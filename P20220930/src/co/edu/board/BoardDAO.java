package co.edu.board;

import java.util.Scanner;


// 기능만 
public class BoardDAO {
	// Singleton 방식의 인스턴스 생성
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100];
	
	// 1.글등록
	public void addBoard() {
		System.out.println("글등록 기능");
		System.out.print("글번호를 입력 >> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		System.out.println("글제목입력 >> ");
		String title = scn.nextLine();
		System.out.println("글내용입력 >> ");
		String content = scn.nextLine();
		
		Board brd = new Board(bNo, title, content);
		// 배열 등록
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] == null) {
				myBoards[i] = brd;
				break;
			}
		}
	}
	
	// 2.글목록
	public void boardList() {
		System.out.println("글목록 기능");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			}
		}
	}
	
	// 3.글상세보기
	public void boardDetail() {
		System.out.println("글상세보기");
		System.out.print("글번호를 입력 >> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		boolean check = false;
		for (int i = 0; i <myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo) {
				System.out.println(myBoards[i].toString());
				check = true;
			}
		}
		if(check == false) {
			System.out.println("해당 글은 없습니다");
		}
	}
	// 4.글삭제
	public void delBoard() {
		System.out.println("글삭제 기능");
		System.out.print("글번호를 입력 >> ");
		int bNo = scn.nextInt();
		scn.nextLine();
		boolean check = false;
		for (int i = 0; i <myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo) {
				myBoards[i] = null;
				System.out.println("삭제되었습니다");
				check = true;
			}
		}
		if(check == false) {
			System.out.println("해당 글은 없습니다");
		}
	}
		
	// 5.전체 메뉴
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println("1.글등록 2.글목록 3.글상세보기 4.글삭제 9.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			switch(menu){
				case 1: 
					addBoard(); 
					break;
				case 2:
					boardList();
					break;
				case 3:
					boardDetail();
					break;
				case 4:
					delBoard();
					break;
				case 9:
					run = false;
					break;
				default:
					System.out.println("잘못된 입력입니다.");
					
			}
		}
		System.out.println("프로그램 종료");
	} // end of exe()
}
