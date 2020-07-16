package com.parthad.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.parthad.main.Book;

public class StudentHome extends JPanel implements ActionListener {

	public static JButton addStudents;
	public static JButton addBook;
	public static JButton issueBook;
	public static JButton bookDtails;
	public static JButton searchBook;
	public static JButton viewIssuedBooks;
	public static JButton viewMyIssuedBooks;
	public static JButton checkStudentDetails;
	public static JButton updateStudentInfo;
	public static JButton updateBookDetails;
	public static JButton submitBook;
	public static JButton updatePersonalInfo;
	public static JButton updatePassword;
	
	public static JButton logout;

	public static JFrame guiBaseFrame;
	public static LibrarianDialog libDialog;
	public static DisplayDataPanel displayData;

	public static final String[] libraryBoard = { "1.Request Book", "2.All Book Details", "3.Search for books",
			"4.View Issued books", "5.My Profile", "6.Update Info" };

	public static int i = 0;
	public static int x = 260;
	public static int y = 200;
	public static int dx = 240;
	public static int dy = 140;

	public static int STATUS_CODE;

	public StudentHome(JFrame guiBaseFrame) {

		// TODO Auto-generated constructor stub
		StudentHome.guiBaseFrame = guiBaseFrame;
		this.setBounds(0, 0, 1920, 1080);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		i++;
		bookDtails = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);

		searchBook = Button.addLibrarianButton(this, libraryBoard[i++], x = 260, y = y + dy);
		viewMyIssuedBooks = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		checkStudentDetails = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);

		updatePersonalInfo = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);

		// updatePassword = Button.addLibrarianButton(this, libraryBoard[i++], x = 260,
		// y = y + dy);

		bookDtails.addActionListener(this);
		searchBook.addActionListener(this);
		viewMyIssuedBooks.addActionListener(this);
		checkStudentDetails.addActionListener(this);
		//updateStudentInfo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked");
		// LibrarianDialog.submitBook();
		try {
			if (e.getSource().equals(bookDtails)) {
				STATUS_CODE = 4;
				new DisplayFrameGUI(null);
			} else if (e.getSource().equals(searchBook)) {
				STATUS_CODE = 5;
				new LibrarianDialog(guiBaseFrame, STATUS_CODE, this);
				
			} else if (e.getSource().equals(viewMyIssuedBooks)) {
				STATUS_CODE = 3;
				new DisplayFrameGUI(null);

			} else if (e.getSource().equals(checkStudentDetails)) {
				STATUS_CODE = 6;
				new DisplayFrameGUI(null);
			} else if (e.getSource().equals(updateStudentInfo)) {
				STATUS_CODE = 5;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

/*
 * From here we need to call the Dialog or the Displaydate Panel thats it. For
 * Dialog no need to add to guibaseFrame.
 * 
 * First It wll goto librarian Dialog
 * 
 * 
 * 
 */