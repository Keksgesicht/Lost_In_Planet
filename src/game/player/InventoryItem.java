package game.player;

import java.awt.image.BufferedImage;
import java.util.List;

import game.resources.GameVisibleItem;

public class InventoryItem extends GameVisibleItem {

	protected List<PlayerEffect> playerEffects;
	
	/**
	 * @Override
	 */
	public InventoryItem(BufferedImage image, String name) {
		super(image, name);
	}

}
