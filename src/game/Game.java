package game;

import java.awt.Color;

import engine.renderEngine.core.Drawer;
import engine.renderEngine.core.GameLevel;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;
import engine.renderEngine.graphics.Image;
import engine.utils.Debug;

public class Game extends GameLevel {

	Image img;
	
	public Game(int leveID) {
		this.levelID = levelID;
	}

	public void init(Window win, GameManager mg) {
		img = new Image("res/test.png");
	}

	public void render(Window win, Drawer d,GameManager mg) {
		d.drawString("Hello World!", 100, 300);
		d.drawImage(img, 200, 300);
	}

	public void update(Window win, GameManager mg) {
		
	}

}
