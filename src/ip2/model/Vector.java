package ip2.model;

public class Vector {
	
	public final int row;
	public final int col;
	
	public Vector(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	// Return true if the vectors are equal.
	public boolean equals(Vector other) {
		return (other.row == this.row)&& ( other.col == this.col); 
	}
	
	

}
