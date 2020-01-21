/* Antony Adamovich
*  DigitalClock.java for Homework #2
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 14-OCT-2018 - Last Edited: 14-OCT-2018
*  Description: Program creates a string digital clock representation from 
*   the current system time, retrieved when the program runs. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   See attached README file
*/

package digitalclock;

import java.util.Date;

public class Antony_Adamovich_HW2_1 {

    public static void main(String[] args) {
        // Specifies the size of the S number arrays
        final int FACE_LENGTH = 7;
        // Colon strings are of length 5, S number array strings are length 4
        // S number arrays describe a vertical string representation of a number, 
        // Colon is a string representation of the (:) character
        final String[] COLON = { "     ", "  -  ", " | | ", "  -  ", "  -  ", " | | ", "  -  "};
        final String[] S_ZERO = { " -- ", "|  |", "|  |", "    ", "|  |", "|  |", " -- "};
        final String[] S_ONE = {  "    ", "   |", "   |", "    ", "   |", "   |", "    "};
        final String[] S_TWO = {  " -- ", "   |", "   |", " -- ", "|   ", "|   ", " -- "};
        final String[] S_THREE = {" -- ", "   |", "   |", " -- ", "   |", "   |", " -- "};
        final String[] S_FOUR = { "    ", "|  |", "|  |", " -- ", "   |", "   |", "    "};
        final String[] S_FIVE = { " -- ", "|   ", "|   ", " -- ", "   |", "   |", " -- "};
        final String[] S_SIX = {  " -- ", "|   ", "|   ", " -- ", "|  |", "|  |", " -- "};
        final String[] S_SEVEN = {" -- ", "   |", "   |", "    ", "   |", "   |", "    "};
        final String[] S_EIGHT = {" -- ", "|  |", "|  |", " -- ", "|  |", "|  |", " -- "};
        final String[] S_NINE = { " -- ", "|  |", "|  |", " -- ", "   |", "   |", " -- "};
        // Numbers 2D array for ability to iterate "vertically" with a loop
        final String[][] NUMBERS = {S_ZERO, S_ONE, S_TWO, S_THREE, S_FOUR, S_FIVE, S_SIX, S_SEVEN, S_EIGHT, S_NINE};
        // currentTime represents the current date and time
        Date currentTime = new Date();
        // Use of deprecated methods to stay within assignment bounds.
        // Individual digits are extracted from 2-digit numbers to inform
        // printing of the digital clock representation
        int hourLeft = (currentTime.getHours() / 10);
        int hourRight = (currentTime.getHours() % 10);
        int minLeft = (currentTime.getMinutes() / 10);
        int minRight = (currentTime.getMinutes() % 10);
        String str = String.format("%tc", currentTime);
        
        System.out.println("Current Date and time: ");
        System.out.println(str);
        // 5 sections of the digital clock face are used, each section takes a 
        // piece of the string array to build the image of a number
        for(int i = 0; i < FACE_LENGTH; i++){
            System.out.print(NUMBERS[hourLeft][i]);
            System.out.print(NUMBERS[hourRight][i]);
            System.out.print(COLON[i]);
            System.out.print(NUMBERS[minLeft][i]);
            System.out.println(NUMBERS[minRight][i]);
            // Last line appends a carriage return
        }
    }
}
