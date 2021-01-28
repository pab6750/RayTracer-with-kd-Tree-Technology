import org.junit.Test;
import org.junit.Assert;

public class BoundingBoxTests {
	private static final double DELTA = 0.1;
	
	//test to check whether median box subdivision works
	@Test
	public void medianSubdivisionTest() {
		Sphere s = new Sphere();
		BoundingBox box = s.getBounds();
		
		BoundingBox[] resultX = box.splitAtX(0.8);
		BoundingBox[] resultY = box.splitAtY(0.3);
		BoundingBox[] resultZ = box.splitAtZ(0.5);
		
		Assert.assertEquals(box.getMin().getX(), resultX[0].getMin().getX(), DELTA);
		Assert.assertEquals(0.8, resultX[0].getMax().getX(), DELTA);
		Assert.assertEquals(0.8, resultX[1].getMin().getX(), DELTA);
		Assert.assertEquals(box.getMax().getX(), resultX[1].getMax().getX(), DELTA);
		
		Assert.assertEquals(box.getMin().getY(), resultY[0].getMin().getY(), DELTA);
		Assert.assertEquals(0.3, resultY[0].getMax().getY(), DELTA);
		Assert.assertEquals(0.3, resultY[1].getMin().getY(), DELTA);
		Assert.assertEquals(box.getMax().getY(), resultY[1].getMax().getY(), DELTA);
		
		Assert.assertEquals(box.getMin().getZ(), resultZ[0].getMin().getZ(), DELTA);
		Assert.assertEquals(0.5, resultZ[0].getMax().getZ(), DELTA);
		Assert.assertEquals(0.5, resultZ[1].getMin().getZ(), DELTA);
		Assert.assertEquals(box.getMax().getZ(), resultZ[1].getMax().getZ(), DELTA);
	}
}
