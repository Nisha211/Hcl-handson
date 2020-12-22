package org.hcl;

import java.util.Scanner;

public class Reusable {
	public static boolean reusableMethod(String value) {
		boolean reusable = false;
		long input;
		long reusableValue = 0;
		long n = value.length();
		for (int i = 0; i < n; i++)
			reusableValue = reusableValue * 10 + ((long) value.charAt(i) - 48);
		while (reusableValue > 0) {
			input = 0;
			int checkValue = (int) (reusableValue % 10);
			if (checkValue != 8) {
				for (input = 1; input <= 9; input++) {
					if (checkValue == input) {
						reusable = true;
					}
				}
			} else {
				reusable = false;
				break;
			}
			reusableValue = reusableValue / 10;

		}
		return reusable;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the reusable value");
		String value = sc.nextLine();
		if (reusableMethod(value)) {
			System.out.println("Yes ,the value is Reusable value");
		} else {
			System.out.println("No,the value is not a Reusable value");
		}
	}
}
