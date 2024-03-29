/*
 * This class was inspired by the architecture proposed by Jamis Buck in his book: The Ray Tracer Challenge.
 * 
 * Reference at : �The Ray Tracer Challenge�. https://pragprog.com/titles/jbtracer/the-ray-tracer-challenge (accessed Apr. 15, 2021).
 */

import java.sql.Timestamp;

/**
 * This class encapsulates functionality for camera settings and positioning.
 * @author Pablo Scarpati
 *
 */
public class Camera {
	private double hsize;
	private double vsize;
	private double fieldOfView;
	private Matrix transform;
	private double halfWidth;
	private double halfHeight;
	private double pixelSize;
	
	public Camera(double hsize, double vsize, double fieldOfView, Matrix transform) {
		this.hsize = hsize;
		this.vsize = vsize;
		this.fieldOfView = fieldOfView;
		this.transform = transform;
		this.pixelSize = this.getPixelSize();
	}
	
	public Camera(double hsize, double vsize, double fieldOfView) {
		this.hsize = hsize;
		this.vsize = vsize;
		this.fieldOfView = fieldOfView;
		
		Coordinate cameraPosition = new Coordinate(0, 0, 0, Coordinate.POINT);
		Coordinate cameraDirection = new Coordinate(0, 0, -1, Coordinate.POINT);
		Coordinate up = new Coordinate(0, 1, 0, Coordinate.POINT);
		
		this.transform = Matrix.cameraTransformation(cameraPosition, cameraDirection, up);
		this.pixelSize = this.getPixelSize();
	}
	
	/**
	 * Creates a canvas instance containing the final image.
	 * @param scene The scene that is being rendered.
	 * @return the Canvas instance.
	 */
	public ImageOutput render(Scene scene) {
		Timestamp timestampBeforeRendering = new Timestamp(System.currentTimeMillis());
		ImageOutput image = new ImageOutput((int)this.vsize, (int)this.hsize);
		
		for(int y = 0; y < this.vsize; y++) {
			double progress = (y * this.hsize * 100) / (this.vsize * this.hsize);
			System.out.println("Rendering Process: " + progress + "%");
			
			for(int x = 0; x < this.hsize; x++) {
				Ray ray = this.rayForPixel(x, y);
				Colour colour = scene.colourAtPixel(ray, Effect.RECURSIVE_CUTOFF);
				image.writePixel(x, y, colour);
			}
		}
		
		Timestamp timestampAfterRendering = new Timestamp(System.currentTimeMillis());
		
		System.out.println("Rendering started on " + timestampBeforeRendering);
		System.out.println("Rendering finished on " + timestampAfterRendering);
		
		return image;
	}
	
	/**
	 * Creates a canvas instance containing the final image.
	 * @param scene The scene that is being rendered.
	 * @return the Canvas instance.
	 */
	public ImageOutput render(Scene scene, String name) {
		Timestamp timestampBeforeRendering = new Timestamp(System.currentTimeMillis());
		ImageOutput image = new ImageOutput((int)this.vsize, (int)this.hsize, name);
		
		for(int y = 0; y < this.vsize; y++) {
			double progress = (y * this.hsize * 100) / (this.vsize * this.hsize);
			System.out.println("Rendering Process: " + progress + "%");
			
			for(int x = 0; x < this.hsize; x++) {
				Ray ray = this.rayForPixel(x, y);
				Colour colour = scene.colourAtPixel(ray, Effect.RECURSIVE_CUTOFF);
				image.writePixel(x, y, colour);
			}
		}
		
		Timestamp timestampAfterRendering = new Timestamp(System.currentTimeMillis());
		
		System.out.println("Rendering started on " + timestampBeforeRendering);
		System.out.println("Rendering finished on " + timestampAfterRendering);
		
		return image;
	}
	
	/**
	 * Shoots a ray at the centre of the pixel.
	 * @param x The x coordinate of the pixel.
	 * @param y The y coordinate of the pixel.
	 * @return the Ray to be shot.
	 */
	public Ray rayForPixel(double x, double y) {
		//the offset from the edge of the canvas to the pixel's centre
		double xoffset = (x + 0.5) * this.pixelSize;
		double yoffset = (y + 0.5) * this.pixelSize;
		
		//the untransformed coordinates of the pixel in scene space
		//(remember that the camera looks toward -z, so +x is to the left)
		double sceneX = this.halfWidth - xoffset;
		double sceneY = this.halfHeight - yoffset;
		
		//using the camera matrix, transform the canvas point and the origin
		// and then compute the ray's direction vector
		//(remember that the canvas is at z = -1)
		Coordinate pixel = this.transform.invert().coordinateMultiplication(new Coordinate(sceneX, sceneY, -1, Coordinate.POINT));
		Coordinate origin = this.transform.invert().coordinateMultiplication(new Coordinate(0, 0, 0, Coordinate.POINT));
		Coordinate direction = pixel.subtractCoordinate(origin).normalize();
		
		return new Ray(origin, direction);
	}
	
	public double getHalfWidth() {
		return halfWidth;
	}

	public double getHalfHeight() {
		return halfHeight;
	}

	public double getPixelSize() {
		double halfView = Math.tan(this.fieldOfView / 2);
		double aspect = this.hsize / this.vsize;
		
		if(aspect >= 1) {
			this.halfWidth = halfView;
			this.halfHeight = halfView / aspect;
		} else {
			this.halfHeight = halfView;
			this.halfWidth = halfView * aspect;
		}
		
		return (halfWidth * 2) / this.hsize;
	}

	public double getHsize() {
		return hsize;
	}

	public double getVsize() {
		return vsize;
	}

	public double getFieldOfView() {
		return fieldOfView;
	}

	public Matrix getTransform() {
		return transform;
	}

	public void setFieldOfView(double fieldOfView) {
		this.fieldOfView = fieldOfView;
	}

	public void setTransform(Matrix transform) {
		this.transform = transform;
	}
	
	
}
