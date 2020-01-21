// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-19-2013
// Sorting Lab v2

// Code for this sort is custom
public class SelectionSort implements Sort{
	
	private Statistics stats;
	
	public SelectionSort(){
		stats = new Statistics();
	}
	
	public Statistics getStats() {
		return stats;
	}

	public int[] runSort(int[] array, int runTimes){
		int[] copyBuffer = new int[0];
		int minIndex;
		// Print name of sort
		System.out.println("Selection Sort: ");
		for(int i = 1; i <= runTimes; i++){
			copyBuffer = (ArrayUtility.copy(array));
			(stats.getTimer()).start();
			for(int u = 0; u < (copyBuffer.length); u++){
				minIndex = (findMinIndex(copyBuffer, u));
				stats.addCompares();
				if(minIndex != u) swap(copyBuffer, u, minIndex);
			}
			stats.getTimer().stop();
			stats.updateTimer();
		}
		return copyBuffer;
	}
	
	private int findMinIndex(int[] array, int startIndex){
		int min = array[startIndex];
		int minIndex = startIndex;
		for(int i = startIndex; i < (array.length); i++){
			stats.addCompares();
			if(array[i] < min){
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private int[] swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		stats.addSwaps();
		return array;
	}
}
