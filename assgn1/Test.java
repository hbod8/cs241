import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] value = {15, 23, 58, 19, 90};
		int[] digit = {5, 3, 8, 9, 0};
		CountingSorter cs = new CountingSorter(9);
		cs.sort(value, digit);
		System.out.println(Arrays.toString(value));
	}
}
