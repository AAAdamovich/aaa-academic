

//// UNUSED CLASS  UNUSED CLASS  UNUSED CLASS  UNUSED CLASS  UNUSED CLASS ////


/* Anton Adamovich
*  Prof. Craig Nelson - CSCI-211 - Community College of Philadelphia
*   Originally written for Prof. Michael Meistering's Adv. Topics in CS at HGP
*  Created: 9-19-2013 - Last Edited: 10-13-2017
*   Edited 10-13-2017: Major revisions to methods and addition of "size" property
*   properties of "tail" and "head" flipped
*  Assignment 3 - "Linked List Programming Assignment"
*  Description: Personal implementation of the ADT "Abstract Data Type" structure
*   known as a "Linked List". Attempted to make this implementation as robust as 
*   possible but it was still heavily tailored to this specific assignment
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
 */
package statefinderv3;

import java.util.ArrayList;


//// UNUSED CLASS  UNUSED CLASS  UNUSED CLASS  UNUSED CLASS  UNUSED CLASS ////


public class LinkedList {
//
//    protected ListNode head;
//    protected ListNode tail;
//    private int size;
//
//    public LinkedList() {
//        head = null;
//        tail = null;
//        size = 0;
//    }
//
//    public LinkedList(ArrayList<Object> list) {
//        this();
//        if (!(list.isEmpty())) {
//            for (int i = 0; i < list.size(); i++) {
//                this.add(list.get(i));
//            }
//        } 
//        else {
//            System.out.println("ArrayList length is zero. ");
//        }
//    }
//
//    public LinkedList(Object[] array) {
//        this();
//        int length = array.length;
//        if (length != 0) {
//            for (int i = 0; i < length; i++) {
//                this.add(array[i]);
//            }
//        } 
//        else {
//            System.out.println("Array length is zero. ");
//        }
//    }
//    
//    /**
//     * Adds toBeAdded to the Linked List at the front of the list, denoted 
//     * by the head pointer. Works even if the list is empty and returns
//     * a boolean variable describing whether the operation was successful or not. 
//     *
//     * @param toBeAdded An Object that is to be encapsulated in a ListNode and 
//     * added to the Linked List
//     * 
//     * @return true if toBeAdded was added to the list successfully, false otherwise
//     */
//    public boolean add(Object toBeAdded) {
//        // Sanity check for broken input
//        if (toBeAdded != null) {
//            // Add operation on an empty list
//            if (this.isEmpty()) {
//                ListNode newNode = new ListNode(toBeAdded, null);
//                // Both head and tail pointers point to same node
//                head = newNode;
//                tail = newNode;
//            } 
//            // Add operation on a non-empty list
//            else {
//                // newNode is the new head of the list, points to null
//                ListNode newNode = new ListNode(toBeAdded, null);
//                // Old head pointer is one node behind newNode, update pointer
//                head.pointer = newNode;
//                // Update head pointer to new head of list
//                head = newNode;
//            }
//            size++;
//            // Item was added to list
//            return true;
//        } 
//        else {
//            // Item was not added to list
//            return false;
//        }
//    }
//
//    /**
//     * Adds toBeAdded to the Linked List at the position denoted by index. The 
//     * ListNode that occupies the indexed position and all subsequent LisNode's 
//     * are moved by +1 index space. Works even if the list is empty and returns
//     * a boolean variable describing whether the operation was successful or not. 
//     *
//     * @param toBeAdded An Object that is to be encapsulated in a ListNode and 
//     * added to the Linked List
//     * @param index The index within the list where toBeAdded will be placed
//     * 
//     * @return true if toBeAdded was added to the list successfully, false otherwise
//     */
//    public boolean add(Object toBeAdded, int index) {
//        // Sanity check for broken input
//        if (toBeAdded != null) {
//            // Sanity check for broken input
//            if (index >= 0) {
//                // Add operation on non-empty list
//                if (!this.isEmpty()) {
//                    // "0" index add is identical to a "AddAtRear" operation
//                    if (index == 0) {
//                        // New node points to old tail node
//                        ListNode newNode = new ListNode(toBeAdded, tail);
//                        // Update tail pointer
//                        tail = newNode;
//                        size++;
//                        // Item added successfully
//                        return true;
//                    }
//                    else{
//                        ListNode beforeAdded = tail;
//                        // Add at index "0" was already considered, this is for indexes >= 1
//                        int i = 1;
//                        // Looking for the indexed position within the list, loop
//                        // ends if list ends or indexed position is reached
//                        while ((beforeAdded != null) && (i <= index)) {
//                            if (i == index) {
//                                // Set the new node's pointer to the node ahead of it
//                                ListNode newNode = new ListNode(toBeAdded, beforeAdded.pointer);
//                                // Then set the pointer of the node behind the new node to the new node
//                                beforeAdded.pointer = newNode;
//                                size++;
//                                // Item added successfully
//                                return true;
//                            }
//                            // Index not attained, iterate to next element in the list
//                            beforeAdded = beforeAdded.pointer;
//                            i++;
//                        }
//                    System.out.println("The index \"" + index + "\" is out of bounds of the list. ");
//                    // Item was not added to the list
//                    return false; 
//                    }
//                    
//                } 
//                // Add operation on empty list
//                else {
//                    // Add operation on an empty list is only possible with an index of "0"
//                    if (index != 0) {
//                        System.out.println("The index \"" + index + "\" is out of bounds of the list. ");
//                        // Item was not added to the list
//                        return false;
//                    } 
//                    else {
//                        // This process is very similar to add method with no index,
//                        // or an add at the front of the list
//                        ListNode newNode = new ListNode(toBeAdded, null);
//                        head = newNode;
//                        tail = newNode;
//                        size++;
//                        // Item was successfully added to the list
//                        return true;
//                    }
//                }
//            } 
//            else {
//                System.out.println("The index \"" + index + "\" is out of bounds of the list. ");
//                // Item was not added to the list
//                return false;
//            }
//        } 
//        else {
//            // Item was not added to the list, null input
//            return false;
//        }
//    }
//
//    /**
//     * Adds toBeAdded to the Linked List at the rear of the list, denoted 
//     * by the tail pointer. Works even if the list is empty and returns
//     * a boolean variable describing whether the operation was successful or not. 
//     *
//     * @param toBeAdded An Object that is to be encapsulated in a ListNode and 
//     * added to the Linked List
//     * 
//     * @return true if toBeAdded was added to the list successfully, false otherwise
//     */
//    public boolean addAtRear(Object toBeAdded) {
//        if (toBeAdded != null) {
//            // Add oteration on a non-empty list
//            if (!this.isEmpty()) {
//                // New node points to old tail node
//                ListNode newNode = new ListNode(toBeAdded, tail);
//                // Update tail pointer
//                tail = newNode;
//            } 
//            // Add operation on an empty list
//            else {
//                ListNode newNode = new ListNode(toBeAdded, null);
//                // Both head and tail pointers point to same node
//                head = newNode;
//                tail = newNode;
//            }
//            size++;
//            // Item was successfully added to the list
//            return true;
//        } 
//        else {
//            // Item not added to the list, null input
//            return false;
//        }
//    }
//// Search method that ended up useless, left it here for future reworking    
///*
//    public ListNode find(State query){
//        // It is impossible to find anything in an empty list
//        if(this.isEmpty()){
//            return null;
//        }
//        else{
//            ListNode currentNode = tail;
//            // Traversal of the list
//            while (currentNode != null) {
//                // Note that this is the State-defined equals method, NOT
//                // the global one defined in Object
//                if(query.equals(currentNode.value)){
//                    return currentNode;
//                }
//                // Query not found yet, iterate to next element
//                currentNode = (currentNode.pointer);
//            }
//            // If above loop completes  w/o return, query does not exist in the list
//            return null;
//        }
//    }
//*/
//    
//    /**
//     * Gets the contents of the head pointer. 
//     * 
//     * @return A pointer to the object contained in the head ListNode
//     */
//    public Object getHead(){
//        return head;
//    }
//    
//    /**
//     * Gets the contents of the tail pointer. 
//     * 
//     * @return A pointer to the object contained in the tail ListNode
//     */
//    public Object getTail(){
//        return tail;
//    }
//    
//    /**
//     * Gives information about the emptiness of the Linked List 
//     * 
//     * @return true if the Linked List contains no elements, false otherwise. 
//     */
//    public boolean isEmpty(){
//        return (size == 0);
//    }
// 
//    /**
//     * Removes the first elements at the rear of the Linked List and returns 
//     * its contents as a ListNode. The element to be removed will be the one 
//     * the tail is pointing to before this method executes. 
//     *
//     * @return The ListNode that was removed from the Linked List. Null is returned 
//     * if nothing was removed. 
//     */
//    public ListNode remove() {
//        // Remove operation on a non-empty list
//        if (!this.isEmpty()) {
//            ListNode toBeRemoved = tail;
//            // Tail pointer is moved up to next element, 
//            // this works even with only 1 element in the list
//            tail = tail.pointer;
//            size--;
//            // Remove operation successful
//            return toBeRemoved;
//        } 
//        // Remove operation on an empty list, impossible
//        else {
//            System.out.println("Nothing to remove. ");
//            return null;
//        }
//    }
//
//    @Override
//    public String toString() {
//        String returnable = "";
//        ListNode currentNode = tail;
//        while (currentNode != null) {
//            returnable += ((currentNode.value.toString()) + "\n");
//            currentNode = (currentNode.pointer);
//        }
//        return returnable;
//    }
//
//// Below are legacy static utility methods that are not needed for this assignment
//    
//    public static LinkedList reverse(ArrayList<Object> list) {
//        LinkedList returnable = new LinkedList();
//        int length = list.size();
//        if (length > 0) {
//            for (int i = (length - 1); i >= 0; i--) {
//                returnable.add(list.get(i));
//            }
//            return returnable;
//        } 
//        else {
//            return returnable;
//        }
//    }
//
//    public static LinkedList reverse(Object[] array) {
//        LinkedList returnable = new LinkedList();
//        int length = array.length;
//        if (length > 0) {
//            for (int i = (length - 1); i >= 0; i--) {
//                returnable.add(array[i]);
//            }
//            return returnable;
//        } 
//        else {
//            return returnable;
//        }
//    }
}


//// UNUSED CLASS  UNUSED CLASS  UNUSED CLASS  UNUSED CLASS  UNUSED CLASS ////