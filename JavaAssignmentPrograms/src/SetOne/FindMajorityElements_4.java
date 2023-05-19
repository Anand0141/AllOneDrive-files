package SetOne;

import java.util.Arrays;

public class FindMajorityElements_4 {

	public static void findMajorityElements(int[] array) {

		int count = 1;
		int element = 0;
		int len = array.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (array[i] == array[j]) {
					count++;
					element = array[i];
					break;
				}
			}
		}
		if (count > len / 2) {
			System.out.println("The Majority element is " + element + " in array " + Arrays.toString(array));
		}
	}

	public static void main(String[] args) {
		int[] array = { 2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2 };
		findMajorityElements(array);
	}
}
