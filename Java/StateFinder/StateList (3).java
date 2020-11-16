/* Anton Adamovich
*  Prof. Chuck Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 1-25-2017 - Last Edited: 9-13-2017
*  Assignment 1
*  Description: The StateList object holds an array of state objects, 
*   upon which several operations are perfromed
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package statefinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateList {

    // Specifies size of instatiated primitive array myList, to be defined
    // inside the default constuctor
    private final int MAX_SIZE;
    // Specifies number of State objects currently populating the myList array,
    // up to a maximum of MAX_SIZE
    private int numElements;
    // A list of State objects, the focal point of the class
    private State[] myList;

    // Default constructor with instatiation of primitive array of State objects
    // and definition of max size of the array. 
    public StateList() {
        // !! IMPORTANT !! Set size of primitive array
        MAX_SIZE = 100;
        
        numElements = 0;
        myList = new State[MAX_SIZE];
    } // end constructor

    // Constructor is used to initialize the myList array using values from a 
    // provided data file. For the implementation of Assignment 1, this data
    // will not be changed after being transformed into array form, only
    // accessed for its information. 
    public StateList(String stateDataPath) throws FileNotFoundException{
        // !! IMPORTANT !! Set size of primitive array
        MAX_SIZE = 100;
        
        myList = new State[MAX_SIZE];
        numElements = 0;
        // Set up Scanner for file input operations
        Scanner fileReader = new Scanner(new File(stateDataPath));
        
        // Read lines from the text file until end of file, it is assumed the
        // number of lines in the data file will be a multiple of 3, also that 
        // the data order in the file goes State, Capitol, Population
        while(fileReader.hasNextLine()){
            // Populates each element of the myList array with a state and its
            // relevant information. The population msut be converted to an
            // int data type before beign entered into the State object
            myList[numElements] = new State();
            myList[numElements].setName(fileReader.nextLine());
            myList[numElements].setCapitol(fileReader.nextLine());
            myList[numElements].setPopulation(Integer.parseInt(fileReader.nextLine()));

            numElements++;
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
        // Iteratre through myList and look for matching state
        for(int i = 0; i < numElements; i++){
            if(myList[i].getName().equalsIgnoreCase(query)){
                // Success! Query matches a state name
                return myList[i];
            } // end if
        } // end for
        // Failure! No match was found
        return null;
    } // end method
    
    /**
     * Creates and returns a String consisting of all the States and relevant 
     * information about said states inside the myList array. Formatting is 
     * taken care of by the overwritten toString() method of the State class. 
     *
     * @return A concatenated String of the contents of every State inside the 
     * myList array, delimited by two consecutive carriage returns. 
     */
    @Override
    public String toString() {
        
        // The final String to be returned
        String allStates = "";
        
        // Loop "builds" the final returned String using a running total
        for(int i = 0; i < numElements; i++){
            // A newline is added betwen each state entry for readability
            allStates += (myList[i].toString() + "\n");
        } // end for
        
        return allStates;
    } // end method 

} // end class
