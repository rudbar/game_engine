package engine.renderEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Drawer {
	
	private Window win;
	private BufferStrategy st;
	private Graphics g;

	public Drawer(Window win) {
		this.win = win;
		this.st = win.getBufferStrategy();
		this.g = st.getDrawGraphics();
		g.setColor(Color.WHITE);
	}

	public void drawString(String str, int x, int y) {
		g.drawString(str, x, y);
	}
	
	public void fillRect(int x, int y, int sx, int sy) {
		g.fillRect(x, y, sx, sy);
	}
	
	public void setColor(Color color) {
		g.setColor(color);
	}
	
}
