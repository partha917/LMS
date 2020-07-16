package com.parthad.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DemoPanel4 extends JPanel {

	public JButton b1;
	public static JButton b2;
	public static JButton b3;
	
	public DemoPanel4(){
		
		this.setBounds(0,0,1080,1920);
		this.setBackground(Color.GRAY);
		this.setLayout(null);;
		
		b1=new JButton("New Button");
		b1.setBounds(100, 100, 100, 100);
		b1.setBackground(Color.RED);
		this.add(b1);
		//b2=Button.setButton(this, "Hellpo", 100, 100);
	}

}
