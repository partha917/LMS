package com.parthad.main;

import java.sql.SQLException;
import java.util.Scanner;

public class LMSMain {

	static Login login = new Login();
	public static Scanner sc = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.println("\n\t\t\t\t\t\t\t\t\t Welcome to LibraryManagement System\n\n");
		System.out.println("Choose the correct option...Press 0 to exit\n\n");

		String choice = "";
		sc = new Scanner(System.in);
		do {
			String[] toPrint = { "1.Librarian Login", "2.Student Login", "3.Admin Login" };
			FormatOP.printDisplayBoard(toPrint);

			choice = sc.next();
			switch (choice) {
			case "1":
				if (logInLibrarian()) {
					librariabDisplayBoard();
				}
				break;

			case "2":
				if (logInStudent()) {
					studentDisplayBoard();
				}
				break;

			case "3":
				
				/*
				 * 
				if (logInAdmin()) {
					adminDisplayBoard();
				}
				
				 */
				
				break;

			}
		} while (!choice.equals("0"));
	}

	public static void adminDisplayBoard() throws ClassNotFoundException, SQLException {

		System.out.println("\n\nChoose the correct option...Press 0 to exit\n\n");

		String choice = "";
		do {
			String[] toPrint = { "1.Librarian Login", "2.Student Login", "3.Admin Login" };
			FormatOP.printDisplayBoard(toPrint);

			choice = sc.next();
			switch (choice) {
			case "1":
				AddUser.addLibrarian();
				break;

			case "2":
				AddUser.addStudent();
				break;

			case "3":
				System.out.println("Welcome");
				break;

			}
		} while (!choice.equals("0"));
	}

	public static void librariabDisplayBoard() throws ClassNotFoundException, SQLException {
		System.out.println("\n\nChoose the correct option...Press 0 to exit\n\n");

		String choice = "";
		do {
			String[] toPrint = { "1.Issue Books", "2.Add Student Accont", "3.Add books", "4.Book Details ",
					"5.Search the books", "6.View Issued books", "7.View My Issued books", "8.Check Student Details",
					"9.Update Book Details", "10.Update Student Record", "11.Submit Book","12.Update Info","13.Update Password"};
			FormatOP.printDisplayBoard(toPrint);

			choice = sc.next();
			switch (choice) {
			case "1":
				UserInput.issueBookInput();
				break;

			case "2":
				UserInput.addStudentInput();
				break;

			case "3":
				UserInput.addBookInput();
				break;

			case "4":
				Book.bookDetails();
				break;

			case "5":
				search("lib");
				break;

			case "6":
				Book.viewAllIssuedBook();
				break;

			case "7":
				Librarian.viewMyIssuedBooks();
				break;

			case "8":
				Student.viewStudentInfo(true);
				break;

			case "9":
				UserInput.updateBookInput();
				break;

			case "10":
				UserInput.updateStudentInfoInput("lib");
				break;

			case "11":
				UserInput.submitBookInput();
				break;

			case "12":
				UserInput.updateLibrarianInfoInput("lib");
				break;
				
			case "13":
				//UserInput.updateLibrarianInfoInput("lib");
				
				break;
			}
		} while (!choice.equals("0"));
	}

	public static void studentDisplayBoard() throws ClassNotFoundException, SQLException {
		System.out.println("\n\nChoose the correct option...Press 0 to exit\n\n");

		String choice = "";
		do {
			String[] toPrint = { "1.Request Book", "2.All Book Details", "3.Search for books", "4.View Issued books",
					"5.My Profile", "6.Update Info" };
			FormatOP.printDisplayBoard(toPrint);

			choice = sc.next();
			switch (choice) {
			case "1":
				break;

			case "2":
				Student.allBookDetailsStudent();
				break;

			case "3":
				search("stu");
				break;

			case "4":
				Student.issuedBooksStudent();
				break;

			case "5":
				Student.viewStudentInfo(false);
				break;

			case "6":
				UserInput.updateStudentInfoInput("student");
				break;

			}
		} while (!choice.equals("0"));
	}

	public static boolean logInLibrarian() throws ClassNotFoundException, SQLException {
		System.out.print("Enter username: ");
		final String username = new String(sc.next());
		System.out.print("Enter password: ");
		final String password = new String(System.console().readPassword());
		return login.librarianLogin(username, password);
	}

	public static boolean logInStudent() throws ClassNotFoundException, SQLException {
		System.out.print("Enter username: ");
		final String username = new String(sc.next());
		System.out.print("Enter password: ");
		final String password = new String(System.console().readPassword());
		return login.studentLogin(username, password);
	}

	public static boolean logInAdmin() {
		System.out.print("Enter username: ");
		final String username = new String(sc.next());
		System.out.print("Enter password: ");
		final String password = new String(System.console().readPassword());
		return login.adminLogin(username, password);

	}

	public static void search(String user) throws ClassNotFoundException, SQLException {
		System.out.print("Enter Bookname: ");
		final String bookname = new String(sc.next());
		if (user.equals("lib")) {
			Book.searchBook(bookname);
		} else {
			Student.searchBookStudent(bookname);
		}
	}

}
