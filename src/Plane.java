
public class Plane extends Shape{
	private Tuple origin;
	
	public Plane() {
		super();
		this.origin = new Tuple(0, 0, 0, Tuple.POINT);
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public BoundingBox getBounds() {
		Tuple min = new Tuple(Double.NEGATIVE_INFINITY, 0, Double.NEGATIVE_INFINITY, Tuple.POINT);
		Tuple max = new Tuple(Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, Tuple.POINT);
		BoundingBox box = new BoundingBox(min, max, this);
		
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
	public Tuple localNormalAt(Tuple p, Intersection hit) {
		return new Tuple(0, 1, 0, Tuple.POINT);
	}
	
	@Override
	public void printData() {
		this.origin.printData();
	}

	public Tuple getOrigin() {
		return origin;
	}

	public void setOrigin(Tuple origin) {
		this.origin = origin;
	}
}
