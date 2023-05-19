package SetOne;

import java.util.Arrays;

public class PrintAllPairsWithAGivenDifference_9 {

	public static void printAllPairsWithAGivenDifference(int[] array,int value) {

		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]-array[j]==value || array[j]-array[i]==value) {
					System.out.println("Pairs found ("+array[i]+","+array[j]+")");
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 2, 2, 5, 5, 4 };
		int k=3;
		int[] temp=Arrays.stream(array).distinct().toArray();
		printAllPairsWithAGivenDifference(temp,k);

	}

}
