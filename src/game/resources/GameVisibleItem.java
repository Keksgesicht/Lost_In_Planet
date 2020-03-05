package game.resources;

import java.awt.Point;

import javafx.scene.image.Image;

public abstract class GameVisibleItem {

	private final String name;
	private final Image image;
	private Point position;

	/**
	 * @param image the pictures that will be rendered in the GUI
	 * @param name  let"s the plazer know what item this is
	 */
	public GameVisibleItem(Image image, String name) {
		this.image = image;
		this.name = name;
		position = new Point(0, 0);
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

	public int posX() {
		return position.x;
	}

	public int posY() {
		return position.y;
	}

	public void posX(int x) {
		position.x = x;
	}

	public void posY(int y) {
		position.y = y;
	}

}
