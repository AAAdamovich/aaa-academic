// Anton Adamovich
// Mr. Meistering
// Advanced Topics in Computer Science Honors
// Some time last year
// Sorting Lab v2

// Code for this sort is custom
public class InsertionSort implements Sort{

	private Statistics stats;
	
	public InsertionSort(){
		stats = new Statistics();
	}
	
	public Statistics getStats() {
		return stats;
	}
	
	public int[] runSort(int[] array, int runTimes){
		int[] copyBuffer = new int[0];
		// Print name of sort
		System.out.println("Insertion Sort: ");
		for(int i = 1; i <= runTimes; i++){
			copyBuffer = (ArrayUtility.copy(array));
			stats.getTimer().start();
			for(int u = 1; u < (array.length); u++){
				stats.addCompares();
				if(copyBuffer[u] < copyBuffer[u - 1]){
					copyBuffer = insert(copyBuffer, (findInsertionIndex(copyBuffer, u)), u);
				}
			}
			stats.getTimer().stop();
			stats.updateTimer();
		}
		return copyBuffer;
	}
	
	private int[] insert(int[] array, int insertIndex, int endIndex){
		// endIndex is the index of the number that is to be inserted
		int temp1 = array[insertIndex];
		int temp2;
		array[insertIndex] = array[endIndex];
		stats.addSwaps();
		for(int i = (insertIndex + 1); i <= endIndex; i++){
			temp2 = array[i];
			array[i] = temp1;
			temp1 = temp2;
			stats.addSwaps();
		}
		return array;
	}
	
	private int findInsertionIndex(int[] array, int endIndex){
		// endIndex is the index of the number that is to be inserted
		int insertionIndex = endIndex;
		for(int i = 0; i < endIndex; i++){
			stats.addCompares();
			if(array[endIndex] < array[i]){
				insertionIndex = i;
				return insertionIndex;
			}
		}
		return insertionIndex;
	}
}
