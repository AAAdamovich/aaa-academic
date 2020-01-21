// Anton Adamovich
// Project Started: 12-13-12
// This Class Created: 3-9-13

public class Location{
	
	// THE CLASS VARIABLES
	
	private int x;
	private int y;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	// THE CONSTRUCTOR
	
	public Location(int xCordinate, int yCordinate){
		x = xCordinate;
		y = yCordinate;
	}
	
	// THE METHODS
	
	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void modifyLocation(int dX, int dY){
		x += dX;
		y += dY;
	}
	
	public void modifyLocation(int dSpec){
		if(dSpec >= 4) dSpec -= 4;
		switch(dSpec){
		case 0: y += 1;
		break;
		case 1: x += 1;
		break;
		case 2: y -= 1;
		break;
		case 3: x -= 1;
		default:;
		}
	}
	
	public boolean equals(Location otherL){
		if((x == (otherL.getX())) && (y == (otherL.getY()))) return true;
		else return false;
	}
}
