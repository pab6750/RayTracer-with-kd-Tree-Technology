import java.io.IOException;
import java.util.ArrayList;

public class World {
	private PointLight light;
	private Shape[] objs;
	private Camera camera;
	
	public World(int resx, int resy) {
		Tuple lightOrigin = new Tuple(-10, 10, -10, Tuple.POINT);
		Colour white = new Colour(1, 1, 1);
		
		this.light = new PointLight(lightOrigin, white);
		
		this.camera = new Camera(resx, resy, Math.PI / 3);
		this.camera.setTransform(Matrix.viewTransformation(new Tuple(0, 3, -10, Tuple.POINT),
													  new Tuple(0, 1, 0, Tuple.POINT),
													  new Tuple(0, 1, 0, Tuple.VECTOR)));
	}
	
	public World() {
		Tuple lightOrigin = new Tuple(-10, 10, -10, Tuple.POINT);
		Colour white = new Colour(1, 1, 1);
		
		this.light = new PointLight(lightOrigin, white);
		
		this.camera = new Camera(512, 512, Math.PI / 3);
		this.camera.setTransform(Matrix.viewTransformation(new Tuple(0, 3, -10, Tuple.POINT),
													  new Tuple(0, 1, 0, Tuple.POINT),
													  new Tuple(0, 1, 0, Tuple.VECTOR)));
	}
	
	public void renderWorld(String name) {
		Canvas canvas = this.camera.render(this, name);
		try {
			canvas.saveFile();
		} catch (IOException e) {
			System.out.println("File Error");
		}
		
		System.out.println("Computation Finished");
	}
	/**
	 * Computes the intersection of a ray.
	 * @param r The ray.
	 * @return The sorted list of intersections.
	 */
	public Intersection[] intersect(Ray r) {
		ArrayList<Intersection> intersects = new ArrayList<Intersection>();
		
		for(int i = 0; i < this.objs.length; i++) {
			Intersection[] current = this.objs[i].intersect(r);
			
			if(current != null) {
				for(int j = 0; j < current.length; j++) {
					intersects.add(current[j]);
				}
			}
		}
		
		Intersection[] result = new Intersection[intersects.size()];
		
		for(int i = 0; i < intersects.size(); i++) {
			result[i] = intersects.get(i);
		}
		
		result = Intersection.sortIntersections(result);
		
		return result;
	}
	
	/**
	 * determines the colour at a specific ray intersection.
	 * @param r The ray that intersects the scene.
	 * @param remaining a recursive cutoff for the computation.
	 * @return the colour of the pixel.
	 */
	public Colour colourAt(Ray r, int remaining) {
		Intersection[] intersects = this.intersect(r);
		Intersection hitPoint = Intersection.hit(intersects);
		
		if(hitPoint != null) {
			Computation comp = new Computation(hitPoint, r, intersects);
			
			return comp.shadeHit(this, remaining);
		} else {
			return new Colour(0, 0, 0);
		}
	}
	
	/**
	 * This method determines whether a point in the scene
	 * is in shadow or not.
	 * @param point The point.
	 * @return a boolean.
	 */
	public boolean isShadowed(Tuple point) {
		Tuple v = this.light.getPosition().subtractTuples(point);
		
		//distance between light and point
		double distance = v.magnitude();
		
		//direction from the point to the light
		Tuple direction = v.normalize();
		
		Ray r = new Ray(point, direction);
		Intersection[] intersections = this.intersect(r);
		
		//h is the closest intersection to the point
		Intersection h = Intersection.hit(intersections);
		
		if(h != null) {
			if(h.getT() < distance) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public PointLight getLight() {
		return light;
	}

	public Shape[] getObjs() {
		return objs;
	}

	public void setLight(PointLight light) {
		this.light = light;
	}

	public void setObjs(Shape[] objs) {
		this.objs = objs;
	}
}
