package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import AliveObjects.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1456564564L;
	private static boolean MasterRunning = false;
	public static int weite = 1920, höhe = 1080;
	public Fenster Window;
	private Thread thread;
	public Handler handler;
	public static float WorldX = 0, WorldY = 0, WorldVelX = 0, WorldVelY = 0;
	public static Debug debug;
	
	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void run() {
		this.requestFocus();
		long letztesMal = System.nanoTime();
		double anzahlvonTicks = 1000.0D;
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
				Debug.a = 0;
					Debug.c = 0;
					Debug.d = 0;
					Debug.o = 0;
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
		g.setColor(Color.black);
		g.fillRect(0, 0, weite, höhe);
		handler.render(g);
		if(Debug.isVisible) {
			debug.render(g);
		}
		g.dispose();
		bs.show();
		this.getGraphics();
	}

	public void tick() {
		WorldX += WorldVelX;
		WorldY += WorldVelY;
		handler.tick();
	}
	
	public Game() {
		Window = new Fenster(this, weite, höhe);
		handler = new Handler();
		handler.addObject(new Player(weite / 2, höhe / 2, ID.Player, handler));
		debug = new Debug(handler);
		this.addKeyListener(new KeyInput(handler));
	}
}
