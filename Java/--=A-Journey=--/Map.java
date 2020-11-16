// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-18-12

public class Map implements Item {

private String name;
	
	public Map(){
		name = "Map";
	}
	
	public String getName(){
		return name;
	}
	
	public void use(Inventory inven, Player player, ForestRoom room) {
	}
	
	public void inspect() {
		System.out.println("A piece of paper");
	}
}