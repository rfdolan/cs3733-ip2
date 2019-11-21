package ip2.model;

import java.util.ArrayList;

public class Board {

	ArrayList<Tile> tiles;
	
	public Board() {
		
		tiles = new ArrayList<Tile>();
	}
	
	public ArrayList<Tile> getList() {
		return tiles;
	}
	
	// Check if two boards contain the same tiles at the same locations
	public boolean equals(Board other) { 
		
		for(Tile t: tiles) {
			
			if(!other.containsTile(t)) {
				return false;
			}
		}
		//System.out.println("We are equal");
		
		return true;

	}
	
	// Return true if this board contains the given tile
	public boolean containsTile(Tile t) {
		for(Tile ourTile: tiles) {
			if(t.equals(ourTile)) {
				return true;
			}
		}
		return false;
	}
	
	public void addTile(Tile t) {
		tiles.add(t);
	}
	
	public Tile getTileAt(Vector v) {
		for(Tile t: tiles) {
			if(t.getLocation().equals(v)) {
				return t;
			}
			
		}
		// If there is not tile at that location, return null (probably clicked the empty tile)
		return null;
	
	}

	// Return true if there are four of any given number visible
	public boolean isLosingState() {
		int numHits;
		for(int i=1; i<5; i++) {
			numHits = 0;
			for(Tile t: tiles) {
				if(t.getVisibleNum() == i) {
					numHits++;
				}
				if(numHits >= 4) {
					return true;
				}
			}
		}
		return false;
	}

	// Set the initial state of the board, as specified in the assignment description.
	public void setInitialState() {
		
		tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile(1, 4, true);
		Tile tile2 = new Tile(4, 1, true);
		Tile tile3 = new Tile(2, 3, false);
		Tile tile4 = new Tile(2, 3, true);
		Tile tile5 = new Tile(1, 4, true);
		Tile tile6 = new Tile(3, 2, false);
		Tile tile7 = new Tile(3, 2, true);
		Tile tile8 = new Tile(4, 1, true);

		tile1.setLocation(new Vector(0,0));
		tile2.setLocation(new Vector(0,1));
		tile3.setLocation(new Vector(0,2));
		tile4.setLocation(new Vector(1,0));
		tile5.setLocation(new Vector(1,1));
		tile6.setLocation(new Vector(1,2));
		tile7.setLocation(new Vector(2,0));
		tile8.setLocation(new Vector(2,1));

		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
		tiles.add(tile5);
		tiles.add(tile6);
		tiles.add(tile7);
		tiles.add(tile8);
	}

	// Set the board state to the winning state.
	public void setWinState() {
		
		tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile(1, 4, true);
		Tile tile2 = new Tile(2, 3, true);
		Tile tile3 = new Tile(3, 2, true);
		Tile tile4 = new Tile(1, 4, false);
		Tile tile5 = new Tile(4, 1, true);
		Tile tile6 = new Tile(2, 3, false);
		Tile tile7 = new Tile(3, 2, false);
		Tile tile8 = new Tile(4, 1, false);

		tile1.setLocation(new Vector(0,0));
		tile2.setLocation(new Vector(0,1));
		tile3.setLocation(new Vector(0,2));
		tile4.setLocation(new Vector(1,0));
		tile5.setLocation(new Vector(1,2));
		tile6.setLocation(new Vector(2,0));
		tile7.setLocation(new Vector(2,1));
		tile8.setLocation(new Vector(2,2));

		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
		tiles.add(tile5);
		tiles.add(tile6);
		tiles.add(tile7);
		tiles.add(tile8);
	}

	// For testing
	public void setAlmostWon() {
		
		tiles = new ArrayList<Tile>();
		Tile tile1 = new Tile(1, 4, true);
		Tile tile2 = new Tile(2, 3, true);
		Tile tile3 = new Tile(3, 2, true);
		Tile tile4 = new Tile(1, 4, true);
		Tile tile5 = new Tile(4, 1, true);
		Tile tile6 = new Tile(3, 2, false);
		Tile tile7 = new Tile(2, 3, false);
		Tile tile8 = new Tile(4, 1, false);

		tile1.setLocation(new Vector(0,0));
		tile2.setLocation(new Vector(0,1));
		tile3.setLocation(new Vector(0,2));
		tile4.setLocation(new Vector(1,1));
		tile5.setLocation(new Vector(1,2));
		tile6.setLocation(new Vector(2,0));
		tile7.setLocation(new Vector(2,1));
		tile8.setLocation(new Vector(2,2));

		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
		tiles.add(tile5);
		tiles.add(tile6);
		tiles.add(tile7);
		tiles.add(tile8);
	}
}
