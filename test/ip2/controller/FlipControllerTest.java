package ip2.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ip2.boundary.App;
import ip2.model.Model;

public class FlipControllerTest {

	Model model;
	App app;
	@Before
	public void setUp() throws Exception {
		model = new Model();
		app = new App(model);
	}
	
	@After
	public void tearDown() {
		app.dispose();
	}
	
	@Test
	public void test() {
		FlipController fpc = new FlipController(app, model);
	}

}
