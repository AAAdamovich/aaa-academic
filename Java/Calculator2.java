//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-6-12
//Project 3-2

import java.util.Scanner;

public class Calculator2 {

	public static void main(String[] args) {

		// Variable Declarations

		double radius;
		double diameter;
		double circumference;
		double surfaceArea;
		double volume;
		final double PI = 3.142;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Description

		System.out.println("This program will calculate a sphere's diameter, "
				+ "circumference, surface area, and volume based on a radius " 
				+ "measurement.");
		System.out.print("Please enter the radius of the sphere: ");

		// User Input

		radius = reader.nextDouble();

		// Calculations

		diameter = (radius * 2);
		circumference = (2 * PI * radius);
		surfaceArea = (4 * PI * (Math.pow(radius, 2)));
		volume = (PI * (Math.pow(radius, 2)));

		// Output

		System.out.println("Based on your entry, these are the results:");
		System.out.println("Diameter = " + diameter);
		System.out.println("Circumference = " + circumference);
		System.out.println("Surface Area = " + surfaceArea);
		System.out.println("Volume = " + volume);

	}

}
