/* Anton Adamovich
*  Prof. Craig Nelson - CSCI-211 - Community College of Philadelphia
*   Originally written for Prof. Michael Meistering's Adv. Topics in CS at HGP
*  Created: 9-17-2013 - Last Edited: 10-13-2017
*   Edited 10-13-2017: Changed visibility of class variables to public and 
*   removed applicable getters/setters
*  Assignment 3 - "Linked List Programming Assignment"
*  Description: ListNode is the class used as elements of LinkedList
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/
package statefinderv2;

public class ListNode {

    public Object value;
    public ListNode pointer;

    public ListNode() {
        value = null;
        pointer = null;
    }

    public ListNode(Object value, ListNode pointer) {
        this.value = value;
        this.pointer = pointer;
    }
}
