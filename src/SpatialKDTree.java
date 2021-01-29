import java.util.ArrayList;

public class SpatialKDTree extends KDTree{
	
	public SpatialKDTree(boolean isRoot, int k) {
		super(isRoot, k);
	}
	
	public SpatialKDTree(boolean isRoot, Shape[] shapes, int k) {
		super(isRoot, shapes, k);
	}

	public static SpatialKDTree createRoot(Shape[] shapes) {
		return new SpatialKDTree(true, shapes, 0);
	}
	
	/**
	 * finds the generation point for spatial split.
	 * @param k the current k.
	 * @return the two new boxes.
	 */
	@Override
	public AABB[] findSplit(int k) {
		if(k == 0) {
			double newX = (this.box.getMin().getX() + this.box.getMax().getX()) / 2;
			return this.box.splitAtX(newX);
		} else if(k == 1) {
			double newY = (this.box.getMin().getY() + this.box.getMax().getY()) / 2;
			return this.box.splitAtY(newY);
		} else if(k == 2) {
			double newZ = (this.box.getMin().getZ() + this.box.getMax().getZ()) / 2;
			return this.box.splitAtZ(newZ);
		}
		
		return null;
	}
	
	/**
	 * Splits this node using the spatial method.
	 * @param k the current k.
	 */
	@Override
	public void split(int k, int level) {
		AABB[] children = this.findSplit(k);
		
		//this node's children
		this.leftChild = new SpatialKDTree(false, k);
		this.leftChild.setBox(children[0]);
		this.leftChild.setLevel(level);
		this.rightChild = new SpatialKDTree(false, k);
		this.rightChild.setBox(children[1]);
		this.rightChild.setLevel(level);
		
		ArrayList<Shape> leftShapes = new ArrayList<Shape>();
		ArrayList<Shape> rightShapes = new ArrayList<Shape>();
		
		//determine which shape belongs where
		for(int i = 0; i < this.shapes.length; i++) {
			AABB currentBox = this.shapes[i].getBounds();
			currentBox = currentBox.transform(this.shapes[i].getTransformation());
			
			if(children[0].containsPoint(currentBox.getMin()) || children[0].containsPoint(currentBox.getMax())) {
				leftShapes.add(this.shapes[i]);
			}
			
			if(children[1].containsPoint(currentBox.getMin()) || children[1].containsPoint(currentBox.getMax())) {
				rightShapes.add(this.shapes[i]);
			}
		}
		
		Shape[] leftArray = new Shape[leftShapes.size()];
		Shape[] rightArray = new Shape[rightShapes.size()];
		
		for(int i = 0; i < leftArray.length; i++) {
			leftArray[i] = leftShapes.get(i);
		}
		
		for(int i = 0; i < rightArray.length; i++) {
			rightArray[i] = rightShapes.get(i);
		}
		
		this.leftChild.setShapes(leftArray);
		this.rightChild.setShapes(rightArray);
	}
}
