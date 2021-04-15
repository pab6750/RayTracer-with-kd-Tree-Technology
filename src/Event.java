import java.util.ArrayList;

public class Event {
	public static final int END_EVENT_FLAG = 0;
	public static final int PLANAR_EVENT_FLAG = 1;
	public static final int START_EVENT_FLAG = 2;
	
	private Shape referencedShape;
	private Coordinate planePosition;
	private int type;
	private int k;
	
	public Event(Shape referencedShape, Coordinate planePosition, int type, int k) {
		this.type = type;
		this.planePosition = planePosition;
		this.referencedShape = referencedShape;
		this.k = k;
	}
	
	public static Event createStartEvent(Shape referencedShape, int k) {
		Coordinate planePos = referencedShape.getAABB()
				              .applyMatrix(referencedShape.getTransformation())
				              .getMin();
		
		return new Event(referencedShape, planePos, START_EVENT_FLAG, k);
	}
	
	public static Event createPlanarEvent(Shape referencedShape, int k) {
		Coordinate planePos = referencedShape.getAABB()
				              .applyMatrix(referencedShape.getTransformation())
				              .getMin();
		
		return new Event(referencedShape, planePos, PLANAR_EVENT_FLAG, k);
	}
	
	public static Event createEndEvent(Shape referencedShape, int k) {
		Coordinate planePos = referencedShape.getAABB()
				              .applyMatrix(referencedShape.getTransformation())
				              .getMax();
		
		return new Event(referencedShape, planePos, END_EVENT_FLAG, k);
	}
	
	public static Event[] sortAllEvents(Shape[] shapes) {
		
		Event[] xEvents = generateEventsInSingleDimension(shapes, KDTree.X_DIMENSION);
		Event[] yEvents = generateEventsInSingleDimension(shapes, KDTree.Y_DIMENSION);
		Event[] zEvents = generateEventsInSingleDimension(shapes, KDTree.Z_DIMENSION);
		
		xEvents = sortEventList(xEvents, KDTree.X_DIMENSION);
		yEvents = sortEventList(yEvents, KDTree.Y_DIMENSION);
		zEvents = sortEventList(zEvents, KDTree.Z_DIMENSION);
		
		Event[] sortedList = interleaveAllDimensions(xEvents, yEvents, zEvents);
		
		return sortedList;
	}
	
	public static Event[] interleaveAllDimensions(Event[] xEvents, Event[] yEvents, Event[] zEvents) {
		Event[] xyInterleaved = interleaveTwoDimensions(xEvents, yEvents);
		Event[] allInterleaved = interleaveTwoDimensions(xyInterleaved, zEvents);
		
		return allInterleaved;
	}
	
	public static Event[] sortEventList(Event[] list, int k) {
		if(k == KDTree.X_DIMENSION) {
			list = sortEventsByX(list);
		} else if(k == KDTree.Y_DIMENSION) {
			list = sortEventsByY(list);
		} else if(k == KDTree.Z_DIMENSION) {
			list = sortEventsByZ(list);
		}
		
		list = sortEventsByType(list);
		
		return list;
	}
	
	public static Event[] generateEventsInSingleDimension(Shape[] shapes, int dimension) {
		int numberOfShapes = shapes.length;
		int numberOfCandidates = numberOfShapes * 2;
		
		Coordinate[] candidateSplitList = new Coordinate[numberOfCandidates];
		
		int counter = 0;
		
		//save the possible split positions into an array
		for(int i = 0; i < numberOfShapes; i++) {
			
			AABB aabb = shapes[i].getAABB();
			aabb = aabb.applyMatrix(shapes[i].getTransformation());
			
			Coordinate splitCandidate1 = aabb.getMin();
			Coordinate splitCandidate2 = aabb.getMax();
			
			candidateSplitList[counter] = splitCandidate1;
			candidateSplitList[counter + 1] = splitCandidate2;
			
			counter += 2;
		}
		
		ArrayList<Event> planarEvents = new ArrayList<Event>();
		
		for(int i = 0; i < numberOfCandidates; i++) {
			
			Coordinate currentCandidate = candidateSplitList[i];
			Coordinate nextCandidate = candidateSplitList[i + 1];
			
			double min = 0;
			double max = 0;
			
			if(dimension == KDTree.X_DIMENSION) {
				min = currentCandidate.getX();
				max = nextCandidate.getX();
			} else if(dimension == KDTree.Y_DIMENSION) {
				min = currentCandidate.getY();
				max = nextCandidate.getY();
			} else if(dimension == KDTree.Z_DIMENSION) {
				min = currentCandidate.getZ();
				max = nextCandidate.getZ();
			}
			
			boolean isPlanar = Effect.compareDouble(min, max);
			
			if(isPlanar) {
				Event currEvent = Event.createPlanarEvent(shapes[(int) (i / 2)], dimension);
				planarEvents.add(currEvent);
			}
			
			i++;
		}
		
		//start and end events for x dimension
		Event[] startEndEvents = new Event[numberOfCandidates - (planarEvents.size() * 2)];
		
		int nonPlanarEventsCounter = 0;
		
		for(int i = 0; i < numberOfShapes; i++) {
			
			boolean isPlanar = false;
			int planarEventCounter = 0;
			
			while(!isPlanar && planarEventCounter < planarEvents.size()) {
				String planarShape = planarEvents.get(planarEventCounter).getReferencedShape().getId();
				
				if(shapes[i].getId().equals(planarShape)) {
					isPlanar = true;
				}
				
				planarEventCounter++;
			}
			
			if(!isPlanar) {
				
				Event currStartEvent = null;
				Event currEndEvent = null;
				
				if(dimension == KDTree.X_DIMENSION) {
					currStartEvent = Event.createStartEvent(shapes[i], KDTree.X_DIMENSION);
					currEndEvent = Event.createEndEvent(shapes[i], KDTree.X_DIMENSION);
				} else if(dimension == KDTree.Y_DIMENSION) {
					currStartEvent = Event.createStartEvent(shapes[i], KDTree.Y_DIMENSION);
					currEndEvent = Event.createEndEvent(shapes[i], KDTree.Y_DIMENSION);
				} else if(dimension == KDTree.Z_DIMENSION) {
					currStartEvent = Event.createStartEvent(shapes[i], KDTree.Z_DIMENSION);
					currEndEvent = Event.createEndEvent(shapes[i], KDTree.Z_DIMENSION);
				}
				
				startEndEvents[nonPlanarEventsCounter] = currStartEvent;
				startEndEvents[nonPlanarEventsCounter + 1] = currEndEvent;
				
				nonPlanarEventsCounter += 2;
			}
		}
		
		//merging planar and non-planar events
		Event[] events = new Event[planarEvents.size() + startEndEvents.length];
		
		int numberOfPlanarEvents = planarEvents.size();
		nonPlanarEventsCounter = 0;
		
		for(int i = 0; i < events.length; i++) {
			if(i < numberOfPlanarEvents) {
				events[i] = planarEvents.get(i);
			} else {
				events[i] = startEndEvents[nonPlanarEventsCounter];
				nonPlanarEventsCounter++;
			}
		}
		
		return events;
	}
	
	/**
	 * This methods classifies a list of triangles based on the position of a splitting plane.
	 * This algorithm is based on the ClassifyLeftRightBoth algorithm proposed by Havran and Wald.
	 * Reference at: Wald, I. and Havran, V. (2006) On Building Fast kd-trees for Ray Tracing, and on Doing that in O(N log N), Symposium on Interactive Ray Tracing, 0, pp. 6169. doi: 10.1109/RT.2006.280216.
	 * @param shapes The list of shapes to be classified.
	 * @param events The list of events.
	 * @param planePosition The position of the splitting plane.
	 * @param planeDimension The dimension associated with the splitting plane.
	 */
	public static Shape[][] classify(Shape[] shapes, Event[] events, Coordinate planePosition, int planeDimension) {
		//TODO finish this
		return null;
	}
	
	public static Event[] sortEventsByXRecursive(Event[] list) {
		int l = list.length;
		
		if(l <= 1) {
			return list;
		} else if(l == 2) {
			double firstX = list[0].getPlanePosition().getX();
			double secondX = list[1].getPlanePosition().getX();
			
			int firstType = list[0].getType();
			int secondType = list[1].getType();
			
			if(list[0].getReferencedShape().isEqual(list[1].getReferencedShape())) {
				if(firstType > secondType) {
					Event temp = list[0];
					list[0] = list[1];
					list[1] = temp;
				}
			} else if(firstX > secondX) {
				Event temp = list[0];
				list[0] = list[1];
				list[1] = temp;
			}
			
			return list;
		} else {
			Event[] left = new Event[l / 2];
			Event[] right = new Event[list.length - left.length];
			
			int count = 0;
			
			for(int i = 0; i < left.length; i++) {
				left[i] = list[count];
				count++;
			}
			
			for(int i = 0; i < right.length; i++) {
				right[i] = list[count];
				count++;
			}
			
			left = sortEventsByXRecursive(left);
			right = sortEventsByXRecursive(right);
			
			Event[] sortedArray = new Event[l];
			
			int leftCount = 0;
			int rightCount = 0;
			
			for(int i = 0; i < l; i++) {
				double currLeft = Double.POSITIVE_INFINITY;
				double currRight = Double.POSITIVE_INFINITY;
				
				int currLeftType = Integer.MAX_VALUE;
				int currRightType = Integer.MAX_VALUE;
				
				Shape currLeftShape = null;
				Shape currRightShape = null;
				
				if(leftCount < left.length) {
					currLeft = left[leftCount].getPlanePosition().getX();
					currLeftType = left[leftCount].getType();
					currLeftShape = left[leftCount].getReferencedShape();
				}
				
				if(rightCount < right.length) {
					currRight = right[rightCount].getPlanePosition().getX();
					currRightType = right[rightCount].getType();
					currRightShape = right[rightCount].getReferencedShape();
				}
				
				boolean sameShapeReferenced = false;
				
				if(currLeftShape != null && currRightShape != null) {
					if(currLeftShape.isEqual(currRightShape)) {
						
						sameShapeReferenced = true;
						
						if(currLeftType > currRightType) {
							sortedArray[i] = right[rightCount];
							rightCount++;
						} else if(currLeftType <= currRightType) {
							sortedArray[i] = left[leftCount];
							leftCount++;
						}
					}
				}
				
				//finish this part
				if(!sameShapeReferenced) {
					if(currLeft <= currRight) {
						sortedArray[i] = left[leftCount];
						leftCount++;
					} else {
						sortedArray[i] = right[rightCount];
						rightCount++;
					}
				}
			}
			
			return sortedArray;
		}
	}
	
	public static Event[] sortEventsByYRecursive(Event[] list) {
		int l = list.length;
		
		if(l <= 1) {
			return list;
		} else if(l == 2) {
			double firstY = list[0].getPlanePosition().getY();
			double secondY = list[1].getPlanePosition().getY();
			
			int firstType = list[0].getType();
			int secondType = list[1].getType();
			
			if(list[0].getReferencedShape().isEqual(list[1].getReferencedShape())) {
				if(firstType > secondType) {
					Event temp = list[0];
					list[0] = list[1];
					list[1] = temp;
				}
			} else if(firstY > secondY) {
				Event temp = list[0];
				list[0] = list[1];
				list[1] = temp;
			}
			
			return list;
		} else {
			Event[] left = new Event[l / 2];
			Event[] right = new Event[list.length - left.length];
			
			int count = 0;
			
			for(int i = 0; i < left.length; i++) {
				left[i] = list[count];
				count++;
			}
			
			for(int i = 0; i < right.length; i++) {
				right[i] = list[count];
				count++;
			}
			
			left = sortEventsByYRecursive(left);
			right = sortEventsByYRecursive(right);
			
			Event[] sortedArray = new Event[l];
			
			int leftCount = 0;
			int rightCount = 0;
			
			for(int i = 0; i < l; i++) {
				double currLeft = Double.POSITIVE_INFINITY;
				double currRight = Double.POSITIVE_INFINITY;
				
				int currLeftType = Integer.MAX_VALUE;
				int currRightType = Integer.MAX_VALUE;
				
				Shape currLeftShape = null;
				Shape currRightShape = null;
				
				if(leftCount < left.length) {
					currLeft = left[leftCount].getPlanePosition().getY();
					currLeftType = left[leftCount].getType();
					currLeftShape = left[leftCount].getReferencedShape();
				}
				
				if(rightCount < right.length) {
					currRight = right[rightCount].getPlanePosition().getY();
					currRightType = right[rightCount].getType();
					currRightShape = right[rightCount].getReferencedShape();
				}
				
				boolean sameShapeReferenced = false;
				
				if(currLeftShape != null && currRightShape != null) {
					if(currLeftShape.isEqual(currRightShape)) {
						
						sameShapeReferenced = true;
						
						if(currLeftType > currRightType) {
							sortedArray[i] = right[rightCount];
							rightCount++;
						} else if(currLeftType <= currRightType) {
							sortedArray[i] = left[leftCount];
							leftCount++;
						}
					}
				}
				
				//finish this part
				if(!sameShapeReferenced) {
					if(currLeft <= currRight) {
						sortedArray[i] = left[leftCount];
						leftCount++;
					} else {
						sortedArray[i] = right[rightCount];
						rightCount++;
					}
				}
			}
			
			return sortedArray;
		}
	}
	
	public static Event[] sortEventsByZRecursive(Event[] list) {
		int l = list.length;
		
		if(l <= 1) {
			return list;
		} else if(l == 2) {
			double firstZ = list[0].getPlanePosition().getZ();
			double secondZ = list[1].getPlanePosition().getZ();
			
			int firstType = list[0].getType();
			int secondType = list[1].getType();
			
			if(list[0].getReferencedShape().isEqual(list[1].getReferencedShape())) {
				if(firstType > secondType) {
					Event temp = list[0];
					list[0] = list[1];
					list[1] = temp;
				}
			} else if(firstZ > secondZ) {
				Event temp = list[0];
				list[0] = list[1];
				list[1] = temp;
			}
			
			return list;
		} else {
			Event[] left = new Event[l / 2];
			Event[] right = new Event[list.length - left.length];
			
			int count = 0;
			
			for(int i = 0; i < left.length; i++) {
				left[i] = list[count];
				count++;
			}
			
			for(int i = 0; i < right.length; i++) {
				right[i] = list[count];
				count++;
			}
			
			left = sortEventsByZRecursive(left);
			right = sortEventsByZRecursive(right);
			
			Event[] sortedArray = new Event[l];
			
			int leftCount = 0;
			int rightCount = 0;
			
			for(int i = 0; i < l; i++) {
				double currLeft = Double.POSITIVE_INFINITY;
				double currRight = Double.POSITIVE_INFINITY;
				
				int currLeftType = Integer.MAX_VALUE;
				int currRightType = Integer.MAX_VALUE;
				
				Shape currLeftShape = null;
				Shape currRightShape = null;
				
				if(leftCount < left.length) {
					currLeft = left[leftCount].getPlanePosition().getZ();
					currLeftType = left[leftCount].getType();
					currLeftShape = left[leftCount].getReferencedShape();
				}
				
				if(rightCount < right.length) {
					currRight = right[rightCount].getPlanePosition().getZ();
					currRightType = right[rightCount].getType();
					currRightShape = right[rightCount].getReferencedShape();
				}
				
				boolean sameShapeReferenced = false;
				
				if(currLeftShape != null && currRightShape != null) {
					if(currLeftShape.isEqual(currRightShape)) {
						
						sameShapeReferenced = true;
						
						if(currLeftType > currRightType) {
							sortedArray[i] = right[rightCount];
							rightCount++;
						} else if(currLeftType <= currRightType) {
							sortedArray[i] = left[leftCount];
							leftCount++;
						}
					}
				}
				
				//finish this part
				if(!sameShapeReferenced) {
					if(currLeft <= currRight) {
						sortedArray[i] = left[leftCount];
						leftCount++;
					} else {
						sortedArray[i] = right[rightCount];
						rightCount++;
					}
				}
			}
			
			return sortedArray;
		}
	}
	
	public static Event[] sortEventsByX(Event[] list) {
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < list.length - 1; i++) {
				Event current = list[i];
				Event next = list[i + 1];
				
				if(current.getPlanePosition().getX() > next.getPlanePosition().getX()) {
					sorted = false;
					Event temp = current;
					list[i] = next;
					list[i + 1] = temp;
				}
			}
		}
		
		return list;
	}
	
	public static Event[] sortEventsByY(Event[] list) {
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < list.length - 1; i++) {
				Event current = list[i];
				Event next = list[i + 1];
				
				if(current.getPlanePosition().getY() > next.getPlanePosition().getY()) {
					sorted = false;
					Event temp = current;
					list[i] = next;
					list[i + 1] = temp;
				}
			}
		}
		
		return list;
	}
	
	public static Event[] sortEventsByZ(Event[] list) {
		boolean sorted = false;
		
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < list.length - 1; i++) {
				Event current = list[i];
				Event next = list[i + 1];
				
				if(current.getPlanePosition().getZ() > next.getPlanePosition().getZ()) {
					sorted = false;
					Event temp = current;
					list[i] = next;
					list[i + 1] = temp;
				}
			}
		}
		
		return list;
	}
	
	public boolean equals(Event e) {
		return this.referencedShape.getId().equals(e.getReferencedShape().getId()) &&
			   this.planePosition.equals(e.getPlanePosition()) &&
			   this.type == e.getType() &&
			   this.k == e.getK();
	}
	
	public void printData() {
		System.out.println("Shape: " + this.referencedShape.getId());
		System.out.println("type: " + this.type);
		System.out.println("k: " + this.k);
		System.out.println("Coordinate:");
		this.planePosition.printData();
		System.out.println("-----------");
	}

	//setters and getters
	public int getK() {
		return k;
	}
	
	public int getType() {
		return type;
	}
	
	public Coordinate getPlanePosition() {
		return planePosition;
	}

	public Shape getReferencedShape() {
		return referencedShape;
	}
	
	public void setK(int k) {
		this.k = k;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setPlanePosition(Coordinate planePosition) {
		this.planePosition = planePosition;
	}

	public void setReferencedShape(Shape referencedShape) {
		this.referencedShape = referencedShape;
	}
	
	//private methods
	private static Event[] interleaveTwoDimensions(Event[] list1, Event[] list2) {
		Event[] allEvents = new Event[list1.length + list2.length];
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < allEvents.length; i++) {
			System.out.println(i);
			Coordinate planePos1 = null;
			Coordinate planePos2 = null;
			
			if(count1 < list1.length) {
				planePos1 = list1[count1].getPlanePosition();
			}
			
			if(count2 < list2.length) {
				planePos2 = list2[count2].getPlanePosition();
			}
			
			if(planePos1 == null) {
				allEvents[i] = list2[count2++];
			} else if(planePos2 == null) {
				allEvents[i] = list1[count1++];
			} else {
				if(planePos1.isEqual(planePos2)) {
					int type1 = list1[count1].getType();
					int type2 = list2[count2].getType();
					
					if(type1 >= type2) {
						allEvents[i] = list1[count1++];
					} else {
						allEvents[i] = list2[count2++];
					}
				} else {
					allEvents[i] = list1[count1++];
				}
			}
		}
		
		return allEvents;
	}
	
	private static Event[] sortEventsByType(Event[] list) {
		boolean sorted = false;
		
		while(!sorted) {
			Event current = list[0];
			sorted = true;
			for(int i = 0; i < list.length - 1; i++) {
				Event next = list[i + 1];
				
				if(!current.getReferencedShape().getId().equals(next.getReferencedShape().getId())) {
					current = next;
				} else {
					if(list[i].getType() > next.getType()) {
						sorted = false;
						Event temp = list[i];
						list[i] = next;
						list[i + 1] = temp;
					}
				}
			}
		}
		
		return list;
	}
}
