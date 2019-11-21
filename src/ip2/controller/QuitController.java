package ip2.controller;

import javax.swing.JOptionPane;

import ip2.boundary.App;

public class QuitController {

	// QuitController code based off of the code in Professor Heineman's Tangram App
	public boolean confirm(App app) {
		return JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?") == JOptionPane.OK_OPTION;	
	}
}
