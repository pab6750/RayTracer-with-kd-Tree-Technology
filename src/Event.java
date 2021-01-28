
public class Event {
	public static final int END_EVENT_FLAG = 0;
	public static final int PLANAR_EVENT_FLAG = 1;
	public static final int START_EVENT_FLAG = 2;
	
	private Shape referencedShape;
	private Tuple planePosition;
	private int type;
	private int k;
	
	public Event(Shape referencedShape, Tuple planePosition, int type, int k) {
		this.type = type;
		this.planePosition = planePosition;
		this.referencedShape = referencedShape;
		this.k = k;
	}
	
	public static Event createStartEvent(Shape referencedShape, int k) {
		Tuple planePos = referencedShape.getBounds()
				.transform(referencedShape.getTransformation())
				.getMin();
		
		return new Event(referencedShape, planePos, START_EVENT_FLAG, k);
	}
	
	public static Event createPlanarEvent(Shape referencedShape, int k) {
		Tuple planePos = referencedShape.getBounds()
				.transform(referencedShape.getTransformation())
				.getMin();
		
		return new Event(referencedShape, planePos, PLANAR_EVENT_FLAG, k);
	}
	
	public static Event createEndEvent(Shape referencedShape, int k) {
		Tuple planePos = referencedShape.getBounds()
				.transform(referencedShape.getTransformation())
				.getMax();
		
		return new Event(referencedShape, planePos, END_EVENT_FLAG, k);
	}
	
	/*public static Event[] sortAllEvents(Event[] list) {
		
	}*/
	
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
	
	public boolean equals(Event e) {
		return this.referencedShape.getId().equals(e.getReferencedShape().getId()) &&
			   this.planePosition.equals(e.getPlanePosition()) &&
			   this.type == e.getType();
	}

	//setters and getters
	public int getK() {
		return k;
	}
	
	public int getType() {
		return type;
	}
	
	public Tuple getPlanePosition() {
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
	
	public void setPlanePosition(Tuple planePosition) {
		this.planePosition = planePosition;
	}

	public void setReferencedShape(Shape referencedShape) {
		this.referencedShape = referencedShape;
	}
	
	//private methods
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
	
	/*private static Event[] sortByPlane(Event[] XList, Event[] YList, Event[] ZList) {
		boolean sorted = false;
		
		//do this tomorrow
	}*/
	
	private static Event[] sortEventsByX(Event[] list) {
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
	
	private static Event[] sortEventsByY(Event[] list) {
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
	
	private static Event[] sortEventsByZ(Event[] list) {
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
}
