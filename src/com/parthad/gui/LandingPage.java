package com.parthad.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LandingPage extends JPanel implements ActionListener {

	public static JButton buttonStudent;
	public static JButton buttonLibrarian;
	public static JButton buttonAdmin;
	public static Component com[];
	public LoginDialog form = null;

	public static String TEXTLIB = "Librarian Login";
	public static String TEXTSTU = "Student Login";
	public static String TEXTADMIN = "Admin Login";

	public static int positionX = 540;
	public static int positionY = 250;
	public static int d = 150;

	public static boolean success = false;
	public static int STATUS_CODE;

	public static JPanel librarianHome = null;
	public static JFrame guiBaseFrame = null;
	public static JDialog loginDialog = null;
	public static JPanel studentHome=null;

	public LandingPage(JFrame guiBaseFrame) {
		LandingPage.guiBaseFrame = guiBaseFrame;
		this.setBounds(0, 0, 1920, 1080);
		// this.setEnabled(true);
		this.setBackground(Color.GRAY);
		// this.setLayout(null);
		this.setLayout(null);

		buttonLibrarian = Button.addButton(this, TEXTLIB, positionX, positionY);
		buttonLibrarian.addActionListener(this);
		buttonStudent = Button.addButton(this, TEXTSTU, buttonLibrarian.getX(), buttonLibrarian.getY() + d);
		buttonStudent.addActionListener(this);
		buttonAdmin = Button.addButton(this, TEXTADMIN, buttonLibrarian.getX(), buttonStudent.getY() + d);
		buttonAdmin.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// librarianHome=new LibrarianHome(guiBaseFrame);
		if (e.getSource().equals(buttonLibrarian)) {
			STATUS_CODE = 1;
		} else if (e.getSource().equals(buttonStudent)) {
			STATUS_CODE = 2;
		} else {
			STATUS_CODE = 3;
		}
		loginDialog = new LoginDialog(guiBaseFrame, STATUS_CODE);
		if (success && STATUS_CODE==1) {
			librarianHome = new LibrarianHome(guiBaseFrame);
			guiBaseFrame.remove(this);
			guiBaseFrame.add(librarianHome);
			guiBaseFrame.repaint();
		}
		else if(success && STATUS_CODE==2) {
			studentHome= new StudentHome(guiBaseFrame);
			guiBaseFrame.remove(this);
			guiBaseFrame.add(studentHome);
			guiBaseFrame.repaint();
			
		}
	}

}
