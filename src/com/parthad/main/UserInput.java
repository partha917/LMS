package com.parthad.main;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {

	public static Scanner sc = new Scanner(System.in);
	public static String s = "";

	public static void issueBookInput() throws ClassNotFoundException, SQLException {
		do {
			System.out.print("Enter Book id: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setIdBook(Integer.parseInt(s));

		do {
			System.out.print("Enter Student id: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setId_stu(Integer.parseInt(s));

		do {
			System.out.print("Enter return date: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkDate(s));
		Book.setReturn_date(s);

		Librarian.issueBook();
	}

	public static void submitBookInput() throws ClassNotFoundException, SQLException {

		do {
			System.out.print("Enter Book ID: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setIdBook(Integer.parseInt(s));

		do {
			System.out.print("Enter Student ID: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		AddUser.setId_stu(Integer.parseInt(s));

		Librarian.submitBook();
	}

	public static void updateBookInput() throws ClassNotFoundException, SQLException {

		do {
			System.out.print("Enter Book id: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setIdBook(Integer.parseInt(s));

		int oldBookID = Book.bookDetailsByID();
		UserInput.inputBook();
		Book.updateBookDetails(oldBookID);
	}

	public static void updateStudentInfoInput(String user) throws ClassNotFoundException, SQLException {
		if (user.equals("lib")) {
			do {
				System.out.print("Enter id: ");
				s = sc.nextLine().toUpperCase();
			} while (!CheckInput.checkNo(s));
			AddUser.setId_stu(Integer.parseInt(s));
		}
		UserInput.inputStudent();
		Student.updateStudenInfo();
	}

	public static void updateLibrarianInfoInput(String user) throws ClassNotFoundException, SQLException {
		if (user.equals("admin")) {
			do {
				System.out.print("Enter librarian id: ");
				s = sc.nextLine().toUpperCase();
			} while (!CheckInput.checkNo(s));
			AddUser.setIdLib(Integer.parseInt(s));
		}
		UserInput.inputLibrarian();
		Librarian.updateLibrarianInfo();
	}

	public static void addBookInput() throws ClassNotFoundException, SQLException {
		UserInput.inputBook();
		Book.addBook();
	}

	public static void addStudentInput() throws ClassNotFoundException, SQLException {
		do {
			System.out.print("Enter id: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		AddUser.setId_stu(Integer.parseInt(s));
		UserInput.inputStudent();
		AddUser.addStudent();
	}

	public static void addLibrarianInput() throws ClassNotFoundException, SQLException {
		do {
			System.out.print("Enter librarian id: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		AddUser.setIdLib(Integer.parseInt(s));
		UserInput.inputLibrarian();
		AddUser.addLibrarian();
	}

	public static void inputStudent() {
		do {
			System.out.print("Enter first name: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		AddUser.setFirstname(s);

		do {
			System.out.print("Enter last name: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		AddUser.setLastname(s);

		do {
			System.out.print("Enter dept: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		AddUser.setDept(s);

		do {
			System.out.print("Enter contact no: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		AddUser.setContactNo(s);

		System.out.print("Enter email: ");
		s = sc.nextLine().toUpperCase();
		AddUser.setEmail(s);

		System.out.print("Enter username: ");
		s = sc.nextLine().toUpperCase();
		AddUser.setUsername(s);
	}

	public static void inputLibrarian() {

		do {
			System.out.print("Enter librarian first name: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		AddUser.setFirstname(s);

		do {
			System.out.print("Enter librarian last name: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		AddUser.setLastname(s);

		do {
			System.out.print("Enter joining date(YYYY-MM-DD): ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkDate(s));
		AddUser.setJoiningDate(s);

		do {
			System.out.print("Enter city:");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		AddUser.setCity(s);

		do {
			System.out.print("Enter contact no: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		AddUser.setContactNo(s);

		System.out.print("Enter email: ");
		s = sc.nextLine().toUpperCase();
		AddUser.setEmail(s);

		System.out.print("Enter username: ");
		s = sc.nextLine().toUpperCase();
		AddUser.setUsername(s);

	}

	public static void inputBook() {
		do {
			System.out.print("Enter Book id: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setIdBook(Integer.parseInt(s));

		System.out.print("Enter Book name: ");
		s = sc.nextLine().toUpperCase();
		Book.setBookName(s);

		do {
			System.out.print("Enter Author name: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		Book.setAuthor(s);

		do {
			System.out.print("Enter Category: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkName(s));
		Book.setCategory(s);

		System.out.print("Enter Shelf: ");
		s = sc.nextLine().toUpperCase();
		Book.setShelf(s);

		do {
			System.out.print("Enter Qty.: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setQty(Integer.parseInt(s));

		do {
			System.out.print("Enter Price.: ");
			s = sc.nextLine().toUpperCase();
		} while (!CheckInput.checkNo(s));
		Book.setPrice(Integer.parseInt(s));
	}

	public static void updatePasswordInput(String user) throws ClassNotFoundException, SQLException {
		System.out.println("Enter id: ");
		System.out.println("Enter username: ");
		System.out.println("Enter old password: ");
		System.out.println("Enter new password: ");
		System.out.println("Verify new password: ");

	}

}
