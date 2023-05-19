package com.java8Features;

public class Lambda {

	//frst approch
	public void m1() {
		System.out.println("Normal method");
	}
	
	public static void main(String[] args) {
		new Lambda().m1();
		
		//second approach using anonymous
		Anonymous ano=new Anonymous() {
			public void m2() {
				System.out.println("Using anonymous function");
			}
		};
	
		//third approach using lambda
		Anonymous a=()->System.out.println("using lamda expression");
		ano.m2();
		a.m2();
	}
}
