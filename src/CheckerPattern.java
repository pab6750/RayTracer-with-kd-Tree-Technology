
public class CheckerPattern extends Pattern {
	
	public CheckerPattern() {
		super();
	}
	
	public CheckerPattern(Colour colourA, Colour colourB) {
		super(colourA, colourB);
	}

	@Override
	public Colour stripeAt(Tuple point) {
		Colour result = ((Math.floor(point.getX()) + Math.floor(point.getY()) + Math.floor(point.getZ())) % 2 == 0) ? this.colourA : this.colourB;
		return result;
	}
	
}
