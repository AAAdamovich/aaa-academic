/* Anton Adamovich
 * YAQueue.java for Assignment 5 - "Queue Assignment"
 * Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
 * Created: 05-APR-2018 - Last Edited: 29-APR-2018
 *  Edited: 29-APR-2018: Implementation of enqueue and dequeue methods
 * Description: YAQueue is an implementation of a "Queue" Abstract Data Type 
 *  which uses the "State" object as the data field. 
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/
package yaqueue;

import statefinderv3.State;

public class YAQueue {
    
    private static int classId = 0;
    private final int ID;
    private QueueElement head;
    private QueueElement tail;
    private int size;
    
    // Default Contructor
    public YAQueue(){
        // Set unique "ID" constant before iterating class-wide id
        ID = classId;
        classId++;
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Removes an element at the front, or "head" of YAQueue and returns 
     * its contents as a State. The element to be removed will be the one 
     * the "head" is pointing to before this method executes. 
     *
     * @return The State value within QueueElement that was removed 
     * from YAQueue. Null is returned if nothing was removed. 
     */
    public State dequeue(){
        // Remove operation on a non-empty queue
        if (!this.isEmpty()) {
            QueueElement toBeRemoved = head;
            // Head pointer is moved up to next element, 
            // This works even with only 1 element in the queue
            head = head.getNext();
            size--;
            // Dereference tail if YAQueue is now empty
            if(this.isEmpty()){
                tail = null;
            }
            // Explicit cast to work with generic Object type used in QueueElement
            return ((State)toBeRemoved.getValue());
            // Remove operation successful
        }
        // Remove operation on an empty queue, impossible
        else {
            System.out.println("Nothing to remove. ");
            return null;
        }
    }
    
    /**
     * Adds toBeAdded to YAQueue at the rear of the queue, denoted 
     * by the tail pointer. Works even if the queue is empty and returns
     * a boolean variable describing whether the operation was successful or not. 
     *
     * @param toBeAdded An Object that is to be encapsulated in a QueueElement
     *  and added to YAQueue
     * 
     * @return true if toBeAdded was added to YAQueue successfully, false otherwise
     */
    public boolean enqueue(State toBeAdded){
        // Sanity check for broken input
        if (toBeAdded != null) {
            // Add operation on an empty queue
            if (this.isEmpty()) {
                QueueElement newNode = new QueueElement(toBeAdded, null);
                // Both head and tail pointers point to same node
                head = newNode;
                tail = newNode;
            }
            // Add operation on a non-empty queue
            else {
                // newNode is the new tail of the list, points to null
                QueueElement newNode = new QueueElement(toBeAdded, null);
                // Old head pointer is one node behind newNode, update pointer
                tail.setNext(newNode);
                // Update head pointer to new "head" or back of queue
                tail = newNode;
            }
            size++;
            // Item was added to queue
            return true;
        } 
        else {
            // Item was not added to queue
            return false;
        }
    }
     
    /**
     * Gives the unique integer identifier for this instance of YAQueue 
     * 
     * @return An id unique among instances of the YAQueue class. 
     *  Minimum = 0, Maximum = Integer.MAX_VALUE
     */
    public int getId(){
        return ID;
    }
    
    /**
     * Obtains the number of elements currently present in YAQueue. 
     * 
     * @return The size of YAQueue, or how many elements the queue contains
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Tests whether YAQueue is empty or not. 
     * 
     * @return true if the queue contains no elements, false otherwise
     */
    public boolean isEmpty(){
        return (size == 0);
    }
}