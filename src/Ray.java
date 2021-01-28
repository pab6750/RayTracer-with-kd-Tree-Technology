
/**
 * This class encapsulates functionality for ray operations.
 * @author Pablo Scarpati.
 *
 */
public class Ray {
	private Tuple origin;
	private Tuple direction;
	
	public Ray(double oX, double oY, double oZ, double dX, double dY, double dZ) {
		this.origin = new Tuple(oX, oY, oZ, Tuple.POINT);
		this.direction = new Tuple(dX, dY, dZ, Tuple.VECTOR);
	}
	
	public Ray(Tuple origin, Tuple direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
	/**
	 * This function returns a point along the ray at time t.
	 * @param t the 'time'.
	 * @return the Tuple position.
	 */
	public Tuple position(double t) {
		Tuple result = this.origin.addTuples(this.direction.scalarMultiplication(t));
		
		return result;
	}
	
	/**
	 * This function transforms the ray and returns the new transformed ray.
	 * @param m The transformation Matrix.
	 * @return The new Ray.
	 */
	public Ray transform(Matrix m) {
		Ray temp;
		
		Tuple newOrigin = m.tupleMultiplication(this.origin);
		Tuple newDirection = m.tupleMultiplication(this.direction);
		
		temp = new Ray(newOrigin, newDirection);
		
		return temp;
	}
	
	public Tuple getOrigin() {
		return this.origin;
	}
	
	public Tuple getDirection() {
		return this.direction;
	}
	
	public boolean isEqual(Ray r) {
		return this.origin.isEqual(r.getOrigin()) && this.direction.isEqual(r.getDirection());
	}
}
