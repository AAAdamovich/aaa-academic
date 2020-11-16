/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*   Originally written for Prof. Michael Meistering's Adv. Topics in CS at HGP
*  Created: 9-17-2013 - Last Edited: 10-13-2017
*   Edited 10-13-2017: Changed visibility of class variables to public and 
*   removed applicable getters/setters
*   Edited 2-15-2018: Restricted type of "value" variable to State
*  Assignment 3 - "Linked List Programming Assignment"
*  Description: ListNode is the class used as elements of StateList
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/
package statefinderv3;

public class ListNode {

    public State value;
    public ListNode pointer;

    public ListNode() {
        value = null;
        pointer = null;
    }

    public ListNode(State value, ListNode pointer) {
        this.value = value;
        this.pointer = pointer;
    }
}
