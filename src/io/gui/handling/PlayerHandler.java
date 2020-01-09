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

	private static KeyCode KEY_PLAYER_UP = KeyCode.W;
	private static KeyCode KEY_PLAYER_DOWN = KeyCode.S;
	private static KeyCode KEY_PLAYER_LEFT = KeyCode.A;
	private static KeyCode KEY_PLAYER_RIGHT = KeyCode.D;

	private static PlayerHandler singleton;
	private static MapScene mapScene;
	private static Block[][] blocks;
	private Player ply;

	static {

	}

	public static PlayerHandler singleton() {
		if (singleton == null)
			return singleton = new PlayerHandler();
		else
			return singleton;
	}

	private PlayerHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mapScene the mapScene to set
	 */
	public static void setMapScene(MapScene mapScene) {
		PlayerHandler.mapScene = mapScene;
	}

	/**
	 * @return the current active player
	 */
	public Player getPlayer() {
		return ply;
	}

	/**
	 * @param ply the current active player
	 */
	public void setPlayer(Player ply) {
		this.ply = ply;
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
		Block playerBlock = getPlayer().toBlock();
		
		if (keyCode == KEY_PLAYER_UP) {
			if (getPlayer().y != 0) {
				hiddenBlock(getPlayer().x, getPlayer().y--, playerBlock);
				playerBlock(getPlayer().x, getPlayer().y, playerBlock);
			}
		}
		else if (keyCode == KEY_PLAYER_DOWN) {
			if (getPlayer().y != blocks[getPlayer().x].length - 1) {
				hiddenBlock(getPlayer().x, getPlayer().y++, playerBlock);
				playerBlock(getPlayer().x, getPlayer().y, playerBlock);
			}
		} else if (keyCode == KEY_PLAYER_LEFT) {
			if (getPlayer().x != 0) {
				hiddenBlock(getPlayer().x--, getPlayer().y, playerBlock);
				playerBlock(getPlayer().x, getPlayer().y, playerBlock);
			}
		} else if (keyCode == KEY_PLAYER_RIGHT) {
			if (getPlayer().x != blocks.length - 1) {
				hiddenBlock(getPlayer().x++, getPlayer().y, playerBlock);
				playerBlock(getPlayer().x, getPlayer().y, playerBlock);
			}
		}
		mapScene.repaint();
	}

	private void hiddenBlock(int x, int y, Block playerBlock) {
		blocks[x][y] = playerBlock.getHiddenBlock();
	}

	private void playerBlock(int x, int y, Block playerBlock) {
		playerBlock.setHiddenBlock(blocks[x][y]);
		blocks[x][y] = playerBlock;
	}

}
