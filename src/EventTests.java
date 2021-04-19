import org.junit.Test;
import org.junit.Assert;

public class EventTests {
	private static final double DELTA = 0.1;
	
	/*@Test
	public void configurationTest() {
		Sphere sphere = new Sphere();
		
		Event e1 = Event.createEndEvent(sphere, KDTree.X_DIMENSION);
		Event e2 = Event.createPlanarEvent(sphere, KDTree.X_DIMENSION);
		Event e3 = Event.createStartEvent(sphere, KDTree.X_DIMENSION);
		
		Assert.assertEquals(true, e1.getType() == Event.END_EVENT_FLAG);
		Assert.assertEquals(true, e2.getType() == Event.PLANAR_EVENT_FLAG);
		Assert.assertEquals(true, e3.getType() == Event.START_EVENT_FLAG);
	}
	
	@Test
	public void sortingTestByX() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(-5, -2, 7);
		Matrix m2 = Matrix.translation(0, 2, 0);
		Matrix m3 = Matrix.translation(3, 5, -4);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Event e1 = Event.createStartEvent(s1, KDTree.X_DIMENSION); //sp0
		Event e2 = Event.createStartEvent(s2, KDTree.X_DIMENSION); //sp1
		Event e3 = Event.createStartEvent(s3, KDTree.X_DIMENSION); //sp2
		
		Event e4 = Event.createPlanarEvent(s1, KDTree.X_DIMENSION); //sp0
		Event e5 = Event.createPlanarEvent(s2, KDTree.X_DIMENSION); //sp1
		Event e6 = Event.createPlanarEvent(s3, KDTree.X_DIMENSION); //sp2
		
		Event e7 = Event.createEndEvent(s1, KDTree.X_DIMENSION); //sp0
		Event e8 = Event.createEndEvent(s2, KDTree.X_DIMENSION); //sp1
		Event e9 = Event.createEndEvent(s3, KDTree.X_DIMENSION); //sp2
		
		//               sp0 sp1 sp2 sp0 sp1 sp2 sp0 sp1 sp2
		Event[] result = {e1, e2, e3, e4, e5, e6, e7, e8, e9};
		
		result = Event.sortEventList(result, KDTree.X_DIMENSION);
		
		//                       sp0 sp0 sp0 sp1 sp1 sp1 sp2 sp2 sp2
		Event[] expectedResult = {e7, e4, e1, e8, e5, e2, e9, e6, e3};
		
		for(int i = 0; i < result.length; i++) {
			Assert.assertEquals(true, result[i].equals(expectedResult[i]));
		}
	}
	
	@Test
	public void sortingTestByY() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(-5, -2, -7);
		Matrix m2 = Matrix.translation(0, 2, 0);
		Matrix m3 = Matrix.translation(3, 5, 4);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Event e1 = Event.createStartEvent(s1, KDTree.Y_DIMENSION);
		Event e2 = Event.createStartEvent(s2, KDTree.Y_DIMENSION);
		Event e3 = Event.createStartEvent(s3, KDTree.Y_DIMENSION);
		
		Event e4 = Event.createPlanarEvent(s1, KDTree.Y_DIMENSION);
		Event e5 = Event.createPlanarEvent(s2, KDTree.Y_DIMENSION);
		Event e6 = Event.createPlanarEvent(s3, KDTree.Y_DIMENSION);
		
		Event e7 = Event.createEndEvent(s1, KDTree.Y_DIMENSION);
		Event e8 = Event.createEndEvent(s2, KDTree.Y_DIMENSION);
		Event e9 = Event.createEndEvent(s3, KDTree.Y_DIMENSION);
		
		Event[] result = {e1, e2, e3, e4, e5, e6, e7, e8, e9};
		result = Event.sortEventList(result, KDTree.Y_DIMENSION);
		 
		Event[] expectedResult = {e7, e4, e1, e8, e5, e2, e9, e6, e3};
		
		for(int i = 0; i < result.length; i++) {
			Assert.assertEquals(true, result[i].equals(expectedResult[i]));
		}
	}
	
	@Test
	public void sortingTestByZ() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(-5, -2, -7);
		Matrix m2 = Matrix.translation(0, 2, 0);
		Matrix m3 = Matrix.translation(3, 5, 4);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Event e1 = Event.createStartEvent(s1, KDTree.Z_DIMENSION);
		Event e2 = Event.createStartEvent(s2, KDTree.Z_DIMENSION);
		Event e3 = Event.createStartEvent(s3, KDTree.Z_DIMENSION);
		
		Event e4 = Event.createPlanarEvent(s1, KDTree.Z_DIMENSION);
		Event e5 = Event.createPlanarEvent(s2, KDTree.Z_DIMENSION);
		Event e6 = Event.createPlanarEvent(s3, KDTree.Z_DIMENSION);
		
		Event e7 = Event.createEndEvent(s1, KDTree.Z_DIMENSION);
		Event e8 = Event.createEndEvent(s2, KDTree.Z_DIMENSION);
		Event e9 = Event.createEndEvent(s3, KDTree.Z_DIMENSION);
		
		Event[] result = {e1, e2, e3, e4, e5, e6, e7, e8, e9};
		result = Event.sortEventList(result, KDTree.Z_DIMENSION);
		 
		Event[] expectedResult = {e7, e4, e1, e8, e5, e2, e9, e6, e3};
		
		for(int i = 0; i < result.length; i++) {
			Assert.assertEquals(true, result[i].equals(expectedResult[i]));
		}
	}
	
	@Test
	public void sortByTypeTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(0, 7, 0);
		Matrix m2 = Matrix.translation(-5, 0, 0);
		Matrix m3 = Matrix.translation(5, -1, 3);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Shape[] shapes = {s1, s2, s3};
		
		Event[] events = Event.generateEventsInSingleDimension(shapes, KDTree.X_DIMENSION);
		
		events = Event.sortEventList(events, KDTree.X_DIMENSION);
		
		Event ss1 = Event.createStartEvent(s1, KDTree.X_DIMENSION);
		Event es1 = Event.createEndEvent(s1, KDTree.X_DIMENSION);
		Event ss2 = Event.createStartEvent(s2, KDTree.X_DIMENSION);
		Event es2 = Event.createEndEvent(s2, KDTree.X_DIMENSION);
		Event ss3 = Event.createStartEvent(s3, KDTree.X_DIMENSION);
		Event es3 = Event.createEndEvent(s3, KDTree.X_DIMENSION);
		
		Assert.assertEquals(true, events[0].equals(es2));
		Assert.assertEquals(true, events[1].equals(ss2));
		Assert.assertEquals(true, events[2].equals(es1));
		Assert.assertEquals(true, events[3].equals(ss1));
		Assert.assertEquals(true, events[4].equals(es3));
		Assert.assertEquals(true, events[5].equals(ss3));
	}
	
	@Test
	public void eventGenerationTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		
		Matrix m = Matrix.translation(2, -2, 7);
		
		s2.setTransformation(m);
		
		Coordinate v1 = Coordinate.createPoint(-2, 0, 1);
		Coordinate v2 = Coordinate.createPoint(-3, 1, 1);
		Coordinate v3 = Coordinate.createPoint(-2, 2, 1);
		
		Triangle t = new Triangle(v1, v2, v3);
		
		Shape[] shapes = {s1, s2, t};
		
		Event[] xEvents = Event.generateEventsInSingleDimension(shapes, KDTree.X_DIMENSION);
		Event[] yEvents = Event.generateEventsInSingleDimension(shapes, KDTree.Y_DIMENSION);;
		Event[] zEvents = Event.generateEventsInSingleDimension(shapes, KDTree.Z_DIMENSION);;
		
		Event resultX1 = Event.createStartEvent(s1, KDTree.X_DIMENSION);
		Event resultX2 = Event.createEndEvent(s1, KDTree.X_DIMENSION);
		Event resultX3 = Event.createStartEvent(s2, KDTree.X_DIMENSION);
		Event resultX4 = Event.createEndEvent(s2, KDTree.X_DIMENSION);
		Event resultX5 = Event.createStartEvent(t, KDTree.X_DIMENSION);
		Event resultX6 = Event.createEndEvent(t, KDTree.X_DIMENSION);
		
		Event resultY1 = Event.createStartEvent(s1, KDTree.Y_DIMENSION);
		Event resultY2 = Event.createEndEvent(s1, KDTree.Y_DIMENSION);
		Event resultY3 = Event.createStartEvent(s2, KDTree.Y_DIMENSION);
		Event resultY4 = Event.createEndEvent(s2, KDTree.Y_DIMENSION);
		Event resultY5 = Event.createStartEvent(t, KDTree.Y_DIMENSION);
		Event resultY6 = Event.createEndEvent(t, KDTree.Y_DIMENSION);
		
		Event resultZ1 = Event.createPlanarEvent(t, KDTree.Z_DIMENSION);
		Event resultZ2 = Event.createStartEvent(s1, KDTree.Z_DIMENSION);
		Event resultZ3 = Event.createEndEvent(s1, KDTree.Z_DIMENSION);
		Event resultZ4 = Event.createStartEvent(s2, KDTree.Z_DIMENSION);
		Event resultZ5 = Event.createEndEvent(s2, KDTree.Z_DIMENSION);
		
		Assert.assertEquals(true, xEvents[0].equals(resultX1));
		Assert.assertEquals(true, xEvents[1].equals(resultX2));
		Assert.assertEquals(true, xEvents[2].equals(resultX3));
		Assert.assertEquals(true, xEvents[3].equals(resultX4));
		Assert.assertEquals(true, xEvents[4].equals(resultX5));
		Assert.assertEquals(true, xEvents[5].equals(resultX6));
		
		Assert.assertEquals(true, yEvents[0].equals(resultY1));
		Assert.assertEquals(true, yEvents[1].equals(resultY2));
		Assert.assertEquals(true, yEvents[2].equals(resultY3));
		Assert.assertEquals(true, yEvents[3].equals(resultY4));
		Assert.assertEquals(true, yEvents[4].equals(resultY5));
		Assert.assertEquals(true, yEvents[5].equals(resultY6));
		
		Assert.assertEquals(true, zEvents[0].equals(resultZ1));
		Assert.assertEquals(true, zEvents[1].equals(resultZ2));
		Assert.assertEquals(true, zEvents[2].equals(resultZ3));
		Assert.assertEquals(true, zEvents[3].equals(resultZ4));
		Assert.assertEquals(true, zEvents[4].equals(resultZ5));
	}
	
	@Test
	public void recursiveSortXTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(-5, -2, -7);
		Matrix m2 = Matrix.translation(0, 2, 0);
		Matrix m3 = Matrix.translation(3, 5, 4);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Event e1 = Event.createStartEvent(s1, KDTree.X_DIMENSION); //sp0
		Event e2 = Event.createStartEvent(s2, KDTree.X_DIMENSION); //sp1
		Event e3 = Event.createStartEvent(s3, KDTree.X_DIMENSION); //sp2
		
		Event e4 = Event.createEndEvent(s1, KDTree.X_DIMENSION); //sp0
		Event e5 = Event.createEndEvent(s2, KDTree.X_DIMENSION); //sp1
		Event e6 = Event.createEndEvent(s3, KDTree.X_DIMENSION); //sp2
		
		Event[] result = {e1, e2, e3, e4, e5, e6};
		
		result = Event.sortEventsByXRecursive(result);
		
		Event[] expectedResult = {e4, e1, e5, e2, e6, e3};
		
		for(int i = 0; i < result.length; i++) {
			result[i].printData();
			Assert.assertEquals(true, result[i].equals(expectedResult[i]));
		}
	}
	
	@Test
	public void recursiveSortYTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(-5, -2, -7);
		Matrix m2 = Matrix.translation(0, 2, 0);
		Matrix m3 = Matrix.translation(3, 5, 4);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Event e1 = Event.createStartEvent(s1, KDTree.Y_DIMENSION); //sp0
		Event e2 = Event.createStartEvent(s2, KDTree.Y_DIMENSION); //sp1
		Event e3 = Event.createStartEvent(s3, KDTree.Y_DIMENSION); //sp2
		
		Event e4 = Event.createEndEvent(s1, KDTree.Y_DIMENSION); //sp0
		Event e5 = Event.createEndEvent(s2, KDTree.Y_DIMENSION); //sp1
		Event e6 = Event.createEndEvent(s3, KDTree.Y_DIMENSION); //sp2
		
		Event[] result = {e1, e2, e3, e4, e5, e6};
		
		result = Event.sortEventsByYRecursive(result);
		
		Event[] expectedResult = {e4, e1, e5, e2, e6, e3};
		
		for(int i = 0; i < result.length; i++) {
			result[i].printData();
			Assert.assertEquals(true, result[i].equals(expectedResult[i]));
		}
	}
	
	@Test
	public void recursiveSortZTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix m1 = Matrix.translation(-5, -2, -7);
		Matrix m2 = Matrix.translation(0, 2, 0);
		Matrix m3 = Matrix.translation(3, 5, 4);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		
		Event e1 = Event.createStartEvent(s1, KDTree.Z_DIMENSION); //sp0
		Event e2 = Event.createStartEvent(s2, KDTree.Z_DIMENSION); //sp1
		Event e3 = Event.createStartEvent(s3, KDTree.Z_DIMENSION); //sp2
		
		Event e4 = Event.createEndEvent(s1, KDTree.Z_DIMENSION); //sp0
		Event e5 = Event.createEndEvent(s2, KDTree.Z_DIMENSION); //sp1
		Event e6 = Event.createEndEvent(s3, KDTree.Z_DIMENSION); //sp2
		
		Event[] result = {e1, e2, e3, e4, e5, e6};
		
		result = Event.sortEventsByZRecursive(result);
		
		Event[] expectedResult = {e4, e1, e5, e2, e6, e3};
		
		for(int i = 0; i < result.length; i++) {
			result[i].printData();
			Assert.assertEquals(true, result[i].equals(expectedResult[i]));
		}
	}*/
}
