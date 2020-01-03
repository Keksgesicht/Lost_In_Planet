package io.gui.handling;

import game.map.Block;
import game.player.Player;
import io.gui.scenes.MapScene;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author Jan B.
 */
public class PlayerHandler implements EventHandler<KeyEvent> {

	public static KeyCode KEY_PLAYER_UP = KeyCode.W;
	public static KeyCode KEY_PLAYER_DOWN = KeyCode.S;
	public static KeyCode KEY_PLAYER_LEFT = KeyCode.A;
	public static KeyCode KEY_PLAYER_RIGHT = KeyCode.D;

	private static PlayerHandler singleton;
	public static MapScene mapScene;
	public static Player ply;

	private Block[][] blocks;

	public static PlayerHandler singleton() {
		if (singleton == null)
			return new PlayerHandler();
		else
			return singleton;
	}

	private PlayerHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(KeyEvent keyEvent) {
		EventType<KeyEvent> keyEventType = keyEvent.getEventType();
		KeyCode keyCode = keyEvent.getCode();
		
		if (keyEventType == KeyEvent.KEY_PRESSED) {
			if (keyCode == KEY_PLAYER_UP 
			 || keyCode == KEY_PLAYER_DOWN
			 || keyCode == KEY_PLAYER_LEFT
			 || keyCode == KEY_PLAYER_RIGHT) {
				movePlayer(keyCode);
			}
		}
	}

	private void movePlayer(KeyCode keyCode) {
		blocks = mapScene.playground.blocks;
		Block playerBlock = ply.toBlock();
		
		if (keyCode == KEY_PLAYER_UP) {
			if (ply.y != 0) {
				hiddenBlock(ply.x, ply.y--, playerBlock);
				playerBlock(ply.x, ply.y, playerBlock);
			}
		}
		else if (keyCode == KEY_PLAYER_DOWN) {
			if (ply.y != blocks[ply.x].length - 1) {
				hiddenBlock(ply.x, ply.y++, playerBlock);
				playerBlock(ply.x, ply.y, playerBlock);
			}
		} else if (keyCode == KEY_PLAYER_LEFT) {
			if (ply.x != 0) {
				hiddenBlock(ply.x--, ply.y, playerBlock);
				playerBlock(ply.x, ply.y, playerBlock);
			}
		} else if (keyCode == KEY_PLAYER_RIGHT) {
			if (ply.x != blocks.length - 1) {
				hiddenBlock(ply.x++, ply.y, playerBlock);
				playerBlock(ply.x, ply.y, playerBlock);
			}
		}
		mapScene.repaint();
	}

	private void hiddenBlock(int x, int y, Block playerBlock) {
		blocks[x][y] = playerBlock.hiddenBlock;
	}

	private void playerBlock(int x, int y, Block playerBlock) {
		playerBlock.hiddenBlock = blocks[x][y];
		blocks[x][y] = playerBlock;
	}



}
