package game.map;

import java.util.ArrayList;

public class GameMap {

	private ArrayList<ArrayList<Block>> map = new ArrayList<>();

	public Block getBlock(int x, int y) {
		return map.get(x).get(y);
	}

	public int getWidth() {
		return 0;
	}

	public int getHeight() {
		return 0;
	}

}
