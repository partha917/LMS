package com.parthad.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	private Connection con = null;
	private static boolean ADMIN_STATTUS_CODE = false;
	private final static String URL = "jdbc:mysql://localhost:3306/lmsdb?dbautoReconnect=true&useSSL=false";
	private final static String DBUSERNAME = "root";
	private final static String DBPASSWORD = "daspartha917";
	private final String ADMIN_USER = "admin";
	private final String ADMIN_PASSWORD = "admin";
	private final static String USER_LIBRARIAN = "";
	private final static String LIBRARIAN_PASSWORD = "";

	private final String getADMIN_USER() {
		return ADMIN_USER;
	}

	private final String getADMIN_PASSWORD() {
		return ADMIN_PASSWORD;
	}

	private static final String getUserLibrarian() {
		return USER_LIBRARIAN;
	}

	private static final String getLibrarianPassword() {
		return LIBRARIAN_PASSWORD;
	}

	public Connection establishConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(URL, DBUSERNAME, DBPASSWORD);
		return con;
	}

	public void fetchRecords() throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from lmsdb.admin");
		while (rs.next())
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
	}

	public boolean adminLogin(String username, String password) {
		if (getADMIN_USER().equals(username) && getADMIN_PASSWORD().equals(password)) {
			System.out.println("\nSuccessfully logger in with admin\n");
			FormatOP.printUnderLine();
			ADMIN_STATTUS_CODE = true;
			return true;
		} else {
			System.out.println("\nUsername or password is incorrect!! Please try again\n");
			return false;
		}
	}

	public boolean librarianLogin(String username, String password) throws ClassNotFoundException, SQLException {
		con = establishConnection();
		Statement st = con.createStatement();
		String sql = "SELECT username,pwd FROM lmsdb.pwd_lib where username = '" + username + "' AND pwd = '" + password
				+ "'";
		AddUser.setLibrarianUsername(username);
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			System.out.println("\nSuccessfully logged in as librarian.");
			FormatOP.printUnderLine();
			closeConnection(con);
			return true;
		} else {
			System.out.println("\nUsername or password is incorrect. Please try again.");
			closeConnection(con);
			return false;
		}

	}

	public boolean studentLogin(String username, String password) throws ClassNotFoundException, SQLException {
		con = establishConnection();
		Statement st = con.createStatement();
		String sql = "SELECT username,pwd FROM lmsdb.pwd_stu where username = '" + username + "' AND pwd = '" + password
				+ "'";
		AddUser.setStudentUsername(username);
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			System.out.println("\nSuccessfully logged in as studnet.");
			FormatOP.printUnderLine();
			closeConnection(con);
			return true;
		} else {
			System.out.println("Username or password is incorrect. Please try again.");
			closeConnection(con);
			return false;
		}

	}

	public void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
			// System.out.println("Connection Closed");
		}
	}

}
