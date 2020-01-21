/* Anton Adamovich
 * Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia
 * Created: 2-23-2017 - Last Edited: 4-25-2017
 * Description: <DESCRIPTION>
 * Resources: 
 *     The Java Platform API Specification
 *     http://docs.oracle.com/javase/8/docs/api/overview-summary.html
 *     Charles Herbert's "Tutorials" - cherbert@ccp.edu
 */

package multiplesorts;

import java.io.File;
import java.util.Scanner;

public class MultipleSorts {

    public static void main(String[] args) throws Exception {
        // A file containing a list of tutorials, delimited by new-lines
        File sourceFile = new File("unsorted.txt");        
        // An array to hold a list of tutorials, identical to the first 100
        // lines contained in the source file
        String[] sourceArray = new String[100];
        // Create an identical array of tutorials to be sorted
        String[] tutorials = sourceArray.clone();
        // The number of elements in sourceArray that are used, also is valid
        // for the tutorials array
        int count = 0;

        // *** BUBBLE SORT SECTION ***
        
        // Read data into tutorials[] line by line and return count
        count = readLines(tutorials, sourceFile);

        // Print the unsorted array contents as seen in the soource file
        System.out.println("The original array: \n");
        displayLines(sourceArray, count);

        // Sort the array 
        sortStringArray(tutorials, count);

        // Print the array on the screen  line by line
        System.out.println("\nThe sorted array:\n");
        displayLines(tutorials, count);

        // write the array to a data file line by line
        writeLines(tutorials, count);

        // *** SELECTION SORT SECTION ***
        
        // *** INSERTION SORT SECTION ***
        
    } // End method       

    /** This method reads a certain amount of lines from a text file
     *  and transforms each line of input into a String array. 
     *  The array has a maximum size that is pre-defined and this method
     *  will stop writing to the array if the amount of lines in the file
     *  exceeds the maximum array size. 
     *  Each line from the file will be one element in the array.
     * 
     *  @param lines The array of String objects read from inFile. 
     *      Preconditions: lines is initialized and has a length greater 
     *      than or equal to local variable MAX_SIZE.
     *      Postconditions: Starting from array index 0, lines array contains data
     *      equal to elements contained in inFile object, delimited by line breaks.
     * 
     *  @param inFile The File object where the tutorials data originates.
     * 
     *  @return The number of lines (or array elements) read from inFile.
     */
    private static int readLines(String[] lines, File inFile) throws Exception{
        
        final int MAX_SIZE = 100;
        
        int count = 0; // number of array elements with data

        // Create a File class object linked to the name of the file to read
        java.io.File unsorted = new java.io.File("unsorted.txt");

        // Scanner will read the input stream from the file
        Scanner fReader = new Scanner(unsorted);

        // Reads lines of text into an array. Scanner function hasNextLine() 
        // is used as a sentinel for the end of inFile. Input operations 
        // cannot exceed maximum array size
        while (fReader.hasNextLine() && count < MAX_SIZE) {
            // Read a line and put it in an array element
            lines[count] = fReader.nextLine();
            // Increment the number of array elements with data
            count++;  
        } // End while

        fReader.close();
        // Returns the number of items used in the array.
        return count;

    } // End method

    /* This method sorts an array of Strings line by line 
     * using a simple bubble sort. 
     * 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */
    public static void sortStringArray(String[] a, int count) {
        boolean swapped;    //  keeps track of when array values are swapped 
        int i;              // a loop counter
        String temp;         // catalyst variable for String swapping

        // Each iteration of the outer do loop is is one pass through the loop. 
        // If anything was swapped, it makes another pass
        do {
            // set swapped to false before each pass
            swapped = false;

            // the for loop is a pass through the array to the second to last element
            for (i = 0; (i < count - 1); i++) {
                // if the two items are out of order  see page 16 for String compareTo() 
                if (a[i + 1].compareTo(a[i]) < 0) {
                    // swap the two items ans set swapped to true    
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;

                    swapped = true;

                }  // end if
            } // end for

            // the outer loop will repeat if a swap was made  – another passs
        } while (swapped);

    } // end sortStringArray

    /*This method prints an array of Strings on the screen.  
         * The first parameter refers to the array in the main method.  The second 
         * parameter is the number of elements in the array that actually contain data
     */
    public static void displayLines(String[] lines, int count) {
        
        for(String line : lines){
            System.out.println(line);
        }
    } // end displayLines()

    /* This method writes an array of Strings to a text data file.  
 * The first parameter refers to the array in the main method. The second parameter
 * is the number of elements in the array that actually contain data
     */
    public static void writeLines(String[] lines, int count) throws Exception {
        // create a File class object and give the file the name tutorials.txt
        java.io.File tut = new java.io.File("tutorials.txt");
        // Create a PrintWriter text output stream and link it to the file x
        java.io.PrintWriter outfile = new java.io.PrintWriter(tut);

        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            outfile.println(lines[i]);
        }

        outfile.close();

    } // end writeTextArray()
}