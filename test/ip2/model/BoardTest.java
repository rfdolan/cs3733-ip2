package ip2.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testConstructor() {
		Board b = new Board();
		assertEquals(b.getList(), new ArrayList<Tile>());
	}
	
	@Test
	public void testEquals() {
		Board b1 = new Board();
		b1.setInitialState();
		Board b2 = new Board();
		b2.setInitialState();
		Board b3 = new Board();
		b3.setWinState();
		assertTrue(b1.equals(b2));
		assertFalse(b1.equals(b3));
	}
	
	@Test
	public void testIsLosingState() {
		
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
		assertTrue(b.isLosingState());
		t1.flip();
		assertFalse(b.isLosingState());
		
	}
	
	@Test
	public void testGetTileAt() {
		Board b = new Board();
		Tile t = new Tile(2, 3, false);
		t.setLocation(new Vector(0,0));
		b.addTile(t);
		assertTrue(b.getTileAt(new Vector(0,0)).equals(t));
		assertEquals(b.getTileAt(new Vector(0,1)), null);
	}


}
