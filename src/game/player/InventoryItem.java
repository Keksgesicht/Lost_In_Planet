package game.player;

import java.util.List;

import game.resources.GameVisibleItem;
import javafx.scene.image.Image;

public class InventoryItem extends GameVisibleItem {

	protected List<PlayerEffect> playerEffects;
	
	/**
	 * @Override
	 */
	public InventoryItem(Image image, String name) {
		super(image, name);
	}

}
