import org.junit.Test;

import org.junit.Assert;

public class TupleTests {
	private static final double DELTA = 0.1;
	
	//this test checks whether tuples are configured correctly
	@Test
	public void tupleConfigurationTest() {
		Tuple t = new Tuple(5.4, 3.2, 6.6, Tuple.POINT);
		
		Assert.assertEquals(5.4, t.getX(), DELTA);
		Assert.assertEquals(3.2, t.getY(), DELTA);
		Assert.assertEquals(6.6, t.getZ(), DELTA);
		Assert.assertEquals(Tuple.POINT, t.getType(), DELTA);
	}
	
	//this test checks whether points are configured correctly
	@Test
	public void pointConfigurationTest() {
		Tuple p = new Tuple(5.4, 3.2, 6.6, Tuple.POINT);
		
		Assert.assertEquals(5.4, p.getX(), DELTA);
		Assert.assertEquals(3.2, p.getY(), DELTA);
		Assert.assertEquals(6.6, p.getZ(), DELTA);
		Assert.assertEquals(Tuple.POINT, p.getType(), DELTA);
	}
	
	//this test checks whether vectors are configured correctly
	@Test
	public void vectorConfigurationTest() {
		Tuple v = new Tuple(5.4, 3.2, 6.6, Tuple.VECTOR);
		
		Assert.assertEquals(5.4, v.getX(), DELTA);
		Assert.assertEquals(3.2, v.getY(), DELTA);
		Assert.assertEquals(6.6, v.getZ(), DELTA);
		Assert.assertEquals(Tuple.VECTOR, v.getType(), DELTA);
	}
	
	//this test checks whether tuple addition works properly
	@Test
	public void tupleAdditionTest() {
		Tuple p = new Tuple(3, -2, 5, Tuple.POINT);
		Tuple v = new Tuple(-2, 3, 1, Tuple.VECTOR);
		
		Tuple result = p.addTuples(v);
		Tuple expectedResult = new Tuple(1, 1, 6, Tuple.POINT);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple subtraction works properly
	@Test
	public void tupleSubtractionTest() {
		Tuple p1 = new Tuple(3, 2, 1, Tuple.POINT);
		Tuple p2 = new Tuple(5, 6, 6, Tuple.POINT);
		
		Tuple result = p1.subtractTuples(p2);
		Tuple expectedResult = new Tuple(-2, -4, -6, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple negation works properly
	@Test
	public void tupleNegationTest() {
		Tuple v = new Tuple(1, 2, 3, Tuple.VECTOR);
		
		Tuple result = v.negateTuple();
		Tuple expectedResult = new Tuple(-1, -2, -3, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple scalar multiplication works properly
	@Test
	public void tupleScalarMultiplicationTest() {
		Tuple v = new Tuple(-1, 2, 10, Tuple.VECTOR);
		
		Tuple result = v.scalarMultiplication(3.5);
		Tuple expectedResult = new Tuple(-3.5, 7, 35, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple scalar division works properly
	@Test
	public void tupleScalarDivisionTest() {
		Tuple v = new Tuple(4, 1, 7, Tuple.VECTOR);
		
		Tuple result = v.scalarDivision(2);
		Tuple expectedResult = new Tuple(2, 0.5, 3.5, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple magnitude works properly
	@Test
	public void tupleMagnitudeTest() {
		Tuple v = new Tuple(0, 1, 0, Tuple.VECTOR);
		
		double result = v.magnitude();
		double expectedResult = 1;
		
		Tuple v2 = new Tuple(1, 2, 3, Tuple.VECTOR);
		
		double result2 = v2.magnitude();
		double expectedResult2 = Math.sqrt(14);
		
		Assert.assertEquals(expectedResult, result, DELTA);
		Assert.assertEquals(expectedResult2, result2, DELTA);
	}
	
	//this test checks whether tuple normalization works properly
	@Test
	public void tupleNormalizationTest() {
		Tuple v1 = new Tuple(0, 1, 0, Tuple.VECTOR);
		Tuple v2 = new Tuple(2, 2, 2, Tuple.VECTOR);
		
		Tuple result1 = v1.normalize();
		Tuple result2 = v2.normalize();
		
		Tuple expectedResult1 = new Tuple(0, 1, 0, Tuple.VECTOR);
		Tuple expectedResult2 = new Tuple(1, 1, 1, Tuple.VECTOR);
		
		Assert.assertEquals(result1.isEqual(expectedResult1), true);
		Assert.assertEquals(result2.isEqual(expectedResult2), true);
	}
	
	//this test checks whether the dot product operation works properly
	@Test
	public void tupleDotProductTest() {
		Tuple v1 = new Tuple(1, 2, 3, Tuple.VECTOR);
		Tuple v2 = new Tuple(2, 3, 4, Tuple.VECTOR);
		
		double result = v1.dotProduct(v2);
		double expectedResult = 20;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	//this test checks whether the cross product operation works properly
	@Test
	public void tupleCrossProductTest() {
		Tuple v1 = new Tuple(1, 2, 3, Tuple.VECTOR);
		Tuple v2 = new Tuple(2, 3, 4, Tuple.VECTOR);
		
		Tuple result = v1.crossProduct(v2);
		Tuple expectedResult = new Tuple(-1, 2, -1, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	
}
