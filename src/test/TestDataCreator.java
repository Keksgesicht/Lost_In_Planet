package test;

import java.io.FileNotFoundException;

import game.map.Block;
import game.map.GameMap;
import game.player.Player;
import game.resources.data.GameData;
import io.data.DataManager;
import io.gui.game.GameStage;

public class TestDataCreator {

	public static void createData(GameStage app) {
		final int width, height;
		width = 200;
		height = 75;
		final String execPathString = TestDataCreator.class.getClassLoader().getResource(".").getPath();
		final GameMap map = new GameMap(width, height);

		Block[] coloredBlocks = new Block[4];
		Player ply = null;

		try {
			Block blueBlock = new Block(DataManager.loadImage(execPathString + "images/blue.png", 20, 20),
					"blauer Block");
			Block greenBlock = new Block(DataManager.loadImage(execPathString + "images/green.png", 20, 20),
					"blauer Block");
			Block redBlock = new Block(DataManager.loadImage(execPathString + "images/red.png", 20, 20),
					"blauer Block");
			Block whiteBlock = new Block(DataManager.loadImage(execPathString + "images/white.png", 20, 20),
					"blauer Block");

			coloredBlocks[0] = blueBlock;
			coloredBlocks[1] = greenBlock;
			coloredBlocks[2] = redBlock;
			coloredBlocks[3] = whiteBlock;
			
			ply = new Player(DataManager.loadImage(execPathString + "images/playermodel.png", 20, 20), "Nummer5");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map.setBlock(i, j, coloredBlocks[Math.max(i, j) % 4]);
			}
		}
		ply.posX(8);
		ply.posY(3);
		GameData.add(ply);
		app.getMapScene().setMap(map);
	}

}
