import org.junit.Test;
import org.junit.Assert;

public class EventTests {
	private static final double DELTA = 0.1;
	
	@Test
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
}
