
public class Attribute {
	
	private String name;
	private int originalValue;
	private int currentValue;

	public Attribute(String aName, int aValue){
		name = aName;
		originalValue = aValue;
		currentValue = aValue;
	}
	
	public Attribute(String aName){
		name = aName;
		originalValue = 0;
		currentValue = 0;
	}

	public int getOriginalValue() {
		return originalValue;
	}
	
	public void modifyOriginalValue(int modValue){
		originalValue += modValue;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void modifyCurrentValue(int modValue){
		currentValue += modValue;
	}
	
	public void resetCurrentValue(){
		currentValue = originalValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}
	
	public boolean equals(Object att){
		if(name.equals(((Attribute)att).getName())) return true;
		else return false;
	}
}
