//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-3-12
//Project 6-3

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Variable Declarations

		double grade;

		// Description

		System.out.println("This program will assign a letter grade to a percentage grade.");
		System.out.println("You may keep entering percentage grades as you wish, the program"
				+ " will stop when you enter -1.");

		// Loop Initialization

		System.out.print("Please enter the percentage grade or -1 to stop: ");
		grade = reader.nextDouble();

		// User Input Loop

		while (grade != -1) {
			if (grade < 0 || grade > 100)
				System.out.println("Your input is not a valid "
						+ "entry, percentages range from 0 to 100.");
			else if (grade >= 85.5)
				System.out.println("For a percentage of " + grade
						+ ", the letter grade is an A");
			else if (grade >= 79.5)
				System.out.println("For a percentage of " + grade
						+ ", the letter grade is a B");
			else if (grade >= 69.5)
				System.out.println("For a percentage of " + grade
						+ ", the letter grade is a C");
			else if (grade >= 59.5)
				System.out.println("For a percentage of " + grade
						+ ", the letter grade is a D");
			else
				System.out.println("For a percentage of " + grade
						+ ", the letter grade is a F");
			System.out.print("Please enter the percentage grade or -1 to stop: ");
			grade = reader.nextDouble();
		}
	}

}
