/*
 * This class was inspired by the architecture proposed by Jamis Buck in his book: The Ray Tracer Challenge.
 * 
 * Reference at : ‘The Ray Tracer Challenge’. https://pragprog.com/titles/jbtracer/the-ray-tracer-challenge (accessed Apr. 15, 2021).
 */


import java.io.IOException;
import java.util.ArrayList;

public class Scene {
	private PointLight light;
	private Shape[] objs;
	private Camera camera;
	
	public Scene(int resx, int resy) {
		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		
		this.light = new PointLight(lightOrigin, white);
		
		this.camera = new Camera(resx, resy, Math.PI / 3);
		this.camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													       new Coordinate(0, 1, 0, Coordinate.POINT),
													       new Coordinate(0, 1, 0, Coordinate.VECTOR)));
	}
	
	public Scene() {
		Coordinate lightOrigin = new Coordinate(-10, 10, -10, Coordinate.POINT);
		Colour white = new Colour(1, 1, 1);
		
		this.light = new PointLight(lightOrigin, white);
		
		this.camera = new Camera(512, 512, Math.PI / 3);
		this.camera.setTransform(Matrix.cameraTransformation(new Coordinate(0, 3, -10, Coordinate.POINT),
													       new Coordinate(0, 1, 0, Coordinate.POINT),
													       new Coordinate(0, 1, 0, Coordinate.VECTOR)));
	}
	
	public void renderScene(String name) {
		ImageOutput canvas = this.camera.render(this, name);
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
	public IntersectionPoint[] intersect(Ray r) {
		ArrayList<IntersectionPoint> intersects = new ArrayList<IntersectionPoint>();
		
		for(int i = 0; i < this.objs.length; i++) {
			IntersectionPoint[] current = this.objs[i].intersect(r);
			
			if(current != null) {
				for(int j = 0; j < current.length; j++) {
					intersects.add(current[j]);
				}
			}
		}
		
		IntersectionPoint[] result = new IntersectionPoint[intersects.size()];
		
		for(int i = 0; i < intersects.size(); i++) {
			result[i] = intersects.get(i);
		}
		
		result = IntersectionPoint.sortIntersections(result);
		
		return result;
	}
	
	/**
	 * determines the colour at a specific ray intersection.
	 * @param r The ray that intersects the scene.
	 * @param remaining a recursive cutoff for the computation.
	 * @return the colour of the pixel.
	 */
	public Colour colourAtPixel(Ray r, int remaining) {
		IntersectionPoint[] intersects = this.intersect(r);
		IntersectionPoint hitPoint = IntersectionPoint.closestIntersection(intersects);
		
		if(hitPoint != null) {
			Effect effect = new Effect(hitPoint, r, intersects);
			
			return effect.finalColour(this, remaining);
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
	public boolean isShadowed(Coordinate point) {
		Coordinate v = this.light.getPosition().subtractCoordinate(point);
		
		//distance between light and point
		double distance = v.magnitude();
		
		//direction from the point to the light
		Coordinate direction = v.normalize();
		
		Ray r = new Ray(point, direction);
		IntersectionPoint[] intersections = this.intersect(r);
		
		//h is the closest intersection to the point
		IntersectionPoint h = IntersectionPoint.closestIntersection(intersections);
		
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
