import java.util.ArrayList;

/**
 * This class performs computations that are useful for the Ray Tracer.
 * @author Pablo Scarpati
 *
 */
public class Effect {
	public static final double EPSILON = 0.00001;
	public static final int RECURSIVE_CUTOFF = 5;
	
	private double t;
	private Shape shape;
	private Coordinate point;
	
	//these two attributes are needed because double variables have trouble with precision here
	private Coordinate overPoint;
	private Coordinate underPoint;
	
	private Coordinate eyeVector;
	private Coordinate normalVector;
	private Coordinate reflectVector;
	private boolean insideShape;
	private double n1;
	private double n2;
	
	public Effect(IntersectionPoint i, Ray r, IntersectionPoint[] xs) {
		this.t = i.getT();
		this.shape = i.getObject();
		this.point = r.position(this.t);
		this.eyeVector = r.getDirection().negateCoordinate();
		IntersectionPoint hit = IntersectionPoint.closestIntersection(xs);
		this.normalVector = shape.normalAt(this.point, hit);
		this.insideShape = this.isInsideShape();
		this.overPoint = this.point.addCoordinate(this.normalVector.scalarMultiplication(EPSILON));
		this.underPoint = this.point.subtractCoordinate(this.normalVector.scalarMultiplication(EPSILON));
		this.reflectVector = r.getDirection().reflect(this.normalVector);
		
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
	
	public Colour reflectedColour(Scene scene, int remaining) {
		if(remaining <= 0) {
			return Colour.BLACK;
		}
		
		if(this.shape.getMaterial().getReflective() == 0) {
			return Colour.BLACK;
		}
		
		Ray reflectedRay = new Ray(this.overPoint, this.reflectVector);
		Colour colour = scene.colourAtPixel(reflectedRay, remaining - 1);
		
		return colour.scalarMultiplication(this.shape.getMaterial().getReflective());
	}
	
	public Colour refractedColour(Scene scene, int remaining) {
		if(remaining <= 0) {
			return Colour.BLACK;
		}
		
		if(this.shape.getMaterial().getTransparency() <= EPSILON) {
			return Colour.BLACK;
		}
		
		double nRatio = this.n1 / this.n2;
		double cosI = this.eyeVector.dotProduct(this.normalVector);
		double sin2T = nRatio * nRatio * (1 - Math.pow(cosI, 2));
		
		if(sin2T > 1) {
			return Colour.BLACK;
		}
		
		double cosT = Math.sqrt(1 - sin2T);
		Coordinate direction = this.normalVector.scalarMultiplication((nRatio * cosI) - cosT).subtractCoordinate(this.eyeVector.scalarMultiplication(nRatio));
		
		Ray refractedRay = new Ray(this.underPoint, direction);
		
		Colour colour = scene.colourAtPixel(refractedRay, remaining - 1).scalarMultiplication(this.shape.getMaterial().getTransparency());
		
		return colour;
	}
	
	public Coordinate getReflectVector() {
		return reflectVector;
	}

	public void setReflectVector(Coordinate reflectVector) {
		this.reflectVector = reflectVector;
	}

	public Coordinate getOverPoint() {
		return overPoint;
	}

	public void setOverPoint(Coordinate overPoint) {
		this.overPoint = overPoint;
	}

	/**
	 * 
	 * @param scene
	 * @param remaining
	 * @return
	 */
	public Colour finalColour(Scene scene, int remaining) {
		//is the point in shadows
		boolean shadowed = scene.isShadowed(this.overPoint);
		
		//the lighting of the point
		Colour surface = this.shape.lighting(scene.getLight(), 
											 this.overPoint, 
											 this.eyeVector, 
											 this.normalVector,
											 shadowed);
		
		//reflected and refracted colours
		Colour reflected = this.reflectedColour(scene, remaining);
		Colour refracted = this.refractedColour(scene, remaining);
		
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
		double cos = this.eyeVector.dotProduct(this.normalVector);
		
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
	public boolean isInsideShape() {
		double value = this.eyeVector.dotProduct(this.normalVector);
		
		if(value < 0) {
			this.normalVector = this.normalVector.negateCoordinate();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getInsideShape() {
		return this.insideShape;
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

	public Coordinate getEyeVector() {
		return eyeVector;
	}

	public Coordinate getNormalVector() {
		return normalVector;
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

	public void setEyevVector(Coordinate eyev) {
		this.eyeVector = eyev;
	}

	public void setNormalVector(Coordinate normalv) {
		this.normalVector = normalv;
	}
}
