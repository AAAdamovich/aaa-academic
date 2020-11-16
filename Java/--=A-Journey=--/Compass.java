// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-18-12

public class Compass implements Item {

private String name;
	
	public Compass(){
		name = "Compass";
	}
	
	public String getName(){
		return name;
	}
	
	public void use(Inventory inven, Player player, ForestRoom room) {
	}
	
	public void inspect() {
		System.out.println("Metal thingy");
	}
}