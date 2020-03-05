package game.map;

import java.util.ArrayList;

public class GameMap {

	/*
	 * geplant ist immer nur das im Speicher zu haben was gerade benötigt wird.
	 * mithilfe von offsets soll zur realen Map Teil referenyiert werden können.
	 */
	private ArrayList<ArrayList<Block>> map;

	public Block getBlock(int x, int y) {
		return map.get(x).get(y);
	}

	public int getWidth() {
		return map.size();
	}

	public int getHeight() {
		return map.get(0).size();
	}

}
