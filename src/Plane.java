
public class Plane extends Shape{
	private Coordinate origin;
	
	public Plane() {
		super();
		this.origin = new Coordinate(0, 0, 0, Coordinate.POINT);
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public AABB getBounds() {
		Coordinate min = new Coordinate(Double.NEGATIVE_INFINITY, 0, Double.NEGATIVE_INFINITY, Coordinate.POINT);
		Coordinate max = new Coordinate(Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, Coordinate.POINT);
		AABB box = new AABB(min, max, this);
		
		return box;
	}
	
	@Override
	public Intersection[] localIntersect(Ray r) {
		if(Math.abs(r.getDirection().getY()) < Computation.EPSILON) {
			return null;
		}
		
		double t = -r.getOrigin().getY() / r.getDirection().getY();
		Intersection[] result = {new Intersection(t, this)};
		return result;
	}
	
	@Override
	public Coordinate localNormalAt(Coordinate p, Intersection hit) {
		return new Coordinate(0, 1, 0, Coordinate.POINT);
	}
	
	@Override
	public void printData() {
		this.origin.printData();
	}

	public Coordinate getOrigin() {
		return origin;
	}

	public void setOrigin(Coordinate origin) {
		this.origin = origin;
	}
}
