/*
 * Hash Table that implements separate chaining and occurance counting
 *
 * @author Harry Saliba, Jax Rounds
*/

import java.util.LinkedList;

public class HashTable {
	/*
	 * Constructor that creates an empty table
	*/
	public HashTable() {
		System.out.println("number for happiness is: " + hash("happiness"));
		System.out.println("number for jax is: " + hash("jax"));
		System.out.println("number for jxa is: " + hash("jxa"));
	}
	/*
	 * Adds item to hash table.
	 *
	 * @param word String of word to be added.
	*/
	public void add(String word) {
		
	}
	/*
	 * Deletes item from hash table.
	 *
	 * @param word String of word to be deleted.
	*/
	public void delete(String word) {

	}
	/* 
	 * This method must return the DataItem containing the word with the greatest occurrence count of all the words stored in the hash table.
	*/
	public DataItem highcount() {
		return null;
	}
	/*
	 * This method will compute the average number of comparisons done for searches that were successful and return that value.
	*/
	public double get_avg_successful_search() {
		double success = 0;
		success = .5*(1+(1/(1-11067)));
		return success;
	}
	/*
	 * This method will compute the average number of comparisons done for searches that were unsuccessful and return that value.
	*/
	public double get_avg_unsuccessful_search() {
		return 0.0;
	}
	private LinkedList<DataItem>[] table = new LinkedList[11067];
	private int hash(String s) {
		char[] in = s.toCharArray();
		double key = 1;
		int val;
		for (char c : in) {
			val = (int) c;
			if ((val % 10) <= 3) {
				key *= val;
			} if ((val % 10) > 3 && (val % 10) <= 8) {
				key += val;
			} else {
				key += (3 * val);
			}
			System.out.println(val + " " + key);
		}
		return (int)(key % (double) table.length);

	}
}
