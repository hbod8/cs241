/*
Jax Rounds and Harry Saliba
10/17/18
This is a radix style of sorter.
*/
import java.util.Arrays;
public class RadixSorter {
	public void sort(int[] list) {
		CountingSorter sorter = new CountingSorter(9);
		int numOfDigits = String.valueOf(max(list)).length();
		int[] digits = new int[list.length];
		
		for (int i = 1; i <= numOfDigits; i++) {
			for (int j = 0; j < list.length; j++) {
				digits[j] = getDigit(list[j], i);
			}
			
			sorter.sort(list, digits);
		}
		
	}
	//Returns the max amount of digits that need to be dealt with
	private int getDigit(int input, int digit) {
	
		if (digit == 1) {
			return input % 10;
		}
		else {
			if (input == 0) {
				return 0;
			} else {
				return getDigit((input / 10), digit - 1);
			}
		}
	}
	//Returns the largest number from the list given
	private int max(int[] list) {
		int max = 0;
		for (int i : list) {
			if (i > max) max = i;
		}
		return max;
	}
}
