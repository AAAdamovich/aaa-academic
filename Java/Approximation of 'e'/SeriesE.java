//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//12-20-12
//Lab 2

public class SeriesE {

	private double value;

	public SeriesE(int runTimes) {
		value = makeValue(runTimes);
	}
	
	private double makeValue(int runTimes){
		double sum = 0;
		for(int i = 0; i < runTimes; i++){
			sum += (1.0 / (((double)factorial(i))));
		}
		return sum;
	}
	
	private int factorial(int num){
		int sum = 1;
		if (num > 1) sum = (num * (factorial((num - 1))));
		return sum;
	}
	
	public double getValue() {
		return value;
	}
	
}
