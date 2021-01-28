
public class Material {
	public static final double VACUUM = 1;
	public static final double AIR = 1.00029;
	public static final double WATER = 1.333;
	public static final double GLASS = 1.52;
	public static final double DIAMOND = 2.417;
	
	private double ambient;
	private double diffuse;
	private double specular;
	private double shininess;
	private Colour colour;
	private Pattern pattern;
	private double reflective;
	private double transparency;
	private double refractiveIndex;
	
	public Material() {
		this.setAmbient(0.1);
		this.setDiffuse(0.9);
		this.setSpecular(0.9);
		this.setShininess(200);
		this.setColour(new Colour(1, 1, 1));
		this.setReflective(0);
		this.pattern = null;
		this.transparency = 0;
		this.refractiveIndex = VACUUM;
	}
	
	public Material(double ambient, 
					double diffuse, 
					double specular, 
					double shininess, 
					double reflective, 
					double transparency, 
					double refractiveIndex,
					Colour colour) {
		
		
		this.setAmbient(ambient);
		this.setDiffuse(diffuse);
		this.setSpecular(specular);
		this.setShininess(shininess);
		this.setColour(colour);
		this.setReflective(reflective);
		this.pattern = null;
		this.setRefractiveIndex(refractiveIndex);
		this.setTransparency(transparency);
	}
	
	public double getTransparency() {
		return transparency;
	}

	public double getRefractiveIndex() {
		return refractiveIndex;
	}

	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

	public void setRefractiveIndex(double refractiveIndex) {
		this.refractiveIndex = refractiveIndex;
	}

	public double getReflective() {
		return reflective;
	}

	public void setReflective(double reflective) {
		if(reflective > 1) {
			this.reflective = 1;
		} else if(reflective < 0) {
			this.reflective = 0;
		} else {
			this.reflective = reflective;
		}
	}
	
	public void setDefaultReflective() {
		this.setDiffuse(0);
		this.setReflective(1);
	}
	
	public void setDefaultRefractive() {
		this.setDiffuse(0);
		this.setReflective(0.5);
		this.setTransparency(0.9);
		this.setRefractiveIndex(Material.WATER);
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public double getAmbient() {
		return ambient;
	}

	public double getDiffuse() {
		return diffuse;
	}

	public double getSpecular() {
		return specular;
	}

	public double getShininess() {
		return shininess;
	}
	
	public Colour getColour() {
		return colour;
	}

	public void setAmbient(double ambient) {
		this.ambient = Math.abs(ambient);
	}

	public void setDiffuse(double diffuse) {
		this.diffuse = Math.abs(diffuse);
	}

	public void setSpecular(double specular) {
		this.specular = Math.abs(specular);
	}

	public void setShininess(double shininess) {
		this.shininess = Math.abs(shininess);
	}
	
	public void setColour(Colour colour) {
		this.colour = colour;
	}
}
