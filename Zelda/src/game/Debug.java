package game;

import java.awt.Color;
import java.awt.Graphics;

public class Debug {
	
	public Handler handler;
	public static boolean isVisible = false;
	
	public Debug(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(isVisible) {
			g.setColor(Color.GREEN);
			g.drawRect(Game.weite/100*85, Game.h�he/100*5, Game.weite/100*10, Game.h�he/100*33);
		}
	}
}
