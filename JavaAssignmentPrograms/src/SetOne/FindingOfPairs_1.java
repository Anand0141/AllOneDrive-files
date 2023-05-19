package SetOne;

public class FindingOfPairs_1 {

	public static void findingOfPairs(int[] array, int target) {

		int length = array.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (array[i] + array[j] == target) {
					System.out.println("Pair found (" + array[i] + " " + array[j]+")");
				}
			}
		}

	}

	public static void main(String[] args) {

		int[] array = { 8, 7, 2, 5, 3, 1 };

		int target = 10;

		findingOfPairs(array, target);

	}

}
