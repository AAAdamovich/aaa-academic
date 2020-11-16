// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-13-12

public class HealthPotion implements Item{

	private String name;
	
	public HealthPotion(){
		name = "Health Potion";
	}
	
	public String getName(){
		return name;
	}
	
	public void use(Inventory inven, Player player, ForestRoom room) {
	}
	
	public void inspect() {
		System.out.println("A flipping bottle");
	}
}
