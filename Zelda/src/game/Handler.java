package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {

	public static boolean renderObject = true, renderAliveObject = true, tickObject = true, tickAliveObject,
			renderDropObject = true, tickDropObject = true, renderContainerObjects = true, tickContainerObjects = true;

	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	public ArrayList<GameObject> aliveObjects = new ArrayList<GameObject>();
	public ArrayList<GameObject> dropObjects = new ArrayList<GameObject>();
	public ArrayList<GameObject> containerObjects = new ArrayList<GameObject>();

	public Handler() {

	}

	public void render(Graphics g) {
		if (renderObject) {
			for (int i = 0; i < objects.size(); i++) {
				objects.get(i).render(g);
			}
		}

		if (renderAliveObject) {
			for (int i = 0; i < aliveObjects.size(); i++) {
				aliveObjects.get(i).render(g);
			}
		}

		if (renderDropObject) {
			for (int i = 0; i < dropObjects.size(); i++) {
				dropObjects.get(i).render(g);
			}
		}

		if (renderContainerObjects) {
			for (int i = 0; i < containerObjects.size(); i++) {
				containerObjects.get(i).render(g);
			}
		}
	}

	public void tick() {
		if (tickObject) {
			for (int i = 0; i < objects.size(); i++) {
				objects.get(i).tick();
			}
		}

		if (tickAliveObject) {
			for (int i = 0; i < aliveObjects.size(); i++) {
				aliveObjects.get(i).tick();
			}
		}

		if (tickDropObject) {
			for (int i = 0; i < dropObjects.size(); i++) {
				dropObjects.get(i).tick();
			}
		}

		if (tickContainerObjects) {
			for (int i = 0; i < containerObjects.size(); i++) {
				containerObjects.get(i).tick();
			}
		}
	}

	public void addObject(GameObject tmp) {
		objects.add(tmp);
	}

	public void removeObject(GameObject tmp) {
		objects.remove(tmp);
	}

	public void addAliveObject(GameObject tmp) {
		aliveObjects.add(tmp);
	}

	public void removeAliveObject(GameObject tmp) {
		aliveObjects.remove(tmp);
	}

	public void addDropObject(GameObject tmp) {
		dropObjects.add(tmp);
	}

	public void removeDropObject(GameObject tmp) {
		dropObjects.remove(tmp);
	}

	public void addContainerObject(GameObject tmp) {
		containerObjects.add(tmp);
	}

	public void removeContainerObject(GameObject tmp) {
		containerObjects.remove(tmp);
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
