package co.edu.board;

import java.util.List;
import java.util.Scanner;

// main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("메뉴) 1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 9.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu == 1) {
				System.out.println("==글등록==");
				System.out.println("글번호>>");
				int num = Integer.parseInt(scn.nextLine());
				System.out.println("글제목>>");
				String title = scn.nextLine();
				System.out.println("글내용>>");
				String content = scn.nextLine();
				System.out.println("작성자>>");
				String writer = scn.nextLine();
				Board board = new Board(num, title, content, writer, null, 0);
				dao.insert(board);
			}else if(menu == 2) {
				System.out.println("==글수정==");
				System.out.println("수정할 글번호>>");
				int num = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 글내용>>");
				String content = scn.nextLine();
				dao.update(num, content);
			}else if(menu == 3) {
				System.out.println("==글삭제==");
				System.out.println("삭제할 글번호>>");
				int num = Integer.parseInt(scn.nextLine());
				dao.delete(num);
			}else if(menu == 4) {
				System.out.println("==글목록==");
				List<Board> boards = dao.search();
				for (Board board : boards) {
					System.out.println(board.getBoardList());
				}
			}else if(menu == 5) {
				System.out.println("==상세조회==");
				System.out.println("조회할 글번호>>");
				int num = Integer.parseInt(scn.nextLine());
				Board board = dao.getBoard(num);
				if (board != null) {
					System.out.println(board.toString());
				}else {
					System.out.println("해당 글번호는 없는 번호입니다");
				}
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("잘못된 메뉴입니다");
			}
		}
		
		scn.close();
		System.out.println("프로그램 종료");
	}
}
