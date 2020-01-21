//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-22-12
//Project 4-8

import java.util.Scanner;

public class Base {

	public static void main(String[] args) {

		// Object declarations

		Scanner reader = new Scanner(System.in);

		// Variable Declarations

		int base;
		int power = 0;
		double result;

		// Description

		System.out.println("This program will display the evaluation of a number in base " +
				"notation.");

		// Loop Initialization

		System.out.print("Please enter the base you would like to work with: ");
		base = reader.nextInt();
		System.out.println("Current base = " + base);
		System.out.println("To stop the program, enter -1");
		System.out.print("Please enter the exponent you would like to raise the base " +
				"to: ");
		power = reader.nextInt();
		result = (Math.pow(base, power));

		// User Input Loop

		while (power != -1) {
			System.out.println(base + " raised to the power of " + power + " is equal to: "
					+ result);
			System.out.println("Current base = " + base);
			System.out.println("To stop the program, enter -1");
			System.out.print("Please enter the exponent you would like to raise the base " +
					"to: ");
			power = reader.nextInt();
			result = (Math.pow(base, power));
		}
	}

}
