//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//12-20-12
//Lab 2

public class RandomE {
	
	private double value;
	
	public RandomE(int runTimes){
		value = makeValue(runTimes);
	}
	
	public double getValue(){
		return value;
	}
	
	private double makeValue(int runTimes){
		int sum = 0;
		for(int i = 1; i <= runTimes; i++){
			sum += (randomization());
		}
		return (((double)sum) / ((double)runTimes));
	}
	
	private int randomization(){
		double aValue;
		double sum = 0.0;
		int counter = 0;
		while(sum < 1.0){
			aValue = Math.random();
			while(aValue == 0.0) aValue = Math.random();
			sum += aValue;
			counter++;
		}
		return counter;
	}
}
