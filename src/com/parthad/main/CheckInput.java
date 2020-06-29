package com.parthad.main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckInput {

	public static Scanner sc = new Scanner(System.in);

	public static boolean checkDate(String s) {
		String regex = "[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}";
		if (Pattern.matches(regex, s)) {
			String[] date = s.split("-");
			if (checkValidDate(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]))) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkValidDate(int y, int m, int d) {
		int MAX_VALID_YR = 2099;
		int MIN_VALID_YR = 2000;
		if (y > MAX_VALID_YR || y < MIN_VALID_YR)
			return false;
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > 31)
			return false;

		if (m == 2) {
			if (isLeap(y))
				return (d <= 29);
			else
				return (d <= 28);
		}
		if (m == 4 || m == 6 || m == 9 || m == 11)
			return (d <= 30);

		return true;
	}

	static boolean isLeap(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}

	public static boolean checkNo(String no) {
		String regex = "[0-9]+";
		if (Pattern.matches(regex, no)) {
			return true;
		}
		return false;
	}

	public static boolean checkName(String name) {
		String regex = "[a-zA-z]+";
		if (Pattern.matches(regex, name)) {
			return true;
		}
		return false;
	}

}
