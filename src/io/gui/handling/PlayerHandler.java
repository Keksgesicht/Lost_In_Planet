package io.gui.handling;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

	private static final Map<String, Set<KeyCode>> KEY_MAP = new HashMap<String, Set<KeyCode>>();
	private static PlayerHandler singleton;
	private static MapScene mapScene;
	private static Block[][] blocks;
	private Player ply;

	static {
		// ONLY DURING TESTING
		setKeyBinding("KEY_PLAYER_UP", KeyCode.W, KeyCode.UP);
		setKeyBinding("KEY_PLAYER_DOWN", KeyCode.S, KeyCode.DOWN);
		setKeyBinding("KEY_PLAYER_LEFT", KeyCode.A, KeyCode.LEFT);
		setKeyBinding("KEY_PLAYER_RIGHT", KeyCode.D, KeyCode.RIGHT);
	}

	public static void setKeyBinding(String function, KeyCode... keys) {
		KEY_MAP.put(function, Arrays.stream(keys).collect(Collectors.toSet()));
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
			if (KEY_MAP.get("KEY_PLAYER_UP").contains(keyCode) || KEY_MAP.get("KEY_PLAYER_DOWN").contains(keyCode)
					|| KEY_MAP.get("KEY_PLAYER_LEFT").contains(keyCode)
					|| KEY_MAP.get("KEY_PLAYER_RIGHT").contains(keyCode)) {
				movePlayer(keyCode);
			}
		}
	}

	private void movePlayer(KeyCode keyCode) {
		blocks = mapScene.playground.blocks;
		Player ply = getPlayer();
		Block playerBlock = ply.toBlock();
		Point plyPosition = ply.getPosition();
		
		if (KEY_MAP.get("KEY_PLAYER_UP").contains(keyCode)) {
			if (plyPosition.y != 0) {
				hiddenBlock(plyPosition.x, plyPosition.y--, playerBlock);
				playerBlock(plyPosition.x, plyPosition.y, playerBlock);
			}
		}
		else if (KEY_MAP.get("KEY_PLAYER_DOWN").contains(keyCode)) {
			if (plyPosition.y != blocks[plyPosition.x].length - 1) {
				hiddenBlock(plyPosition.x, plyPosition.y++, playerBlock);
				playerBlock(plyPosition.x, plyPosition.y, playerBlock);
			}
		} else if (KEY_MAP.get("KEY_PLAYER_LEFT").contains(keyCode)) {
			if (plyPosition.x != 0) {
				hiddenBlock(plyPosition.x--, plyPosition.y, playerBlock);
				playerBlock(plyPosition.x, plyPosition.y, playerBlock);
			}
		} else if (KEY_MAP.get("KEY_PLAYER_RIGHT").contains(keyCode)) {
			if (plyPosition.x != blocks.length - 1) {
				hiddenBlock(plyPosition.x++, plyPosition.y, playerBlock);
				playerBlock(plyPosition.x, plyPosition.y, playerBlock);
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
