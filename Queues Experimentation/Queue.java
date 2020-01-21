// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 10/31/13
// Queues Experimentation

import java.util.ArrayList;
import adt.LinkedList;

// NOTICE! head points to the front and tail points to the back, but elements are added at the
// tail and removed out the head.

// Linked List's remove method is fully supported, no need to overwrite

public class Queue extends LinkedList{
	
	public Queue(){
		super();
	}
	
	public Queue(ArrayList<Object> list){
		super(list);
	}

	public Queue(Object[] array){
		super(array);
	}
	
	public boolean isEmpty(){
		if(head == null) return true;
		else return false;
	}

	public boolean add(Object toBeAdded){
		return super.addAtRear(toBeAdded);
	}
}