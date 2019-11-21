package ip2.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ip2.controller.FlipController;
import ip2.model.Model;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class App extends JFrame {

	private JPanel contentPane;


	PuzzlePanel panel;
	Model model;

	public PuzzlePanel getDrawingPanel() {return panel; }
	/**
	 * Create the frame.
	 */
	public App(Model m) {
		this.model = m;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 652, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		FlipController fpc = new FlipController(this, model);
		panel.addMouseListener(fpc);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  model.resetGame();
			  repaint();
		  }
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReset)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
