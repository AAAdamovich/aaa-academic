/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 22-FEB-2018 - Last Edited: 27-FEB-2018
*  Assignment 4 - "Stack Assignment"
*  Description: Forms the individual element structure for "YAStack.java"
*   Note that the type of the "value" variable is set to "Object"
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package yastack;

public class StackElement {
  
    private Object value;
    private StackElement next;

    public StackElement() {
        value = null;
        next = null;
    }

    public StackElement(Object value, StackElement pointer) {
        this.value = value;
        this.next = pointer;
    }

    // \/ Generic getters and setters \/
    
    public StackElement getNext(){
        return next;
    }

    public Object getValue(){
        return value;
    }

    public void setNext(StackElement pointer){
        this.next = pointer;
    }
    
    public void setValue(Object value){
        this.value = value;
    }
    
}