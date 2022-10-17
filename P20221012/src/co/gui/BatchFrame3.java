package co.gui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class BatchFrame3 extends JFrame{
	public BatchFrame3() {
		setTitle("GridLayout 배치");
		setSize(350,250);
		
		setLayout(new GridLayout(2,3));
		JButton btn1 = new JButton("확인1");
		JButton btn2 = new JButton("확인2");
		JButton btn3 = new JButton("확인3");
		JButton btn4 = new JButton("확인4");
		JButton btn5 = new JButton("확인5");
		JButton btn6 = new JButton("확인6");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new BatchFrame3();
	}
}
