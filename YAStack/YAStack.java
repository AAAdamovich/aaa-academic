/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 27-FEB-2018 - Last Edited: 27-MAR-2018
*   EDITED 27-MAR-2018 - Added documentation to methods
*  Assignment 4 - "Stack Assignment"
*  Description: An implementation of a stack abstract data type. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package yastack;

public class YAStack {
    
    private StackElement head;
    private int size;
    
    // Default "null" constuctor
    public YAStack(){
        head = null;
        size = 0;
    }
    
    // Construction of YAStack when an array of data is provided
    public YAStack(Object[] array){
        // Chaining default constructor to avoid null pointer errors
        this();
        // Iterate through parameter array and add each element to the stack
        for(Object a : array){
            push(a);
        }
    }
    
    /**
     * Obtains the number of elements currently present in YAStack. 
     * 
     * @return The size of YAStack, or how many elements the stack contains
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Tests whether YAStack is empty or not. 
     * 
     * @return true if the stack contains no elements, false otherwise
     */
    public boolean isEmpty(){
        return (size == 0);
    }
    
    /**
     * Returns the element that is at the top of the stack without removing it. 
     * 
     * @return The value inside the StackElement indicated by the "head" 
     * pointer, which is the top of YAStack. Null is returned if YAStack is
     * empty
     */
    public Object peek(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return head.getValue();
        }
    } // End method
    
    /**
     * Returns the element that is at the top of the stack and removes it from 
     * the stack. 
     * 
     * @return The value inside the StackElement indicated by the "head" 
     * pointer, which is the top of YAStack. Null is returned if the YAStack is
     * empty
     */
    public Object pop(){
        if(this.isEmpty()){
            return null;
        }
        else{
            // Store value ot be returned before dereferencing the top node
            Object value = head.getValue();
            // Update head pointer to the next node below the top
            head = head.getNext();
            // A node was removed, update size
            size--;
            return value;
        }
    } // End method
    
    /**
     * Adds a new StackElement to the stack at the top of YAStack. 
     * 
     * @param a The data that is to be included in the StackElement class
     * that is being added to YAStack. 
     */
    public void push(Object a){
        // Instatiate new StackElement object with stored parameter data. 
        // This new node's pointer is set to the dead of YAStack
        StackElement newElement = new StackElement(a, head);
        // ... The head pointer is then updated to the newly added node
        head = newElement;
        // A node was added, update size
        size++;
    } // End method
    
    /**
     * Returns a string representation of the data within YAStack, delimited
     * by carriage returns. 
     * 
     * @return A concatenated string containing the string representations
     * of every StackElement within YAStack
     */
    @Override
    public String toString(){
        // An iterator is required to obtain information from every node 
        StackElement iterator = head;
        // The "running total" string that will be built and returned
        String stackTotal = "";
        // Loop goes until iterator finds the bottom of YAStack. 
        // An empty stack will skip this loop, returning an empty String
        while(iterator != null){
            // Adds the contents of whatever the iterator is pointing to the 
            // "stackTotal" that will be returned
            stackTotal += ((iterator.getValue().toString()) + "\n");
            // Iterate the iterator to the next node in YAStack
            iterator  = iterator.getNext();
        }
        return stackTotal;
    } // End method
} // End class