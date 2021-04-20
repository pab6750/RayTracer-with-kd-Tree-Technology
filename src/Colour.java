/*
 * This class was inspired by the architecture proposed by Jamis Buck in his book: The Ray Tracer Challenge.
 * 
 * Reference at : ‘The Ray Tracer Challenge’. https://pragprog.com/titles/jbtracer/the-ray-tracer-challenge (accessed Apr. 15, 2021).
 */


public class Colour {
	public static final Colour WHITE = new Colour(1, 1, 1);
	public static final Colour BLACK = new Colour(0, 0, 0);
	
    private double r;
    private double g;
    private double b;
    
    public Colour(double c){
        r = c;
        g = c;
        b = c;
    }

    public Colour(double r, double g, double b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Colour addColours(Colour c){
    	double newR = r + c.r;
    	double newG = g + c.g;
    	double newB = b + c.b;
    	
    	newR = (newR >= 1) ? 1 : newR;
    	newG = (newG >= 1) ? 1 : newG;
    	newB = (newB >= 1) ? 1 : newB;

        return new Colour(newR, newG, newB);
    }

    public Colour subtractColours(Colour c){
    	double newR = r - c.r;
    	double newG = g - c.g;
    	double newB = b - c.b;

        return new Colour(newR, newG, newB);
    }

    public Colour scalarMultiplication(double scalar){
    	double newR = r * scalar;
    	double newG = g * scalar;
    	double newB = b * scalar;

        return new Colour(newR, newG, newB);
    }

    public Colour scalarDivision(double scalar){
    	double divisionFactor = 1/scalar;

    	double newR = r * divisionFactor;
    	double newG = g * divisionFactor;
    	double newB = b * divisionFactor;

        return new Colour(newR, newG, newB);
    }

    public Colour colourProduct(Colour c){
    	double newR = r * c.r;
    	double newG = g * c.g;
    	double newB = b * c.b;

        return new Colour(newR, newG, newB);
    }
    
    public int scaleR() {
    	return (int)(this.r * 255);
    }
    
    public int scaleG() {
    	return (int)(this.g * 255);
    }
    
    public int scaleB() {
    	return (int)(this.b * 255);
    }
    
    public double getR() {
    	return this.r;
    }
    
    public double getG() {
    	return this.g;
    }
    
    public double getB() {
    	return this.b;
    }

    public void printData(){
        System.out.println("r: " + this.r);
        System.out.println("g: " + this.g);
        System.out.println("b: " + this.b);
    }
    
    public void PrintDataScaled() {
    	System.out.println("r: " + this.scaleR());
        System.out.println("g: " + this.scaleG());
        System.out.println("b: " + this.scaleB());
    }
    
    public boolean isEqual(Colour c) {
    	return Effect.compareDouble(this.getR(), c.getR()) &&
    		   Effect.compareDouble(this.getG(), c.getG()) &&
    		   Effect.compareDouble(this.getB(), c.getB());
    }
}
