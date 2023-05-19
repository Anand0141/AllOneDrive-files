package com.java8Features;

public class CalculatorImpl {

//	@Override
//	public void sum(int i, int j) {
//		System.out.println("sum is:"+ (i+j));

	public static void main(String[] args) {
//		CalculatorImpl cal=new CalculatorImpl();
//		cal.sum(10, 20);

		Calculator cal = ( i, j) -> System.out.println(i + j);
		cal.sum(25, 25);
	}

}
