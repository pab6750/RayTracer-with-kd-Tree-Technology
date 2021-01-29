import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		/*Canvas canvas = new Canvas(5);

		System.out.println(canvas.canvasToPPM());*/

		/*Matrix m1 = new Matrix(4);
		Matrix m2 = new Matrix(4);

		double[][] d1 = {{1,2,3,4},
				         {5,6,7,8},
				         {9,0,1,2},
				         {3,4,5,6}};

		double[][] d2 = {{1,2,3,4},
				         {5,6,7,8},
				         {9,0,1,2},
				         {3,4,5,6}};

		m1.setMatrix(d1);
		m2.setMatrix(d2);*/

		/*System.out.println("are equals: " + m1.equals(m2));

		double[][] d3 = {{1,2,3,4},
				         {5,6,7,8},
				         {9,8,7,6},
				         {5,4,3,2}};

		double[][] d4 = {{-2,1,2,3},
				         {3,2,1,-1},
				         {4,3,6,5},
				         {1,2,7,8}};

		m1.setMatrix(d3);
		m2.setMatrix(d4);

		m1.setMatrix(m1.matrixMultiplication(m2));
		m1.printData();*/

		/*Tuple t = new Tuple(1,2,3,1);

		double[][] d5 = {{1,2,3,4},
				         {2,4,4,2},
				         {8,6,4,1},
				         {0,0,0,1}};

		m1.setMatrix(d5);

		Tuple result = m1.tupleMultiplication(t);

		result.printData();*/

		/*m1.setIdentityMatrix();
		m1.printData();*/

		/*Matrix m3 = new Matrix(4);
		m3.setMatrix(m1.transposition());
		m1.printData();
		System.out.println("----------------");
		m3.printData();*/

		/*double[][] d6 = {{3,5,0},
				         {2,-1,-7},
				         {6,-1,5}};

		Matrix m4 = new Matrix(3);
		m4.setMatrix(d6);

		m4.getSubmatrix(1, 0).printData();

		System.out.println("--------------");

		System.out.println("minor: " + m4.getMinor(1, 0));
		System.out.println("cofactor: " + m4.getCofactor(1, 0));*/

		/*double[][] d6 = {{1,2,6},
				         {-5,8,-4},
				         {2,6,4}};

		Matrix m5 = new Matrix(3);
		m5.setMatrix(d6);

		System.out.println("cofactor(0,0): " + m5.getCofactor(0, 0));
		System.out.println("cofactor(0,1): " + m5.getCofactor(0, 1));
		System.out.println("cofactor(0,2): " + m5.getCofactor(0, 2));
		System.out.println("cofactor(2,2): " + m5.getCofactor(2, 2));
		System.out.println("Determinant: " + m5.getDeterminant());

		Matrix testMatrix = m5.getSubmatrix(0, 2);
		testMatrix.printData();*/

		/*double[][] d7 = {{-2,-8,3,5},
		         		 {-3,1,7,3},
		         		 {1,2,-9,6},
		         		 {-6,7,7,-9}};

		Matrix m5 = new Matrix(4);
		m5.setMatrix(d7);

		System.out.println("Determinant: " + m5.getDeterminant());*/

		/*double[][] d8 = {{6,4,4,4},
        		 		   {5,5,7,6},
        		 		   {4,-9,3,-7},
        		 		   {9,1,7,-6}};

		double[][] d9 = {{-4,2,-2,-3},
        		 		 {9,6,2,6},
        		 		 {0,-5,1,-5},
        		 		 {0,0,0,0}};

		Matrix m6 = new Matrix(4);
		m6.setMatrix(d8);

		System.out.println("Determinant: " + m6.getDeterminant());
		System.out.println("Is invertible: " + m6.isInvertible());

		m6.setMatrix(d9);

		System.out.println("Determinant: " + m6.getDeterminant());
		System.out.println("Is invertible: " + m6.isInvertible());*/

		/*double[][] d8 = {{-5,2,6,-8},
		 		   		 {1,-5,1,8},
		 		   		 {7,7,-6,-7},
		 		   		 {1,-3,7,4}};

		Matrix m7 = new Matrix(4);
		m7.setMatrix(d8);

		Matrix invertedMatrix = m7.invert();
		invertedMatrix.printData();*/

		/*double[][] d1 = {{3,-9,7,3},
		   		 		 {3,-8,2,-9},
		   		 		 {-4,4,4,1},
		   		 		 {-6,5,-1,1}};

		double[][] d2 = {{8,2,2,2},
  		 		 		 {3,-1,7,0},
  		 		 		 {7,0,5,4},
  		 		 		 {6,5,0,5}};

		Matrix m1 = new Matrix(4);
		Matrix m2 = new Matrix(4);

		m1.setMatrix(d1);
		m2.setMatrix(d2);

		Matrix multiplicatedMatrix = m1.matrixMultiplication(m2);

		Matrix inversionResult = m2.invert();
		Matrix result = multiplicatedMatrix.matrixMultiplication(inversionResult);
		result.printData();*/

		/*Matrix transform = Matrix.translation(5, -3, 2);
		Tuple p = new Tuple(-3, 4, 5, Tuple.POINT);

		Tuple result = transform.tupleMultiplication(p);
		result.printData();*/

		/*Matrix transform = Matrix.translation(5, -3, 2);
		Matrix inverse = transform.invert();
		Tuple p = new Tuple(-3, 4, 5, Tuple.POINT);

		Tuple result = inverse.tupleMultiplication(p);
		result.printData();*/

		/*Matrix transform = Matrix.translation(5, -3, 2);
		Tuple p = new Tuple(-3, 4, 5, Tuple.VECTOR);

		Tuple result = transform.tupleMultiplication(p);
		result.printData();*/

		/*Matrix transform = Matrix.scaling(2, 3, 4);
		Tuple p = new Tuple(-4, 6, 8, Tuple.POINT);
		Tuple result = transform.tupleMultiplication(p);
		result.printData();*/

		/*Matrix transform = Matrix.scaling(2, 3, 4);
		Tuple p = new Tuple(-4, 6, 8, Tuple.VECTOR);
		Tuple result = transform.tupleMultiplication(p);
		result.printData();*/

		/*Matrix halfQuarter = Matrix.rotationX(Math.PI / 4);
		Matrix fullQuarter = Matrix.rotationX(Math.PI / 2);
		Tuple p = new Tuple(0, 1, 0, Tuple.POINT);

		Tuple halfQuarterSolution = halfQuarter.tupleMultiplication(p);
		Tuple fullQuarterSolution = fullQuarter.tupleMultiplication(p);

		halfQuarterSolution.printData();
		System.out.println("--------------");
		fullQuarterSolution.printData();*/

		/*Matrix halfQuarter = Matrix.rotationY(Math.PI / 4);
		Matrix fullQuarter = Matrix.rotationY(Math.PI / 2);
		Tuple p = new Tuple(0, 0, 1, Tuple.POINT);

		Tuple halfQuarterSolution = halfQuarter.tupleMultiplication(p);
		Tuple fullQuarterSolution = fullQuarter.tupleMultiplication(p);

		halfQuarterSolution.printData();
		System.out.println("--------------");
		fullQuarterSolution.printData();*/

		/*Matrix halfQuarter = Matrix.rotationZ(Math.PI / 4);
		Matrix fullQuarter = Matrix.rotationZ(Math.PI / 2);
		Tuple p = new Tuple(0, 1, 0, Tuple.POINT);

		Tuple halfQuarterSolution = halfQuarter.tupleMultiplication(p);
		Tuple fullQuarterSolution = fullQuarter.tupleMultiplication(p);

		halfQuarterSolution.printData();
		System.out.println("--------------");
		fullQuarterSolution.printData();*/

		/*Tuple origin = new Tuple(2, 3, 4, Tuple.POINT);
		Tuple direction = new Tuple(1, 0, 0, Tuple.VECTOR);

		Ray ray = new Ray(origin, direction);

		ray.position(2.5).printData();*/

		/*Tuple origin = new Tuple(0, 0, 5, Tuple.POINT);
		Tuple direction = new Tuple(0, 0, 1, Tuple.VECTOR);

		Ray r = new Ray(origin, direction);

		Sphere s = new Sphere();

		double[] intersectionPoints = s.intersect(r);

		if(intersectionPoints != null) {
			System.out.println("p1: " + intersectionPoints[0]);
			System.out.println("p2: " + intersectionPoints[1]);
		} else {
			System.out.println("The ray misses the sphere");
		}*/

		/*Tuple origin = new Tuple(0, 0, -5, Tuple.POINT);
		Tuple direction = new Tuple(0, 0, 1, Tuple.VECTOR);

		Ray r = new Ray(origin, direction);

		Sphere s = new Sphere();

		Intersection[] intersectionPoints = s.intersect(r);

		intersectionPoints[0].printData();
		intersectionPoints[1].printData();*/

		/*Sphere s = new Sphere();

		Intersection i1 = new Intersection(2, s);
		Intersection i2 = new Intersection(1, s);
		Intersection[] set = {i1,i2};

		Intersection[] xs = Intersection.intersections(set);

		Intersection i = Intersection.hit(xs);

		System.out.println(xs[0].getT());
		System.out.println(xs[1].getT());

		i.printData();*/

		/*Sphere s = new Sphere();

		Intersection i1 = new Intersection(5, s);
		Intersection i2 = new Intersection(7, s);
		Intersection i3 = new Intersection(-3, s);
		Intersection i4 = new Intersection(2, s);

		Intersection[] xs = {i1, i2, i3, i4};

		xs = Intersection.intersections(xs);

		Intersection i = Intersection.hit(xs);
		i.printData();*/

		/*Tuple origin = new Tuple(1, 2, 3, Tuple.POINT);
		Tuple direction = new Tuple(0, 1, 0, Tuple.VECTOR);

		Ray r = new Ray(origin, direction);

		Matrix m = Matrix.scaling(2, 3, 4);

		Ray transformedRay = r.transform(m);

		transformedRay.getOrigin().printData();
		transformedRay.getDirection().printData();*/

		/*Sphere s = new Sphere();

		Matrix m1 = s.getTransformation();
		m1.printData();

		System.out.println("--------------");

		Matrix m2 = Matrix.translation(2, 3, 4);
		s.setTransformation(m2);

		s.getTransformation().printData();*/

		/*Tuple origin = new Tuple(0, 0, -5, Tuple.POINT);
		Tuple direction = new Tuple(0, 0, 1, Tuple.VECTOR);

		Ray r = new Ray(origin, direction);

		Sphere s = new Sphere();

		Matrix m = Matrix.translation(5, 0, 0);

		s.setTransformation(m);

		Intersection[] xs = s.intersect(r);

		if(xs != null) {
			System.out.println("xs[0]: " + xs[0].getT());
			System.out.println("xs[1]: " + xs[1].getT());
		} else {
			System.out.println("Array is empty");
		}*/

		//raySphereIntersectionTest();
		//raySphereIntersectionWithScalingTest();
		//normalVectorTest();
		//normalVectorTranslatedTest();
		//normalVectorTransformedTest();
	    //lightingTestEyeBetweenLightAndSurfaces();
		//lightingTestEye45DegreesOffNormal();
		//lightingTestLight45DegreesOffNormal();
		//lightingTestEyeInPathOfReflectionVector();
		//lightingTestLightBehindObject();
		//lightingTest();
		//raySphereIntersectionWithScalingTest();
		//normaliseTest();
		//lightingTest2();
		//intersectWorldTest();
		//isInsideTest();
		//isInsideTest2();
		//shadingIntersectionTest();
		//shadingIntersectionTest2();
		//rayMissesTest();
		//colourAtTest();
		//colourAtTest2();
		//orientationTest();
		//orientationTest2();
		//orientationTest3();
		//orientationTest4();
		//cameraTest();
		//cameraTest2();
		//cameraTest3();
		//renderTest();
		//sceneTest();
		//pointInShadowTest();
		//shadowTest();
		//shadowTest2();
		//shadowTest3();
		//shadowTest4();
		//shadowRenderTest();
		//wtfTest();
		//wtfTest2();
		//localNormalAtFunctionPlaneTest();
		//planeIntersectTest();
		//planeIntersectTest2();
		//planeIntersectTest3();
		//planeIntersectTest4();
		//sceneTest2();
		//sceneTest3();
		//patternTest();
		//patternTest3();
		//patternTest4();
		//patternTest5();
		//patternTest6();
		//patternTest7();
		//sceneTest5();
		//patternTest8();
		//patternTest9();
		//patternTest10();
		//patternTest13();
		//sceneTest6();
		//patternTest14();
		//reflectvTest();
		//nonreflectiveTest();
		//reflectiveTest();
		//reflectiveTest2();
		//sceneTest7();
		//refractionTest();
		//refractionTest7();
		//fresnelTest();
		//fresnelTest2();
		//fresnelTest3();
		//fresnelTest4();
		//sceneTest8();
		//visualTest();
		//cubeTest2();
		//sceneTest9();
		//cylinderTest();
		//cylinderTest2();
		//cylinderTest3();
		//cylinderTest4();
		//cylinderTest5();
		//cylinderTest6();
		//cylinderTest7();
		//cylinderTest8();
		//coneTest();
		//coneTest2();
		//coneTest3();
		//coneTest4();
		//iceCream();
		//groupTest2();
		//groupTest3();
		//groupTest4();
		//groupTest5();
		//groupTest6();
		//groupTest7();
		//groupTest8();
		//showcase();
		//coneNormalTest();
		//triangleTest();
		//triangleTest2();
		//triangleTest3();
		//triangleTest4();
		//triangleTest5();
		//triangleTest6();
		//triangleTest7();
		//triangleTest8();
		//triangleTest9();
		//triangleTest10();
		//triangleTest11();
		//groupVisualTest();
		//triangleVisualTest();
		//violinCaseTest();
		//smoothTriangleTest();
		//normalInterpolationTest();
		//smoothTriangleTest2();
		//smoothTriangleTest3();
		//smoothTriangleTest4();
		//spaceMesh();
		//boundingVolumesTest();
		//boundingVolumesTest2();
		//boundingVolumesTest3();
		//boundingVolumesTest4();
		//boundingVolumesTest5();
		//boundingVolumesTest6();
		//BVHTest();
		//xWideTest();
		//yWideTest();
		//zWideTest();
		//BVHTest2();
		//violinCaseTest2();
		//trumpetTest();
		//generalTest();
		//superReflectionTest();
		//finitePlaneTest();
		//finitePlaneWithRandomVerticesTest();
		//finitePlaneRotationTest();
		//regexTest();
		//teddybearTest();
		//manySpheres();
		//surfaceHeuristicValidationTest();
		//BBOXMaterialTest();
		//matricesChapterPic();
		//medianKDTreeConfigurationTest();
		//phongModelPicture();
		//classTest();
		//reflectionWorld();
		//surfaceAreaHeuristicRender();
		//surfaceAreaHeuristicRender2();
		//appendixImage1();
		//appendixImage2();
		//appendixImage3();
		//kdTreeTest();
		//kdTreeTest2();
		//sortingTest();
		//spatialTest();
		//trumpetTest();
		//kdTreeTest3();
		//spatialTest2();
		lakeSimulation();
		//kdTreeTest4();
		//bunnyTest();
        //appendixImage2();
	}

	public static void kdTreeTest4() {
		Sphere s0 = new Sphere();
		Sphere s1 = new Sphere();
 		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();

		Matrix t0 = Matrix.translation(-4, 0, -8);
		Matrix t1 = Matrix.translation(-3, 0, -6);
		Matrix t2 = Matrix.translation(-2, 0, -4);
		Matrix t3 = Matrix.translation(-1, 0, -2);
		Matrix t4 = Matrix.translation(0, 0, 0);

		s0.setTransformation(t0);
		s1.setTransformation(t1);
		s2.setTransformation(t2);
		s3.setTransformation(t3);
		s4.setTransformation(t4);

		Shape[] shapes = {s0, s1, s2, s3, s4};

		MedianKDTree kdt = new MedianKDTree(true, shapes, 0);
		kdt.build();

		Shape[] worldList = {kdt};

		World world = new World(200, 200);
		world.setObjs(worldList);
		world.renderWorld("medianResult4");
	}

	public static void lakeSimulation() {
		Plane water = new Plane();
		water.setDefaultRefractiveMaterial();
		water.getMaterial().setRefractiveIndex(Material.WATER);
		water.setColour(new Colour(0, 0, 1));

		Plane seaFloor = new Plane();
		seaFloor.setColour(new Colour(1, 0, 0));
		seaFloor.setTransformation(Matrix.translation(0, -0.2, 0));

		Cube cube = new Cube();
		Matrix c1 = Matrix.translation(0, 10, 150);
		Matrix c2 = Matrix.scaling(10, 100, 10);
		Matrix c3 = c1.matrixMultiplication(c2);
		cube.setTransformation(c3);

		Shape[] shapes = {water, seaFloor, cube};

		World world = new World(128, 128);
		world.setObjs(shapes);
		world.renderWorld("lakeSimulation");
	}

	public static void kdTreeTest3() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();
		Sphere s5 = new Sphere();
		Sphere s6 = new Sphere();
		Sphere s7 = new Sphere();
		Sphere s8 = new Sphere();
		Sphere s9 = new Sphere();
		Sphere s10 = new Sphere();
		Sphere s11 = new Sphere();
		Sphere s12 = new Sphere();
		Sphere s13 = new Sphere();
		Sphere s14 = new Sphere();
		Sphere s15 = new Sphere();
		Sphere s16 = new Sphere();
		Sphere s17 = new Sphere();
		Sphere s18 = new Sphere();
		Sphere s19 = new Sphere();
		Sphere s20 = new Sphere();
		Sphere s21 = new Sphere();
		Sphere s22 = new Sphere();
		Sphere s23 = new Sphere();
		Sphere s24 = new Sphere();
		Sphere s25 = new Sphere();

		s1.setTransformation(Matrix.translation(-5, 5, 0));
		s2.setTransformation(Matrix.translation(-3, 5, 0));
		s3.setTransformation(Matrix.translation(-1, 5, 0));
		s4.setTransformation(Matrix.translation(1, 5, 0));
		s5.setTransformation(Matrix.translation(3, 5, 0));
		s6.setTransformation(Matrix.translation(-5, 3, 0));
		s7.setTransformation(Matrix.translation(-3, 3, 0));
		s8.setTransformation(Matrix.translation(-1, 3, 0));
		s9.setTransformation(Matrix.translation(1, 3, 0));
		s10.setTransformation(Matrix.translation(3, 3, 0));
		s11.setTransformation(Matrix.translation(-5, 1, 0));
		s12.setTransformation(Matrix.translation(-3, 1, 0));
		s13.setTransformation(Matrix.translation(-1, 1, 0));
		s14.setTransformation(Matrix.translation(1, 1, 0));
		s15.setTransformation(Matrix.translation(3, 1, 0));
		s16.setTransformation(Matrix.translation(-5, -1, 0));
		s17.setTransformation(Matrix.translation(-3, -1, 0));
		s18.setTransformation(Matrix.translation(-1, -1, 0));
		s19.setTransformation(Matrix.translation(1, -1, 0));
		s20.setTransformation(Matrix.translation(3, -1, 0));
		s21.setTransformation(Matrix.translation(-5, -3, 0));
		s22.setTransformation(Matrix.translation(-3, -3, 0));
		s23.setTransformation(Matrix.translation(-1, -3, 0));
		s24.setTransformation(Matrix.translation(1, -3, 0));
		s25.setTransformation(Matrix.translation(3, -3, 0));

		Shape[] shapes = {s1, s2, s3, s4, s5,
						  s6, s7, s8, s9, s10,
						  s11, s12, s13, s14, s15,
						  s16, s17, s18, s19, s20,
						  s21, s22, s23, s24, s25};

		MedianKDTree kdt = new MedianKDTree(true, shapes, 0);
		kdt.build();

		Shape[] worldList = {kdt};

		World world = new World(200, 200);
		world.setObjs(worldList);
		world.renderWorld("medianResult3");
	}

	public static void bunnyTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\Bunny.obj");
		OBJParser p = new OBJParser(file);
		Shape[] shapes = p.getFaces();
		Shape[] shapesMinusNull = new Shape[shapes.length - 1];
		System.arraycopy(shapes, 1, shapesMinusNull, 0, shapes.length - 1);

		Matrix m = Matrix.scaling(2, 2, 2);

		for(int i = 0; i < shapesMinusNull.length; i++) {
			shapesMinusNull[i].setTransformation(m);
		}

		/*System.out.println("Building Process Started");
		MedianKDTree mkdt = MedianKDTree.createRoot(shapesMinusNull);
		mkdt.build();
		Shape[] objs = {mkdt};
		System.out.println("Building Process Ended");*/

		World world = new World(512, 512);
		world.setObjs(shapesMinusNull);

		world.renderWorld("bunny");
	}

	public static void trumpetTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\Trumpet.obj");
		OBJParser p = new OBJParser(file);
		Shape[] shapes = p.getFaces();
		Shape[] shapesMinusNull = new Shape[shapes.length - 1];
		System.arraycopy(shapes, 1, shapesMinusNull, 0, shapes.length - 1);

		//KDTree kdt = new KDTree(true, shapesMinusNull, 0);
		//kdt.buildWithMedian();
		//Shape[] objs = {kdt};

		World world = new World(200, 200);
		world.setObjs(shapesMinusNull);

		world.renderWorld("trumpet");
	}

	public static void spatialTest() {
		Sphere s0 = new Sphere();
		Sphere s1 = new Sphere();
 		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();

		Matrix t0 = Matrix.translation(-3, 0, 0);
		Matrix t1 = Matrix.translation(-2, 0, 0);
		Matrix t2 = Matrix.translation(-1, 0, 0);
		Matrix t3 = Matrix.translation(1, 0, 0);
		Matrix t4 = Matrix.translation(2, 0, 0);

		s0.setTransformation(t0);
		s1.setTransformation(t1);
		s2.setTransformation(t2);
		s3.setTransformation(t3);
		s4.setTransformation(t4);

		Shape[] shapes = {s0, s1, s2, s3, s4};

		SpatialKDTree kdt = new SpatialKDTree(true, shapes, 0);
		kdt.build();
		kdt.printTreeWithData();
	}

	public static void spatialTest2() {
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

		SpatialKDTree kdt = new SpatialKDTree(true, shapes, 0);
		kdt.build();

		Shape[] worldList = {kdt};

		World world = new World(200, 200);
		world.setObjs(worldList);
		world.renderWorld("spatialResult1");
	}

	public static void kdTreeTest() {
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

		Shape[] worldList = {kdt};

		World world = new World(512, 512);
		world.setObjs(worldList);
		world.renderWorld("medianResult1");
	}

	public static void kdTreeTest2() {
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

		Shape[] worldList = {kdt};

		World world = new World(512, 512);
		world.setObjs(shapes);
		world.renderWorld("medianResult2");
	}

	public static void appendixImage3() {
		Plane plane = new Plane();

		Sphere sphere1 = new Sphere();

		Matrix s1 = Matrix.translation(0, 1, 0);

		sphere1.setTransformation(s1);
		sphere1.setDefaultRefractiveMaterial();

		Sphere sphere2 = new Sphere();
		sphere2.setDefaultReflectiveMaterial();

		Matrix s2 = Matrix.scaling(2, 2, 2);
		Matrix s3 = Matrix.translation(-2, 1, 0);
		sphere2.setTransformation(s2.matrixMultiplication(s3));

		Cube cube = new Cube();
		cube.setColour(new Colour(0, 1, 0));
		cube.getMaterial().setDiffuse(0);
		cube.getMaterial().setTransparency(0.9);

		Matrix c1 = Matrix.translation(3, 1, 0);
		Matrix c2 = Matrix.rotationY(Math.PI / 4);

		cube.setTransformation(c1.matrixMultiplication(c2));

		Shape[] shapes = {plane, sphere1, sphere2, cube};

		World world = new World();
		world.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void appendixImage2() {
		Plane plane = new Plane();

		Sphere sphere1 = new Sphere();
		Colour cs = new Colour(1, 0, 0);

		Matrix s1 = Matrix.translation(0, 1, 0);

		sphere1.setTransformation(s1);
		sphere1.setColour(cs);

		Sphere sphere2 = new Sphere();
		sphere2.setColour(cs);

		Matrix s2 = Matrix.scaling(2, 2, 2);
		Matrix s3 = Matrix.translation(-2, 1, 0);
		sphere2.setTransformation(s2.matrixMultiplication(s3));

		Cube cube = new Cube();
		cube.setColour(new Colour(0, 1, 0));

		Matrix c1 = Matrix.translation(3, 1, 0);
		Matrix c2 = Matrix.rotationY(Math.PI / 4);

		cube.setTransformation(c1.matrixMultiplication(c2));

		Shape[] shapes = {plane, sphere1, sphere2, cube};

		World world = new World();
		world.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(256, 256, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void appendixImage1() {
		Plane plane = new Plane();

		Sphere sphere = new Sphere();
		Colour cs = new Colour(1, 0, 0);

		Matrix s = Matrix.translation(0, 1, 0);

		sphere.setTransformation(s);
		sphere.setColour(cs);

		Cube cube = new Cube();
		Colour cc = new Colour(0, 1, 0);

		Matrix c = Matrix.translation(-3, 1, 0);

		cube.setTransformation(c);
		cube.setColour(cc);

		Coordinate p1 = new Coordinate(2, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(5, 1, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(4, 3, 0, Coordinate.POINT);

		Triangle triangle = new Triangle(p1, p2, p3);
		Colour ct = new Colour(0, 0, 1);
		triangle.setColour(ct);

		Shape[] shapes = {plane, sphere, cube, triangle};

		World world = new World();
		world.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void surfaceAreaHeuristicRender2() {
		AABB sceneBox = new AABB(null);
		Cube[] cubes = new Cube[100];

		for(int i = 0; i < cubes.length; i++) {
			cubes[i] = new Cube();

			Matrix transformationMatrix;

			double lowerBound = 0.3;
			double upperBound = 1;

			double index = i;
			double total = cubes.length;

			double scaling = ((upperBound - lowerBound) * (index / total)) + lowerBound;
			Matrix scalingMatrix = Matrix.scaling(scaling, scaling, scaling);

			double max = 10;
			double min = -10;
			double randomX = Math.random() * (max - min + 1) + min;
			double randomY = Math.random() * (max - min + 1) + min;
			double randomZ = Math.random() * (max - min + 1) + min;

			Matrix translationMatrix = Matrix.translation(randomX, randomY, randomZ);

			transformationMatrix = translationMatrix.matrixMultiplication(scalingMatrix);

			double maxColour = 10;
			double minColour = -10;
			double randomR = Math.random() * (maxColour - minColour + 1) + minColour;
			double randomG = Math.random() * (maxColour - minColour + 1) + minColour;
			double randomB = Math.random() * (maxColour - minColour + 1) + minColour;

			Colour randomColour = new Colour(randomR, randomG, randomB);

			cubes[i].setColour(randomColour);

			if(transformationMatrix.isInvertible()){
				cubes[i].setTransformation(transformationMatrix);
			} else {
				cubes[i].setTransformation(translationMatrix);
			}
		}

		Group g = new Group();
		g.setShapes(cubes);
		g.divide(2);

		for(int i = 0; i < cubes.length; i++) {
			sceneBox.addBox(cubes[i].getBounds());
		}

		//Plane plane = new Plane();
		//Matrix t = Matrix.translation(0, -1, 0);
		//plane.setTransformation(t);

		Shape[] shapes = {g/*, plane*/};

		World world = new World();
		world.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -20, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void surfaceAreaHeuristicRender() {
		AABB sceneBox = new AABB(null);
		Cube[] cubes = new Cube[100];
		int[] values = new int[cubes.length];

		int invertibles = 0;
		int noninvertibles = 0;

		//mapping[i]=((i2-i1)*(t[i]/Size))+i1
		//range (-5,5)
		for(int i = 0; i < cubes.length; i++) {
			values[i] = 0;
			cubes[i] = new Cube();
			Matrix transformationMatrix;

			double lowerBound = 0;
			double upperBound = 10;

			double index = i;
			double total = cubes.length;

			double scaling = ((upperBound - lowerBound) * (index / total)) + lowerBound;
			Matrix scalingMatrix = Matrix.scaling(scaling, scaling, scaling);

			double max = 10;
			double min = -10;
			double randomX = Math.random() * (max - min + 1) + min;
			double randomY = Math.random() * (max - min + 1) + min;
			double randomZ = 0;

			Matrix translationMatrix = Matrix.translation(randomX, randomY, randomZ);

			transformationMatrix = translationMatrix.matrixMultiplication(scalingMatrix);

			if(transformationMatrix.isInvertible()){
				cubes[i].setTransformation(transformationMatrix);
				invertibles++;
			} else {
				cubes[i].setTransformation(translationMatrix);
				noninvertibles++;
			}

		}

		Group g = new Group();
		g.setShapes(cubes);
		g.divide(2);

		for(int i = 0; i < cubes.length; i++) {
			sceneBox.addBox(cubes[i].getBounds());
		}

		Shape[] shapes = {g};

		World world = new World();
		world.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-20, 20, -20, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -20, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");

	}

	public static void reflectionWorld() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setReflective(0.5);

		Plane leftWall = new Plane();
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);
		leftWall.setDefaultReflectiveMaterial();

		Plane rightWall = new Plane();
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);
		rightWall.setDefaultReflectiveMaterial();

		Sphere middle = new Sphere();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		middle.setColour(new Colour(0.5, 0.5, 0.5));
		middle.getMaterial().setReflective(1);

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.setDefaultReflectiveMaterial();

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.setDefaultReflectiveMaterial();

		Shape[] objs = {floor, leftWall, rightWall, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void phongModelPicture() {
		World world = new World();

		Sphere sphere = new Sphere();
		sphere.setColour(new Colour(0, 1, 0));

		Matrix t = Matrix.translation(0, 1, 0);
		Matrix s = Matrix.scaling(2, 2, 2);
		Matrix matrix = t.matrixMultiplication(s);

		sphere.setTransformation(matrix);

		Shape[] objs = {sphere};

		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void medianKDTreeConfigurationTest() {
		World world = new World();

		Sphere sphere1 = new Sphere();
		Sphere sphere2 = new Sphere();
		Sphere sphere3 = new Sphere();

		Matrix matrix1 = Matrix.translation(-1, 0, 0);
		Matrix matrix2 = Matrix.translation(0, 1, 0);
		Matrix matrix3 = Matrix.translation(1, 0, 0);

		sphere1.setTransformation(matrix1);
		sphere2.setTransformation(matrix2);
		sphere3.setTransformation(matrix3);

		AABB box1 = sphere1.getBounds().transform(sphere1.getTransformation());
		AABB box2 = sphere2.getBounds().transform(sphere2.getTransformation());
		AABB box3 = sphere3.getBounds().transform(sphere3.getTransformation());

		Shape[] shapes = {sphere1, sphere2, sphere3};
		world.setObjs(shapes);

		MedianKDTree kdt = MedianKDTree.createRoot(shapes);
		kdt.setShapes(shapes);

		Coordinate[] t = new Coordinate[6];
		t[0] = box1.getMin();
		t[1] = box1.getMax();
		t[2] = box2.getMin();
		t[3] = box2.getMax();
		t[4] = box3.getMin();
		t[5] = box3.getMax();
		//Tuple[] t = kdt.sortBoundingExtentsByX();

		for(int i = 0; i < t.length; i++) {
			t[i].printData();
		}
	}

	public static void matricesChapterPic() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Cube cube1 = new Cube();
		Matrix t1 = Matrix.translation(-2, 1, 0);
		cube1.setTransformation(t1);
		cube1.setColour(new Colour(1, 0, 0));

		Cube cube2 = new Cube();
		Matrix t2 = Matrix.translation(0, 1, 0);
		Matrix s1 = Matrix.scaling(0.5, 0.5, 0.5);
		Matrix f1 = t2.matrixMultiplication(s1);
		cube2.setTransformation(f1);
		cube2.setColour(new Colour(0, 0, 1));

		Cube cube3 = new Cube();
		Matrix t3 = Matrix.translation(2, 1, 0);
		Matrix s2 = Matrix.scaling(0.7, 0.7, 0.7);
		Matrix ro1 = Matrix.rotationZ(Math.PI / 4);
		Matrix f2 = t3.matrixMultiplication(ro1).matrixMultiplication(s2);
		cube3.setTransformation(f2);
		cube3.setColour(new Colour(0, 1, 0));

		Shape[] objs = {floor, leftWall, rightWall, cube1, cube2, cube3};

		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void BBOXMaterialTest() {
		Plane floor = new Plane();

		Plane leftWall = new Plane();
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Sphere s = new Sphere();
		Matrix sphereMatrix = Matrix.translation(0, 1, 0);
		s.setTransformation(sphereMatrix);
		Colour red = new Colour(1, 0, 0);
		s.setColour(red);

		AABB box = s.getBounds();
		box.setTransformation(sphereMatrix);
		box.showBox();

		Shape[] objs = {floor, leftWall, rightWall, s, box};

		World world = new World(512, 512);
		world.setObjs(objs);
		world.renderWorld("boxVisualization");
	}

	public static void classTest() {
		Sphere s = new Sphere();

		System.out.println(s.getClass().getName());
	}

	public static void surfaceHeuristicValidationTest() {
		AABB sceneBox = new AABB(null);
		Cube[] cubes = new Cube[100];
		int[] values = new int[cubes.length];

		int invertibles = 0;
		int noninvertibles = 0;

		//mapping[i]=((i2-i1)*(t[i]/Size))+i1
		//range (-5,5)
		for(int i = 0; i < cubes.length; i++) {
			values[i] = 0;
			cubes[i] = new Cube();
			Matrix transformationMatrix;

			double lowerBound = 0;
			double upperBound = 10;

			double index = i;
			double total = cubes.length;

			double scaling = ((upperBound - lowerBound) * (index / total)) + lowerBound;
			Matrix scalingMatrix = Matrix.scaling(scaling, scaling, scaling);

			double max = 10;
			double min = -10;
			double randomX = Math.random() * (max - min + 1) + min;
			double randomY = Math.random() * (max - min + 1) + min;
			double randomZ = Math.random() * (max - min + 1) + min;

			Matrix translationMatrix = Matrix.translation(randomX, randomY, randomZ);

			transformationMatrix = translationMatrix.matrixMultiplication(scalingMatrix);

			if(transformationMatrix.isInvertible()){
				cubes[i].setTransformation(transformationMatrix);
				invertibles++;
			} else {
				cubes[i].setTransformation(translationMatrix);
				noninvertibles++;
			}

		}

		Group g = new Group();
		g.setShapes(cubes);
		g.divide(2);

		for(int i = 0; i < cubes.length; i++) {
			sceneBox.addBox(cubes[i].getBounds());
		}

		int missedCount = 0;

		for(int i = 0; i < 100000; i++) {
			//z = -20, x = - 15/15, y = -15/15

			double max = 15;
			double min = -15;

			double randomOriginX = Math.random() * (max - min + 1) + min;
			double randomOriginY = Math.random() * (max - min + 1) + min;

			Coordinate rayOrigin = new Coordinate(randomOriginX, randomOriginY, -1);

			double randomDirectionX = Math.random() * (max - min + 1) + min;
			double randomDirectionY = Math.random() * (max - min + 1) + min;

			Coordinate rayDirection = new Coordinate(randomDirectionX, randomDirectionY, 20);

			Ray ray = new Ray(rayOrigin, rayDirection);

			Intersection[] xs = g.intersect(ray);

			/*if(xs != null) {
				for(int k = 0; k < xs.length; k++) {
					int id = xs[k].getObject().getId() - 1;
					values[id]++;
				}
			} else {
				missedCount++;
			}*/

			System.out.println(i + " rays are done");
		}

		System.out.println("invertibles: " + invertibles);
		System.out.println("noninvertibles: " + noninvertibles);
		System.out.println("missed: " + missedCount);

	}

	public static void manySpheres() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Sphere[][] spheres = new Sphere[50][50];

		Group masterGroup = new Group("Master Group");
		Group[] children = new Group[50];

		for(int i = 0; i < spheres.length; i++) {
			children[i] = new Group("Child Group " + i);
			masterGroup.addChild(children[i]);

			for(int j = 0; j < spheres[i].length; j++) {
				spheres[i][j] = new Sphere();
				Matrix m = Matrix.translation((3 + i) - 25, 1, 3 + j);
				spheres[i][j].setTransformation(m);

				children[i].addChild(spheres[i][j]);
			}
		}

		Shape[] objs = {floor, masterGroup};

		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void teddybearTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\teddybear.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		group.divide(5);

		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(750, 750, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void regexTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\regexTest.txt");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());
		System.out.println(in.next());

		in.close();
	}

	public static void smoothTriangleTest4() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest6.obj");
		OBJParser p = new OBJParser(file);

		Group g = p.getMasterGroup();
		Shape t1 = g.getShapes()[0];
		Shape t2 = g.getShapes()[1];

		t1.printData();
		System.out.println("-------------");
		t2.printData();
	}

	public static void smoothTriangleTest3() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);
		Coordinate n1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate n2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate n3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		SmoothTriangle tri = new SmoothTriangle(p1, p2, p3, n1, n2, n3);

		Intersection i = new Intersection(1, tri, 0.45, 0.25);

		Intersection[] xs = {i};

		Coordinate rayOrigin = new Coordinate(-0.2, 0.3, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Computation c = new Computation(i, ray, xs);

		Coordinate n = c.getNormalv();

		n.printData();
	}

	public static void superReflectionTest() {
		World world = new World();
		Plane floor = new Plane();
		floor.setDefaultReflectiveMaterial();

		Plane leftWall = new Plane();
		leftWall.setDefaultReflectiveMaterial();
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.setDefaultReflectiveMaterial();
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Cube cube = new Cube();
		cube.setTransformation(Matrix.translation(-3, 1, 0));
		cube.setColour(new Colour(0.7, 0.1, 0.4));
		cube.setDefaultReflectiveMaterial();

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(3, 1, 0));
		ball.setDefaultReflectiveMaterial();

		Cone cone = new Cone(0, 1, true);
		cone.setDefaultReflectiveMaterial();

		Group group = new Group();
		group.addChild(cone);
		group.addChild(ball);
		group.addChild(cube);
		group.addChild(rightWall);
		group.addChild(leftWall);
		group.addChild(floor);


		Shape[] objs = {group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void generalTest() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Cube cube = new Cube();
		cube.setTransformation(Matrix.translation(-3, 1, 0));
		cube.setColour(new Colour(0.7, 0.1, 0.4));

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(3, 1, 0));

		Cone cone = new Cone(0, 1, true);
		cone.setDefaultRefractiveMaterial();

		Group group = new Group();
		group.addChild(cone);
		group.addChild(ball);
		group.addChild(cube);


		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void trumpetTest0() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\Trumpet.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		group.divide(5);

		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void violinCaseTest2() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\ViolinCase.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		group.divide(5);

		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void BVHTest2() {
		Sphere s1 = new Sphere();
		s1.setTransformation(Matrix.translation(-2, 0, 0));
		System.out.println("s1: " + s1);

		Sphere s2 = new Sphere();
		s2.setTransformation(Matrix.translation(2, 0, 0));
		System.out.println("s2: " + s2);

		Sphere s3 = new Sphere();
		System.out.println("s3: " + s3);

		Group group = new Group();

		group.addChild(s1);
		group.addChild(s2);
		group.addChild(s3);

		Shape[][] partition = group.partitionChildren();

		Shape[] p1 = partition[0];
		Shape[] p2 = partition[1];

		System.out.println("p1[0]: " + p1[0]);
		System.out.println("p2[0]: " + p2[0]);

		Shape[] remaining = group.getShapes();

		System.out.println("remaining[0]: " + remaining[0]);
	}

	public static void zWideTest() {
		Coordinate min = new Coordinate(-1, -2, -3, Coordinate.POINT);
		Coordinate max = new Coordinate(5, 3, 7, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.splitBounds();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void yWideTest() {
		Coordinate min = new Coordinate(-1, -2, -3, Coordinate.POINT);
		Coordinate max = new Coordinate(5, 8, 3, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.splitBounds();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void xWideTest() {
		Coordinate min = new Coordinate(-1, -2, -3, Coordinate.POINT);
		Coordinate max = new Coordinate(9, 5.5, 3, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.splitBounds();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void BVHTest() {
		Coordinate min = new Coordinate(-1, -4, -5, Coordinate.POINT);
		Coordinate max = new Coordinate(9, 6, 5, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.splitBounds();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void boundingVolumesTest6() {
		Coordinate min = new Coordinate(5, -2, 0, Coordinate.POINT);
		Coordinate max = new Coordinate(11, 4, 7, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		Coordinate point;
		Coordinate direction;
		Ray ray;
		Intersection[] xs;

		//1
		point = new Coordinate(15, 1, 2, Coordinate.POINT);
		direction = new Coordinate(-1, 0, 0, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//2
		point = new Coordinate(-5, -1, 4, Coordinate.POINT);
		direction = new Coordinate(1, 0, 0, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//3
		point = new Coordinate(7, 6, 5, Coordinate.POINT);
		direction = new Coordinate(0, -1, 0, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//4
		point = new Coordinate(9, -5, 6, Coordinate.POINT);
		direction = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//5
		point = new Coordinate(8, 2, 12, Coordinate.POINT);
		direction = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//6
		point = new Coordinate(6, 0, -5, Coordinate.POINT);
		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//7
		point = new Coordinate(8, 1, 3.5, Coordinate.POINT);
		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//8
		point = new Coordinate(9, -1, -8, Coordinate.POINT);
		direction = new Coordinate(2, 4, 6, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//9
		point = new Coordinate(8, 3, -4, Coordinate.POINT);
		direction = new Coordinate(6, 2, 4, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//10
		point = new Coordinate(9, -1, -2, Coordinate.POINT);
		direction = new Coordinate(4, 6, 2, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//11
		point = new Coordinate(4, 0, 9, Coordinate.POINT);
		direction = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//12
		point = new Coordinate(8, 6, -1, Coordinate.POINT);
		direction = new Coordinate(0, -1, 0, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}

		//13
		point = new Coordinate(12, 5, 4, Coordinate.POINT);
		direction = new Coordinate(-1, 0, 0, Coordinate.VECTOR);
		direction = direction.normalize();
		ray = new Ray(point, direction);
		xs = box.intersect(ray);

		if(xs != null) {
			System.out.println("NOT EMPTY");
		} else {
			System.out.println("EMPTY");
		}
	}

	public static void boundingVolumesTest5() {
		Sphere s = new Sphere();
		Matrix m = Matrix.translation(2, 5, -3).matrixMultiplication(Matrix.scaling(2, 2, 2));
		s.setTransformation(m);

		Cylinder c = new Cylinder();

		c.setMinimum(-2);
		c.setMaximum(2);
		Matrix m2 = Matrix.translation(-4, -1, 4).matrixMultiplication(Matrix.scaling(0.5, 1, 0.5));
		c.setTransformation(m2);

		Group g = new Group();

		g.addChild(s);
		g.addChild(c);

		AABB box = g.getBounds();

		box.getMin().printData();
		box.getMax().printData();
	}

	public static void boundingVolumesTest4() {
		Sphere s = new Sphere();
		Matrix m = Matrix.translation(1, -3, 5).matrixMultiplication(Matrix.scaling(0.5, 2, 4));
		s.setTransformation(m);

		AABB box = s.parentSpaceBoundsOf();

		box.getMin().printData();
		box.getMax().printData();
	}

	public static void boundingVolumesTest3() {
		Coordinate min = new Coordinate(-1, -1, -1, Coordinate.POINT);
		Coordinate max = new Coordinate( 1,  1,  1, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		Matrix matrix = Matrix.rotationX(Math.PI / 4).matrixMultiplication(Matrix.rotationY(Math.PI / 4));

		box.transform(matrix);

		box.getMin().printData();
		box.getMax().printData();
	}

	public static void boundingVolumesTest2() {
		Coordinate min1 = new Coordinate(-5, -2, 0, Coordinate.POINT);
		Coordinate min2 = new Coordinate(8, -7, -2, Coordinate.POINT);
		Coordinate max1 = new Coordinate(7, 4, 4, Coordinate.POINT);
		Coordinate max2 = new Coordinate(14, 2, 8, Coordinate.POINT);

		AABB b1 = new AABB(min1, max1, null);
		AABB b2 = new AABB(min2, max2, null);

		b1.addBox(b2);

		b1.getMin().printData();
		b1.getMax().printData();
	}

	public static void boundingVolumesTest() {
		AABB box = new AABB(null);

		Coordinate p1 = new Coordinate(-5, 2, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(7, 0, -3, Coordinate.POINT);

		box.addPoint(p1);
		box.addPoint(p2);

		box.getMin().printData();
		box.getMax().printData();
	}

	public static void spaceMesh() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\Space.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 1, 1));
		group.setTransformation(Matrix.translation(0, 1, 0).matrixMultiplication(Matrix.rotationX(-Math.PI / 2)));

		World world = new World();
		Plane floor = new Plane();
		floor.setTransformation(Matrix.translation(0, -6, 0));
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 15).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 15);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -15, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void smoothTriangleTest2() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest4.obj");
		OBJParser p = new OBJParser(file);

		Coordinate[] normals = p.getNormals();

		for(int i = 1; i < normals.length; i++) {
			normals[i].printData();
			System.out.println("------------");
		}
	}

	public static void normalInterpolationTest() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);
		Coordinate n1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate n2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate n3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		SmoothTriangle tri = new SmoothTriangle(p1, p2, p3, n1, n2, n3);

		Intersection i = new Intersection(1, tri, 0.45, 0.25);
		Coordinate n = tri.normalAt(new Coordinate(0, 0, 0, Coordinate.POINT), i);

		n.printData();
	}

	public static void smoothTriangleTest() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);
		Coordinate n1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate n2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate n3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		SmoothTriangle tri = new SmoothTriangle(p1, p2, p3, n1, n2, n3);

		Coordinate rayOrigin = new Coordinate(-0.2, 0.3, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = tri.localIntersect(ray);

		System.out.println("u: " + xs[0].getU());
		System.out.println("v: " + xs[0].getV());
	}

	public static void violinCaseTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\ViolinCase.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void triangleTest11() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\Diamond.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Shape[] objs = {floor, rightWall, leftWall, group};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void triangleVisualTest() {
		Coordinate v1 = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate v2 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate v3 = new Coordinate(1, 1, 0, Coordinate.POINT);
		Coordinate v4 = new Coordinate(0, 1, 1, Coordinate.POINT);
		Coordinate v5 = new Coordinate(1, 1, 1, Coordinate.POINT);
		Coordinate v6 = new Coordinate(0, 1, 0, Coordinate.POINT);

		Triangle t1 = new Triangle(v1, v2, v3);
		Triangle t2 = new Triangle(v1, v2, v4);
		Triangle t3 = new Triangle(v1, v4, v5);
		Triangle t4 = new Triangle(v1, v3, v5);
		Triangle t5 = new Triangle(v2, v3, v6);
		Triangle t6 = new Triangle(v2, v4, v6);
		Triangle t7 = new Triangle(v4, v5, v6);
		Triangle t8 = new Triangle(v3, v5, v6);

		World world = new World();
		Plane floor = new Plane();

		Shape[] objs = {floor, t1, t2, t3, t4, t5, t6, t7, t8};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(0, 10, 0, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 2, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void groupVisualTest() {
		World world = new World();
		Plane floor = new Plane();

		Group g = new Group();

		Sphere s = new Sphere();
		s.setTransformation(Matrix.translation(2, 0, 0));

		Sphere s2 = new Sphere();

		g.addChild(s);
		g.addChild(s2);

		Shape[] objs = {floor, g};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(0, 10, 0, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void triangleTest10() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest3.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		Shape[] t = group.getShapes();

		for(int i = 0; i < group.getShapes().length; i++) {
			t[i].printData();
			System.out.println("-------");
		}
	}

	public static void triangleTest9() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest3.obj");
		OBJParser p = new OBJParser(file);

		Group g1 = null;
		Group g2 = null;

		Group[] groups = p.getGroups();

		for(int i = 0; i < groups.length; i++) {
			if(groups[i].getName().equals("FirstGroup")) {
				g1 = groups[i];
			}

			if(groups[i].getName().equals("SecondGroup")) {
				g2 = groups[i];
			}
		}

		System.out.println(g1.getName() + ":");
		Shape[] t = g1.getShapes();

		for(int i = 0; i < g1.getShapes().length; i++) {
			t[i].printData();
		}

		System.out.println(g2.getName() + ":");
		Shape[] t2 = g2.getShapes();

		for(int i = 0; i < g1.getShapes().length; i++) {
			t2[i].printData();
		}
	}

	public static void triangleTest8() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest2.obj");
		OBJParser p = new OBJParser(file);

		Shape[] t = p.getFaces();

		System.out.println("l: " + t.length);

		for(int i = 1; i < t.length; i++) {
			System.out.println("t[" + i + "]");
			t[i].printData();
		}
	}

	public static void triangleTest7() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest.obj");
		OBJParser p = new OBJParser(file);

		Shape[] t = p.getFaces();

		System.out.println("l: " + t.length);

		for(int i = 1; i < t.length; i++) {
			System.out.println("t[" + i + "]");
			t[i].printData();
		}
	}

	public static void triangleTest6() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest.obj");
		OBJParser p = new OBJParser(file);

		Coordinate[] v = p.getVertices();

		System.out.println("l:" + v.length);

		for(int i = 1; i < v.length; i++) {
			v[i].printData();
			System.out.println("-----------");
		}
	}

	public static void triangleTest5() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		Triangle t = new Triangle(p1, p2, p3);

		Coordinate rayOrigin = new Coordinate(0, 0.5, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray r = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = t.localIntersect(r);

		System.out.println("xs: " + xs[0].getT());
	}

	public static void triangleTest4() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		Triangle t = new Triangle(p1, p2, p3);

		Coordinate rayOrigin = new Coordinate(0, -1, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray r = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = t.localIntersect(r);

		System.out.println(xs == null);
	}

	public static void triangleTest3() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		Triangle t = new Triangle(p1, p2, p3);

		Coordinate rayOrigin = new Coordinate(-1, 1, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray r = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = t.localIntersect(r);

		System.out.println(xs == null);
	}

	public static void triangleTest2() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		Triangle t = new Triangle(p1, p2, p3);

		Coordinate rayOrigin = new Coordinate(1, 1, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray r = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = t.localIntersect(r);

		System.out.println(xs == null);
	}

	public static void triangleTest() {
		Coordinate p1 = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate p2 = new Coordinate(-1, 0, 0, Coordinate.POINT);
		Coordinate p3 = new Coordinate(1, 0, 0, Coordinate.POINT);

		Triangle t = new Triangle(p1, p2, p3);

		Coordinate rayOrigin = new Coordinate(0, -1, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);

		Ray r = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = t.localIntersect(r);

		System.out.println(xs == null);
	}

	public static void coneNormalTest() {
		World world = new World();
		Plane floor = new Plane();

		Plane leftWall = new Plane();
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Cone cone = new Cone(-1, 1, true);
		cone.setTransformation(Matrix.translation(0, 2, 0));


		Shape[] objs = {floor, rightWall, leftWall, cone};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void showcase() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		//floor.getMaterial().setReflective(0.5);

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Cube cube = new Cube();
		cube.setTransformation(Matrix.translation(-3, 1, 0));
		cube.setColour(Colour.WHITE);
		cube.getMaterial().setDiffuse(0);
		cube.getMaterial().setTransparency(0.8);
		cube.getMaterial().setRefractiveIndex(Material.DIAMOND);

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(3, 1, 0));
		ball.getMaterial().setDiffuse(0);
		ball.getMaterial().setTransparency(0.8);
		ball.getMaterial().setRefractiveIndex(Material.DIAMOND);
		Cone cone = new Cone(0, 1, true);
		cone.setTransformation(Matrix.translation(0, 1, 0));


		Shape[] objs = {floor, cube, rightWall, leftWall, ball, cone};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void groupTest8() {
		Group g1 = new Group();
		g1.setTransformation(Matrix.rotationY(Math.PI / 2));

		Group g2 = new Group();
		g2.setTransformation(Matrix.scaling(1, 2, 3));

		g1.addChild(g2);

		Sphere s = new Sphere();
		s.setTransformation(Matrix.translation(5, 0, 0));
		g2.addChild(s);

		Coordinate n = s.normalAt(new Coordinate(1.7321, 1.1547, -5.5774, Coordinate.POINT), null);
		n.printData();
	}

	public static void groupTest7() {
		Group g1 = new Group();
		g1.setTransformation(Matrix.rotationY(Math.PI / 2));

		Group g2 = new Group();
		g2.setTransformation(Matrix.scaling(1, 2, 3));

		g1.addChild(g2);

		Sphere s = new Sphere();
		s.setTransformation(Matrix.translation(5, 0, 0));
		g2.addChild(s);

		Coordinate n = new Coordinate(Math.sqrt(3) / 3, Math.sqrt(3) / 3, Math.sqrt(3) / 3, Coordinate.VECTOR);
		Coordinate normal = s.normalToWorld(n);
		normal.printData();
	}

	public static void groupTest6() {
		Group g1 = new Group();
		g1.setTransformation(Matrix.rotationY(Math.PI / 2));

		Group g2 = new Group();
		g2.setTransformation(Matrix.scaling(2, 2, 2));

		g1.addChild(g2);

		Sphere s = new Sphere();
		s.setTransformation(Matrix.translation(5, 0, 0));
		g2.addChild(s);

		Coordinate p = s.worldToObject(new Coordinate(-2, 0, -10, Coordinate.POINT));
		p.printData();
	}

	public static void groupTest5() {
		Group group = new Group();
		group.setTransformation(Matrix.scaling(2, 2, 2));

		Sphere s = new Sphere();
		s.setTransformation(Matrix.translation(5, 0, 0));

		group.addChild(s);

		Coordinate rayOrigin = new Coordinate(10, 0, -10, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = group.intersect(ray);

		System.out.println(xs.length);
	}

	public static void groupTest4() {
		Group group = new Group();

		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		s2.setTransformation(Matrix.translation(0, 0, -3));
		Sphere s3 = new Sphere();
		s3.setTransformation(Matrix.translation(5, 0, 0));

		group.addChild(s1);
		group.addChild(s2);
		group.addChild(s3);

		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = group.localIntersect(ray);

		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		System.out.println("s3: " + s3);

		System.out.println("Length: " + xs.length);

		for(int i = 0; i < xs.length; i++) {
			System.out.println("xs[" + i + "]: " + xs[i].getObject());
		}
	}

	public static void groupTest3() {
		Group group = new Group();

		Coordinate rayOrigin = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = group.localIntersect(ray);

		if(xs == null) {
			System.out.println("EMPTY");
		}
	}

	public static void groupTest2() {
		Group group = new Group();
		Sphere s = new Sphere();

		group.addChild(s);

		Shape[] result = group.getShapes();

		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i].getId());
		}
	}

	public static void groupTest() {
		Group group = new Group();
		group.getTransformation().printData();
	}

	public static void iceCream() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		//floor.getMaterial().setReflective(0.5);

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Cube cube = new Cube();
		cube.setTransformation(Matrix.translation(-3, 1, 0));
		cube.setColour(new Colour(0.7, 0.1, 0.4));

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(0, 1, 0));


		Shape[] objs = {floor, cube, rightWall, leftWall, ball};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void coneTest4() {
		Cone cone = new Cone();
		Coordinate point;
		Coordinate n;

		point = new Coordinate(0, 0, 0, Coordinate.POINT);
		n = cone.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(1, 1, 1, Coordinate.POINT);
		n = cone.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(-1, -1, 0, Coordinate.POINT);
		n = cone.localNormalAt(point, null);
		n.printData();
	}

	public static void coneTest3() {
		Cone cone = new Cone(-0.5, 0.5, true);

		Coordinate origin;
		Coordinate direction;
		Ray r;
		Intersection[] xs;

		origin = new Coordinate(0, 0, -5, Coordinate.POINT);
		direction = new Coordinate(0, 1, 0, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("1: " + xs.length);

		origin = new Coordinate(0, 0, -0.25, Coordinate.POINT);
		direction = new Coordinate(0, 1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("2: " + xs.length);

		origin = new Coordinate(0, 0, -0.25, Coordinate.POINT);
		direction = new Coordinate(0, 1, 0, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("3: " + xs.length);
	}

	public static void coneTest2() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		floor.getMaterial().setReflective(0.5);

		Cone cone = new Cone(-1, 0, true);
		cone.setColour(new Colour(1, 0, 0));
		cone.setTransformation(Matrix.translation(0, 2, 0));

		Shape[] objs = {floor, cone};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 2, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void coneTest() {
		Cone cone = new Cone();
		Coordinate origin;
		Coordinate direction;
		Ray r;
		Intersection[] xs;

		origin = new Coordinate(0, 0, -5 ,Coordinate.POINT);
		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());

		origin = new Coordinate(0, 0, -5 ,Coordinate.POINT);
		direction = new Coordinate(1, 1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());

		origin = new Coordinate(1, 1, -5 ,Coordinate.POINT);
		direction = new Coordinate(-0.5, -1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());

		origin = new Coordinate(0, 0, -1 ,Coordinate.POINT);
		direction = new Coordinate(0, 1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cone.localIntersect(r);
		System.out.println("xs[0]: " + xs[0].getT());
	}

	public static void cylinderTest8() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		floor.getMaterial().setReflective(0.5);

		Cylinder cyl = new Cylinder(1, 2, true);
		cyl.setColour(new Colour(1, 0, 0));

		Shape[] objs = {floor, cyl};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 2, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void cylinderTest7() {
		Cylinder cyl = new Cylinder(1, 2, true);
		Coordinate point;
		Coordinate n;

		point = new Coordinate(0, 1, 0, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0.5, 1, 0, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0, 1, 0.5, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0, 2, 0, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0.5, 2, 0, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0, 2, 0.5, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();
	}

	public static void cylinderTest6() {
		Cylinder cyl = new Cylinder(1, 2, true);
		Coordinate direction;
		Coordinate origin;
		Ray r;
		Intersection[] xs;

		origin = new Coordinate(0, 3, 0, Coordinate.POINT);
		direction = new Coordinate(0, -1, 0, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);
		System.out.println("1: " + xs.length);

		origin = new Coordinate(0, 3, -2, Coordinate.POINT);
		direction = new Coordinate(0, -1, 2, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);
		System.out.println("2: " + xs.length);

		origin = new Coordinate(0, 4, -2, Coordinate.POINT);
		direction = new Coordinate(0, -1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);
		System.out.println("3: " + xs.length);

		origin = new Coordinate(0, 0, -2, Coordinate.POINT);
		direction = new Coordinate(0, 1, 2, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);
		System.out.println("4: " + xs.length);

		origin = new Coordinate(0, -1, -2, Coordinate.POINT);
		direction = new Coordinate(0, 1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);
		System.out.println("5: " + xs.length);
	}

	public static void cylinderTest5() {
		Cylinder cyl = new Cylinder(1, 2, false);
		Coordinate direction;
		Coordinate origin;
		Ray r;
		Intersection[] xs;

		direction = new Coordinate(0.1, 1, 0, Coordinate.VECTOR).normalize();
		origin = new Coordinate(0, 1.5, 0, Coordinate.POINT);
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		System.out.println("1: " + xs.length);

		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		origin = new Coordinate(0, 3, -5, Coordinate.POINT);
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		System.out.println("2: " + xs.length);

		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		origin = new Coordinate(0, 0, -5, Coordinate.POINT);
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		System.out.println("3: " + xs.length);

		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		origin = new Coordinate(0, 2, -5, Coordinate.POINT);
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		System.out.println("4: " + xs.length);

		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		origin = new Coordinate(0, 1, -5, Coordinate.POINT);
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		System.out.println("5: " + xs.length);

		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		origin = new Coordinate(0, 1.5, -2, Coordinate.POINT);
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		System.out.println("6: " + xs.length);
	}

	public static void cylinderTest4() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		floor.getMaterial().setReflective(0.5);

		Cylinder cyl = new Cylinder();
		cyl.setColour(new Colour(1, 0, 0));

		Shape[] objs = {floor, cyl};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 2, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void cylinderTest3() {
		Cylinder cyl = new Cylinder();

		Coordinate point;
		Coordinate n;

		point = new Coordinate(1, 0, 0, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0, 5, -1, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(0, -2, 1, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();

		point = new Coordinate(-1, 1, 0, Coordinate.POINT);
		n = cyl.localNormalAt(point, null);
		n.printData();
	}

	public static void cylinderTest2() {
		Cylinder cyl = new Cylinder();
		Coordinate direction;
		Coordinate origin;
		Ray r;
		Intersection[] xs;

		origin = new Coordinate(1, 0, -5, Coordinate.POINT);
		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		if(xs == null) {
			System.out.println("EMPTY");
		} else {
			System.out.println("xs[0]: " + xs[0].getT());
			System.out.println("xs[1]: " + xs[1].getT());
		}

		origin = new Coordinate(0, 0, -5, Coordinate.POINT);
		direction = new Coordinate(0, 0, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		if(xs == null) {
			System.out.println("EMPTY");
		} else {
			System.out.println("xs[0]: " + xs[0].getT());
			System.out.println("xs[1]: " + xs[1].getT());
		}

		origin = new Coordinate(0.5, 0, -5, Coordinate.POINT);
		direction = new Coordinate(0.1, 1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(origin, direction);
		xs = cyl.localIntersect(r);

		if(xs == null) {
			System.out.println("EMPTY");
		} else {
			System.out.println("xs[0]: " + xs[0].getT());
			System.out.println("xs[1]: " + xs[1].getT());
		}
	}

	public static void cylinderTest() {
		Cylinder cyl = new Cylinder();

		Coordinate direction;
		Ray r;
		Intersection[] xs;

		direction = new Coordinate(0, 1, 0, Coordinate.VECTOR).normalize();
		r = new Ray(new Coordinate(1, 0, 0, Coordinate.POINT), direction);
		xs = cyl.localIntersect(r);

		if(xs == null) {
			System.out.println("EMPTY");
		} else {
			System.out.println("1");
			xs[0].printData();
		}

		direction = new Coordinate(0, 1, 0, Coordinate.VECTOR).normalize();
		r = new Ray(new Coordinate(0, 0, 0, Coordinate.POINT), direction);
		xs = cyl.localIntersect(r);

		if(xs == null) {
			System.out.println("EMPTY");
		} else {
			System.out.println("2");
			xs[0].printData();
		}

		direction = new Coordinate(1, 1, 1, Coordinate.VECTOR).normalize();
		r = new Ray(new Coordinate(0, 0, -5, Coordinate.POINT), direction);
		xs = cyl.localIntersect(r);

		if(xs == null) {
			System.out.println("EMPTY");
		} else {
			System.out.println("3");
			xs[0].printData();
		}
	}

	public static void sceneTest9() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		floor.getMaterial().setReflective(0.5);

		Cube cube = new Cube();
		cube.setColour(new Colour(0, 0, 1));
		cube.setTransformation(Matrix.translation(-0.5, 1, 0.5).matrixMultiplication(Matrix.rotationY(Math.PI / 4)));

		Shape[] objs = {floor, cube};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 2, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void cubeTest2() {
		Cube cube = new Cube();
		Coordinate rayOrigin;
		Coordinate rayDirection;
		Ray ray;
		Intersection[] xs;

		//1
		rayOrigin = new Coordinate(-2, 0, 0, Coordinate.POINT);
		rayDirection = new Coordinate(0.2673, 0.5345, 0.8018, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		if(xs != null) {
			System.out.println(xs.length == 0);
		} else {
			System.out.println("EMPTY");
		}

		//2
		rayOrigin = new Coordinate(0, -2, 0, Coordinate.POINT);
		rayDirection = new Coordinate(0.8018, 0.2673, 0.5345, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		if(xs != null) {
			System.out.println(xs.length == 0);
		} else {
			System.out.println("EMPTY");
		}

		//3
		rayOrigin = new Coordinate(0, 0, -2, Coordinate.POINT);
		rayDirection = new Coordinate(0.5345, 0.8018, 0.2673, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		if(xs != null) {
			System.out.println(xs.length == 0);
		} else {
			System.out.println("EMPTY");
		}

		//4
		rayOrigin = new Coordinate(2, 0, 2, Coordinate.POINT);
		rayDirection = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		if(xs != null) {
			System.out.println(xs.length == 0);
		} else {
			System.out.println("EMPTY");
		}

		//5
		rayOrigin = new Coordinate(0, 2, 2, Coordinate.POINT);
		rayDirection = new Coordinate(0, -1, 0, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		if(xs != null) {
			System.out.println(xs.length == 0);
		} else {
			System.out.println("EMPTY");
		}

		//6
		rayOrigin = new Coordinate(2, 2, 0, Coordinate.POINT);
		rayDirection = new Coordinate(-1, 0, 0, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		if(xs != null) {
			System.out.println(xs.length == 0);
		} else {
			System.out.println("EMPTY");
		}
	}

	public static void cubeTest() {
		Cube cube = new Cube();
		Coordinate rayOrigin;
		Coordinate rayDirection;
		Ray ray;
		Intersection[] xs;

		//+x
		rayOrigin = new Coordinate(5, 0.5, 0, Coordinate.POINT);
		rayDirection = new Coordinate(-1, 0, 0, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");

		//-x
		rayOrigin = new Coordinate(-5, 0.5, 0, Coordinate.POINT);
		rayDirection = new Coordinate(1, 0, 0, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");

		//+y
		rayOrigin = new Coordinate(0.5, 5, 0, Coordinate.POINT);
		rayDirection = new Coordinate(0, -1, 0, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");

		//-y
		rayOrigin = new Coordinate(0.5, -5, 0, Coordinate.POINT);
		rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");

		//+z
		rayOrigin = new Coordinate(0.5, 0, 5, Coordinate.POINT);
		rayDirection = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");

		//-z
		rayOrigin = new Coordinate(0.5, 0, -5, Coordinate.POINT);
		rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");

		//inside
		rayOrigin = new Coordinate(0, 0.5, 0, Coordinate.POINT);
		rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		ray = new Ray(rayOrigin, rayDirection);

		xs = cube.localIntersect(ray);

		System.out.println("xs[0]: " + xs[0].getT());
		System.out.println("xs[1]: " + xs[1].getT());
		System.out.println("----------------");
	}

	public static void sceneTest8() {

		World world = new World();
		Plane wall = new Plane();
		wall.setTransformation(Matrix.rotationX(1.5708).matrixMultiplication(Matrix.translation(0, 0, 10)));
		CheckerPattern pattern = new CheckerPattern(new Colour(0.15, 0.15, 0.15), new Colour(0.85, 0.85, 0.85));
		wall.getMaterial().setPattern(pattern);
		wall.getMaterial().setAmbient(0.8);
		wall.getMaterial().setDiffuse(0.2);
		wall.getMaterial().setSpecular(0);

		Sphere ball = Sphere.getGlassSphere();
		ball.getMaterial().setColour(Colour.WHITE);
		ball.getMaterial().setAmbient(0);
		ball.getMaterial().setDiffuse(0);
		ball.getMaterial().setSpecular(0.9);
		ball.getMaterial().setShininess(300);
		ball.getMaterial().setReflective(0.9);
		ball.getMaterial().setTransparency(0.9);
		ball.getMaterial().setRefractiveIndex(Material.DIAMOND);

		Sphere hollowCentre = new Sphere();
		hollowCentre.setTransformation(Matrix.scaling(0.5, 0.5, 0.5));
		hollowCentre.getMaterial().setColour(Colour.WHITE);
		hollowCentre.getMaterial().setAmbient(0);
		hollowCentre.getMaterial().setDiffuse(0);
		hollowCentre.getMaterial().setSpecular(0.9);
		hollowCentre.getMaterial().setShininess(300);
		hollowCentre.getMaterial().setReflective(0.9);
		hollowCentre.getMaterial().setTransparency(0.9);
		hollowCentre.getMaterial().setRefractiveIndex(1.0000034);

		Shape[] objs = {wall, ball};

		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(2, 10, -5, Coordinate.POINT);
		Colour white = new Colour(0.9, 0.9, 0.9);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(300, 300, 0.45);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 0, -5, Coordinate.POINT),
													  new Coordinate(0, 0, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void fresnelTest4() {
		World world = new World();
		Plane floor = new Plane();
		floor.setTransformation(Matrix.translation(0, -1, 0));
		floor.getMaterial().setReflective(0.5);
		floor.getMaterial().setTransparency(0.5);
		floor.getMaterial().setRefractiveIndex(1.5);

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(0, -3.5, -0.5));
		ball.setColour(new Colour(1, 0, 0));
		ball.getMaterial().setAmbient(0.5);

		Shape[] objs = {floor, ball};
		world.setObjs(objs);

		Coordinate rayOrigin = new Coordinate(0, 0, -3, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, -Math.sqrt(2) / 2, Math.sqrt(2) / 2, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(Math.sqrt(2), floor);

		Intersection[] xs = {xs1};

		Computation comps = new Computation(xs[0], ray, xs);

		Colour colour = comps.shadeHit(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void fresnelTest3() {
		Sphere shape = Sphere.getGlassSphere();

		Coordinate rayOrigin = new Coordinate(0, 0.99, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(1.8589, shape);

		Intersection[] xs = {xs1};

		Computation comps = new Computation(xs[0], ray, xs);

		System.out.println(comps.schlick());
	}

	public static void fresnelTest2() {
		Sphere shape = Sphere.getGlassSphere();

		Coordinate rayOrigin = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(-1, shape);
		Intersection xs2 = new Intersection(1, shape);

		Intersection[] xs = {xs1, xs2};

		Computation comps = new Computation(xs[1], ray, xs);

		System.out.println(comps.schlick());
	}

	public static void fresnelTest() {
		Sphere shape = Sphere.getGlassSphere();

		Coordinate rayOrigin = new Coordinate(0, 0, Math.sqrt(2) / 2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(-Math.sqrt(2) / 2, shape);
		Intersection xs2 = new Intersection(Math.sqrt(2) / 2, shape);

		Intersection[] xs = {xs1, xs2};

		Computation comps = new Computation(xs[1], ray, xs);

		System.out.println(comps.schlick());
	}

	public static void visualTest() {
		World world = new World();
		Plane floor = new Plane();
		floor.setTransformation(Matrix.translation(0, -1, 0));
		floor.getMaterial().setTransparency(0.5);
		floor.getMaterial().setRefractiveIndex(1.5);

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(0, -3.5, -0.5));
		ball.setColour(new Colour(1, 0, 0));
		ball.getMaterial().setAmbient(0.5);

		Shape[] objs = {floor, ball};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 0, -3, Coordinate.POINT),
													  new Coordinate(0, -Math.sqrt(2) / 2, Math.sqrt(2) / 2, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void refractionTest7() {
		World world = new World();
		Plane floor = new Plane();
		floor.setTransformation(Matrix.translation(0, -1, 0));
		floor.getMaterial().setTransparency(0.5);
		floor.getMaterial().setRefractiveIndex(1.5);

		Sphere ball = new Sphere();
		ball.setTransformation(Matrix.translation(0, -3.5, -0.5));
		ball.setColour(new Colour(1, 0, 0));
		ball.getMaterial().setAmbient(0.5);

		Shape[] objs = {floor, ball};
		world.setObjs(objs);

		Coordinate rayOrigin = new Coordinate(0, 0, -3, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, -Math.sqrt(2) / 2, Math.sqrt(2) / 2, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(Math.sqrt(2), floor);

		Intersection[] xs = {xs1};

		Computation comps = new Computation(xs[0], ray, xs);

		Colour colour = comps.shadeHit(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void refractionTest6() {
		World world = new World();
		Shape[] objs = world.getObjs();
		Shape shape = objs[0];

		shape.getMaterial().setAmbient(1);

		Shape shape2 = objs[1];
		shape2.getMaterial().setTransparency(1);
		shape2.getMaterial().setRefractiveIndex(1.5);

		Coordinate rayOrigin = new Coordinate(0, 0, 0.1, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(-0.9899, shape);
		Intersection xs2 = new Intersection(-0.4899, shape2);
		Intersection xs3 = new Intersection(0.4899, shape2);
		Intersection xs4 = new Intersection(0.9899, shape);

		Intersection[] xs = {xs1, xs2, xs3, xs4};

		Computation comps = new Computation(xs[2], ray, xs);

		Colour colour = comps.refractedColour(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void refractionTest5() {
		World world = new World();
		Shape[] objs = world.getObjs();
		Shape shape = objs[0];

		shape.getMaterial().setTransparency(1);
		shape.getMaterial().setRefractiveIndex(1.5);

		Coordinate rayOrigin = new Coordinate(0, 0, Math.sqrt(2) / 2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(-Math.sqrt(2) / 2, shape);
		Intersection xs2 = new Intersection(Math.sqrt(2) / 2, shape);

		Intersection[] xs = {xs1, xs2};

		Computation comps = new Computation(xs[1], ray, xs);

		Colour colour = comps.refractedColour(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void refractionTest4() {
		World world = new World();
		Shape[] objs = world.getObjs();
		Shape shape = objs[0];

		shape.getMaterial().setTransparency(1);
		shape.getMaterial().setRefractiveIndex(1.5);

		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(4, shape);
		Intersection xs2 = new Intersection(6, shape);

		Intersection[] xs = {xs1, xs2};

		Computation comps = new Computation(xs[0], ray, xs);

		Colour colour = comps.refractedColour(world, 0);
		colour.printData();
	}

	public static void refractionTest3() {
		World world = new World();
		Shape[] objs = world.getObjs();
		Shape shape = objs[0];

		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(4, shape);
		Intersection xs2 = new Intersection(6, shape);

		Intersection[] xs = {xs1, xs2};

		Computation comps = new Computation(xs[0], ray, xs);

		Colour colour = comps.refractedColour(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void refractionTest2() {
		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Sphere s = Sphere.getGlassSphere();
		s.setTransformation(Matrix.translation(0, 0, 1));

		Intersection i = new Intersection(5, s);
		Intersection[] xs = {i};

		Computation comps = new Computation(i, ray, xs);

		System.out.println(comps.getUnderPoint().getZ() > Computation.EPSILON / 2);
		System.out.println(comps.getPoint().getZ() < comps.getUnderPoint().getZ());
	}

	public static void refractionTest() {
		Sphere a = Sphere.getGlassSphere();
		a.setTransformation(Matrix.scaling(2, 2, 2));
		a.getMaterial().setRefractiveIndex(1.5);

		Sphere b = Sphere.getGlassSphere();
		b.setTransformation(Matrix.translation(0, 0, -0.25));
		b.getMaterial().setRefractiveIndex(2);

		Sphere c = Sphere.getGlassSphere();
		c.setTransformation(Matrix.translation(0, 0, 0.25));
		c.getMaterial().setRefractiveIndex(2.5);

		Coordinate rayOrigin = new Coordinate(0, 0, -4, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection xs1 = new Intersection(2, a);
		Intersection xs2 = new Intersection(2.75, b);
		Intersection xs3 = new Intersection(3.25, c);
		Intersection xs4 = new Intersection(4.75, b);
		Intersection xs5 = new Intersection(5.25, c);
		Intersection xs6 = new Intersection(6, a);

		Intersection[] xs = {xs1, xs2, xs3, xs4, xs5, xs6};

		System.out.println("| index | n1 | n2 |");

		for(int i = 0; i < xs.length; i++) {
			Computation comps = new Computation(xs[i], ray, xs);

			System.out.println("| " + i + " | " + comps.getN1() + " | " + comps.getN2() + " |");
		}
	}

	public static void sceneTest7() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());
		floor.getMaterial().setReflective(0.5);

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Sphere middle = new Sphere();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		middle.setColour(new Colour(0.5, 0.5, 0.5));
		middle.getMaterial().setReflective(1);

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.getMaterial().setDiffuse(0.7);
		right.getMaterial().setSpecular(0.3);
		right.getMaterial().setPattern(new CheckerPattern(new Colour(1, 0, 0), Colour.WHITE));

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.getMaterial().setDiffuse(0.7);
		left.getMaterial().setSpecular(0.3);
		RingPattern leftSpherePattern = new RingPattern(new Colour(0, 0, 1), Colour.WHITE);
		Matrix leftSpherePatternTransformation = Matrix.rotationZ(Math.PI / 4).matrixMultiplication(Matrix.scaling(0.3, 0.3, 0.3));
		leftSpherePattern.setTransformation(leftSpherePatternTransformation);
		left.getMaterial().setPattern(leftSpherePattern);

		Shape[] objs = {floor, leftWall, rightWall, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void reflectiveTest2() {
		World world = new World();
		Plane shape = new Plane();
		shape.getMaterial().setReflective(0.5);
		shape.setTransformation(Matrix.translation(0, -1, 0));

		Shape[] originalObjects = world.getObjs();
		Shape[] newObjects = {originalObjects[0],
				              originalObjects[1],
				              shape};
		world.setObjs(newObjects);

		Coordinate rayOrigin = new Coordinate(0, 0, -3, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, -Math.sqrt(2) / 2, Math.sqrt(2) / 2, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection i = new Intersection(Math.sqrt(2), shape);
		Computation comps = new Computation(i, ray, null);

		Colour colour = comps.shadeHit(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void reflectiveTest() {
		World world = new World();
		Plane shape = new Plane();
		shape.getMaterial().setReflective(0.5);
		shape.setTransformation(Matrix.translation(0, -1, 0));

		Shape[] originalObjects = world.getObjs();
		Shape[] newObjects = {originalObjects[0],
				              originalObjects[1],
				              shape};
		world.setObjs(newObjects);

		Coordinate rayOrigin = new Coordinate(0, 0, -3, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, -Math.sqrt(2) / 2, Math.sqrt(2) / 2, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection i = new Intersection(Math.sqrt(2), shape);
		Computation comps = new Computation(i, ray, null);

		Colour colour = comps.reflectedColour(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void nonreflectiveTest() {
		World world = new World();

		Coordinate rayOrigin = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Shape[] objects = world.getObjs();

		Shape shape = objects[1];
		shape.getMaterial().setAmbient(1);

		Intersection i = new Intersection(1, shape);
		Computation comps = new Computation(i, ray, null);

		Colour result = comps.reflectedColour(world, Computation.RECURSIVE_CUTOFF);
		result.printData();
	}

	public static void reflectvTest() {
		Plane shape = new Plane();

		Coordinate rayOrigin = new Coordinate(0, 1, -1, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, -Math.sqrt(2) / 2, Math.sqrt(2) / 2, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);
		Intersection i = new Intersection(Math.sqrt(2), shape);
		Computation comps = new Computation(i, ray, null);

		comps.getReflectv().printData();
	}

	public static void patternTest14() {

		RingPattern pattern = new RingPattern();
		pattern.getTransformation().printData();

		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix m3 = Matrix.scaling(10, 0.01, 10);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2).matrixMultiplication(m3);
		pattern.setTransformation(transformLeftWall);

		pattern.getTransformation().printData();
	}

	public static void sceneTest6() {
		World world = new World();
		Plane floor = new Plane();
		floor.getMaterial().setPattern(new CheckerPattern());

		Plane leftWall = new Plane();
		leftWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix transformLeftWall = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2);
		leftWall.setTransformation(transformLeftWall);

		Plane rightWall = new Plane();
		rightWall.getMaterial().setPattern(new RingPattern(new Colour(0, 0, 1), new Colour(0.5, 0.5, 1)));
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix transformRightWall = r1.matrixMultiplication(r2).matrixMultiplication(r3);
		rightWall.setTransformation(transformRightWall);

		Sphere middle = new Sphere();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		GradientPattern gradient = new GradientPattern(new Colour(0, 0, 1), new Colour(1, 0, 0));
		gradient.setTransformation(Matrix.translation(-1, 0, 0).matrixMultiplication(Matrix.scaling(2, 2, 2)));
		middle.getMaterial().setPattern(gradient);

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.getMaterial().setDiffuse(0.7);
		right.getMaterial().setSpecular(0.3);
		right.getMaterial().setPattern(new CheckerPattern(new Colour(1, 0, 0), Colour.WHITE));

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.getMaterial().setDiffuse(0.7);
		left.getMaterial().setSpecular(0.3);
		RingPattern leftSpherePattern = new RingPattern(new Colour(0, 0, 1), Colour.WHITE);
		Matrix leftSpherePatternTransformation = Matrix.rotationZ(Math.PI / 4).matrixMultiplication(Matrix.scaling(0.3, 0.3, 0.3));
		leftSpherePattern.setTransformation(leftSpherePatternTransformation);
		left.getMaterial().setPattern(leftSpherePattern);

		Shape[] objs = {floor, leftWall, rightWall, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void patternTest13() {
		CheckerPattern pattern = new CheckerPattern(Colour.WHITE, Colour.BLACK);

		Colour c = pattern.stripeAt(new Coordinate(0, 0, 0, Coordinate.POINT));
		c.printData();
		System.out.println("-----------");

		Colour c2 = pattern.stripeAt(new Coordinate(0, 0, 0.99, Coordinate.POINT));
		c2.printData();
		System.out.println("-----------");

		Colour c3 = pattern.stripeAt(new Coordinate(0, 0, 1.01, Coordinate.POINT));
		c3.printData();
		System.out.println("-----------");
	}

	public static void patternTest12() {
		CheckerPattern pattern = new CheckerPattern(Colour.WHITE, Colour.BLACK);

		Colour c = pattern.stripeAt(new Coordinate(0, 0, 0, Coordinate.POINT));
		c.printData();
		System.out.println("-----------");

		Colour c2 = pattern.stripeAt(new Coordinate(0, 0.99, 0, Coordinate.POINT));
		c2.printData();
		System.out.println("-----------");

		Colour c3 = pattern.stripeAt(new Coordinate(0, 1.01, 0, Coordinate.POINT));
		c3.printData();
		System.out.println("-----------");
	}

	public static void patternTest11() {
		CheckerPattern pattern = new CheckerPattern(Colour.WHITE, Colour.BLACK);

		Colour c = pattern.stripeAt(new Coordinate(0, 0, 0, Coordinate.POINT));
		c.printData();
		System.out.println("-----------");

		Colour c2 = pattern.stripeAt(new Coordinate(0.99, 0, 0, Coordinate.POINT));
		c2.printData();
		System.out.println("-----------");

		Colour c3 = pattern.stripeAt(new Coordinate(1.01, 0, 0, Coordinate.POINT));
		c3.printData();
		System.out.println("-----------");
	}

	public static void patternTest10() {
		RingPattern pattern = new RingPattern(Colour.WHITE, Colour.BLACK);

		Colour c = pattern.stripeAt(new Coordinate(0, 0, 0, Coordinate.POINT));
		c.printData();
		System.out.println("-----------");

		Colour c2 = pattern.stripeAt(new Coordinate(1, 0, 0, Coordinate.POINT));
		c2.printData();
		System.out.println("-----------");

		Colour c3 = pattern.stripeAt(new Coordinate(0, 0, 1, Coordinate.POINT));
		c3.printData();
		System.out.println("-----------");

		Colour c4 = pattern.stripeAt(new Coordinate(0.708, 0, 0.708, Coordinate.POINT));
		c4.printData();
		System.out.println("-----------");
	}

	public static void patternTest9() {
		GradientPattern pattern = new GradientPattern(Colour.WHITE, Colour.BLACK);

		Colour c = pattern.stripeAt(new Coordinate(0, 0, 0, Coordinate.POINT));
		c.printData();
		System.out.println("-----------");

		Colour c2 = pattern.stripeAt(new Coordinate(0.25, 0, 0, Coordinate.POINT));
		c2.printData();
		System.out.println("-----------");

		Colour c3 = pattern.stripeAt(new Coordinate(0.5, 0, 0, Coordinate.POINT));
		c3.printData();
		System.out.println("-----------");

		Colour c4 = pattern.stripeAt(new Coordinate(0.75, 0, 0, Coordinate.POINT));
		c4.printData();
		System.out.println("-----------");
	}

	public static void patternTest8() {
		Sphere shape = new Sphere();
		shape.setTransformation(Matrix.scaling(2, 2, 2));

		StripePattern pattern = new StripePattern();
		Colour c = pattern.stripeAtObject(shape, new Coordinate(2, 3, 4, Coordinate.POINT));
		c.printData();
	}

	public static void patternTest7() {
		Sphere s = new Sphere();
		s.setTransformation(Matrix.scaling(2, 2, 2));

		StripePattern pattern = new StripePattern();
		pattern.setTransformation(Matrix.scaling(0.5, 1, 1));

		Colour c = pattern.stripeAtObject(s, new Coordinate(2.5, 0, 0, Coordinate.POINT));
		c.printData();
	}

	public static void patternTest6() {
		Sphere s = new Sphere();

		StripePattern pattern = new StripePattern();
		pattern.setTransformation(Matrix.scaling(2, 2, 2));

		Colour c = pattern.stripeAtObject(s, new Coordinate(1.5, 0, 0, Coordinate.POINT));
		c.printData();
	}

	public static void patternTest5() {
		Sphere s = new Sphere();
		s.setTransformation(Matrix.scaling(2, 2, 2));

		StripePattern pattern = new StripePattern();

		Colour c = pattern.stripeAtObject(s, new Coordinate(1.5, 0, 0, Coordinate.POINT));
		c.printData();
	}

	public static void sceneTest5() {
		World world = new World();
		Plane floor = new Plane();

		Material defaultMaterial = new Material();
		Material realMaterial = new Material(defaultMaterial.getAmbient(),
											 defaultMaterial.getDiffuse(),
											 defaultMaterial.getSpecular(),
											 defaultMaterial.getShininess(),
											 defaultMaterial.getReflective(),
											 defaultMaterial.getTransparency(),
											 defaultMaterial.getRefractiveIndex(),
											 defaultMaterial.getColour());

		floor.setMaterial(realMaterial);

		Sphere middle = new Sphere();
		//middle.getMaterial().getPattern().printData();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		middle.setMaterial(realMaterial);
		middle.getMaterial().setPattern(new CheckerPattern());

		/*StripePattern pattern = new StripePattern();
		pattern.setTransformation(Matrix.scaling(0.5, 1, 1).matrixMultiplication(Matrix.rotationZ(Math.PI / 4)));
		middle.getMaterial().setPattern(pattern);*/

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.getMaterial().setDiffuse(0.7);
		right.getMaterial().setSpecular(0.3);

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.getMaterial().setDiffuse(0.7);
		left.getMaterial().setSpecular(0.3);

		Shape[] objs = {floor, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void sceneTest4() {
		World world = new World();
		Plane floor = new Plane();

		Material defaultMaterial = new Material();
		Material realMaterial = new Material(defaultMaterial.getAmbient(),
											 defaultMaterial.getDiffuse(),
											 defaultMaterial.getSpecular(),
											 defaultMaterial.getShininess(),
											 defaultMaterial.getReflective(),
											 defaultMaterial.getTransparency(),
											 defaultMaterial.getRefractiveIndex(),
											 defaultMaterial.getColour());

		floor.setMaterial(realMaterial);

		Sphere middle = new Sphere();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		middle.setColour(new Colour(0.24, 0.84, 0.58));
		middle.getMaterial().setDiffuse(0.7);
		middle.getMaterial().setSpecular(0.3);

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.getMaterial().setDiffuse(0.7);
		right.getMaterial().setSpecular(0.3);

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.getMaterial().setDiffuse(0.7);
		left.getMaterial().setSpecular(0.3);

		Shape[] objs = {floor, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void patternTest4() {
		Material material = new Material(1, 0, 0, 200, 0, 0, 1, Colour.WHITE);
		Coordinate eyev = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		PointLight light = new PointLight(new Coordinate(0, 0, -10, Coordinate.POINT), Colour.WHITE);
		Sphere s = new Sphere();
		s.setMaterial(material);

		Colour a = s.lighting(light, new Coordinate(0.9, 0, 0), eyev, normalv, false);
		Colour b = s.lighting(light, new Coordinate(1.1, 0, 0), eyev, normalv, false);

		a.printData();
		System.out.println("----------");
		b.printData();
	}

	public static void patternTest3() {
		StripePattern pattern = new StripePattern();

		pattern.stripeAt(new Coordinate(0, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(0.9, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(1, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(-0.1, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(-1, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(-1.1, 0, 0)).printData();
		System.out.println("--------------");

	}

	public static void patternTest2() {
		StripePattern pattern = new StripePattern();

		pattern.stripeAt(new Coordinate(0, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(0, 0, 1)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(0, 0, 2)).printData();
		System.out.println("--------------");

	}

	public static void patternTest() {
		StripePattern pattern = new StripePattern();

		pattern.stripeAt(new Coordinate(0, 0, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(0, 1, 0)).printData();
		System.out.println("--------------");
		pattern.stripeAt(new Coordinate(0, 2, 0)).printData();
		System.out.println("--------------");

	}

	public static void sceneTest3() {
		World world = new World();
		Plane floor = new Plane();
		floor.setColour(new Colour(1, 0.9, 0.9));
		floor.getMaterial().setSpecular(0);
		floor.setColour(new Colour(1, 0.9, 0.9));
		floor.getMaterial().setSpecular(0);

		Sphere middle = new Sphere();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		middle.setColour(new Colour(0.24, 0.84, 0.58));
		middle.getMaterial().setDiffuse(0.7);
		middle.getMaterial().setSpecular(0.3);

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.getMaterial().setDiffuse(0.7);
		right.getMaterial().setSpecular(0.3);

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.getMaterial().setDiffuse(0.7);
		left.getMaterial().setSpecular(0.3);

		Shape[] objs = {floor, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void sceneTest2() {
		World world = new World();
		Plane floor = new Plane();
		floor.setColour(new Colour(1, 0.9, 0.9));
		floor.getMaterial().setSpecular(0);

		Sphere s1 = new Sphere();
		s1.setTransformation(Matrix.translation(0, 0.5, 0));

		Sphere s2 = new Sphere();
		s2.setTransformation(Matrix.translation(1, 0.5, 0));

		Shape[] objs = {floor, s1, s2};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(1, 20, 0, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void planeIntersectTest4() {
		Plane p = new Plane();

		Coordinate rayOrigin = new Coordinate(0, -1, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = p.localIntersect(ray);

		if(xs != null) {
			if(xs.length == 0) {
				System.out.println("Empty");
			} else {
				xs[0].printData();
			}
		} else {
			System.out.println("NULL");
		}
	}

	public static void planeIntersectTest3() {
		Plane p = new Plane();

		Coordinate rayOrigin = new Coordinate(0, 1, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, -1, 0, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = p.localIntersect(ray);

		if(xs != null) {
			if(xs.length == 0) {
				System.out.println("Empty");
			} else {
				xs[0].printData();
			}
		} else {
			System.out.println("NULL");
		}
	}

	public static void planeIntersectTest2() {
		System.out.println("TEST 2");
		Plane p = new Plane();

		Coordinate rayOrigin = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = p.localIntersect(ray);

		if(xs != null) {
			if(xs.length == 0) {
				System.out.println("Empty");
			} else {
				System.out.println("Not Empty");
			}
		} else {
			System.out.println("NULL");
		}
	}

	public static void planeIntersectTest() {
		System.out.println("TEST 1");
		Plane p = new Plane();

		Coordinate rayOrigin = new Coordinate(0, 10, 0, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = p.localIntersect(ray);

		if(xs != null) {
			if(xs.length == 0) {
				System.out.println("Empty");
			} else {
				System.out.println("Not Empty");
			}
		} else {
			System.out.println("NULL");
		}
	}

	public static void localNormalAtFunctionPlaneTest() {
		Plane p = new Plane();

		Coordinate n1 = p.localNormalAt(new Coordinate(0, 0, 0, Coordinate.POINT), null);
		Coordinate n2 = p.localNormalAt(new Coordinate(10, 0, -10, Coordinate.POINT), null);
		Coordinate n3 = p.localNormalAt(new Coordinate(-5, 0, 150, Coordinate.POINT), null);

		n1.printData();
		System.out.println("--------");
		n2.printData();
		System.out.println("--------");
		n3.printData();
		System.out.println("--------");
	}

	public static void wtfTest2() {
		Sphere s = new Sphere();
		Matrix m = Matrix.scaling(1, 0.5, 1).matrixMultiplication(Matrix.rotationZ(Math.PI / 5));
		s.setTransformation(m);
		Coordinate n = s.normalAt(new Coordinate(0, Math.sqrt(2) / 2, -Math.sqrt(2) / 2, Coordinate.POINT), null);
		n.printData();
	}

	public static void wtfTest() {
		Sphere s = new Sphere();
		s.setTransformation(Matrix.translation(0, 1, 0));
		Coordinate n = s.normalAt(new Coordinate(0, 1.70711, -0.70711), null);
		n.printData();
	}

	public static void shadowRenderTest() {
		World world = new World();
		Coordinate lightOrigin = new Coordinate(0, 0, -10, Coordinate.POINT);
		Colour lightColour = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightOrigin, lightColour);
		world.setLight(light);

		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Matrix transform = Matrix.translation(0,  0, 10);
		s2.setTransformation(transform);

		Sphere[] objs = {s1, s2};
		world.setObjs(objs);

		Coordinate rayOrigin = new Coordinate(0, 0, 5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection i = new Intersection(4, s2);
		Computation comps = new Computation(i, ray, null);
		Colour colour = comps.shadeHit(world, Computation.RECURSIVE_CUTOFF);
		colour.printData();
	}

	public static void shadowTest4() {
		World world = new World();
		Coordinate p = new Coordinate(-2, 2, -2, Coordinate.POINT);
		System.out.println(world.isShadowed(p));
	}

	public static void shadowTest3() {
		World world = new World();
		Coordinate p = new Coordinate(-20, 20, -20, Coordinate.POINT);
		System.out.println(world.isShadowed(p));
	}

	public static void shadowTest2() {
		World world = new World();
		Coordinate p = new Coordinate(10, -10, 10, Coordinate.POINT);
		System.out.println(world.isShadowed(p));
	}

	public static void shadowTest() {
		World world = new World();
		Coordinate p = new Coordinate(0, 10, 0, Coordinate.POINT);
		System.out.println(world.isShadowed(p));
	}

	public static void pointInShadowTest() {
		Coordinate origin = new Coordinate(0, 0, 0, Coordinate.POINT);
		Sphere s = new Sphere();
		Coordinate eyev = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		PointLight light = new PointLight(new Coordinate(0, 0, -10, Coordinate.POINT), new Colour(1, 1, 1));
		boolean inShadow = true;

		Colour result = s.lighting(light, origin, eyev, normalv, inShadow);
		result.printData();
	}

	public static void sceneTest() {
		World world = new World();
		Sphere floor = new Sphere();
		Matrix transform = Matrix.scaling(10, 0.01, 10);
		floor.setTransformation(transform);
		floor.setColour(new Colour(1, 0.9, 0.9));
		floor.getMaterial().setSpecular(0);

		Sphere leftWall = new Sphere();
		Matrix m1 = Matrix.rotationY(-Math.PI / 4);
		Matrix m2 = Matrix.rotationX(Math.PI / 2);
		Matrix m3 = Matrix.scaling(10, 0.01, 10);
		//Matrix transform2 = m3.matrixMultiplication(m2).matrixMultiplication(m1).matrixMultiplication(Matrix.translation(0, 0, 5));
		Matrix transform2 = Matrix.translation(0, 0, 5).matrixMultiplication(m1).matrixMultiplication(m2).matrixMultiplication(m3);
		leftWall.setTransformation(transform2);
		leftWall.setMaterial(floor.getMaterial());

		Sphere rightWall = new Sphere();
		Matrix r1 = Matrix.translation(0, 0, 5);
		Matrix r2 = Matrix.rotationY(Math.PI / 4);
		Matrix r3 = Matrix.rotationX(Math.PI / 2);
		Matrix r4 = Matrix.scaling(10, 0.01, 10);

		Matrix transform3 = r1.matrixMultiplication(r2).matrixMultiplication(r3).matrixMultiplication(r4);
		//Matrix transform3 = r4.matrixMultiplication(r3).matrixMultiplication(r2).matrixMultiplication(r1);
		rightWall.setTransformation(transform3);
		rightWall.setMaterial(floor.getMaterial());

		Sphere middle = new Sphere();
		middle.setTransformation(Matrix.translation(-0.5, 1, 0.5));
		middle.setColour(new Colour(0.24, 0.84, 0.58));
		middle.getMaterial().setDiffuse(0.7);
		middle.getMaterial().setSpecular(0.3);

		Sphere right = new Sphere();
		right.setTransformation(Matrix.translation(1.5, 0.5, -0.5).matrixMultiplication(Matrix.scaling(0.5, 0.5, 0.5)));
		right.setColour(new Colour(0.24, 0.84, 0.82));
		right.getMaterial().setDiffuse(0.7);
		right.getMaterial().setSpecular(0.3);

		Sphere left = new Sphere();
		Matrix l1 = Matrix.translation(-1.5, 0.33, -0.75);
		Matrix l2 = Matrix.scaling(0.33, 0.33, 0.33);
		left.setTransformation(l1.matrixMultiplication(l2));
		left.setColour(new Colour(1, 0.8, 0.1));
		left.getMaterial().setDiffuse(0.7);
		left.getMaterial().setSpecular(0.3);

		Sphere[] objs = {floor, rightWall, leftWall, middle, right, left};
		world.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		world.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.viewTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(world);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void renderTest() {
		World world = new World();
		Camera camera = new Camera(11, 11, Math.PI / 2);

		Coordinate from = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate to = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate up = new Coordinate(0, 1, 0, Coordinate.VECTOR);

		camera.setTransform(Matrix.viewTransformation(from, to, up));

		ImageOutput image = camera.render(world);
		Colour testColour = image.pixelAt(5, 5);
		testColour.printData();
		try {
			image.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}
	}

	public static void cameraTest3() {
		Camera camera = new Camera(201, 101, Math.PI / 2);
		Matrix m = Matrix.rotationY(Math.PI / 4).matrixMultiplication(Matrix.translation(0, -2, 5));
		camera.setTransform(m);

		Ray r = camera.rayForPixel(100, 50);

		r.getOrigin().printData();
		System.out.println("--------");
		r.getDirection().printData();
	}

	public static void cameraTest2() {
		Camera camera = new Camera(201, 101, Math.PI / 2);

		Ray r = camera.rayForPixel(0, 0);

		r.getOrigin().printData();
		System.out.println("--------");
		r.getDirection().printData();
	}

	public static void cameraTest() {
		Camera camera = new Camera(201, 101, Math.PI / 2);

		Ray r = camera.rayForPixel(100, 50);

		r.getOrigin().printData();
		System.out.println("--------");
		r.getDirection().printData();
	}

	public static void orientationTest4() {
		Coordinate from = new Coordinate(1, 3, 2, Coordinate.POINT);
		Coordinate to = new Coordinate(4, -2, 8, Coordinate.POINT);
		Coordinate up = new Coordinate(1, 1, 0, Coordinate.POINT);

		Matrix v = Matrix.viewTransformation(from, to, up);

		v.printData();
	}

	public static void orientationTest3() {
		Coordinate from = new Coordinate(0, 0, 8, Coordinate.POINT);
		Coordinate to = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate up = new Coordinate(0, 1, 0, Coordinate.POINT);

		Matrix v = Matrix.viewTransformation(from, to, up);

		v.printData();

		System.out.println();

		Matrix i = Matrix.translation(0, 0, -8);
		i.printData();
	}

	public static void orientationTest2() {
		Coordinate from = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate to = new Coordinate(0, 0, 1, Coordinate.POINT);
		Coordinate up = new Coordinate(0, 1, 0, Coordinate.POINT);

		Matrix v = Matrix.viewTransformation(from, to, up);

		v.printData();

		System.out.println();

		Matrix i = Matrix.scaling(-1, 1, -1);
		i.printData();
	}

	public static void orientationTest() {
		Coordinate from = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate to = new Coordinate(0, 0, -1, Coordinate.POINT);
		Coordinate up = new Coordinate(0, 1, 0, Coordinate.POINT);

		Matrix v = Matrix.viewTransformation(from, to, up);

		v.printData();

		System.out.println();

		Matrix i = new Matrix(4);

		i.setIdentityMatrix();
		i.printData();
	}

	public static void colourAtTest() {
		World world = new World();

		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Colour colour = world.colourAt(ray, Computation.RECURSIVE_CUTOFF);

		colour.printData();
	}

	public static void rayMissesTest() {
		World world = new World();

		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 1, 0, Coordinate.VECTOR);
		Ray ray = new Ray(rayOrigin, rayDirection);

		Colour colour = world.colourAt(ray, Computation.RECURSIVE_CUTOFF);

		colour.printData();
	}

	public static void isInsideTest() {
		Coordinate point = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate vector = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray r = new Ray(point, vector);

		Sphere s = new Sphere();

		Intersection i = new Intersection(4, s);

		Computation c = new Computation(i, r, null);

		System.out.println("is Inside: " + c.getInside());
	}

	public static void isInsideTest2() {
		Coordinate point = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate vector = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray r = new Ray(point, vector);

		Sphere s = new Sphere();

		Intersection i = new Intersection(1, s);

		Computation c = new Computation(i, r, null);

		System.out.println("is Inside: " + c.getInside());
	}

	public static void intersectWorldTest() {
		World world = new World();
		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Intersection[] xs = world.intersect(ray);

		for(int i = 0; i < xs.length; i++) {
			xs[i].printData();
			System.out.println("------------");
		}
	}

	public static void lightingTest2() {
		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);

		double wallZ = 10;
		double wallSize = 7;

		int canvasPixels = 200;

		ImageOutput canvas = new ImageOutput(canvasPixels);
		//Colour red = new Colour(1, 0, 0);

		double pixelSize = wallSize / canvasPixels;
		double half = wallSize / 2;

		//Tuple sphereOrigin = new Tuple(0, 0, 5, Tuple.POINT);
		//double radius = 1.2;

		Sphere shape = new Sphere();
		Matrix scaling = Matrix.scaling(1, 2, 1);
		shape.setTransformation(scaling);
		shape.setColour(new Colour(1, 0.2, 1));

		Coordinate lightPosition = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour lightColour = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, lightColour);

		for(int y = 0; y < canvasPixels; y++) {
			double worldY = half - (pixelSize * y);

			for(int x = 0; x < canvasPixels; x++) {
				double worldX = -half + (pixelSize * x);

				Coordinate position = new Coordinate(worldX, worldY, wallZ, Coordinate.POINT);
				Coordinate newPosition = position.subtractCoordinate(rayOrigin).normalize();

				Ray r = new Ray(rayOrigin, newPosition);
				Intersection[] xs = shape.intersect(r);

				if(xs != null) {
					Intersection hitPoint = Intersection.hit(xs);
					if(hitPoint != null) {
						Coordinate point = r.position(hitPoint.getT());
						Coordinate normal = shape.normalAt(point, null);
						Coordinate eye = r.getDirection().negateCoordinate();

						Colour finalColour = shape.lighting(light, point, eye, normal, true);

						if(finalColour.getR() > 1 || finalColour.getG() > 1 || finalColour.getB() > 1) {
							finalColour.printData();
						}

						//canvas.writePixel(x, y, red);
						canvas.writePixel(x, y, finalColour);
					}
				}
			}
		}

		try {
			canvas.saveFile();
			System.out.println("File Saved Successfully");
		} catch (IOException e) {
			System.out.println("File Issue");
		}
	}

	public static void normaliseTest() {
		Coordinate t = new Coordinate(2,3,4,Coordinate.VECTOR);
		t.normalize();
		t.printData();
	}

	public static void lightingTest() {
		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);

		double wallZ = 10;
		double wallSize = 7;

		int canvasPixels = 200;

		ImageOutput canvas = new ImageOutput(canvasPixels);
		//Colour red = new Colour(1, 0, 0);

		double pixelSize = wallSize / canvasPixels;
		double half = wallSize / 2;

		Sphere shape = new Sphere();
		shape.setColour(new Colour(1, 0.2, 1));

		Coordinate lightPosition = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour lightColour = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, lightColour);

		for(int y = 0; y < canvasPixels; y++) {
			double worldY = half - (pixelSize * y);

			for(int x = 0; x < canvasPixels; x++) {
				double worldX = -half + (pixelSize * x);

				Coordinate position = new Coordinate(worldX, worldY, wallZ, Coordinate.POINT);
				Coordinate newPosition = position.subtractCoordinate(rayOrigin).normalize();

				Ray r = new Ray(rayOrigin, newPosition);
				Intersection[] xs = shape.intersect(r);

				if(xs != null) {
					Intersection hitPoint = Intersection.hit(xs);
					if(hitPoint != null) {
						Coordinate point = r.position(hitPoint.getT());
						Coordinate normal = shape.normalAt(point, null);
						Coordinate eye = r.getDirection().negateCoordinate();

						Colour finalColour = shape.lighting(light, point, eye, normal, true);

						if(finalColour.getR() > 1 || finalColour.getG() > 1 || finalColour.getB() > 1) {
							finalColour.printData();
						}

						//canvas.writePixel(x, y, red);
						canvas.writePixel(x, y, finalColour);
					}
				}
			}
		}

		try {
			canvas.saveFile();
			System.out.println("File Saved Successfully");
		} catch (IOException e) {
			System.out.println("File Issue");
		}
	}

	public static void lightingTestEyeBetweenLightAndSurfaces() {
		System.out.println("Lighting Test - Eye between the light and surface");
		Sphere s = new Sphere();
		Coordinate position = new Coordinate(0, 0, 0, Coordinate.POINT);

		Coordinate eyev = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate lightPosition = new Coordinate(0, 0, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, white);
		Colour result = s.lighting(light, position, eyev, normalv, true);
		result.printData();
	}

	public static void lightingTestEye45DegreesOffNormal() {
		System.out.println("Lighting Test - Eye at 45 degrees off normal");
		Sphere s = new Sphere();
		Coordinate position = new Coordinate(0, 0, 0, Coordinate.POINT);

		Coordinate eyev = new Coordinate(0, Math.sqrt(2) / 2, -Math.sqrt(2) / 2, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate lightPosition = new Coordinate(0, 0, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, white);
		Colour result = s.lighting(light, position, eyev, normalv, true);
		result.printData();
	}

	public static void lightingTestLight45DegreesOffNormal() {
		System.out.println("Lighting Test - Light at 45 degrees off normal");
		Sphere s = new Sphere();
		Coordinate position = new Coordinate(0, 0, 0, Coordinate.POINT);

		Coordinate eyev = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate lightPosition = new Coordinate(0, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, white);
		Colour result = s.lighting(light, position, eyev, normalv, true);
		result.printData();
	}

	public static void lightingTestEyeInPathOfReflectionVector() {
		System.out.println("Lighting Test - Eye in path of reflection vector");
		Sphere s = new Sphere();
		Coordinate position = new Coordinate(0, 0, 0, Coordinate.POINT);

		Coordinate eyev = new Coordinate(0, -Math.sqrt(2) / 2, -Math.sqrt(2) / 2, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate lightPosition = new Coordinate(0, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, white);
		Colour result = s.lighting(light, position, eyev, normalv, true);
		result.printData();
	}

	public static void lightingTestLightBehindObject() {
		System.out.println("Lighting Test - Light behind object");
		Sphere s = new Sphere();
		Coordinate position = new Coordinate(0, 0, 0, Coordinate.POINT);

		Coordinate eyev = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate normalv = new Coordinate(0, 0, -1, Coordinate.VECTOR);
		Coordinate lightPosition = new Coordinate(0, 0, 10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		PointLight light = new PointLight(lightPosition, white);
		Colour result = s.lighting(light, position, eyev, normalv, true);
		result.printData();
	}

	public static void normalVectorTransformedTest() {
		Sphere s = new Sphere();
		Matrix m = Matrix.scaling(1, 0.5, 1).matrixMultiplication(Matrix.rotationZ(Math.PI / 5));
		s.setTransformation(m);
		Coordinate p = new Coordinate(0, Math.sqrt(2) / 2, -Math.sqrt(2) / 2, Coordinate.POINT);
		Coordinate n = s.normalAt(p, null);

		n.printData();
	}

	public static void normalVectorTest() {
		Sphere s = new Sphere();
		Coordinate p = new Coordinate(Math.sqrt(3) / 3, Math.sqrt(3) / 3, Math.sqrt(3) / 3, Coordinate.POINT);
		Coordinate n = s.normalAt(p, null);

		n.printData();
	}

	public static void normalVectorTranslatedTest() {
		Sphere s = new Sphere();
		Matrix m = Matrix.translation(0, 1, 0);
		s.setTransformation(m);
		Coordinate p = new Coordinate(0, 1.70711, -0.70711, Coordinate.POINT);
		Coordinate n = s.normalAt(p, null);

		n.printData();
	}

	public static void raySphereIntersectionTest() {
		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);

		double wallZ = 10;
		double wallSize = 7;

		int canvasPixels = 100;

		ImageOutput canvas = new ImageOutput(canvasPixels);

		double pixelSize = wallSize / canvasPixels;
		double half = wallSize / 2;

		Colour red = new Colour(1, 0, 0);
		Sphere shape = new Sphere();

		for(int y = 0; y < canvasPixels; y++) {
			double worldY = half - (pixelSize * y);

			for(int x = 0; x < canvasPixels; x++) {
				double worldX = -half + (pixelSize * x);

				Coordinate position = new Coordinate(worldX, worldY, wallZ, Coordinate.POINT);
				Coordinate newPosition = position.subtractCoordinate(rayOrigin).normalize();

				Ray r = new Ray(rayOrigin, newPosition);
				Intersection[] xs = shape.intersect(r);

				if(xs != null) {
					if(Intersection.hit(xs) != null) {
						canvas.writePixel(x, y, red);
					}
				}
			}
		}

		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Issue");
		}
	}

	public static void raySphereIntersectionWithScalingTest() {
		Coordinate rayOrigin = new Coordinate(0, 0, -5, Coordinate.POINT);

		double wallZ = 10;
		double wallSize = 7;

		int canvasPixels = 100;

		ImageOutput canvas = new ImageOutput(canvasPixels);

		double pixelSize = wallSize / canvasPixels;
		double half = wallSize / 2;

		Colour red = new Colour(1, 0, 0);
		Sphere shape = new Sphere();
		//Matrix scalingMatrix = Matrix.scaling(1, 0.5, 1);
		Matrix scalingMatrix = Matrix.scaling(1.3, 1.3, 1.3);
		shape.setTransformation(scalingMatrix);

		for(int y = 0; y < canvasPixels; y++) {
			double worldY = half - (pixelSize * y);

			for(int x = 0; x < canvasPixels; x++) {
				double worldX = -half + (pixelSize * x);

				Coordinate position = new Coordinate(worldX, worldY, wallZ, Coordinate.POINT);
				Coordinate newPosition = position.subtractCoordinate(rayOrigin).normalize();

				Ray r = new Ray(rayOrigin, newPosition);
				Intersection[] xs = shape.intersect(r);

				if(xs != null) {
					if(Intersection.hit(xs) != null) {
						canvas.writePixel(x, y, red);
					}
				}
			}
		}

		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Issue");
		}
	}
}
