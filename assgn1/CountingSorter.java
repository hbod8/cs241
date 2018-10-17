public class CountingSorter {
	public CountingSorter(int biggest) {
		numbers = new int[biggest + 1];
	}
	private final int[] numbers;
	public void sort(int[] value, int[] digit) {
		for (int i : digit) {
			numbers[i]++;
		}
		//init sorted array
		int[] output = new int[digit.length];
		//prefix sum
		int previousElements = 0, c;
		for (int i = 0; i < numbers.length; i++) {
			c = numbers[i];
			numbers[i] = previousElements;
			total += c;
		}
		//create sorted array
		int[] output = new int[digit.length];
		for (int i = 0; i < output.length; i++) {
			output[numbers[i]] = x;
			
		}
	}
}
