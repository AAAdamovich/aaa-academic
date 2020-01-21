// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-15-12

import java.util.ArrayList;

public class ForestArea {
	
	// THE PRIVATE VARIABLES
	
	private ArrayList<ForestRoom> ForestRooms;
	
	// THE CONSTRUCTOR
	
	public ForestArea(){
		ForestRooms = new ArrayList<ForestRoom>();
		
		// Item Instantiations for Constructor
		
		HealthPotion hP = new HealthPotion();
		Key key = new Key();
		
		// Room Construction
		
		// Description and loot chance values have to be entered manually.
		// 0
		ForestRoom r60 = new ForestRoom(6, 0, -1, 0, true, false, false, false);
		ForestRooms.add(r60);
		// 1
		ForestRoom r61 = new ForestRoom(6, 1, -1, 0,  true, false, false, true);
		ForestRooms.add(r61);
		r61.setDescription("You enter a tiny clearing in which the trees are just as dense as the rest of this place. # the clearing extends, offering another path. # is nothinng but the thicket, there is no path in that direction. #, you can see a tiny hole that may offer way if it can be sqeezed through. # there are some smooth stones scattered about. It appears that these stones slowly come together, but where they go you cannot tell.");
		// 2
		ForestRoom r51 = new ForestRoom(5, 1, -1, 0, false, true, false, true);
		ForestRooms.add(r51);
		r51.setDescription("The path you have been following is becoming more defined. #, a large and ancient wall rises from the thicket, there is no way over it. #, the path diminishes back into the trees. # the trees are too thick to travel through. #, the path grows in definition and loses some of its mossyness");
		// 3
		ForestRoom r41 = new ForestRoom(4, 1, -1, 0, false, true, false, true);
		ForestRooms.add(r41);
		r41.setLootChance(80);
		r41.genLoot(hP);
		r41.setDescription("$NA");
		// 4
		ForestRoom r31 = new ForestRoom(3, 1, 3, 0, false, true, false, true);
		ForestRooms.add(r31);
		r31.setDescription("$NA");
		// 5
		ForestRoom r62 = new ForestRoom(6, 2, -1, 0, true, true, true, false);
		ForestRooms.add(r62);
		r62.setLootChance(100);
		r62.genLoot(hP);
		r62.setDescription("$NA");
		// 6
		ForestRoom r63 = new ForestRoom(3, 6, -1, 100, false, false, true, false);
		ForestRooms.add(r63);
		r63.setLootChance(100);
		r63.genLoot(key);
		r63.setDescription("$NA");
		// 7
		ForestRoom r72 = new ForestRoom(7, 2, -1, 0, false, false, true, true);
		ForestRooms.add(r72);
		r72.setLootChance(100);
		r72.genLoot(hP);
		r72.setDescription("$NA");
		// 8
		ForestRoom r21 = new ForestRoom(2, 1, 1, 100, true, true, true, true);
		ForestRooms.add(r21);
		r21.setDescription("$NA");
	}
	
	// THE METHODS
	
	public ArrayList<ForestRoom> importForestRooms() {
		return ForestRooms;
	}
		
}
