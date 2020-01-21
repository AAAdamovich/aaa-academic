// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-17-2013
// Linked Lists Experimentation

import adt.ListNode;

public class DoublyLinkedListNode extends ListNode{

	private Object value;
	private DoublyLinkedListNode back;
	private DoublyLinkedListNode front;
	
	public DoublyLinkedListNode(){
		value = null;
		front = null;
		back = null;
	}
	
	public DoublyLinkedListNode(Object value, DoublyLinkedListNode back, DoublyLinkedListNode front){
		this.value = value;
		this.back = back;
		this.front = front;
	}
}
