package SetOne;

public class FindtheMinimumDifference_10{

	public static void FindtheMinimumDifference(int[] array, int x, int y) {
		int index1 = 0, index2 = 0, temp = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				index1 = i;
				//System.out.println(index1);
			}
			if (array[i] == y) {
				index2 = i;
				//System.out.println(index2);
			}
			if (index1 - index2 == 2) { 
				temp = index1 - index2;
			}
		}
		System.out.println("Their minimum absolute difference is min ("+index1+"-"+index2 +") = "+ temp);
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 4, 8, 2, 4, 3, 6, 5 };
		int x = 3, y = 2;
		FindtheMinimumDifference(arr, x, y);
	}
}
