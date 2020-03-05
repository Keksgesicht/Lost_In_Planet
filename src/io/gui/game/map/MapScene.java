package io.gui.game.map;

import java.awt.Point;

import game.map.GameMap;
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
		display();
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(GameMap map) {
		this.map = map;
	}

	void move(int x, int y) {
		int newX = mapPartBase.x + x;
		int newY = mapPartBase.y + y;

		if (0 <= newX && newX + gameWidth <= map.getWidth())
			mapPartBase.x = newX;
		if (0 <= newY && newY + gameHeight <= map.getHeight())
			mapPartBase.y = newY;

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

		for (int y = 0; y < gameHeight; y++)
			new GridDrawerThread(this, y).start();
		this.setRoot(gridPane);
	}

}


class GridDrawerThread extends Thread {

	int x, y;
	MapScene mapScene;

	public GridDrawerThread(MapScene mapScene, int y) {
		this.mapScene = mapScene;
		this.y = y;
	}

	@Override
	public void run() {
		for (int x = 0; x < mapScene.gameWidth; x++) {
			ImageView image = new ImageView(mapScene.map.getBlock(x, y).image());
			mapScene.gridPane.add(image, x, y);
		}
	}
}
