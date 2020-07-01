package engine.renderEngine;

import java.util.ArrayList;

public class GameManager {

	private ArrayList<GameLevel> levels = new ArrayList<GameLevel>();
	private GameLevel currentLevel;
	
	public void addLevel(GameLevel level) {
		levels.add(level);
	}
	
	public void flushLevels(GameLevel level) {
		levels.clear();
	}
	
	public void enterLevel(int levelID) {
		currentLevel = levels.get(levelID);
	}

}
