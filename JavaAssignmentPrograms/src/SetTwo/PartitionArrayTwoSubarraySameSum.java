package SetTwo;

public class PartitionArrayTwoSubarraySameSum {

	public static int PartitionArrayTwoSubarraySameSum(int[] array) {

		int leftSum = 0, rightSum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				leftSum += array[j];
			}
			for (int j = i; j < array.length; j++) {
				rightSum+=array[j];
			}
			
			if(leftSum==rightSum)
				return i;

		}
		return -1;
	}

	public static void main(String[] args) {

		int[] array = { 6, -4, -3, 2, 3 };

		int i=PartitionArrayTwoSubarraySameSum(array);
		if(i!=-1) {
			
	}
		
	}
}
