package game.resources;

import javafx.scene.image.Image;

public abstract class GameVisibleItem {

	private final String name;
	private final Image image;

	/**
	 * @param image the pictures that will be rendered in the GUI
	 * @param name  let"s the plazer know what item this is
	 */
	public GameVisibleItem(Image image, String name) {
		this.image = image;
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String name() {
		return name;
	}

	/**
	 * @return the image
	 */
	public Image image() {
		return image;
	}

}
