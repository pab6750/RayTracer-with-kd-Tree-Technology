
public abstract class Pattern {
	protected Colour colourA;
	protected Colour colourB;
	protected Matrix transformation;
	
	public Pattern() {
		this.colourA = new Colour(1, 1, 1);
		this.colourB = new Colour(0, 0, 0);
		this.transformation = new Matrix(4);
		this.transformation.setIdentityMatrix();
	}
	
	public Pattern(Colour colourA, Colour colourB) {
		this.colourA = colourA;
		this.colourB = colourB;
		this.transformation = new Matrix(4);
		this.transformation.setIdentityMatrix();
	}
	
	public Matrix getTransformation() {
		return transformation;
	}

	public void setTransformation(Matrix transformation) {
		this.transformation = transformation;
	}

	protected abstract Colour stripeAt(Tuple point);
	
	public Colour stripeAtObject(Shape object, Tuple point) {
		//Tuple objectPoint = object.getTransformation().invert().tupleMultiplication(point);
		Tuple objectPoint = object.worldToObject(point);
		Tuple patternPoint = this.getTransformation().invert().tupleMultiplication(objectPoint);
		
		return this.stripeAt(patternPoint);
	}

	public Colour getColourA() {
		return colourA;
	}

	public Colour getColourB() {
		return colourB;
	}

	public void setColourA(Colour colourA) {
		this.colourA = colourA;
	}

	public void setColourB(Colour colourB) {
		this.colourB = colourB;
	}
	
	public void printData() {
		System.out.println("Colour A:");
		this.colourA.printData();
		System.out.println("Colour B:");
		this.colourB.printData();
		System.out.println("Transformation:");
		this.transformation.printData();
	}
}
