package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected  int x, y;
	protected Rectangle rec;
	protected float velX, velY;
	protected ID id;
	
	public GameObject(int x,int y,Rectangle rec) {
		this.x = x;
		this.y = y;
		this.rec = rec;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract void removeThis();
	
	public int getX() {
		return x;
	}
	
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
}
