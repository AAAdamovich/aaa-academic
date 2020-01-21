// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-19-2013
// Sorting Lab v2

public class Statistics{

	private long swaps;
	private long compares;
	private long averageTime;
	private StopWatch timer;

	public Statistics(){
		swaps = 0;
		compares = 0;
		averageTime = 0;
		timer = new StopWatch();
	}

	public void addSwaps(){
		swaps++;
	}

	public long getSwaps(){
		return swaps;
	}

	public void addCompares(){
		compares++;
	}

	public long getCompares(){
		return compares;
	}
	
	public long getAverageTime(){
		return averageTime;
	}

	public void updateTimer(){
		if(averageTime != 0) averageTime = ((averageTime + (timer.getElapsedTime())) / 2);
		else averageTime = timer.getElapsedTime();
		timer.reset();
	}
	
	public StopWatch getTimer(){
		return timer;
	}
}
