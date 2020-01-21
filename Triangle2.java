//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-15-12
//Loop Idea 7

import java.util.Scanner;

public class Triangle2 {

	public static void main(String[] args) {

		// Variable Declarations

		int spaceNum = 0;
		int readNum;

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Description

		System.out.println("This program will display an upside-down Equilateral "
				+ "Triangle with a side length that you specify.");
		System.out.println("Your input must be greater than zero, keep in mind "
				+ "decimals will not be accepted.");

		// User Input

		System.out.print("Please enter the side length: ");
		readNum = reader.nextInt();

		// Extra Line for nice spacing

		System.out.println();

		// Star Loops

		for (int sideNum = readNum; sideNum >= 1; sideNum -= 2) {
			for (int spaceNumCount = spaceNum; spaceNumCount >= 1; spaceNumCount--)
				System.out.print(" ");
			for (int sideNumCount = sideNum; sideNumCount >= 1; sideNumCount--)
				System.out.print("*");
			System.out.println();
			spaceNum++;

		}
	}

}
