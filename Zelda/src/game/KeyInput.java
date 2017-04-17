package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	public Handler handler;
	public float speed = -0.5F;
	
	public boolean[] keydown = {
			
			false, // W
			false, // S
			false, // A
			false  // D
			};
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		if(key == KeyEvent.VK_H)  {
			Debug.isVisible = true;
		}
		
		if(key == KeyEvent.VK_W) {
			keydown[0] = true;
			Game.WorldVelY = -speed;
		}
		
		if(key == KeyEvent.VK_S) {
			keydown[1] = true;
			Game.WorldVelY = speed;
		}
		if(key == KeyEvent.VK_A) {
			keydown[2] = true;
			Game.WorldVelX = -speed;
		}
		
		if(key == KeyEvent.VK_D) {
			keydown[3] = true;
			Game.WorldVelX = speed;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_W) {
			keydown[0] = false;
			if(!keydown[1]) {
				Game.WorldVelY = 0;
			} else {
				Game.WorldVelY = speed;
			}
		}
		
		if(key == KeyEvent.VK_S) {
			keydown[1] = false;
			if(!keydown[0]) {
				Game.WorldVelY = 0;
			} else {
				Game.WorldVelY = -speed;
			}
		}
		
		if(key == KeyEvent.VK_A) {
			keydown[2] = false;
			if(!keydown[3]) {
				Game.WorldVelX = 0;
			} else {
				Game.WorldVelX = speed;
			}
		}
		
		if(key == KeyEvent.VK_D) {
			keydown[3] = false;
			if(!keydown[2]) {
				Game.WorldVelX = 0;
			} else {
				Game.WorldVelX = -speed;
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		super.keyTyped(e);
		int key = e.getKeyCode();
		
	}
}
