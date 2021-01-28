import org.junit.Test;
import org.junit.Assert;

public class MatrixTests {
	private static final double DELTA = 0.1;
	
	//this test makes sure a matrix is set up correctly
	@Test
	public void matrixConfigurationTest() {
		Matrix m = new Matrix(4);
		
		double[][] d = {{1,    2,    3,    4   },
						{5.5,  6.5,  7.5,  8.5 },
						{9,    10,   11,   12  },
						{13.5, 14.5, 15.5, 16.5}};
		
		m.setMatrix(d);
		
		Assert.assertEquals(1,    m.getMatrix()[0][0], DELTA);
		Assert.assertEquals(4,    m.getMatrix()[0][3], DELTA);
		Assert.assertEquals(5.5,  m.getMatrix()[1][0], DELTA);
		Assert.assertEquals(7.5,  m.getMatrix()[1][2], DELTA);
		Assert.assertEquals(11,   m.getMatrix()[2][2], DELTA);
		Assert.assertEquals(13.5, m.getMatrix()[3][0], DELTA);
		Assert.assertEquals(15.5, m.getMatrix()[3][2], DELTA);
	}
	
	//this test checks whether matrix comparison works correctly when the matrices are equal
	@Test
	public void matrixComparisonTest() {
		Matrix m1 = new Matrix(4);
		Matrix m2 = new Matrix(4);
		
		double[][] d1 = {{1, 2, 3, 4},
						 {5, 6, 7, 8},
						 {9, 8, 7, 6},
						 {5, 4, 3, 2}};
		
		double[][] d2 = {{1, 2, 3, 4},
				 		 {5, 6, 7, 8},
				 		 {9, 8, 7, 6},
				 		 {5, 4, 3, 2}};
		
		m1.setMatrix(d1);
		m2.setMatrix(d2);
		
		Assert.assertEquals(m1.equals(m2), true);
	}
	
	//this test checks whether matrix comparison works correctly when the matrices aren't equal
	@Test
	public void matrixComparisonWithDifferentMatricesTest() {
		Matrix m1 = new Matrix(4);
		Matrix m2 = new Matrix(4);
		
		double[][] d1 = {{1, 2, 3, 4},
						 {5, 6, 7, 8},
						 {9, 8, 7, 6},
						 {5, 4, 3, 2}};
		
		double[][] d2 = {{1, 2, 3, 1},
				 		 {5, 6, 7, 1},
				 		 {9, 8, 7, 1},
				 		 {5, 4, 3, 1}};
		
		m1.setMatrix(d1);
		m2.setMatrix(d2);
		
		Assert.assertEquals(m1.isEqual(m2), false);
	}
	
	//this test checks whether matrix multiplication works correctly
	@Test
	public void matrixMultiplicationTest() {
		Matrix m1 = new Matrix(4);
		Matrix m2 = new Matrix(4);
		
		double[][] d1 = {{1, 2, 3, 4},
				         {5, 6, 7, 8},
				         {9, 8, 7, 6},
				         {5, 4, 3, 2}};
		
		double[][] d2 = {{-2, 1, 2, 3 },
				         {3,  2, 1, -1},
				         {4,  3, 6, 5 },
				         {1,  2, 7, 8 }};
		
		m1.setMatrix(d1);
		m2.setMatrix(d2);
		
		Matrix result = m1.matrixMultiplication(m2);
		
		double[][] d3 = {{20, 22, 50,  48 },
						 {44, 54, 114, 108},
						 {40, 58, 110, 102},
						 {16, 26, 46,  42 }};
		
		Matrix expectedResult = new Matrix(4);
		expectedResult.setMatrix(d3);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether matrix-tuple multiplication works properly
	@Test
	public void matrixTupleMultiplicationTest() {
		double[][] d = {{1, 2, 3, 4},
		                {2, 4, 4, 2},
		                {8, 6, 4, 1},
		                {0, 0, 0, 1}};
		
		Matrix m = new Matrix(4);
		m.setMatrix(d);
		
		Tuple t = new Tuple(1, 2, 3, Tuple.POINT);
		
		Tuple result = m.tupleMultiplication(t);
		Tuple expectedResult = new Tuple(18, 24, 33, Tuple.POINT);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
}
