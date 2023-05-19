package SetOne;

import java.util.Arrays;

public class MoveAllZeroToLast_5 {

	public static void moveAllZeroToLast(int[] array) {
		int[] temp = new int[array.length];
		int length = array.length - 1;
		int k = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				temp[k] = array[i];
				k++;
			} else {
				temp[length] = array[i];
				length--;
			}
		}
		System.out.println(Arrays.toString(temp));

	}

	public static void main(String[] args) {

		int[] array = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };
		moveAllZeroToLast(array);

	}
}
