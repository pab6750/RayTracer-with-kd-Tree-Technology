
public class GradientPattern extends Pattern{
	
	public GradientPattern() {
		super();
	}
	
	public GradientPattern(Colour colourA, Colour colourB) {
		super(colourA, colourB);
	}
	
	@Override
	public Colour stripeAt(Coordinate point) {
		Colour distance = this.colourB.subtractColours(this.colourA);
		double fraction = point.getX() - Math.floor(point.getX());
		Colour dividedDistance = distance.scalarMultiplication(fraction);
		
		return this.colourA.addColours(dividedDistance);
	}
}
