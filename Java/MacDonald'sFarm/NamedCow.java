//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-17-12
//Lab 1

public class NamedCow extends Cow {
	
	private String myName;
	
	public NamedCow(String sound, String type, String name) {
		super(sound, type);
		myName = name;
	}
	
	public String getName() {
		return myName;
	}

}
