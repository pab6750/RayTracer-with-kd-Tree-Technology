import org.junit.Test;
import org.junit.Assert;

public class RayTests {
	private static final double DELTA = 0.1;
	
	//ray configuration test
	@Test
	public void rayConfigurationTest() {
		Coordinate origin = new Coordinate(1, 2, 3, Coordinate.POINT);
		Coordinate direction = new Coordinate(4, 5, 6, Coordinate.VECTOR);
		
		Ray ray = new Ray(origin, direction);
		
		Assert.assertEquals(true, ray.isEqual(new Ray(origin, direction)));
	}
	
	//position method test
	@Test
	public void rayPositionTest() {
		Coordinate origin = new Coordinate(2, 3, 4, Coordinate.POINT);
		Coordinate direction = new Coordinate(1, 0, 0, Coordinate.VECTOR);
		
		Ray ray = new Ray(origin, direction);
		
		Assert.assertEquals(true, ray.position(0).isEqual(ray.getOrigin()));
		Assert.assertEquals(true, ray.position(1).isEqual(new Coordinate(3, 3, 4, Coordinate.POINT)));
		Assert.assertEquals(true, ray.position(-1).isEqual(new Coordinate(1, 3, 4, Coordinate.POINT)));
		Assert.assertEquals(true, ray.position(2.5).isEqual(new Coordinate(4.5, 3, 4, Coordinate.POINT)));
	}
	
	//ray sphere intersection test
	@Test
	public void raySphereIntersectionTest() {
		Coordinate origin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate direction = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		
		Ray ray = new Ray(origin, direction);
		
		Sphere s = new Sphere();
		
		Intersection[] xs = s.intersect(ray);
		
		Assert.assertEquals(true, xs.length == 2);
		Assert.assertEquals(true, xs[0].getT() == 4);
	}
}
