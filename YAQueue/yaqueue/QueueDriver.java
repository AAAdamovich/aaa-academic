/* Anton Adamovich
 * QueueDriver.java for Assignment 5 - "Queue Assignment"
 * Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
 * Created: 05-APR-2018 - Last Edited: 29-APR-2018
 * Description: Test class for functionality of YAQueue
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/
package yaqueue;

import statefinderv3.State;

public class QueueDriver {

    public static void main(String[] args) {
        
        State data1 = new State("Alabama", "Montgomery", 4858979);
        State data2 = new State("Alaska", "Juneau", 738432);
        State data3 = new State("Arizona", "Phoenix", 6828065);
        State data4 = new State("Arkansas", "Little Rock", 2978204);

        YAQueue testQueue0 = new YAQueue();
        YAQueue testQueue1 = new YAQueue();
        YAQueue testQueue2 = new YAQueue();
        YAQueue testQueue3 = new YAQueue();
        
        // Demonstate functionality of "ID" field
        System.out.println(testQueue0.getId());
        System.out.println(testQueue1.getId());
        System.out.println(testQueue2.getId());
        System.out.println(testQueue3.getId());
        
        // Dequeue / Enqueue tests and size verification
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Enqueue of: \n" + data1.toString());
        testQueue0.enqueue(data1);
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Enqueue of: \n" + data3.toString());
        testQueue0.enqueue(data1);
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Next Dequeue: \n" + testQueue0.dequeue().toString());
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Enqueue of: \n" + data2.toString());
        testQueue0.enqueue(data2);
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Enqueue of: \n" + data4.toString());
        testQueue0.enqueue(data4);
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Next Dequeue: \n" + testQueue0.dequeue().toString());
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Next Dequeue: \n" + testQueue0.dequeue().toString());
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
        
        System.out.println("Next Dequeue: \n" + testQueue0.dequeue().toString());
        
        System.out.println("Queue Size: " + testQueue0.getSize() + "\n");
    }
}
