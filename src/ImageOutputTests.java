import org.junit.Test;
import org.junit.Assert;

public class ImageOutputTests {
	private static final double DELTA = 0.1;
	
	//this test checks whether colours are set up correctly
	@Test
	public void colourCOnfigurationTest() {
		Colour c = new Colour(0.7, 0.1, 0.45);
		
		Assert.assertEquals(0.7, c.getR(), DELTA);
		Assert.assertEquals(0.1, c.getG(), DELTA);
		Assert.assertEquals(0.45, c.getB(), DELTA);
	}
	
	//this test checks whether colour addition works properly
	@Test
	public void colourAdditionTest() {
		Colour c1 = new Colour(0.9, 0.5, 0.1);
		Colour c2 = new Colour(0.1, 0.2, 0.3);
		
		Colour result = c1.addColours(c2);
		result.printData();
		Colour expectedResult = new Colour(1, 0.7, 0.4);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether colour subtraction works properly
	@Test
	public void colourSubtractionTest() {
		Colour c1 = new Colour(0.9, 0.5, 0.4);
		Colour c2 = new Colour(0.1, 0.2, 0.3);
		
		Colour result = c1.subtractColours(c2);
		Colour expectedResult = new Colour(0.8, 0.3, 0.1);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether colour scalar multiplication works properly
	@Test
	public void colourScalarMultiplicationTest() {
		Colour c = new Colour(0.2, 0.3, 0.4);
		double scalar = 2;
		
		Colour result = c.scalarMultiplication(scalar);
		Colour expectedResult = new Colour(0.4, 0.6, 1);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether colour multiplication works properly
	@Test
	public void colourMultiplicationTest() {
		Colour c1 = new Colour(0.2, 0.3, 0.4);
		Colour c2 = new Colour(0.1, 0.2, 0.3);
		
		Colour result = c1.colourProduct(c2);
		Colour expectedResult = new Colour(0.02, 0.06, 0.12);
		
		Assert.assertEquals(result.isEqual(expectedResult), true);
	}
	
	//this test checks whether a canvas is configured correctly
	@Test
	public void canvasConfigurationTest() {
		ImageOutput c = new ImageOutput(10, 5);
		
	    int height = c.getH();
	    int width = c.getW();
	    
	    Assert.assertEquals(10, height);
	    Assert.assertEquals(5, width);
	}
	
	//this test checks whether pixels in the canvas can be written correctly
	@Test
	public void pixelConfigurationTest() {
		ImageOutput c = new ImageOutput(10, 5);
		
		Colour red = new Colour(1, 0, 0);
		
		c.writePixel(2, 3, red);
		
		Colour result = c.pixelAt(2, 3);
		
		Assert.assertEquals(result.isEqual(red), true);
	}
	
	
}
