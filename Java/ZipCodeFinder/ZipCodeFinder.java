/* @author Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 1-25-2017 - Last Edited: 1-23-2018
*       Edited 1-23-2018: Variable names modifed to fit "zipcodes.txt" test file
*  Assignment 1 - ZipCodeFinder.java
*  Description: Program creates a list of states from a pre-defined data
*	file and then promtpts the user to search for a specific postal zip
*       code by name. Information about said zip code, such as town name and
*       county, is then printed. 
*  Resources:
*	The Java Platform API Specification
*	http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package zipcodefinder;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ZipCodeFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // The pathname for the file that contains the state data
        final String DATA_FILE = "zipcodes.txt";

        // The list of states, being generated with data from the file
        ZipCodeList states = new ZipCodeList(DATA_FILE);
        // Scanner used to get input frm the user
        Scanner reader = new Scanner(System.in);

        // Temporary variables, used when searching for a zip code the user 
        // specifies
        String userQuery = "";

        // Program indroduction
        System.out.println("This program will display a list of zip codes inside a pre-defined data file, ");
        System.out.println("then ask you to search for a particular state name. ");
        System.out.println();
        // This prints the contents of the states array
        System.out.println(states.toString());
        // Prompt the user for the name of a state and read in the response
        System.out.println("Please enter a zip code and press Enter: ");
        userQuery = reader.nextLine();
        // Some spacing before results are printed
        System.out.println();
        // Program searches for a match for the user's query, then prints the
        // relevant information or an error message if the query was not found
        states.findState(userQuery);

        reader.close();
    } // end main method

} // end class StateFinder
