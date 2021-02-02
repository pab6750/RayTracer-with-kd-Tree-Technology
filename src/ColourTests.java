import org.junit.Test;
import org.junit.Assert;

public class ColourTests {
	@Test
	public void additionTest() {
		Colour c1 = new Colour(0.5, 0.5, 0.5);
		Colour c2 = new Colour(0.7, 0.7, 0.7);
		
		Colour res = c1.addColours(c2);
		
		Assert.assertEquals(true, res.isEqual(Colour.WHITE));
	}
	
	@Test 
	public void additionTest2() {
		Colour c1 = new Colour(0.5, 0.5, 0.5);
		Colour c2 = new Colour(0.4, 0.4, 0.4);
		
		Colour res = c1.addColours(c2);
		
		Assert.assertEquals(true, res.isEqual(new Colour(0.9, 0.9, 0.9)));
	}
	
	@Test
	public void subtractionTest() {
		Colour c1 = new Colour(0.5, 0.5, 0.5);
		Colour c2 = new Colour(0.5, 0.5, 0.5);
		
		Colour res = c1.subtractColours(c2);
		
		Assert.assertEquals(true, res.isEqual(Colour.BLACK));
	}
	
	@Test
	public void scalarMultiplicationTest() {
		Colour c1 = new Colour(0.2, 0.2, 0.2);
		int scalar = 2;
		
		Colour res = c1.scalarMultiplication(scalar);
		
		Assert.assertEquals(true, res.isEqual(new Colour(0.4, 0.4, 0.4)));
	}
	
	@Test
	public void scalarDivisionTest() {
		Colour c1 = new Colour(0.2, 0.2, 0.2);
		int scalar = 2;
		
		Colour res = c1.scalarDivision(scalar);
		
		Assert.assertEquals(true, res.isEqual(new Colour(0.1, 0.1, 0.1)));
	}
	
	@Test
	public void colourProductTest() {
		Colour c1 = new Colour(0.5, 0.5, 0.5);
		Colour c2 = new Colour(0.5, 0.5, 0.5);
		
		Colour res = c1.colourProduct(c2);
		
		Assert.assertEquals(true, res.isEqual(new Colour(0.25, 0.25, 0.25)));
	}
}
