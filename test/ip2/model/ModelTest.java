package ip2.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {

	@Test
	public void testConstructor() {
		Model m = new Model();
		Board b = new Board();
		Board win = new Board();
		b.setInitialState();
		win.setWinState();
		assertTrue(b.equals(m.getBoard()));
		assertTrue(0 == m.getNumMoves());
		assertFalse(m.hasLost());
		assertFalse(m.isLoss());
		assertTrue(m.getEmptyTile().equals(new Vector(2,2)));
		m.setAlmostWinTestState();
		m.incMoves();
		m.resetGame();
		assertTrue(b.equals(m.getBoard())  );
		assertTrue((m.getNumMoves() == 0));
	}
	
	@Test
	public void testNeighboringEmpty() {
		Model m = new Model();
		Tile t1 = new Tile(2,3,false);
		Tile t2 = new Tile(2,3,false);
		t1.setLocation(new Vector(2,1));
		t2.setLocation(new Vector(0,0));

		assertTrue(m.neighboringEmpty(t1));
		assertFalse(m.neighboringEmpty(t2));
	}
	
	@Test
	public void testLoser() {
		
		Model m = new Model();
		Board b = new Board();
		Tile t1 = new Tile(1,4,true);
		t1.setLocation(new Vector(0,0));
		Tile t2 = new Tile(1,4,true);
		t2.setLocation(new Vector(1,0));
		Tile t3 = new Tile(1,4,true);
		t3.setLocation(new Vector(2,0));
		Tile t4 = new Tile(1,4,true);
		t4.setLocation(new Vector(0,1));
		b.addTile(t1);
		b.addTile(t2);
		b.addTile(t3);
		b.addTile(t4);
		m.setBoard(b);
		assertTrue(m.isLoss());
	}
	
	@Test
	public void testWinner() {
		Model m = new Model();
		Board b = new Board();
		assertFalse(m.isWin());
		b.setWinState();
		m.setBoard(b);
		assertTrue(m.isWin());
	}
	
	@Test
	public void testEmptyTile() {
		Model m = new Model();
		Vector v = new Vector(0,0);
		m.setEmptyTile(new Vector(0,0));
	
		assertTrue(v.equals(m.getEmptyTile()));
	}
	
	@Test
	public void testGetTile() {
		Model m = new Model();
		Tile t = new Tile(1,4,true);
		t.setLocation(new Vector(0,0));
		m.getTileAtLocation(new Vector(0,0));
	}
	

}
