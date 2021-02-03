import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
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
		//halfTimeTest3();
	}
	
	//this took 77 seconds
	public static void halfTimeTest3() {
		Sphere left = new Sphere();
		Sphere middle = new Sphere();
		Sphere right = new Sphere();
		
		Matrix leftMatrix = Matrix.translation(-5, 0, 0);
		Matrix rightMatrix = Matrix.translation(5, 0, 0);
		
		left.setTransformation(leftMatrix);
		right.setTransformation(rightMatrix);
		
		Shape[] objects = {left, middle, right};
		
		MedianKDTree kdt = new MedianKDTree(true, objects, 0);
		kdt.split(0, 1);
		kdt.printTreeWithData();
		
		Shape[] kdtList = {kdt};
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(kdtList);
		scene.renderScene("HalfTimeSimulation3");
	}
	
	//this took 77 seconds
	public static void halfTimeTest2() {
		Sphere left = new Sphere();
		Sphere middle = new Sphere();
		Sphere right = new Sphere();
		
		Matrix leftMatrix = Matrix.translation(-5, 0, 0);
		Matrix rightMatrix = Matrix.translation(5, 0, 0);
		
		left.setTransformation(leftMatrix);
		right.setTransformation(rightMatrix);
		
		Shape[] objects = {left, middle, right};
		
		SpatialKDTree kdt = new SpatialKDTree(true, objects, 0);
		kdt.split(0, 1);
		kdt.printTreeWithData();
		
		Shape[] kdtList = {kdt};
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(kdtList);
		scene.renderScene("HalfTimeSimulation2");
	}
	
	//this took 69 seconds
	public static void halfTimeTest() {
		Sphere left = new Sphere();
		Sphere middle = new Sphere();
		Sphere right = new Sphere();
		
		Matrix leftMatrix = Matrix.translation(-5, 0, 0);
		Matrix rightMatrix = Matrix.translation(5, 0, 0);
		
		left.setTransformation(leftMatrix);
		right.setTransformation(rightMatrix);
		
		Shape[] objects = {left, middle, right};
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(objects);
		scene.renderScene("HalfTimeSimulation");
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

		Shape[] sceneList = {kdt};

		Scene scene = new Scene(200, 200);
		scene.setObjs(sceneList);
		scene.renderScene("medianResult4");
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

		Scene scene = new Scene(128, 128);
		scene.setObjs(shapes);
		scene.renderScene("lakeSimulation");
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

		Shape[] sceneList = {kdt};

		Scene scene = new Scene(200, 200);
		scene.setObjs(sceneList);
		scene.renderScene("medianResult3");
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

		Scene scene = new Scene(512, 512);
		scene.setObjs(shapesMinusNull);

		scene.renderScene("bunny");
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

		Scene scene = new Scene(200, 200);
		scene.setObjs(shapesMinusNull);

		scene.renderScene("trumpet");
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

		Shape[] sceneList = {kdt};

		Scene scene = new Scene(200, 200);
		scene.setObjs(sceneList);
		scene.renderScene("spatialResult1");
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

		Shape[] sceneList = {kdt};

		Scene scene = new Scene(512, 512);
		scene.setObjs(sceneList);
		scene.renderScene("medianResult1");
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

		Shape[] sceneList = {kdt};

		Scene scene = new Scene(512, 512);
		scene.setObjs(shapes);
		scene.renderScene("medianResult2");
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

		Scene scene = new Scene();
		scene.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		Scene scene = new Scene();
		scene.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(256, 256, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		Scene scene = new Scene();
		scene.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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
			sceneBox.addAABB(cubes[i].getAABB());
		}

		//Plane plane = new Plane();
		//Matrix t = Matrix.translation(0, -1, 0);
		//plane.setTransformation(t);

		Shape[] shapes = {g/*, plane*/};

		Scene scene = new Scene();
		scene.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -20, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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
			sceneBox.addAABB(cubes[i].getAABB());
		}

		Shape[] shapes = {g};

		Scene scene = new Scene();
		scene.setObjs(shapes);

		Coordinate lightOrigin = new Coordinate(-20, 20, -20, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -20, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");

	}

	public static void reflectionScene() {
		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 1.5, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void phongModelPicture() {
		Scene scene = new Scene();

		Sphere sphere = new Sphere();
		sphere.setColour(new Colour(0, 1, 0));

		Matrix t = Matrix.translation(0, 1, 0);
		Matrix s = Matrix.scaling(2, 2, 2);
		Matrix matrix = t.matrixMultiplication(s);

		sphere.setTransformation(matrix);

		Shape[] objs = {sphere};

		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

	public static void medianKDTreeConfigurationTest() {
		Scene scene = new Scene();

		Sphere sphere1 = new Sphere();
		Sphere sphere2 = new Sphere();
		Sphere sphere3 = new Sphere();

		Matrix matrix1 = Matrix.translation(-1, 0, 0);
		Matrix matrix2 = Matrix.translation(0, 1, 0);
		Matrix matrix3 = Matrix.translation(1, 0, 0);

		sphere1.setTransformation(matrix1);
		sphere2.setTransformation(matrix2);
		sphere3.setTransformation(matrix3);

		AABB box1 = sphere1.getAABB().applyMatrix(sphere1.getTransformation());
		AABB box2 = sphere2.getAABB().applyMatrix(sphere2.getTransformation());
		AABB box3 = sphere3.getAABB().applyMatrix(sphere3.getTransformation());

		Shape[] shapes = {sphere1, sphere2, sphere3};
		scene.setObjs(shapes);

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
		Scene scene = new Scene();
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

		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(512, 512, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		AABB box = s.getAABB();
		box.setTransformation(sphereMatrix);
		box.showBox();

		Shape[] objs = {floor, leftWall, rightWall, s, box};

		Scene scene = new Scene(512, 512);
		scene.setObjs(objs);
		scene.renderScene("boxVisualization");
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
			sceneBox.addAABB(cubes[i].getAABB());
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

			IntersectionPoint[] xs = g.intersect(ray);

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
		Scene scene = new Scene();
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

		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(750, 750, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		IntersectionPoint i = new IntersectionPoint(1, tri, 0.45, 0.25);

		IntersectionPoint[] xs = {i};

		Coordinate rayOrigin = new Coordinate(-0.2, 0.3, -2, Coordinate.POINT);
		Coordinate rayDirection = new Coordinate(0, 0, 1, Coordinate.VECTOR);

		Ray ray = new Ray(rayOrigin, rayDirection);

		Effect c = new Effect(i, ray, xs);

		Coordinate n = c.getNormalVector();

		n.printData();
	}

	public static void trumpetTest0() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\Trumpet.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		group.divide(5);

		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		AABB[] boxes = box.split();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void yWideTest() {
		Coordinate min = new Coordinate(-1, -2, -3, Coordinate.POINT);
		Coordinate max = new Coordinate(5, 8, 3, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.split();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void xWideTest() {
		Coordinate min = new Coordinate(-1, -2, -3, Coordinate.POINT);
		Coordinate max = new Coordinate(9, 5.5, 3, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.split();

		boxes[0].getMin().printData();
		boxes[0].getMax().printData();
		boxes[1].getMin().printData();
		boxes[1].getMax().printData();
	}

	public static void BVHTest() {
		Coordinate min = new Coordinate(-1, -4, -5, Coordinate.POINT);
		Coordinate max = new Coordinate(9, 6, 5, Coordinate.POINT);

		AABB box = new AABB(min, max, null);

		AABB[] boxes = box.split();

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
		IntersectionPoint[] xs;

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

		box.applyMatrix(matrix);

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

		b1.addAABB(b2);

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

		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -15, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		IntersectionPoint i = new IntersectionPoint(1, tri, 0.45, 0.25);
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

		IntersectionPoint[] xs = tri.localIntersect(ray);

		System.out.println("u: " + xs[0].getU());
		System.out.println("v: " + xs[0].getV());
	}

	public static void violinCaseTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\ViolinCase.obj");
		OBJParser p = new OBJParser(file);
		Group group = p.toGroup();
		group.setColour(new Colour(1, 0, 0));
		group.setTransformation(Matrix.translation(0, 1, 0));

		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		Scene scene = new Scene();
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
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(400, 400, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
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

		Scene scene = new Scene();
		Plane floor = new Plane();

		Shape[] objs = {floor, t1, t2, t3, t4, t5, t6, t7, t8};
		scene.setObjs(objs);

		Coordinate lightOrigin = new Coordinate(0, 10, 0, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		scene.setLight(new PointLight(lightOrigin, white));

		Camera camera = new Camera(200, 200, Math.PI / 3);
		camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 2, -5, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.POINT),
													  new Coordinate(0, 1, 0, Coordinate.VECTOR)));

		ImageOutput canvas = camera.render(scene);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}

		System.out.println("Computation Finished");
	}

}
