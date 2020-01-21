// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 10/31/13
// Queues Experimentation

import java.util.Random;

public class QueueDriver{

	public static void main(String[] args){
		Random generator = new Random();
		Integer[] array = new Integer[10];
		System.out.println("Original Array: ");
		for(int i = 0; i < 10; i++){
			array[i] = new Integer(generator.nextInt(10));
			System.out.print((array[i].intValue()) + " ");
		}
		Queue queue = new Queue(array);
		System.out.println("\nSame array fed through a queue and printed out: ");
		for(int i = 0; i < 10; i++){
			if(!(queue.isEmpty())) System.out.print((((Integer)(queue.remove().getValue())).intValue()) + " ");
		}
	}
}
