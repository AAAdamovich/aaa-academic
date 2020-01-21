//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-28-12
//Project 4-5

import java.util.Scanner;

public class Calculator3 {

	public static void main(String[] args) {

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Variable declarations

		int iterations;
		int printIterations;
		int operator = 1;
		double divisor = 3.0;
		double tempTotal = 0;
		double allTotal;

		// Description

		System.out.println("This program will approximate the value of pi based on a"
				+ " method developed by German mathematician Gottfried Leibniz.");

		// User Input

		System.out.println("NOTE: The larger the number of iterations, the more accurate "
				+ "this approximation will be to the actual value of pi.");
		System.out.print("Enter the number of iterations for the calculation: ");
		iterations = reader.nextInt();

		// User Input Check

		while (iterations <= 0) {
			System.out.print("ERROR: Your input is not a valid number, try something "
					+ "greater than zero: ");
			iterations = reader.nextInt();
		}

		// Output Storage

		printIterations = iterations;

		// Calculations

		while (iterations != 0) {
			if (operator == 1)
				tempTotal -= (1.0 / divisor);
			else
				tempTotal += (1.0 / divisor);
			operator = -operator;
			divisor += 2;
			iterations--;
		}
		allTotal = (tempTotal + 1.0) * 4.0;

		// Output

		if (printIterations != 1)
			System.out.println("For " + printIterations
					+ " iterations, the approximate"
					+ " value of pi according to this method is " + allTotal);
		else
			System.out.println("For " + printIterations
					+ " iteration, the approximate"
					+ " value of pi according to this method is " + allTotal);

	}

}
