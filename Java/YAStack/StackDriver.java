/* Anton Adamovich
*  Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 27-FEB-2018 - Last Edited: 27-MAR-2018
*  Assignment 4 - "Stack Assignment"
*  Description: Tests the functionality of YAStack. Imports an array of strings
*   into a stack and pops each element off the stack, reversing the array of
*   string in the process
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package yastack;

public class StackDriver {

    public static void main(String[] args) {
        // Create test array of various strings
        String[] testArray  = {"Joe", "Fred", "Bill", "Cookie", "Marcus"};
        // Print the testArray
        System.out.println("Test Array: ");
        for(String a : testArray){
            System.out.println(a);
        }
        // Create a stack containing the data in the test array
        YAStack testStack = new YAStack(testArray);
        System.out.println("\nArray passed through a stack: ");
        // Empty the contents of the test stack, the strings 
        while(!testStack.isEmpty()){
            System.out.println(testStack.pop().toString());
            // Methods used for testing:
            // System.out.println(testStack.peek());
            // System.out.println(testStack.getSize());
            // System.out.println(testStack.toString());
        }
    }
}