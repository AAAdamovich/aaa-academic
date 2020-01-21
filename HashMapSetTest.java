// Anton Adamovich
// Advanced Topics in Computer Science Honors
// Mr. Meistering
// 1/12/14
// Hash-Map-Set Experimentation

import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.util.Random;

public class HashMapSetTest {

	public static void main(String[] args){
		System.out.println("This program will create a map of peoples' names and their ID numbers.");
		System.out.println("The keys will be the ID numbers and the values will be the names.");
		System.out.println("Every ID number will be a random number between 100 and 200, inclusive.");
		System.out.println("Afterward the ID numbers will be copied onto a hashset.");
		System.out.println("The names will likewise be copied and printed out.");
		Random generator = new Random();
		// Numbers and names are parallel arrays
		String[] names = {"Ray", "Gavin", "Michael", "Ryan", "Geoff"};
		Integer[] numbers = new Integer[5];
		for(int i = 0; i < 5; i++){
			numbers[i] = new Integer((generator.nextInt(101) + 100));
		}
		HashMap<Integer, String> identificationMap = new HashMap<Integer, String>();
		for(int i = 0; i < 5; i++){
			// Ensures all five names are included by checking for duplicate ID's
			while(identificationMap.containsKey(numbers[i])) numbers[i] = new Integer((generator.nextInt(101) + 100));
			identificationMap.put(numbers[i], names[i]);
		}
		Set<Integer> identifications = identificationMap.keySet();
		Collection<String> nameIdentifications = identificationMap.values();
		System.out.println("Names: ");
		for(String name : nameIdentifications){
			System.out.print(name + " ");
		}
		System.out.println("\nID Numbers: ");
		for(Integer number : identifications){
			System.out.print(number.intValue() + " ");
		}
	}
}
