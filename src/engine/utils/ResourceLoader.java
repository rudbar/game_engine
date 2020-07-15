package engine.utils;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class ResourceLoader {

	public static Image loadImage(String path) {
		try {
			Image img = ImageIO.read(new File(path));
			return img;
		} catch (Exception e) {
			Debug.LogError(e.getMessage());
		}
		return null;
	}
	
}
