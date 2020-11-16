// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-18-12

public class Key implements Item {

private String name;
	
	public Key(){
		name = "Key";
	}
	
	public String getName(){
		return name;
	}
	
	public void use(Inventory inven, Player player, ForestRoom room) {
	}
	
	public void inspect() {
		System.out.println("Opens things");
	}
}
