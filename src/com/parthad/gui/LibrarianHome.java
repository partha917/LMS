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
import javax.swing.plaf.synth.SynthTextAreaUI;

public class LibrarianHome extends JPanel implements ActionListener {

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

	public static final String[] libraryBoard = { "1.Issue Books", "2.Add Student Accont", "3.Add books",
			"4.Book Details ", "5.Search the books", "6.View Issued books", "7.View My Issued books",
			"8.Check Student Details", "9.Update Book Details", "10.Update Student Record", "11.Submit Book",
			"12.Update Info", "13.Update Password" };

	public static int i = 0;
	public static int x = 260;
	public static int y = 200;
	public static int dx = 240;
	public static int dy = 140;

	public static int STATUS_CODE;

	public LibrarianHome(JFrame guiBaseFrame) {

		LibrarianHome.guiBaseFrame = guiBaseFrame;
		this.setBounds(0, 0, 1920, 1080);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);

		issueBook = Button.addLibrarianButton(this, libraryBoard[i++], x, y);
		addBook = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		addStudents = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		bookDtails = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);

		searchBook = Button.addLibrarianButton(this, libraryBoard[i++], x = 260, y = y + dy);
		viewIssuedBooks = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		viewMyIssuedBooks = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		checkStudentDetails = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);

		updateBookDetails = Button.addLibrarianButton(this, libraryBoard[i++], x = 260, y = y + dy);
		updateStudentInfo = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		submitBook = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);
		updatePersonalInfo = Button.addLibrarianButton(this, libraryBoard[i++], x = x + dx, y);

		updatePassword = Button.addLibrarianButton(this, libraryBoard[i++], x = 260, y = y + dy);
		logout = Button.addLibrarianButton(this, "Log Out", x = x + dx, y);
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guiBaseFrame.remove(LibrarianHome.this);
				guiBaseFrame.add(new LandingPage(guiBaseFrame));
				guiBaseFrame.repaint();
				
			}
		});


		issueBook.addActionListener(this);
		addBook.addActionListener(this);
		addStudents.addActionListener(this);
		bookDtails.addActionListener(this);
		searchBook.addActionListener(this);
		viewIssuedBooks.addActionListener(this);
		viewMyIssuedBooks.addActionListener(this);
		checkStudentDetails.addActionListener(this);
		updateStudentInfo.addActionListener(this);
		updateBookDetails.addActionListener(this);
		submitBook.addActionListener(this);
		updatePersonalInfo.addActionListener(this);
		updatePassword.addActionListener(this);
		
		logout.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicked");
		// LibrarianDialog.submitBook();
		if (e.getSource().equals(issueBook)) {
			STATUS_CODE = 1;
		} else if (e.getSource().equals(addBook)) {
			STATUS_CODE = 2;
		} else if (e.getSource().equals(addStudents)) {
			STATUS_CODE = 3;
		} else if (e.getSource().equals(bookDtails)) {
			STATUS_CODE = 4;
		} else if (e.getSource().equals(searchBook)) {
			STATUS_CODE = 5;
		} else if (e.getSource().equals(viewIssuedBooks)) {
			STATUS_CODE = 6;
		} else if (e.getSource().equals(viewMyIssuedBooks)) {
			STATUS_CODE = 7;
		} else if (e.getSource().equals(checkStudentDetails)) {
			STATUS_CODE = 8;
		} else if (e.getSource().equals(updateBookDetails)) {
			STATUS_CODE = 9;
		} else if (e.getSource().equals(updateStudentInfo)) {
			STATUS_CODE = 10;
		} else if (e.getSource().equals(submitBook)) {
			STATUS_CODE = 11;
		} else if (e.getSource().equals(updatePersonalInfo)) {
			STATUS_CODE = 12;
		} else if (e.getSource().equals(updatePassword)) {
			STATUS_CODE = 13;
		}
		try {
			libDialog = new LibrarianDialog(guiBaseFrame, STATUS_CODE, this);
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