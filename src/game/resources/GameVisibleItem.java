package game.resources;

import javafx.scene.image.Image;

public abstract class GameVisibleItem {

	public final String name;
	public final Image image;

	/**
	 * @param image the pictures that will be rendered in the GUI
	 * @param name  let"s the plazer know what item this is
	 */
	public GameVisibleItem(Image image, String name) {
		this.image = image;
		this.name = name;
	}

}
