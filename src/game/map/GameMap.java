package game.map;

import java.util.ArrayList;

public class GameMap {

	/*
	 * geplant ist immer nur das im Speicher zu haben was gerade benötigt wird.
	 * mithilfe von offsets soll zur realen Map Teil referenyiert werden können.
	 */
	private ArrayList<ArrayList<Block>> map;

	/**
	 * 
	 */
	public GameMap(int width , int height) {
		map = new ArrayList<>(width);
		for (int i = 0; i < width; i++) {
			ArrayList<Block> col = new ArrayList<>(height);
			for (int j = 0; j < height; j++) {
				col.add(null);
			}
			map.add(col);
		}
	}

	public void setBlock(int x, int y, Block block) {
		map.get(x).set(y, block);
	}

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
