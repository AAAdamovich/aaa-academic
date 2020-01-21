/* Anton Adamovich
 * QuickSort.java for Assignment 2 - "Analysis of Common Sorting Algorithms"
 * Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
 *  Originally written for Prof. Charles Herbert's CSCI-112 class at CCP
 * Created: 3-2-2017 - Last Edited: 9-27-2017
 *  Edited 9-27-2017 - Added implementation of "Sort" interface
 * Description: An implementation of "QuickSort" using the Sort interface. 
 *  Pivot is selected from the middle of the array to be sorted
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
 *  Sort implementation courtesy of:
 *  Charles Herbert's "QuickSortDemo" - cherbert@ccp.edu
*/

package sortbenchmarking;

public class QuickSort implements Sort{

    public QuickSort(){}
    
    // This method performs quicksort partitioning on a set of elements in an array.
    private static int partition(int[] a, int startIndex, int endIndex) {

        int pivotIndex;             // the index of the chosen pivot element
        int pivot;                  // the value of the chosen pivot
        int midIndex = startIndex;  // boundary element between high and low sets

        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];

        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);

        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            // if a[i] is less than the pivot
            if (a[i] < pivot) {

                // put a[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;
            } // end if
        } // end for 

        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);

        // return index of pivot
        return midIndex;

    } // end partition
    //************************************************************************

    // This method swaps two elements in an integer array
    private static void swap(int[] a, int first, int second) {

        int c;  // a catalyst variable used for the swap

        c = a[first];
        a[first] = a[second];
        a[second] = c;

    } // end Swap()
    //************************************************************************

    private static void QuickSort(int[] a, int startIndex, int endIndex) {
        int pivotIndex;      // the index of pivot returned by the quicksort partition

        // if the set has more than one element, then partition
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex);
            // quicksort the low set
            QuickSort(a, startIndex, pivotIndex - 1);
            // quiclsort the high set
            QuickSort(a, pivotIndex + 1, endIndex);
        } // end if
    } // end runSortIndexed()
    
    public static void runSort(int[] array){
        QuickSort(array, 0, (array.length - 1));
    }
}