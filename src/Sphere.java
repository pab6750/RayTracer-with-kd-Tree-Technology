/**
 * This class extends Shape.
 * It encapsulates the functionality for representing a sphere.
 * @author Pablo Scarpati.
 *
 */
public class Sphere extends Shape{
	private Coordinate origin;
	
	public Sphere() {
		super();
		this.origin = new Coordinate(0, 0, 0, Coordinate.POINT);
	}
	
	public Sphere(Coordinate origin, double radius) {
		super();
		this.origin = origin;
	}
	
	/**
	 * A static method that produces a sphere with a glassy material.
	 * @return The sphere.
	 */
	public static Sphere getGlassSphere() {
		Sphere s = new Sphere();
		Material m = new Material();
		m.setTransparency(1);
		m.setRefractiveIndex(1.5);
		
		s.setMaterial(m);
		
		return s;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}
	
	/**
	 * It returns the bounding box surrounding the Sphere.
	 * @return The bounding box.
	 */
	@Override
	public AABB getBounds() {
		Coordinate min = new Coordinate(-1, -1, -1, Coordinate.POINT);
		Coordinate max = new Coordinate(1, 1, 1, Coordinate.POINT);
		AABB box = new AABB(min, max, this);
		
		return box;
	}
	
	/**
	 * It produces the intersection between a ray and the current sphere.
	 * @return the list of intersections.
	 */
	@Override
	public Intersection[] localIntersect(Ray r) {
		AABB bbox = this.getBounds();
		Intersection[] xs = bbox.intersect(r);
		
		if(xs != null) {
			Intersection[] intersectionPoints;
			
			//a vector from the sphere's centre to the ray's origin
			Coordinate sphereToRay = r.getOrigin().subtractCoordinate(new Coordinate(0, 0, 0, Coordinate.POINT));
			double a = r.getDirection().dotProduct(r.getDirection());
			double b = 2 * r.getDirection().dotProduct(sphereToRay);
			double c = sphereToRay.dotProduct(sphereToRay) - 1;
			
			//the discriminant determines the number of intersections.
			double discriminant = (b * b) - (4 * a * c);
			
			if(discriminant < 0) {
				//case where there are no intersections
				return null;
			} else if(discriminant == 0) {
				//case in which there are 2 intersections (but they are both the same)
				double p = (b * -1) / (2 * a);
				
				Intersection i = new Intersection(p, this);
				Intersection[] set = {i,i};
				intersectionPoints = Intersection.sortIntersections(set);
			} else {
				//case where there are 2 intersections (but they are different)
				double p1 = (-b - Math.sqrt(discriminant)) / (2 * a);
				double p2 = (-b + Math.sqrt(discriminant)) / (2 * a);
				
				Intersection i1 = new Intersection(p1, this);
				Intersection i2 = new Intersection(p2, this);
				Intersection[] set = {i1,i2};
				
				intersectionPoints = Intersection.sortIntersections(set);
			}
			
			return intersectionPoints;
		} else {
			return null;
		}
	}
	
	/**
	 * Determines the normal at the point
	 * @return the normal Tuple.
	 */
	@Override
	public Coordinate localNormalAt(Coordinate worldPoint, Intersection hit) {
		Coordinate originPoint = new Coordinate(0, 0, 0, Coordinate.POINT);
		return worldPoint.subtractCoordinate(originPoint);
	}
	
	@Override
	public void printData() {
		this.origin.printData();
	}
}
