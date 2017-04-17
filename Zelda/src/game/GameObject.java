package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected  float x, y;
	protected Rectangle rec;
	protected float velX, velY;
	protected short priority;
	protected ID id;
	
	public GameObject(float x,float y,ID id, short priority) {
		this.priority = priority;
		this.x = x;
		this.y = y;
		this.id = id;
	}
	


	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract void removeThis();
	
	public short getPriority() {
		return priority;
	}

	public void setPriority(short priority) {
		this.priority = priority;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
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

	public float getY() {
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
	
	public int getWidth() {
		return (int) getBounds().getWidth();
	}
	
	public int getHeight() {
		return (int) getBounds().getHeight();
	}
}
