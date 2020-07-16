package com.parthad.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.parthad.cnostatnts.LibrarianInput;
import com.parthad.main.Action;

public class LibrarianDialog extends JDialog implements ActionListener {

	public static JDialog lDialog;
	public static final String TITLE_ISSUEBOOK = "Issue Book";

	public static final String messageFailure = "Invalid input!!";
	public static final String messageSuccess = "Successfully updated.";
	public static JLabel message;

	// Submit Button
	public static JButton submit;

	// JLebes
	public static JLabel usernameLabel;
	// public static JLabel idBookLabel;
	// public static JLabel returnDate;
	public static JLabel idStudentLabel;
	public static JLabel idBookLabel;
	public static JLabel returnDateLabel;
	public static JLabel firstNameLabel;
	public static JLabel lastNameLabel;
	public static JLabel deptLabel;
	public static JLabel contactLabel;
	public static JLabel emailLabel;
	// --Book TextLabel
	public static JLabel priceLabel;
	public static JLabel qtyLabel;
	public static JLabel authorLabel;
	public static JLabel bookNameLabel;
	public static JLabel categoryLabel;
	public static JLabel shelfLabel;

	// JTextFields
	public static JTextField usernameField;
	public static JTextField idBookeField;
	public static JTextField returnDateField;
	public static JTextField idStudentField;
	public static JTextField firstNameField;
	public static JTextField lastNameField;
	public static JTextField deptField;
	public static JTextField contactField;
	public static JTextField emailField;
	// --Book TextField
	public static JTextField priceField;
	public static JTextField qtyField;
	public static JTextField authorField;
	public static JTextField bookNameField;
	public static JTextField categoryField;
	public static JTextField shelfField;

	// positions
	public static int width = 300;
	public static int height = 30;
	public static int d = 50;

	public static int xLebel = 20;
	public static int xField = 130;
	public static int Y = 100;

	// Initialize enums
	public static LibrarianInput libInput;

	// Create a Map for storing the data
	public static HashMap<JLabel, String> map;

	public static ArrayList<JLabel> asLabel;
	public static ArrayList<JTextField> asField;

	public static int STATUS_CODE;

	public static boolean success;
	public static Thread thread;

	public static JFrame guiBaseFrame;

	public LibrarianDialog(JFrame guiBaseFrame, int STATUS_CODE, JPanel librarianHome)
			throws ClassNotFoundException, SQLException {
		lDialog = new JDialog(guiBaseFrame, TITLE_ISSUEBOOK, true);
		LibrarianDialog.guiBaseFrame = guiBaseFrame;

		lDialog.setLayout(null);
		Y = 100;
		LibrarianDialog.STATUS_CODE = STATUS_CODE;
		if (STATUS_CODE == 1) {
			issueBookDialog();
		} else if (STATUS_CODE == 2) {
			addStudnetDialog();
		} else if (STATUS_CODE == 3) {
			addBookDialog();
		} else if (STATUS_CODE == 4) {
			new DisplayFrameGUI(lDialog);
		} else if (STATUS_CODE == 5 ) {
			searchBookDialog();
		} else if (STATUS_CODE == 6) {
			new DisplayFrameGUI(lDialog);
			// View all issued books
		} else if (STATUS_CODE == 7) {
			// View My Issued Books
			new DisplayFrameGUI(lDialog);
		} else if (STATUS_CODE == 8) {
			// Check Student Details
			new DisplayFrameGUI(lDialog);
		} else if (STATUS_CODE == 9) {
			// new DisplayFrameGUI(lDialog);
			updateBookDetails();
		} else if (STATUS_CODE == 10) {
			// new DisplayFrameGUI(lDialog);
			updateStudentDetails();
		} else if (STATUS_CODE == 11) {
			// new DisplayFrameGUI(lDialog);
			submitBook();
		} else if (STATUS_CODE == 13) {
			new DisplayFrameGUI(lDialog);
		}

		/*
		 * else if (STATUS_CODE == 4) { new DisplayFrameGUI(); // Display Books } else
		 * if (STATUS_CODE == 5) { new DisplayFrameGUI(); // Search Book } else if }
		 * (STATUS_CODE == 6) { new DisplayFrameGUI(); // viewIssued Books } else if
		 * (STATUS_CODE == 7) { // view My issued books new DisplayFrameGUI(); } else if
		 * (STATUS_CODE == 8) { new DisplayFrameGUI(); // checkstudent Deatils } else if
		 * (STATUS_CODE == 9) { new DisplayFrameGUI(); // update student details } else
		 * if (STATUS_CODE == 10) { new DisplayFrameGUI(); // update book details } else
		 * if (STATUS_CODE == 11) { new DisplayFrameGUI(); // submit book } else if
		 * (STATUS_CODE == 12) { new DisplayFrameGUI(); // update personal info } else
		 * if (STATUS_CODE == 13) { new DisplayFrameGUI(); // update password }
		 */

		if (STATUS_CODE == 1 || STATUS_CODE == 2 || STATUS_CODE == 3 || STATUS_CODE == 5 || STATUS_CODE == 10
				|| STATUS_CODE == 9 || STATUS_CODE == 11) {

			submit.addActionListener(this);

			lDialog.setBounds(500, 120, 500, 500);
			lDialog.setVisible(true);
			lDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		}

	}

	public static void issueBookDialog() {
		takeBookID();
		takeStuID();
		takeReturnDate();
		submitButton(Y + 50);
	}

	public static void addStudnetDialog() {
		Y = Y - 60;
		takeStuID();
		takeFirstName();
		takeLastName();
		takeDept();
		takeContactNO();
		takeEmail();
		takeUsername();
		submitButton(Y + 20);
	}

	public static void addBookDialog() {
		Y = Y - 60;
		takeBookID();
		takeBookName();
		takeBookAuthor();
		takeBookCategory();
		takeBookShelf();
		takeBookQty();
		takeBookPrice();
		submitButton(Y + 20);

	}

	public static void submitBook() {
		takeBookID();
		takeStuID();
		submitButton(Y + 100);
	}

	public static void searchBookDialog() {
		takeBookName();
		submitButton(Y + 70);
	}

	public static void updateStudentDetails() {
		addStudnetDialog();
	}

	public static void updateBookDetails() {
		addBookDialog();
	}

	private static void takeBookPrice() {
		priceLabel = createLabel(LibrarianInput.PRICE.getAction());
		priceField = createField();

	}

	private static void takeBookQty() {
		qtyLabel = createLabel(LibrarianInput.QTY.getAction());
		qtyField = createField();

	}

	private static void takeBookShelf() {
		shelfLabel = createLabel(LibrarianInput.SHELF.getAction());
		shelfField = createField();

	}

	private static void takeBookCategory() {
		categoryLabel = createLabel(LibrarianInput.CATEGORY.getAction());
		categoryField = createField();

	}

	private static void takeBookAuthor() {
		authorLabel = createLabel(LibrarianInput.AUTHOR_NAME.getAction());
		authorField = createField();

	}

	private static void takeBookName() {
		libInput = LibrarianInput.BOOK_NAME;
		bookNameLabel = createLabel(libInput.getAction());
		bookNameField = createField();

	}

	public static void takeUsername() {
		libInput = LibrarianInput.USERNAME;
		usernameLabel = createLabel(libInput.getAction());
		usernameField = createField();

	}

	public static void takeEmail() {
		emailLabel = createLabel(LibrarianInput.EMAIL.getAction());
		emailField = createField();

	}

	public static void takeContactNO() {
		contactLabel = createLabel(LibrarianInput.CONTACT_NO.getAction());
		contactField = createField();

	}

	public static void takeDept() {
		deptLabel = createLabel(LibrarianInput.DEPT.getAction());
		deptField = createField();

	}

	public static void takeLastName() {
		lastNameLabel = createLabel(LibrarianInput.LASTNAME.getAction());
		lastNameField = createField();

	}

	public static void takeFirstName() {
		firstNameLabel = createLabel(LibrarianInput.FIRSTNAME.getAction());
		firstNameField = createField();

	}

	// Need to be updated

	public static void takeLibID() {

		libInput = LibrarianInput.ID;
		usernameLabel = createLabel(libInput.getAction());
		usernameField = createField();
		// Y = Y + d;
	}

	public static void takeBookID() {
		libInput = LibrarianInput.BOOK_ID;
		idBookLabel = createLabel(libInput.getAction());
		idBookeField = createField();
	}

	public static void takeStuID() {
		libInput = LibrarianInput.STUDENT_ID;
		idStudentLabel = createLabel(libInput.getAction());
		idStudentField = createField();
		// Y = Y + d;
	}

	public static void takeReturnDate() {
		libInput = LibrarianInput.RETURN_DATE;
		returnDateLabel = createLabel(libInput.getAction());
		returnDateField = createField();
		// Y = Y + d;
	}

	public static JTextField createField() {
		JTextField textField = new JTextField();
		textField.setBounds(xField, Y, width, height);
		textField.setBackground(Color.LIGHT_GRAY);
		lDialog.add(textField);
		Y = Y + d;
		return textField;
	}

	public static JLabel createLabel(String input) {
		JLabel label = new JLabel(input);
		label.setBounds(xLebel, Y, width, height);
		lDialog.add(label);
		return label;

	}

	public static void submitButton(int d) {
		submit = new JButton("Submit");
		submit.setBounds(xField + 35, d, 130, 40);
		lDialog.add(submit);

	}

	public static void setErrorMessage(int d, boolean flag) throws InterruptedException {

		if (flag) {
			message = new JLabel(messageSuccess);
		} else {
			message = new JLabel(messageFailure);

		}
		message.setBounds(xField, Y - d, width, height);
		lDialog.setBackground(Color.BLACK);

		lDialog.add(message);

		/*
		 * if(success==false) { thread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { try { System.out.println("Thread started");
		 * lDialog.add(message); Thread.sleep(1000); message.setText(""); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 * 
		 * } }); thread.start(); } else { lDialog.add(message);
		 * 
		 * }
		 */

		System.out.println("Error message set");
		success = false;

	}

	public static void createArray() {

		asField = new ArrayList<JTextField>();
		asField.add(usernameField);
		asField.add(idBookeField);
		asField.add(returnDateField);
		asField.add(idStudentField);
		asField.add(firstNameField);
		asField.add(lastNameField);
		asField.add(deptField);
		asField.add(contactField);
		asField.add(emailField);
		asField.add(priceField);
		asField.add(qtyField);
		asField.add(authorField);
		asField.add(bookNameField);
		asField.add(categoryField);
		asField.add(shelfField);

		asLabel = new ArrayList<JLabel>();
		asLabel.add(usernameLabel);
		asLabel.add(idBookLabel);
		asLabel.add(returnDateLabel);
		asLabel.add(idStudentLabel);
		asLabel.add(firstNameLabel);
		asLabel.add(lastNameLabel);
		asLabel.add(deptLabel);
		asLabel.add(contactLabel);
		asLabel.add(emailLabel);
		asLabel.add(priceLabel);
		asLabel.add(qtyLabel);
		asLabel.add(authorLabel);
		asLabel.add(bookNameLabel);
		asLabel.add(categoryLabel);
		asLabel.add(shelfLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			map = new HashMap<JLabel, String>();
			createArray();
			// message.setText("");
			for (int i = 0; i < asLabel.size(); i++) {
				if (asLabel.get(i) != null) {
					map.put(asLabel.get(i), asField.get(i).getText());
				}
			}
			System.out.println("Submit button clicked");

			if (STATUS_CODE == 1) {
				success = Action.issueBookGUI(map);

			} else if (STATUS_CODE == 2) {
				success = Action.addStudentGUI(map, STATUS_CODE, lDialog);

			} else if (STATUS_CODE == 3) {
				success = Action.addBookGUI(map, STATUS_CODE, lDialog);

			} else if (STATUS_CODE == 5 ) {
				success = Action.searchBookGUI(map, lDialog);

			} else if (STATUS_CODE == 9) {

				success = Action.addBookGUI(map, STATUS_CODE, lDialog);

			} else if (STATUS_CODE == 10) {

				success = Action.addStudentGUI(map, STATUS_CODE, lDialog);

			} else if (STATUS_CODE == 11) {
				success = Action.sumbitBookGUI(map);
			}

		} catch (Exception exception) {
			// TODO: handle exception
			System.out.println(exception.getMessage());
		}

		if (success) {
			submit.setVisible(false);
		}
		// message = null;
		try {
			setErrorMessage(20, success);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

/*
 * 
 * 
 * 
 * 
 * LibrarianDialog<--->Action if(true) Dialog submit button is hidden.
 * 
 * It doesnt gives back the response to the LibrarianHome
 * 
 * 
 * if(false){ Dialog stays as it is.
 * 
 */
