package io.gui.scenes;

import game.map.Block;
import game.map.Chunk;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MapScene extends Scene {

	Chunk playground;

	/**
	 * @param width  the width of the scene
	 * @param height the height of the scene
	 */
	public MapScene(double width, double height) {
		super(new GridPane(), width, height);
	}

	public void display(Chunk playground) {
		this.playground = playground;
		Block[][] pBlocks = playground.blocks;

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(1);
		gridPane.setVgap(1);

		for (int i = 0; i < pBlocks.length; i++) {
			for (int j = 0; j < pBlocks[0].length; j++) {
				ImageView image = new ImageView(pBlocks[i][j].image);
				gridPane.add(image, i, j);
			}
		}

		this.setRoot(gridPane);
	}

}
