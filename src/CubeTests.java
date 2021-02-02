import org.junit.Test;
import org.junit.Assert;

public class CubeTests {
	@Test
	public void intersectionTest() {
		Cube cube = new Cube();
		Matrix m = Matrix.translation(0, 0, -1);
		cube.setTransformation(m);
		
		Coordinate rayOrigin = Coordinate.createPoint(0, 0, -3);
		Coordinate rayDirection = Coordinate.createVector(0, 0, 1);
		
		Ray r = new Ray(rayOrigin, rayDirection);
		
		IntersectionPoint[] intersections = cube.intersect(r);
		
		Assert.assertEquals(true, Effect.compareDouble(intersections[0].getT(), 1));
		Assert.assertEquals(true, Effect.compareDouble(intersections[1].getT(), 3));
	}
}
