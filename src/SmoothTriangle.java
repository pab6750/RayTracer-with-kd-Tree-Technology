
public class SmoothTriangle extends Shape{
	private Coordinate v1;
	private Coordinate v2;
	private Coordinate v3;
	private Coordinate n1;
	private Coordinate n2;
	private Coordinate n3;
	
	private Coordinate e1;
	private Coordinate e2;
	
	
	public SmoothTriangle(Coordinate v1, Coordinate v2, Coordinate v3,
			              Coordinate n1, Coordinate n2, Coordinate n3) {
		super();
		
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		
		this.e1 = this.v2.subtractCoordinate(this.v1);
		this.e2 = this.v3.subtractCoordinate(this.v1);
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

	public Coordinate getN1() {
		return n1;
	}

	public Coordinate getN2() {
		return n2;
	}

	public Coordinate getN3() {
		return n3;
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

	public void setN1(Coordinate n1) {
		this.n1 = n1;
	}

	public void setN2(Coordinate n2) {
		this.n2 = n2;
	}

	public void setN3(Coordinate n3) {
		this.n3 = n3;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public AABB getBounds() {
		AABB box = new AABB(this);
		
		box.addPoint(this.v1);
		box.addPoint(this.v2);
		box.addPoint(this.v3);
		
		return box;
	}

	@Override
	public IntersectionPoint[] localIntersect(Ray r) {
		Coordinate dirCrossE2 = r.getDirection().crossProduct(this.e2);
		double determinant = this.e1.dotProduct(dirCrossE2);
		
		if(Math.abs(determinant) < Computation.EPSILON) {
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
		IntersectionPoint[] xs = {new IntersectionPoint(t, this, u, v)};
		
		return xs;
	}

	@Override
	public Coordinate localNormalAt(Coordinate p, IntersectionPoint hit) {
		return this.n2.scalarMultiplication(hit.getU())
				      .addCoordinate(this.n3.scalarMultiplication(hit.getV()))
				      .addCoordinate(this.n1.scalarMultiplication(1 - hit.getU() - hit.getV()));
	}

}
