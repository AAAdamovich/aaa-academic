// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 10-2-2013
// Linked Lists Experimentation

package adt;

import java.util.ArrayList;

public class CircularLinkedList extends LinkedList{

	public CircularLinkedList(){
		super();
	}
	
	public CircularLinkedList(ArrayList<Object> list){
		super(list);
	}
	
	public CircularLinkedList(Object[] array){
		super(array);
	}
	
	public boolean add(Object toBeAdded){
		if(head != null){
			ListNode newNode = new ListNode(toBeAdded, head);
			head = newNode;
		}
		else{
			ListNode newNode = new ListNode(toBeAdded, null);
			newNode.setPointer(newNode);
			head = newNode;
			tail = newNode;
		}
		return true;
	}
	
	public boolean addAtRear(Object toBeAdded){
		if(tail != null){
			ListNode newNode = new ListNode(toBeAdded, head);
			tail.setPointer(newNode);
			tail = newNode;
		}
		else{
			ListNode newNode = new ListNode(toBeAdded, null);
			newNode.setPointer(newNode);
			head = newNode;
			tail = newNode;
		}
		return true;
	}
	
	public ListNode remove(){
		if(head != null){
			ListNode returnable = head;
			if(head == (head.getPointer())){
				head = null;
				tail = null;
				return returnable;
			}
			head = (head.getPointer());
			tail.setPointer(head);
			return returnable;
		}
		else{
			System.out.println("List length is zero. ");
			return null;
		}
	}
	
	public String toString(){
		ListNode currentNode = head;
		String returnable = "";
		boolean tailChecker = false;
		while((currentNode != null) && (!tailChecker)){
			if(tail == currentNode) tailChecker = true;
			returnable += ((currentNode.getValue().toString()) + " ");
			currentNode = (currentNode.getPointer());
		}
		return returnable;
	}
}
