package SetTwo;

import java.util.Arrays;
import java.util.Comparator;

public class FindMaximuSum_13 {

	public static void findMaximumSum(Integer[] arr) {

		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr));

		int x = 0;
		for (int i = 0; i < arr.length; i = i + 2) {
			x = x * 10 + arr[i];
		}
		int y = 0;
		for (int i = 1; i < arr.length; i = i + 2) {
			y = y * 10 + arr[i];
		}
		System.out.println("The two numbers with maximum sum are "
                + x + " and " + y);
	}

	public static void main(String[] args) {

		Integer[] array = { 4, 6, 2, 7, 9, 8 };
		
		findMaximumSum(array);
	}

}
