import java.lang.Math;

/**
 * This class encapulates functionality to do matrix operations.
 * @author Pablo Scarpati.
 *
 */
public class Matrix {
	private double matrix[][];
	private int h;
	private int w;
	
	public Matrix(int n) {
		this.h = n;
		this.w = n;
		
		this.matrix = new double[h][w];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				this.matrix[i][j] = 0;
			}
		}
	}
	
	public Matrix(int h, int w) {
		this.h = h;
		this.w = w;
		
		this.matrix = new double[h][w];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				this.matrix[i][j] = 0;
			}
		}
	}
	
	public boolean equals(Matrix m) {
		boolean result = true;
		
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; h < this.w; j++) {
				if(this.matrix[i][j] != m.matrix[i][j]) {
					result = false;
				}
			}
		}
		
		return result;
	}
	
	public void setMatrix(double[][] m) {
		this.matrix = m;
	}
	
	/**
	 * Multiplies 2 matrices together.
	 * @param m the other matrix.
	 * @return the resulting matrix.
	 */
	public Matrix matrixMultiplication(Matrix m){
		double[][] result = new double[this.h][this.w];
		
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.w; j++) {
				double sum = 0;
				
				for(int k = 0; k < this.h; k++) {
					sum += this.matrix[i][k] * m.matrix[k][j];
				}
				
				result[i][j] = sum;
			}
		}
		
		Matrix multiplicationResult = new Matrix(this.h);
		multiplicationResult.setMatrix(result);
		
		return multiplicationResult;
	}
	
	/**
	 * Multiplies a Matrix with a Tuple.
	 * @param t the Tuple.
	 * @return the resulting Tuple.
	 */
	public Coordinate coordinateMultiplication(Coordinate t) {
		double results[] = {0, 0, 0, 0};
		double values[] = {t.getX(), t.getY(), t.getZ(), t.getType()};
		
		for(int i = 0; i < this.h; i++) {
			double sum = 0;
			
			for(int j = 0; j < this.w; j++) {
				sum += this.matrix[i][j] * values[j];
			}
			
			results[i] = sum;
		}
		
		Coordinate newCoordinate = new Coordinate(results[0], results[1], results[2], (int)results[3]);
		
		return newCoordinate;
	}
	
	/**
	 * Sets the current matrix to the identity Matrix.
	 */
	public void setIdentityMatrix() {
		double identityMatrix[][] = {{1, 0, 0, 0},
					   				 {0, 1, 0, 0},
					   				 {0, 0, 1, 0},
					   				 {0, 0, 0, 1}};
		
		this.setMatrix(identityMatrix);
	}
	
	/**
	 * Turns the rows into columns and the columns to rows.
	 * @return The resulting Matrix.
	 */
	public Matrix transposition(){
		double[][] result = new double[h][w];
		
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.w; j++) {
				result[j][i] = this.matrix[i][j];
			}
		}
		
		Matrix transposedMatrix = new Matrix(h);
		transposedMatrix.setMatrix(result);
		
		return transposedMatrix;
	}
	
	/**
	 * Inverts a Matrix, like inverting a number.
	 * @return The inverted Matrix.
	 */
	public Matrix invert() {
		if(this.isInvertible()) {
			Matrix cofactorMatrix = this.createCofactorMatrix();
			Matrix transposedMatrix = cofactorMatrix.transposition();
			
			double originalDeterminant = this.getDeterminant();
			
			double[][] transposedGrid = transposedMatrix.getMatrix();
			double[][] invertedGrid = new double[this.h][this.w];
			
			for(int i = 0; i < this.h; i++) {
				for(int j = 0; j < this.w; j++) {
					invertedGrid[i][j] = transposedGrid[i][j] / originalDeterminant;
				}
			}
			
			Matrix invertedMatrix = new Matrix(this.h);
			invertedMatrix.setMatrix(invertedGrid);
			
			return invertedMatrix;
		} else {
			return null;
		}
	}
	
	/**
	 * Removes a row and a column from the matrix.
	 * @param row The row to be deleted.
	 * @param col The column to be deleted.
	 * @return The resulting matrix.
	 */
	public Matrix getSubmatrix(int row, int col) {
		int newHeight = this.getHeight() - 1;
		int newWidth = this.getWidth() - 1;
		
		double[][] result = new double[newHeight][newWidth];
		double[][] originalMatrix = this.getMatrix();
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.w; j++) {
				if(i != row && j != col) {
					result[x][y] = originalMatrix[i][j];
					y++;
				}
			}
			
			if(y == newWidth) {
				x++;
				y = 0;
			}
		}
		Matrix resultMatrix = new Matrix(newHeight, newWidth);
		resultMatrix.setMatrix(result);
		
		return resultMatrix;
	}
	
	/**
	 * Get the determinant of a 2x2 grid.
	 * @param m The grid.
	 * @return The determinant.
	 */
	public double getDeterminant2x2(double[][] m) {
		double a = m[0][0];
		double b = m[0][1];
		double c = m[1][0];
		double d = m[1][1];
		
		return (a * d) - (b * c);
	}
	
	/**
	 * The minor of an element at row i and column j is the determinant of the
	 * submatrix at (i,j).
	 * @param row
	 * @param col
	 * @return The resulting minor.
	 */
	public double getMinor(int row, int col) {
		Matrix submatrix = this.getSubmatrix(row, col);
		
		return this.getDeterminant2x2(submatrix.getMatrix());
	}
	
	public double getCofactor(int row, int col) {
		if(this.h == 3) {
			double minor = this.getMinor(row, col);
			
			return ((row + col) % 2 == 0) ? minor : minor * -1;
		} else if(this.h == 4) {
			Matrix submatrix = this.getSubmatrix(row, col);
			
			double minor = submatrix.getDeterminant();
			
			return ((row + col) % 2 == 0) ? minor : minor * -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Get the determinant of the matrix.
	 * @return The determinant.
	 */
	public double getDeterminant() {
		if(this.h == 2) {
			return this.getDeterminant2x2(this.matrix);
		} else if(this.h == 3){
			double[] firstRow = this.matrix[0];
			
			double sum = 0;
			
			for(int i = 0; i < this.w; i++) {
				sum += firstRow[i] * this.getCofactor(0, i);
			}
			
			return sum;
		} else if(this.h == 4) {
			double[] firstRow = this.matrix[0];
			
			double sum = 0;
			
			for(int i = 0; i < this.w; i++) {
				Matrix m = this.getSubmatrix(0, i);
				
				double cofactor = (i % 2 == 0) ? m.getDeterminant() : m.getDeterminant() * -1;
				sum += firstRow[i] * cofactor;
			}
			
			return sum;
		}
		
		return 0;
	}
	
	/**
	 * if the determinant is 0, the matrix isnt invertible.
	 * @return the boolean.
	 */
	public boolean isInvertible() {
		return this.getDeterminant() != 0;
	}
	
	public int getHeight() {
		return this.h;
	}
	
	public int getWidth() {
		return this.w;
	}
	
	public double[][] getMatrix(){
		return this.matrix;
	}
	
	public void printData() {
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.w; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * Create a cofactor Matrix.
	 * @return
	 */
	public Matrix createCofactorMatrix() {
		double[][] cofactorGrid = new double[this.h][this.w];
		
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.w; j++) {
				cofactorGrid[i][j] = this.getCofactor(i, j);
			}
		}
		
		Matrix cofactorMatrix = new Matrix(this.h);
		cofactorMatrix.setMatrix(cofactorGrid);
		
		return cofactorMatrix;
	}
	
	/**
	 * Translates the object.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return The translated matrix.
	 */
	public static Matrix translation(double x, double y, double z) {
		double[][] translationGrid = {{1, 0, 0, x},
									  {0, 1, 0, y},
									  {0, 0, 1, z},
									  {0, 0, 0, 1}};
		
		Matrix translationMatrix = new Matrix(4);
		translationMatrix.setMatrix(translationGrid);
		
		return translationMatrix;
	}
	
	/**
	 * Scales the object.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return The scaled matrix.
	 */
	public static Matrix scaling(double x, double y, double z) {
		double[][] scalingGrid = {{x, 0, 0, 0},
								  {0, y, 0, 0},
								  {0, 0, z, 0},
								  {0, 0, 0, 1}};
		
		Matrix scalingMatrix = new Matrix(4);
		scalingMatrix.setMatrix(scalingGrid);
		
		return scalingMatrix;
	}
	
	/**
	 * Rotates the object.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return The Rotated matrix.
	 */
	public static Matrix rotationX(double r) {
		double cosr = Math.cos(r);
		double sinr = Math.sin(r);
		
		double[][] rotationGrid = {{1, 0,    0,     0},
				                   {0, cosr, sinr * -1, 0},
				                   {0, sinr, cosr,  0},
				                   {0, 0,    0,     1}};
		
		Matrix rotationMatrix = new Matrix(4);
		rotationMatrix.setMatrix(rotationGrid);
		
		return rotationMatrix;
	}
	
	/**
	 * Rotates the object.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return The Rotated matrix.
	 */
	public static Matrix rotationY(double r) {
		double cosr = Math.cos(r);
		double sinr = Math.sin(r);
		
		double[][] rotationGrid = {{cosr,  0,    sinr,     0},
				                   {0,     1,    0,        0},
				                   {-sinr, 0,    cosr,     0},
				                   {0,     0,    0,        1}};
		
		Matrix rotationMatrix = new Matrix(4);
		rotationMatrix.setMatrix(rotationGrid);
		
		return rotationMatrix;
	}
	
	/**
	 * Rotates the object.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return The Rotated matrix.
	 */
	public static Matrix rotationZ(double r) {
		double cosr = Math.cos(r);
		double sinr = Math.sin(r);
		
		double[][] rotationGrid = {{cosr,  -sinr,    0,     0},
				                   {sinr,   cosr,    0,     0},
				                   {0,      0,       1,     0},
				                   {0,      0,       0,     1}};
		
		Matrix rotationMatrix = new Matrix(4);
		rotationMatrix.setMatrix(rotationGrid);
		
		return rotationMatrix;
	}
	
	/**
	 * Shears the object.
	 * @param x The x coordinate.
	 * @param y The y coordinate.
	 * @param z The z coordinate.
	 * @return The sheared matrix.
	 */
	public static Matrix shearing(double xy, double xz, double yx, double yz, double zx, double zy) {
		double[][] shearingGrid = {{1,  xy, xz, 0},
								   {yx, 1,  yz, 0},
								   {zx, zy, 1,  0},
								   {0,  0,  0,  1}};
		
		Matrix shearingMatrix = new Matrix(4);
		shearingMatrix.setMatrix(shearingGrid);
		
		return shearingMatrix;
	}
	
	/**
	 * Make a transformation for a camera.
	 * @param from the origin of the camera.
	 * @param to the direction of the camera.
	 * @param up the up vector of the camera.
	 * @return the camera transformation matrix.
	 */
	public static Matrix viewTransformation(Coordinate cameraPosition, Coordinate cameraDirection, Coordinate up) {
		Coordinate forward = cameraDirection.subtractCoordinate(cameraPosition).normalize();
		Coordinate upn = up.normalize();
		Coordinate left = forward.crossProduct(upn);
		Coordinate trueUp = left.crossProduct(forward);
		
		Matrix orientation = new Matrix(4);
		
		double[][] orientationGrid = {{left.getX(),     left.getY(),     left.getZ(),     0},
		                              {trueUp.getX(),   trueUp.getY(),   trueUp.getZ(),   0},
		                              {-forward.getX(), -forward.getY(), -forward.getZ(), 0},
		                              {0,               0,               0,               1}};
		
		orientation.setMatrix(orientationGrid);
		
		return orientation.matrixMultiplication(Matrix.translation(-cameraPosition.getX(), 
				                                                   -cameraPosition.getY(), 
				                                                   -cameraPosition.getZ()));
	}
	
	/**
	 * This method checks whether 2 matrices are equal.
	 * @param m the other matrix.
	 * @return true if they are equal, false otherwise.
	 */
	public boolean isEqual(Matrix m) {
		if(this.getHeight() != m.getHeight() || this.getWidth() != m.getWidth()) {
			return false;
		}
		
		for(int i = 0; i < this.getHeight(); i++) {
			for(int j = 0; j < this.getWidth(); j++) {
				if(!Effect.compareDouble(this.matrix[i][j], m.getMatrix()[i][j])) {
					return false;
				}
			}
		}
		
		return true;
	}
}
