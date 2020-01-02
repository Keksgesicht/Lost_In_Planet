package game.player;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import game.resources.GameVisibleItem;

public class Player extends GameVisibleItem {

	public final Map<InventoryItem, Double> inventoryItems = new HashMap<>();

	/**
	 * @Override
	 */
	public Player(BufferedImage image, String name) {
		super(image, name);
	}

}
