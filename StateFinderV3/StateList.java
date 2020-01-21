/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*   Originally written for Prof. Charles Herbert's CSCI-112 at CCP
*  Created: 1-25-2017 - Last Edited: 2-15-2017
*   Edited 10-13-2017: Rewritten for Linked List Structure and other cleanup
*   Edited 2-15-2017: Import of LinkedList functionality from LinkedList.java,
*   not all methods were used, "Object" parameters restricted to type "State"
*  Assignment 3 - "Linked List Programming Assignment"
*  Description: The StateList object holds an linked list of state objects, 
*   upon which several operations are performed
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package statefinderv3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateList {

    // A list of State objects, the focal point of the class
    protected ListNode head;
    protected ListNode tail;
    private int size;

    // Default Constructor
    public StateList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Instantiation of linked list from a primitive array of State objects
    // and definition of max size of the array. 
    public StateList(State[] array) {
        // Chaining default contructor ensures proper operation if 
        // import data is empty
        this();
        int length = array.length;
        if (length != 0) {
            for (int i = 0; i < length; i++) {
                this.add(array[i]);
            }
        } 
        else {
            System.out.println("Array length is zero. ");
        }
    } // end constructor

    // Constructor is used to initialize the myList array using values from a 
    // provided data file. For the implementation of Assignment 3, this data
    // will not be changed after being transformed into array form, only
    // accessed for its information. 
    public StateList(File stateData) throws FileNotFoundException{ 
        // Chaining default contructor ensures proper operation of 
        // import data is empty
        this();
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
            this.add(new State(fileReader.nextLine(), fileReader.nextLine(), Integer.parseInt(fileReader.nextLine())));
            
        } // end while
        fileReader.close();
    } // end constructor
    
    /**
     * Adds toBeAdded to the Linked List at the front of the list, denoted 
     * by the head pointer. Works even if the list is empty and returns
     * a boolean variable describing whether the operation was successful or not. 
     *
     * @param toBeAdded An Object that is to be encapsulated in a ListNode and 
     * added to the Linked List
     * 
     * @return true if toBeAdded was added to the list successfully, false otherwise
     */
    public boolean add(State toBeAdded) {
        // Sanity check for broken input
        if (toBeAdded != null) {
            // Add operation on an empty list
            if (this.isEmpty()) {
                ListNode newNode = new ListNode(toBeAdded, null);
                // Both head and tail pointers point to same node
                head = newNode;
                tail = newNode;
            } 
            // Add operation on a non-empty list
            else {
                // newNode is the new head of the list, points to null
                ListNode newNode = new ListNode(toBeAdded, null);
                // Old head pointer is one node behind newNode, update pointer
                head.pointer = newNode;
                // Update head pointer to new head of list
                head = newNode;
            }
            size++;
            // Item was added to list
            return true;
        } 
        else {
            // Item was not added to list
            return false;
        }
    }
    
    /**
     * Adds toBeAdded to the Linked List at the rear of the list, denoted 
     * by the tail pointer. Works even if the list is empty and returns
     * a boolean variable describing whether the operation was successful or not. 
     *
     * @param toBeAdded An State that is to be encapsulated in a ListNode and 
     * added to the Linked List
     * 
     * @return true if toBeAdded was added to the list successfully, false otherwise
     */
    public boolean addAtRear(State toBeAdded) {
        if (toBeAdded != null) {
            // Add operation on a non-empty list
            if (!this.isEmpty()) {
                // New node points to old tail node
                ListNode newNode = new ListNode(toBeAdded, tail);
                // Update tail pointer
                tail = newNode;
            }
            // Add operation on an empty list
            else {
                ListNode newNode = new ListNode(toBeAdded, null);
                // Both head and tail pointers point to same node
                head = newNode;
                tail = newNode;
            }
            size++;
            // Item was successfully added to the list, iterate size
            return true;
        } 
        else {
            // Item not added to the list, null input
            return false;
        }
    }
    
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
        ListNode nextNode = this.tail;
        while(nextNode != null){
            if((nextNode.value).getName().equalsIgnoreCase(query)){
                // Success! Query matches a state name
                return nextNode.value;
            }
            // Iterate to next element
            nextNode = nextNode.pointer;
        }
        // Failure! No match was found
        return null;
    } // end method
    
    /**
     * Gets the contents of the head pointer. 
     * 
     * @return A pointer to the object contained in the head ListNode
     */
    public ListNode getHead(){
        return head;
    }
    
    /**
     * Gets the contents of the tail pointer. 
     * 
     * @return A pointer to the object contained in the tail ListNode
     */
    public ListNode getTail(){
        return tail;
    }
    
    /**
     * Gives information about the emptiness of the Linked List 
     * 
     * @return true if the Linked List contains no elements, false otherwise. 
     */
    public boolean isEmpty(){
        return (size == 0);
    }
    
    /**
     * Removes the first elements at the rear of the Linked List and returns 
     * its contents as a ListNode. The element to be removed will be the one 
     * the tail is pointing to before this method executes. 
     *
     * @return The ListNode that was removed from the Linked List. Null is returned 
     * if nothing was removed. 
     */
    public ListNode remove() {
        // Remove operation on a non-empty list
        if (!this.isEmpty()) {
            ListNode toBeRemoved = tail;
            // Tail pointer is moved up to next element, 
            // this works even with only 1 element in the list
            tail = tail.pointer;
            size--;
            // Remove operation successful
            return toBeRemoved;
        } 
        // Remove operation on an empty list, impossible
        else {
            System.out.println("Nothing to remove. ");
            return null;
        }
    }
    
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
        String result = "";
        ListNode currentNode = tail;
        while (currentNode != null) {
            result += ((currentNode.value.toString()) + "\n");
            currentNode = (currentNode.pointer);
        }
        return result;
    } // end method 

} // end class

