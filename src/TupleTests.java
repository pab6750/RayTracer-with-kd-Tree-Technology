import org.junit.Test;

import org.junit.Assert;

public class TupleTests {
	private static final double DELTA = 0.1;
	
	//this test checks whether Coordinates are configured correctly
	@Test
	public void coordinateConfigurationTest() {
		Coordinate t = new Coordinate(5.4, 3.2, 6.6, Coordinate.POINT);
		
		Assert.assertEquals(5.4, t.getX(), DELTA);
		Assert.assertEquals(3.2, t.getY(), DELTA);
		Assert.assertEquals(6.6, t.getZ(), DELTA);
		Assert.assertEquals(Coordinate.POINT, t.getType(), DELTA);
	}
	
	//this test checks whether points are configured correctly
	@Test
	public void pointConfigurationTest() {
		Coordinate p = new Coordinate(5.4, 3.2, 6.6, Coordinate.POINT);
		
		Assert.assertEquals(5.4, p.getX(), DELTA);
		Assert.assertEquals(3.2, p.getY(), DELTA);
		Assert.assertEquals(6.6, p.getZ(), DELTA);
		Assert.assertEquals(Coordinate.POINT, p.getType(), DELTA);
	}
	
	//this test checks whether vectors are configured correctly
	@Test
	public void vectorConfigurationTest() {
		Coordinate v = new Coordinate(5.4, 3.2, 6.6, Coordinate.VECTOR);
		
		Assert.assertEquals(5.4, v.getX(), DELTA);
		Assert.assertEquals(3.2, v.getY(), DELTA);
		Assert.assertEquals(6.6, v.getZ(), DELTA);
		Assert.assertEquals(Coordinate.VECTOR, v.getType(), DELTA);
	}
	
	//this test checks whether Coordinate addition works properly
	@Test
	public void coordinateAdditionTest() {
		Coordinate p = new Coordinate(3, -2, 5, Coordinate.POINT);
		Coordinate v = new Coordinate(-2, 3, 1, Coordinate.VECTOR);
		
		Coordinate result = p.addCoordinate(v);
		Coordinate expectedResult = new Coordinate(1, 1, 6, Coordinate.POINT);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether Coordinate subtraction works properly
	@Test
	public void coordinateSubtractionTest() {
		Coordinate p1 = new Coordinate(3, 2, 1, Coordinate.POINT);
		Coordinate p2 = new Coordinate(5, 6, 6, Coordinate.POINT);
		
		Coordinate result = p1.subtractCoordinate(p2);
		Coordinate expectedResult = new Coordinate(-2, -4, -6, Coordinate.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether Coordinate negation works properly
	@Test
	public void coordinateNegationTest() {
		Coordinate v = new Coordinate(1, 2, 3, Coordinate.VECTOR);
		
		Coordinate result = v.negateCoordinate();
		Coordinate expectedResult = new Coordinate(-1, -2, -3, Coordinate.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether Coordinate scalar multiplication works properly
	@Test
	public void coordinateScalarMultiplicationTest() {
		Coordinate v = new Coordinate(-1, 2, 10, Coordinate.VECTOR);
		
		Coordinate result = v.scalarMultiplication(3.5);
		Coordinate expectedResult = new Coordinate(-3.5, 7, 35, Coordinate.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether Coordinate scalar division works properly
	@Test
	public void coordinateScalarDivisionTest() {
		Coordinate v = new Coordinate(4, 1, 7, Coordinate.VECTOR);
		
		Coordinate result = v.scalarDivision(2);
		Coordinate expectedResult = new Coordinate(2, 0.5, 3.5, Coordinate.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether Coordinate magnitude works properly
	@Test
	public void coordinateMagnitudeTest() {
		Coordinate v = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		
		double result = v.magnitude();
		double expectedResult = 1;
		
		Coordinate v2 = new Coordinate(1, 2, 3, Coordinate.VECTOR);
		
		double result2 = v2.magnitude();
		double expectedResult2 = Math.sqrt(14);
		
		Assert.assertEquals(expectedResult, result, DELTA);
		Assert.assertEquals(expectedResult2, result2, DELTA);
	}
	
	//this test checks whether Coordinate normalization works properly
	@Test
	public void coordinateNormalizationTest() {
		Coordinate v1 = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Coordinate v2 = new Coordinate(2, 2, 2, Coordinate.VECTOR);
		
		Coordinate result1 = v1.normalize();
		Coordinate result2 = v2.normalize();
		
		Coordinate expectedResult1 = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Coordinate expectedResult2 = new Coordinate(1, 1, 1, Coordinate.VECTOR);
		
		Assert.assertEquals(result1.isEqual(expectedResult1), true);
		Assert.assertEquals(result2.isEqual(expectedResult2), true);
	}
	
	//this test checks whether the dot product operation works properly
	@Test
	public void coordinateDotProductTest() {
		Coordinate v1 = new Coordinate(1, 2, 3, Coordinate.VECTOR);
		Coordinate v2 = new Coordinate(2, 3, 4, Coordinate.VECTOR);
		
		double result = v1.dotProduct(v2);
		double expectedResult = 20;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	//this test checks whether the cross product operation works properly
	@Test
	public void coordinateCrossProductTest() {
		Coordinate v1 = new Coordinate(1, 2, 3, Coordinate.VECTOR);
		Coordinate v2 = new Coordinate(2, 3, 4, Coordinate.VECTOR);
		
		Coordinate result = v1.crossProduct(v2);
		Coordinate expectedResult = new Coordinate(-1, 2, -1, Coordinate.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	
}
