// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-17-2013
// Linked Lists Experimentation

import java.util.Random;

import adt.CircularLinkedList;
import adt.LinkedList;

public class LinkedListsDriver {

	public static void main(String[] args) {
		Integer[] array = generateArray(10);
		LinkedList list;
		CircularLinkedList cList;
		// Experimentation Section
		
		System.out.println("Unsorted array: ");
		for(int i = 0; i < 10; i++){
			System.out.print((array[i].intValue()) + " ");
		}
		
		list = new LinkedList(array);
		System.out.println("\nUnsorted array in LinkedList form: ");
		System.out.println(list.toString());
		
		list = LinkedList.reverse(array);
		System.out.println("Same array in LinkedList form but reversed: ");
		System.out.println(list.toString());
		
		cList = new CircularLinkedList(array);
		System.out.println("Same array except in CircularLinkedList form: ");
		System.out.println(cList.toString());
	}
	
	private static Integer[] generateArray(int length){
		Random generator = new Random();
		Integer[] array = new Integer[length];
		Integer a;
		for(int i = 0; i < length; i++){
			a = new Integer(generator.nextInt(10));
			array[i] = a;
		}
		return array;
	}

}
