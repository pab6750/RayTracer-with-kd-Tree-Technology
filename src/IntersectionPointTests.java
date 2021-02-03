import org.junit.Test;
import org.junit.Assert;

public class IntersectionPointTests {
	@Test
	public void closestIntersectionTest() {
		Sphere s = new Sphere();
		
		IntersectionPoint i1 = new IntersectionPoint(0.5, s);
		IntersectionPoint i2 = new IntersectionPoint(1, s);
		IntersectionPoint i3 = new IntersectionPoint(3, s);
		IntersectionPoint i4 = new IntersectionPoint(6, s);
		IntersectionPoint i5 = new IntersectionPoint(9, s);
		
		IntersectionPoint[] intersections = {i1, i2, i3, i4, i5};
		
		IntersectionPoint res = IntersectionPoint.closestIntersection(intersections);
		
		Assert.assertEquals(true, res.isEqual(i1));
	}
	
	@Test
	public void sortIntersectionTest() {
		Sphere s = new Sphere();
		
		IntersectionPoint i1 = new IntersectionPoint(0.5, s);
		IntersectionPoint i2 = new IntersectionPoint(3, s);
		IntersectionPoint i3 = new IntersectionPoint(1, s);
		IntersectionPoint i4 = new IntersectionPoint(9, s);
		IntersectionPoint i5 = new IntersectionPoint(6, s);
		
		IntersectionPoint[] intersections = {i1, i2, i3, i4, i5};
		
		IntersectionPoint[] res = IntersectionPoint.sortIntersections(intersections);
		
		Assert.assertEquals(true, res[0].isEqual(i1));
		Assert.assertEquals(true, res[1].isEqual(i3));
		Assert.assertEquals(true, res[2].isEqual(i2));
		Assert.assertEquals(true, res[3].isEqual(i5));
		Assert.assertEquals(true, res[4].isEqual(i4));
	}
}
