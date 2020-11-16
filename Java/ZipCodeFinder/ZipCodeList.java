/* Anton Adamovich
*  Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 1-25-2017 - Last Edited: 1-26-2018
*       Edited 1-23-2018 Variable names modifed to fit "zipcodes.txt" test file
*  Assignment 1 - ZipCodeList.java
*  Description: The ZipCodeList object holds an array of ZipCode objects, 
*       with some accessory functions. 
*  Resources:
*       The Java Platform API Specification
*       http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package zipcodefinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZipCodeList {

    // Specifies size of the array myList
    private final int MAX_SIZE = 1000;
    // Specifies number of ZipCode objects currently populating the myList array,
    // up to a maximum of MAX_SIZE. 
    private int numElements;
    // A list of ZipCode objects, the focal point of the class
    private final ZipCode[] MY_LIST;

    // Default constructor with instatiation of primitive array of ZipCode objects
    public ZipCodeList() {
        numElements = 0;
        MY_LIST = new ZipCode[MAX_SIZE];
    } // end constructor

    // Constructor is used to initialize the myList array using values from a 
    // provided data file. For the implementation of Assignment 1, this data
    // will not be changed after being transformed into array form, only
    // accessed for its information. 
    public ZipCodeList(String zipDataPath) throws FileNotFoundException{
        // MY_LIST is initialized to a locked size
        MY_LIST = new ZipCode[MAX_SIZE];
        numElements = 0;
        // Set up Scanner for file input operations
        Scanner fileReader = new Scanner(new File(zipDataPath));
        
        // Read lines from the text file until end of file, it is assumed the
        // number of lines in the data file will be a multiple of 3, also that 
        // the data order in the file is ordered: zip code, town, county. 
        while(fileReader.hasNextLine()){
            // Populates each element of the MY_LIST array with a ZipCode and its
            // relevant information. 
            MY_LIST[numElements] = new ZipCode();
            MY_LIST[numElements].setZip(fileReader.nextLine());
            MY_LIST[numElements].setTown(fileReader.nextLine());
            MY_LIST[numElements].setCounty(fileReader.nextLine());
            // A ZipCode object was added to MY_LIST, iterate numElements
            numElements++;
        } // end while
        fileReader.close();
    } // end constructor
    
    /**
     * Finds a ZipCode in the MY_LIST array based on a zip code search and prints
     * the information associated with the zip code query. There may be more
     * than one zip code printed. If no match was found, an error message is
     * printed. 
     *
     * @param query The character string the method will search for among the 
     *  "zipCode" properties of the ZipCode class. 
     */
    public void findState(String query){
        // Flag variable, set to true if the user query matches a zip code
        // entry in MY_LIST
        boolean isFound = false;
        // Iterate through MY_LIST and look for matching state
        for(int i = 0; i < numElements; i++){
            if(MY_LIST[i].getZip().equals(query)){
                // Success! Query matches a state name
                System.out.println(MY_LIST[i].getZip());
                System.out.println(MY_LIST[i].getTown());
                System.out.println(MY_LIST[i].getCounty());
                // Last print line for spacing between records
                System.out.println();
                // A match was found, flag variable is set
                isFound = true;
            } // end if
        } // end for
        if(!isFound){
            // Failure! No match was found since flag variable was never set
            System.out.println("Your search of \"" + query + "\" was not found in the list of zip codes. ");
        }
    } // end method
    
    /**
     * Creates and returns a String consisting of all the States and relevant 
     * information about said states inside the MY_LIST array. Formatting is 
     * taken care of by the overwritten toString() method of the State class. 
     *
     * @return A concatenated String of the contents of every zip code inside  
     * the MY_LIST array. 
     */
    @Override
    public String toString() {
        
        // The final String to be returned
        String allStates = "";
        
        // Loop "builds" the final returned String using a running total
        for(int i = 0; i < numElements; i++){
            // A newline is added betwen each state entry for readability
            allStates += (MY_LIST[i].toString() + "\n");
        } // end for
        
        return allStates;
    } // end method 

} // end class