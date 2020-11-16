//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//10-7-12
//Project 6-2

import java.util.Scanner;
import java.util.Random;

public class Guess2 {

	public static void main(String[] args) {

		// Object Declarations

		Scanner readerS = new Scanner(System.in);
		Random generator = new Random();

		// Variable Declarations

		int max = 100;
		int min = 1;
		int currentTry;
		int tries = 1;
		String conditional = "no";

		// Description

		System.out.println("In this program, the computer will play a guessing game "
				+ "with you, select a number between 1 and 100, non-inclusive,"
				+ " and keep it in your mind.");
		System.out.println("The computer will try to guess your number, every time it"
				+ " does, you must respond by saying 'yes' if the computer "
				+ "guessed correctly.");
		System.out.println("If not, respond with 'less' if your number is less than "
				+ "the computer's guess and 'more' if your number is higher "
				+ "than the computer's guess.");
		System.out.println("Remember, no decimals!");

		// Extra line for nice spacing

		System.out.println();

		// Loop Initialization

		currentTry = (generator.nextInt(((max + 1) - min)) + min);
		System.out.println("The computer has guessed " + currentTry
				+ ". Is this correct? [yes], [more], [less]");
		conditional = readerS.nextLine();

		// User Input Loop

		while (!(conditional.equals("yes"))) {
			if (conditional.equals("less")) {
				max = currentTry;
				tries++;
				if (min != 1)
					currentTry = (generator.nextInt((max - 1) - min) + (min + 1));
				else
					currentTry = (generator.nextInt((max + 1) - (min + 1)) + min);
			} else {
				if (conditional.equals("more")) {
					min = currentTry;
					tries++;
					if (max != 100)
						currentTry = (generator.nextInt((max - 1) - min) + (min + 1));
					else
						currentTry = (generator.nextInt((max + 1) - (min + 1)) + (min + 1));
				} else
					System.out.println("Your entry is invalid, only entries of 'yes'"
							+ ", 'less', or 'more' will be accepted.");
			}
			System.out.println("The computer has guessed " + currentTry
					+ ". Is this correct? [yes], [more], [less]");
			conditional = readerS.nextLine();
		}

		// Win Description

		if (currentTry != 1)
			System.out.println("The computer has successfully guessed your number of "
					+ currentTry
					+ ". It took the computer "
					+ tries
					+ " tries to guess it correctly.");
		else
			System.out.println("The computer has successfully guessed your number of "
					+ currentTry
					+ ". It took the computer "
					+ tries
					+ " try to guess it correctly.");

	}

}
