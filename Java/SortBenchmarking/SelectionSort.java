/* Anton Adamovich
 * SelectionSort.java for Assignment 2 - "Analysis of Common Sorting Algorithms"
 * Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
 *  Originally written for Prof. Charles Herbert's CSCI-112 class at CCP
 * Created: 3-2-2017 - Last Edited: 9-27-2017
 *  Edited 9-27-2017 - Added implementation of "Sort" interface
 * Description: An implementation of "Selection Sort" using the Sort interface. 
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package sortbenchmarking;

public class SelectionSort implements Sort{
    
    public SelectionSort(){}
    
    public static void runSort(int[] array){
        
        int minIndex = 0;
        int temp = 0;
        
        for(int i = 0; i < array.length; i++){
            minIndex = i;
            for(int j = (i + 1); j < array.length; j++){
                // Z - A returns a positive integer, A - Z is a negative one
                if(array[j] < (array[minIndex])){
                    minIndex = j;
                }
            } // End for j
            // Swap operations, if minimum is already in the correct location, no swap neccessary
            if(minIndex != i){
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            } 
        } // End for i
    } // End method
} // End class
