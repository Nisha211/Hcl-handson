package org.hcl;

import java.util.Scanner;

public class Power {
	static int power(String first_string, String second_string) {
		int sum = 0;
		int length1 = Integer.parseInt(first_string);
		int length2 = Integer.parseInt(second_string);

		while (length1 > 0 && length2 > 0) {
			int number1 = length1 % 10;
			int number2 = length2 % 10;
			sum = (int) (sum + Math.pow(number1, number2));
			length1 = length1 / 10;
			length2 = length2 / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string1");
		String first_string = sc.nextLine();
		System.out.println("Enter the string2");
		String second_string = sc.nextLine();
		System.out.println("The solution is " + power(first_string, second_string));

	}

}
