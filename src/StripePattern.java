
public class StripePattern extends Pattern{
	
	public StripePattern() {
		super();
	}
	
	public StripePattern(Colour colourA, Colour colourB) {
		super(colourA, colourB);
	}
	
	@Override
	public Colour stripeAt(Tuple point) {
		Colour result = (Math.floor(point.getX()) % 2 == 0) ? this.colourA : this.colourB;
		return result;
	}

}
