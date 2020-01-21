// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 11/6/13
// Stacks Experimentation

import java.util.ArrayList;
import java.util.Random;
import adt.Stack;

public class StackDriver {

	public static void main(String[] args) {
		Random generator = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack stack = new Stack();
		for(int i = 0; i < 10; i++){
			list.add(new Integer(generator.nextInt(10)));
		}
		System.out.println("Original list printed out: ");
		for(Integer a : list){
			System.out.print((a.intValue()) + " ");
			stack.push(a);
		}
		System.out.println("\nList printed out again top-down out of a stack: ");
		while(!(stack.isEmpty())){
			System.out.print((((Integer)(stack.pop())).intValue()) + " ");
		}
	}
}
