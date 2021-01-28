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
		Point p = new Point(5.4, 3.2, 6.6);
		
		Assert.assertEquals(5.4, p.getX(), DELTA);
		Assert.assertEquals(3.2, p.getY(), DELTA);
		Assert.assertEquals(6.6, p.getZ(), DELTA);
		Assert.assertEquals(Tuple.POINT, p.getType(), DELTA);
	}
	
	//this test checks whether vectors are configured correctly
	@Test
	public void vectorConfigurationTest() {
		Vector v = new Vector(5.4, 3.2, 6.6);
		
		Assert.assertEquals(5.4, v.getX(), DELTA);
		Assert.assertEquals(3.2, v.getY(), DELTA);
		Assert.assertEquals(6.6, v.getZ(), DELTA);
		Assert.assertEquals(Tuple.VECTOR, v.getType(), DELTA);
	}
	
	//this test checks whether tuple addition works properly
	@Test
	public void tupleAdditionTest() {
		Point p = new Point(3, -2, 5);
		Vector v = new Vector(-2, 3, 1);
		
		Tuple result = p.addTuples(v);
		Tuple expectedResult = new Tuple(1, 1, 6, Tuple.POINT);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple subtraction works properly
	@Test
	public void tupleSubtractionTest() {
		Point p1 = new Point(3, 2, 1);
		Point p2 = new Point(5, 6, 6);
		
		Tuple result = p1.subtractTuples(p2);
		Tuple expectedResult = new Tuple(-2, -4, -6, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple negation works properly
	@Test
	public void tupleNegationTest() {
		Vector v = new Vector(1, 2, 3);
		
		Tuple result = v.negateTuple();
		Tuple expectedResult = new Tuple(-1, -2, -3, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple scalar multiplication works properly
	@Test
	public void tupleScalarMultiplicationTest() {
		Vector v = new Vector(-1, 2, 10);
		
		Tuple result = v.scalarMultiplication(3.5);
		Tuple expectedResult = new Tuple(-3.5, 7, 35, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple scalar division works properly
	@Test
	public void tupleScalarDivisionTest() {
		Vector v = new Vector(4, 1, 7);
		
		Tuple result = v.scalarDivision(2);
		Tuple expectedResult = new Tuple(2, 0.5, 3.5, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether tuple magnitude works properly
	@Test
	public void tupleMagnitudeTest() {
		Vector v = new Vector(0, 1, 0);
		
		double result = v.magnitude();
		double expectedResult = 1;
		
		Vector v2 = new Vector(1, 2, 3);
		
		double result2 = v2.magnitude();
		double expectedResult2 = Math.sqrt(14);
		
		Assert.assertEquals(expectedResult, result, DELTA);
		Assert.assertEquals(expectedResult2, result2, DELTA);
	}
	
	//this test checks whether tuple normalization works properly
	@Test
	public void tupleNormalizationTest() {
		Vector v1 = new Vector(0, 1, 0);
		Vector v2 = new Vector(2, 2, 2);
		
		Vector result1 = v1.normalize();
		Vector result2 = v2.normalize();
		
		Vector expectedResult1 = new Vector(0, 1, 0);
		Vector expectedResult2 = new Vector(1, 1, 1);
		
		Assert.assertEquals(result1.isEqual(expectedResult1), true);
		Assert.assertEquals(result2.isEqual(expectedResult2), true);
	}
	
	//this test checks whether the dot product operation works properly
	@Test
	public void tupleDotProductTest() {
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(2, 3, 4);
		
		double result = v1.dotProduct(v2);
		double expectedResult = 20;
		
		Assert.assertEquals(expectedResult, result, DELTA);
	}
	
	//this test checks whether the cross product operation works properly
	@Test
	public void tupleCrossProductTest() {
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(2, 3, 4);
		
		Tuple result = v1.crossProduct(v2);
		Tuple expectedResult = new Tuple(-1, 2, -1, Tuple.VECTOR);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	
}
