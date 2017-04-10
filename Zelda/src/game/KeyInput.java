package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int key = e.getKeyCode();
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		int key = e.getKeyCode();
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
		int key = e.getKeyCode();
		
	}
}
