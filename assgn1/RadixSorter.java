public class RadixSorter {
	public void sort(int[] list) {
		
	}
	private int getDigit(int input, int digit) {
	//digit is the position of the digit from the right of the number.
		if (digit == 1) {
			return input % 10;
		} else {
			if (input == 0) {
				return 0;
			} else {
				getDigit(input / 10, digit--);
			}
		}
	}
}
