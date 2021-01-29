import java.util.ArrayList;

public class Cylinder extends Shape{
	
	private double maximum;
	private double minimum;
	private boolean closed;
	
	public Cylinder() {
		super();
		this.maximum = Double.POSITIVE_INFINITY;
		this.minimum = Double.NEGATIVE_INFINITY;
		this.closed = false;
	}
	
	public Cylinder(double minimum, double maximum, boolean closed) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
		this.closed = closed;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public BoundingBox getBounds() {
		Coordinate min;
		Coordinate max;
		
		if(this.maximum == Double.POSITIVE_INFINITY) {
			max = new Coordinate(1, Double.POSITIVE_INFINITY, 1, Coordinate.POINT);
		} else {
			max = new Coordinate(1, this.maximum, 1, Coordinate.POINT);
		}
		
		if(this.minimum == Double.NEGATIVE_INFINITY) {
			min = new Coordinate(-1, Double.NEGATIVE_INFINITY, -1, Coordinate.POINT);
		} else {
			min = new Coordinate(-1, this.minimum, -1, Coordinate.POINT);
		}
		
		BoundingBox box = new BoundingBox(min, max, this);
		
		return box;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public double getMaximum() {
		return maximum;
	}

	public double getMinimum() {
		return minimum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	@Override
	public Intersection[] localIntersect(Ray r) {
		
		double a = r.getDirection().getX() * r.getDirection().getX()
				 + r.getDirection().getZ() * r.getDirection().getZ();
		
		if(Math.abs(a) <= Computation.EPSILON) {
			ArrayList<Intersection> temp = new ArrayList<Intersection>();
			this.intersectCaps(r, temp);
			Intersection[] xsCaps = new Intersection[temp.size()];
			
			for(int i = 0; i < temp.size(); i++) {
				xsCaps[i] = temp.get(i);
			}
			
			return xsCaps;
		}
		
		double b = 2 * r.getOrigin().getX() * r.getDirection().getX()
				 + 2 * r.getOrigin().getZ() * r.getDirection().getZ();
		
		double c = r.getOrigin().getX() * r.getOrigin().getX()
				 + r.getOrigin().getZ() * r.getOrigin().getZ() - 1;
		
		double discriminant = (b * b) - (4 * a * c);
		
		if(discriminant < 0) {
			return null;
		}
		
		double t0 = (-b - Math.sqrt(discriminant)) / (2 * a);
		double t1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		
		if(t0 > t1) {
			double temp = t0;
			t0 = t1;
			t1 = temp;
		}
		
		ArrayList<Intersection> xsTemp = new ArrayList<Intersection>();
		
		double y0 = r.getOrigin().getY() + t0 * r.getDirection().getY();
		
		if(this.minimum < y0 && y0 < this.maximum) {
			xsTemp.add(new Intersection(t0, this));
		}
		
		double y1 = r.getOrigin().getY() + t1 * r.getDirection().getY();
		
		if(this.minimum < y1 && y1 < this.maximum) {
			xsTemp.add(new Intersection(t1, this));
		}
		
		this.intersectCaps(r, xsTemp);
		
		Intersection[] xs = new Intersection[xsTemp.size()];
		
		for(int i = 0; i < xsTemp.size(); i++) {
			xs[i] = xsTemp.get(i);
		}
		
		return xs;
	}

	@Override
	public Coordinate localNormalAt(Coordinate p, Intersection hit) {
		double dist = p.getX() * p.getX() + p.getZ() * p.getZ();
		
		if(dist < 1 && p.getY() >= this.maximum - Computation.EPSILON) {
			return new Coordinate(0, 1, 0, Coordinate.VECTOR);
		} else if(dist < 1 && p.getY() <= this.minimum + Computation.EPSILON) {
			return new Coordinate(0, -1, 0, Coordinate.VECTOR);
		} else {
			return new Coordinate(p.getX(), 0, p.getZ(), Coordinate.POINT);
		}
	}
	
	@Override
	public void printData() {
		System.out.println("closed: " + this.closed);
		System.out.println("minimum: " + this.minimum);
		System.out.println("maximum: " + this.maximum);
	}
	
	private void intersectCaps(Ray r, ArrayList<Intersection> xs) {
		if(this.closed == false || Math.abs(r.getDirection().getY()) <= Computation.EPSILON) {
			return;
		}
		
		double t = (this.minimum - r.getOrigin().getY()) / r.getDirection().getY();
		
		if(this.checkCap(r, t)) {
			xs.add(new Intersection(t, this));
		}
		
		t = (this.maximum - r.getOrigin().getY()) / r.getDirection().getY();
		
		if(this.checkCap(r, t)) {
			xs.add(new Intersection(t, this));
		}
	}
	
	private boolean checkCap(Ray r, double t) {
		double x = r.getOrigin().getX() + t * r.getDirection().getX();
		double z = r.getOrigin().getZ() + t * r.getDirection().getZ();
		
		return (x * x + z * z) <= 1;
	}

}
