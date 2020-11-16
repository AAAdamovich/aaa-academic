//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//11-13-12
//Lab 2

public class Cricket {

	private int chirps;
	
	public Cricket(int temp){
		makeChirps(temp);
	}
	
	private void makeChirps(int temp){
		chirps = ((4 * temp) - 40);
	}
	
	public int getChirps() {
		return chirps;
	}
	
}
