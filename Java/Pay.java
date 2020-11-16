//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-2-12
//Project 3-5

import java.util.Scanner;

public class Pay {

	public static void main(String[] args) {

		// Variable Declarations

		double wage;
		int hours1;
		int hours2;
		int hours3;
		int hours4;
		int hours5;
		int overHours1;
		int overHours2;
		int overHours3;
		int overHours4;
		int overHours5;
		double weekPay;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Descriptions
		
		System.out.println("This program will calculate your weekly pay based on regular " +
				"and overtime hours on each of the five working days.");
		System.out.println("NOTE: Please estimate all working hours to the nearest whole " +
				"number.");
		
		// User Input A
		
		System.out.print("First enter your hourly wage: ");
		wage = reader.nextDouble();
		
		// User Input B
		
		System.out.println("Next enter your regular working hours on Monday, Tuesday, " +
		"Wednesday, Thursday, and Friday, respectively.");
		hours1 = reader.nextInt();
		hours2 = reader.nextInt();
		hours3 = reader.nextInt();
		hours4 = reader.nextInt();
		hours5 = reader.nextInt();
		
		// User Input C
		
		System.out.println("Now enter your overtime hours on each working day in a similar" +
				" fashion to how regular hours were entered: ");
		overHours1 = reader.nextInt();
		overHours2 = reader.nextInt();
		overHours3 = reader.nextInt();
		overHours4 = reader.nextInt();
		overHours5 = reader.nextInt();
		
		//Calculations
		
		weekPay = (wage * (hours1 + hours2 + hours3 + hours4 + hours5))
				+ ((1.5 * wage) * (overHours1 + overHours2 + overHours3
						+ overHours4 + overHours5));
		
		//Output
		
		System.out.print("Your total weekly pay is: $");
		System.out.println(weekPay);

	}

}
