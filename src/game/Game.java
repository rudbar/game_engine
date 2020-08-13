package game;

import java.awt.Color;

import engine.inputeEngine.Input;
import engine.inputeEngine.Mouse;
import engine.renderEngine.core.Drawer;
import engine.renderEngine.core.GameLevel;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;
import engine.renderEngine.graphics.Image;
import engine.utils.Debug;

public class Game extends GameLevel {

	Image img;
	int y = 200, x = 100;
	
	String coords = "0, 0";
	 
	public Game(int leveID) {
		this.levelID = levelID;
	}

	public void init(Window win, GameManager mg) {
		img = new Image("res/test.png");
	}

	public void render(Window win, Drawer d,GameManager mg) {
		d.drawString("Coordinates: " + coords, 100, 300);
		d.drawImage(img, x, y);
	}

	public void update(Window win, GameManager mg) {
		Input inp = win.getInput();
		Mouse m = win.getMouse();
		
		coords = m.getX() + ", " + m.getY();
		
		x = m.getX()-40;
		y = m.getY()-40;
	}

}
