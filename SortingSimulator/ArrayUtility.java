// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-25-2013
// Sorting Lab v2

import java.util.Random;

public class ArrayUtility {

	public static int[] copy(int[] originalArray){
		int length = originalArray.length;
		int[] copiedArray = new int[length];
		for(int i = 0; i < length; i++){
			copiedArray[i] = originalArray[i];
		}
		return copiedArray;
	}
	
	public static void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		// Nice spacing for following output
		System.out.println();
	}
	
	public static int[] generateArray(int length){
		Random generator = new Random();
		int[] array = new int[length];
		for(int i = 0; i < length; i++){
			array[i] = generator.nextInt(10);
		}
		return array;
	}
}
