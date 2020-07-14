package game;

import engine.renderEngine.GameManager;
import engine.renderEngine.Window;

public class Main extends GameManager {

	private static Window win;
	private static final int WIDTH = 1200, HEIGHT = 768, BUFFER_SIZE = 2;
	private static final String TITLE = "Game Engine";
	
	private static final int GAME_ID = 0;
	
	public Main() {
		win = createWindow(TITLE, WIDTH, HEIGHT, BUFFER_SIZE);
		win.show();
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.addLevel(new Game(GAME_ID));
		m.enterLevel(GAME_ID, true);
	}

}
