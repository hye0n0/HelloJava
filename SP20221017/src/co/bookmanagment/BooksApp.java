package co.bookmanagment;

import java.util.List;
import java.util.Scanner;

public class BooksApp { // main
	public static void main(String[] args) {
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		String id = null;
		String pw = null;
		int userNum = -1;
		while (true) {
			System.out.println();
			System.out.println("<<로그인화면>>");
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.로그인 2.회원가입 0.종료");
			int menu = readInt("선택>>  ");
			if (menu == 1) { // 로그인
				System.out.println();
				System.out.print("아이디 입력>>  ");
				id = scn.nextLine();
				System.out.print("비밀번호 입력>>  ");
				pw = scn.nextLine();
				userNum = dao.rogin(id, pw);
				if (userNum >= 1) {
					System.out.println();
					System.out.println("<<로그인 성공했습니다>>");
					BookM(id, userNum);
				} else if (userNum == -1) {
					System.out.println();
					System.out.println("<<잘못된 아이디입니다>>");
				} else if (userNum == -2) {
					System.out.println();
					System.out.println("<<잘못된 비밀번호입니다>>");
				}
			} else if (menu == 2) { // 회원가입
				System.out.println();
				System.out.print("아이디 입력>>  ");
				id = scn.nextLine();
				System.out.print("비밀번호 입력>>  ");
				pw = scn.nextLine();
				System.out.print("이름 입력>>  ");
				String name = scn.nextLine();
				Member member = new Member(0, id, pw, name);
				dao.createUser(member);
			} else if (menu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
		scn.close();
		System.out.println();
		System.out.println("<<프로그램 종료>>");
	}// end of main

	public static void BookM(String id, int userNum) { // 전체메뉴
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		if (userNum == 1) { // 매니저 전용메뉴
			while (true) {
				System.out.println();
				System.out.println("<<메인메뉴>>");
				System.out.println(
						"==============================================================================================================");
				System.out
						.println("메뉴)) 1.책등록 2.책수정 3.책삭제 4.전체목록 5.상세조회 6.내도서후기보기 7.북마크 8.대여반납관리 9.회원관리 10.QNA 0.로그아웃");
				int menu = readInt("선택>>  ");
				if (menu == 1) { // 책등록
					insertBook();
				} else if (menu == 2) { // 책수정
					updateBook();
				} else if (menu == 3) { // 책삭제
					System.out.println();
					System.out.println(
							"==============================================================================================================");
					System.out.println("<<책삭제>>");
					int num = readInt("삭제할 책번호>>  ");
					Book book = new Book(num, null, null, null, null, null, null, null);
					dao.delete(book);
				} else if (menu == 4) { // 전체목록
					BooksList();
				} else if (menu == 5) {
					bookSearch(id);
				} else if (menu == 6) {
					myReviews(id);
				} else if (menu == 7) {
					myBookmarks(id);
				} else if (menu == 8) {
					rentReturn(id);
				} else if (menu == 9) {
					members();
				} else if (menu == 10) {
					QnAM(id);
				} else if (menu == 0) {
					System.out.println();
					System.out.println("<<로그아웃합니다>>");
					break;
				} else {
					System.out.println();
					System.out.println("<<잘못된 선택입니다>>");
				}
			}
		} else if (userNum > 1) { // 일반회원
			while (true) {
				System.out.println();
				System.out.println("<<메인메뉴>>");
				System.out.println(
						"==============================================================================================================");
				System.out.println("메뉴)) 1.전체목록 2.상세조회 3.내도서후기보기 4.북마크 5.대여중인도서 6.QNA 0.로그아웃");
				int menu = readInt("선택>> ");
				if (menu == 1) {
					BooksList();
				} else if (menu == 2) {
					bookSearch(id);
				} else if (menu == 3) {
					myReviews(id);
				} else if (menu == 4) {
					myBookmarks(id);
				} else if (menu == 5) {
					rentBooks(id);
				} else if (menu == 6) {
					QnA(id);
				} else if (menu == 0) {
					System.out.println();
					System.out.println("<<로그아웃합니다>>");
					break;
				} else {
					System.out.println();
					System.out.println("<<잘못된 선택입니다>>");
				}
			}
		}
	} // end of 전체메뉴

	public static void insertBook() { // 책등록메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<책등록>>");
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.입력 2.파일가져오기 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if (submenu == 1) { // 책등록(입력)
				System.out.println();
				System.out.print("글제목>>  ");
				String name = scn.nextLine();
				System.out.print("글쓴이>>  ");
				String writer = scn.nextLine();
				System.out.print("출판사>>  ");
				String publisher = scn.nextLine();
				Book book = new Book(0, name, writer, publisher, null, null, null, null);
				dao.insert(book);
			} else if (submenu == 2) { // 책등록(파일가져오기)
				System.out.println();
				System.out.println("<<책등록(파일가져오기)>>");
				dao.insertFile();
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void updateBook() { // 책수정메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<책수정>>");
			System.out.println(
					"==============================================================================================================");
			int num = readInt("수정할 책번호>>  ");
			Book curBook = dao.getBook(num);
			if (curBook != null) {
				System.out.println("메뉴)) 1.전체수정 2.책이름수정 3.글쓴이수정 4.출판사수정 0.뒤로가기");
				int submenu = readInt("선택>>  ");
				if (submenu == 1) {
					System.out.println();
					System.out.println("<<전체수정>>"); // 전체수정
					System.out.print("수정할 책이름>>  ");
					String name = scn.nextLine();
					System.out.print("수정할 글쓴이>>  ");
					String writer = scn.nextLine();
					System.out.print("수정할 출판사>>  ");
					String publisher = scn.nextLine();
					Book book = new Book(num, name, writer, publisher, null, null, null, null);
					dao.update(book);
				} else if (submenu == 2) { // 책이름만 수정
					System.out.println();
					System.out.println("<<책이름수정>>");
					System.out.print("수정할 책이름>>  ");
					String name = scn.nextLine();
					Book book = new Book(num, name, curBook.getBookWriter(), curBook.getBookPublisher(), null, null,
							null, null);
					dao.update(book);
				} else if (submenu == 3) { // 글쓴이만 수정
					System.out.println();
					System.out.println("<<글쓴이수정>>");
					System.out.print("수정할 글쓴이>>  ");
					String writer = scn.nextLine();
					Book book = new Book(num, curBook.getBookName(), writer, curBook.getBookPublisher(), null, null,
							null, null);
					dao.update(book);
				} else if (submenu == 4) { // 출판사만 수정
					System.out.println();
					System.out.println("<<출판사수정>>");
					System.out.print("수정할 출판사>>  ");
					String publisher = scn.nextLine();
					Book book = new Book(num, curBook.getBookName(), curBook.getBookWriter(), publisher, null, null,
							null, null);
					dao.update(book);
				} else if (submenu == 0) {
					break;
				} else {
					System.out.println();
					System.out.println("<<잘못된 선택입니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 책번호는 없는 책입니다>>");
				break;
			}
		}
	}

	public static void BooksList() { // 책전체목록메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		System.out.println();
		System.out.println("<<전체목록>>");
		System.out.println(
				"==============================================================================================================");
		int pageSet = 10;
		int page = 1;
		int order = 1;
		int search = -1;
		String serWord = "";
		while (true) {
			System.out.println();
			String orderWord = null;
			switch (order) {
			case 1:
				orderWord = "책번호 오름차순";
				break;
			case 2:
				orderWord = "책번호 내림차순";
				break;
			case 3:
				orderWord = "책이름 오름차순";
				break;
			case 4:
				orderWord = "책이름 내림차순";
				break;
			case 5:
				orderWord = "글쓴이 오름차순";
				break;
			case 6:
				orderWord = "글쓴이 내림차순";
				break;
			}
			String searchWord = "";
			switch (search) {
			case 1:
				searchWord = "책이름";
				break;
			case 2:
				searchWord = "글쓴이";
				break;
			case 3:
				searchWord = "출판사";
				break;
			default:
				break;
			}
			if (search == -1) {
				System.out.println("설정)) 현재 페이지 : " + page + " | 글목록: " + pageSet + "개씩 | 순서: " + orderWord);
			} else {
				System.out.println("설정)) 현재 페이지 : " + page + " | 글목록: " + pageSet + "개씩 | 순서: " + orderWord + " | 검색("
						+ searchWord + "): " + serWord);
			}
			System.out.println();
			System.out.println(
					"==============================================================================================================");
			List<Book> books = dao.search(order, search, serWord);
			for (int i = ((page - 1) * pageSet); i < (page * pageSet); i++) {
				if (i == books.size()) {
					break;
				} else if (books.get(i) != null) {
					System.out.printf("책번호: %3s | 책이름: %20s | 글쓴이: %10s | 출판사: %7s  | 대여: %4s \n", books.get(i).getBookId(),
							books.get(i).getBookName(), books.get(i).getBookWriter(), books.get(i).getBookPublisher(), books.get(i).getRenting());
				}
			}
			System.out.println();
			System.out.println(
					"==============================================================================================================");
			if (page == 1) {
				System.out.println("메뉴))              2.다음페이지>>   3.글목록갯수설정 4.목록정렬설정 5.검색 6.검색취소 0.뒤로가기");
			} else if (((page * pageSet) + 1) > books.size()) {
				System.out.println("메뉴)) 1.<<이전페이지                3.글목록갯수설정 4.목록정렬설정 5.검색 6.검색취소 0.뒤로가기");
			} else {
				System.out.println("메뉴)) 1.<<이전페이지 2.다음페이지>>   3.글목록갯수설정 4.목록정렬설정 5.검색 6.검색취소 0.뒤로가기");
			}
			int subMenu = readInt("선택>>  ");
			if (subMenu == 1) {
				if (page == 1) {
					System.out.println();
					System.out.println("<<첫 페이지는 입니다>>");
				} else {
					page--;
				}
			} else if (subMenu == 2) {
				if (((page * pageSet) + 1) > books.size()) {
					System.out.println();
					System.out.println("<<다음 페이지는 없습니다>>");
				} else {
					page++;
				}
			} else if (subMenu == 3) {
				System.out.println();
				pageSet = readInt("원하는 글목록갯수입력>>  ");
				page = 1;
			} else if (subMenu == 4) {
				System.out.println();
				System.out.println("목록정렬)) 1.책번호 오름차순 2.책번호 내림차순 3.책이름 오름차순 4.책이름 내림차순 5.글쓴이 오름차순 6.글쓴이 내림차순 ");
				int orMenu = readInt("선택>>  ");
				if (0 < orMenu && orMenu < 7) {
					order = orMenu;
					page = 1;
				} else {
					System.out.println();
					System.out.println("잘못된 목록정렬 선택입니다. 설정을 다시 해주세요");
				}
			} else if (subMenu == 5) {
				System.out.println();
				System.out.println("<<검색>>");
				System.out.println("검색분야)) 1.책이름 2.글쓴이 3.출판사 ");
				search = readInt("선택>>  ");
				System.out.print("검색어 입력>>  ");
				serWord = scn.nextLine();
				page = 1;
			} else if (subMenu == 6) {
				System.out.println();
				System.out.println("<<검색 취소>>");
				search = -1;
				serWord = "";
				page = 1;
			} else if (subMenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void bookSearch(String id) { // 책상세조회메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		System.out.println();
		System.out.println("<<상세조회>>");
		int num = readInt("조회할 책번호>>  ");
		Book book = dao.getBook(num);
		if (book != null) {
			while (true) {
				book = dao.getBook(num);
				System.out.println();
				System.out.println(
						"==============================================================================================================");
				if (book.getReturnDate() == null) {
					System.out.println(book.toStringY());
				} else {
					System.out.println(book.toStringN());
				}
				System.out.println(
						"==============================================================================================================");
				System.out.println("<<도서후기>>");
				List<Review> revs = dao.getRevList(num);
				for (Review rev : revs) {
					System.out.println(rev.getrevList());
				}
				System.out.println();
				System.out.println(
						"==============================================================================================================");
				System.out.println("메뉴)) 1.대여 2.반납 3.도서후기작성 4.도서후기수정 5.도서후기삭제 6.북마크 0.뒤로가기");
				int submenu = readInt("선택>>  ");
				if (submenu == 1) {
					System.out.println();
					System.out.println("<<대여>>");
					Book rentbook = new Book(num, null, null, null, null, null, null, id);
					dao.rentBook(rentbook);
				} else if (submenu == 2) {
					System.out.println();
					System.out.println("<<반납>>");
					Book returnbook = new Book(num, null, null, null, null, null, null, id);
					dao.returnBook(returnbook);
				} else if (submenu == 3) {
					System.out.println();
					System.out.println("<<도서후기작성>>");
					System.out.println("도서후기 내용>>  ");
					String content = scn.nextLine();
					Review rev = new Review(0, num, content, id, null);
					dao.insertRev(rev);
				} else if (submenu == 4) {
					System.out.println();
					System.out.println("<<도서후기수정>>");
					int revId = readInt("수정할 도서후기번호>>  ");
					System.out.println("수정할 도서후기 내용>>  ");
					String content = scn.nextLine();
					Review rev = new Review(revId, num, content, id, null);
					dao.updateRev(rev);
				} else if (submenu == 5) {
					System.out.println();
					System.out.println("<<도서후기삭제>>");
					int revId = readInt("삭제할 도서후기번호>>  ");
					Review rev = new Review(revId, 0, null, id, null);
					dao.deleteRev(rev);
				} else if (submenu == 6) {
					System.out.println();
					System.out.println("<<북마크>>");
					Bookmark bmk = new Bookmark(0, book.getBookId(), id, book.getBookName(), book.getBookWriter(),
							book.getBookPublisher());
					dao.insertBmk(bmk);
				} else if (submenu == 0) {
					break;
				} else {
					System.out.println();
					System.out.println("<<잘못된 선택입니다>>");
				}
			}
		} else {
			System.out.println();
			System.out.println("<<해당 책번호는 없는 책입니다>>");
		}
	}

	public static void myReviews(String id) { // 내도서후기보기메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<내도서후기보기>>");
			System.out.println(
					"==============================================================================================================");
			List<Review> revs = dao.getMyRev(id);
			for (Review rev : revs) {
				System.out.println(rev.getrevList());
			}
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.도서후기수정 2.도서후기삭제 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if (submenu == 1) {
				System.out.println();
				System.out.println("<<도서후기수정>>");
				int revId = readInt("수정할 도서후기번호>>  ");
				System.out.println("수정할 도서후기 내용>>  ");
				String content = scn.nextLine();
				Review rev = new Review(revId, 0, content, id, null);
				dao.updateRev(rev);
			} else if (submenu == 2) {
				System.out.println();
				System.out.println("<<도서후기삭제>>");
				int revId = readInt("삭제할 도서후기번호>>  ");
				Review rev = new Review(revId, 0, null, id, null);
				dao.deleteRev(rev);
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void myBookmarks(String id) { // 내북마크보기메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<북마크>>");
			System.out.println(
					"==============================================================================================================");
			List<Bookmark> bmks = dao.getMyBmk(id);
			for (Bookmark bmk : bmks) {
				System.out.printf("북마크번호: %3s | 책번호: %3s | 책이름: %20s | 글쓴이: %10s | 출판사: %7s \n", bmk.getMarkId(),
						bmk.getBookId(), bmk.getBookName(), bmk.getBookWriter(), bmk.getBookPublisher());
			}
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.북마크삭제 2.파일로저장 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if (submenu == 1) {
				System.out.println();
				System.out.println("<<북마크삭제>>");
				int bmkId = readInt("삭제할 북마크번호>>  ");
				Bookmark bmk = new Bookmark(bmkId, 0, id, null, null, null);
				dao.deleteBmk(bmk);
			} else if (submenu == 2) {
				System.out.println();
				System.out.println("<<파일로저장>>");
				dao.toBmkfile(bmks);
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void rentReturn(String id) { // 대여반납관리메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<대여반납관리>>");
			System.out.println(
					"==============================================================================================================");
			List<Book> rentBooks = dao.getRentBookList();
			for (Book rbook : rentBooks) {
				System.out.printf("책번호: %3s | 책이름: %20s | 대여한사람: %10s \n", rbook.getBookId(), rbook.getBookName(),
						rbook.getRentUserId());
			}
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.대여 2.반납 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if(submenu == 1) {
				System.out.println();
				System.out.println("<<대여>>");
				System.out.print("대여하는 회원아이디>>");
				String rentId = scn.nextLine();
				int num = readInt("대여할 책번호>> ");
				Book book = new Book(num, null, null, null, null, null, null, rentId);
				dao.rentBook(book);
			}else if (submenu == 2) {
				System.out.println();
				System.out.println("<<반납>>");
				int num = readInt("반납할 책번호>> ");
				Book book = new Book(num, null, null, null, null, null, null, id);
				dao.returnBook(book);
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void members() { // 회원관리메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<회원관리>>");
			System.out.println(
					"==============================================================================================================");
			List<Member> mems = dao.MemberList();
			for (Member mem : mems) {
				System.out.println(mem.toString());
			}
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.회원수정 2.회원삭제 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if (submenu == 1) {
				int num = readInt("수정할 회원번호>>  ");
				System.out.print("수정할 회원이름>>  ");
				String upName = scn.nextLine();
				Member mem = new Member(num, null, null, upName);
				dao.updateMem(mem);
			} else if (submenu == 2) {
				int num = readInt("수정할 회원번호>>  ");
				Member mem = new Member(num, null, null, null);
				dao.deleteMem(mem);
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void QnAM(String id) { // QnA(매니저)메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<QnA>>");
			System.out.println(
					"==============================================================================================================");
			List<Question> ques = dao.getQueList(0, id);
			for (Question que : ques) {
				System.out.println(que.getQue());
			}
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.질문상세보기 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if (submenu == 1) {
				queSerachM(id);
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void queSerachM(String id) { // QnA상세보기(매니저)메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		System.out.println();
		int queId = readInt("조회할 질문번호>>  ");
		while (true) {
			Question question = new Question(queId, null, null, id, null, null);
			Question que = dao.searchQue(question);
			if (que == null) {
				break;
			} else {
				System.out.println();
				System.out.println(
						"==============================================================================================================");
				System.out.println(que.toString());
				Answer ans = dao.searchAns(queId);
				if (ans != null) {
					System.out.println("<<답변>>");
					System.out.println(ans.toString());
				}
				System.out.println(
						"==============================================================================================================");
				System.out.println("메뉴)) 1.답변등록 2.답변수정 3.답변삭제 0.뒤로가기");
				int ssbmenu = readInt("선택>>  ");
				if (ssbmenu == 1) {
					System.out.println();
					System.out.println("<<답변등록>>");
					System.out.println("답변내용>>  ");
					String content = scn.nextLine();
					Answer answer = new Answer(0, queId, content, null);
					dao.insertAns(answer);
				} else if (ssbmenu == 2) {
					System.out.println();
					System.out.println("<<답변수정>>");
					System.out.println("수정할 답변내용>>  ");
					String content = scn.nextLine();
					Answer answer = new Answer(0, queId, content, null);
					dao.updateAns(answer);
				} else if (ssbmenu == 3) {
					System.out.println();
					System.out.println("<<답변삭제>>");
					Answer answer = new Answer(0, queId, null, null);
					dao.deleteAns(answer);
				} else if (ssbmenu == 0) {
					break;
				} else {
					System.out.println();
					System.out.println("<<잘못된 선택입니다>>");
				}
			}
		}
	}

	public static void rentBooks(String id) { // 대여중인책메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("<<대여중인도서>>");
			System.out.println(
					"==============================================================================================================");
			List<Book> rentBooks = dao.getMyRentBook(id);
			for (Book rbook : rentBooks) {
				System.out.printf("책번호: %3s | 책이름: %20s | 글쓴이: %10s | 출판사: %7s \n", rbook.getBookId(),
						rbook.getBookName(), rbook.getBookWriter(), rbook.getBookPublisher());
			}
			System.out.println(
					"==============================================================================================================");
			System.out.println("메뉴)) 1.반납 0.뒤로가기");
			int submenu = readInt("선택>>  ");
			if (submenu == 1) {
				System.out.println();
				System.out.println("<<반납>>");
				int num = readInt("반납할 책번호>> ");
				Book book = new Book(num, null, null, null, null, null, null, id);
				dao.returnBook(book);
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void QnA(String id) { // QnA(일반회원)메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		int order = 0;
		while (true) {
			System.out.println();
			System.out.println("<<QnA>>");
			System.out.println(
					"==============================================================================================================");
			List<Question> ques = dao.getQueList(order, id);
			for (Question que : ques) {
				System.out.println(que.getQue());
			}
			System.out.println(
					"==============================================================================================================");
			if (order == 1) {
				System.out.println("메뉴)) 1.질문상세보기 2.질문등록             4.내질문만보기(취소) 0.뒤로가기");
			} else if (order == 0) {
				System.out.println("메뉴)) 1.질문상세보기 2.질문등록 3.내질문만보기                  0.뒤로가기");
			}
			int submenu = readInt("선택>>  ");
			if (submenu == 1) {
				queSerach(id);
			} else if (submenu == 2) {
				System.out.println();
				System.out.println("<<질문등록>>");
				System.out.println("질문 제목>>  ");
				String title = scn.nextLine();
				System.out.println("질문 내용>>  ");
				String content = scn.nextLine();
				Question que = new Question(0, title, content, id, null, null);
				dao.insertQue(que);
			} else if (submenu == 3) {
				order = 1;
			} else if (submenu == 4) {
				order = 0;
			} else if (submenu == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("<<잘못된 선택입니다>>");
			}
		}
	}

	public static void queSerach(String id) { // QnA상세보기(일반회원)메소드
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		System.out.println();
		System.out.println("<<질문상세보기>>");
		int queId = readInt("조회할 질문번호>>  ");
		while (true) {
			Question question = new Question(queId, null, null, id, null, null);
			Question que = dao.searchQue(question);
			if (que == null) {
				break;
			} else {
				System.out.println();
				System.out.println(
						"==============================================================================================================");
				System.out.println(que.toString());
				Answer ans = dao.searchAns(queId);
				if (ans != null) {
					System.out.println("<<답변>>");
					System.out.println(ans.toString());
				}
				System.out.println(
						"==============================================================================================================");
				System.out.println("메뉴)) 1.질문수정 2.질문삭제 0.뒤로가기");
				int ssbmenu = readInt("선택>>  ");
				if (ssbmenu == 1) {
					System.out.println();
					System.out.println("<<질문수정>>");
					System.out.println("수정할 질문제목>>  ");
					String title = scn.nextLine();
					System.out.println("수정할 질문내용>>  ");
					String content = scn.nextLine();
					Question upQue = new Question(queId, title, content, id, null, null);
					dao.updateQue(upQue);
				} else if (ssbmenu == 2) {
					System.out.println();
					System.out.println("<<질문삭제>>");
					Question delQue = new Question(queId, null, null, id, null, null);
					boolean del = dao.deleteQue(delQue);
					if(del) {
						break;
					}
				} else if (ssbmenu == 0) {
					break;
				} else {
					System.out.println();
					System.out.println("<<잘못된 선택입니다>>");
				}
			}
		}
	}

	public static int readInt(String msg) { // 숫자 예외
		Scanner scn = new Scanner(System.in);
		int result = -1;
		while (true) {
			System.out.print(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("<<숫자를 입력해주세요!>>");
			}
		}
		return result;
	}
}
