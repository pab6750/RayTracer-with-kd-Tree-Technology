import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class OBJParser {
	private File file;
	private ArrayList<Coordinate> vertices;
	private ArrayList<Shape> faces;
	private ArrayList<Group> groups;
	private ArrayList<Coordinate> normals;
	private Group masterGroup;
	private int type;
	
	public OBJParser(File file) {
		this.file = file;
		this.vertices = new ArrayList<Coordinate>();
		this.faces = new ArrayList<Shape>();
		this.groups = new ArrayList<Group>();
		this.normals = new ArrayList<Coordinate>();
		this.masterGroup = new Group();
		this.parse();
		
		for(int i = 0; i < this.faces.size(); i++) {
			this.masterGroup.addChild(this.faces.get(i));
		}
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
		Group currentGroup = null;
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
				ArrayList<Coordinate> nList = new ArrayList<Coordinate>();
				
				if(this.type == 0) {					
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
						
						if(currentGroup != null) {
							currentGroup.addChild(tList.get(i));
						}
					}
				//if type isn't 0, and the file uses normal interpolation
				} else {
					while(in.hasNext()) {
						int v;
						int n;
						
						String faceInformation = in.next();
						
						if(!faceInformation.equals("f")) {
							v = faceInformation.charAt(0) - 48;
							n = faceInformation.charAt(faceInformation.length() - 1) - 48;
							
							vList.add(this.vertices.get(v - 1));
							nList.add(this.normals.get(n - 1));
						}
						
						/*int v = in.nextInt();
						in.next();
						
						if(in.hasNextInt()) {
							in.next();
						}
						
						in.next();
						int n = in.nextInt();
						
						vList.add(this.vertices.get(v - 1));
						nList.add(this.normals.get(n - 1));*/
					}
					
					ArrayList<SmoothTriangle> tList;
					
					if(vList.size() > 3) {
						tList = this.fanTriangulation(vList, nList);
					} else {
						SmoothTriangle t = new SmoothTriangle(vList.get(0), vList.get(1), vList.get(2),
								                              nList.get(0), nList.get(1), nList.get(2));
						
						tList = new ArrayList<SmoothTriangle>();
						tList.add(t);
					}
					
					for(int i = 0; i < tList.size(); i++) {
						this.faces.add(tList.get(i));
						
						if(currentGroup != null) {
							currentGroup.addChild(tList.get(i));
						}
					}
				}
				
				if(in.hasNextLine()) {
					in.nextLine();
				}
			} else if(current.contentEquals("g")) {
				String groupName = in.next();
				
				currentGroup = new Group(groupName);
				
				this.groups.add(currentGroup);
				
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
		    //captures the "type" of the file, to see whether it uses normal interpolation or not
			} else if(current.contentEquals("t")) {
				this.type = in.nextInt();
			} else {
				ignoredCount++;
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
	
	public Group getMasterGroup() {
		return this.masterGroup;
	}
	
	public Group[] getGroups() {
		Group[] gl = new Group[this.groups.size()];
		
		for(int i = 0; i < this.faces.size(); i++) {
			gl[i] = this.groups.get(i);
		}
		
		return gl;
	}
	
	public Group toGroup() {
		Group newGroup = new Group();
		
		for(int i = 0; i < this.groups.size(); i++) {
			newGroup.addChild(this.groups.get(i));
		}
		
		return newGroup;
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
	
	private ArrayList<SmoothTriangle> fanTriangulation(ArrayList<Coordinate> vertices, ArrayList<Coordinate> normals){
		ArrayList<SmoothTriangle> result = new ArrayList<SmoothTriangle>();
		
		for(int i = 1; i < vertices.size() - 1; i++) {
			SmoothTriangle t = new SmoothTriangle(vertices.get(0), vertices.get(i), vertices.get(i + 1),
					                              normals.get(0), normals.get(1), normals.get(2));
			result.add(t);
		}
		
		return result;
	}
}
