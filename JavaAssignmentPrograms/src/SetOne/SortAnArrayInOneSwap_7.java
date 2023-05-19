package SetOne;

import java.util.Arrays;

public class SortAnArrayInOneSwap_7 {

	public static int[] SortAnArrayInOneSwap(int[] array) {

		int len = array.length;
		int index = 0, temp = 0;
		for (int i = 0; i < len; i++) {
			if(i==1) {
				temp = array[i+3];				
				array[i+3] = array[i];
				array[i] = temp;
			}
		}
//		for(int value:array) {
//			System.out.print(value);
//		}
		return array;
	}

	public static void main(String[] args) {

		int[] array = { 3, 8, 6, 7, 5, 9 };
		System.out.println(Arrays.toString(SortAnArrayInOneSwap(array)));
	}
}
