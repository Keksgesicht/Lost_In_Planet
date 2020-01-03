package game.map;

import java.util.List;

import game.player.InventoryItem;
import game.resources.GameVisibleItem;
import javafx.scene.image.Image;

public class Block extends GameVisibleItem implements BlockConvertable {

	protected boolean destroyAble;
	protected boolean visible;
	protected List<InventoryItem> droppedItems;
	public Block hiddenBlock;

	/*
	 * weitere Eigenschaften hinzufügen
	 */

	/**
	 * @Override
	 */
	public Block(Image image, String name) {
		super(image, name);
	}

	/**
	 * @return the destroyAble
	 */
	public boolean isDestroyAble() {
		return destroyAble;
	}

	/**
	 * @param destroyAble the destroyAble to set
	 */
	public void setDestroyAble(boolean destroyAble) {
		this.destroyAble = destroyAble;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the droppedItems
	 */
	public List<InventoryItem> getDroppedItems() {
		return droppedItems;
	}

	/**
	 * @param droppedItems the droppedItems to set
	 */
	public void setDroppedItems(List<InventoryItem> droppedItems) {
		this.droppedItems = droppedItems;
	}

	@Override
	public Block toBlock() {
		return this;
	}

}
