import org.junit.Test;
import org.junit.Assert;

public class SceneTests {
	@Test
	public void intersectionTest() {
		Sphere sphere = new Sphere();
		Matrix m = Matrix.translation(0, 0, -1);
		sphere.setTransformation(m);
		
		Shape[] objs = {sphere};
		
		Scene scene = new Scene();
		scene.setObjs(objs);
		
		Coordinate rayOrigin = Coordinate.createPoint(0, 0, -3);
		Coordinate rayDirection = Coordinate.createVector(0, 0, 1);
		
		Ray r = new Ray(rayOrigin, rayDirection);
		
		IntersectionPoint[] intersections = scene.intersect(r);
		
		Assert.assertEquals(true, Effect.compareDouble(intersections[0].getT(), 1));
		Assert.assertEquals(true, Effect.compareDouble(intersections[1].getT(), 3));
	}
}