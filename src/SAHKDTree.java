
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

	@Override
	public AABB[] findSplit(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void split(int k, int level) {
		// TODO Auto-generated method stub
		
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
}
