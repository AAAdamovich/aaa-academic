//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-17-12
//Lab 1

public class Pig implements Animal {

	private String mySound;
	private String myType;

	public Pig(String sound, String type) {
		mySound = sound;
		myType = type;
	}

	public String getSound() {
		return mySound;
	}

	public String getType() {
		return myType;
	}
	
	public int compareTo(Animal otherA) {
		if((mySound.length()) > (otherA.getSound().length())) return 1;
		if((mySound.length()) < (otherA.getSound().length())) return -1;
		else return 0;
	}
	
	public String toString(){
		String statement;
		statement = ("I am a " + myType + " and I go " + mySound);
		return statement;
	}
}

