//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-22-12
//Project 4-9

import java.util.Scanner;
import java.io.*;

public class Base2 {

	public static void main(String[] args) throws IOException {

		// Object declarations

		Scanner reader = new Scanner(new File("numbers.txt"));

		// Variable Declarations

		int base;
		int power;
		double result;
		int lineNumber = 1;

		// Description
		
		System.out.println("This program will display the evaluation of a number in base " +
				"notation.");
		System.out.println("Bases and exponents will be read from a text file in said " +
				"order, with a pair on each line.");

		// File Reader Loop

		while (reader.hasNext()) {
			base = reader.nextInt();
			power = reader.nextInt();
			result = (Math.pow(base, power));
			System.out.println("Line " + lineNumber + ": With a base of "
					+ base + " and an exponent of " + power
					+ " , the result is: " + (int) result);
			lineNumber++;
			
		}
	}

}
