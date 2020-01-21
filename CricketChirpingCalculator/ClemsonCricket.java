//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//11-13-12
//Lab 2

public class ClemsonCricket extends Cricket{
	
	private int chirps;
	
	public ClemsonCricket(int aTemperature){
		super(aTemperature);
		chirps = makeChirps();
	}
	
	private int makeChirps(){
		int someChirps;
		someChirps = super.getChirps();
		someChirps = ((int)Math.round(0.8 * someChirps));
		return someChirps;
	}
	
	public int getChirps() {
		return chirps;
	}
}
