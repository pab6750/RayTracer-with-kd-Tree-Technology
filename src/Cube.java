
public class Cube extends Shape{
	
	public Cube() {
		super();
	}
	
	@Override
	public AABB getAABB() {
		Coordinate min = new Coordinate(-1, -1, -1, Coordinate.POINT);
		Coordinate max = new Coordinate(1, 1, 1, Coordinate.POINT);
		AABB box = new AABB(min, max, null);
		
		return box;
	}

	/**
	 * This method is used to intersect the cube with a ray in local space.
	 * More information at: https://www.scratchapixel.com/lessons/3d-basic-rendering/minimal-ray-tracer-rendering-simple-shapes/ray-box-intersection
	 */
	@Override
	public IntersectionPoint[] localIntersect(Ray r) {
		double[] xvalues = this.checkAxis(r.getOrigin().getX(), r.getDirection().getX());
		double[] yvalues = this.checkAxis(r.getOrigin().getY(), r.getDirection().getY());
		double[] zvalues = this.checkAxis(r.getOrigin().getZ(), r.getDirection().getZ());
		
		double xtmin = xvalues[0];
		double xtmax = xvalues[1];
		double ytmin = yvalues[0];
		double ytmax = yvalues[1];
		double ztmin = zvalues[0];
		double ztmax = zvalues[1];
		
		double tempMin = Math.max(xtmin, ytmin);
		double tmin = Math.max(tempMin, ztmin);
		
		double tempMax = Math.min(xtmax, ytmax);
		double tmax = Math.min(tempMax, ztmax);
		
		if(tmin > tmax) {
			return null;
		}
		
		IntersectionPoint[] xs = {new IntersectionPoint(tmin, this), new IntersectionPoint(tmax, this)};
		
		return xs;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}

	@Override
	public Coordinate localNormalAt(Coordinate p, IntersectionPoint hit) {
		double temp = Math.max(Math.abs(p.getX()), Math.abs(p.getY()));
		double maxc = Math.max(temp, Math.abs(p.getZ()));
		
		if(maxc == Math.abs(p.getX())) {
			return new Coordinate(p.getX(), 0, 0, Coordinate.VECTOR);
		} else if(maxc == Math.abs(p.getY())) {
			return new Coordinate(0, p.getY(), 0, Coordinate.VECTOR);
		}
		
		return new Coordinate(0, 0, p.getZ(), Coordinate.VECTOR);
	}
	
	@Override
	public void printData() {
		
	}
	
	private double[] checkAxis(double origin, double direction) {
		double tminNumerator = (-1 - origin);
		double tmaxNumerator = (1 - origin);
		
		double tmin;
		double tmax;
		
		if(Math.abs(direction) >= EPSILON) {
			tmin = tminNumerator / direction;
			tmax = tmaxNumerator / direction;
		} else {
			tmin = tminNumerator * Double.POSITIVE_INFINITY;
			tmax = tmaxNumerator * Double.POSITIVE_INFINITY;
		}
		
		if(tmin > tmax) {
			double temp = tmin;
			tmin = tmax;
			tmax = temp;
		}
		double[] result = {tmin, tmax};
		
		return result;
	}

}
