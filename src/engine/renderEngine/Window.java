package engine.renderEngine;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private static JFrame FRAME;
	private static int WIDTH, HEIGHT, BUFFER_SIZE;
	private static String TITLE;
	
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
		
		FRAME.setVisible(true);
	}
	
}
