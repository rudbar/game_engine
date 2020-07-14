package engine.renderEngine;

import java.awt.Color;
import java.util.ArrayList;

public class GameManager {

	private ArrayList<GameLevel> levels = new ArrayList<GameLevel>();
	private GameLevel currentLevel;
	private Window win;
	
	
	public void addLevel(GameLevel level) {
		levels.add(level);
	}
	
	public void flushLevels(GameLevel level) {
		levels.clear();
	}
	
	public void enterLevel(int levelID, boolean doInit) {
		currentLevel = levels.get(levelID);
		if (doInit) {
			currentLevel.init(win, this);
		}
	}

	public Window createWindow(String TITLE, int WIDTH, int HEIGHT, int BUFFER_SIZE) {
		win = new Window(TITLE, WIDTH, HEIGHT, BUFFER_SIZE, this);
		return win;
	}
	
	//window access
	void init() {
		if (isLevelOpen())
			currentLevel.init(win, this);
	}
	void render() {
		if (isLevelOpen()) {
			win.clear(Color.BLACK);
			currentLevel.render(win, win.getDrawer(),this);
			win.update();
			win.frames++;
		}
	}
	void update() {
		if (isLevelOpen()) {
			currentLevel.update(win, this);
			win.ticks++;
		}
			
	}
	
	private boolean isLevelOpen() {
		if (currentLevel == null) {
			return false;
		}
		return true;
	}
	
}
