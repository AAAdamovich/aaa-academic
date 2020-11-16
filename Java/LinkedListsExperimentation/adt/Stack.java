// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 11/1/13
// Stacks Experimentation

package adt;

public class Stack{
	
	private ListNode top;
	
	public Stack(){
		top = null;
	}
	
	public Stack(Object toBeAdded){
		top = new ListNode(toBeAdded, null);
	}

	public boolean push(Object toBeAdded){
		if(toBeAdded != null){
			ListNode newNode;
			if(top != null){
				newNode = (new ListNode(toBeAdded, top));
				top = newNode;
				return true;
			}
			newNode = (new ListNode(toBeAdded, null));
			top = newNode;
			return true;
		}
		else return false;
	}
	
	public Object pop(){
		ListNode toBeRemoved = top;
		top = (top.getPointer());
		return (toBeRemoved.getValue());
	}
	
	public Object peek(){
		return top.getValue();
	}
	
	public boolean isEmpty(){
		if(top == null) return true;
		else return false;
	}
}
