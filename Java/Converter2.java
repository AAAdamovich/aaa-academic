//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//8-30-12
//Project 2-3

import java.util.Scanner;

public class Converter2 {

	public static void main(String[] args) {

		// Variable Declarations

		double kilometers;
		double nauticalMiles;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Descriptions

		System.out.println("This program will convert Kilometers to Nautical Miles.");
		System.out.print("Please enter number of Kilometers: ");

		// User Input

		kilometers = reader.nextDouble();

		// Calculations

		nauticalMiles = (kilometers / 10000 * 5400);

		// Output

		System.out.print("The equivalent in Nautical miles is: ");
		System.out.println(nauticalMiles);

	}

}