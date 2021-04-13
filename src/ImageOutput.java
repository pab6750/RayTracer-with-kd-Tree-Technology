import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class creates colour information into a readable ppm file.
 * @author Pablo Scarpati.
 *
 */
public class ImageOutput {
	private int h;
	private int w;
	private Colour[][] grid;
	private String name;
	
	public ImageOutput(int n) {
		this.h = n;
		this.w = n;
		
		this.grid = new Colour[n][n];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				this.grid[i][j] = new Colour(0);
			}
		}
		
		this.name = "render";
	}
	
	public ImageOutput(int h, int w) {
		this.h = h;
		this.w = w;
		
		this.grid = new Colour[h][w];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				this.grid[i][j] = new Colour(0);
			}
		}
		
		this.name = "render";
	}
	
	public ImageOutput(int h, int w, String name) {
		this.h = h;
		this.w = w;
		
		this.grid = new Colour[h][w];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				this.grid[i][j] = new Colour(0);
			}
		}
		
		this.name = name;
	}
	
	public int getH() {
		return this.h;
	}
	
	public int getW() {
		return this.w;
	}
	
	/**
	 * Converts colours to PPM format.
	 * @return a string containing the contents of the file.
	 */
	public String canvasToPPM() {
		String PPMStringFormat = "";
		
		PPMStringFormat += "P3\n";
		PPMStringFormat += this.w + " " + this.h + "\n";
		PPMStringFormat += "255\n";
		
		for(int i = 0; i < this.h; i++) {
			for(int j = 0; j < this.w; j++) {
				PPMStringFormat += this.grid[i][j].scaleR() + " ";
				PPMStringFormat += this.grid[i][j].scaleG() + " ";
				PPMStringFormat += this.grid[i][j].scaleB() + " ";
			}
			
			PPMStringFormat += "\n";
		}
		
		
		return PPMStringFormat;
	}
	
	public Colour pixelAt(int x, int y) {
		return this.grid[y][x];
	}
	
	/**
	 * saves the final file as a PPM file
	 * @throws IOException
	 */
	public void saveFile() throws IOException{
		String address = "C:\\Users\\pablo\\OneDrive\\Desktop\\uni\\Dissertation\\RenderResults\\" + this.name + ".ppm";
		
		FileWriter fileWriter = new FileWriter(address);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print(this.canvasToPPM());
	    printWriter.close();
	}
	
	public void writePixel(int x, int y, Colour c) {
		this.grid[y][x] = c;
	}
}
