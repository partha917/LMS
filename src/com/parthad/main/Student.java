package com.parthad.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

	private static Connection con;
	static Login login = new Login();
	private static Statement st;

	public static void allBookDetailsStudent() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT b.id_book,b.book_name,b.author,b.category, q.qty from lmsdb.books b inner join lmsdb.books_qty q on b.id_book=q.id_book order by b.category";
		ResultSet rs = st.executeQuery(sql);

		String[] toPrint = { "Book ID", "Book Name", "Author", "Category", "No. of Books" };
		FormatOP.printHeader(toPrint, 20);

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String author = rs.getString(3);
			String category = rs.getString(4);
			int qty = rs.getInt(5);

			Object[] data = { id, name, author, category, qty };
			FormatOP.printData(data, 20);
			System.out.println();
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

	public static void searchBookStudent(String bookname) throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT b.id_book,b.book_name,b.author,b.category, q.qty from lmsdb.books b , lmsdb.books_qty q where b.id_book=q.id_book and b.book_name like '%"
				+ bookname + "%' order by b.book_name";
		ResultSet rs = st.executeQuery(sql);
		int count = 0;
		boolean check = false;
		while (rs.next()) {
			check = true;
			if (count == 0) {
				String[] toPrint = { "Book ID", "Book Name", "Author", "Category", "No. of Books" };
				FormatOP.printHeader(toPrint, 20);
				count++;
			}
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String author = rs.getString(3);
			String category = rs.getString(4);
			int qty = rs.getInt(5);

			Object[] data = { id, name, author, category, qty };
			FormatOP.printData(data, 20);
			System.out.println();
		}

		if (!check) {
			System.out.println("\n\nNo results found");
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");

	}

	public static void issuedBooksStudent() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT b.id_book,b.book_name,b.author,b.category, i.issue_date,i.return_date, i.status from lmsdb.books b , lmsdb.issue_book i where b.id_book=i.id_book and i.id_stu="
				+ AddUser.getLoggedInStudentID();
		ResultSet rs = st.executeQuery(sql);
		int count = 0;
		boolean check = false;
		while (rs.next()) {
			check = true;
			if (count == 0) {
				String[] toPrint = { "Book ID", "Book Name", "Author", "Category", "Issue Date", "Return Date",
						"Satus" };
				FormatOP.printHeader(toPrint, 20);
				count++;
			}
			int bookID = rs.getInt(1);
			String bookName = rs.getString(2);
			String author = rs.getString(3);
			String category = rs.getString(4);
			String issueDate = rs.getString(5);
			String returnDate = rs.getString(6);
			String status = rs.getString(7);

			Object[] data = { bookID, bookName, author, category, issueDate, returnDate, status };
			FormatOP.printData(data, 20);
			System.out.println();

		}
		if (!check) {
			System.out.println("\n\nNo results found");
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

	public static void viewStudentInfo(boolean all) throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql;
		if (all) {
			sql = "SELECT id_stu,concat(firstname_stu,' ',lastname_stu )as StudentName, username,dept,contact_no,email FROM lmsdb.student";
		} else {
			sql = "SELECT id_stu,concat(firstname_stu,' ',lastname_stu )as StudentName, username,dept,contact_no,email FROM lmsdb.student where id_stu="
					+ AddUser.getLoggedInStudentID();
		}
		ResultSet rs = st.executeQuery(sql);

		int count = 0;
		boolean check = false;
		while (rs.next()) {
			check = true;
			if (count == 0) {
				String[] toPrint = { "Student ID", "Student Name", "Username", "Dept.", "Contact No", "Email" };
				FormatOP.printHeader(toPrint, 20);
				count++;
			}
			int studentID = rs.getInt(1);
			String studentName = rs.getString(2);
			String username = rs.getString(3);
			String Dept = rs.getString(4);
			String contactNo = rs.getString(5);
			String email = rs.getString(6);

			Object[] data = { studentID, studentName, username, Dept, contactNo, email };
			FormatOP.printData(data, 20);
			System.out.println();

		}
		if (!check) {
			System.out.println("\n\nNo results found");
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

	public static void updateStudenInfo() throws ClassNotFoundException, SQLException {

		con = login.establishConnection();
		try {
			st = con.createStatement();
			String sql = "UPDATE lmsdb.student SET  firstname_stu = '" + AddUser.getFirstname() + "', lastname_stu = '"
					+ AddUser.getLastname() + "', username = '" + AddUser.getUsername() + "', dept = '"
					+ AddUser.getDept() + "', contact_no = '" + AddUser.getContactNo() + "', email= '"
					+ AddUser.getEmail() + "' WHERE id_stu = " + AddUser.getLoggedInStudentID();
			st.executeUpdate(sql);
			System.out.println("Student Record updated successfully.\n");
		} catch (SQLException e) {
			System.out.println("Could not added.\n" + e.getErrorCode() + e.getMessage());
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

}
