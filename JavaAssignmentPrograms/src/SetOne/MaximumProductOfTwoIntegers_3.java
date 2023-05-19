package SetOne;

public class MaximumProductOfTwoIntegers_3 {

	public static void maximumProductOfTwoIntegers(int[] array) {

		int max=array[0];
		
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(max<array[i]*array[j]) {
					max=array[i]*array[j];
					System.out.println("The maximum product is the ("+array[i]+" "+array[j]+")");
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { -10, -3, 5, 6, -2 };

		maximumProductOfTwoIntegers(array);
	}
}
