//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-1-12
//Project 3-1

import java.util.Scanner;

public class Cube {

	public static void main(String[] args) {

		// Variable Declarations

		// Although the project parameters specify to use an integer, I thought
		// decimal values are a possibility in geometry

		double cubeEdge;
		double cubeArea;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Description

		System.out.println("This program will calculate the surface area of a cube based " +
				"on its edge.");
		System.out.print("Please enter the value of the edge of the cube: ");

		// User Input

		cubeEdge = reader.nextDouble();

		// Calculations

		cubeArea = (cubeEdge * cubeEdge) * 6;

		// Output

		System.out.print("The surface area of the cube is: ");
		System.out.println(cubeArea);

	}

}
