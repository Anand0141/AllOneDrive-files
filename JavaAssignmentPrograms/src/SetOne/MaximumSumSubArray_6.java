package SetOne;

public class MaximumSumSubArray_6 {

	public static void MaximumSumSubArray(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		int s = 0, start = 0, end = 0;
		String sum = "";

		for (int i = 0; i < array.length; i++) {
			curSum = curSum + array[i];
			if (maxSum < curSum) {
				maxSum = curSum;
				start = s;
				end = i;
			} else if (curSum < 0) {
				curSum = 0;
				s = i + 1;
			}
		}
		for (int i = start; i <= end; i++) {
			sum = sum + array[i]+",";
		}
		System.out.print("Subarray with the largest sum is {"+sum+"} with sum "+maxSum);
		// System.out.println(end);
		// System.out.println(array[curSum]);
		//return maxSum;
	}

	public static void main(String[] args) {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		 MaximumSumSubArray(array);
	}
}
