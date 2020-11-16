// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 1-7-13

public class Player {

	// THE PRIVATE VARIABLES
	
	private ForestRoom currentRoom;
	private Location currentL;
	private int facingDir;
	private Attribute health;
	private Attribute attack;
	private Attribute survival;
	private Attribute agility;
	
	// THE CONSTRUCTOR
	
	public Player(ForestRoom startingRoom){
		currentRoom = startingRoom;
		currentL = new Location(6, 0);
		facingDir = Location.NORTH;
		health = new Attribute("Health", 100);
		attack = new Attribute("Attack", 10);
		survival = new Attribute("Survival", 10);
		agility = new Attribute("Agility", 10);
	}
	
	/// THE METHODS
	
	public ForestRoom getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(ForestRoom aRoom) {
		currentRoom = aRoom;
	}

	public Location getLocation() {
		return currentL;
	}

	public void setLocation(int x, int y) {
		currentL.setLocation(x, y);
	}
	
	public void adjustLocation(int x, int y){
		currentL.modifyLocation(x, y);
	}
	
	public void adjustLocation(int dSpec){
		currentL.modifyLocation(dSpec);
	}

	public int getFacingDir() {
		return facingDir;
	}

	public void setFacingDir(int aFacingDir) {
		facingDir = aFacingDir;
	}
	
	public void adjustFacingDir(int angle){
		facingDir += angle;
		if(facingDir >= 4) facingDir -= 4;
	}

	public Attribute getHealth() {
		return health;
	}

	public Attribute getAttack() {
		return attack;
	}

	public Attribute getSurvival() {
		return survival;
	}

	public Attribute getAgility() {
		return agility;
	}
}
