package game.map;

import java.awt.image.BufferedImage;
import java.util.List;

import game.player.InventoryItem;
import game.resources.GameVisibleItem;

public class Block extends GameVisibleItem {

	protected boolean destroyAble;
	protected boolean visible;
	protected List<InventoryItem> droppedItems;
	/*
	 * weitere Eigenschaften hinzufügen
	 */

	/**
	 * @Override
	 */
	public Block(BufferedImage image, String name) {
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

}
