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
		//System.out.println("number for happiness is: " + hash("happiness"));
		//System.out.println("number for jax is: " + hash("jax"));
		//System.out.println("number for jxa is: " + hash("jxa"));
	}
	/*
	 * Adds item to hash table.
	 *
	 * @param word String of word to be added.
	*/
	public void add(String word) {
		word = word.toLowerCase();
		int index = hash(word);
		boolean found = false;
		if (table[index] == null) {
			table[index] = new LinkedList<DataItem>();
			table[index].add(new DataItem(word));
		} else {
			for (int i = 0; i < table[index].size(); i++) {
				if (table[index].get(i).word.equals(word)) {
					table[index].get(i).count++;
					found = true;
				}
			}
			if (!found) {
				table[index].add(new DataItem(word));
			}
		}
	}
	/*
	 * Deletes item from hash table.
	 *
	 * @param word String of word to be deleted.
	*/
	public void delete(String word) {
		word = word.toLowerCase();
		int index = hash(word);
		if (table[index] == null) {
			return;
		} else {
			for (int i = 0; i < table[index].size(); i++) {
				if (table[index].get(i).word.equals(word)) {
					table[index].remove(i);
				}
			}
			return;
		}
	}
	/* 
	 * This method must return the DataItem containing the word with the greatest occurrence count of all the words stored in the hash table.
	*/
	public DataItem highcount() {
		DataItem biggest = new DataItem("");
		biggest.count = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				for (int j = 0; j < table[i].size(); j++) {
					if (table[i].get(j).count > biggest.count) {
						biggest = table[i].get(j);
					}
				}
			}
		}
		return biggest;
	}
	/*
	 * This method will compute the average number of comparisons done for searches that were successful and return that value.
	*/
	public double get_avg_successful_search() {
		double success = 0;
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				count++;
			}
		}
		double load = count/11067.0;
		success = 1 + (load/2);
		return success;
	}
	/*
	 * This method will compute the average number of comparisons done for searches that were unsuccessful and return that value.
	*/
	public double get_avg_unsuccessful_search() {
		//double unsuccess = 0;
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				count++;
			}
		}
		//System.out.println(count + "/" + 11067 + "=" + count/11067);
		double load = count/11067.0;
		return load;
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
			//System.out.println(val + " " + key);
		}
		return (int)(key % (double) table.length);

	}
}
