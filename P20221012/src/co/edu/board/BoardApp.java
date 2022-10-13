package co.edu.board;

import java.util.List;
import java.util.Scanner;

// main
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		String id = null;
		String pw = null;
		while(true) {
			System.out.println("아이디 입력>> ");
			id = scn.nextLine();
			System.out.println("비밀번호 입력>> ");
			pw = scn.nextLine();
			if(dao.rogin(id, pw) == 0) {
				break;
			} else if(dao.rogin(id, pw) == -1) {
				System.out.println("잘못된 아이디입니다");
			} else if(dao.rogin(id, pw) == -2){
				System.out.println("잘못된 비밀번호입니다");
			}
		}
		while(true) {
			System.out.println("메뉴) 1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 6.내댓글보기 9.종료");
			int menu = readInt("선택>> ");
			if(menu == 1) {
				System.out.println("==글등록==");
				int num = readInt("글번호>>");
				System.out.println("글제목>>");
				String title = scn.nextLine();
				System.out.println("글내용>>");
				String content = scn.nextLine();
				Board board = new Board(num, title, content, id, null, 0);
				dao.insert(board);
			}else if(menu == 2) {
				System.out.println("==글수정==");
				int num = readInt("수정할 글번호>>");
				System.out.println("수정할 글내용>>");
				String content = scn.nextLine();
				Board board = new Board(num, null, content, id, null, 0);
				dao.update(board);
			}else if(menu == 3) {
				System.out.println("==글삭제==");
				int num = readInt("삭제할 글번호>>");
				Board board = new Board(num, null, null, id, null, 0);
				dao.delete(board);
			}else if(menu == 4) {
				int pageSet = 10;
				int page = 1;
				int order = 1;
				while(true) {
					System.out.println("==글목록==");
					String orderWord = null;
					switch (order) {
					case 1:
						orderWord = "글번호 오름차순";
						break;
					case 2:
						orderWord = "글번호 내림차순";
						break;
					case 3:
						orderWord = "작성일시 오름차순";
						break;
					case 4:
						orderWord = "작성일시 내림차순";
						break;
					case 5:
						orderWord = "조회수 오름차순";
						break;
					case 6:
						orderWord = "조회수 내림차순";
						break;
					}
					System.out.println("==========================================================");
					System.out.println("현재 페이지 : <" + page + "> 설정)) 글목록: " + pageSet + "개씩, 순서: " + orderWord);
					List<Board> boards = dao.search(order);
					for (int i=((page-1)*pageSet) ; i<(page*pageSet); i++) {
						if(i == boards.size() ){
							break;
						}else if(boards.get(i) != null) {
						System.out.println(boards.get(i).getBoardList());
						}
					}
					System.out.println("==========================================================");
					if(page == 1) {
						System.out.println("메뉴) 2.다음페이지>>   3.글목록갯수설정 4.목록정렬설정 9.뒤로가기");
					}else if(((page*pageSet)+1)>boards.size()) {
						System.out.println("메뉴) 1.<<이전페이지 			     3.글목록갯수설정 4.목록정렬설정 9.뒤로가기");
					}else {
						System.out.println("메뉴) 1.<<이전페이지 2.다음페이지>>   3.글목록갯수설정 4.목록정렬설정 9.뒤로가기");
					}
					int subMenu = readInt("선택>> ");
					if (subMenu == 1) {
						if(page == 1) {
							System.out.println("첫 페이지는 입니다");
						}else {
							page --;
						}
					}else if(subMenu == 2) {
						if(((page*pageSet)+1)>boards.size()) {
							System.out.println("다음 페이지는 없습니다");
						}else {
							page ++;
						}
					}else if(subMenu == 3) {
						pageSet = readInt("원하는 글목록갯수입력>> ");
						page = 1;
					}else if(subMenu == 4) {
						System.out.println("목록정렬) 1.글번호 오름차순 2.글번호 내림차순 3.작성일시 오름차순 4.작성일시 내림차순 5.조회수 오름차순 6.조회수 내림차순 ");
						int orMenu = readInt("선택>> ");
						if(0 < orMenu && orMenu < 7) {
							order = orMenu;
						}else {
							System.out.println("잘못된 목록정렬 선택입니다. 설정을 다시 해주세요");
						}
					}else if(subMenu == 9) {
						System.out.println("글목록을 나갑니다");
						break;
					}else {
						System.out.println("잘못된 선택입니다");
					}
				}
			}else if(menu == 5) {
				System.out.println("==상세조회==");
				int num = readInt("조회할 글번호>>");
				Board board = dao.getBoard(num);
				if (board != null) {
					while(true) {
						System.out.println("<<"+num+"번글>>");
						System.out.println(board.toString());
						System.out.println("<댓글>");
						List<Reply> reps = dao.getReps(num);
						for (Reply rep : reps) {
							System.out.println(rep.toString());
						}
						System.out.println("메뉴) 1.댓글작성 2.댓글수정 3.댓글삭제 9.뒤로가기");
						int subMenu = readInt("선택>> ");
						if(subMenu == 1) {
							System.out.println("==댓글작성==");
							System.out.println("댓글내용>>");
							String content = scn.nextLine();
							Reply rep = new Reply(0, num, content, id, null);
							dao.insertReq(rep);
						}else if (subMenu == 2) {
							System.out.println("==댓글수정==");
							int repNum = readInt("수정할 댓글번호>>");
							System.out.println("수정할 댓글내용>>");
							String content = scn.nextLine();
							Reply rep = new Reply(repNum, 0, content, id, null);
							dao.updateReq(rep);
						}else if (subMenu == 3) {
							System.out.println("==댓글삭제==");
							int repNum = readInt("삭제할 댓글번호>>");
							Reply rep = new Reply(repNum, 0, null, id, null);
							dao.deleteReq(rep);
						}else if (subMenu == 9) {
							System.out.println("상세조회를 나갑니다");
							break;
						}else {
							System.out.println("잘못된 선택입니다");
						}
					}	
				}else {
					System.out.println("해당 글번호는 없는 번호입니다");
				}
			}else if(menu == 6) {
				while(true) {
					System.out.println("==내댓글보기==");
					List<Reply> reps = dao.getMyRepList(id);
					for (Reply rep : reps) {
						System.out.println(rep.getMyRep());
					}
					System.out.println("메뉴) 1.댓글수정 2.댓글삭제 9.뒤로가기");
					System.out.println("선택>> ");
					int subMenu = Integer.parseInt(scn.nextLine());
					if (subMenu == 1) {
						System.out.println("==댓글수정==");
						int repNum = readInt("수정할 댓글번호>>");
						System.out.println("수정할 댓글내용>>");
						String content = scn.nextLine();
						Reply rep = new Reply(repNum, 0, content, id, null);
						dao.updateReq(rep);
					}else if (subMenu == 2) {
						System.out.println("==댓글삭제==");
						int repNum = readInt("삭제할 댓글번호>>");
						Reply rep = new Reply(repNum, 0, null, id, null);
						dao.deleteReq(rep);
					}else if (subMenu == 9) {
						System.out.println("상세조회를 나갑니다");
						break;
					}else {
						System.out.println("잘못된 선택입니다");
					}
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
	
	public static int readInt(String msg) {
		Scanner scn = new Scanner(System.in);
		int result = -1;
		while (true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException  e) {
				System.out.println("숫자를 입력해주세요!");
			}
		}
		return result;
	}
}
