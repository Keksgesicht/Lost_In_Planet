/**
 * 
 */
package game.resources;

import java.util.ArrayList;
import java.util.List;

import game.player.Player;

/**
 * @author Jan Braun
 *
 */
public abstract class GameData {

	private static List<Player> players = new ArrayList<>();

	private GameData() {
	}

	public static int getPlayerCount() {
		return players.size();
	}

	public static Player getPlayer(int index) {
		return players.get(index);
	}

}
