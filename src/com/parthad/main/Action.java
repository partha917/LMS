package com.parthad.main;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JLabel;

import com.parthad.gui.DisplayFrameGUI;
import com.parthad.gui.LibrarianDialog;

public class Action {

	public static String s;
	public static boolean success = false;

	public static boolean sumbitBookGUI(HashMap<JLabel, String> map) throws ClassNotFoundException, SQLException {
		s = map.get(LibrarianDialog.idBookLabel);
		System.out.println("Book ID: " + s);
		if (CheckInput.checkNo(s.toUpperCase())) {
			Book.setIdBook(Integer.parseInt(s));
		}
		s = map.get(LibrarianDialog.idStudentLabel);
		System.out.println("Student ID: " + s);

		if (CheckInput.checkNo(s)) {
			AddUser.setId_stu(Integer.parseInt(s));
		}
		return Librarian.submitBook();

	}

	public static boolean issueBookGUI(HashMap<JLabel, String> map) throws ClassNotFoundException, SQLException {
		s = map.get(LibrarianDialog.idBookLabel);
		Book.setIdBook(Integer.parseInt(s));
		System.out.println(s);
		s = map.get(LibrarianDialog.idStudentLabel);
		System.out.println(s);
		System.out.println(Integer.parseInt(s));
		AddUser.setId_stu(Integer.parseInt(s));
		s = map.get(LibrarianDialog.returnDateLabel);
		System.out.println(s);
		Book.setReturn_date(s);

		System.out.println("Logged in lib id: " + AddUser.getLoggedInLibrarianID());

		return Librarian.issueBook();
	}

	public static boolean addStudentGUI(HashMap<JLabel, String> map, int STATUS_CODE, JDialog lDialog)
			throws ClassNotFoundException, SQLException {

		s = map.get(LibrarianDialog.idStudentLabel);
		System.out.println(s);
		AddUser.setId_stu(Integer.parseInt(s));

		s = map.get(LibrarianDialog.firstNameLabel);
		System.out.println(s);
		AddUser.setFirstname(s);

		s = map.get(LibrarianDialog.lastNameLabel);
		System.out.println(s);
		AddUser.setLastname(s);

		s = map.get(LibrarianDialog.deptLabel);
		System.out.println(s);
		AddUser.setDept(s);

		s = map.get(LibrarianDialog.contactLabel);
		System.out.println(s);
		AddUser.setContactNo(s);

		s = map.get(LibrarianDialog.emailLabel);
		System.out.println(s);
		AddUser.setEmail(s);

		s = map.get(LibrarianDialog.usernameLabel);
		System.out.println(s);
		System.out.println(map.size());
		// AddUser.setStudentUsername(s);
		// AddUser.setId_stu(Integer.parseInt(s));
		AddUser.setUsername_stu(s);

		if (STATUS_CODE == 2) {
			return AddUser.addStudent();
		} else if (STATUS_CODE == 10) {
			// return Student.updateStudenInfo();
			success = Student.updateStudenInfo(false);
			System.out.println(success + "!!!!!!!!!!!");
			if (success) {
				new DisplayFrameGUI(lDialog);
				//
				// Student Table needs to be updated with pwd on delete
				// Student.viewStudentInfo(false);
			}
			return success;

		}
		return false;

	}

	public static boolean addBookGUI(HashMap<JLabel, String> map, int STATUS_CODE, JDialog lDialog)
			throws ClassNotFoundException, SQLException {

		System.out.print("Enter Book id: ");
		s = map.get(LibrarianDialog.idBookLabel);
		Book.setIdBook(Integer.parseInt(s));

		System.out.print("Enter Book name: ");
		s = map.get(LibrarianDialog.bookNameLabel);
		Book.setBookName(s);

		System.out.print("Enter Author name: ");
		s = map.get(LibrarianDialog.authorLabel);
		Book.setAuthor(s);

		System.out.print("Enter Category: ");
		s = map.get(LibrarianDialog.categoryLabel);
		Book.setCategory(s);

		System.out.print("Enter Shelf: ");
		s = map.get(LibrarianDialog.shelfLabel);
		Book.setShelf(s);

		System.out.print("Enter Qty.: ");
		s = map.get(LibrarianDialog.qtyLabel);
		Book.setQty(Integer.parseInt(s));

		System.out.print("Enter Price.: ");
		s = map.get(LibrarianDialog.priceLabel);
		Book.setPrice(Integer.parseInt(s));
		System.out.println("Calling the method");

		// return Book.addBook();

		if (STATUS_CODE == 3) {
			return Book.addBook();
		} else if (STATUS_CODE == 9) {
			// return Student.updateStudenInfo();
			success = Book.updateBookDetails();
			System.out.println(success + "!!!!!!!!!!!");
			if (success) {
				new DisplayFrameGUI(lDialog);
				//
				// Student Table needs to be updated with pwd on delete
				// Student.viewStudentInfo(false);
			}
			return success;

		}
		return false;

	}

	public static boolean searchBookGUI(Map<JLabel, String> map, JDialog lDialog)
			throws ClassNotFoundException, SQLException {
		s = map.get(LibrarianDialog.bookNameLabel);
		System.out.println("book name: " + s);
		if (!s.isEmpty()) {

			success = Book.searchBook(s);
			if (success) {
				new DisplayFrameGUI(lDialog);

				Book.searchBook(s);
			}
			return success;

		}
		return false;
	}

}
