package ip2.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import ip2.boundary.App;
import ip2.model.Board;
import ip2.model.Model;
import ip2.model.Tile;
import ip2.model.Vector;

public class FlipController extends MouseAdapter {

	final App app;
	final Model model;
	
	public FlipController(App app, Model model) {
		 this.app = app;
		 this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {

		// If they have lost, ignore clicks on the board.
		if(model.hasLost()) {
			return;
		}
		// Get the x y coordinates by doing pos/100
		Point p = me.getPoint();
		int pcol = (p.x / 100);
		int prow = (p.y / 100);
		
		Vector v = new Vector(prow, pcol);
		
		//System.out.println("Hit point (" + pcol + ", " + prow + ")");
		
		Tile t = model.getTileAtLocation(v);
		// If we clicked on a non empty tile that is next to empty, flip
		if((t != null) && (model.neighboringEmpty(t))) {
			flip(t);
		}

	}
	
	private void flip(Tile t) {
		//System.out.println("Flip!");
		model.incMoves();

		// Switch locations of empty tile and tile.
		Vector newTileLocation = model.getEmptyTile();
		Vector newEmpty = t.getLocation();
		t.setLocation(newTileLocation);
		
		// Flip the tile
		t.flip();
		model.setEmptyTile(newEmpty);
		
		// Refresh the display
		app.repaint();
	}
}
