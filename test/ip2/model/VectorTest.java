package ip2.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {

	// Test constructor
	@Test
	public void testConstructor() {
		Vector v1 = new Vector(2,2);
		assertEquals(v1.row, 2);
		assertEquals(v1.col, 2);
	}
	
	// Test equals funciton
	@Test
	public void testEquals() {
		Vector v1 = new Vector(0,0);
		Vector v2 = new Vector(0,0);
		assertTrue(v1.equals(v2));
	}

}
