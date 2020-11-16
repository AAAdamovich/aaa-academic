/* Anton Adamovich
 * SelectionSort.java for Assignment 2 - "Analysis of Common Sorting Algorithms"
 * Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
 * Created: 9-29-2017 - Last Edited: 9-29-2017
 * Description: An implementation of "Insertion Sort" using the Sort interface
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
 *  Logic for this sort came from:
 *  https://www.roseindia.net/java/beginners/arrayexamples/InsertionSort.shtml
*/
package sortbenchmarking;

public class InsertionSort {
    
    public static void runSort(int[] array){
        int j = 0;
        int max = -1;
        
        for(int i = 1; i < array.length; i++){
            j = i;
            max = array[i];
            // Shifting loop moves elements if a number has to be inserted
            while ((j > 0) && (array[j-1] > max)){
               array[j] = array[j-1];
               j--;
            }
        array[j] = max;
        }
    }
    
}
