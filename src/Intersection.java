

public class Intersection {
	private double t;
	private Shape object;
	
	//u and v will be floating points between 0 and 1
	//they will represent the position of the intersection point in relation to the vertices
	private double u;
	private double v;
	
	public Intersection(double t, Shape object) {
		this.t = t;
		this.object = object;
	}
	
	public Intersection(double t, Shape object, double u, double v) {
		this.t = t;
		this.object = object;
		this.u = u;
		this.v = v;
	}
	
	public double getU() {
		return u;
	}

	public double getV() {
		return v;
	}

	public void setU(double u) {
		this.u = u;
	}

	public void setV(double v) {
		this.v = v;
	}

	public double getT() {
		return this.t;
	}
	
	public Shape getObject() {
		return this.object;
	}
	
	public void printData() {
		System.out.println("t: " + this.t);
	}
	
	public static Intersection hit(Intersection[] intersectionArray) {
		if(intersectionArray.length != 0) {
			double current = intersectionArray[0].getT();
			int index = 0;
			
			for(int i = 1; i < intersectionArray.length; i++) {
				double value = intersectionArray[i].getT();
				
				if(current < 0) {
					current = value;
				}
				
				if(value >= 0 && value <= current) {
					current = value;
					index = i;
				}
			}
			
			if(intersectionArray[index].getT() >= 0) {
				return intersectionArray[index];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public static Intersection[] sortIntersections(Intersection[] intersectionsList) {
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < intersectionsList.length - 1; i++) {
				if(intersectionsList[i].getT() > intersectionsList[i + 1].getT()) {
					Intersection temp = intersectionsList[i];
					intersectionsList[i] = intersectionsList[i + 1];
					intersectionsList[i + 1] = temp;
					sorted = false;
				}
				
			}
		}
		
		return intersectionsList;
	}
}
