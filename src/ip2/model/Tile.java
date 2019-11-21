package ip2.model;


public class Tile {
	final int grayNum;
	final int blackNum;
	
	boolean graySideUp;
	
	Vector location;


	public Tile(int grayNum, int blackNum, boolean graySideUp) {
		this.grayNum = grayNum;
		this.blackNum = blackNum;
		this.graySideUp = graySideUp;
	}
	
	// Return true if the tiles have the same numbers, flipped state, and location.
	public boolean equals(Tile other) {
		if((other.grayNum == this.grayNum) && 
				(other.blackNum == this.blackNum)&& 
				(other.graySideUp == this.graySideUp) &&
				(this.location.equals(other.getLocation()))) { 
			//System.out.println("This tile matches");
			return true;
		}
		return false;
	}
	
	// Return the visible number.
	public int getVisibleNum() {
		if(graySideUp) { return grayNum; }
		return blackNum;
	}
	
	public void setLocation(Vector loc) {
		this.location = loc;
	}
	
	public Vector getLocation() {
		return location;
	}
	
	public boolean getGraySideUp() {
		return graySideUp;
	}
	
	public void flip() {
		//System.out.println("Flipping");
		graySideUp = !graySideUp;
	}
	
}
