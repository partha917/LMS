package com.parthad.gui;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Text extends JComponent {

	public static JLabel label;
	public static int height = 200;
	public static int width = 200;

	public static void setLabel(JDialog dialog, String text, int x, int y) {
		label = new JLabel(text);
		// label.setBounds(x, y, width, height);
		dialog.add(label);
	}

}
