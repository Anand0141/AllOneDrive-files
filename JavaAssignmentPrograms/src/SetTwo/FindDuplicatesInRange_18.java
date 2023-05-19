package SetTwo;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInRange_18 {

	public static boolean findDuplicatesInRange(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				if (i - map.get(arr[i]) <= k) {
					return true;
				}
				map.put(arr[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = { 5, 6, 8, 2, 4, 6, 9 };
		int k = 6;

		if (findDuplicatesInRange(array, k)) {
			System.out.println("Duplicates found");
		} else {
			System.out.println("No duplicates were found");
		}
	}
}
