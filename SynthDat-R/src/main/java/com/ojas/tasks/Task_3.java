package com.ojas.tasks;

import java.util.Scanner;

public class Task_3 {
	
	public static void test(String prefix, int length) {
		if (length == 0) {
			System.out.println(prefix);
			return ;
		}

		for (char ch = 'a'; ch <= 'z'; ch++) {
			test(prefix + ch, length - 1);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of rounds : ");
		int number = sc.nextInt();
		

		for (int i = 1; i <= number; i++) {
			test(" ", i);
		}
	}
}
