package game;

import engine.renderEngine.Window;

public class Main {

	private static Window win;
	private static final int WIDTH = 1200, HEIGHT = 768, BUFFER_SIZE = 2;
	private static final String TITLE = "Game Engine";
	
	
	public Main() {
		
	}

	public static void main(String[] args) {
		win = new Window(TITLE, WIDTH, HEIGHT, BUFFER_SIZE);
		
		win.show();
	}

}
