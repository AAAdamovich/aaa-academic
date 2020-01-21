//Anton Adamovich
//AP Computer Science A
//Mr. Meistering
//3-5-12
//Mid-Term Review

import java.util.Scanner;
import java.util.Random;

public class ChangeZeros {
	
	public static void genList(int[] list){
		Random generator = new Random();
		for(int i = 0; i < (list.length); i++){
			list[i] = generator.nextInt(6);
		}
	}

	public static int findZero(int[] list, int pos){
		for(int i = pos; i < (list.length); i++){
			if(list[i] == 0) return i;
		}
		return -1;
	}
	
	// Modifies the array without return type
	public static void setZeroes(int[] list, int pos1, int pos2){
		for(int i = (pos1 + 1); i < pos2; i++){
			list[i] = 0;
		}
	}
	
	public static void printArray(int[] list){
		for(int i = 0; i < (list.length); i++){
			System.out.print((list[i]) + " ");
		}
	}
	
	public static void main(String[] args) {
		
		// Variable Declarations & Object Instatiations
		
		int size;
		int pos1;
		int pos2;
		Scanner reader = new Scanner(System.in);
		
		// User Input
		
		System.out.print("Enter a length for the array: ");
		size = reader.nextInt();
		
		// Changing the Zeroes and Printing
		
		int[] trueList = new int[size];
		genList(trueList);
		pos1 = findZero(trueList, 0);
		pos2 = findZero(trueList, (pos1 + 1));
		System.out.print("This is the original array: ");
		printArray(trueList);
		setZeroes(trueList, pos1, pos2);
		System.out.print("\nThis is the modified array: ");
		printArray(trueList);
	}

}
