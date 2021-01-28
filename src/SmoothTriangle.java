
public class SmoothTriangle extends Shape{
	private Tuple v1;
	private Tuple v2;
	private Tuple v3;
	private Tuple n1;
	private Tuple n2;
	private Tuple n3;
	
	private Tuple e1;
	private Tuple e2;
	
	
	public SmoothTriangle(Tuple v1, Tuple v2, Tuple v3,
						  Tuple n1, Tuple n2, Tuple n3) {
		super();
		
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		
		this.e1 = this.v2.subtractTuples(this.v1);
		this.e2 = this.v3.subtractTuples(this.v1);
	}

	public Tuple getV1() {
		return v1;
	}

	public Tuple getV2() {
		return v2;
	}

	public Tuple getV3() {
		return v3;
	}

	public Tuple getN1() {
		return n1;
	}

	public Tuple getN2() {
		return n2;
	}

	public Tuple getN3() {
		return n3;
	}

	public void setV1(Tuple v1) {
		this.v1 = v1;
	}

	public void setV2(Tuple v2) {
		this.v2 = v2;
	}

	public void setV3(Tuple v3) {
		this.v3 = v3;
	}

	public void setN1(Tuple n1) {
		this.n1 = n1;
	}

	public void setN2(Tuple n2) {
		this.n2 = n2;
	}

	public void setN3(Tuple n3) {
		this.n3 = n3;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	@Override
	public BoundingBox getBounds() {
		BoundingBox box = new BoundingBox(this);
		
		box.addPoint(this.v1);
		box.addPoint(this.v2);
		box.addPoint(this.v3);
		
		return box;
	}

	@Override
	public Intersection[] localIntersect(Ray r) {
		Tuple dirCrossE2 = r.getDirection().crossProduct(this.e2);
		double determinant = this.e1.dotProduct(dirCrossE2);
		
		if(Math.abs(determinant) < Computation.EPSILON) {
			return null;
		}
		
		double f = 1 / determinant;
		
		Tuple v1ToOrigin = r.getOrigin().subtractTuples(this.v1);
		
		double u = f * v1ToOrigin.dotProduct(dirCrossE2);
		
		if(u < 0 || u > 1) {
			return null;
		}
		
		Tuple originCrossE1 = v1ToOrigin.crossProduct(this.e1);
		double v = f * r.getDirection().dotProduct(originCrossE1);
		
		if(v < 0 || (u + v) > 1) {
			return null;
		}
		
		double t = f * this.e2.dotProduct(originCrossE1);
		Intersection[] xs = {new Intersection(t, this, u, v)};
		
		return xs;
	}

	@Override
	public Tuple localNormalAt(Tuple p, Intersection hit) {
		return this.n2.scalarMultiplication(hit.getU()).addTuples(this.n3.scalarMultiplication(hit.getV())).addTuples(this.n1.scalarMultiplication(1 - hit.getU() - hit.getV()));
	}

}
