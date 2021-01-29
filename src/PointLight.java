
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
