package com.parthad.gui;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.parthad.main.Book;
import com.parthad.main.Librarian;
import com.parthad.main.Student;

public class DisplayFrameGUI extends JFrame {

	public static JTable jt;
	public static JScrollPane sp;
	public static DefaultTableModel tableModel;

	public DisplayFrameGUI(JDialog lDialog) throws ClassNotFoundException, SQLException {

		System.out.println("In display");
		this.setLayout(new BorderLayout(5, 5));
		System.out.println(this.getLayout());

		jt = new JTable();
		jt.setBounds(0, 0, 600, 800);

		tableData();

		sp = new JScrollPane(jt);
		// jt.setFillsViewportHeight(true);
		
		if(lDialog!=null) {
		lDialog.dispose();
		}
		
		this.add(sp);
		this.setSize(1040, 860);
		this.setLocation(500, 0);
		this.setVisible(true);
		this.setFocusable(true);

		//
		// this.setBackground(Color.LIGHT_GRAY);
		// this.setVisible(true);
	}

	public static void tableData() throws ClassNotFoundException, SQLException {

		//
		if (LibrarianDialog.STATUS_CODE == 4 || StudentHome.STATUS_CODE==4) {
			Book.bookDetails();
		} else if (LibrarianDialog.STATUS_CODE == 6) {
			Book.viewAllIssuedBook();

		} else if (LibrarianDialog.STATUS_CODE == 7) {
			Librarian.viewMyIssuedBooks();

		} else if (LibrarianDialog.STATUS_CODE == 8) {
			Student.viewStudentInfo(true);

		}else if (LibrarianDialog.STATUS_CODE == 9) {
			//Student.updateStudenInfo(false);
			Book.bookDetailsByID();
		}
		else if (LibrarianDialog.STATUS_CODE == 10) {
			//Student.updateStudenInfo(false);
			Student.viewStudentInfo(false);
		}
		else if(StudentHome.STATUS_CODE==3) {
			Student.issuedBooksStudent();
		}

		else if(StudentHome.STATUS_CODE==6) {
			Student.viewStudentInfo(false);
		}
		

		//
		if(tableModel!=null)
		jt.setModel(tableModel); // place model into JTable
	
	}

	public static void setColumnNames(String[] column) {
		// String[] columnNames = { "Book ID", "Book Name", "Author", "Category",
		// "Shelf", "Price", "No. of Books" };
		String[] columnNames = column;
		tableModel = new DefaultTableModel(columnNames, 0);

	}

	public static void createTableData(Object[] data) {
		tableModel.addRow(data);

	}

}


/*
 * DisplayFrame-->tabledata()-->calling the methods to create and set the table-->Books.bookdetails()
 * 
 * Books.bookdetails()--> setColumn()
 * Books.bookDetails()--> createTableData()
 * 
 * 
 * 
 * 
 */










