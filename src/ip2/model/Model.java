package ip2.model;

import java.util.ArrayList;

public class Model {

	Tile tile;
	int numMoves;
	Vector emptyTileLocation;
	Board board;
	Board winState;
	boolean lost;

	//ArrayList<Tile> tiles;

	
	public Model () {
		board = new Board();
		winState = new Board();
		//setInitialBoardState();
		setInitialBoardState();
		numMoves = 0;
		
	}
	
	// Sets the board state to the initial state denoted by my ID number (3)
	private void setInitialBoardState() {
		emptyTileLocation = new Vector(2,2);
		lost = false;
 
		board.setInitialState();
		winState.setWinState();
		
	}
	
	public void setAlmostWinTestState() {
		emptyTileLocation = new Vector(1,0);
		lost = false;
 
		board.setAlmostWon();
		winState.setWinState();
	}
	
	public void resetGame() {
		//System.out.println("Resetting");
		setInitialBoardState();
		numMoves = 0;

	}
	
	public void setBoard(Board b) {
		this.board = b;
	}
	public Board getBoard() {
		return board;
	}
	
	public Vector getEmptyTile() {
		return emptyTileLocation;
	}
	
	// Given a tile, return true if it is neighboring the empty tile.
	public boolean neighboringEmpty(Tile t) {
		Vector tileLoc = t.getLocation();
		int deltaX = Math.abs((emptyTileLocation.row)- (tileLoc.row));
		int deltaY = Math.abs((emptyTileLocation.col)- (tileLoc.col)); 
		if(deltaX + deltaY == 1) {
			return true;
		}
		return false;
		
	}
	
	public Tile getTileAtLocation(Vector v) {
		return board.getTileAt(v);
	}
	
	public void setEmptyTile(Vector v) {
		
		this.emptyTileLocation = v;
	}
	
	public int getNumMoves() {
		return numMoves;
	}

	public void incMoves() {
		numMoves++;
	}
	
	public boolean isWin() {
		//System.out.println("Checking if we won.");
		return board.equals(winState);
		
	}
	
	public boolean isLoss() {
		if(board.isLosingState()) {
			lost = true;
			return true;
		}
		return false;
	}
	
	public boolean hasLost() {
		return lost;
	}
	
}
