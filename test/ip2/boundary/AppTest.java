package ip2.boundary;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ip2.model.Model;

public class AppTest {
	Model model;
	App app;

	@Before
	public void setUp() throws Exception {
		model = new Model();
		app = new App(model);
	}

	@After
	public void tearDown() throws Exception {
		app.dispose();
	}

	@Test
	public void test() {
		assertTrue(app != null);

	}

}
