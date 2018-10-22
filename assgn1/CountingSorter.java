/*
Jax Rounds and Harry Saliba
10/17/18
This is a counting sort class to be used in conjuction with a radix sorter.
*/
import java.util.Arrays;
public class CountingSorter {
	public CountingSorter(int biggest) {
		this.biggest = biggest;
	}
	private final int biggest;
	public void sort(int[] value, int[] digit) {
		//murphys law test
		if (digit.length != value.length) {
			System.out.println("one of your numbers dosent exisit, consider making it exsist");
			System.exit(1);
		}
		int[] numbers = new int[biggest + 1];
		for (int i : digit) {
			numbers[i]++;
		}

		//prefix sum
		int previousElements = 0, c;
		for (int i = 0; i < numbers.length; i++) {
			c = numbers[i];
			previousElements += c;
			numbers[i] = previousElements;
		}
		
		//create sorted array
		int[] output = new int[digit.length];
		for (int i = output.length - 1; i >= 0; i--) {
			int indexOfDig = digit[i];
			int newIndex = numbers[indexOfDig];
			output[newIndex - 1] = value[i];
			//output[numbers[digit[i]]] = value[i];
			numbers[digit[i]]--;
		}
		//System.out.println("cs:value" + Arrays.toString(value));
		//System.out.println("cs:" + Arrays.toString(output));
		System.arraycopy(output, 0, value, 0, output.length);
	}
}
