/* Anton Adamovich
*  Prof. Craig Nelson - CSCI-211 - Community College of Philadelphia
*   Originally written for Prof. Chuck CSCI-112 at CCP
*  Created: 1-25-2017 - Last Edited: 10-13-2017
*   Edited 10-13-2017: Rewritten for Linked List Structure and other cleanup
*  Assignment 3 - "Linked List Programming Assignment"
*  Description: The StateList object holds an array of state objects, 
*   upon which several operations are perfromed
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package statefinderv2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateList {

    // A list of State objects, the focal point of the class
    private final LinkedList myList;

    // Default constructor with instatiation of primitive array of State objects
    // and definition of max size of the array. 
    public StateList() {
        myList = new LinkedList();
    } // end constructor

    // Constructor is used to initialize the myList array using values from a 
    // provided data file. For the implementation of Assignment 3, this data
    // will not be changed after being transformed into array form, only
    // accessed for its information. 
    public StateList(File stateData) throws FileNotFoundException{ 
        myList = new LinkedList();
        // Set up Scanner for file input operations, no error handling is done
        // here, any errors are thrown up the stack
        Scanner fileReader = new Scanner(stateData);
        
        // Read lines from the text file until end of file, it is assumed the
        // number of lines in the data file will be a multiple of 3, also that 
        // the data order in the file goes State, Capitol, Population
        while(fileReader.hasNextLine()){
            // Populates each element of the myList array with a state and its
            // relevant information. The population must be converted to an
            // int data type before being entered into the State object
            myList.add(new State(fileReader.nextLine(), fileReader.nextLine(), Integer.parseInt(fileReader.nextLine())));
            
        } // end while
        fileReader.close();
    } // end constructor
    
    /**
     * Finds a state in the myList array based on a name search and returns
     * that State object or null if no match was found. Character case is 
     * ignored while searching for a match. 
     *
     * @param query The String name of the State to search for inside myList
     * 
     * @return The State object matching the String name search query
     */
    public State findState(String query){
        // Iterate through myList and look for matching state
        ListNode nextNode = myList.tail;
        while(nextNode != null){
            // Explicit cast to State type to avoid compile errors, meant to
            // be used ONLY with a list built with State objects
            if(((State)nextNode.value).getName().equalsIgnoreCase(query)){
                // Success! Query matches a state name
                return (State)(nextNode.value);
            }
            // Iterate to next element
            nextNode = nextNode.pointer;
        }
        // Failure! No match was found
        return null;
    } // end method
    
    /**
     * Creates and returns a String consisting of all the States and relevant 
     * information about said states inside the myList array. Formatting is 
     * taken care of by the overwritten toString() method of the State class. 
     *
     * @return A concatenated String of the contents of every State inside the 
     * myList array, delimited by carriage returns. 
     */
    @Override
    public String toString() {
        return myList.toString();
    } // end method 

} // end class

