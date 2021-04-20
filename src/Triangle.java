/*
 * This class was inspired by the architecture proposed by Jamis Buck in his book: The Ray Tracer Challenge.
 * 
 * Reference at : ‘The Ray Tracer Challenge’. https://pragprog.com/titles/jbtracer/the-ray-tracer-challenge (accessed Apr. 15, 2021).
 */



public class Triangle extends Shape{
	
	private Coordinate v1;
	private Coordinate v2;
	private Coordinate v3;
	private Coordinate e1;
	private Coordinate e2;
	private Coordinate normal;
	
	public Triangle(Coordinate v1, Coordinate v2, Coordinate v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		
		this.e1 = this.v2.subtractCoordinate(this.v1);
		this.e2 = this.v3.subtractCoordinate(this.v1);
		this.normal = this.e2.crossProduct(this.e1).normalize();
	}
	
	public void setV1(Coordinate v1) {
		this.v1 = v1;
	}

	public void setV2(Coordinate v2) {
		this.v2 = v2;
	}

	public void setV3(Coordinate v3) {
		this.v3 = v3;
	}

	public Coordinate getV1() {
		return v1;
	}

	public Coordinate getV2() {
		return v2;
	}

	public Coordinate getV3() {
		return v3;
	}

	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public AABB getAABB() {
		AABB box = new AABB(this);
		
		box.addPoint(this.v1);
		box.addPoint(this.v2);
		box.addPoint(this.v3);
		
		return box;
	}

	/**
	 * This algorithm is used to determine ray-triangle intersections.
	 * Reference at: Möller, T. and Trumbore, B. (1997) 'Fast, minimum storage ray-triangle intersection', Journal of Graphics Tools, 2(1), pp. 21–28. doi: 10.1080/10867651.1997.10487468.
	 */
	@Override
	public IntersectionPoint[] localIntersect(Ray r) {
		Statistics.incrementTriangleIntersectionCount();
		
		Coordinate dirCrossE2 = r.getDirection().crossProduct(this.e2);
		double determinant = this.e1.dotProduct(dirCrossE2);
		
		if(Math.abs(determinant) < EPSILON) {
			return null;
		}
		
		double f = 1 / determinant;
		
		Coordinate v1ToOrigin = r.getOrigin().subtractCoordinate(this.v1);
		
		double u = f * v1ToOrigin.dotProduct(dirCrossE2);
		
		if(u < 0 || u > 1) {
			return null;
		}
		
		Coordinate originCrossE1 = v1ToOrigin.crossProduct(this.e1);
		double v = f * r.getDirection().dotProduct(originCrossE1);
		
		if(v < 0 || (u + v) > 1) {
			return null;
		}
		
		double t = f * this.e2.dotProduct(originCrossE1);
		IntersectionPoint[] xs = {new IntersectionPoint(t, this)};
		
		return xs;
	}

	@Override
	public Coordinate localNormalAt(Coordinate p, IntersectionPoint hit) {
		return this.normal;
	}

	@Override
	public void printData() {
		this.v1.printData();
		this.v2.printData();
		this.v3.printData();
	}
}
