package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Debug {
	
	public Handler handler;
	public static boolean isVisible = false;
	public static int a = 0,d = 0,o = 0,c = 0;
	
	public Debug(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(isVisible) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("ARIAL BLACK", 15, 15));
			
			int x = Game.weite/100*85 + 7, y = Game.höhe/100*5+15, i = 1;
			g.drawString("DEBUG INFO", x, y + 20*i++);
			g.drawString("Welt Koordinaten: " + ((int)Game.WorldX) + " || " + ((int)Game.WorldY), x, y + 20*i++);
			g.drawString("Objekte: " + handler.objects.size() + "(" + o + ")", x, y+20*i++);
			g.drawString("Drop Objekte: " + handler.hitlessObjects.size() + "(" + d + ")", x, y+20*i++);
			g.drawRect(Game.weite/100*85, Game.höhe/100*5, Game.weite/100*13, ((int)(Game.höhe/100*1.5F)*i+45));
		}
	}
}
