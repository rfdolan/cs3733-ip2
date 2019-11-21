package ip2.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {

	// Test if constructor works
	@Test
	public void testConstructor() {
		Tile t = new Tile(2, 3, true);
		assertTrue((t.grayNum == 2) && (t.blackNum == 3) && (t.getGraySideUp() == true));
	}

	// Test if the method to see if tiles are equivalent works
	@Test
	public void testEquals() {
		Tile t1 = new Tile(2, 3, true);
		t1.setLocation(new Vector(0,0));
		Tile t2 = new Tile(2, 3, true);
		t2.setLocation(new Vector(0,0));
		Tile t3 = new Tile(1,4,false);
		t3.setLocation(new Vector(0,0));
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
	}
	
	// Test getVisibleNum function
	@Test
	public void testVisibleNum() {
		Tile t1 = new Tile(2, 3, true);
		assertEquals(t1.getVisibleNum(), 2);
	}
	
	// Test flip function
	@Test
	public void testFlip() {
		Tile t1 = new Tile(2, 3, true);
		t1.flip();
		assertEquals(t1.getVisibleNum(), 3);
	}
	
}
