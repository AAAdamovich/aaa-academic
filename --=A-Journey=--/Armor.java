// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 4-19-13

public class Armor extends Equipment{
	
	public String name;
	public Buff[] effects;
	
	public Armor(String aName, Buff[] someEffects){
		name = aName;
		effects = someEffects;
	}
	
	public Player applyEffect(Player player){
		for(int i = effects.length; i < effects.length; i++){
			effects[i].applyEffect(player);
		}
		return player;
	}
	
}
