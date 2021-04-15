import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * This class contains functionality for KD Trees.
 * @author Pablo Scarpati(981009).
 *
 */
public abstract class KDTree extends Shape{
	public static final int X_DIMENSION = 0;
	public static final int Y_DIMENSION = 1;
	public static final int Z_DIMENSION = 2;
	
	public static final int SHAPES_LIMIT = 5;
	public static final int DEPTH_LIMIT = 10;
	
	protected boolean isRoot;
	protected KDTree leftChild;
	protected KDTree rightChild;
	protected AABB box;
	protected Shape[] shapes;
	protected int k;
	protected int level;
	
	public KDTree(boolean isRoot, int k) {
		super();
		this.isRoot = isRoot;
		this.shapes = null;
		this.box = null;
		this.k = k;
		this.level = 0;
	}
	
	public KDTree(boolean isRoot, Shape[] shapes, int k) {
		super();
		this.isRoot = isRoot;
		this.shapes = shapes;
		this.setBox();
		this.k = k;
		this.level = 0;
	}
	
	public abstract AABB[] findSplit(int k);
	
	public abstract void split(int k, int level);
	
	public void buildTree() {
		System.out.println("KD tree is being built");
		Timestamp timestampBeforeBuilding = new Timestamp(System.currentTimeMillis());
		this.build();
		Timestamp timestampAfterBuilding = new Timestamp(System.currentTimeMillis());
		System.out.println("Building process completed.");
		System.out.println("Building Start Time: " + timestampBeforeBuilding);
		System.out.println("Building End Time: " + timestampAfterBuilding);
	}
	
	/**
	 * This method gets the bounding volume of this node.
	 */
	@Override
	public AABB getAABB() {
		return this.getBox();
	}

	/**
	 * This method intersects a ray with the objects in the tree.
	 */
	@Override
	public IntersectionPoint[] localIntersect(Ray r) {
		if(this.shapes == null) {
			return null;
		} else if(this.shapes.length == 0) {
			return null;
		//end condition
		} else if(this.shapes.length <= SHAPES_LIMIT || this.level == DEPTH_LIMIT) {
			
			ArrayList<IntersectionPoint> allIntersections = new ArrayList<IntersectionPoint>();
			
			for(int i = 0; i < this.shapes.length; i++) {
				IntersectionPoint[] currentIntersections = this.shapes[i].intersect(r);
				
				if(currentIntersections != null) {
					for(int j = 0; j < currentIntersections.length; j++) {
						allIntersections.add(currentIntersections[j]);
					}
				}
			}
			
			if(allIntersections.isEmpty()) {
				return null;
			}
			
			IntersectionPoint[] intersectionList = new IntersectionPoint[allIntersections.size()];
			
			for(int i = 0; i < allIntersections.size(); i++) {
				intersectionList[i] = allIntersections.get(i);
			}
			
			intersectionList = IntersectionPoint.sortIntersections(intersectionList);
			
			return intersectionList;
		} else {
			IntersectionPoint[] leftIntersections = null;
			IntersectionPoint[] rightIntersections = null;
			
			if(this.leftChild.getBox().intersect(r) != null) {
				leftIntersections = this.leftChild.intersect(r);
			}
			
			if(this.rightChild.getBox().intersect(r) != null) {
				rightIntersections = this.rightChild.intersect(r);
			}
			
			int leftNumber = 0;
			int rightNumber = 0;
			
			if(leftIntersections != null) {
				leftNumber = leftIntersections.length;
			}
			
			if(rightIntersections != null) {
				rightNumber = rightIntersections.length;
			}
			
			IntersectionPoint[] total = new IntersectionPoint[leftNumber + rightNumber];
			int index = 0;
			
			
			for(int i = 0; i < leftNumber; i++) {
				total[index] = leftIntersections[i];
				index++;
			}
			
			for(int i = 0; i < rightNumber; i++) {
				total[index] = rightIntersections[i];
				index++;
			}
			
			total = IntersectionPoint.sortIntersections(total);
			
			return total;
		}
	}

	/**
	 * This method does nothing.
	 */
	@Override
	public Coordinate localNormalAt(Coordinate p, IntersectionPoint hit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void divide(int threshold) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean terminate() {
		if(this.shapes.length <= SHAPES_LIMIT || this.level >= DEPTH_LIMIT) {
			return true;
		}
		
		return false;
	}

	//getters and setters
	public boolean isRoot() {
		return isRoot;
	}

	public KDTree getLeftChild() {
		return leftChild;
	}

	public KDTree getRightChild() {
		return rightChild;
	}

	public Shape[] getShapes() {
		return shapes;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public void setLeftChild(KDTree leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(KDTree rightChild) {
		this.rightChild = rightChild;
	}

	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
		this.setBox();
	}
	
	public AABB getBox() {
		return box;
	}

	public void setBox() {
		AABB bbox = new AABB(null);
		
		for(int i = 0; i < this.shapes.length; i++) {
			if(this.shapes[i] != null) {
				AABB currentBox = this.shapes[i].getAABB().applyMatrix(this.shapes[i].getTransformation());
				bbox.addAABB(currentBox);
			}
		}
		
		this.box = bbox;
	}
	
	public void setBox(AABB bbox) {
		this.box = bbox;
	}
	
	/**
	 * Adds a shape to the tree.
	 * @param newShape the new shape.
	 */
	public void addShape(Shape newShape) {
		if(this.shapes == null) {
			this.shapes = new Shape[1];
			this.shapes[0] = newShape;
		} else {
			ArrayList<Shape> newArrayList = new ArrayList<Shape>();
			
			for(int i = 0; i < this.shapes.length; i++) {
				newArrayList.add(this.shapes[i]);
			}
			
			newArrayList.add(newShape);
			
			Shape[] newList = new Shape[this.shapes.length + 1];

			for(int i = 0; i < newArrayList.size(); i++) {
				newList[i] = newArrayList.get(i);
			}
			
			this.shapes = newList;
		}
	}
	
	/**
	 * This method returns the height of the tree.
	 * @return The height of the tree.
	 */
	public int getHeight() {
		return (int) Math.floor(Math.log(this.shapes.length) / Math.log(2)) + 1;
	}
	
	/**
	 * Prints the tree with data.
	 */
	public void printTreeWithData() {
		System.out.println(this.getDataString(0));
	}
	public String getDataString(int l) {
		String result = "";
		
		for(int i = 0; i < l; i++) {
			result += "  ";
		}
		
		result += this.getId() + ": {";
		
		for(int i = 0; i < this.shapes.length; i++) {
			result += this.shapes[i].getId();
			
			if(i != this.shapes.length - 1) {
				result += ", ";
			}
		}
		
		result += "}" + ", k = " + this.k;
		result += "\n";
		
		if(this.leftChild != null) {
			result += this.leftChild.getDataString(l + 1);
		}
		
		if(this.rightChild != null) {
			result += this.rightChild.getDataString(l + 1);
		}
		
		return result;
	}
	
	public void printTree() {
		System.out.println(this.getTreeString(0));
	}
	
	public String getTreeString(int l) {
		String result = "";
		String pad = "       ";
		
		result += this.getId() + "\n";
		
		for(int i = 0; i < l; i++) {
			if(i == l - 2) {
				result += "|";
			}
			result += pad;
		}
		
		result += "|\n";
		
		for(int i = 0; i < l; i++) {
			result += pad;
		}
		
		result += " ----";
		
		if(this.leftChild != null) {
			result += this.leftChild.getTreeString(l + 1);
		} else {
			result += this.getShapes()[0].getId() + "\n";
			
			for(int i = 0; i < l; i++) {
				if(i == l - 2) {
					result += "|";
				}
				result += pad;
			}
			
			result += "| \n";
			
			for(int i = 0; i < l; i++) {
				result += pad;
			}
			
			result += " ----";
			
			result += this.getShapes()[1].getId() + "\n";
			return result;
		}
		
		result += "\n";
		
		for(int i = 0; i < l; i++) {
			result += pad;
		}
		
		result += "| \n";
		
		for(int i = 0; i < l; i++) {
			result += pad;
		}
		
		result += " ----";
		
		if(this.rightChild != null) {
			result += this.rightChild.getTreeString(l + 1);
		} else {
			return result += " null";
		}
		
		return result;
	}
	
	public void printData() {
		int l = 0;
		
		System.out.println("Level " + l + ":");
		
		for(int i = 0; i < this.shapes.length; i++) {
			System.out.print(this.shapes[i].getId() + " ");
		}
		
		System.out.println();
		
		if(this.leftChild != null) {
			this.leftChild.printDataRecursive(l + 1);
		}
		
		if(this.rightChild != null) {
			this.rightChild.printDataRecursive(l + 1);
		}
	}
	
	/**
	 * Builds the entire tree.
	 */
	private void build() {
		if(!this.terminate()) {
			int newK = (this.k + 1) % 3;
			int newL = this.level + 1;
			this.split(newK, newL);
			this.leftChild.build();
			this.rightChild.build();
		} else {
			this.rightChild = null;
			this.leftChild = null;
		}
	}
	
	private void printDataRecursive(int l) {
		System.out.println("Level " + l + ":");
		
		for(int i = 0; i < this.shapes.length; i++) {
			System.out.print(this.shapes[i].getId() + " ");
		}
		
		System.out.println();
		
		if(this.leftChild != null) {
			this.leftChild.printDataRecursive(l + 1);
		}
		
		if(this.rightChild != null) {
			this.rightChild.printDataRecursive(l + 1);
		}
	}
}
