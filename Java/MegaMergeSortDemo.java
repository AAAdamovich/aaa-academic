/* MegaMergeSortDemo.java
 * CSCI 112 Spring 2014 Semester
 * last edited March 21, 2014 by C. Herbert
 * 
 * This application demonstrates mergesort and timing a mergesort that sorts 1 million 
 * randomly generated integers, each up to 5 digits long.
 * 
 * It uses the system function nanoTime() to read the system closk in nanoseconds,
 * once before the sort starts ande once after it ends. It subtracts the end time from
 * the start time to ge the elapsed time in nanoseconds.  This is divided by 1 bilion to
 * gte the time in seconds.
 * 
 * The randomly genertated array is written to a data file before the sort and again after the sort.
 * The sorted list in the file "after.txt" can be visually inspected or otherwise
 * tested for correctness.
 * 
 * This code is written for clarity.  Changes can be made to improve effeciency.
 */
package megamergesortdemo;

import java.io.*;

public class MegaMergeSortDemo {

    public static void main(String[] arg) throws Exception{

        for (int k = 1; k<= 100; k++)
        {
        int size = 1000000;     // change this number to change the size of the random array
        int[] a = new int[size];
        int[] temp = new int[a.length];  // empty temporary array, the same size and type as a[]

        // fill the array with random integers
        for (int i = 0; i< a.length; i++) 
            a[i] = (int)(Math.random()*100000 +1);
        
        // write the array to a data file 
        // WARNING the text file will be 5.7 MB for 1 million items
        //writeLines(a, "before.txt");
        
        // get the start time in nanoseconds
        long startTime = System.nanoTime();

        //call mergesort to sort the entire array
        mergeSort(a, temp, 0, (a.length - 1));

        // get the end time in nanoseconds
        long endTime = System.nanoTime();

        // calculate elapsed time in nanoseconds
        long duration = endTime - startTime;

        // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.printf("%12.8f %n", (double)duration/100000000) ;
        
        // write the sorted array to a data file 
        // WARNING the file will be 5.7 MB for 1 million items
        //writeLines(a, "after.txt");
        }
    }// end main()
    //*******************************************************************

    public static void mergeSort(int[] a, int[] temp, int low, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        
        int mid;  // the middle of the array – last item in low half
        
        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part

            // find middle (last element in low half)   
            mid = (low+high)/2;
            mergeSort(a, temp, low, mid );
            mergeSort(a, temp, mid+1, high);
            
            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if 

        return;
    }// end mergerSort()
    //********************************************************************
    
    
    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     * 
     * The work of sorting occurs as the two halves are merged back into one 
     * sorted set.
     * 
     * This version of mergesort copies the set to be sorted into the same 
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */
    public static void merge(int[] a, int[] temp, int low, int mid, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half
        
        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }

        //set up necessary pointers 
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half)
        while ((lowP <= mid) && (highP <= high)) {

            // if current item in low half <= current item in high half 
            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;
            } else {
                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;
            } // end if..else
            
            // increment pointer for location in original array
            aP++;
        } // end while

        /* When the while loop is done, either the low half or the high half is done 
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid) 
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        else // high half is done, move rest of low half
        
            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for
        
        return;
    } // end merge()
    // *************************************************************

    /* This method writes an int array to a text data file.  
     * The first parameter is the array. The second parameter
     * is the file name.
     */
    public static void writeLines(int[] a, String fileName) throws Exception {
        // create a File class object with the given file name
        java.io.File out = new java.io.File(fileName);
        // Create a PrintWriter output stream and link it to the File object
        java.io.PrintWriter outfile = new java.io.PrintWriter(out);

        // write the elements of an int array, separated by spaces
        for (int i = 0; i < a.length; i++) 
            outfile.print(a[i] + " ");
        
        // print a newline at the end of the list of integers
        outfile.println();

        outfile.close();

    } // end writeTextArray()
    /**
     * **********************************************
     */

} // end class MergeSortDemo
