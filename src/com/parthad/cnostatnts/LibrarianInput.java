package com.parthad.cnostatnts;

public enum LibrarianInput {

	ID("Enter ID: "), USERNAME("Enter Username: "), LIB_PASSWORD("Enter Password: "), LIB_JOININIGDATE(""),
	FIRSTNAME("Enter Firstname: "), LASTNAME("Enter Lastname: "), DEPT("Enter Dept: "), CONTACT_NO("Enter contact: "),
	EMAIL("Enter Email"), BOOK_ID("Enter Book ID: "), BOOK_NAME("Enter Book Name: "),
	AUTHOR_NAME("Enter Author name: "), CATEGORY("Enter Category: "), SHELF("Enter Shelf: "), QTY("Enter qty: "),
	PRICE("Enter Price: "),RETURN_DATE("Enter Return Date: "),STUDENT_ID("Enter Student ID: ");

	// declaring private variable for getting values
	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor - cannot be public or protected
	private LibrarianInput(String action) {
		this.action = action;
	}
}
