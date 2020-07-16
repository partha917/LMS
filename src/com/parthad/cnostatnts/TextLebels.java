package com.parthad.cnostatnts;

import javax.swing.JTextField;

public enum TextLebels {

	USERNAMELABEL("usernameLabel"), IDBOOKLABEL("idBookLabel"), IDSTUDENTLABEL("idStudentLabel"),
	RETURNDATELABEL("returnDateLabel"), FIRSTNAMELABEL("firstnameLabel"), LASTNAMELABEL("lastnameLabel"),
	DEPTLABEL("deptLabel"), CONTACTLABEL("contactLabel"), EMAILLABEL("emailLabel"), PRICELABEL("priceLabel"),
	QTYLABEL("qtyLabel"), AUTHORLABEL("authorLabel"), BOOKNAMELABEL("bookNameLabel");

	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor - cannot be public or protected
	private TextLebels(String action) {
		this.action = action;
	}

}
