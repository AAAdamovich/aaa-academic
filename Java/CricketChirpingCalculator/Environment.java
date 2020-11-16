//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//11-13-12
//Lab 2

import java.util.Random;

public class Environment {

	private int temperature;
	
	public Environment(){
		temperature = makeTemperature();
	}

	private int makeTemperature() {
		int temp;
		Random generator = new Random();
		temp = (generator.nextInt(101) + 10);
		return temp;
	}
	
	public int getTemperature(){
		return temperature;
	}
}
