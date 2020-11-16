// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-13-12

import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {
	
	// Checks and runs any command the user inputs, will also print error messages
	private static boolean exe(String command, Inventory inven, Player player, ArrayList<ForestRoom> forestArea){
		int cLength = command.length();
		String cCall = (command.substring(0, (cLength) - 2));
		ForestRoom cRoom = player.getCurrentRoom();
		
		// "Help" Command
		
		if((command.equalsIgnoreCase("help"))){
			System.out.println("         ---== List of Commands ==---");
			System.out.println("Help: Shows you a list of valid commands");
			System.out.println("Inventory: Shows you your inventory");
			System.out.println("Observe: Tells you anything interesting about the room you are currently in");
			System.out.println("Use x: Uses an item from your inventory, 'x' is the slot in which this item resides");
			System.out.println("Inspect x: Tells you everything important about an item from your inventory, 'x' is the slot in which this item resides");
			System.out.println("Drop x: Drops an item from your inventory, 'x' is the slot in which this item resides");
			System.out.println("Forward, left, back, right: Moves your charecter in the noted direction");
			System.out.println("Observe Loot: Tells you about availible loot in the room you are currently in");
			System.out.println("Loot x: Loots a specified item, 'Observe Loot' will assist in properly designating 'x'");
			System.out.println("Loot All: Loots everything in the room you are currently in, to the limit of your inventory");
			return true;
		}
		
		// Print Inventory
		
		if((command.equalsIgnoreCase("inventory"))){
			inven.displayInventory();
			return true;
		}
		
		// "Observe" Command
		
		if((command.equalsIgnoreCase("observe"))){
			cRoom.printDescription(player.getFacingDir());
			cRoom.printItems();
			return true;
		}
		
		// Item Commands
		
		if(((cCall.equalsIgnoreCase("use")) || (cCall.equalsIgnoreCase("inspect"))) || (cCall.equalsIgnoreCase("drop"))){
			if(command.charAt((cLength - 2)) == ' '){
				int invenSlot;
				invenSlot = Integer.parseInt((command.substring((cLength - 1))));
				if((invenSlot > (inven.getInventorySize())) || (invenSlot == 0)){
					System.out.println("That particular inventory slot does not exist. ");
					return true;
				}
				else{
					if(!(inven.slotIsFull(invenSlot - 1))){
						System.out.println("That inventory slot is empty. ");
						return true;
					}
					else{
						inven.itemAction((invenSlot - 1), cCall, inven, player, cRoom);
						return true;
					}
				}
			}
			return false;
		}

		// Player Movement (Also prints the room's description) Returns error messages in you like running into walls

		if(((command.equalsIgnoreCase("forward")) || (command.equalsIgnoreCase("right"))) || ((command.equalsIgnoreCase("back")) || (command.equalsIgnoreCase("left")))){
			int fDir = player.getFacingDir();
			int mDir = 0;
			int sDir;
			boolean[] validDirs;
			validDirs = (cRoom.getOpenDoors());
			if(command.equalsIgnoreCase("forward")) mDir = 0;
			if(command.equalsIgnoreCase("right")) mDir = 1;
			if(command.equalsIgnoreCase("back")) mDir = 2;
			if(command.equalsIgnoreCase("left")) mDir = 3;
			sDir = (fDir + mDir);
			if(sDir >= 4) sDir -= 4;
			if(validDirs[sDir]){
				if(sDir != (cRoom.getLockedDoor())){
					player.adjustLocation(sDir);
					player.adjustFacingDir(mDir);
					for(ForestRoom room : forestArea){
						if((room.getLocation()).equals(player.getLocation())){
							player.setCurrentRoom(room);
							room.printDescription(player.getFacingDir());
							return true;
						}
					}
				}
				else{ 
					System.out.println("To advance in that direction requires the use of a key. ");
					return true;
				}
			}
			else{ 
				System.out.println("You cannot advance in that direction. ");
				return true;
			}
		}

		// Item Loot Description
		
		if((command.equalsIgnoreCase("observe loot"))){
			cRoom.printLoot();
			return true;
		}
		
		// Loot Command + Error Message
		
		if((cCall.equalsIgnoreCase("loot"))){
			if(command.charAt((cLength - 2)) == ' '){
				int lootSlot;
				lootSlot = Integer.parseInt((command.substring((cLength - 1))));
				if((lootSlot > (cRoom.getLoot().size())) || (lootSlot == 0)){
					System.out.println("You can't loot something that doesn't exist. ");
					return true;
				}
				else{
					if(inven.isFull()){
						System.out.println("Your inventory is full. ");
						return true;
					}
					else{
						Item item = cRoom.getLoot().get(lootSlot - 1);
						inven.addItem(item);
						cRoom.removeLoot(lootSlot - 1);
						System.out.println("Looting successful. ");
						return true;
					}
				}
			}
			return false;
		}
		
		// "Loot All" Command + Error Message
		
		if((command.equalsIgnoreCase("loot all"))){
			if(inven.isFull()){
				System.out.println("Your inventory is full. ");
				return true;
			}
			else{
				ArrayList<Item> lootables = cRoom.getLoot();
				if(lootables.isEmpty()){
					System.out.println("There is nothing to loot. ");
					return true;
				}
				else{
					while(!((inven.isFull()) || (lootables.isEmpty()))){
						Item lootItem = cRoom.getLoot().get(0);
						inven.addItem(lootItem);
						cRoom.getLoot().remove(0);
					}
					System.out.println("Everything that could possibly be looted has been. If your inventory was full, some loot may yet remain. ");
					return true;
				}
			}
		}
		// Final "false" for no command matches
		return false;
	}
	
	// Runs a combat situation, returns player to previous room if fleeing from combat
	public boolean runCombat(String command, Inventory inven, Player player, int enemy){
		return true;
		
	}
	
	// THE MAIN METHOD

	public static void main(String[] args) {
		
		// Object & Variable Declarations
		
		Inventory inven;
		ForestArea a1;
		ArrayList<ForestRoom> forestArea;
		Player player;
		Scanner readerN;
		Scanner readerS;
		String command;
		
		// Initialization & Instantiation
		
		a1 = new ForestArea();
		inven = new Inventory();
		readerN = new Scanner(System.in);
		readerS = new Scanner(System.in);
		inven.initializeInventory();
		forestArea = (a1.importForestRooms());
		player = new Player(forestArea.get(0));
		
		// Main Console Loop
		
		System.out.println("For a long time you have been thinking... About what or why seems to escape you. It's not that you can't remember, it's just that there is nothing to remember. You take stock of your surroundings... Trees all around. Ancient and young ones weave together to create what feels like a prison." +
				"\nYou are standing on a small patch of stones, worn perfectly smooth. There seems to be no escape from these absurd grey and green denizens except a small hole directly in front of you. How come I didn't notice this before?");
		forestArea.get(0).setDescription("$Emerging from that dense tunnel of a hole, you see nothing but trees around you, their ominous bodies extending into the pale sky. There are some smooth stones arranged in a rough circle before you. Behind you is the tunnel that you know leads back to the rest of the forest. ");
		command = readerS.nextLine();
		while(!(command.equals("exit"))){
			if(!(exe(command, inven, player, forestArea))) System.out.println("That is not a valid command. ");
			
			command = readerS.nextLine();
		}
		
		// Testing code
		
		//(forestArea.get(0)).setDescription("A waterfall appears before you. #, you can barely see an entrance uder the water's torrent. #, a giant cliff rises into the skies. # is the cave from which you have just emerged. #, there is a door. ");
		//(forestArea.get(0)).printDescription(1);
		//inven.addItem(hPot);
		//System.out.println("X: " + (player.getLocation().getX()) + " Y: " + (player.getLocation().getY()));
		//exe("forward", inven, player, forestArea);
		//System.out.println("X: " + (player.getLocation().getX()) + " Y: " + (player.getLocation().getY()));
		//exe("right", inven, player, forestArea);
		//System.out.println("X: " + (player.getLocation().getX()) + " Y: " + (player.getLocation().getY()));
		//exe("back", inven, player, forestArea);
		//System.out.println("X: " + (player.getLocation().getX()) + " Y: " + (player.getLocation().getY()));
		//exe("inspect -3", inven, player, forestArea);
		//if(i.invenIsFull()) System.out.println("YES");
		//else System.out.println("NO");
	}
}