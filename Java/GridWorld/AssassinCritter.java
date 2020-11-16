/**
  * @author Anton Adamovich
 * AP Computer Science A
 * Mr. Meistering
 * 3-6-13
 * Case Study Exploration 2
 */

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class AssassinCritter extends Critter{

	private int lungeDistance;

	public AssassinCritter(int aLungeDist){
		lungeDistance = aLungeDist;
		setColor(Color.BLACK);
	}

	public ArrayList<Actor> getActors(){
		ArrayList<Actor> emptySet = new ArrayList<Actor>();
		return emptySet;
	}
	
	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> lungeLocs = new ArrayList<Location>();
		Location currentL = getLocation();
		int row = currentL.getRow();
		int col = currentL.getCol();
		Grid world = getGrid();
		// Code: 0 is north, 1 is north-east, 4 is south, and so forth for both lists
		Location[] possibleLocs = new Location[8];
		boolean[] blockedLOS = {false, false, false, false, false, false, false, false};
		for(int i = 1; i <= lungeDistance; i++){
			possibleLocs[0] = new Location((row - i), col);
			possibleLocs[1] = new Location((row - i), (col + i));
			possibleLocs[2] = new Location(row, (col + i));
			possibleLocs[3] = new Location((row + i), (col + i));
			possibleLocs[4] = new Location((row + i), col);
			possibleLocs[5] = new Location((row + i), (col - i));
			possibleLocs[6] = new Location(row, (col - i));
			possibleLocs[7] = new Location((row - i), (col - i));
			for(int u = 0; u <= 7; u++){
				if(!(blockedLOS[u])){
					if(world.isValid(possibleLocs[u])){
						if(((world.get(possibleLocs[u])) instanceof Bug) || ((world.get(possibleLocs[u])) instanceof Critter)){
							lungeLocs.add(possibleLocs[u]);
						}
						if((world.get(possibleLocs[u])) instanceof Rock){
							blockedLOS[u] = true;
						}
					}
				}
			}
		}
		return lungeLocs;
	}
	
	public void makeMove(Location loc){
		Location currentL = getLocation();
		if(loc != currentL) setDirection(currentL.getDirectionToward(loc));
		super.makeMove(loc);
    }
}
