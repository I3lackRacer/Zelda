package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	public ArrayList<GameObject> hitlessObjects = new ArrayList<GameObject>();

	public Handler() {

	}

	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}

		for (int i = 0; i < hitlessObjects.size(); i++) {
			hitlessObjects.get(i).render(g);
		}
	}

	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).tick();
		}

		for (int i = 0; i < hitlessObjects.size(); i++) {
			hitlessObjects.get(i).tick();
		}
	}

	public void addObject(GameObject tmp) {
		objects.add(tmp);
	}

	public void removeObject(GameObject tmp) {
		objects.remove(tmp);
	}
	
	public void removeHitlessObject(GameObject tmp) {
		hitlessObjects.remove(tmp);
	}
	
	public void addHitlessObject(GameObject tmp) {
		hitlessObjects.add(tmp);
	}

	public GameObject getDirect(ID id) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).getId() == id) {
				return objects.get(i);
			}
		}
		return null;
	}
}
