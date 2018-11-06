/* Java program for Merge Sort */

import java.util.Arrays;

class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(int arr[], int l, int m, int r) {
	//System.out.println("\n-- NEW MERGE --\nl=" + l + " m=" + m + " r=" + r);
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
	//System.out.println("Sub-array sizes: " + n1 + ", " + n2);

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; i++) {
            L[i] = arr[l+i];
	    //L[i] = arr[l];
        }
        for (int j=0; j<n2; j++) {
            R[j] = arr[m+1+j];
	    //R[j] = arr[m+j];
        }
	
	//System.out.println("Merging L[]=" + Arrays.toString(L) + " and R[]=" + Arrays.toString(R) + " from " + Arrays.toString(arr));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        //int k = l-1;
	int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
		//System.out.println("Took " + arr[k] + " from left array.");
            }
            else {
                arr[k] = R[j];
                j++;
		//System.out.println("Took " + arr[k] + " from right array.");
            }
            k++;
        }	

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
	    //System.out.println("Took " + arr[k] + " from left array.");
	    k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
	    //System.out.println("Took " + arr[k] + " from right array.");
	    k++;
        }

	//System.out.println("New array: " + Arrays.toString(Arrays.copyOfRange(arr, k, r)));
	//System.out.println("New array: " + Arrays.toString(arr));
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
            int arr[] = {12, 11, 13, 5, 6, 7};
            if( args.length > 0 ) {
                arr = new int[args.length];
                for( int i=0; i<args.length; i++ ) {
                    arr[i] = Integer.parseInt(args[i]);
                }
            }

            System.out.println("Given array:");
            printArray(arr);

            MergeSort.sort(arr, 0, arr.length-1);

            System.out.println("\nSorted array:");
            printArray(arr);
    }
}

