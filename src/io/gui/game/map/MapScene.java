package io.gui.game.map;

import java.awt.Point;

import game.map.GameMap;
import game.player.Player;
import game.resources.data.GameData;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class MapScene extends Scene {

	int gameWidth = 95;
	int gameHeight = 50;
	Point mapPartBase = new Point(0, 0);
	GridPane gridPane;
	GameMap map;

	/**
	 * @param width  the width of the scene
	 * @param height the height of the scene
	 */
	public MapScene(double width, double height) {
		super(new GridPane(), width, height);
		this.addEventHandler(KeyEvent.ANY, new KeyHandler(this));
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(GameMap map) {
		this.map = map;
		display();
	}

	void move(int x, int y) {
		int newX = mapPartBase.x + x;
		int newY = mapPartBase.y + y;
		Player ply = GameData.getPlayer(0);
		int posX = ply.posX() + x;
		int posY = ply.posY() + y;

		// view bounds check
		if (0 <= newX && newX + gameWidth <= map.getWidth())
			mapPartBase.x = newX;
		if (0 <= newY && newY + gameHeight <= map.getHeight())
			mapPartBase.y = newY;

		// player bounds check
		if (0 <= posX && posX <= map.getWidth())
			ply.posX(posX);
		if (0 <= posY && posY <= map.getHeight())
			ply.posY(posY);
		
		display();
	}

	/**
	 * draw the map
	 */
	private void display() {
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(1, 1, 1, 1));
		gridPane.setHgap(1);
		gridPane.setVgap(1);

		for (int y = 0; y < gameHeight; y++) {
			ImageView image;
			Player ply = GameData.getPlayer(0);
			if (ply.posY() == y) {
				for (int x = 0; x < gameWidth; x++) {
					if (ply.posX() == x)
						image = new ImageView(ply.image());
					else
						image = new ImageView(map.getBlock(x, y).image());
					gridPane.add(image, x, y);
				}
			} else {
				for (int x = 0; x < gameWidth; x++) {
					image = new ImageView(map.getBlock(x, y).image());
					gridPane.add(image, x, y);
				}
			}
		}
		this.setRoot(gridPane);
	}

}
