// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// 9-19-2013
// Sorting Lab v2

// Code for this sort is stock
// Code was obtained from class text: Fundamentals of Java
public class MergeSort implements Sort{

	private Statistics stats;
	
	public MergeSort(){
		stats = new Statistics();
	}
	
	public Statistics getStats(){
		return stats;
	}
	
	public int[] runSort(int[] array, int runTimes){
		int[] copyBuffer = new int[0];
		int[] mergeCopyBuffer = new int[array.length];
		// Print name of sort
		System.out.println("Merge Sort: ");
		for(int i = 1; i <= runTimes; i++){
			copyBuffer = ArrayUtility.copy(array);
			stats.getTimer().start();
			mergeSortHelper(copyBuffer, mergeCopyBuffer, 0, (copyBuffer.length - 1));
			stats.getTimer().stop();
			stats.updateTimer();
		}
		return copyBuffer;
	}
	
	private void mergeSortHelper(int[] array, int[] mergeCopyBuffer, int low, int high){
		stats.addCompares();
		if(low < high){
			int middle = ((low + high) / 2);
			mergeSortHelper(array, mergeCopyBuffer, low, middle);
			mergeSortHelper(array, mergeCopyBuffer, (middle + 1), high);
			merge(array, mergeCopyBuffer, low, middle, high);
		}
	}
	
	private void merge(int[] array, int[] mergeCopyBuffer, int low, int middle, int high){
		int i1 = low;
		int i2 = (middle + 1);
		for(int i = low; i <= high; i++){
			stats.addCompares();
			if(i1 > middle){
				stats.addSwaps();
				mergeCopyBuffer[i] = array[i2++];
			}
			else{
				stats.addCompares();
				if(i2 > high){
					stats.addSwaps();
					mergeCopyBuffer[i] = array[i1++];
				}
				else{
					stats.addCompares();
					if(array[i1] < array[i2]){
						stats.addSwaps();
						mergeCopyBuffer[i] = array[i1++];
					}
					else{
						stats.addSwaps();
						mergeCopyBuffer[i] = array[i2++];
					}
				}
			}
		}
		for(int u = low; u <= high; u++){
			stats.addSwaps();
			array[u] = mergeCopyBuffer[u];
		}
	}
}
