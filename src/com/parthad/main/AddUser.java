package com.parthad.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddUser {

	protected static int id_lib = 0;
	protected static String firstname = "";
	protected static String lastname = "";
	protected static String username = "";
	protected static String joining_date = "";
	protected static String city = "";
	protected static String contact_no = "";
	protected static String email = "";
	protected static String password = "";
	protected static int id_stu = 0;
	protected static String dept = "";
	protected static Statement st;
	protected static Connection con;
	protected static String username_lib = "";
	protected static String username_stu = "";

	static Login login = new Login();

	protected static final int getIdLib() {
		return id_lib;
	}

	protected static final int getId_stu() {
		return id_stu;
	}

	protected static final String getFirstname() {
		return firstname;
	}

	protected static final String getLastname() {
		return lastname;
	}

	protected static final String getUsername() {
		return username;
	}

	protected static final String getJoiningDate() {
		return joining_date;
	}

	protected static final String getCity() {
		return city;
	}

	protected static final String getContactNo() {
		return contact_no;
	}

	protected static final String getEmail() {
		return email;
	}

	protected static final String getPassword() {
		return password;
	}

	protected static final String getDept() {
		return dept;
	}

	protected static final void setIdLib(int idLib) {
		id_lib = idLib;
	}

	protected static final void setId_stu(int id_stu) {
		AddUser.id_stu = id_stu;
	}

	protected static final void setFirstname(String firstnameLib) {
		firstname = firstnameLib;
	}

	protected static final void setLastname(String lastnameLib) {
		lastname = lastnameLib;
	}

	protected static final void setUsername(String username_lib) {
		AddUser.username = username_lib;
	}

	protected static final void setJoiningDate(String joiningDate) {
		joining_date = joiningDate;
	}

	protected static final void setCity(String city) {
		AddUser.city = city;
	}

	protected static final void setContactNo(String contactNo) {
		contact_no = contactNo;
	}

	protected static final void setEmail(String email) {
		AddUser.email = email;
	}

	protected static final void setPassword(String password) {
		AddUser.password = password;
	}

	protected static final void setDept(String dept) {
		AddUser.dept = dept;
	}

	protected static final String getUsername_lib() {
		return username_lib;
	}

	protected static final void setUsername_lib(String username_lib) {
		AddUser.username_lib = username_lib;
	}

	protected static final String getUsername_stu() {
		return username_stu;
	}

	protected static final void setUsername_stu(String username_stu) {
		AddUser.username_stu = username_stu;
	}

	public static void addLibrarian() throws ClassNotFoundException, SQLException {

		con = login.establishConnection();
		setPassword(System.console().readLine());
		try {
			st = con.createStatement();

			String sql = "INSERT INTO lmsdb.librarian " + "VALUES ('" + getIdLib() + "', '" + getFirstname() + "', '"
					+ getLastname() + "','" + getUsername() + "', '" + getJoiningDate() + "', '" + getCity() + "','"
					+ getContactNo() + "','" + getEmail() + "')";
			st.executeUpdate(sql);

			sql = "INSERT INTO lmsdb.pwd_lib VALUES('" + getIdLib() + "','" + getUsername() + "', '" + getPassword()
					+ "')";

			st.executeUpdate(sql);

			System.out.println("Librarian added successfully.");
		} catch (SQLException e) {
			System.out.println("Could not added." + e.getErrorCode() + e.getMessage());
		}

		login.closeConnection(con);
	}

	public static boolean addStudent() throws ClassNotFoundException, SQLException {

		con = login.establishConnection();
		try {
			st = con.createStatement();

			String sql = "INSERT INTO lmsdb.student " + "VALUES ('" + getId_stu() + "', '" + getFirstname() + "', '"
					+ getLastname() + "','" + getUsername_stu() + "', '" + getDept() + "', '" + getContactNo() + "','"
					+ getEmail() + "')";
			st.executeUpdate(sql);

			sql = "INSERT INTO lmsdb.pwd_stu (id_stu, username) VALUES('" + getId_stu() + "','" + getUsername() + "')";

			st.executeUpdate(sql);

			System.out.println("Student added successfully.");
		} catch (SQLException e) {
			System.out.println("Could not added." + e.getErrorCode() + e.getMessage());
			login.closeConnection(con);
			return false;
		}

		login.closeConnection(con);
		return true;

	}

	public static int getLoggedInLibrarianID() throws ClassNotFoundException, SQLException {

		con = login.establishConnection();
		st = con.createStatement();
		int id = 0;
		String sql = "SELECT id_lib FROM lmsdb.librarian WHERE userame_lib ='" + getUsername_lib() + "'";
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		login.closeConnection(con);
		return id;
	}

	public static int getLoggedInStudentID() throws ClassNotFoundException, SQLException {

		con = login.establishConnection();
		st = con.createStatement();
		int id = 0;
		String sql = "SELECT id_stu FROM lmsdb.student WHERE username ='" + getUsername_stu() + "'";
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		login.closeConnection(con);
		return id;
	}

	public static void setLibrarianUsername(String username) {
		setUsername_lib(username);
	}

	public static void setStudentUsername(String username) {
		setUsername_stu(username);
	}
	public static void setId_Student() throws ClassNotFoundException, SQLException {
		int id=getLoggedInStudentID();
		AddUser.setId_stu(id);
	}

}
