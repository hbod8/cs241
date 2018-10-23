/**
InsertionSort is a simple class that implments insertion sort for testing by the TestInsertionSort class.

@author Harry Saliba
@since 23-Oct-18
*/
public class InsertionSort {
	/**
	Returns sorted array in acending order using insertion sort method.
	
	@param arr Array to be sorted.
	@return int[] Sorted array.
	*/
	public int[] insertionSort(int[] arr) {
		int[] sorted = new int[arr.legth];
		System.arraycopy(arr, 0, sorted, 0, arr.length);
		for (int i = 1; i < sorted.length; i++) {
			int j = i;
			while (j > 0 && sorted[j-1] > sorted[j]) {
				int t = sorted[j]
				sorted[j] = sorted[j-1];
				sorted[j-1] = t;
				j--;
			}
		}
	}
}
