package com.ojas.tasks;

import java.util.Scanner;

public class Tasks_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rounds: ");
		int rounds = scanner.nextInt();
		printSequences(rounds);
	}

	public static void printSequences(int rounds) {
		for (int i = 1; i <= rounds; i++) {
			printSequence(i);
		}
	}
	

	public static void printSequence(int length) {
		StringBuilder sequence = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sequence.append('a');
		}
		while (true) {
			System.out.println(sequence);
			int index = length - 1;
			while (index >= 0 && sequence.charAt(index) == 'z') {
				index--;
			}
			if (index < 0) {
				break;
			}
			char nextChar = (char) (sequence.charAt(index) + 1);
			for (int i = index; i < length; i++) {
				sequence.setCharAt(i, nextChar);
			}
		}

	}
}
