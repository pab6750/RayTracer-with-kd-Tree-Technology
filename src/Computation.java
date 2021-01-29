import java.util.ArrayList;

/**
 * This class performs computations that are useful for the Ray Tracer.
 * @author Pablo Scarpati
 *
 */
public class Computation {
	public static final double EPSILON = 0.00001;
	public static final int RECURSIVE_CUTOFF = 5;
	
	private double t;
	private Shape shape;
	private Coordinate point;
	
	//these two attributes are needed because double variables have trouble with precision here
	private Coordinate overPoint;
	private Coordinate underPoint;
	
	private Coordinate eyev;
	private Coordinate normalv;
	private Coordinate reflectv;
	private boolean inside;
	private double n1;
	private double n2;
	
	public Computation(Intersection i, Ray r, Intersection[] xs) {
		this.t = i.getT();
		this.shape = i.getObject();
		this.point = r.position(this.t);
		this.eyev = r.getDirection().negateCoordinate();
		Intersection hit = Intersection.hit(xs);
		this.normalv = shape.normalAt(this.point, hit);
		this.inside = this.isInside();
		this.overPoint = this.point.addCoordinate(this.normalv.scalarMultiplication(EPSILON));
		this.underPoint = this.point.subtractCoordinate(this.normalv.scalarMultiplication(EPSILON));
		this.reflectv = r.getDirection().reflect(this.normalv);
		
		//transparency intersections algorithm
		if(xs != null) {
			ArrayList<Shape> container = new ArrayList<Shape>();
			
			for(int index = 0; index < xs.length; index++) {
				
				if(i.equals(xs[index])) {
					if(container.isEmpty()) {
						this.n1 = Material.VACUUM;
					} else {
						this.n1 = container.get(container.size() - 1).getMaterial().getRefractiveIndex();
					}
				}
				
				if(container.contains(xs[index].getObject())) {
					container.remove(xs[index].getObject());
				} else {
					container.add(xs[index].getObject());
				}
				
				if(i == xs[index]) {
					if(container.isEmpty()) {
						this.n2 = Material.VACUUM;
					} else {
						this.n2 = container.get(container.size() - 1).getMaterial().getRefractiveIndex();
					}
					
					break;
				}
			}
		}
	}
	
	/**
	 * Compares two doubles.
	 * @param d1 first number.
	 * @param d2 second number.
	 * @return returns true if d1 and d2 are equal.
	 */
	public static boolean compareDouble(double d1, double d2) {
		return (Math.abs(d1) - Math.abs(d2) < EPSILON);
	}
	
	public double getN1() {
		return n1;
	}

	public double getN2() {
		return n2;
	}
	
	public Coordinate getUnderPoint() {
		return this.underPoint;
	}
	
	public Colour reflectedColour(World world, int remaining) {
		if(remaining <= 0) {
			return Colour.BLACK;
		}
		
		if(this.shape.getMaterial().getReflective() == 0) {
			return Colour.BLACK;
		}
		
		Ray reflectedRay = new Ray(this.overPoint, this.reflectv);
		Colour colour = world.colourAt(reflectedRay, remaining - 1);
		
		return colour.scalarMultiplication(this.shape.getMaterial().getReflective());
	}
	
	public Colour refractedColour(World world, int remaining) {
		if(remaining <= 0) {
			return Colour.BLACK;
		}
		
		if(this.shape.getMaterial().getTransparency() <= EPSILON) {
			return Colour.BLACK;
		}
		
		double nRatio = this.n1 / this.n2;
		double cosI = this.eyev.dotProduct(this.normalv);
		double sin2T = nRatio * nRatio * (1 - Math.pow(cosI, 2));
		
		if(sin2T > 1) {
			return Colour.BLACK;
		}
		
		double cosT = Math.sqrt(1 - sin2T);
		Coordinate direction = this.normalv.scalarMultiplication((nRatio * cosI) - cosT).subtractCoordinate(this.eyev.scalarMultiplication(nRatio));
		
		Ray refractedRay = new Ray(this.underPoint, direction);
		
		Colour colour = world.colourAt(refractedRay, remaining - 1).scalarMultiplication(this.shape.getMaterial().getTransparency());
		
		return colour;
	}
	
	public Coordinate getReflectv() {
		return reflectv;
	}

	public void setReflectv(Coordinate reflectv) {
		this.reflectv = reflectv;
	}

	public Coordinate getOverPoint() {
		return overPoint;
	}

	public void setOverPoint(Coordinate overPoint) {
		this.overPoint = overPoint;
	}

	/**
	 * 
	 * @param world
	 * @param remaining
	 * @return
	 */
	public Colour shadeHit(World world, int remaining) {
		//is the point in shadows
		boolean shadowed = world.isShadowed(this.overPoint);
		
		//the lighting of the point
		Colour surface = this.shape.lighting(world.getLight(), 
											 this.overPoint, 
											 this.eyev, 
											 this.normalv,
											 shadowed);
		
		//reflected and refracted colours
		Colour reflected = this.reflectedColour(world, remaining);
		Colour refracted = this.refractedColour(world, remaining);
		
		Material m = this.shape.getMaterial();
		
		//case where there is total internal reflection
		if(m.getReflective() > 0 && m.getTransparency() > 0) {
			double reflectance = this.schlick();
			
			Colour schlickReflected = reflected.scalarMultiplication(reflectance);
			Colour schlickRefracted = refracted.scalarMultiplication(1 - reflectance);
			
			return surface.addColours(schlickReflected).addColours(schlickRefracted);
		} else {
			return surface.addColours(reflected).addColours(refracted);
		}
	}
	
	/**
	 * This method produces the reflectance in the case of Total Internal Reflection
	 * @return the reflectance
	 */
	public double schlick() {
		double cos = this.eyev.dotProduct(this.normalv);
		
		if(this.n1 > this.n2) {
			double n = this.n1 / this.n2;
			double sin2T = Math.pow(n, 2) * (1 - Math.pow(cos, 2));
			
			if(sin2T > 1) {
				return 1;
			}
			
			double cosT = Math.sqrt(1 - sin2T);
			
			cos = cosT;
		}
		
		double r0 = Math.pow(((this.n1 - this.n2) / (this.n1 + this.n2)), 2);
		return r0 + (1 - r0) * Math.pow((1 - cos), 5);
	}
	
	/**
	 * This methods determines whether the point is inside a shape (?).
	 * @return Returns true if the point is inside (?).
	 */
	public boolean isInside() {
		double value = this.eyev.dotProduct(this.normalv);
		
		if(value < 0) {
			this.normalv = this.normalv.negateCoordinate();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getInside() {
		return this.inside;
	}

	public double getT() {
		return t;
	}

	public Shape getShape() {
		return shape;
	}

	public Coordinate getPoint() {
		return point;
	}

	public Coordinate getEyev() {
		return eyev;
	}

	public Coordinate getNormalv() {
		return normalv;
	}

	public void setT(double t) {
		this.t = t;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void setPoint(Coordinate point) {
		this.point = point;
	}

	public void setEyev(Coordinate eyev) {
		this.eyev = eyev;
	}

	public void setNormalv(Coordinate normalv) {
		this.normalv = normalv;
	}
}
