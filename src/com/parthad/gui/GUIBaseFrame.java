package com.parthad.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIBaseFrame extends JFrame {

	public static final String TITLE = "Library Management System";
	public static JFrame mainFrame;
	public static JPanel landingPage;
	public static JPanel panel4;

	public GUIBaseFrame() {
		mainFrame = new JFrame(TITLE);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setExtendedState(MAXIMIZED_BOTH);
		//panel4=new DemoPanel4();
	}

	public static void main(String[] args) {
		new GUIBaseFrame();
		landingPage = new LandingPage(mainFrame);
		mainFrame.add(landingPage);

	}

}
