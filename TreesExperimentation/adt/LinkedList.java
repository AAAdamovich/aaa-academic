// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-19-2013
// Linked Lists Experimentation

package adt;

import java.util.ArrayList;

public class LinkedList{

	protected ListNode head;
	protected ListNode tail;
	
	public LinkedList(){
		head = null;
		tail = null;
	}
	
	public LinkedList(ArrayList<Object> list){
		this();
		if(!(list.isEmpty())){
			for(int i = 0; i < list.size(); i++){
				this.add(list.get(i));
			}
		}
		else{
			System.out.println("ArrayList length is zero. ");
		} 
	}

	public LinkedList(Object[] array){
		this();
		int length = array.length;
		if(length != 0){
			for(int i = 0; i < length; i++){
				this.add(array[i]);
			}
		}
		else{
			System.out.println("Array length is zero. ");
		} 
	}
	
	public boolean add(Object toBeAdded){
		if(toBeAdded != null){
			if(head != null){
				ListNode newNode = new ListNode(toBeAdded, head);
				head = newNode;
			}
			else{
				ListNode newNode = new ListNode(toBeAdded, null);
				head = newNode;
				tail = newNode;
			}
			return true;
		}
		else return false;
	}
	
	public boolean add(Object toBeAdded, int index){
		if(toBeAdded != null){
			if(index >= 0){
				if(head != null){
					if(index == 0){
						ListNode newNode = new ListNode(toBeAdded, head);
						head = newNode;
						return true;
					}
					ListNode beforeAdded = head;
					int i = 0;
					while((beforeAdded != null) && (i < index)){
						if(i == (index - 1)){
							ListNode newNode = new ListNode(toBeAdded, (beforeAdded.getPointer()));
							beforeAdded.setPointer(newNode);
							return true;
						}
						beforeAdded = (beforeAdded.getPointer());
						i++;
					}
					System.out.println("That index is out of bounds of the list. ");
					return false;
				}
				else{
					if(index != 0){
						System.out.println("That index is out of bounds of the list. ");
						return false;
					}
					else{
						ListNode newNode = new ListNode(toBeAdded, null);
						head = newNode;
						tail = newNode;
						return true;
					}
				}
			}
			else{
				System.out.println("That index is out of bounds of the list. ");
				return false;
			}
		}
		else return false;
	}
	
	public boolean addAtRear(Object toBeAdded){
		if(toBeAdded != null){
			if(tail != null){
				ListNode newNode = new ListNode(toBeAdded, null);
				tail.setPointer(newNode);
				tail = newNode;
			}
			else{
				ListNode newNode = new ListNode(toBeAdded, null);
				head = newNode;
				tail = newNode;
			}
			return true;
		}
		else return false;
	}
	
	public ListNode remove(){
		if(head != null){
			ListNode toBeRemoved = head;
			if((head.getPointer()) == null) tail = null;
			head = (head.getPointer());
			return toBeRemoved;
		}
		else{
			System.out.println("Nothing to remove. ");
			return null;
		}
	}
	
	public String toString(){
		String returnable = "";
		ListNode currentNode = head;
		while(currentNode != null){
			returnable += ((currentNode.getValue().toString()) + " ");
			currentNode = (currentNode.getPointer());
		}
		return returnable;
	}
	
	public static LinkedList reverse(ArrayList<Object> list){
		LinkedList returnable = new LinkedList();
		int length = list.size();
		if(length > 0){
			for(int i = (length - 1); i >= 0; i--){
				returnable.add(list.get(i));
			}
			return returnable;
		}
		else return returnable;
	}
	
	public static LinkedList reverse(Object[] array){
		LinkedList returnable = new LinkedList();
		int length = array.length;
		if(length > 0){
			for(int i = (length - 1); i >= 0; i--){
				returnable.add(array[i]);
			}
			return returnable;
		}
		else return returnable;
	}
}
