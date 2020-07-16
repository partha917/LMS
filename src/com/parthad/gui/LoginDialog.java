package com.parthad.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.parthad.main.Librarian;
import com.parthad.main.Login;

public class LoginDialog extends JDialog implements ActionListener {

	public static JDialog loginDialog;
	public static final String TITLE = "Login";
	public static String USERNAME = "Enter Username: ";
	public static String PASSWORD = "Enter Password: ";
	public static final String messageFailure = "Wrong username or password!!";
	public static final String messageSuccess = "Successfully logged in.";
	public static boolean success;

	public static JLabel usernameLabel;
	public static JTextField usernameField;
	public static JPasswordField passwordField;
	public static JLabel passwordLabel;
	public static JLabel message;

	public static JButton loginButton;
	public static int STATUS_CODE;
	public static JFrame guiBaseFrame;
	public static JPanel librarianHome = null;

	public LoginDialog(JFrame guiBaseFrame, int STATUS_CODE) {

		// LoginDialog.success=success;
		LoginDialog.STATUS_CODE = STATUS_CODE;
		LoginDialog.guiBaseFrame = guiBaseFrame;
		loginDialog = new JDialog(guiBaseFrame, TITLE, true);
		loginDialog.setLayout(null);

		usernameLabel = new JLabel(USERNAME);
		usernameLabel.setBounds(loginDialog.getX() + 50, loginDialog.getY() + 150, 300, 30);
		loginDialog.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setBounds(usernameLabel.getX() + 100, usernameLabel.getY(), 300, 30);
		usernameField.setBackground(Color.LIGHT_GRAY);
		loginDialog.add(usernameField);

		passwordLabel = new JLabel(PASSWORD);
		passwordLabel.setBounds(usernameLabel.getX(), usernameLabel.getY() + 80, 300, 30);
		loginDialog.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(usernameField.getX(), usernameField.getY() + 80, 300, 30);
		passwordField.setBackground(Color.LIGHT_GRAY);
		loginDialog.add(passwordField);

		loginButton = new JButton("Login");
		loginButton.setBounds(passwordField.getX() + 25, passwordField.getY() + 100, 130, 40);
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginDialog.add(loginButton);

		loginButton.addActionListener(this);

		message = new JLabel();
		message.setBounds(passwordField.getX(), passwordField.getY() + 40, 300, 30);
		message.setBackground(Color.BLACK);
		loginDialog.add(message);

		loginDialog.setBounds(500, 120, 500, 500);
		loginDialog.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		System.out.println("clicked before if");

		Login login=new Login();
		if (STATUS_CODE == 1) {
			if (!(username.isEmpty()) && !(password.isEmpty())) {
				// Close button
				System.out.println(username);
				System.out.println(password);
				
				try {
					LandingPage.success = login.librarianLogin(username, password);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		} else if (STATUS_CODE == 2) {
			try {
				LandingPage.success=login.studentLogin(username, password);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (STATUS_CODE == 3) {

		}
		
		
		if(LandingPage.success) {
			message.setText(messageSuccess);
			loginButton.setVisible(false);
			//loginDialog.dispose();
			
			}
			else {
				message.setText(messageFailure);
			}

	}

}
