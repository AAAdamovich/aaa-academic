// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-13-12

import java.util.ArrayList;

public class Inventory{
	
	// THE PRIVATE VARIABLES
	
	private int inventorySize;
	private ArrayList<Item> inventoryList;
	private EmptySlot empty;
	
	// THE CONSTRUCTOR
	
	public Inventory(){
		inventorySize = 6;
		inventoryList = new ArrayList<Item>(inventorySize);
		empty = new EmptySlot();
	}

	// THE METHODS
	
	// Returns the size of the inventory
	public int getInventorySize() {
		return inventorySize;
	}

	// Changes the size of the inventory
	public void setInventorySize(int inventorySize) {
		this.inventorySize = inventorySize;
	}

	// Fills the inventory with empty slots, REQUIRED for the inventory to work
	public void initializeInventory(){
		for(int i = 0; i <= (inventorySize - 1); i++){
			inventoryList.add(i, empty);
		}
	}

	// Opens a GUI window that displays the inventory
	public void displayInventory(){
		InventoryWindow.makeWindow(inventoryList);
	}
	
	// Adds an item into an empty slot in the inventory. Method is "safe", but check if full anyway
	public void addItem(Item item){
		int slotNum = 0;
		if((inventoryList.get(slotNum)) instanceof EmptySlot){
			inventoryList.set(slotNum, item);
			slotNum = 100;
		}
		while ((slotNum <= (inventorySize - 1) && (!((inventoryList.get(slotNum)) instanceof EmptySlot)))){
			slotNum++;
			if((inventoryList.get(slotNum)) instanceof EmptySlot){
				inventoryList.set(slotNum, item);
				slotNum = 100;
			}
		}
	}
	
	// Removes an item from a slot in the inventory. 
	private void removeItem(int slot){
		inventoryList.set(slot, empty);
	}
	
	// Returns whether or not the inventory is full. Recommended usage: check before using method "addItem"
	public boolean isFull(){
		for(int i = 0; i <= (inventorySize - 1); i++){
			if((inventoryList.get(i)) instanceof EmptySlot) return false;
		}
		return true;
	}
	
	// Returns whether or not a slot in the inventory is full. Recommended usage: check before using method "itemAction"
	public boolean slotIsFull(int slot){
		if ((inventoryList.get(slot)) instanceof EmptySlot) return false;
		return true;
	}
	
	// Executes a user command on an item in a designated slot
	public void itemAction(int slot, String action, Inventory inven, Player player, ForestRoom room){
		if(action.equals("use")) (inventoryList.get(slot)).use(inven, player, room);
		if(action.equals("inspect")) (inventoryList.get(slot)).inspect();
		if(action.equals("drop")) removeItem(slot);
	}
}
