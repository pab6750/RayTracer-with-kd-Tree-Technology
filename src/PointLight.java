/*
 * This class was inspired by the architecture proposed by Jamis Buck in his book: The Ray Tracer Challenge.
 * 
 * Reference at : ‘The Ray Tracer Challenge’. https://pragprog.com/titles/jbtracer/the-ray-tracer-challenge (accessed Apr. 15, 2021).
 */



public class PointLight {
	private Coordinate position;
	private Colour intensity;
	
	public PointLight() {
		this.position = new Coordinate(0, 0, 0, Coordinate.POINT);
		this.intensity = new Colour(0, 0, 0);
	}
	
	public PointLight(Coordinate position, Colour intensity) {
		this.position = position;
		this.intensity = intensity;
	}

	public Coordinate getPosition() {
		return position;
	}

	public Colour getIntensity() {
		return intensity;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	public void setIntensity(Colour intensity) {
		this.intensity = intensity;
	}
	
	
}
