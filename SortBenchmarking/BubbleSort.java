/* Anton Adamovich
 * BubbleSort.java for Assignment 2 - "Analysis of Common Sorting Algorithms"
 * Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
 * Created: 9-29-2017 - Last Edited: 9-29-2017
 * Description: An implementation of "Bubble Sort" using the Sort interface
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package sortbenchmarking;

public class BubbleSort implements Sort{
    
    private static void swap(int[] array, int index1, int index2){
        int temp = 0;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public static void runSort(int[] array){
        for(int i = array.length - 1; i > 1 ; i--){
            for(int j = 0; j < i; j++){
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                }
            }
        }
    }  
}
