package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenster extends JFrame{
	
	private static final long serialVersionUID = 1546456L;
	public JFrame frame = this;
	
	public Fenster(Game game, int weite, int höhe) {
		frame.setTitle("Zelda");
		frame.setPreferredSize(new Dimension(weite, höhe));
		frame.setMaximumSize(new Dimension(weite, höhe));
		frame.setMinimumSize(new Dimension(weite, höhe));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setUndecorated(true);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		game.start();
	}

}
