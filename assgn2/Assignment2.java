/*
	Assignment2.java
	
	David Bover, Tanzima Z Islam
	
	File with main() method for CSCI 241 Assignment 2
	
	Gets words from a file and adds them to a hash table
	to keep a count of the number of occurrences of each word.
	
	Relies on a HashTable class with instance methods:
		add(word)
		delete(word)
		highcount()
        get_avg_successful_search()
        get_avg_unsuccessful_search()
*/	
	
	
import java.io.*;
import java.util.*;

public class Assignment2 {

	public static void addWords(String filename, HashTable table) {
		// System.out.println("Hello world");	
		// open the file
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(filename));
		}
		catch (Exception e) {
			System.out.println("Cannot open file " + filename);
			return;
		}

		// read each line of the file
		String line = "";
		try {
			line = in.readLine();
		}
		catch (Exception e) {
			System.out.println("I/O error: " + e);
		}	
		while (line != null) {
			
			// tokenize the line
			String delimiters = " ,;.!@#$%^&*()_+-=<>?[]{}:\"'";
			StringTokenizer tokenizer 
				= new StringTokenizer(line, delimiters);

			// add each word to the hash table
			while (tokenizer.hasMoreTokens()) {
				String word = tokenizer.nextToken();
				//stem.out.println("adding " + word);
				table.add(word);
			}
			
			// get the next line from the file
			try {
				line = in.readLine();
			}		
			catch (Exception e) {
				System.out.println("I/O error: " + e);
			}	
		}
	}
	
	public static void main(String[] args) {
	
		// first command-line argument should be 
		// an integer, the number of words to display
		
		int howmany;
		try {
			howmany = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Usage: java Assignment2 n file ...");
			return;
		}
		
		// create the hash table
		HashTable table = new HashTable();
		
		// for each file specified in a command-line argument
		// extract each word and add it to the hash table
		for (int file = 1; file < args.length; file++){
			addWords(args[file], table);
        	}
        	System.out.println("Average number of successful probes: " + table.get_avg_successful_search());
        	System.out.println("Average number of unsuccessful probes: " + table.get_avg_unsuccessful_search());		
		// display the top howmany words
		for (int i = 1; i <= howmany; i++) {
			DataItem data = table.highcount();
			if (data == null) return;
			System.out.println(data.word + ": " + data.count);
			
			// and then delete the word from the hash table
			table.delete(data.word);
            
		}
        System.out.println("Average number of successful probes: " + table.get_avg_successful_search());
        System.out.println("Average number of unsuccessful probes: " + table.get_avg_unsuccessful_search());
	}

}
