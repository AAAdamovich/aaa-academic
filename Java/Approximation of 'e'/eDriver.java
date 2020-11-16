//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//12-20-12
//Lab 2

public class eDriver {

	public static void main(String[] args) {
		RandomE computationA = new RandomE(500);
		SeriesE computationB = new SeriesE(10);

		System.out.println("The first algorithim, running 500 times, generated a value of "
				+ (computationA.getValue())
				+ ".\nThe second algorithm, running 10 times, "
				+ "generated a value of " + (computationB.getValue()));
	}
}
