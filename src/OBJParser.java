import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class OBJParser {
	private File file;
	private ArrayList<Coordinate> vertices;
	private ArrayList<Shape> faces;
	private ArrayList<Coordinate> normals;
	
	public OBJParser(File file) {
		this.file = file;
		this.vertices = new ArrayList<Coordinate>();
		this.faces = new ArrayList<Shape>();
		this.normals = new ArrayList<Coordinate>();
		this.parse();
	}
	
	/**
	 * This method turns the normals array list into an array
	 * @return
	 */
	public Coordinate[] getNormals() {
		Coordinate[] result = new Coordinate[this.normals.size() + 1];
		
		//first element is null because count in the file starts from 1
		result[0] = null;
		
		for(int i = 1; i < result.length; i++) {
			result[i] = this.normals.get(i - 1);
		}
		
		return result;
	}

	public void parse() {
		Scanner in = null;
		int ignoredCount = 0;
		
		try {
			in = new Scanner(this.file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		in.useLocale(Locale.ENGLISH);
		
		while(in.hasNextLine()) {
			String current = in.next();
			
			//the program has encountered vertex information
			if(current.equals("v")) {
				
				//the 3 coordinates of the vertex
				double p1 = in.nextDouble();
				double p2 = in.nextDouble();
				double p3 = in.nextDouble();
				
				Coordinate v = new Coordinate(p1, p2, p3, Coordinate.POINT);
				
				//the vertex is added to the vertices list
				this.vertices.add(v);
				if(in.hasNextLine()) {
					in.nextLine();
				}
			//the program has encountered face information (usually a triangle, but it could be another polygon)
			} else if(current.equals("f")) {
				
				ArrayList<Coordinate> vList = new ArrayList<Coordinate>();
								
				while(in.hasNextInt()) {
					int v = in.nextInt();
					vList.add(this.vertices.get(v - 1));
				}
				
				AABB finalBox = new AABB(null);
				
				for(int i = 0; i < this.vertices.size(); i++) {
					finalBox.addPoint(this.vertices.get(i));
				}
				
				for(int i = 0; i < this.vertices.size(); i++) {
					
					double sx = finalBox.getMax().getX() - finalBox.getMin().getX();
					double sy = finalBox.getMax().getY() - finalBox.getMin().getY();
					double sz = finalBox.getMax().getZ() - finalBox.getMin().getZ();
					
					double temp = Math.max(sx, sy);
					double maxValue = Math.max(temp, sz) / 2;
					
					Coordinate currentPoint = this.vertices.get(i);
					
					currentPoint.setX((currentPoint.getX() - (finalBox.getMin().getX() + sx / 2)) / maxValue);
					currentPoint.setY((currentPoint.getY() - (finalBox.getMin().getY() + sx / 2)) / maxValue);
					currentPoint.setZ((currentPoint.getZ() - (finalBox.getMin().getZ() + sx / 2)) / maxValue);
				}
				
				ArrayList<Triangle> tList;
				
				//if the face is not a triangle, the polygon will have to be "triangulated"
				if(vList.size() > 3) {
					tList = this.fanTriangulation(vList);
				} else {
					Triangle t = new Triangle(vList.get(0),
											  vList.get(1),
											  vList.get(2));
					
					tList = new ArrayList<Triangle>();
					tList.add(t);
				}
				
				for(int i = 0; i < tList.size(); i++) {
					
					this.faces.add(tList.get(i));
				}
				
				if(in.hasNextLine()) {
					in.nextLine();
				}
			} else if(current.contentEquals("vn")) {
		    	double n1 = in.nextDouble();
		    	double n2 = in.nextDouble();
		    	double n3 = in.nextDouble();
		    	
		    	Coordinate n = new Coordinate(n1, n2, n3, Coordinate.VECTOR);
		    	
		    	this.normals.add(n);
		    	
		    	if(in.hasNextLine()) {
					in.nextLine();
				}
			}
		}
		
		if(ignoredCount != 0) {
			System.out.println(ignoredCount + " lines ignored.");
		}
	}

	public Coordinate[] getVertices() {
		Coordinate[] vl = new Coordinate[this.vertices.size() + 1];
		vl[0] = null;
		
		for(int i = 1; i < this.vertices.size() + 1; i++) {
			vl[i] = this.vertices.get(i - 1);
		}
		
		return vl;
	}
	
	public Shape[] getFaces() {
		Shape[] fl = new Shape[this.faces.size() + 1];
		fl[0] = null;
		
		for(int i = 1; i < this.faces.size() + 1; i++) {
			fl[i] = this.faces.get(i - 1);
		}
		
		return fl;
	}
	
	
	/**
	 * this program assumes the polygon will always be convex (interior angles sum up to or less than 180°
	 * Triangulates a polygon that isn't a triangle.
	 * More info at https://en.wikipedia.org/wiki/Fan_triangulation
	 * @param vertices the list of vertices of the polygon
	 * @return a list of triangles forming the polygon
	 */
	private ArrayList<Triangle> fanTriangulation(ArrayList<Coordinate> vertices){
		ArrayList<Triangle> result = new ArrayList<Triangle>();
		
		for(int i = 1; i < vertices.size() - 1; i++) {
			Triangle t = new Triangle(vertices.get(0), vertices.get(i), vertices.get(i + 1));
			result.add(t);
		}
		
		return result;
	}
}
