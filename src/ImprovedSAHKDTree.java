import java.sql.Timestamp;
import java.util.ArrayList;

public class ImprovedSAHKDTree extends KDTree{
	public static final double KT = 1;
	public static final double KI = 1;
	private Event[] eventsX;
	private Event[] eventsY;
	private Event[] eventsZ;
	
	public ImprovedSAHKDTree(boolean isRoot, int k) {
		super(isRoot, k);
	}
	
	public ImprovedSAHKDTree(boolean isRoot, Shape[] shapes, Event[] eventsX, Event[] eventsY, Event[] eventsZ, int k) {
		super(isRoot, shapes, k);
		this.eventsX = eventsX;
		this.eventsY = eventsY;
		this.eventsZ = eventsZ;
	}
	
	public static ImprovedSAHKDTree createRoot(Shape[] shapes) {
		Event[] eventsX = Event.generateEventsInSingleDimension(shapes, X_DIMENSION);
		Event[] eventsY = Event.generateEventsInSingleDimension(shapes, Y_DIMENSION);
		Event[] eventsZ = Event.generateEventsInSingleDimension(shapes, Z_DIMENSION);
		return new ImprovedSAHKDTree(true, shapes, eventsX, eventsY, eventsZ, 0);
	}
	
	//does nothing
	@Override
	public AABB[] findSplit(int k) {
		return null;
	}
	
	public AABB[] findSplit(int k, Event[] events) {
		Coordinate split = EventBasedSplitting(k, events);
		
		AABB[] childBoxes = null;
		
		if(this.k == KDTree.X_DIMENSION) {
			childBoxes = this.getBox().splitAtX(split.getX());
		} else if(this.k == KDTree.Y_DIMENSION) {
			childBoxes = this.getBox().splitAtY(split.getY());
		} else if(this.k == KDTree.Z_DIMENSION) {
			childBoxes = this.getBox().splitAtZ(split.getZ());
		}
		
		return childBoxes;
	}
	
	public Coordinate EventBasedSplitting(int k, Event[] events) {
		//delete this
		System.out.println("this.shapes.length: " + this.shapes.length);
		System.out.println("events.length: " + events.length);
		
		//this probably shouldn't be done here. Consider moving it to split.
		if(k == KDTree.X_DIMENSION) {
			events = Event.sortEventsByXRecursive(events);
		} else if(k == KDTree.Y_DIMENSION) {
			events = Event.sortEventsByYRecursive(events);
		} else if(k == KDTree.Z_DIMENSION) {
			events = Event.sortEventsByZRecursive(events);
		}
		
		Coordinate currentCandidate = null;
		Coordinate bestCandidate = null;
		
		//number of shapes on the left
		int nl = 0;
		
		//number of shapes on the right
		int nr = 0;
		
		//number of planar shapes
		int np = 0;
		
		double leftSA = 0;
		double rightSA = 0;
		double currentSA = this.getAABB().getSurfaceArea();
		
		double currentBestCost = Double.POSITIVE_INFINITY;
		
		for(int i = 0; i < events.length - 1; i++) {
			currentCandidate = events[i].getPlanePosition();
			Coordinate newCandidate = events[i + 1].getPlanePosition();
			
			if(!currentCandidate.isEqual(newCandidate)) {
				
				//calculate SAH
				double leftSideCost = (leftSA / currentSA) * (nl + np);
				double rightSideCost = (rightSA / currentSA) * (nr + np);
				
				double newCost = KT + KI * (leftSideCost + rightSideCost);
				
				//change best values
				if(newCost < currentBestCost) {
					currentBestCost = newCost;
					bestCandidate = currentCandidate;
				}
				
				//reset all values for next plane
				nl = 0;
				nr = 0;
				np = 0;
				leftSA = 0;
				rightSA = 0;
				
				//change plane
				currentCandidate = newCandidate;
			}
			
			int currentType = events[i].getType();
			
			//determine number of shapes on each sides, and surface area of each side
			if(currentType == Event.END_EVENT_FLAG) {
				nl++;
				AABB b = events[i].getReferencedShape().getAABB();
				b = b.applyMatrix(events[i].getReferencedShape().getTransformation());
				leftSA += b.getSurfaceArea();
			} else if(currentType == Event.PLANAR_EVENT_FLAG) {
				np++;
				AABB b = events[i].getReferencedShape().getAABB();
				b = b.applyMatrix(events[i].getReferencedShape().getTransformation());
				leftSA += b.getSurfaceArea();
				rightSA += b.getSurfaceArea();
			} else if(currentType == Event.START_EVENT_FLAG) {
				nr++;
				AABB b = events[i].getReferencedShape().getAABB();
				b = b.applyMatrix(events[i].getReferencedShape().getTransformation());
				rightSA += b.getSurfaceArea();
			}
		}
		
		return bestCandidate;
	}
	
	/**
	 * Splits the node according to the SAH and the k value.
	 * @param k the current k value.
	 */
	@Override
	public void split(int k, int level) {
		AABB[] children = null;
		
		if(k == X_DIMENSION) {
			children = this.findSplit(k, eventsX);
		} else if(k == Y_DIMENSION) {
			children = this.findSplit(k, eventsY);
		} else if(k == Z_DIMENSION) {
			children = this.findSplit(k, eventsZ);
		}
		
		//this node's children
		ImprovedSAHKDTree leftChildTemp = new ImprovedSAHKDTree(false, k);
		leftChildTemp.setBox(children[0]);
		leftChildTemp.setLevel(level);
		ImprovedSAHKDTree rightChildTemp = new ImprovedSAHKDTree(false, k);
		rightChildTemp.setBox(children[1]);
		rightChildTemp.setLevel(level);
		
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
		
		leftChildTemp.setShapes(leftArray);
		rightChildTemp.setShapes(rightArray);
		
		//event handling
		Event[][] newEventArraysX = null;
		Event[][] newEventArraysY = null;
		Event[][] newEventArraysZ = null;
		
		if(k == X_DIMENSION) {
			double split = children[0].getMax().getX();
			newEventArraysX = this.handleEventsX(eventsX, split);
			newEventArraysY = this.handleEventsX(eventsY, split);
			newEventArraysZ = this.handleEventsX(eventsZ, split);
			//delete this
			System.out.println("k: " + k);
			System.out.println("newEventArraysX[0].length: " + newEventArraysX[0].length);
			System.out.println("newEventArraysX[1].length: " + newEventArraysX[1].length);
			System.out.println("newEventArraysY[0].length: " + newEventArraysY[0].length);
			System.out.println("newEventArraysY[1].length: " + newEventArraysY[1].length);
			System.out.println("newEventArraysZ[0].length: " + newEventArraysZ[0].length);
			System.out.println("newEventArraysZ[1].length: " + newEventArraysZ[1].length);
		} else if(k == Y_DIMENSION) {
			double split = children[0].getMax().getY();
			newEventArraysX = this.handleEventsY(eventsX, split);
			newEventArraysY = this.handleEventsY(eventsY, split);
			newEventArraysZ = this.handleEventsY(eventsZ, split);
			//delete this
			System.out.println("k: " + k);
			System.out.println("newEventArraysX[0].length: " + newEventArraysX[0].length);
			System.out.println("newEventArraysX[1].length: " + newEventArraysX[1].length);
			System.out.println("newEventArraysY[0].length: " + newEventArraysY[0].length);
			System.out.println("newEventArraysY[1].length: " + newEventArraysY[1].length);
			System.out.println("newEventArraysZ[0].length: " + newEventArraysZ[0].length);
			System.out.println("newEventArraysZ[1].length: " + newEventArraysZ[1].length);
		} else if(k == Z_DIMENSION) {
			double split = children[0].getMax().getZ();
			newEventArraysX = this.handleEventsZ(eventsX, split);
			newEventArraysY = this.handleEventsZ(eventsY, split);
			newEventArraysZ = this.handleEventsZ(eventsZ, split);
			//delete this
			System.out.println("k: " + k);
			System.out.println("newEventArraysX[0].length: " + newEventArraysX[0].length);
			System.out.println("newEventArraysX[1].length: " + newEventArraysX[1].length);
			System.out.println("newEventArraysY[0].length: " + newEventArraysY[0].length);
			System.out.println("newEventArraysY[1].length: " + newEventArraysY[1].length);
			System.out.println("newEventArraysZ[0].length: " + newEventArraysZ[0].length);
			System.out.println("newEventArraysZ[1].length: " + newEventArraysZ[1].length);
		}
		
		leftChildTemp.setEventsX(newEventArraysX[0]);
		leftChildTemp.setEventsY(newEventArraysY[0]);
		leftChildTemp.setEventsZ(newEventArraysZ[0]);
		
		rightChildTemp.setEventsX(newEventArraysX[1]);
		rightChildTemp.setEventsY(newEventArraysY[1]);
		rightChildTemp.setEventsZ(newEventArraysZ[1]);
		
		this.leftChild = leftChildTemp;
		this.rightChild = rightChildTemp;
	}
	
	public Event[][] handleEventsX(Event[] events, double split) {
		//determine number of events on each side
		int ll = 0;
		int rl = 0;
		
		for(int i = 0; i < events.length; i++) {
			AABB aabb = events[i].getReferencedShape().getAABB();
			aabb = aabb.applyMatrix(events[i].getReferencedShape().getTransformation());
			
			if(aabb.getMin().getX() > split || aabb.getMax().getX() > split) {
				rl++;
			}
			
			if(aabb.getMin().getX() <= split || aabb.getMax().getX() <= split ) {
				ll++;
			}
		}
		
		Event[] left = new Event[ll];
		Event[] right = new Event[rl];
		
		int countLeft = 0;
		int countRight = 0;
		
		for(int i = 0; i < events.length; i++) {
			AABB aabb = events[i].getReferencedShape().getAABB();
			aabb = aabb.applyMatrix(events[i].getReferencedShape().getTransformation());
			
			if(aabb.getMin().getX() > split || aabb.getMax().getX() > split) {
				right[countRight] = events[i];
				countRight++;
			}
			
			if(aabb.getMin().getX() <= split || aabb.getMax().getX() <= split ) {
				left[countLeft] = events[i];
				countLeft++;
			}
		}
		
		Event[][] result = {left, right};
		
		return result;
	}
	
	public Event[][] handleEventsY(Event[] events, double split) {
		//determine number of events on each side
		int ll = 0;
		int rl = 0;
		
		for(int i = 0; i < events.length; i++) {
			AABB aabb = events[i].getReferencedShape().getAABB();
			aabb = aabb.applyMatrix(events[i].getReferencedShape().getTransformation());
			
			if(aabb.getMin().getY() > split || aabb.getMax().getY() > split) {
				rl++;
			}
			
			if(aabb.getMin().getY() <= split || aabb.getMax().getY() <= split ) {
				ll++;
			}
		}
		
		Event[] left = new Event[ll];
		Event[] right = new Event[rl];
		
		int countLeft = 0;
		int countRight = 0;
		
		for(int i = 0; i < events.length; i++) {
			AABB aabb = events[i].getReferencedShape().getAABB();
			aabb = aabb.applyMatrix(events[i].getReferencedShape().getTransformation());
			
			if(aabb.getMin().getY() > split || aabb.getMax().getY() > split) {
				right[countRight] = events[i];
				countRight++;
			}
			
			if(aabb.getMin().getY() <= split || aabb.getMax().getY() <= split ) {
				left[countLeft] = events[i];
				countLeft++;
			}
		}
		
		Event[][] result = {left, right};
		
		return result;
	}
	
	public Event[][] handleEventsZ(Event[] events, double split) {
		//determine number of events on each side
		int ll = 0;
		int rl = 0;
		
		for(int i = 0; i < events.length; i++) {
			AABB aabb = events[i].getReferencedShape().getAABB();
			aabb = aabb.applyMatrix(events[i].getReferencedShape().getTransformation());
			
			if(aabb.getMin().getZ() > split || aabb.getMax().getZ() > split) {
				rl++;
			}
			
			if(aabb.getMin().getZ() <= split || aabb.getMax().getZ() <= split ) {
				ll++;
			}
		}
		
		Event[] left = new Event[ll];
		Event[] right = new Event[rl];
		
		int countLeft = 0;
		int countRight = 0;
		
		for(int i = 0; i < events.length; i++) {
			AABB aabb = events[i].getReferencedShape().getAABB();
			aabb = aabb.applyMatrix(events[i].getReferencedShape().getTransformation());
			
			if(aabb.getMin().getZ() > split || aabb.getMax().getZ() > split) {
				right[countRight] = events[i];
				countRight++;
			}
			
			if(aabb.getMin().getZ() <= split || aabb.getMax().getZ() <= split ) {
				left[countLeft] = events[i];
				countLeft++;
			}
		}
		
		Event[][] result = {left, right};
		
		return result;
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

	public Event[] getEventsX() {
		return eventsX;
	}

	public void setEventsX(Event[] events) {
		this.eventsX = events;
	}
	
	public Event[] getEventsY() {
		return eventsY;
	}

	public void setEventsY(Event[] events) {
		this.eventsY = events;
	}
	
	public Event[] getEventsZ() {
		return eventsZ;
	}

	public void setEventsZ(Event[] events) {
		this.eventsZ = events;
	}
}
