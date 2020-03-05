package test;

import java.awt.Point;
import java.io.FileNotFoundException;

import game.map.Block;
import game.map.Map;
import game.player.Player;
import io.data.DataManager;
import io.gui.game.map.Main;
import io.gui.handling.KeyHandler;
import javafx.application.Application;

public class TestDataCreator {

	public static void createData(Application app) {
		final String execPathString = TestDataCreator.class.getClassLoader().getResource(".").getPath();
		final KeyHandler plyHandler = KeyHandler.singleton();
		final Main main = (Main) app;

		final Map chunk = new Map();
		final Block[][] pBlocks = chunk.blocks;

		Block[] coloredBlocks = new Block[4];
		Player ply = null;

		try {
			Block blueBlock = new Block(DataManager.loadImage(execPathString + "images/blue.png", 48, 48),
					"blauer Block");
			Block greenBlock = new Block(DataManager.loadImage(execPathString + "images/green.png", 48, 48),
					"blauer Block");
			Block redBlock = new Block(DataManager.loadImage(execPathString + "images/red.png", 48, 48),
					"blauer Block");
			Block whiteBlock = new Block(DataManager.loadImage(execPathString + "images/white.png", 48, 48),
					"blauer Block");

			coloredBlocks[0] = blueBlock;
			coloredBlocks[1] = greenBlock;
			coloredBlocks[2] = redBlock;
			coloredBlocks[3] = whiteBlock;
			
			ply = new Player(DataManager.loadImage(execPathString + "images/playermodel.png", 48, 48), "Nummer5");
			plyHandler.setPlayer(ply);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < pBlocks.length; i++) {
			for (int j = 0; j < pBlocks[0].length; j++) {
				pBlocks[i][j] = coloredBlocks[Math.max(i, j) % 4];
			}
		}

		int x = 8;
		int y = 3;

		Block hiddenBlock = chunk.blocks[x][y];
		chunk.blocks[x][y] = ply.toBlock();
		chunk.blocks[x][y].setHiddenBlock(hiddenBlock);
		ply.setPosition(new Point(x, y));

		main.getMapScene().display(chunk);
	}

}
