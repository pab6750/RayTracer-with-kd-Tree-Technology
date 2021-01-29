
/**
 * This class encapsulates functionality for ray operations.
 * @author Pablo Scarpati.
 *
 */
public class Ray {
	private Coordinate origin;
	private Coordinate direction;
	
	public Ray(double oX, double oY, double oZ, double dX, double dY, double dZ) {
		this.origin = new Coordinate(oX, oY, oZ, Coordinate.POINT);
		this.direction = new Coordinate(dX, dY, dZ, Coordinate.VECTOR);
	}
	
	public Ray(Coordinate origin, Coordinate direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
	/**
	 * This function returns a point along the ray at time t.
	 * @param t the 'time'.
	 * @return the Tuple position.
	 */
	public Coordinate position(double t) {
		Coordinate result = this.origin.addCoordinate(this.direction.scalarMultiplication(t));
		
		return result;
	}
	
	/**
	 * This function transforms the ray and returns the new transformed ray.
	 * @param m The transformation Matrix.
	 * @return The new Ray.
	 */
	public Ray transform(Matrix m) {
		Ray temp;
		
		Coordinate newOrigin = m.coordinateMultiplication(this.origin);
		Coordinate newDirection = m.coordinateMultiplication(this.direction);
		
		temp = new Ray(newOrigin, newDirection);
		
		return temp;
	}
	
	public Coordinate getOrigin() {
		return this.origin;
	}
	
	public Coordinate getDirection() {
		return this.direction;
	}
	
	public boolean isEqual(Ray r) {
		return this.origin.isEqual(r.getOrigin()) && this.direction.isEqual(r.getDirection());
	}
}
