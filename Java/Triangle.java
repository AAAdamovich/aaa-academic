//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-22-12
//Project 4-2

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {

		// Variable Declarations

		double side1;
		double side2;
		double side3;
		double hypotenuse;
		double shortSide1;
		double shortSide2;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Description

		System.out.println("This program will calculate whether or not a triangle is a "
				+ "right triangle based on its three sides.");

		// User Input

		System.out.print("Please enter the three sides consecutively: ");
		side1 = reader.nextDouble();
		side2 = reader.nextDouble();
		side3 = reader.nextDouble();

		// Calculations

		hypotenuse = Math.max(Math.max(side1, side2), Math.max(side2, side3));

		// Side Checking

		if (side1 == hypotenuse) {
			shortSide1 = side2;
			shortSide2 = side3;
		} else if (side2 == hypotenuse) {
			shortSide1 = side1;
			shortSide2 = side3;
		} else {
			shortSide1 = side1;
			shortSide2 = side2;
		}
		// Output

		if ((Math.pow(shortSide1, 2) + Math.pow(shortSide2, 2)) == Math.pow(
				hypotenuse, 2))
			System.out.println("Based on your entry, these sides will form a Right triangle.");
		else
			System.out.println("Based on your entry, these sides will not form a Right "
					+ "triangle.");

	}

}
