package game.resources;

import java.awt.image.BufferedImage;

public abstract class GameVisibleItem {

	public final String name;
	public final BufferedImage image;

	/**
	 * @param image the pictures that will be rendered in the GUI
	 * @param name  let"s the plazer know what item this is
	 */
	public GameVisibleItem(BufferedImage image, String name) {
		this.image = image;
		this.name = name;
	}

}
