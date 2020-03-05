package io.gui.game.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author Jan B.
 */
public class KeyHandler implements EventHandler<KeyEvent> {

	private static final Map<String, Set<KeyCode>> KEY_MAP = new HashMap<String, Set<KeyCode>>();
	private MapScene mapScene;

	static {
		// ONLY DURING TESTING
		setKeyBinding("KEY_PLAYER_UP", KeyCode.W, KeyCode.UP);
		setKeyBinding("KEY_PLAYER_DOWN", KeyCode.S, KeyCode.DOWN);
		setKeyBinding("KEY_PLAYER_LEFT", KeyCode.A, KeyCode.LEFT);
		setKeyBinding("KEY_PLAYER_RIGHT", KeyCode.D, KeyCode.RIGHT);
	}

	public KeyHandler(MapScene map) {
		mapScene = map;
	}

	public static void setKeyBinding(String function, KeyCode... keys) {
		KEY_MAP.put(function, Arrays.stream(keys).collect(Collectors.toSet()));
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
		if (KEY_MAP.get("KEY_PLAYER_UP").contains(keyCode)) {
			mapScene.move(0, -1);
		} else if (KEY_MAP.get("KEY_PLAYER_DOWN").contains(keyCode)) {
			mapScene.move(0, 1);
		} else if (KEY_MAP.get("KEY_PLAYER_LEFT").contains(keyCode)) {
			mapScene.move(-1, 0);
		} else if (KEY_MAP.get("KEY_PLAYER_RIGHT").contains(keyCode)) {
			mapScene.move(1, 0);
		}
	}

}
