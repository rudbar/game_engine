package engine.renderEngine;

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
	
	private static boolean isRunning;
	
	public Window(String title, int width, int height, int bufferSize) {
		
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
}

