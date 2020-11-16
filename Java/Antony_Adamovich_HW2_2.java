/* Antony Adamovich
*  MonthPrinter.java for Homework #2
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 14-OCT-2018 - Last Edited: 14-OCT-2018
*  Description: Program takes an integer year and integer month as input and
*   produces a string graphical representation of a calendar specified
    by the month and year from input. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   See attached README file
*/

package monthprinter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Antony_Adamovich_HW2_2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int month = 0;
        int year = 0;
        // Sentinel variable used for adding whitespace to calendar
        int nextDayOfWeek = 1;
        
        // User input
        System.out.print("Enter an integer for the month (1-12): ");
        month = reader.nextInt();
        System.out.print("Enter a year: ");
        year = reader.nextInt();
        // Month must be adjusted to plug into Calendar.MONTH field values
        month--;
        // Calendar constants are 0-indexed, meaning January is 0, December is 11
        Calendar calendar = new GregorianCalendar(year, month, 1, 0, 1);
        // Set Sunday as first day of week, as opposed to Monday for certain countries such as France
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        // Extra spacing
        System.out.println();
        // Prints the full name of the month represented by integer input (3 = March)
        System.out.print(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
        // Also print year from input
        System.out.println(" " + year);
        // Calendar header
        System.out.println(" S  M Tu  W Th  F  S\n");
        // Print whitespace before first day of first week
        while(nextDayOfWeek < calendar.get(Calendar.DAY_OF_WEEK)){
            System.out.print("   ");
            nextDayOfWeek++;
        }
        // Once first day of week is reached, number printing begins
        do{
            if(calendar.get(Calendar.DATE) < 10){
                // Add whitespace for single-digit numbers
                System.out.print(" ");
            }
            // Print date
            System.out.print(calendar.get(Calendar.DATE) + " "); 
            // Once saturday is reached, (end of week) a carriage return is added
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
               System.out.println();
            }
            // Iterate calendar to the next day in the month
            calendar.add(Calendar.DATE, 1);
            // 1 is printed without condition. Next time this loop reaches 1,
            // the calendar would have flipped over to the next month, signifying
            // the termination of number printing
        }while(calendar.get(Calendar.DATE) != 1);
        // Adjust output for future printing
        System.out.println();
    }
}