package co.gui;

import java.awt.FlowLayout;

import javax.swing.*;

public class BatchFrame extends JFrame{
	
	public BatchFrame() {
		setTitle("배치관리자 UI");
		setSize(300, 250);
		// 화면구성
		setLayout (new FlowLayout()); //배치관리자 FlowLayout();
		
		JButton btn1 = new JButton("확인");
		JButton btn2 = new JButton("취소");
		JButton btn3 = new JButton("추가");
		JButton btn4 = new JButton("수정");
		JButton btn5 = new JButton("삭제");
		JButton btn6 = new JButton("조회");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BatchFrame();
	}
}
