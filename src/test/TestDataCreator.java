package test;

import java.io.FileNotFoundException;

import game.map.Block;
import game.map.Chunk;
import game.player.Player;
import io.data.DataManager;
import io.gui.handling.PlayerHandler;
import io.gui.stages.Main;
import javafx.application.Application;

public class TestDataCreator {

	public static void createData(Application app) {
		try {
			final String execPathString = TestDataCreator.class.getClassLoader().getResource(".").getPath();
			final Chunk chunk = new Chunk();
			
			Block blueBlock = new Block(DataManager.loadImage(execPathString + "images/blue.png", 48, 48),
					"blauer Block");
			Block greenBlock = new Block(DataManager.loadImage(execPathString + "images/green.png", 48, 48),
					"blauer Block");
			Block redBlock = new Block(DataManager.loadImage(execPathString + "images/red.png", 48, 48),
					"blauer Block");
			Block whiteBlock = new Block(DataManager.loadImage(execPathString + "images/white.png", 48, 48),
					"blauer Block");

			Block[] coloredBlocks = new Block[4];
			coloredBlocks[0] = blueBlock;
			coloredBlocks[1] = greenBlock;
			coloredBlocks[2] = redBlock;
			coloredBlocks[3] = whiteBlock;

			Block[][] pBlocks = chunk.blocks;
			for (int i = 0; i < pBlocks.length; i++) {
				for (int j = 0; j < pBlocks[0].length; j++) {
					pBlocks[i][j] = coloredBlocks[Math.max(i, j) % 4];
				}
			}

			Player ply;
			int x = 8;
			int y = 3;
			PlayerHandler.ply = ply = new Player(
					DataManager.loadImage(execPathString + "images/playermodel.png", 48, 48), "Nummer5");

			Block hiddenBlock = chunk.blocks[x][y];
			chunk.blocks[x][y] = ply.toBlock();
			chunk.blocks[x][y].hiddenBlock = hiddenBlock;

			ply.x = x;
			ply.y = y;

			Main main = (Main) app;
			main.getMapScene().display(chunk);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
