package ip2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ip2.boundary.App;
import ip2.controller.QuitController;
import ip2.model.Board;
import ip2.model.Model;
import ip2.model.Tile;

public class Main {

	public static void main(String[] args) {
		
		Model m = new Model();
		App app = new App(m);
		// Disposing the window will complete the application
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (new QuitController().confirm(app)) {
					app.dispose();
				}
			}      
		});
		app.setVisible(true);
		
		
		
	}
}
