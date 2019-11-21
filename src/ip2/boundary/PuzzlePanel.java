package ip2.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import ip2.model.Board;
import ip2.model.Model;
import ip2.model.Tile;
import ip2.model.Vector;

public class PuzzlePanel extends JPanel {

	Model model;
	/**
	 * Create the panel.
	 */
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public PuzzlePanel() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {

		// Statement for window builder
		if(model == null) { 
			System.out.println("Hello");
			return; 
		}
		
		Board tiles = model.getBoard();

		// Paing all of the tiles
		for(Tile t: tiles.getList()) {
			int num = t.getVisibleNum();
			Vector location = t.getLocation();
			int x = 100*location.col;
			int y = 100*location.row;
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 72));	

			if(t.getGraySideUp()) {
				g.setColor(Color.gray);
			}
			else {
				g.setColor(Color.black);
			}
			g.fillRect(x, y, 100, 100);

			g.setColor(Color.white);
			g.drawString(String.valueOf(num), x+30, y+70);
		}
		
		// Paint the empty tile
		Vector location = model.getEmptyTile();
		int x = 100*location.col;
		int y = 100*location.row;
		g.setColor(Color.yellow);
		g.fillRect(x, y, 100, 100);
		
		// Draw the number of moves
		g.setColor(Color.black);
		g.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));	
		g.drawString("Num Moves: ", 15, 325);
		g.drawString(String.valueOf(model.getNumMoves()), 135, 325);
		
		// If they won, congratulate
		if(model.isWin()) {
			g.setColor(Color.green);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
			System.out.println("Nice");
			g.drawString("Congratulation!", 0, 150);
			
		}
		
		// If they lost, lock them out
		if(model.isLoss()) {
			g.setColor(Color.red);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
			System.out.println("not Nice");
			g.drawString("You Lose!", 0, 150);
			
		}
	}

}
