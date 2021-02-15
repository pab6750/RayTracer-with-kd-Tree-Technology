import org.junit.Test;
import org.junit.Assert;

public class AABBTests {
	private static final double DELTA = 0.1;
	
	//test to check whether median box subdivision works
	@Test
	public void medianSubdivisionTest() {
		Sphere s = new Sphere();
		AABB box = s.getAABB();
		
		AABB[] resultX = box.splitAtX(0.8);
		AABB[] resultY = box.splitAtY(0.3);
		AABB[] resultZ = box.splitAtZ(0.5);
		
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
	
	@Test
	public void surfaceAreaTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m2 = Matrix.translation(-5, -5, -5);
		Matrix m3 = Matrix.scaling(2, 2, 2);
		
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		double result1 = s1.getAABB().getSurfaceArea();
		double result2 = s2.getAABB().getSurfaceArea();
		double result3 = s3.getAABB().getSurfaceArea();
		
		double expected1 = 24;
		double expected2 = 24;
		double expected3 = 96;
		
		Assert.assertEquals(expected1, result1, DELTA);
		Assert.assertEquals(expected2, result2, DELTA);
		Assert.assertEquals(expected3, result3, DELTA);
	}
}
