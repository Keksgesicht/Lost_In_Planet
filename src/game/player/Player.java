package game.player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import game.map.Block;
import game.map.BlockConvertable;
import game.resources.GameVisibleItem;
import javafx.scene.image.Image;

public class Player extends GameVisibleItem implements BlockConvertable {

	public int maxHP ;
	public int currentHP;
	 
	int[] Gear = new int[3]; // int[0] = Head, int[1] = Body, int[2] = Legs, int[3] = Hand
	int[] Quickslots = new int[3]; 
	public final Map<InventoryItem, Double> inventoryItems = new HashMap<>();
	 
	double x;
	double y;
	 
	File playerFile;

	/**
	 * 
	 * @param image this will display the player in the GUI
	 * @param name his name
	 * @param playerFile where his data will saved
	 */
	public Player(Image image, String name) {
		super(image, name);
	}

	@Override
	public Block toBlock() {
		return new Block(image, name);
	}
	 
}
