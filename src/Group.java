import java.util.ArrayList;

public class Group extends Shape{
	private Shape[] shapes;
	private String name;
	
	public Group() {
		super();
		this.shapes = null;
		this.name = null;
	}
	
	public Group(String name) {
		super();
		this.shapes = null;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shape[] getShapes() {
		return shapes;
	}

	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
	}
	
	@Override
	public AABB getBounds() {
		AABB box = new AABB(null);
		
		for(int i = 0; i < this.shapes.length; i++) {
			AABB cbox = this.shapes[i].parentSpaceBoundsOf();
			box.addBox(cbox);
		}
		
		return box;
	}

	@Override
	public Intersection[] localIntersect(Ray r) {
		if(this.getBounds().intersect(r) != null) {
			if(this.shapes == null || this.shapes.length == 0) {
				return null;
			}
			
			Intersection[][] total = new Intersection[this.shapes.length][];
			int totalLength = 0;
			
			for(int i = 0; i < this.shapes.length; i++) {
				
				Intersection[] curr = this.shapes[i].intersect(r);
				total[i] = curr;
				
				if(total[i] != null) {
					totalLength += total[i].length;
				}
			}
			
			Intersection[] result = new Intersection[totalLength];
			int destPos = 0;
			
			for(int i = 0; i < this.shapes.length; i++) {
				if(total[i] != null) {
					System.arraycopy(total[i], 0, result, destPos, total[i].length);
					destPos += total[i].length;
				}
			}
			
			result = Intersection.sortIntersections(result);
			
			return result;
		} else {
			return null;
		}
	}
	
	@Override
	public void printData() {
		System.out.println("name: " + this.name);
		System.out.println("l: " + this.shapes.length);
		
		for(int i = 0; i < this.shapes.length; i++) {
			this.shapes[i].printData();
			System.out.println("-------");
		}
	}
	
	public void applyColourToChildren() {
		Colour c = this.getMaterial().getColour();
		
		for(int i = 0; i < this.shapes.length; i++) {
			this.shapes[i].setColour(c);
		}
	}

	//never call this function
	@Override
	public Coordinate localNormalAt(Coordinate p, Intersection hit) throws NullPointerException{
		
		return null;
	}
	
	public void addChild(Shape child) {
		ArrayList<Shape> temp = new ArrayList<Shape>();
		
		if(this.shapes != null) {
			for(int i = 0; i < this.shapes.length; i++) {
				temp.add(this.shapes[i]);
			}
		}
		
		temp.add(child);
		child.setParent(this);
		
		Shape[] newArray = new Shape[temp.size()];
		
		for(int i = 0; i < newArray.length; i++) {
			newArray[i] = temp.get(i);
		}
		
		this.shapes = newArray;
	}
	
	public void removeChild(Shape child) {
		ArrayList<Shape> newList = new ArrayList<Shape>();
		
		for(int i = 0; i < this.shapes.length; i++){
			newList.add(this.shapes[i]);
		}
		
		if(!newList.isEmpty()) {
			newList.remove(child);
		}
		
		Shape[] newArray = new Shape[newList.size()];
		newArray = newList.toArray(newArray);
		
		this.shapes = newArray;
	}
	
	public void createSubGroup(Shape[] list) {
		Group newGroup = new Group();
		
		newGroup.setShapes(list);
		
		this.addChild(newGroup);
	}
	
	public Shape[][] partitionChildren(){
		ArrayList<Shape> removable = new ArrayList<Shape>();
		
		ArrayList<Shape> list1 = new ArrayList<Shape>();
		ArrayList<Shape> list2 = new ArrayList<Shape>();
		
		AABB[] boxes = this.getBounds().splitBounds();
		AABB box1 = boxes[0];
		AABB box2 = boxes[1];
		
		for(int i = 0; i < this.shapes.length; i++) {
			if(box1.containsBox(this.shapes[i].parentSpaceBoundsOf())) {
				list1.add(this.shapes[i]);
				removable.add(this.shapes[i]);
			}
			
			if(box2.containsBox(this.shapes[i].parentSpaceBoundsOf())) {
				list2.add(this.shapes[i]);
				removable.add(this.shapes[i]);
			}
		}
		
		for(int i = 0; i < removable.size(); i++) {
			this.removeChild(removable.get(i));
		}
		
		Shape[] l1 = new Shape[list1.size()];
		l1 = list1.toArray(l1);
		
		Shape[] l2 = new Shape[list2.size()];
		l2 = list2.toArray(l2);
		
		Shape[][] result = {l1, l2};
		
		return result;
	}
	
	@Override
	public void divide(int threshold) {
		if(threshold <= this.shapes.length) {
			Shape[][] partition = this.partitionChildren();
			Shape[] left = partition[0];
			Shape[] right = partition[1];
			
			if(left.length != 0) {
				this.createSubGroup(left);
			}
			
			if(right.length != 0) {
				this.createSubGroup(right);
			}
		}
		
		for(int i = 0; i < this.shapes.length; i++) {
			this.shapes[i].divide(threshold);
		}
	}
}
