/* The overall structure of this Ray Tracer was taken by the book 'The Ray Tracer Challenge' by Jamis Buck*/

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
		//lakeSimulation();
		//kdTreeTest4();
		bunnyTest();
        //appendixImage2();
		//halfTimeTest();
		//boxCheck();
		//SAHNaiveTest();
		//SAHInterceptionTimeTest();
		//bunnyDepthTest();
		//uniformDistribution();
		//ununiformDistribution();
	}
	
	public static void ununiformDistribution() {
		Shape[] spheres = new Shape[100];
		
		for(int i = 0; i < spheres.length / 2; i++) {
			spheres[i] = new Sphere();
			Matrix m = Matrix.translation((i * 10) - 100, 0, 500);
			spheres[i].setTransformation(m);
		}
		
		for(int i = spheres.length / 2; i < spheres.length; i++) {
			spheres[i] = new Sphere();
			Matrix m = Matrix.translation((i * 10) + 100, 0, 500);
			spheres[i].setTransformation(m);
		}
		
		SAHKDTree skdt = SAHKDTree.createRoot(spheres);
		skdt.buildTree();
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(spheres);
		scene.renderScene("UnUniformSpace");
		
		System.out.println("Intersections per pixel: " + (Statistics.getSphereIntersectionCount() / (512 * 512)));
	}
	
	//rendering time: 20 mins
	//building time: 
	//intersections per pixel: 100
	public static void uniformDistribution() {
		Shape[] spheres = new Shape[100];
		
		for(int i = 0; i < spheres.length; i++) {
			spheres[i] = new Sphere();
			Matrix m = Matrix.translation(i * 10, 0, 500);
			spheres[i].setTransformation(m);
		}
		
		SAHKDTree skdt = SAHKDTree.createRoot(spheres);
		skdt.buildTree();
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(spheres);
		scene.renderScene("UniformSpace");
		
		System.out.println("Intersections per pixel: " + (Statistics.getSphereIntersectionCount() / (512 * 512)));
	}
	
	//SPATIAL: 55 intercepts per pixel
	//MEDIAN: 74 intercepts per pixel
	//SAH: 70
	public static void bunnyDepthTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\Dissertation\\OBJFiles\\Bunny.obj");
		OBJParser p = new OBJParser(file);
		Shape[] shapes = p.getFaces();
		Shape[] shapesMinusNull = new Shape[shapes.length - 1];
		System.arraycopy(shapes, 1, shapesMinusNull, 0, shapes.length - 1);

		Matrix m = Matrix.scaling(2, 2, 2);

		for(int i = 0; i < shapesMinusNull.length; i++) {
			shapesMinusNull[i].setTransformation(m);
		}
		
		SAHKDTree skdt = SAHKDTree.createRoot(shapesMinusNull);
		skdt.buildTree();
		
		Shape[] kdts = {skdt};
		
	    Scene scene = new Scene(512, 512);
		scene.setObjs(kdts);
		scene.renderScene("Bunny");
				
		System.out.println("Intersections per pixel: " + (Statistics.getTriangleIntersectionCount() / (512 * 512)));
		
	}
	
	/*
	 * It looks like SAH may not be worth being used with small scenes even more so than Median
	 * This is because median can use splitting points that arent bbox points, while SAH cant.
	 * This means that with SAH, one side may be 
	 * Without KDT  = 4 mins 05 secs
	 * With SAH     = 2 mins 30 secs
	 * With Median  = 1 mins 22 secs
	 * With Spatial = 1 mins 30 secs
	 */
	public static void SAHInterceptionTimeTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();
		Sphere s5 = new Sphere();
		Sphere s6 = new Sphere();
		Sphere s7 = new Sphere();
		Sphere s8 = new Sphere();
		Sphere s9 = new Sphere();
		Sphere sa = new Sphere();
		Sphere sb = new Sphere();
		Sphere sc = new Sphere();
		Sphere sd = new Sphere();
		Sphere se = new Sphere();
		Sphere sf = new Sphere();
		Sphere sg = new Sphere();
		Sphere sh = new Sphere();
		
		Matrix m1 = Matrix.translation(-50, 0, 0);
		Matrix m2 = Matrix.translation(-45, 0, 0);
		Matrix m3 = Matrix.translation(-40, 0, 0);
		Matrix m4 = Matrix.translation(-35, 0, 0);
		Matrix m5 = Matrix.translation(-30, 0, 0);
		Matrix m6 = Matrix.translation(-25, 0, 0);
		Matrix m7 = Matrix.translation(-20, 0, 0);
		Matrix m8 = Matrix.translation(-15, 0, 0);
		Matrix m9 = Matrix.translation(-10, 0, 0);
		Matrix ma = Matrix.translation(-5, 0, 0);
		Matrix mb = Matrix.translation(0, 0, 0);
		Matrix mc = Matrix.translation(5, 0, 0);
		Matrix md = Matrix.translation(10, 0, 0);
		Matrix me = Matrix.translation(15, 0, 0);
		Matrix mf = Matrix.translation(20, 0, 0);
		Matrix mg = Matrix.translation(25, 0, 0);
		Matrix mh = Matrix.translation(30, 0, 0);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		s4.setTransformation(m4);
		s5.setTransformation(m5);
		s6.setTransformation(m6);
		s7.setTransformation(m7);
		s8.setTransformation(m8);
		s9.setTransformation(m9);
		sa.setTransformation(ma);
		sb.setTransformation(mb);
		sc.setTransformation(mc);
		sd.setTransformation(md);
		se.setTransformation(me);
		sf.setTransformation(mf);
		sg.setTransformation(mg);
		sh.setTransformation(mh);
		
		Shape[] objects = {s1, s2, s3, s4, s5, s6, s7, s8, s9, sa, sb, sc, sd, se, sf, sg, sh};
		
		MedianKDTree kdt = MedianKDTree.createRoot(objects);
		//kdt.split(0, 1);
		//kdt.split(1, 2);
		kdt.buildTree();
		kdt.printTreeWithData();
		
		//Shape[] kdts = {kdt};
		
		//Scene scene = new Scene(512, 512);
		//scene.setObjs(objects);
		//scene.setObjs(kdts);
		//scene.renderScene("HalfTimeSimulation");
		
		//8
		//System.out.println("Intersections per pixel: " + (Statistics.getSphereIntersectionCount() / (512 * 512)));
	}
	
	//SAH with 200 spheres : built in 41s rendering time 1h KI = 1 and KT = 1
	//SAH with 200 spheres : built in 41s rendering time 50mins KI = 0.5 and KT = 0.5
	//SAH with 200 spheres : built in 41s rendering time 54mins KI = 2.0 and KT = 0.5
	//Spatial with 200 spheres : built in 2ms rendering time 13 mins
	public static void SAHNaiveTest() {
		Shape[] ss = new Shape[200];
		
		for(int i = 0; i < ss.length; i++) {
			ss[i] = new Sphere();
			
			Matrix m = Matrix.translation((Math.random() * 100) - 50, (Math.random() * 100) - 50, (Math.random() * 100) - 50);
			
			ss[i].setTransformation(m);
		}
		
		//SpatialKDTree sakdt = SpatialKDTree.createRoot(ss);
		SAHKDTree sakdt = SAHKDTree.createRoot(ss);
		sakdt.buildTree();
		
		Shape[] objs = {sakdt};
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(objs);
		scene.renderScene("SAHTest1");
	}
	
	public static void boxCheck() {
		Sphere s = new Sphere();
		
		AABB b = s.getAABB();
		
		b.printData();
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
		
		Scene scene = new Scene(128, 128);
		scene.setObjs(kdtList);
		scene.renderScene("HalfTimeSimulation2");
	}
	
	/*
	 * Rendering started on 2021-02-05 12:01:17.95
     * Rendering finished on 2021-02-05 12:06:29.212
     *  = 5 mins 12 secs
     * 
     * 
	 */
	public static void halfTimeTest() {
		Sphere s1 = new Sphere();
		Sphere s2 = new Sphere();
		Sphere s3 = new Sphere();
		Sphere s4 = new Sphere();
		Sphere s5 = new Sphere();
		Sphere s6 = new Sphere();
		Sphere s7 = new Sphere();
		Sphere s8 = new Sphere();
		Sphere s9 = new Sphere();
		Sphere sa = new Sphere();
		Sphere sb = new Sphere();
		Sphere sc = new Sphere();
		Sphere sd = new Sphere();
		Sphere se = new Sphere();
		Sphere sf = new Sphere();
		Sphere sg = new Sphere();
		Sphere sh = new Sphere();
		
		Matrix m1 = Matrix.translation(-20, 0, 0);
		Matrix m2 = Matrix.translation(-18, 0, 0);
		Matrix m3 = Matrix.translation(-16, 0, 0);
		Matrix m4 = Matrix.translation(-14, 0, 0);
		Matrix m5 = Matrix.translation(-12, 0, 0);
		Matrix m6 = Matrix.translation(-10, 0, 0);
		Matrix m7 = Matrix.translation(-8, 0, 0);
		Matrix m8 = Matrix.translation(-6, 0, 0);
		Matrix m9 = Matrix.translation(-4, 0, 0);
		Matrix ma = Matrix.translation(-2, 0, 0);
		Matrix mb = Matrix.translation(0, 0, 0);
		Matrix mc = Matrix.translation(2, 0, 0);
		Matrix md = Matrix.translation(4, 0, 0);
		Matrix me = Matrix.translation(6, 0, 0);
		Matrix mf = Matrix.translation(8, 0, 0);
		Matrix mg = Matrix.translation(10, 0, 0);
		Matrix mh = Matrix.translation(12, 0, 0);
		
		s1.setTransformation(m1);
		s2.setTransformation(m2);
		s3.setTransformation(m3);
		s4.setTransformation(m4);
		s5.setTransformation(m5);
		s6.setTransformation(m6);
		s7.setTransformation(m7);
		s8.setTransformation(m8);
		s9.setTransformation(m9);
		sa.setTransformation(ma);
		sb.setTransformation(mb);
		sc.setTransformation(mc);
		sd.setTransformation(md);
		se.setTransformation(me);
		sf.setTransformation(mf);
		sg.setTransformation(mg);
		sh.setTransformation(mh);
		
		Shape[] objects = {s1, s2, s3, s4, s5, s6, s7, s8, s9, sa, sb, sc, sd, se, sf, sg, sh};
		
		SpatialKDTree kdt = SpatialKDTree.createRoot(objects);
		kdt.split(0, 1);
		//kdt.build();
		kdt.printTreeWithData();
		
		Shape[] kdts = {kdt};
		
		Scene scene = new Scene(512, 512);
		scene.setObjs(kdts);
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
		kdt.buildTree();

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
		kdt.buildTree();

		Shape[] sceneList = {kdt};

		Scene scene = new Scene(200, 200);
		scene.setObjs(sceneList);
		scene.renderScene("medianResult3");
	}
	//building with SAH: 2 mins 30 secs
	//rendering with SAH: 10 mins
	//building with median: 1 secs
	//rendering with median: 12 mins
	//building with spatial: 0.2 secs
	//rendering with median: 9 mins 30 secs
	public static void bunnyTest() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\Dissertation\\OBJFiles\\Bunny.obj");
		OBJParser p = new OBJParser(file);
		Shape[] shapes = p.getFaces();
		Shape[] shapesMinusNull = new Shape[shapes.length - 1];
		System.arraycopy(shapes, 1, shapesMinusNull, 0, shapes.length - 1);

		Matrix m = Matrix.scaling(2, 2, 2);

		for(int i = 0; i < shapesMinusNull.length; i++) {
			shapesMinusNull[i].setTransformation(m);
		}
		
		/*System.out.println("Building Process Started");
		SpatialKDTree skdt = SpatialKDTree.createRoot(shapesMinusNull);
		skdt.buildTree();
		Shape[] objs = {skdt};
		System.out.println("Building Process Ended");
		*/
		/*System.out.println("Building Process Started");
		MedianKDTree mkdt = MedianKDTree.createRoot(shapesMinusNull);
		mkdt.buildTree();
		Shape[] objs2 = {mkdt};
		System.out.println("Building Process Ended");*/
		//
		SAHKDTree sakdt = SAHKDTree.createRoot(shapesMinusNull);
		sakdt.buildTree();
		Shape[] objs3 = {sakdt};

		Scene scene = new Scene(512, 512);
		scene.setObjs(objs3);

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
		kdt.buildTree();
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
		kdt.buildTree();

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
		kdt.buildTree();

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
		kdt.buildTree();

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

	public static void smoothTriangleTest2() {
		File file = new File("C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\year 3\\Diss\\OBJFiles\\objTest4.obj");
		OBJParser p = new OBJParser(file);

		Coordinate[] normals = p.getNormals();

		for(int i = 1; i < normals.length; i++) {
			normals[i].printData();
			System.out.println("------------");
		}
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
