package io.gui.game.map;

import java.awt.Point;

import game.map.GameMap;
import game.player.Player;
import game.resources.data.GameData;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MapScene extends Scene {

	int gameWidth = 75;
	int gameHeight = 42;
	Point base = new Point(0, 0);
	GameMap map;

	/**
	 * @param width  the width of the scene
	 * @param height the height of the scene
	 */
	public MapScene(double width, double height) {
		super(new VBox(), width, height);
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
		int newX = base.x + x;
		int newY = base.y + y;
		Player ply = GameData.getPlayer(0);
		int posX = ply.posX() + x;
		int posY = ply.posY() + y;
		int mapMaxX = map.getWidth();
		int mapMaxY = map.getHeight();

		// view bounds check
		if (0 <= newX && newX + gameWidth <= mapMaxX && newX + gameWidth / 2 == posX)
			base.x = newX;
		if (0 <= newY && newY + gameHeight <= mapMaxY && newY + gameHeight / 2 == posY)
			base.y = newY;

		// player bounds check
		if (0 <= posX && posX < mapMaxX)
			ply.posX(posX);
		if (0 <= posY && posY < mapMaxY)
			ply.posY(posY);
		
		display();
	}

	/**
	 * draw the map
	 */
	private void display() {
		VBox pane = new VBox(1);
		pane.setPadding(new Insets(1, 1, 1, 1));
		ImageView image;
		
		Player ply = GameData.getPlayer(0);
		int posX = ply.posX();
		int posY = ply.posY();
		
		for (int y = 0; y < gameHeight; y++) {
			int by = base.y + y;
			HBox box = new HBox(1);
			for (int x = 0; x < gameWidth; x++) {
				int bx = base.x + x;
				if (posX == bx && posY == by)
					image = new ImageView(ply.image());
				else
					image = new ImageView(map.getBlock(bx, by).image());
				image.setFitHeight(20);
				image.setFitWidth(20);
				box.getChildren().add(x, image);
			}
			pane.getChildren().add(y, box);
		}
		this.setRoot(pane);
	}

}
