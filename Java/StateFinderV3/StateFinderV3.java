/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*   Originally written for Prof. Charles Herbert's CSCI-112 at CCP
*  Created: 1-25-2017 - Last Edited: 10-13-2017
*   Edited 10-13-2017: Modified file handling section, lines 29-31 only
*  Assignment 3 - "Linked List Programming Assignment"
*  Description: StateFinderV3 creates a list of states from a pre-defined data
*   file and then prompts the user to search for a specific state by name. 
*   Information about said state, such as population and capitol city, is
*   then printed out. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
 */
package statefinderv3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StateFinderV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // The pathname for the file that contains the state data
        final String DATA_PATH = "statedata.txt";
        // The File object that holds the pathname
        File inputFile = new File(DATA_PATH);
        // The list of states, being generated with data from the file
        StateList states = new StateList(inputFile);
        // Scanner used to get input frm the user
        Scanner reader = new Scanner(System.in);

        // Temporary variables, used when searching for a state the user 
        // specifies
        String userQuery = "";
        State resultState = null;

        // Program introduction
        System.out.println("This program will display a list of states inside a pre-defined data file, ");
        System.out.println("then ask you to search for a particular state name. ");
        System.out.println();
        // This prints the contents of the states array
        System.out.println(states.toString());
        // Prompt the user for the name of a state and read in the response
        System.out.println("Please enter a state name and press Enter: ");
        userQuery = reader.nextLine();
        System.out.println();
        // Program searches for a match for the user's query
        resultState = states.findState(userQuery);
        // A non-null value for resultState means a corresponding state name
        // entry was found in the StateList array
        if (resultState != null) {
            System.out.println("Success! ");
            System.out.println(resultState.toString());
        } // end if
        // Otherwise, if resultState is null, the user's query did 
        // not match any names in the StateList array
        else {
            System.out.println("The query \"" + userQuery + "\" did not match the name of any state in the list. ");
        } // end else

        reader.close();
    } // end main method

} // end class StateFinder
