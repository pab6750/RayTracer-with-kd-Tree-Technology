import org.junit.Test;
import org.junit.Assert;

public class RayTests {
	private static final double DELTA = 0.1;
	
	//ray configuration test
	@Test
	public void rayConfigurationTest() {
		Tuple origin = new Tuple(1, 2, 3, Tuple.POINT);
		Tuple direction = new Tuple(4, 5, 6, Tuple.VECTOR);
		
		Ray ray = new Ray(origin, direction);
		
		Assert.assertEquals(true, ray.isEqual(new Ray(origin, direction)));
	}
	
	//position method test
	@Test
	public void rayPositionTest() {
		Tuple origin = new Tuple(2, 3, 4, Tuple.POINT);
		Tuple direction = new Tuple(1, 0, 0, Tuple.VECTOR);
		
		Ray ray = new Ray(origin, direction);
		
		Assert.assertEquals(true, ray.position(0).isEqual(ray.getOrigin()));
		Assert.assertEquals(true, ray.position(1).isEqual(new Tuple(3, 3, 4, Tuple.POINT)));
		Assert.assertEquals(true, ray.position(-1).isEqual(new Tuple(1, 3, 4, Tuple.POINT)));
		Assert.assertEquals(true, ray.position(2.5).isEqual(new Tuple(4.5, 3, 4, Tuple.POINT)));
	}
	
	//ray sphere intersection test
	@Test
	public void raySphereIntersectionTest() {
		Tuple origin = new Tuple(0, 0, -5, Tuple.POINT);
		Tuple direction = new Tuple(0, 0, 1, Tuple.VECTOR);
		
		Ray ray = new Ray(origin, direction);
		
		Sphere s = new Sphere();
		
		Intersection[] xs = s.intersect(ray);
		
		Assert.assertEquals(true, xs.length == 2);
		Assert.assertEquals(true, xs[0].getT() == 4);
	}
}
