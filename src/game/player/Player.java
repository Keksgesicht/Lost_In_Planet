package game.player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import game.resources.GameVisibleItem;

public class Player extends GameVisibleItem {

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
	public Player(BufferedImage image, String name) {
		super(image, name);
	}
	 
}
