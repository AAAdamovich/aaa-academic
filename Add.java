//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-10-12
//Loop Idea 2

import java.util.Scanner;

public class Add {

	public static void main(String[] args) {

		// Variable Declarations

		double adder;
		double subTotal = 0.0;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Description

		System.out.println("This program will act like an adding machine.");
		System.out.println("You may continue to add numbers and the program will "
				+ "continuously show your subtotal.");
		System.out.println("You may enter negative numbers to subtract and 0 to stop "
				+ "the program");

		// Loop Initialization

		System.out.println("Your current subtotal is: " + subTotal);
		System.out.print("Please enter a number or 0 to stop: ");
		adder = reader.nextDouble();

		// User Input Loop

		while (adder != 0) {
			subTotal += adder;
			System.out.println("Your current subtotal is: " + subTotal);
			System.out.print("Please enter a number or 0 to stop: ");
			adder = reader.nextDouble();
		}
		System.out.println("Your final total was: " + subTotal);
	}

}
