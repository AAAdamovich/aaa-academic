// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 4-2-13

public class Buff {

	// THE PRIVATE VARIABLES
	
	private String name;
	private Attribute modifiedAttribute;
	private int magnitude;
	// If type is true, the buff type is %, otherwise its numerical
	private boolean type;
	
	// THE CONSTRUCTOR
	
	public Buff(String aName, Attribute anAttribute, int aMagnitude, boolean aType){
		name = aName;
		modifiedAttribute = anAttribute;
		magnitude = aMagnitude;
		type = aType;
	}
	
	// THE METHODS
	
	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public Player applyEffect(Player player){
		int finalStat;
		int baseStat;
		// Health
		if(modifiedAttribute.equals(player.getHealth())){
			baseStat = player.getHealth().getCurrentValue();
			if(type) finalStat = ((int)(Math.round(((((double)baseStat) * (((double)magnitude) / 100.0)) + (double)baseStat))));
			else finalStat = (baseStat + magnitude);
			player.getHealth().modifyCurrentValue(finalStat);
		}
		// Agility
		if(modifiedAttribute.equals(player.getAgility())){
			baseStat = player.getAgility().getCurrentValue();
			if(type) finalStat = ((int)(Math.round(((((double)baseStat) * (((double)magnitude) / 100.0)) + (double)baseStat))));
			else finalStat = (baseStat + magnitude);
			player.getAgility().modifyCurrentValue(finalStat);
		}
		// Attack
		if(modifiedAttribute.equals(player.getAttack())){
			baseStat = player.getAttack().getCurrentValue();
			if(type) finalStat = ((int)(Math.round(((((double)baseStat) * (((double)magnitude) / 100.0)) + (double)baseStat))));
			else finalStat = (baseStat + magnitude);
			player.getAttack().modifyCurrentValue(finalStat);
		}
		// Survival
		if(modifiedAttribute.equals(player.getSurvival())){
			baseStat = player.getSurvival().getCurrentValue();
			if(type) finalStat = ((int)(Math.round(((((double)baseStat) * (((double)magnitude) / 100.0)) + (double)baseStat))));
			else finalStat = (baseStat + magnitude);
			player.getSurvival().modifyCurrentValue(finalStat);
		}
		return player;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public Attribute getModifiedAttribute() {
		return modifiedAttribute;
	}
	
	public String toString(){
		String tooltip;
		if(type) tooltip = (name + ": Increases your " + modifiedAttribute.getName() + " by " + magnitude + "%.");
		else tooltip = (name + ": Increases your " + modifiedAttribute.getName() + " by " + magnitude + ".");
		return tooltip;
	}
	
}
