/**
 * 
 */
package game.resources.data;

import java.util.ArrayList;
import java.util.List;

import game.player.Player;

/**
 * @author Jan Braun
 *
 */
public abstract class GameData {

	private static List<Player> players = new ArrayList<>();

	public static int getPlayerCount() {
		return players.size();
	}

	public static Player getPlayer(int index) {
		return players.get(index);
	}

	public static void add(Player ply) {
		players.add(ply);
	}

}
