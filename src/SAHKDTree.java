import java.util.ArrayList;

public class SAHKDTree extends KDTree{
	public static final double KT = 1;
	public static final double KI = 1;
	
	public SAHKDTree(boolean isRoot, int k) {
		super(isRoot, k);
	}
	
	public SAHKDTree(boolean isRoot, Shape[] shapes, int k) {
		super(isRoot, shapes, k);
	}
	
	public static SAHKDTree createRoot(Shape[] shapes) {
		return new SAHKDTree(true, shapes, 0);
	}

	//Naive O(N^2) algorithm described by Havran and Wald
	@Override
	public AABB[] findSplit(int k) {
		int numShapes = this.shapes.length;
		int numCandidates = numShapes * 2;
		Coordinate[] allCandidates = new Coordinate[numCandidates];
		
		//collect all candidates
		for(int i = 0; i < numCandidates; i++) {
			AABB currBox = this.shapes[i / 2].getAABB();
			currBox = currBox.applyMatrix(this.shapes[i / 2].getTransformation());
			
			if(i % 2 == 0) {
				allCandidates[i] = currBox.getMin();
			} else {
				allCandidates[i] = currBox.getMax();
			}
		}
		
		//separate into left & right
		ArrayList<Shape> leftShapes = null;
		ArrayList<Shape> rightShapes = null;
		
		double minSAH = Double.POSITIVE_INFINITY;
		Coordinate bestCandidate = allCandidates[0];
		
		for(int i = 0; i < numCandidates; i++) {
			
			Coordinate currCandidate = allCandidates[i];
			leftShapes = new ArrayList<Shape>();
			rightShapes = new ArrayList<Shape>();
			
			for(int j = 0; j < numShapes; j++) {
				
				AABB currBox = this.shapes[j].getAABB();
				currBox = currBox.applyMatrix(this.shapes[j].getTransformation());
				
				if(this.k == KDTree.X_DIMENSION) {
					if(currBox.getMin().getX() <= currCandidate.getX() || currBox.getMax().getX() <= currCandidate.getX()) {
						leftShapes.add(this.shapes[j]);
					} else {
						rightShapes.add(this.shapes[j]);
					}
				} else if(this.k == KDTree.Y_DIMENSION) {
					if(currBox.getMin().getY() <= currCandidate.getY() || currBox.getMax().getY() <= currCandidate.getY()) {
						leftShapes.add(this.shapes[j]);
					} else {
						rightShapes.add(this.shapes[j]);
					}
				} else if(this.k == KDTree.Z_DIMENSION) {
					if(currBox.getMin().getZ() <= currCandidate.getZ() || currBox.getMax().getZ() <= currCandidate.getZ()) {
						leftShapes.add(this.shapes[j]);
					} else {
						rightShapes.add(this.shapes[j]);
					}
				}
			}
			
			int numLeft = leftShapes.size();
			int numRight = rightShapes.size();
			
			Shape[] leftArray = new Shape[numLeft];
			Shape[] rightArray = new Shape[numRight];
			
			for(int j = 0; j < numLeft; j++) {
				leftArray[j] = leftShapes.get(j);
			}
			
			for(int j = 0; j < numRight; j++) {
				rightArray[j] = rightShapes.get(j);
			}
			
			double newSAH = this.SurfaceAreaHeuristic(leftArray, rightArray);
			
			if(newSAH < minSAH) {
				minSAH = newSAH;
				bestCandidate = currCandidate;
			}
		}
		
		AABB[] childBoxes = null;
		
		if(this.k == KDTree.X_DIMENSION) {
			childBoxes = this.getBox().splitAtX(bestCandidate.getX());
		} else if(this.k == KDTree.Y_DIMENSION) {
			childBoxes = this.getBox().splitAtY(bestCandidate.getY());
		} else if(this.k == KDTree.Z_DIMENSION) {
			childBoxes = this.getBox().splitAtZ(bestCandidate.getZ());
		}
		
		return childBoxes;
	}

	/**
	 * Splits the node according to the SAH and the k value.
	 * @param k the current k value.
	 */
	@Override
	public void split(int k, int level) {
		AABB[] children = this.findSplit(k);
		//this node's children
		this.leftChild = new SAHKDTree(false, k);
		this.leftChild.setBox(children[0]);
		this.leftChild.setLevel(level);
		this.rightChild = new SAHKDTree(false, k);
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
	
	public double SurfaceAreaHeuristic(SAHKDTree leftChild, SAHKDTree rightChild) {
		double currentSA = this.getAABB().getSurfaceArea();
		double leftSA = this.getLeftChild().getAABB().getSurfaceArea();
		double rightSA = this.getRightChild().getAABB().getSurfaceArea();
		
		double leftSideCost = (leftSA / currentSA) * this.getLeftChild().getShapes().length;
		double rightSideCost = (rightSA / currentSA) * this.getRightChild().getShapes().length;
		
		double finalCost = KT + KI * (leftSideCost + rightSideCost);
		
		return finalCost;
	}
	
	public double SurfaceAreaHeuristic(Shape[] leftShapes, Shape[] rightShapes) {
		double currentSA = this.getAABB().getSurfaceArea();
		
		AABB leftAABB = new AABB(null);
		AABB rightAABB = new AABB(null);
		
		int numLeftShapes = leftShapes.length;
		int numRightShapes = rightShapes.length;
		
		for(int i = 0; i < numLeftShapes; i++) {
			AABB currBox = leftShapes[i].getAABB();
			currBox = currBox.applyMatrix(leftShapes[i].getTransformation());
			leftAABB.addAABB(currBox);
		}
		
		for(int i = 0; i < numRightShapes; i++) {
			AABB currBox = rightShapes[i].getAABB();
			currBox = currBox.applyMatrix(rightShapes[i].getTransformation());
			rightAABB.addAABB(currBox);
		}
		
		double leftSA = leftAABB.getSurfaceArea();
		double rightSA = rightAABB.getSurfaceArea();
		
		double leftSideCost = (leftSA / currentSA) * numLeftShapes;
		double rightSideCost = (rightSA / currentSA) * numRightShapes;
		
		double finalCost = KT + KI * (leftSideCost + rightSideCost);
		
		return finalCost;
	}
}
