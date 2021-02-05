/**
 * This class encapsulates basic functionality for a primitive shape.
 * @author Pablo Scarpati.
 *
 */
public abstract class Shape {
	public static final double EPSILON = 0.00001;
	
	private static int id = 0;
	private static int cubeId = 0;
	private static int groupId = 0;
	private static int planeId = 0;
	private static int smoothTriangleId = 0;
	private static int sphereId = 0;
	private static int triangleId = 0;
	private static int boundingBoxId = 0;
	private static int kdTreeId = 0;
	private static int spatialKdTreeId = 0;
	private static int medianKdTreeId = 0;
	
	protected String currentId;
	protected Matrix transformation;
	protected Material material;
	protected Group parent;
	
	public Shape() {
		this.setId();
		this.transformation = new Matrix(4);
		this.transformation.setIdentityMatrix();
		this.material = new Material();
		this.parent = null;
	}
	
	/**
	 * Abstract method that computes the intersection points of a shape.
	 * @param r The intersecting ray.
	 * @return The list of intersections.
	 */
	public abstract IntersectionPoint[] localIntersect(Ray r);
	
	/**
	 * Abstract method that computes the normal at a certain point.
	 * @param p The point where the normal is to be calculated.
	 * @param hit The hit.
	 * @return The normal vector.
	 */
	public abstract Coordinate localNormalAt(Coordinate p, IntersectionPoint hit);
	
	/**
	 * This method divides the group into subgroups.
	 * @param threshold The threshold.
	 */
	public abstract void divide(int threshold);
	
	/**
	 * Prints nothing
	 */
	public void printData() {
		
	}
	
	/**
	 * returns the Bounding Box for this shape.
	 * @return the Box bounding this shape.
	 */
	public AABB getAABB() {
		Coordinate min = new Coordinate(-1, -1, -1, Coordinate.POINT);
		Coordinate max = new Coordinate(1, 1, 1, Coordinate.POINT);
		AABB box = new AABB(min, max, this);
		
		return box;
	}
	
	/**
	 * Gets the bounding box in parent space.
	 * @return the bounding box in parent space.
	 */
	public AABB parentSpaceBoundsOf() {
		
		return this.getAABB().applyMatrix(this.transformation);
	}
	
	/**
	 * Turns a point in scene space to object space
	 * @param point
	 * @return
	 */
	public Coordinate sceneToObject(Coordinate point) {
		if(this.parent != null) {
			point = this.parent.sceneToObject(point);
		}
		
		return this.transformation.invert().coordinateMultiplication(point);
	}
	
	/**
	 * Turns the normal to scene space.
	 * @param normal
	 * @return
	 */
	public Coordinate normalToScene(Coordinate normal) {
		normal = this.transformation.invert().transposition().coordinateMultiplication(normal);
		normal.setType(Coordinate.VECTOR);
		normal = normal.normalize();
		
		if(this.parent != null) {
			normal = this.parent.normalToScene(normal);
		}
		
		return normal;
	}
	
	/**
	 * Set the material to a default reflective material.
	 */
	public void setDefaultReflectiveMaterial() {
		this.material.setDefaultReflective();
	}
	
	/**
	 * Set the material to a default refractive material.
	 */
	public void setDefaultRefractiveMaterial() {
		this.material.setDefaultRefractive();
	}
	
	public Group getParent() {
		return parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

	/**
	 * intersects a ray with this shape.
	 * @param r the ray.
	 * @return returns the intersection points
	 */
	public IntersectionPoint[] intersect(Ray r){
		Ray localRay = r.transform(this.transformation.invert());
		return this.localIntersect(localRay);
	}
	
	/**
	 * Finds the normal at the given point.
	 * @param scenePoint
	 * @param hit
	 * @return
	 */
	public Coordinate normalAt(Coordinate scenePoint, IntersectionPoint hit) {
		
		//transforms the scenePoint in object space
		Coordinate localPoint = this.sceneToObject(scenePoint);
		Coordinate localNormal = this.localNormalAt(localPoint, hit);
		
		return this.normalToScene(localNormal);
	}
	
	public void setColour(Colour colour) {
		this.material.setColour(colour);
	}
	
	/**
	 * Lights the object.
	 * @param light The Light.
	 * @param position The position to be light up.
	 * @param eyev the vector pointing to the eye.
	 * @param normalv the normal vector
	 * @param inShadow a boolean indicating whether the point is in shadow or not.
	 * @return the final colour of the point.
	 */
	public Colour lighting(PointLight light, Coordinate position, Coordinate eyev, Coordinate normalv, boolean inShadow) {
		Colour colour = this.material.getColour();
		
		//combine the surface colour with the light's colour
		Colour effectiveColour = colour.colourProduct(light.getIntensity());
		//find the direction to the light source
		Coordinate lightv = light.getPosition().subtractCoordinate(position).normalize();
		//compute the ambient contribution
		Colour ambient = effectiveColour.scalarMultiplication(this.material.getAmbient());
		/*
		 * lightDotNormal representes the cosine of the angle between the light vector and the normal vector.
		 * a negative number means the light is on the other side of the surface
		 */
		double lightDotNormal = lightv.dotProduct(normalv);
		
		Colour diffuse;
		Colour specular;
		
		if(lightDotNormal < 0 || inShadow) {
			diffuse = new Colour(0, 0, 0);
			specular = new Colour(0, 0, 0);
		} else {
			//compute the diffuse contribution
			diffuse = effectiveColour.scalarMultiplication(this.material.getDiffuse() * lightDotNormal);
			
			/*
			 * reflectDotEye represents the cosine of the angle between
			 * the reflection vector and the eye vector. A negative
			 * number means the light reflects away from the eye
			 */
			
			Coordinate reflectv = lightv.negateCoordinate().reflect(normalv);
			double reflectDotEye = reflectv.dotProduct(eyev);
			
			if(reflectDotEye <= 0) {
				specular = new Colour(0, 0, 0);
			} else {
				//compute the specular contribution
				double factor = Math.pow(reflectDotEye, this.material.getShininess());
				specular = light.getIntensity().scalarMultiplication(this.material.getSpecular() * factor);
			}
		}
		
		Colour colourResult = ambient.addColours(diffuse.addColours(specular));
		
		return colourResult;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
	public String getId() {
		return this.currentId;
	}
	
	public void setTransformation(Matrix m) {
		this.transformation.setMatrix(m.getMatrix());
	}
	
	public Matrix getTransformation() {
		return this.transformation;
	}
	
	public static void refreshIds() {
		id = 0;
		cubeId = 0;
		groupId = 0;
		planeId = 0;
		smoothTriangleId = 0;
		sphereId = 0;
		triangleId = 0;
		boundingBoxId = 0;
		kdTreeId = 0;
	}
	
	private void setId() {
		String name = this.getClass().getName();
		
		if(name.equals("BoundingBox")) {
			this.currentId = "BB" + boundingBoxId;
			boundingBoxId++;
		} else if(name.equals("Cube")) {
			this.currentId = "CU" + cubeId;
			cubeId++;
		} else if(name.equals("Group")) {
			this.currentId = "GR" + groupId;
			groupId++;
		} else if(name.equals("KDTree")) {
			this.currentId = "KD" + kdTreeId;
			kdTreeId++;
		} else if(name.equals("Plane")) {
			this.currentId = "PL" + planeId;
			planeId++;
		} else if(name.equals("SmoothTriangle")) {
			this.currentId = "SM" + smoothTriangleId;
			smoothTriangleId++;
		} else if(name.equals("Sphere")) {
			this.currentId = "SP" + sphereId;
			sphereId++;
		} else if(name.equals("Triangle")) {
			this.currentId = "TR" + triangleId;
			triangleId++;
		} else if(name.equals("SpatialKDTree")) {
			this.currentId = "ST" + spatialKdTreeId;
			spatialKdTreeId++;
		} else if(name.equals("MedianKDTree")) {
			this.currentId = "MT" + medianKdTreeId;
			medianKdTreeId++;
		} else {
			this.currentId = "SH" + id;
			id++;
		}
	}
}
