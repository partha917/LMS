package com.parthad.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {

	protected static int id_book = 0;
	protected static String book_name = "";
	protected static String author = "";
	protected static String category = "";
	protected static String shelf = "";
	protected static int qty = 0;
	protected static int price = 0;
	protected static Statement st;
	protected static Connection con;
	protected static String return_date = "";
	protected static int id_stu = 0;

	static Login login = new Login();

	protected static final int getIdBook() {
		return id_book;
	}

	protected static final String getBookName() {
		return book_name;
	}

	protected static final String getAuthor() {
		return author;
	}

	protected static final String getCategory() {
		return category;
	}

	protected static final String getShelf() {
		return shelf;
	}

	protected static final int getQty() {
		return qty;
	}

	protected static final int getPrice() {
		return price;
	}

	protected static final void setIdBook(int idBook) {
		id_book = idBook;
	}

	protected static final void setBookName(String bookName) {
		book_name = bookName;
	}

	protected static final void setAuthor(String author) {
		Book.author = author;
	}

	protected static final void setCategory(String category) {
		Book.category = category;
	}

	protected static final void setShelf(String shelf) {
		Book.shelf = shelf;
	}

	protected static final void setQty(int qty) {
		Book.qty = qty;
	}

	protected static final void setPrice(int price) {
		Book.price = price;
	}

	protected static final String getReturn_date() {
		return return_date;
	}

	protected static final void setReturn_date(String return_date) {
		Book.return_date = return_date;
	}

	protected static final int getId_stu() {
		return id_stu;
	}

	protected static final void setId_stu(int id_stu) {
		Book.id_stu = id_stu;
	}

	public static Date getDate() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		return date;
	}

	public static void bookDetails() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT b.*, q.qty from lmsdb.books b left join lmsdb.books_qty q on b.id_book=q.id_book order by id_book";
		ResultSet rs = st.executeQuery(sql);

		String[] toPrint = { "Book ID", "Book Name", "Author", "Category", "Shelf", "Price", "No. of Books" };
		FormatOP.printHeader(toPrint, 20);

		while (rs.next()) {
			int bookID = rs.getInt(1);
			String bookName = rs.getString(2);
			String author = rs.getString(3);
			String category = rs.getString(4);
			String shelf = rs.getString(5);
			int price = rs.getInt(6);
			int qty = rs.getInt(7);

			Object[] data = { bookID, bookName, author, category, shelf, price, qty };
			FormatOP.printData(data, 20);
			System.out.println();

		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

	public static int bookDetailsByID() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT b.*, q.qty from lmsdb.books b inner join lmsdb.books_qty q on b.id_book=q.id_book and b.id_book="
				+ Book.getIdBook() + " order by id_book";
		ResultSet rs = st.executeQuery(sql);

		String[] toPrint = { "Book ID", "Book Name", "Author", "Category", "Shelf", "Price", "No. of Books" };
		FormatOP.printHeader(toPrint, 20);
		int bookID = 0;
		if (rs.next()) {
			bookID = rs.getInt(1);
			String bookName = rs.getString(2);
			String author = rs.getString(3);
			String category = rs.getString(4);
			String shelf = rs.getString(5);
			int price = rs.getInt(6);
			int qty = rs.getInt(7);

			Object[] data = { bookID, bookName, author, category, shelf, price, qty };
			FormatOP.printData(data, 20);
			System.out.println();
		}
		return bookID;
	}

	public static void searchBook(String bookname) throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT b.*, q.qty from lmsdb.books b inner join lmsdb.books_qty q on b.id_book=q.id_book and b.book_name like '%"
				+ bookname + "%' order by b.book_name";
		ResultSet rs = st.executeQuery(sql);
		int count = 0;
		boolean check = false;
		while (rs.next()) {
			check = true;
			if (count == 0) {
				String[] toPrint = { "Book ID", "Book Name", "Author", "Category", "Shelf", "Price", "No. of Books" };
				FormatOP.printHeader(toPrint, 20);

				count++;
			}
			int bookID = rs.getInt(1);
			String bookName = rs.getString(2);
			String author = rs.getString(3);
			String category = rs.getString(4);
			String shelf = rs.getString(5);
			int price = rs.getInt(6);
			int qty = rs.getInt(7);

			Object[] data = { bookID, bookName, author, category, shelf, price, qty };
			FormatOP.printData(data, 20);
			System.out.println();

		}

		if (!check) {
			System.out.println("\n\nNo results found");
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");

	}

	public static void viewAllIssuedBook() throws ClassNotFoundException, SQLException {
		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT  i.id_book,b.book_name ,i.id_stu, concat(s.firstname_stu,' ',s.lastname_stu) as studentUsername,i.id_lib, concat(l.firstname_lib,' ',l.lastname_lib) as librarianUsername , i.issue_date,i.return_date ,i.status  from lmsdb.issue_book i,lmsdb.books b, lmsdb.student s, lmsdb.librarian l where i.id_stu=s.id_stu and i.id_lib=l.id_lib and i.id_book=b.id_book order by b.book_name desc;";
		ResultSet rs = st.executeQuery(sql);
		int count = 0;
		boolean check = false;
		while (rs.next()) {
			if (count == 0) {
				check = true;
				String[] toPrint = { "Book ID", "Book Name", "Student ID", "Student Name", "Lib. ID", "Lib. Name",
						"Issue Date", "Return Date", "Satus" };
				FormatOP.printHeader(toPrint, 20);

				count++;
			}
			int bookID = rs.getInt(1);
			String bookName = rs.getString(2);
			int studentID = rs.getInt(3);
			String studentName = rs.getString(4);
			int libID = rs.getInt(5);
			String libName = rs.getString(6);
			String issueDate = rs.getString(7);
			String returnDate = rs.getString(8);
			String status = rs.getString(9);
			Object[] data = { bookID, bookName, studentID, studentName, libID, libName, issueDate, returnDate, status };
			FormatOP.printData(data, 20);
			System.out.println();
		}
		System.out.println();
		if (!check) {
			System.out.println("\n\nNo results found");
		}

		login.closeConnection(con);
		System.out.println("\n\n\n");
	}

	public static void addBook() throws SQLException, ClassNotFoundException {
		con = login.establishConnection();
		try {
			st = con.createStatement();

			String sql = "INSERT INTO lmsdb.books " + "VALUES ('" + Book.getIdBook() + "', '" + Book.getBookName()
					+ "', '" + Book.getAuthor() + "','" + Book.getCategory() + "', '" + Book.getShelf() + "','"
					+ Book.getPrice() + "')";
			st.executeUpdate(sql);

			sql = "INSERT INTO lmsdb.books_qty " + "VALUES('" + Book.getIdBook() + "', '" + Book.getQty() + "')";
			st.executeUpdate(sql);

			System.out.println("Books added successfully.\n");
		} catch (SQLException e) {
			System.out.println("Could not added.\n" + e.getErrorCode() + e.getMessage());
		}

		login.closeConnection(con);
	}

	public static int checkAvailablity() throws ClassNotFoundException, SQLException {

		con = login.establishConnection();
		st = con.createStatement();
		String sql = "SELECT qty from lmsdb.books_qty where id_book=" + getIdBook();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			return rs.getInt(1);
		}
		login.closeConnection(con);
		return 0;
	}

	public static void updateBookDetails(int oldBookID) throws ClassNotFoundException, SQLException {
		con = login.establishConnection();

		try {

			st = con.createStatement();
			String sql = "UPDATE lmsdb.books SET id_book = " + Book.getIdBook() + ", book_name = '" + Book.getBookName()
					+ "', author = '" + Book.getAuthor() + "', category = '" + Book.getCategory() + "', shelf = '"
					+ Book.getShelf() + "', price = " + Book.getPrice() + " WHERE id_book = " + oldBookID;
			st.executeUpdate(sql);
			sql = "UPDATE lmsdb.books_qty SET qty = " + Book.getQty() + " WHERE id_book = " + Book.getIdBook();
			st.executeUpdate(sql);
			System.out.println("Books added successfully.\n");
		} catch (SQLException e) {
			System.out.println("Could not added.\n" + e.getErrorCode() + e.getMessage());
		}

		login.closeConnection(con);
	}

}
