
public class RingPattern extends Pattern{
	
	public RingPattern() {
		super();
	}
	
	public RingPattern(Colour colourA, Colour colourB) {
		super(colourA, colourB);
	}

	@Override
	public Colour stripeAt(Tuple point) {
		Colour result = (Math.floor(Math.sqrt(Math.pow(point.getX(), 2) + Math.pow(point.getZ(), 2))) % 2 == 0) ? this.colourA : this.colourB;
		return result;
	}

}
