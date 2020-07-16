package com.parthad.cnostatnts;

public enum TextFields {

	/*
	 * USERNAMEFIELD("usernamefield"), IDBOOKEFIELD("idbookefield"),
	 * RETURNDATEFIELD("returndatefield"), IDSTUDENTFIELD("idstudentfield"),
	 * FIRSTNAMEFIELD("firstnamefield"), LASTNAMEFIELD("lastnamefield"),
	 * DEPTFIELD("deptfield"), CONTACTFIELD("contactfield"),
	 * EMAILFIELD("emailfield"), PRICEFIELD("pricefield"), QTYFIELD("qtyfield"),
	 * AUTHORFIELD("authorfield"), BOOKNAMEFIELD("booknamefield");
	 * 
	 */
	USERNAMEFIELD("usernameField"), IDBOOKFIELD("idBookField"), IDSTUDENTFIELD("idStudentField"),
	RETURNDATEFIELD("returnDateField"), FIRSTNAMEFIELD("firstNameField"), LASTNAMEFIELD("lastNameField"),
	DEPTFIELD("deptField"), CONTACTFIELD("contactField"), EMAILFIELD("emailField"), PRICEFIELD("priceField"),
	QTYFIELD("qtyField"), AUTHORFIELD("authorField"), BOOKNAMEFIELD("bookNameField");

	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor - cannot be public or protected
	private TextFields(String action) {
		this.action = action;
	}

}