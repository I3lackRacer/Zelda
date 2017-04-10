package AliveObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GameObject;
import game.Handler;
import game.ID;

public class Player extends GameObject{
	
	public Handler handler;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		setVelX(0);
		setVelY(0);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect( (int)x, (int)y, getWidth(), getWidth());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle( (int)x, (int)y, 100, 100);
	}

	@Override
	public void removeThis() {
		if(handler.aliveObjects.contains(this)) {
			handler.removeAliveObject(this);
		}
		
		if(handler.objects.contains(this)) {
			handler.removeObject(this);
		}
	}
	
}
