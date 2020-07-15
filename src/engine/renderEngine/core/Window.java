package engine.renderEngine.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import engine.utils.Debug;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private static JFrame FRAME;
	private static int WIDTH, HEIGHT, BUFFER_SIZE;
	private static String TITLE;
	
	private GameManager gm;
	private Drawer drawer;
	
	int frames, ticks, time;
	private int lastFrames, lastTicks;
	
	private Thread loop;
	private final double UPDATE_SPEED = 60;
	private static boolean isRunning;
	
	public Window(String title, int width, int height, int bufferSize, GameManager gm) {
		
		this.gm = gm;
		
		
		
		Window.TITLE = title;
		Window.WIDTH = width;
		Window.HEIGHT = height;
		Window.BUFFER_SIZE = bufferSize;
		
		
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setSize(size);
		setFocusable(true);
		
		
		
		FRAME = new JFrame(TITLE);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.setSize(size);
		FRAME.add(this);
		FRAME.pack();
		FRAME.setResizable(false);
		FRAME.setLocationRelativeTo(null);
		
	}
	
	
	public void show() {
		this.createBufferStrategy(BUFFER_SIZE);
		isRunning = true;
		FRAME.setVisible(true);
		
		drawer = new Drawer(this);
		gameLoop();
	}

	/**
	 * This method is displaying the next buffer
	 */
	public void update() {
		if (!isRunning()) {Debug.LogError("WINDOW_NOT_INITIALIZED");}
		this.getBufferStrategy().show();
	}
	
	public void clear(Color ClearColor) {
		if (!isRunning()) {Debug.LogError("WINDOW_NOT_INITIALIZED");}
		BufferStrategy st = this.getBufferStrategy();
		Graphics g = st.getDrawGraphics();
		g.setColor(ClearColor);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public void close() {
		System.out.println("WINDOW >> CLOSING APPLICATION");
		FRAME.dispose();
		System.exit(0);
	}
	
	public boolean isRunning() {
		return isRunning;
	}

	private void gameLoop() {
		loop = new Thread() {
			public void run() {
				double lastTime = System.nanoTime();
				double delta = 0;
				final double ns = 1e9/UPDATE_SPEED;
				
				double start = System.currentTimeMillis();
				int next = 1;
				
				while (isRunning()) {
					double nowTime = System.nanoTime();
					double now = (System.currentTimeMillis()-start)/1000;
					delta += (nowTime - lastTime)/ns;
					lastTime = nowTime;
					
					while (delta >= 1) {
						gm.update();
						delta--;
					}
					gm.render();
					
					if (now >= next) {
						next++;
						time++;
						lastFrames = frames;
						lastTicks = ticks;
						Debug.Log("FPS: "+lastFrames+", UPS: "+lastTicks);
						frames = 0;
						ticks = 0;
					}
				}
				
			}
		}; loop.start();
	}

	Drawer getDrawer() {
		return drawer;
	}
}

