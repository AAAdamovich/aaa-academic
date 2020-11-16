/**
 * @author Anton Adamovich
 * AP Computer Science A
 * Mr. Meistering
 * 3-6-13
 * Case Study Exploration 1
 */

import info.gridworld.actor.Bug;
import java.awt.Color;
import java.util.Random;

public class NeonBug extends Bug{
	
    public NeonBug(){
        setColor(Color.WHITE);
    }

    public void act(){
        if (canMove()){
        	Random generator = new Random();
        	int colorNum = generator.nextInt(7);
        	switch(colorNum){
        	case 0: setColor(Color.BLACK);
        	break;
        	case 1: setColor(Color.BLUE);
        	break;
        	case 2: setColor(Color.CYAN);
        	break;
        	case 3: setColor(Color.GREEN);
        	break;
        	case 4: setColor(Color.MAGENTA);
        	break;
        	case 5: setColor(Color.ORANGE);
        	break;
        	case 6: setColor(Color.RED);
        	break;
        	default: setColor(Color.WHITE);
        	}
        	move();
        	if((Math.random() < 0.5)) turn();
        }
        else{
            turn();
        }
    }
}
