//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-4-12
//Project 6-4

import java.util.Scanner;

public class Grade2 {

	public static void getLetterGrade(double grade) {

		if (grade >= 85.5)
			System.out.println("A");
		else if (grade >= 79.5)
			System.out.println("B");
		else if (grade >= 69.5)
			System.out.println("C");
		else if (grade >= 59.5)
			System.out.println("D");
		else
			System.out.println("F");
	}

	public static void main(String[] args) {

		// Object Declarations

		Scanner reader = new Scanner(System.in);

		// Variable Declarations

		double grade;
		double max = -1;
		double min = 101;
		double average;
		double sum = 0;
		double gradeTally = 0;

		// Description

		System.out.println("This program will allow you to specify a set of percentage "
				+ "grades and show you the minimum, maximum, and average letter " +
				"grades of the entire set.");
		System.out.println("The program will continue until you enter -1.");

		// Loop Initialization and Check

		System.out.print("Enter a percentage grade: ");
		grade = reader.nextDouble();
		while (grade == -1) {
			if (grade < 0 || grade > 100)
				System.out.println("Your input is not a valid "
						+ "entry, percentages range from 0 to 100.");
			else {
				System.out.print("You must enter at least one grade: ");
				grade = reader.nextDouble();
			}
		}

		// User Input Loop

		while (grade != -1) {
			if (grade < 0 || grade > 100)
				System.out.println("Your input is not a valid "
						+ "entry, percentages range from 0 to 100.");
			else {
				sum += grade;
				gradeTally++;
				if (grade > max)
					max = grade;
				if (grade < min)
					min = grade;
			}
			System.out.print("Enter a percentage grade or -1 to stop: ");
			grade = reader.nextDouble();
		}

		// Calculations

		average = (sum / gradeTally);

		// Output

		System.out.print("The maximum letter grade for the class was: ");
		getLetterGrade(max);
		System.out.print("The mimimum letter grade for the class was: ");
		getLetterGrade(min);
		System.out.print("The average letter grade for the class was: ");
		getLetterGrade(average);
	}

}
