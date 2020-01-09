package game.player;

import java.util.List;

import game.resources.GameVisibleItem;
import javafx.scene.image.Image;

public class InventoryItem extends GameVisibleItem {

	protected List<PlayerEffect> playerEffects;
	
	/**
	 * @param image the pictures that will be rendered in the GUI
	 * @param name  let"s the plazer know what item this is
	 */
	public InventoryItem(Image image, String name) {
		super(image, name);
	}

}
