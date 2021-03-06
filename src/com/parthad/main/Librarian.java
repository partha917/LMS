package com.parthad.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.parthad.gui.DisplayFrameGUI;

public class Librarian {

	private static Connection con;
	static Login login = new Login();
	private static Statement st;

	public static boolean issueBook() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		try {
			st = con.createStatement();
			int qty = Book.checkAvailablity();
			if (qty < 1) {
				System.out.print("Book is not available.");
				return false;
			}
			String sql = "INSERT INTO lmsdb.issue_book (id_book, id_stu, id_lib, issue_date, return_date, status)"
					+ "VALUES ('" + Book.getIdBook() + "', '" + AddUser.getId_stu() + "', '"
					+ AddUser.getLoggedInLibrarianID() + "','" + Book.getDate() + "', '" + Book.getReturn_date()
					+ "','Pending')";
			System.out.println(sql);
			st.executeUpdate(sql);
			System.out.println(sql);
			sql = "UPDATE lmsdb.books_qty SET qty = '" + (qty - 1) + "' WHERE (id_book = '" + Book.getIdBook() + "')";
			st.executeUpdate(sql);
			
			System.out.println("\n\nBook issued successfully.\n\n");
		} catch (SQLException e) {
			System.out.println("Could not issue book cause : " + e.getErrorCode() + e.getMessage());
			return false;
		}

		login.closeConnection(con);
		return true;
	}

	public static boolean submitBook() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		try {
			int qty = Book.checkAvailablity();
			String sql = "select no from lmsdb.issue_book where id_book= " + Book.getIdBook()+" and id_stu= "+AddUser.getId_stu();
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			
			int no = 0;
			if (rs.next()) {
				no = rs.getInt(1);
			}
			if(no==0) {
				return false;
			}
			sql = "UPDATE lmsdb.issue_book SET status = 'Submitted' WHERE No = " + no;
			st.executeUpdate(sql);
			System.out.println(sql);
			//UPDATE `lmsdb`.`issue_book` SET `status` = 'Submitted' WHERE (`No` = '8');

			sql = "UPDATE lmsdb.books_qty SET qty = " + (qty + 1) + " WHERE id_book = " + Book.getIdBook();
			
			st.executeUpdate(sql);
			System.out.println(sql);
			
			System.out.println("\n\nBook submitted successfully.\n\n");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			login.closeConnection(con);
			return false;
		}
		login.closeConnection(con);
		System.out.println("\n\n\n");
		return true;
	}

	public static boolean viewMyIssuedBooks() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT  i.id_book,b.book_name ,i.id_stu, concat(s.firstname_stu,' ',s.lastname_stu) as studentUsername,  i.issue_date,i.return_date ,i.status  from lmsdb.issue_book i,lmsdb.books b, lmsdb.student s, lmsdb.librarian l where i.id_lib="+AddUser.getLoggedInLibrarianID()+" and i.id_stu=s.id_stu and i.id_lib=l.id_lib and i.id_book=b.id_book order by b.book_name desc";
		ResultSet rs = st.executeQuery(sql);
		System.out.println(sql);
		int count = 0;
		boolean check = false;
		while (rs.next()) {
			check = true;
			if (count == 0) {
				String[] toPrint = { "Book ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Return Date",
						"Satus" };
				FormatOP.printHeader(toPrint, 20);

				DisplayFrameGUI.setColumnNames(toPrint);

				count++;
			}
			int bookID = rs.getInt(1);
			String bookName = rs.getString(2);
			int studentID = rs.getInt(3);
			String studentName = rs.getString(4);
			String issueDate = rs.getString(5);
			String returnDate = rs.getString(6);
			String status = rs.getString(7);

			Object[] data = { bookID, bookName, studentID, studentName, issueDate, returnDate, status };
			FormatOP.printData(data, 20);
			//
			DisplayFrameGUI.createTableData(data);
			System.out.println();
		}
		if (!check) {
			System.out.println("\n\nNo results found");
			login.closeConnection(con);
			return false;
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
		return true;
	}

	public static void updateLibrarianInfo() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		try {
			st = con.createStatement();
			String sql = "UPDATE lmsdb.librarian SET  firstname_lib = '" + AddUser.getFirstname()
					+ "', lastname_lib = '" + AddUser.getLastname() + "', username_lib = '" + AddUser.getUsername()
					+ "', joining_date = '" + AddUser.getJoiningDate() + "',city='" + AddUser.getCity()
					+ "', contact_no = '" + AddUser.getContactNo() + "', email_lib= '" + AddUser.getEmail()
					+ "' WHERE id_lib = " + AddUser.getLoggedInLibrarianID();
			st.executeUpdate(sql);
			System.out.println("Librarian Record updated successfully.\n");
		} catch (SQLException e) {
			System.out.println("Could not added.\n" + e.getErrorCode() + e.getMessage());
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

}
