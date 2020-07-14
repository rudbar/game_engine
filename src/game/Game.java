package game;

import java.awt.Color;

import engine.renderEngine.Drawer;
import engine.renderEngine.GameLevel;
import engine.renderEngine.GameManager;
import engine.renderEngine.Window;
import engine.utils.Debug;

public class Game extends GameLevel {

	public Game(int leveID) {
		this.levelID = levelID;
	}

	public void init(Window win, GameManager mg) {
		
	}

	public void render(Window win, Drawer d,GameManager mg) {
		d.drawString("Hello World!", 100, 300);
		d.fillRect(300, 200, 100, 150);
	}

	public void update(Window win, GameManager mg) {
		
	}

}
