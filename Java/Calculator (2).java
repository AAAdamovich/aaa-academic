//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//8-30-12
//Project 2-5

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		// Variable Declarations

		double mass;
		double velocity;
		double momentum;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Descriptions

		System.out.println("This probram will calculate the momentum of an object based " +
				"on its velocity and mass.");
		System.out.print("First enter mass in kilograms: ");

		// User Input

		mass = reader.nextDouble();
		System.out.print("Now enter velocity in meters per second: ");
		velocity = reader.nextDouble();

		// Calculations

		momentum = velocity * mass;

		// Output

		System.out.print("The momentum is ");
		System.out.print(momentum);
		System.out.println(" kilograms per meter-second");

	}

}
