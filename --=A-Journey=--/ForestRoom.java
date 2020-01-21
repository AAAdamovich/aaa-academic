// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-15-12

import java.util.ArrayList;
import java.util.Random;

public class ForestRoom{
	
	// THE PRIVATE VARIABLES
	
	private Location location;
	private int lockedDoor;
	private boolean[] openDoors;
	private int enemyChance;
	private int lootChance;
	private ArrayList<Item> loot;
	private ArrayList<Item> items;
	private String description;
	
	// THE CONSTRUCTOR
	
	// IMPORTANT! Integer code for doors: 0 = North, 1 = East, 2 = South, 3 = West
	// With open doors, the boolean tells you whether or not the door is open, with locked doors, the int tells you which door is locked
	// Door that are locked will be classified as "true" in openDoors[] but will not actually be initially open
	// A value of -1 for int lockedDoors will return no locked doors
	public ForestRoom(int xLoc, int yLoc, int aLockedDoor, int eChance, boolean north, boolean east, boolean south, boolean west){
		loot = new ArrayList<Item>();
		items = new ArrayList<Item>();
		openDoors = new boolean[4];
		location = new Location(xLoc, yLoc);
		lockedDoor = aLockedDoor;
		openDoors[0] = north;
		openDoors[1] = east;
		openDoors[2] = south;
		openDoors[3] = west;
		enemyChance = eChance;
		lootChance = 0;
	}
	
	// THE METHODS
	
	// Returns the location of the room
	public Location getLocation() {
		return location;
	}

	// Returns which door is locked, or if none are
	public int getLockedDoor() {
		return lockedDoor;
	}

	// Changes which door is locked or if none are
	public void setLockedDoor(int aLockedDoor) {
		lockedDoor = aLockedDoor;
	}
	
	// Returns the list of open/closed doors
	public boolean[] getOpenDoors() {
		return openDoors;
	}

	// Changes which doors are open and which are not
	public void setOpenDoors(boolean north, boolean east, boolean south, boolean west) {
		openDoors[0] = north;
		openDoors[1] = east;
		openDoors[2] = south;
		openDoors[3] = west;
	}
	
	// Returns if a selected door is open (int)
	public boolean isDoorOpen(int side){
		return(openDoors[side]);
	}

	// Set the % chance that an item will spawn in a room
	public void setLootChance(int aLootChance) {
		lootChance = aLootChance;
	}

	// Returns the room's list of loot
	public ArrayList<Item> getLoot() {
		return loot;
	}

	// Adds a loot item to the loot array if it passes the spawn test 
	public void genLoot(Item item){
		Random generator = new Random();
		int roll;
		roll = generator.nextInt(100);
		if(roll < lootChance) loot.add(item);
	}
	
	// Returns whether or not a certain item is in the loot Array List. "safe"
	public boolean hasLoot(String item){
		for(int i = 0; i < (loot.size()); i++){
			if(((loot.get(i)).getName()).equals(item)) return true;
		}
		return false;
	}
	
	// Removes a specified loot item from the slot of a room's loot Array List
	public void removeLoot(int slot){
		loot.remove(slot);
	}
	
	// Removes everything from the room's Array List
	public void removeAllLoot(){
		loot.clear();
	}
	
	// Prints a text description of the loot in the room. Works without loot as well, "safe".
	public void printLoot(){
		int size = (loot.size());
		if(!(loot.isEmpty())){
			System.out.print("You find: ");
			for(int i = 0; i < (size - 1); i++) System.out.print(((loot.get(i)).getName()) + ", ");
			System.out.println(((loot.get(size - 1)).getName()) + ".");
		}
		else System.out.println("You find nothing.");
	}
	
	// Prints the representation of all the dropped items in the room. Should print automatically - should NOT have an 'else'
	public void printItems(){
		int size = (items.size());
		if(!(items.isEmpty())){ 
			System.out.print("The following items are strewn about the floor: ");
			for(int i = 0; i < (size - 1); i++) System.out.print(((items.get(i)).getName()) + ", ");
			System.out.println(((items.get(size - 1)).getName()) + ".");
		}
	}

	// This method is to be called when an item is dropped
	public void putItemInRoom(Item item){
		items.add(item);
	}
	
	// Returns a list of all the dropped items in the room (even if there are none) 
	public ArrayList<Item> getItems() {
		return items;
	}
	
	// Displays the description for the room the player is in, int is the door the player is facing
	public void printDescription(int direction){
		if(!((description.charAt(0)) == '$')){
			int size = description.length();
			int prevIndex = 0;
			int runTime = 0;
			int dirChecker;
			String[] directions = new String[4];
			directions[0] = "In front of you";
			directions[1] = "On your right";
			directions[2] = "Behind you";
			directions[3] = "On your left";
			for(int i = 0; i < size; i++){
				if((description.charAt(i)) == '#'){
					if(runTime == 0){
						dirChecker = 0;
						dirChecker -= direction;
						if(dirChecker < 0) dirChecker += 4;
						System.out.print(((description.substring((prevIndex), i)) + (directions[(dirChecker)])));
					}
					if(runTime == 1){
						dirChecker = 0;
						dirChecker += (1 - direction);
						if(dirChecker < 0) dirChecker += 4;
						System.out.print(((description.substring((prevIndex + 1), i)) + (directions[(dirChecker)])));
					}
					if(runTime == 2){
						dirChecker = 0;
						dirChecker += (2 - direction);
						if(dirChecker < 0) dirChecker += 4;
						System.out.print(((description.substring((prevIndex + 1), i)) + (directions[(dirChecker)])));
					}
					if(runTime == 3){
						dirChecker = 0;
						dirChecker += (3 - direction);
						if(dirChecker < 0) dirChecker += 4;
						System.out.println(((description.substring((prevIndex + 1), i)) + (directions[(dirChecker)]) + (description.substring(i + 1))));
					}
					runTime++;
					prevIndex = i;
				}
			}
		}
		else System.out.println(description.substring(1));
	}	

	
	// Sets the description for the room
	public void setDescription(String str){
		description = str;
	}
}