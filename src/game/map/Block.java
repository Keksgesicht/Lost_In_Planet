package game.map;

import java.util.List;

import game.player.InventoryItem;
import game.resources.GameVisibleItem;
import javafx.scene.image.Image;

public class Block extends GameVisibleItem implements BlockConvertable {

	private boolean destroyAble;
	private boolean visible;
	private List<InventoryItem> droppedItems;
	private Block hiddenBlock;
	/*
	 * weitere Eigenschaften hinzufügen
	 */

	/**
	 * @param image the pictures that will be rendered in the GUI
	 * @param name  let"s the plazer know what item this is
	 */
	public Block(Image image, String name) {
		super(image, name);
	}

	@Override
	public Block toBlock() {
		return this;
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

	/**
	 * @return the hiddenBlock
	 */
	public Block getHiddenBlock() {
		return hiddenBlock;
	}

	/**
	 * @param hiddenBlock the hiddenBlock to set
	 */
	public void setHiddenBlock(Block hiddenBlock) {
		this.hiddenBlock = hiddenBlock;
	}


}
