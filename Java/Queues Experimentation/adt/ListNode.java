// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-17-2013
// Linked Lists Experimentation

package adt;

public class ListNode {

	private Object value;
	private ListNode pointer;
	
	public ListNode(){
		value = null;
		pointer = null;
	}
	
	public ListNode(Object value, ListNode pointer){
		this.value = value;
		this.pointer = pointer;
	}

	public Object getValue(){
		return value;
	}

	public void setValue(Object value){
		this.value = value;
	}

	public ListNode getPointer(){
		return pointer;
	}

	public void setPointer(ListNode pointer){
		this.pointer = pointer;
	}
}
