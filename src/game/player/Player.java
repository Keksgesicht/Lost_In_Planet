package game.player;

import java.io.File;

public class Player {

	 public int id ;
	 public int maxHP ;
	 public int currentHP;
	 
	 int[] Gear = new int[3]; // int[0] = Head, int[1] = Body, int[2] = Legs, int[3] = Hand
	 int[] Quickslots = new int[3]; 
	 int[] Inventory = new int[8];
	 
	 double x;
	 double y;
	 
	File playerFile;
	 
	 
}
