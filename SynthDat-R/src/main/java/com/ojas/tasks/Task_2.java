package com.ojas.tasks;

import java.util.Scanner;

public class Task_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// char ch = sc.next().charAt(0);

		System.out.print("Enter number of rounds : ");
		int number = sc.nextInt();

		for (int i = 1; i <= number; i++) {

			for (char j = 'a'; j <= 'z'; j++) {
				System.out.println(j);
			}
		}

	}
}
