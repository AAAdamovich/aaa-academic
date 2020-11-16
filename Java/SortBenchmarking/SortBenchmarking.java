/* Anton Adamovich
 * SortBenchmarking.java for Assignment 2 - "Analysis of Common Sorting Algorithms"
 * Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
 *  Originally written for Prof. Charles Herbert's CSCI-112 class at CCP
 * Created: 3-2-2017 - Last Edited: 9-29-2017
 *  Edited 9-27-2017 - Modified program structure to ask for user input
 *  concerning test parameters
 * Description: A benchmarking enviornment that tests and times various sorting
 *  algorithims on a test array of randomly generated integers. 
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package sortbenchmarking;

import java.io.IOException;
import java.util.Scanner;

public class SortBenchmarking {

    public static void main(String[] args) throws IOException{
        
        // The range of numbers (between 1, inclusive, and this number, inclusive)
        // that could occur as elements in the randomly generated arrays
        final int ELEMENT_SIZE = 1000;
        
        // How large (how many elements) the arrays will be
        int dataSize = 0;
        // How many times the program will run
        int trials = 1;
        // User-inputted number that dictates what sort the program will use
        int sortSelector = 0;
        // Variables for running time caculations
        long startTime = 0;
        long endTime = 0;
        long duration = 0;
        // The longest time a sort ran, in seconds
        double maxTime = 0;
        // The fastest time a sort ran, in seconds
        double minTime = Double.MAX_VALUE;
        // The average time a sort ran, running "trials" times
        double average = 0;
        // A duration a sort ran, in seconds
        double durationSeconds = 0;

        Scanner reader = new Scanner(System.in);
        
        System.out.println("Please enter a size for the test array: ");
        dataSize = reader.nextInt();
        
        System.out.println("Please enter the amount of times you would like the sort to run: ");
        trials = reader.nextInt();
        // Slection menu for which sort to run
        System.out.println("Please designate the sorting algorithim you would like the program to use: ");
        System.out.println("Enter \"1\" for BubbleSort ");
        System.out.println("Enter \"2\" for SelectionSort ");
        System.out.println("Enter \"3\" for InsertionSort ");
        System.out.println("Enter \"4\" for QuickSort ");
        System.out.println("Enter \"5\" for MergeSort ");
        sortSelector = reader.nextInt();
        // Print sorting results header and begin running sort(s)
        System.out.println();
        System.out.println("Trial Running times (in seconds): ");
        
        int[] original = new int[dataSize];
        int[] sortingArray = new int[dataSize];
        
        // This loop controls the amount of times a sorting algorithim will run
        for(int i = 1; i <= trials; i++){
            // Start by generating test array
            for(int j = 0; j < dataSize; j++){
            original[j] = (int)((Math.random() * ELEMENT_SIZE) + 1);
            }
            // Copy the original to a working array
            for(int j = 0; j < dataSize; j++){
                sortingArray[j] = original[j];
            }
            // Start the "timer"
            startTime = System.nanoTime();
            // Run whatever sort the user selected, BubbleSort is default
            switch(sortSelector){
            case 1:
                BubbleSort.runSort(sortingArray);
                break;
            case 2:
                SelectionSort.runSort(sortingArray);
                break;
            case 3:
                InsertionSort.runSort(sortingArray);
                break;
            case 4:
                QuickSort.runSort(sortingArray);
                break;
            case 5:
                MergeSort.runSort(sortingArray);
                break;
            default:
                BubbleSort.runSort(sortingArray);
                break;
            }
            // End the "timer"
            endTime = System.nanoTime();
            // Generate the program's running duration
            duration = endTime - startTime;
            // Convert running time to seconds
            durationSeconds = ((double)duration / 1000000000.0);
            // Print the duration (to file)
            System.out.println(durationSeconds);
            // Update min/max running times
            if(durationSeconds < minTime){
                minTime = durationSeconds;
            }
            if(durationSeconds > maxTime){
                maxTime = durationSeconds;
            }
            // Add latest trial to running average
            average += durationSeconds;
        }
        // After trials conclude, the average running time has to be calculated
        average /= ((double)trials);
        
        System.out.println("\nAfter running your selected sort " + trials + " times: ");
        System.out.println("The slowest sort took " + maxTime + " seconds, ");
        System.out.println("the fastest sort took " + minTime + " seconds, ");
        System.out.println("and the average running time was " + average + " seconds. ");
        
        // Left this in for testing the sorting algorithims themselves
        /*
        System.out.println();
        for(int element : original){
            System.out.println(element);
        }
        System.out.println();
        for(int element : sortingArray){
            System.out.println(element);
        }
        */
    }
}
