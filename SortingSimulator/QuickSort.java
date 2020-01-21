// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 1-9-2014
// Sorting Lab v2

// Code for this sort is Stock
// Code was obtained at: http://www.mycstutorials.com/articles/sorting/quicksort
public class QuickSort implements Sort {

	private Statistics stats;
	
	public QuickSort(){
		stats = new Statistics();
	}
	
	public Statistics getStats(){
		return stats;
	}
	
	public int[] runSort(int[] array, int runTimes){
		int[] copyBuffer = new int[0];
		// Print name of sort
		System.out.println("Quick Sort: ");
		for(int i = 1; i <= runTimes; i++){
			copyBuffer = (ArrayUtility.copy(array));
			(stats.getTimer()).start();
			quickSort(copyBuffer, 0, ((copyBuffer.length) - 1));
			stats.getTimer().stop();
			stats.updateTimer();
		}
		return copyBuffer;
	}

	public void quickSort(int array[], int start, int end){
		int i = start; 
		int u = end; 
		stats.addCompares();
		if (end - start >= 1){
			int pivot = array[start]; 
			stats.addCompares();
			while (u > i){
				stats.addCompares();
				stats.addCompares();
				while (array[i] <= pivot && i <= end && u > i){
					stats.addCompares();
					i++; 
				}
				stats.addCompares();
				while (array[u] > pivot && u >= start && u >= i){
					stats.addCompares();
					u--; 
				}
				stats.addCompares();
				if (u > i) swap(array, i, u);
			}
			swap(array, start, u); 
			quickSort(array, start, u - 1); 
			quickSort(array, u + 1, end); 
		}
		else return;
	}

	public void swap(int array[], int index1, int index2){
		int temp = array[index1]; 
		array[index1] = array[index2]; 
		array[index2] = temp; 
		stats.addSwaps();
	}
}
