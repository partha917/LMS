package com.parthad.cnostatnts;

import java.util.Scanner;

public class Demo {

	public Demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] input) {
		String strUpper, strLower = null;
		Scanner scan = new Scanner(System.in);

		int n = 17;
		for (int i = 0; i < n; i++) {
			strUpper = scan.nextLine();
			//strLower = strUpper.toLowerCase();

			System.out.println("asLabel.add("+strUpper+");");
		}

	}
}
/*

usernameLabel
idBookeLabel
returnDateLabel
idStudentLabel
firstNameLabel
lastNameLabel
deptLabel
contactLabel
emailLabel
priceLabel
qtyLabel
authorLabel
bookNameLabel
categoryLabel
shelfLabel

*/