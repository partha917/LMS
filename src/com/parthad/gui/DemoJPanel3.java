package com.parthad.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.parthad.cnostatnts.LibrarianInput;

public class DemoJPanel3 extends JPanel {

	public static JButton b1;
	public static JButton b2;
	public static JButton b3;
	public JPanel panel4=null;
	public DemoJPanel3(JFrame f,JPanel panel) {
		this.setBounds(0,0,600,800);
		this.setBackground(Color.BLUE);
		DemoJPanel3.b1=new JButton("FROM demoPanel 3");
		b1.setBounds(100,100,100,100);
		b1.setBackground(Color.RED);
		this.add(b1);
		
		b2=Button.addButton(this, "Hello", 300,300);
		this.add(b2);
		
		b3=Button.addButton(this, "Hello", 500,500);
		this.add(b3);
		
		
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4=new DemoPanel4();
				f.remove(DemoJPanel3.this);
				//f.add(panel);
				f.add(panel4);
				f.repaint();
				
			}
			
		});
		
		
	}

	
	
	
	
	
}
