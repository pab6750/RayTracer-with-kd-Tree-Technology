import java.util.ArrayList;

public class Cone extends Shape{
	private double minimum;
	private double maximum;
	private boolean closed;
	
	public Cone() {
		super();
		this.closed = false;
		this.minimum = Double.NEGATIVE_INFINITY;
		this.maximum = Double.POSITIVE_INFINITY;
	}
	
	public Cone(double minimum, double maximum, boolean closed) {
		super();
		this.closed = closed;
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public AABB getBounds() {
		double a = Math.abs(this.minimum);
		double b = Math.abs(this.maximum);
		double limit = Math.max(a, b);
		
		Coordinate min = new Coordinate(-limit, this.minimum, -limit, Coordinate.POINT);
		Coordinate max = new Coordinate( limit, this.maximum,  limit, Coordinate.POINT);
		
		AABB box = new AABB(min, max, null);
		
		return box;
	}

	public double getMinimum() {
		return minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	@Override
	public IntersectionPoint[] localIntersect(Ray r) {
		double a = r.getDirection().getX() * r.getDirection().getX()
				 - r.getDirection().getY() * r.getDirection().getY()
				 + r.getDirection().getZ() * r.getDirection().getZ();
		
		
		double b = 2 * r.getOrigin().getX() * r.getDirection().getX()
				 - 2 * r.getOrigin().getY() * r.getDirection().getY()
				 + 2 * r.getOrigin().getZ() * r.getDirection().getZ();
		
		double c = r.getOrigin().getX() * r.getOrigin().getX()
				 - r.getOrigin().getY() * r.getOrigin().getY()
				 + r.getOrigin().getZ() * r.getOrigin().getZ();
		
		if(Math.abs(a) <= EPSILON && Math.abs(b) <= EPSILON) {
			return null;
		}
		
		if(Math.abs(a) <= EPSILON) {
			IntersectionPoint[] xs = new IntersectionPoint[1];
			
			xs[0] = new IntersectionPoint(-c / (2 * b), this);
			
			return xs;
		}
		
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
		
		ArrayList<IntersectionPoint> xsTemp = new ArrayList<IntersectionPoint>();
		
		double y0 = r.getOrigin().getY() + t0 * r.getDirection().getY();
		
		if(this.minimum < y0 && y0 < this.maximum) {
			xsTemp.add(new IntersectionPoint(t0, this));
		}
		
		double y1 = r.getOrigin().getY() + t1 * r.getDirection().getY();
		
		if(this.minimum < y1 && y1 < this.maximum) {
			xsTemp.add(new IntersectionPoint(t1, this));
		}
		
		this.intersectCaps(r, xsTemp);
		
		IntersectionPoint[] xs = new IntersectionPoint[xsTemp.size()];
		
		for(int i = 0; i < xsTemp.size(); i++) {
			xs[i] = xsTemp.get(i);
		}
		
		return xs;
	}

	@Override
	public Coordinate localNormalAt(Coordinate p, IntersectionPoint hit) {
		double dist = p.getX() * p.getX() + p.getZ() * p.getZ();
		double y = Math.sqrt(dist);
		
		//???
		if(y > 0 && p.getY() > 0) {
			y *= -1;
		}
		
		if(dist < 1 && p.getY() >= this.maximum - EPSILON) {
			return new Coordinate(0, 1, 0, Coordinate.VECTOR);
		} else if(dist < 1 && p.getY() <= this.minimum + EPSILON) {
			return new Coordinate(0, -1, 0, Coordinate.VECTOR);
		} else {
			return new Coordinate(p.getX(), y, p.getZ(), Coordinate.VECTOR);
		}
	}
	
	@Override
	public void printData() {
		System.out.println("closed: " + this.closed);
		System.out.println("minimum: " + this.minimum);
		System.out.println("maximum: " + this.maximum);
	}
	
	private void intersectCaps(Ray r, ArrayList<IntersectionPoint> xs) {
		if(!this.closed || Math.abs(r.getDirection().getY()) <= EPSILON) {
			return;
		}
		
		double t = (this.minimum - r.getOrigin().getY()) / r.getDirection().getY();
		
		if(this.checkCap(r, t, this.minimum)) {
			xs.add(new IntersectionPoint(t, this));
		}
		
		t = (this.maximum - r.getOrigin().getY()) / r.getDirection().getY();
		
		if(this.checkCap(r, t, this.maximum)) {
			xs.add(new IntersectionPoint(t, this));
		}
	}
	
	private boolean checkCap(Ray r, double t, double y) {
		double x = r.getOrigin().getX() + t * r.getDirection().getX();
		double z = r.getOrigin().getZ() + t * r.getDirection().getZ();
		
		return (x * x + z * z) <= y * y;
	}

}
