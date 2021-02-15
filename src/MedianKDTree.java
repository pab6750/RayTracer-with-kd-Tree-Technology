import java.util.ArrayList;

public class MedianKDTree extends KDTree{

	public MedianKDTree(boolean isRoot, int k) {
		super(isRoot, k);
	}
	
	public MedianKDTree(boolean isRoot, Shape[] shapes, int k) {
		super(isRoot, shapes, k);
	}
	
	public static MedianKDTree createRoot(Shape[] shapes) {
		return new MedianKDTree(true, shapes, 0);
	}

	/**
	 * finds the point of generation for a median split.
	 * @param k the current k.
	 * @return the two new bounding boxes.
	 */
	@Override
	public AABB[] findSplit(int k) {
		//points are sorted and the median is found
		if(this.k == X_DIMENSION) {
			double[] sortedList = this.sortBoundingExtentsByX();
			double median = this.findMedian(sortedList);
			return this.box.splitAtX(median);
		} else if(this.k == Y_DIMENSION) {
			double[] sortedList = this.sortBoundingExtentsByY();
			double median = this.findMedian(sortedList);
			return this.box.splitAtY(median);
		} else if(this.k == Z_DIMENSION){
			double[] sortedList = this.sortBoundingExtentsByZ();
			double median = this.findMedian(sortedList);
			return this.box.splitAtZ(median);
		}
		
		return null;
	}

	/**
	 * Splits the node according to the median and the k value.
	 * @param k the current k value.
	 */
	@Override
	public void split(int k, int level) {
		AABB[] children = this.findSplit(k);
		//this node's children
		this.leftChild = new MedianKDTree(false, k);
		this.leftChild.setBox(children[0]);
		this.leftChild.setLevel(level);
		this.rightChild = new MedianKDTree(false, k);
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
	
	/**
	 * Sorts a list of points by their x coordinate.
	 * @return The sorted list.
	 */
	private double[] sortBoundingExtentsByX() {
		double[] pointList = new double[this.shapes.length * 2];
		
		int current = 0;
		
		for(int i = 0; i < this.shapes.length; i++) {
			AABB box = this.shapes[i].getAABB().applyMatrix(this.shapes[i].getTransformation());
			pointList[current] = box.getMin().getX();
			pointList[current + 1] = box.getMax().getX();
			current += 2;
		}
		
		return this.sortBoundingExtentsProcedural(pointList);
	}
	
	/**
	 * Sorts a list of points by their y coordinate.
	 * @return The sorted list.
	 */
	private double[] sortBoundingExtentsByY() {
		double[] pointList = new double[this.shapes.length * 2];
		
		int current = 0;
		
		for(int i = 0; i < this.shapes.length; i++) {
			AABB box = this.shapes[i].getAABB().applyMatrix(this.shapes[i].getTransformation());
			pointList[current] = box.getMin().getY();
			pointList[current + 1] = box.getMax().getY();
			current += 2;
		}
		
		return this.sortBoundingExtentsProcedural(pointList);
	}
	
	/**
	 * Sorts a list of points by their z coordinate.
	 * @return The sorted list.
	 */
	private double[] sortBoundingExtentsByZ() {
		double[] pointList = new double[this.shapes.length * 2];
		
		int current = 0;
		
		for(int i = 0; i < this.shapes.length; i++) {
			AABB box = this.shapes[i].getAABB().applyMatrix(this.shapes[i].getTransformation());
			pointList[current] = box.getMin().getZ();
			pointList[current + 1] = box.getMax().getZ();
			current += 2;
		}
		
		return this.sortBoundingExtentsProcedural(pointList);
	}

	/**
	 * Sorts a list of numbers using merge sort.
	 * @param l the list of numbers.
	 * @return the sorted list.
	 */
	private double[] sortBoundingExtentsByRecursive(double[] l) {
		if(l.length > 2) {
			double[] list1 = new double[l.length / 2];
			System.arraycopy(l, 0, list1, 0, l.length / 2);
			
			double[] list2 = new double[l.length - list1.length];
			System.arraycopy(l, list1.length, list2, 0, list2.length);
			
			double[] finalList = new double[l.length];
			
			double[] sortedList1 = this.sortBoundingExtentsByRecursive(list1);
			double[] sortedList2 = this.sortBoundingExtentsByRecursive(list2);
			
			int currentList1 = 0;
			int currentList2 = 0;
			
			for(int i = 0; i < finalList.length; i++) {
				if(sortedList1.length > currentList1 && sortedList2.length > currentList2) {
					if(sortedList1[currentList1] > sortedList2[currentList2]) {
						finalList[i] = sortedList2[currentList2];
						currentList2++;
					} else if(sortedList1[currentList1] < sortedList2[currentList2]) {
						finalList[i] = sortedList1[currentList1];
						currentList1++;
					} else if(sortedList1[currentList1] == sortedList2[currentList2]) {
						finalList[i] = sortedList1[currentList1];
						currentList1++;
					}
				} else {
					if(sortedList1.length == currentList1) {
						finalList[i] = sortedList2[currentList2];
						currentList2++;
					} else if(sortedList2.length == currentList2) {
						finalList[i] = sortedList1[currentList1];
						currentList1++;
					}
				}
			}
			
			return finalList;
		} else if(l.length == 2) {
			if(l[0] > l[1]) {
				double temp = l[0];
				l[0] = l[1];
				l[1] = temp;
			}
			
			return l;
		} else {
			return l;
		}
	}
	
	/**
	 * Sorts a list of numbers using bubble sort.
	 * @param l the list of numbers.
	 * @return the sorted list.
	 */
	private double[] sortBoundingExtentsProcedural(double[] l) {
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < l.length - 1; i++) {
				if(l[i] > l[i + 1]) {
					double temp = l[i];
					l[i] = l[i + 1];
					l[i + 1] = temp;
					sorted = false;
				}
			}
		}
		
		return l;
	}
	
	/**
	 * finds the median given a sorted list.
	 * @param sortedList the sorted list.
	 * @return the median value.
	 */
	private double findMedian(double[] sortedList) {
		int l = sortedList.length;
		
		if(l % 2 == 0) {
			int index1 = l / 2;
			int index2 = l / 2 - 1;
			
			double median = (sortedList[index1] + sortedList[index2]) / 2;
			
			return median;
		} else {
			int index = l / 2;
			
			double median = sortedList[index];
			
			return median;
		}
	}
}
