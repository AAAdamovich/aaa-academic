//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//11-13-12
//Lab 2

public class CricketDriver {
	public static void main(String[] args){
		int temperature;
		int chirps1;
		int chirps2;
		Environment enviro = new Environment();
		temperature = (enviro.getTemperature());
		Cricket c1 = new Cricket(temperature);
		chirps1 = c1.getChirps();
		Cricket c2 = new ClemsonCricket(temperature);
		chirps2 = c2.getChirps();
		System.out.println("The regular cricket chirped " + chirps1 + " times and the " +
				"Clemson cricket chirped " + chirps2 + " times at a temperature of " 
				+ temperature);
	}
}
	
