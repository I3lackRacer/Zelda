package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import AliveObjects.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1456564564L;
	private static boolean MasterRunning = false;
	public int weite = 1920, höhe = 1080;
	public Fenster Window;
	private Thread thread;
	public Handler handler;
	
	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void run() {
		this.requestFocus();
		long letztesMal = System.nanoTime();
		double anzahlvonTicks = 60.0;
		double ns = 1000000000 / anzahlvonTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (MasterRunning) {
			delta += (System.nanoTime() - letztesMal) / ns;
			letztesMal = System.nanoTime();
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (MasterRunning) {
				render();
				frames++;
				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					frames = 0;
				}
			}
		}
		stop();
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		MasterRunning = true;
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		handler.render(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, weite, höhe);
		g.dispose();
		bs.show();
		this.getGraphics();
	}

	public void tick() {
		handler.tick();
	}
	
	public Game() {
		Window = new Fenster(this, weite, höhe);
		handler = new Handler();
		handler.addAliveObject(new Player(weite / 2, höhe / 2, ID.Player, handler));
		this.addKeyListener(new KeyInput(handler));
	}
}
