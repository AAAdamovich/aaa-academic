//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-17-12
//Lab 1

public class Chick implements Animal {

	private String mySound;
	private String mySound2;
	private String myType;

	public Chick(String sound, String sound2, String type) {
		mySound = sound;
		mySound2 = sound2;
		myType = type;
	}

	public String getType() {
		return myType;
	}

	// John Dott told me where to put this :)
	public String getSound() {
		if (Math.random() < .5)
			return mySound;
		else
			return mySound2;
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
