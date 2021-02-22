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
	 * Splits the node according to the the spatial middle and the k value.
	 * @param k the current k value.
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
		
		int totalLength = this.shapes.length;
		
		int rightArrayLength = 0;
		int leftArrayLength = 0;
		Shape[] rightArray;
		Shape[] leftArray;
		
		//determines how long each array will need to be
		for(int i = 0; i < totalLength; i++) {
			AABB currentBox = this.shapes[i].getAABB();
			currentBox = currentBox.applyMatrix(this.shapes[i].getTransformation());
			
			if(children[0].containsPoint(currentBox.getMin()) || children[0].containsPoint(currentBox.getMax())) {
				leftArrayLength++;
			}
			
			if(children[1].containsPoint(currentBox.getMin()) || children[1].containsPoint(currentBox.getMax())) {
				rightArrayLength++;
			}
		}
		
		rightArray = new Shape[rightArrayLength];
		leftArray = new Shape[leftArrayLength];
		
		int rightCounter = 0;
		int leftCounter = 0;
		
		//allocates each shape to its appropriate array
		for(int i = 0; i < totalLength; i++) {
			AABB currentBox = this.shapes[i].getAABB();
			currentBox = currentBox.applyMatrix(this.shapes[i].getTransformation());
			
			if(children[0].containsPoint(currentBox.getMin()) || children[0].containsPoint(currentBox.getMax())) {
				leftArray[leftCounter] = this.shapes[i];
				leftCounter++;
			}
			
			if(children[1].containsPoint(currentBox.getMin()) || children[1].containsPoint(currentBox.getMax())) {
				rightArray[rightCounter] = this.shapes[i];
				rightCounter++;
			}
		}
		
		//this.shapes = null;
		this.leftChild.setShapes(leftArray);
		this.rightChild.setShapes(rightArray);
	}
}
