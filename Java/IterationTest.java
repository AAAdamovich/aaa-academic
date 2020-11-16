// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 11-6-2013
// Iteration Experimentation

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IterationTest {

	public static void main(String[] args) {
		Random generator = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("A randomly generated ArrayList printed out with a basic 'for' loop: ");
		for(int i = 0; i < 10; i++){
			list.add(new Integer(generator.nextInt(10)));
			System.out.print((list.get(i).intValue()) + " ");
		}
		System.out.println("\nThe same ArrayList printed out using an iterator: ");
		Iterator<Integer> iteration = list.iterator();
		while(iteration.hasNext()){
			System.out.print((iteration.next()) + " ");
		}
	}
}
