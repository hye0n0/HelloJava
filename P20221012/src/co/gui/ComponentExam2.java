package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class ComponentExam2 extends JFrame{
	
	public ComponentExam2() {
		setTitle("입력필드 UI");
		setSize(350, 150);
		Dimension lblDim = new Dimension(60, 16);
		
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel(new FlowLayout());
		JPanel bottom = new JPanel();
		
		JLabel idLb1 = new JLabel("id");
		idLb1.setPreferredSize(lblDim);
		JLabel pwLb1 = new JLabel("password");
		pwLb1.setPreferredSize(lblDim);
		JTextField idTxt = new JTextField(23);
		JPasswordField pwTxt = new JPasswordField(23);
		
		center.add(idLb1);
		center.add(idTxt);
		center.add(pwLb1);
		center.add(pwTxt);
		
		JButton btn = new JButton("확인");
		
		bottom.add(btn);
		
	
		add("Center",center);
		add("South",bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new ComponentExam2();
	}
}
