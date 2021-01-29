import java.lang.Math;

/**
 * this class represents Points and Vectors in the scene.
 * @author Pablo Scarpati
 *
 */
public class Coordinate {
	public static final int VECTOR = 0;
	public static final int POINT  = 1;
	
	protected double x;
	protected double y;
	protected double z;
	protected int type;
	
	public Coordinate(double n) {
		this.x = n;
		this.y = n;
		this.z = n;
		this.type = POINT;
	}
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = POINT;
	}
	
	public Coordinate(double x, double y, double z, int type) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
	}
	
	/**
	 * Compares two tuples.
	 * @param t the other tuple.
	 * @return true if equal.
	 */
	public boolean equals(Coordinate t){

        return Computation.compareDouble(this.x, t.x) &&
        	   Computation.compareDouble(this.y, t.y) &&
        	   Computation.compareDouble(this.z, t.z) &&
               this.type == t.type;
    }
	
	/**
	 * performs the addition operation on a tuple.
	 * if you add a point and a vector, it's like to follow that vector from that point.
	 * @param t the other tuple.
	 * @return the new tuple.
	 */
	public Coordinate addCoordinate(Coordinate t) {
		double newX = this.x + t.x;
		double newY = this.y + t.y;
		double newZ = this.z + t.z;
		int newType = this.type + t.type;
		
		return new Coordinate(newX, newY, newZ, newType);
	}
	
	/**
	 * performs the subtraction operation on a tuple.
	 * @param t the other tuple.
	 * @return the new tuple.
	 */
	public Coordinate subtractCoordinate(Coordinate t) {
		double newX = this.x - t.x;
		double newY = this.y - t.y;
		double newZ = this.z - t.z;
		int newType = this.type - t.type;
		
		return new Coordinate(newX, newY, newZ, newType);
	}
	
	/**
	 * negates the tuple.
	 * @return the negated tuple.
	 */
	public Coordinate negateCoordinate() {
		double newX = this.x * -1;
		double newY = this.y * -1;
		double newZ = this.z * -1;
		
		return new Coordinate(newX, newY, newZ, this.type);
	}
	
	/**
	 * Multiplies all components of the tuple by a scalar.
	 * @param scalar the scalar.
	 * @return the new tuple.
	 */
	public Coordinate scalarMultiplication(double scalar) {
		double newX = this.x * scalar;
		double newY = this.y * scalar;
		double newZ = this.z * scalar;
		
		return new Coordinate(newX, newY, newZ, this.type);
	}
	
	/**
	 * Divides all components of the tuple by a scalar.
	 * @param scalar the scalar.
	 * @return the new tuple.
	 */
	public Coordinate scalarDivision(double scalar) {
		double divisionFactor = 1 / scalar;
		
		double newX = this.x * divisionFactor;
		double newY = this.y * divisionFactor;
		double newZ = this.z * divisionFactor;
		
		return new Coordinate(newX, newY, newZ, this.type);
	}
	
	/**
	 * The magnitude is the length of a vector.
	 * @return the magnitude.
	 */
	double magnitude() {
		return Math.sqrt(Math.pow(this.x, 2) +
						 Math.pow(this.y, 2) +
						 Math.pow(this.z, 2));
	}
	
	/**
	 * it converts the current vector into a unit vector.
	 * @return the unit vector.
	 */
	public Coordinate normalize() {
		
		double inverse = 1 / this.magnitude();
		
		double xpos = this.x * inverse;
		double ypos = this.y * inverse;
		double zpos = this.z * inverse;
		
		return new Coordinate(xpos, ypos, zpos, Coordinate.VECTOR);
	}
	
	/**
	 * it takes two vectors and returns a scalar value.
	 * the smaller the angle between the vectors, the larger the dot product.
	 * @param t the other vector.
	 * @return the scalar value.
	 */
	public double dotProduct(Coordinate t) {
		return this.x * t.x +
	           this.y * t.y +
	           this.z * t.z +
	           this.type * t.type;
	}
	
	/**
	 * it takes two vectors and produces a vector.
	 * the result is a vector perpendicular to both input vectors.
	 * order matters in this function.
	 * @param t the other vector.
	 * @return the new vector.
	 */
	public Coordinate crossProduct(Coordinate t) {
		return new Coordinate(this.y * t.z - this.z * t.y,
                         this.z * t.x - this.x * t.z,
                         this.x * t.y - this.y * t.x,
                         VECTOR);
	}
	
	/**
	 * prints data relative to this object.
	 */
	public void printData() {
		System.out.println("x: " + this.x);
		System.out.println("y: " + this.y);
		System.out.println("z: " + this.z);
		
		String messageType = (this.type == VECTOR) ? "type: VECTOR" : "type: POINT";
		
		System.out.println(messageType);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double getType() {
		return this.type;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * it reflects a vector around a normal.
	 * @param normal the normal.
	 * @return the reflected vector.
	 */
	public Coordinate reflect(Coordinate normal) {
		double scalar = 2 * this.dotProduct(normal);
		return this.subtractCoordinate(normal.scalarMultiplication(scalar));
	}
	
	/**
	 * This method compares the equality of two tuples.
	 * @param t the other tuple.
	 * @return true if the tuples are equal.
	 */
	public boolean isEqual(Coordinate t) {
		return Computation.compareDouble(this.getX(), t.getX()) &&
			   Computation.compareDouble(this.getY(), t.getY()) &&
			   Computation.compareDouble(this.getZ(), t.getZ()) &&
			   this.getType() == t.getType();
	}
}
