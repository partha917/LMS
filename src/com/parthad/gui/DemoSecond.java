package com.parthad.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.parthad.cnostatnts.LibrarianInput;

public class DemoSecond extends JFrame {

	public static JFrame f;
	public static JPanel panel;
	public static JPanel panel2;
	public static JPanel panel3;
	public static DemoJPanel3 panel4;

	public DemoSecond() throws IOException {
		f = new JFrame("Panel Example");
		f.setBounds(0, 0, 1080, 1920);
		//f.setExtendedState(MAXIMIZED_BOTH);
		
		f.setLayout(null);
		f.setVisible(true);
		panel = new JPanel();
		panel.setEnabled(true);
		panel.setBounds(0,0,800,1200);
		//panel.setBackground(Color.BLACK);
		//BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\parthad\\Documents\\Projects\\lib00.png"));
		JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\parthad\\Documents\\Projects\\lib00.png"));
		//JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		imgLabel.setBounds(0, 0, 800, 1200);
		panel.add(imgLabel);
		
		
		f.add(panel);
		
		
		
	}

	public static void main(String[] args) throws IOException {
		
		
		new DemoSecond();
			
	}
	

}
