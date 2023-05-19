package SetOne;

import java.util.Arrays;

public class MoveAllOneToLast_2 {
	
	
	public static void moveAllOneToLast(int[] array)
	{
		int[] temp=new int[array.length];
		int length=array.length-1;
		int k=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]==1) {
				temp[k]=array[i];
				k++;
			}
			else {
				temp[length]=array[i];
				length--;
			}
		}
		System.out.println(Arrays.toString(temp));

	}
		
	public static void main(String[] args) {
		
		int[] array= {1, 0, 1, 0, 1, 0, 0, 1};
		moveAllOneToLast(array);
		
	}

}
