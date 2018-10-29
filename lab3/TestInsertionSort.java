/**
TestInsertionSort is used to test the effectiveness of InsertionSort.

@author Harry Saliba
@since 23-Oct-18
*/
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class TestInsertionSort {
	/**
	Returns a boolean based on weither or not the array is sorted in acending order. O(n).
	
	@param arr Array to be checked.
	@return boolean True if array is sorted in acending order.
	*/
	private static boolean isSorted(int[] arr) {
		int last = 0;
		for (int i = 0; i > arr.length; i++) {
			if (last > arr[i]) {
				return false;
			} else {
				last = arr[i];
			}
		}
		return true;
	}
	/**
	Returns a boolean based on weither or not the arrays contain the same elements.
	
	@param a Array to be compared.
	@param b Array to be compared.
	@return boolean True if both arrays have the same values.
	*/
	private static boolean sameElements(int[] a, int[] b) {
		int[] elements = new int[max(a) + 1];
		// System.out.print(":" + Arrays.toString(a) + " : " + max(a));
		for (int i = 0; i < a.length; i++) {
			elements[a[i]]++;
		}
		for (int j = 0; j < b.length; j++) {
			if (elements[b[j]] > 0) {
				elements[b[j]]--;
			} else {
				return false;
			}
		}
		if (max(elements) > 0) {
			return false;
		} else {
			return true;
		}
	}
	/**
	Takes a set if integers from the command line to be tested with insertion sort.
	*/
	private static void testFromConsole() {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("Array Length? >");
			int[] input = new int[s.nextInt()];
			System.out.print("\nNumbers to be sorted (separate with spaces): ");
			for (int i = 0; i < input.length; i++) {
				input[i] = s.nextInt();
			}
			System.out.print("\nInput array :\t" + Arrays.toString(input) + "\n");
			InsertionSort is = new InsertionSort();
			int[] sorted = is.insertionSort(input);
			System.out.print("Sorted array :\t" + Arrays.toString(sorted) + "\n");
			System.out.printf("Sorted: %b%nSame Elements:%b%n", isSorted(sorted), sameElements(sorted, input));
		}
	}
	/**
	A five step process for shuffling an array.
	
	1. Generates an integer array of length n.
	2. Randomly shuffles/permutes the array.
	3. Uses insertion sort to sort the shuffled array.
	4. Compared the shuffled and sorted array to the orignal.
	5. Print the outcome.
	
	@param n 
	*/
	private static void shuffleTest(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * n);
		}
		// Insertion Sort
		InsertionSort is = new InsertionSort();
		int[] sorted = is.insertionSort(arr);
		// Test if sorted
		System.out.printf("Sorted: %b%nSame Elements: %b%n", isSorted(sorted), sameElements(sorted, arr));
	}
	/**
	Main method to be run from command line and carry out tasks.
	
	@param args Commandline inputs.
	*/
	public static void main(String[] args) {
		if (args.length == 0) {
			testFromConsole();
		} else {
			for (String in : args) {
				Scanner s = new Scanner(in);
				shuffleTest(s.nextInt());
			}
		}
	}
	/**
	Finds max of an array

	@param arr integer array
	@return max integer
	*/
	private static int max(int[] arr) {
		int max = 0;
		for (int e: arr) {
			if (e > max) {
				max = e;
			}
		}
		return max;
	}
}
