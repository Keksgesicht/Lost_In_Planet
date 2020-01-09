package io.gui.scenes;

import game.map.Block;
import game.map.Chunk;
import io.gui.handling.PlayerHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class MapScene extends Scene {

	public Chunk playground;

	/**
	 * @param width  the width of the scene
	 * @param height the height of the scene
	 */
	public MapScene(double width, double height) {
		super(new GridPane(), width, height);

		PlayerHandler.mapScene = this;
		PlayerHandler plyHandler = PlayerHandler.singleton();
		this.addEventHandler(KeyEvent.ANY, plyHandler);
	}

	public void display(Chunk playground) {
		this.playground = playground;
		Block[][] pBlocks = playground.blocks;

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(1);
		gridPane.setVgap(1);

		for (int x = 0; x < pBlocks.length; x++) {
			for (int y = 0; y < pBlocks[0].length; y++) {
				ImageView image = new ImageView(pBlocks[x][y].image());
				gridPane.add(image, x, y);
			}
		}

		this.setRoot(gridPane);
	}

	public void repaint() {
		display(playground);
	}

}
