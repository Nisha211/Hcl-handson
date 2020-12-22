package org.hcl;

import java.util.Scanner;

public class SuperUser {
	public static boolean userDetails(String userId, String userCode, String userPin) {
		boolean flag = false;
		int sum = 0;
		if (userId.startsWith("SU")) {
			int userCodeValue = Integer.parseInt(userCode);

			if (userCodeMethod(userCodeValue)) {
				if (userPinMethod(userCode, userPin)) {
					flag = true;
				}

			}

		}
		return flag;
	}

	public static boolean userPinMethod(String userCode, String userPin) {
		boolean checkUser = false;
		int tempValue = 0;
		int userCodeValue = Integer.parseInt(userCode);
		int userPinValue = Integer.parseInt(userPin);
		while (userPinValue > 0) {
			tempValue = userCodeValue;
			int pinValue = userPinValue % 10;
			while (tempValue > 0) {
				int codeValue = userCodeValue % 10;
				if (codeValue == pinValue) {
					checkUser = true;
				}
				tempValue = tempValue / 10;
				break;
			}
			userPinValue = userPinValue / 10;
		}
		return checkUser;
	}

	public static boolean userCodeMethod(int userCodeValue) {
		int sum = 0, total = 0, temp = 0;
		boolean check = false, value = false;
		temp = userCodeValue;
		while (temp > 0) {
			int number = temp % 10;
			sum = sum + number;
			temp = temp / 10;
		}
		while (sum > 0) {
			int sumNumber = sum % 10;
			total = total + sumNumber;
			sum = sum / 10;
		}

		if (total == 9) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the userId");
		String userId = sc.nextLine();
		System.out.println("Enter the userCode");
		String userCode = sc.nextLine();
		System.out.println("Enter the userPin");
		String userPin = sc.nextLine();
		if (userDetails(userId, userCode, userPin)) {
			System.out.println("Yes ,The user is super user");
		} else {
			System.out.println("No,The user is not a superuser");
		}

	}

}
