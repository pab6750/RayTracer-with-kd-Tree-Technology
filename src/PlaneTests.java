import org.junit.Test;
import org.junit.Assert;

public class PlaneTests {
	@Test
	public void intersectionTest() {
		Plane plane = new Plane();
		Matrix m = Matrix.rotationX(Math.PI / 2);
		plane.setTransformation(m);
		
		Coordinate rayOrigin = Coordinate.createPoint(0, 0, -3);
		Coordinate rayDirection = Coordinate.createVector(0, 0, 1);
		
		Ray r = new Ray(rayOrigin, rayDirection);
		
		IntersectionPoint[] intersections = plane.intersect(r);
		
		Assert.assertEquals(true, Effect.compareDouble(intersections[0].getT(), 3));
	}
}