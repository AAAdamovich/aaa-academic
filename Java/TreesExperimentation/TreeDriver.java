// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 10/22/13
// Trees Experimentation

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TreeDriver{
	
	private static void printObjectArray(ArrayList<Object> list){
		if(!(list.isEmpty())){
			if(list.get(0) instanceof Integer){
				for(Object value : list){
					System.out.print((((Integer)value).intValue()) + " ");
				}
				// For spacing
				System.out.println();
			}
			if(list.get(0) instanceof String){
				for(Object value : list){
					System.out.print(((String)value) + " ");
				}
				// For spacing
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args){
		Random generator = new Random();
		BinaryTree tree = new BinaryTree();
		Integer a;
		System.out.println("-- Tree Stuff --\n");
		System.out.println("Original Array: ");
		for(int i = 0; i < 10; i++){
			a = new Integer(generator.nextInt(10));
			tree.add(a);
			System.out.print((a.intValue()) + " ");
		}
		System.out.println("\n\nTree printed out with preOrder: ");
		printObjectArray(tree.preOrder());
		System.out.println("\nTree printed out with inOrder: ");
		printObjectArray(tree.inOrder());
		System.out.println("\nTree printed out with postOrder: ");
		printObjectArray(tree.postOrder());
		
		
		System.out.println("\n-- Binary Expression Tree printouts --\n");
		boolean isPrefix = true;
		int intType;
		String expression;
		Scanner sReader = new Scanner(System.in);
		Scanner gReader = new Scanner(System.in);
		System.out.print("What type of expression would you like to input? Enter 1 for preFix and 2 for postFix: ");
		intType = gReader.nextInt();
		System.out.print("Please enter an expression, separated with spaces: ");
		expression = sReader.nextLine();
		if(intType == 2) isPrefix = false;
		BinaryExpressionTree eTree = new BinaryExpressionTree(expression, isPrefix);
		System.out.println("\nExpression input:\n" + expression);
		System.out.println("\npreOrder: ");
		printObjectArray(eTree.preOrder());
		System.out.println("\ninOrder: ");
		printObjectArray(eTree.inOrder());
		System.out.println("\npostOrder: ");
		printObjectArray(eTree.postOrder());
	}
}
