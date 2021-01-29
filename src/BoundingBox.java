import java.util.ArrayList;

public class BoundingBox extends Shape{
	private Shape owner;
	private Coordinate min;
	private Coordinate max;
	
	public BoundingBox(Shape owner) {
		this.min = new Coordinate(Double.POSITIVE_INFINITY,
							      Double.POSITIVE_INFINITY,
							      Double.POSITIVE_INFINITY,
							      Coordinate.POINT);
		
		this.max = new Coordinate(Double.NEGATIVE_INFINITY,
							      Double.NEGATIVE_INFINITY,
							      Double.NEGATIVE_INFINITY,
							      Coordinate.POINT);
		
		this.owner = owner;
	}
	
	public BoundingBox(Coordinate min, Coordinate max, Shape owner) {
		this.min = min;
		this.max = max;
		this.owner = owner;
	}
	
	public BoundingBox(Coordinate v1, Coordinate v2, Coordinate v3, Shape owner) {
		double temp;
		
		temp = Math.min(v1.getX(), v2.getX());
		double minX = Math.min(temp, v3.getX());
		
		temp = Math.min(v1.getY(), v2.getY());
		double minY = Math.min(temp, v3.getY());
		
		temp = Math.min(v1.getZ(), v2.getZ());
		double minZ = Math.min(temp, v3.getZ());
		
		temp = Math.max(v1.getX(), v2.getX());
		double maxX = Math.max(temp, v3.getX());
		
		temp = Math.max(v1.getY(), v2.getY());
		double maxY = Math.max(temp, v3.getY());
		
		temp = Math.max(v1.getZ(), v2.getZ());
		double maxZ = Math.max(temp, v3.getZ());
		
		Coordinate minimum = new Coordinate(minX, minY, minZ, Coordinate.POINT);
		Coordinate maximum = new Coordinate(maxX, maxY, maxZ, Coordinate.POINT);
		
		this.min = minimum;
		this.max = maximum;
		this.owner = owner;
	}
	
	public void showBox() {
		Colour gray = new Colour(0.7, 0.7, 0.7);
		this.material = new Material(0.1, 0, 0.9, 200, 0, 0.8, Material.VACUUM, gray);
	}
	
	public BoundingBox transform(Matrix matrix) {
		BoundingBox box = new BoundingBox(this.owner);
	    
		Coordinate p1 = new Coordinate(this.min.getX(), this.min.getY(), this.min.getZ(), Coordinate.POINT);
		Coordinate p2 = new Coordinate(this.min.getX(), this.min.getY(), this.max.getZ(), Coordinate.POINT);
		Coordinate p3 = new Coordinate(this.min.getX(), this.max.getY(), this.min.getZ(), Coordinate.POINT);
		Coordinate p4 = new Coordinate(this.min.getX(), this.max.getY(), this.max.getZ(), Coordinate.POINT);
		Coordinate p5 = new Coordinate(this.max.getX(), this.min.getY(), this.min.getZ(), Coordinate.POINT);
		Coordinate p6 = new Coordinate(this.max.getX(), this.min.getY(), this.max.getZ(), Coordinate.POINT);
		Coordinate p7 = new Coordinate(this.max.getX(), this.max.getY(), this.min.getZ(), Coordinate.POINT);
		Coordinate p8 = new Coordinate(this.max.getX(), this.max.getY(), this.max.getZ(), Coordinate.POINT);
		
		Coordinate[] p = {p1, p2, p3, p4, p5, p6, p7, p8};
		
		for(int i = 0; i < p.length; i++) {
			box.addPoint(matrix.coordinateMultiplication(p[i]));
		}
		
		return box;
	}
	
	public boolean containsBox(BoundingBox box) {
		return this.containsPoint(box.getMin()) && this.containsPoint(box.getMax());
	}
	
	public boolean containsPoint(Coordinate point) {
		return point.getX() >= this.min.getX() && point.getX() <= this.max.getX() &&
			   point.getY() >= this.min.getY() && point.getY() <= this.max.getY() &&
			   point.getZ() >= this.min.getZ() && point.getZ() <= this.max.getZ();
	}
	
	public void addBox(BoundingBox box) {
		this.addPoint(box.getMin());
		this.addPoint(box.getMax());
	}
	
	public void addPoint(Coordinate point) {
		if(point.getX() > this.max.getX()) {
			this.max.setX(point.getX());
		}
		
		if(point.getY() > this.max.getY()) {
			this.max.setY(point.getY());
		}
		
		if(point.getZ() > this.max.getZ()) {
			this.max.setZ(point.getZ());
		}
		
		if(point.getX() < this.min.getX()) {
			this.min.setX(point.getX());
		}
		
		if(point.getY() < this.min.getY()) {
			this.min.setY(point.getY());
		}
		
		if(point.getZ() < this.min.getZ()) {
			this.min.setZ(point.getZ());
		}
	}

	public Coordinate getMin() {
		return min;
	}

	public Coordinate getMax() {
		return max;
	}
	
	public Shape getOwner() {
		return this.owner;
	}
	
	public BoundingBox[] splitBounds() {
		double sizeX = Math.abs(this.max.getX() - this.min.getX());
		double sizeY = Math.abs(this.max.getY() - this.min.getY());
		double sizeZ = Math.abs(this.max.getZ() - this.min.getZ());
		
		double temp = Math.max(sizeX, sizeY);
		double maxDimension = Math.max(temp, sizeZ);
		
		double x0 = this.min.getX();
		double y0 = this.min.getY();
		double z0 = this.min.getZ();
		double x1 = this.max.getX();
		double y1 = this.max.getY();
		double z1 = this.max.getZ();
		
		if(maxDimension == sizeX) {
			x1 = x0 + sizeX / 2;
			x0 = x0 + sizeX / 2;
		} else if(maxDimension == sizeY) {
			y1 = y0 + sizeY / 2;
			y0 = y0 + sizeY / 2;
		} else {
			z1 = z0 + sizeZ / 2;
			z0 = z0 + sizeZ / 2;
		}
		
		Coordinate midMin = new Coordinate(x0, y0, z0, Coordinate.POINT);
		Coordinate midMax = new Coordinate(x1, y1, z1, Coordinate.POINT);
		
		BoundingBox box1 = new BoundingBox(this.min, midMax, null);
		BoundingBox box2 = new BoundingBox(midMin, this.max, null);
		
		BoundingBox[] boxes = {box1, box2};
		
		return boxes;
	}
	
	//does nothing
	@Override
	public void divide(int threshold) {
		
	}

	@Override
	public Intersection[] localIntersect(Ray r) {
		double[] xvalues = this.checkAxis(r.getOrigin().getX(), r.getDirection().getX(), this.min.getX(), this.max.getX());
		double[] yvalues = this.checkAxis(r.getOrigin().getY(), r.getDirection().getY(), this.min.getY(), this.max.getY());
		double[] zvalues = this.checkAxis(r.getOrigin().getZ(), r.getDirection().getZ(), this.min.getZ(), this.max.getZ());
		
		double xtmin = xvalues[0];
		double xtmax = xvalues[1];
		double ytmin = yvalues[0];
		double ytmax = yvalues[1];
		double ztmin = zvalues[0];
		double ztmax = zvalues[1];
		
		double tempMin = Math.max(xtmin, ytmin);
		double tmin = Math.max(tempMin, ztmin);
		
		double tempMax = Math.min(xtmax, ytmax);
		double tmax = Math.min(tempMax, ztmax);
		
		if(tmin > tmax) {
			return null;
		}
		
		Intersection[] xs = {new Intersection(tmin, this), new Intersection(tmax, this)};
		
		return xs;
	}

	@Override
	public Coordinate localNormalAt(Coordinate p, Intersection hit) {
		double temp = Math.max(Math.abs(p.getX()), Math.abs(p.getY()));
		double maxc = Math.max(temp, Math.abs(p.getZ()));
		
		if(maxc == Math.abs(p.getX())) {
			return new Coordinate(p.getX(), 0, 0, Coordinate.VECTOR);
		} else if(maxc == Math.abs(p.getY())) {
			return new Coordinate(0, p.getY(), 0, Coordinate.VECTOR);
		}
		
		return new Coordinate(0, 0, p.getZ(), Coordinate.VECTOR);
	}
	
	public BoundingBox[] splitAtX(double x) {
		Coordinate newMin = new Coordinate(x, this.min.getY(), this.min.getZ(), Coordinate.POINT);
		Coordinate newMax = new Coordinate(x, this.max.getY(), this.max.getZ(), Coordinate.POINT);
		
		BoundingBox box1 = new BoundingBox(this.min, newMax, null);
		BoundingBox box2 = new BoundingBox(newMin, this.max, null);
		
		BoundingBox[] result = {box1, box2};
		
		return result;
	}
	
	public BoundingBox[] splitAtY(double y) {
		Coordinate newMin = new Coordinate(this.min.getX(), y, this.min.getZ(), Coordinate.POINT);
		Coordinate newMax = new Coordinate(this.max.getX(), y, this.max.getZ(), Coordinate.POINT);
		
		BoundingBox box1 = new BoundingBox(this.min, newMax, null);
		BoundingBox box2 = new BoundingBox(newMin, this.max, null);
		
		BoundingBox[] result = {box1, box2};
		
		return result;
	}

	public BoundingBox[] splitAtZ(double z) {
		Coordinate newMin = new Coordinate(this.min.getX(), this.min.getY(), z, Coordinate.POINT);
		Coordinate newMax = new Coordinate(this.max.getX(), this.max.getY(), z, Coordinate.POINT);
		
		BoundingBox box1 = new BoundingBox(this.min, newMax, null);
		BoundingBox box2 = new BoundingBox(newMin, this.max, null);
		
		BoundingBox[] result = {box1, box2};
		
		return result;
	}
	
	@Override
	public void printData() {
		System.out.println("Box id: " + this.getId());
		System.out.println("Min:");
		this.getMin().printData();
		System.out.println("Max:");
		this.getMax().printData();
	}
	
	private double[] checkAxis(double origin, double direction, double min, double max) {
		double tminNumerator = (min - origin);
		double tmaxNumerator = (max - origin);
		
		double tmin;
		double tmax;
		
		if(Math.abs(direction) >= Computation.EPSILON) {
			tmin = tminNumerator / direction;
			tmax = tmaxNumerator / direction;
		} else {
			tmin = tminNumerator * Double.POSITIVE_INFINITY;
			tmax = tmaxNumerator * Double.POSITIVE_INFINITY;
		}
		
		if(tmin > tmax) {
			double temp = tmin;
			tmin = tmax;
			tmax = temp;
		}
		double[] result = {tmin, tmax};
		
		return result;
	}
}
