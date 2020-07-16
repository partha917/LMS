package com.parthad.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Button extends JPanel {

	public static JButton button;
	public static int height = 100;
	public static int width = 500;

	public static int librarianHeight = 80;
	public static int librarianWidth = 200;

	public static int dialogHeight = 30;
	public static int dialogWidth = 60;

	public static JButton addButton(JPanel panel, String text, int x, int y) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		panel.add(button);
		return button;
	}

	public static JButton addLibrarianButton(JPanel panel, String text, int x, int y) {
		button = new JButton(text);
		button.setBounds(x, y, librarianWidth, librarianHeight);
		panel.add(button);
		return button;
	}

	public static JButton addDialogButton(JDialog dialog, String text, int x, int y) {
		button = new JButton(text);
		button.setBounds(x, y, dialogWidth, dialogHeight);
		button.setBackground(Color.GRAY);
		dialog.add(button);
		return button;
	}

}
