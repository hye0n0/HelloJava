package co.edu.books;

import java.util.Scanner;

public class BooksDAO {
	private static BooksDAO instance = new BooksDAO();
	private BooksDAO() {}
	public static BooksDAO getInstance() {
		return instance;
	}
	Scanner scn = new Scanner(System.in);
	Books[] myBooks = new Books[100];
	public void addBook() {
		System.out.println("책 등록 기능");
		System.out.print("책 번호를 입력>> ");
		int bookId = scn.nextInt();
		scn.nextLine();
		System.out.print("책 제목을 입력>> ");
		String title = scn.nextLine();
		System.out.print("책 저자를 입력>> ");
		String author = scn.nextLine();
		System.out.print("책 출판사를 입력>> ");
		String publisher = scn.nextLine();
		Books book = new Books(bookId, title, author, publisher);
		for(int i=0; i<myBooks.length; i++) {
			if(myBooks[i] == null) {
				myBooks[i] = book;
				break;
			}
		}
	}
	public void booksList() {
		System.out.println("책 목록 조회");
		for(Books book : myBooks) {
			if(book != null) {
				System.out.println(book.toString());
			}
		}
	}
	public void bookDetail() {
		System.out.println("책 상세 검색");
		System.out.print("책번호를 입력>> ");
		int bookId = scn.nextInt();
		scn.nextLine();
		boolean check = false;
		for(int i=0; i<myBooks.length; i++) {
			if(myBooks[i] != null && myBooks[i].getBookId() == bookId) {
				System.out.println(myBooks[i].toString());
				check = true;
			}
		}
		if(check == false) {
			System.out.println("해당 책번호는 없는 책입니다");
		}
	}
	public void editBook() {
		System.out.println("책 정보 수정");
		System.out.print("책번호를 입력>> ");
		int bookId = scn.nextInt();
		scn.nextLine();
		boolean check = false;
		for(int i=0; i<myBooks.length; i++) {
			if(myBooks[i] != null && myBooks[i].getBookId() == bookId) {
				System.out.println(" 1.책번호 2.책제목 3.책저자 4.책출판사 5.종료");
				System.out.print("선택>> ");
				int menu = scn.nextInt();
				switch(menu) {
					case 1:
						System.out.print("수정할 책번호를 입력>> ");
						bookId = scn.nextInt();
						scn.nextLine();
						myBooks[i].setBookId(bookId);
						System.out.print("수정되었습니다");
						break;
					case 2:
						System.out.print("수정할 책제목을 입력>> ");
						String title = scn.nextLine();
						myBooks[i].setTitle(title);
						System.out.print("수정되었습니다");
						break;
					case 3:
						System.out.print("수정할 책저자를 입력>> ");
						String author = scn.nextLine();
						myBooks[i].setAuthor(author);
						System.out.print("수정되었습니다");
						break;
					case 4:
						System.out.print("수정할 책출판사를 입력>> ");
						String publisher = scn.nextLine();
						myBooks[i].setPublisher(publisher);
						System.out.print("수정되었습니다");
						break;
					case 5:
						break;
					default:
						System.out.println("잘못된 입력입니다");
				}
			}
		}
		if(check == false) {
			System.out.println("해당 책번호는 없는 책입니다");
		}
	}
	public void delBook() {
		System.out.println("책 삭제");
		System.out.print("책번호를 입력>> ");
		int bookId = scn.nextInt();
		scn.nextLine();
		boolean check = false;
		for(int i=0; i<myBooks.length; i++) {
			if(myBooks[i] != null && myBooks[i].getBookId() == bookId) {
				myBooks[i] = null;
				System.out.println("삭제되었습니다");
				check = true;
			}
		}
		if(check == false) {
			System.out.println("해당 책번호는 없는 책입니다");
		}
	}
	public void exe() {
		boolean run = true;
		while(run) {
			System.out.println(" 1.책등록 2.책목록 3.책검색 4.책수정 5.책삭제 6.종료");
			System.out.print("선택>> ");
			int menu = scn.nextInt();
			switch(menu) {
				case 1:
					addBook();
					break;
				case 2:
					booksList();
					break;
				case 3:
					bookDetail();
					break;
				case 4:
					editBook();
					break;
				case 5:
					delBook();
					break;
				case 6:
					run = false;
					break;
				default:
					System.out.println("잘못된 입력입니다");
			}
		}
		System.out.println("프로그램 종료");
	}
}
