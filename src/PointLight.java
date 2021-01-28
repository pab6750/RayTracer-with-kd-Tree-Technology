
public class PointLight {
	private Tuple position;
	private Colour intensity;
	
	public PointLight() {
		this.position = new Tuple(0, 0, 0, Tuple.POINT);
		this.intensity = new Colour(0, 0, 0);
	}
	
	public PointLight(Tuple position, Colour intensity) {
		this.position = position;
		this.intensity = intensity;
	}

	public Tuple getPosition() {
		return position;
	}

	public Colour getIntensity() {
		return intensity;
	}

	public void setPosition(Tuple position) {
		this.position = position;
	}

	public void setIntensity(Colour intensity) {
		this.intensity = intensity;
	}
	
	
}
