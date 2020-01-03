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
			
			Block blueBlock = new Block(DataManager.loadImage(execPathString + "images/blue.png", 32, 32),
					"blauer Block");
			Block[][] pBlocks = chunk.blocks;
			for (int i = 0; i < pBlocks.length; i++) {
				for (int j = 0; j < pBlocks[0].length; j++) {
					pBlocks[i][j] = blueBlock;
				}
			}

			Player ply;
			PlayerHandler.ply = ply = new Player(
					DataManager.loadImage(execPathString + "images/playermodel.png", 32, 32), "Nummer5");
			chunk.blocks[8][8] = ply.toBlock();

			Main main = (Main) app;
			main.getMapScene().display(chunk);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
