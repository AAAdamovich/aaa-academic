//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//9-26-12
//Project 6-1

import java.util.Scanner;
import java.util.Random;

public class Guess {

	public static void main(String[] args) {

		// Object declarations

		Scanner reader = new Scanner(System.in);
		Random generator = new Random();

		// Variable declarations

		int tries = 1;
		int randomNumber = 0;
		int currentTry = 0;

		// Random Number Generation

		randomNumber = (generator.nextInt(100) + 1);

		// Description

		System.out.println("This program will play a guessing game with you, you must guess"
				+ " a number the computer has selected between 1 and 100.");
		System.out.println("You may only guess whole numbers, no decimals.");

		// Loop Initialization

		System.out.print("Enter a whole number between 1 and 100: ");
		currentTry = reader.nextInt();

		// Win Condition Loop

		while (randomNumber != currentTry) {
			if (currentTry > 100 || currentTry < 1)
				System.out.println("Your entry is outside the random number's range, try "
						+ "again.");
			else {
				System.out.println("Nice try, but your guess is wrong");
				tries++;
				if (currentTry < randomNumber)
					System.out.println("Your guess is too low.");
				else
					System.out.println("Your guess is too high.");
			}
			System.out.print("Enter a whole number between 1 and 100: ");
			currentTry = reader.nextInt();
		}

		// Win Description

		System.out.println("Congratulations! You have guessed correctly, "
				+ "the number was " + randomNumber + ".");
		System.out.println("It took you " + tries
				+ " tries to guess the number.");

	}

}
