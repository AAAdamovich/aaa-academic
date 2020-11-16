/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

//This class was modified to run anything so it is not exclusive to Box bugs anymore
public class MultiDriver{
    public static void main(String[] args){
    	
    	// Object Declarations
    	
        ActorWorld world = new ActorWorld();
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        BoxBug bob = new BoxBug(3);
        NeonBug noob = new NeonBug();
        Rock stone1 = new Rock();
        Rock stone2 = new Rock();
        Bug buggy = new Bug();
        ChameleonCritter shady = new ChameleonCritter();
        AssassinCritter zero = new AssassinCritter(4);
        Location addedLoc;

        // Running the World
        
        addedLoc = new Location(5, 2);
        world.add(addedLoc, noob);
        addedLoc = new Location(7, 8);
        world.add(addedLoc, alice);
        addedLoc = new Location(5, 5);
        world.add(addedLoc, bob);
        addedLoc = new Location(4, 3);
        world.add(addedLoc, shady);
        addedLoc = new Location(3, 5);
        world.add(addedLoc, buggy);
        addedLoc = new Location(0, 0);
        world.add(addedLoc, zero);
        addedLoc = new Location(0, 1);
        world.add(addedLoc, stone1);
        world.add(stone2);
        world.show();
    }
    
}