package AliveObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Debug;
import game.Game;
import game.GameObject;
import game.Handler;
import game.ID;

public class Player extends GameObject{
	
	public Handler handler;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = 0;
		velY = 0;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		float tmpX = x + Game.WorldX, tmpY = y + Game.WorldY;
		if(!(tmpX > Game.weite || tmpY > Game.höhe || tmpX < -getBounds().getWidth() || tmpY < -getBounds().getHeight())) {
			Debug.a++;
			g.setColor(Color.GREEN);
			g.fillRect( (int)tmpX, (int)tmpY, getWidth(), getWidth());
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle( (int)x, (int)y, 100, 100);
	}

	@Override
	public void removeThis() {
		if(handler.objects.contains(this)) {
			handler.removeObject(this);
		}
	}
	
}
