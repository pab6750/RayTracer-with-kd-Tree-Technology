import org.junit.Test;
import org.junit.Assert;

public class KDTreeTests {
	private static final double DELTA = 0.1;
	
	//KDTree configuration test
	@Test
	public void KDTreeConfigurationTest() {
		Shape[] shapes = {new Sphere(), new Cube(), new Plane()};
		MedianKDTree kdt = MedianKDTree.createRoot(shapes);
		
		kdt.setShapes(shapes);
		
		Assert.assertEquals(kdt.isRoot(), true);
		Assert.assertEquals(kdt.getLeftChild() == null, true);
		Assert.assertEquals(kdt.getRightChild() == null, true);
		Assert.assertEquals(kdt.getShapes().length, 3);
	}
	
	//test for the addShape method
	@Test
	public void addShapeTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		
		Shape[] onlyS1 = {s1};
		
		MedianKDTree kd1 = new MedianKDTree(true, onlyS1, 0);
		kd1.addShape(s2);
		
		Shape shape1 = kd1.getShapes()[1];
		
		String result1 = shape1.getId();
		
		String expectedResult1 = s2.getId();
		
		Assert.assertEquals(true, result1.equals(expectedResult1));
	}
	
	//test for the medianSplit method
	@Test
	public void medianSplitTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		
		Matrix leftMatrix = Matrix.translation(-2, 0, 0);
		Matrix rightMatrix = Matrix.translation(2, 0, 0);
		
		s1.setTransformation(leftMatrix);
		s3.setTransformation(rightMatrix);
		
		Shape[] shapes = {s1, s2, s3};
		
		boolean isRoot = true;
		
		MedianKDTree kdt = new MedianKDTree(isRoot, shapes, 0);
		kdt.split(1, 1);
		
		KDTree leftChild = kdt.getLeftChild();
		KDTree rightChild = kdt.getRightChild();
		
		Shape[] leftChildShapes = leftChild.getShapes();
		Shape[] rightChildShapes = rightChild.getShapes();
		
		Assert.assertEquals(true, leftChildShapes.length == 2);
		Assert.assertEquals(true, rightChildShapes.length == 2);
	}
	
	//test for building with median method
	@Test
	public void medianBuildingTest() {
		Sphere s0 = new Sphere();
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();
		Sphere s5 = new Sphere();
		Sphere s6 = new Sphere();
		Sphere s7 = new Sphere();
		Sphere s8 = new Sphere();
		Sphere s9 = new Sphere();
		
		Matrix t0 = Matrix.translation(-10, 0, 0);
		Matrix t1 = Matrix.translation(-8, 0, 0);
		Matrix t2 = Matrix.translation(-6, 0, 0);
		Matrix t3 = Matrix.translation(-4, 0, 0);
		Matrix t4 = Matrix.translation(-2, 0, 0);
		Matrix t5 = Matrix.translation( 0, 0, 0);
		Matrix t6 = Matrix.translation( 2, 0, 0);
		Matrix t7 = Matrix.translation( 4, 0, 0);
		Matrix t8 = Matrix.translation( 6, 0, 0);
		Matrix t9 = Matrix.translation( 8, 0, 0);
		
		s0.setTransformation(t0);
		s1.setTransformation(t1);
		s2.setTransformation(t2);
		s3.setTransformation(t3);
		s4.setTransformation(t4);
		s5.setTransformation(t5);
		s6.setTransformation(t6);
		s7.setTransformation(t7);
		s8.setTransformation(t8);
		s9.setTransformation(t9);
		
		Shape[] shapes = {s0, s1, s2, s3, s4, s5, s6, s7, s8, s9};
		
		MedianKDTree kdt = new MedianKDTree(true, shapes, 0);
		kdt.build();
	}
	
	//intersection test without kdtree
	@Test
	public void intersectionTestWithoutKdTree() {
		Shape.refreshIds();
		Sphere s0 = new Sphere();
		Sphere s1 = new Sphere();
 		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();
		
		Matrix t0 = Matrix.translation(-5, 0, 0);
		Matrix t1 = Matrix.translation(-3, 0, 0);
		Matrix t2 = Matrix.translation(-1, 0, 0);
		Matrix t3 = Matrix.translation(1, 0, 0);
		Matrix t4 = Matrix.translation(3, 0, 0);
		
		s0.setTransformation(t0);
		s1.setTransformation(t1);
		s2.setTransformation(t2);
		s3.setTransformation(t3);
		s4.setTransformation(t4);
		
		Shape[] shapes = {s0, s1, s2, s3, s4};
		
		double step = 0.1;
		boolean notMissed = false;
		
		for(int i = 0; i < 80; i++) {
			Coordinate currentOrigin = new Coordinate(-6 + (i * step), 0, -2, Coordinate.POINT);
			Coordinate currentDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
			
			Ray currentRay = new Ray(currentOrigin, currentDirection);
			
			boolean allMissed = true;
			
			for(int j = 0; j < shapes.length; j++) {
				if(shapes[j].intersect(currentRay) != null) {
					allMissed = false;
				}
			}
			
			notMissed = !allMissed;
			
			Assert.assertEquals(true, notMissed);
		}
	}
	
	//intersection test with median kdtree
	@Test
	public void intersectionTestWithMedianKdTree() {
		Shape.refreshIds();
		Sphere s0 = new Sphere();
		Sphere s1 = new Sphere();
 		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();
		
		Matrix t0 = Matrix.translation(-5, 0, 0);
		Matrix t1 = Matrix.translation(-3, 0, 0);
		Matrix t2 = Matrix.translation(-1, 0, 0);
		Matrix t3 = Matrix.translation(1, 0, 0);
		Matrix t4 = Matrix.translation(3, 0, 0);
		
		s0.setTransformation(t0);
		s1.setTransformation(t1);
		s2.setTransformation(t2);
		s3.setTransformation(t3);
		s4.setTransformation(t4);
		
		Shape[] shapes = {s0, s1, s2, s3, s4};
		
		MedianKDTree kdt = new MedianKDTree(true, shapes, 0);
		kdt.build();
		
		double step = 0.1;
		boolean notMissed = true;
		
		for(int i = 0; i < 80; i++) {
			Coordinate currentOrigin = new Coordinate(-6 + (i * step), 0, -2, Coordinate.POINT);
			Coordinate currentDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
			
			Ray currentRay = new Ray(currentOrigin, currentDirection);
			
			Intersection[] intersections = kdt.intersect(currentRay);
			if(intersections == null) {
				notMissed = false;
			} else {
				System.out.println("Shape: " + intersections[0].getObject().getId());
			}
			
			Assert.assertEquals(false, notMissed);
		}
	}
}
