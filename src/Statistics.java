
public class Statistics {
	private static long TRIANGLE_INTERSECTION_COUNT = 0;
	private static long CUBE_INTERSECTION_COUNT = 0;
	private static long SPHERE_INTERSECTION_COUNT = 0;
	private static long PLANE_INTERSECTION_COUNT = 0;
	private static long GENERAL_INTERSECTION_COUNT = 0;
	
	public static void incrementTriangleIntersectionCount() {
		TRIANGLE_INTERSECTION_COUNT++;
		GENERAL_INTERSECTION_COUNT++;
	}
	
	public static void incrementCubeIntersectionCount() {
		CUBE_INTERSECTION_COUNT++;
		GENERAL_INTERSECTION_COUNT++;
	}
	
	public static void incrementSphereIntersectionCount() {
		SPHERE_INTERSECTION_COUNT++;
		GENERAL_INTERSECTION_COUNT++;
	}
	
	public static void incrementPlaneIntersectionCount() {
		PLANE_INTERSECTION_COUNT++;
		GENERAL_INTERSECTION_COUNT++;
	}
	
	public static long getTriangleIntersectionCount() {
		return TRIANGLE_INTERSECTION_COUNT;
	}
	
	public static long getCubeIntersectionCount() {
		return CUBE_INTERSECTION_COUNT;
	}
	
	public static long getSphereIntersectionCount() {
		return SPHERE_INTERSECTION_COUNT;
	}
	
	public static long getPlaneIntersectionCount() {
		return PLANE_INTERSECTION_COUNT;
	}
	
	public static long getGeneralIntersectionCount() {
		return GENERAL_INTERSECTION_COUNT;
	}
}
