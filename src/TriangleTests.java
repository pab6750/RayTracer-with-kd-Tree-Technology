import org.junit.Test;
import org.junit.Assert;

public class TriangleTests {
	
	//triangle intersection tests
	@Test
	public void intersectionTest() {
		Coordinate v1 = Coordinate.createPoint(-1, 0, 0);
		Coordinate v2 = Coordinate.createPoint(1, 0, 0);
		Coordinate v3 = Coordinate.createPoint(0, 1, 0);
		
		Triangle t = new Triangle(v1, v2, v3);
		
		Coordinate rayOrigin = Coordinate.createPoint(0, 0, -1);
		Coordinate rayDirection = Coordinate.createVector(0, 0, 1);
		
		Ray r = new Ray(rayOrigin, rayDirection);
		
		IntersectionPoint[] intersections = t.intersect(r);
		
		Assert.assertEquals(true, Effect.compareDouble(intersections[0].getT(), 1));
	}
}
