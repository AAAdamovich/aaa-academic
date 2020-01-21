/* Anton Adamovich
 * QueueElement.java for Assignment 5 - "Queue Assignment"
 * Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
 * Created: 05-APR-2018 - Last Edited: 05-APR-2018
 * Description: An individual element of YAQueue able to accept any 
 * captital-"O" Object for its "value" field
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package yaqueue;

public class QueueElement {
    
    private Object value;
    private QueueElement next;

    public QueueElement() {
        value = null;
        next = null;
    }

    public QueueElement(Object value, QueueElement pointer) {
        this.value = value;
        this.next = pointer;
    }

    // \/ Generic getters and setters \/
    
    public QueueElement getNext(){
        return next;
    }

    public Object getValue(){
        return value;
    }

    public void setNext(QueueElement pointer){
        this.next = pointer;
    }
    
    public void setValue(Object value){
        this.value = value;
    }
}