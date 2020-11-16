// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 12-13-12

public interface Item {
	public String getName();
	public void inspect();
	public void use(Inventory inven, Player player, ForestRoom room);
}
