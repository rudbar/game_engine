package engine.renderEngine.graphics;

import engine.utils.ResourceLoader;

public class Image {

	private java.awt.Image img;
	
	public Image(String path) {
		img = ResourceLoader.loadImage(path);
	}	

	public java.awt.Image getRawImage() {
		return img;
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
}
