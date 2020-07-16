package com.parthad.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayDataPanel extends JPanel {

	public static JPanel home;
	public static JTable jt;
	public static JScrollPane sp;

	public DisplayDataPanel(JFrame guiBaseFrame) {
		System.out.println("In display");
		// this.setLayout(new BorderLayout());
		//this.setLayout(new BorderLayout());
		this.setLayout(new BorderLayout(5,5));
		System.out.println(this.getLayout());
		
		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };
		jt = new JTable(data, column);
		// jt.setBounds(100, 200, 800, 600);
		//jt.setBounds(0, 0, 200, 300);

		sp = new JScrollPane(jt);
		//jt.setFillsViewportHeight(true);
		this.add(sp);
		this.setSize(1920, 1080);
		//this.setBounds(0, 0, 1920, 1080);
		
		//
		// this.setBackground(Color.LIGHT_GRAY);
		// this.setVisible(true);

	}

}
