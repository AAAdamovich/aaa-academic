// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-19-2013
// Sorting Lab v2

public class SortingDriver{

	public static void main(String[] args){
		// Console Area
		int runTimes = 20;
		int[] array = ArrayUtility.generateArray(20000);
		// Sorting Code
		Sort[] sorts = new Sort[4];
		sorts[0] = new SelectionSort();
		sorts[1] = new InsertionSort();
		sorts[2] = new MergeSort();
		sorts[3] = new QuickSort();
		for(Sort aSort : sorts){
			aSort.runSort(array, runTimes);
			System.out.println("Total compares: " + (aSort.getStats().getCompares()));
			System.out.println("Total swaps: " + (aSort.getStats().getSwaps()));
			System.out.println("Average compares per trial: " + ((aSort.getStats().getCompares()) / ((long)runTimes)));
			System.out.println("Average swaps per trial: " + ((aSort.getStats().getSwaps()) / ((long)runTimes)));
			System.out.println("Average time per trial (in milliseconds): " + (aSort.getStats().getAverageTime()) + "\n");
		}
	}
}
