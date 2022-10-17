package co.bookmanagment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BooksApp {
	public static void main(String[] args) {
		BooksDAO dao = new BooksDAO();
		Scanner scn = new Scanner(System.in);
		String id = null;
		String pw = null;
		while (true) {
			System.out.println("아이디 입력>> ");
			id = scn.nextLine();
			System.out.println("비밀번호 입력>> ");
			pw = scn.nextLine();
			if (dao.rogin(id, pw) == 0) {
				break;
			} else if (dao.rogin(id, pw) == -1) {
				System.out.println("잘못된 아이디입니다");
			} else if (dao.rogin(id, pw) == -2) {
				System.out.println("잘못된 비밀번호입니다");
			}
		}
		if (id.equals("master")) {
			while (true) {
				System.out.println("메뉴) 1.책등록 2.책수정 3.책삭제 4.전체목록 5.상세조회 6.내도서후기보기 7.북마크 0.종료");
				int menu = readInt("선택>> ");
				if (menu == 1) {
					while (true) {
						System.out.println("==책등록==");
						System.out.println("메뉴) 1.입력 2.파일가져오기 0.취소");
						int submenu = readInt("선택>> ");
						if (submenu == 1) {
							System.out.println("==책등록(입력)==");
							System.out.println("글제목>>");
							String name = scn.nextLine();
							System.out.println("글쓴이>>");
							String writer = scn.nextLine();
							System.out.println("출판사>>");
							String publisher = scn.nextLine();
							Book book = new Book(0, name, writer, publisher, null, null, null);
							dao.insert(book);
						} else if (submenu == 2) {
							System.out.println("==책등록(파일가져오기)==");
							String[] books = null;
							Book book = null;
							try (FileReader fr = new FileReader("C:/BookManag/bookList.txt");
									BufferedReader br = new BufferedReader(fr);) {
								while (true) {
									String bok = br.readLine();
									if (bok == null)
										break;

									books = bok.split(" ");
									book = new Book(0, books[0], books[1], books[2], null, null, null);
									dao.insert(book);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else if (submenu == 0) {
							break;
						} else {
							System.out.println("잘못된 선택입니다");
						}
					}
				} else if (menu == 2) {
					while (true) {
						System.out.println("==책수정==");
						int num = readInt("수정할 책번호>>");
						Book curBook = dao.getBook(num);
						if (curBook != null) {
							System.out.println("메뉴) 1.전체수정 2.책이름수정 3.글쓴이수정 4.출판사수정 0.취소");
							int submenu = readInt("선택>> ");
							if (submenu == 1) {
								System.out.println("==전체수정==");
								System.out.println("수정할 책이름>>");
								String name = scn.nextLine();
								System.out.println("수정할 글쓴이>>");
								String writer = scn.nextLine();
								System.out.println("수정할 출판사>>");
								String publisher = scn.nextLine();
								Book book = new Book(0, name, writer, publisher, null, null, null);
								dao.update(book);
							} else if (submenu == 2) {
								System.out.println("==책이름수정==");
								System.out.println("수정할 책이름>>");
								String name = scn.nextLine();
								Book book = new Book(0, name, curBook.getBookWriter(), curBook.getBookPublisher(), null,
										null, null);
								dao.update(book);
							} else if (submenu == 3) {
								System.out.println("==글쓴이수정==");
								System.out.println("수정할 글쓴이>>");
								String writer = scn.nextLine();
								Book book = new Book(0, curBook.getBookName(), writer, curBook.getBookPublisher(), null,
										null, null);
								dao.update(book);
							} else if (submenu == 4) {
								System.out.println("==출판사수정==");
								System.out.println("수정할 출판사>>");
								String publisher = scn.nextLine();
								Book book = new Book(0, curBook.getBookName(), curBook.getBookWriter(), publisher, null,
										null, null);
								dao.update(book);
							} else if (submenu == 0) {
								break;
							} else {
								System.out.println("잘못된 선택입니다");
							}
						} else {
							System.out.println("해당 책번호는 없는 책입니다");
							break;
						}
					}
				} else if (menu == 3) {
					System.out.println("==책삭제==");
					int num = readInt("삭제할 책번호>>");
					Book book = new Book(num, null, null, null, null, null, null);
					dao.delete(book);
				} else if (menu == 4) {
					System.out.println("==전체목록==");
					int pageSet = 10;
					int page = 1;
					int order = 1;
					while(true) {
						System.out.println("==글목록==");
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
						System.out.println("==========================================================");
						System.out.println("현재 페이지 : <" + page + "> 설정)) 글목록: " + pageSet + "개씩, 순서: " + orderWord);
						List<Book> books = dao.search(order);
						for (int i=((page-1)*pageSet) ; i<(page*pageSet); i++) {
							if(i == books.size() ){
								break;
							}else if(books.get(i) != null) {
							System.out.println(books.get(i).toBookList());
							}
						}
						System.out.println("==========================================================");
						if(page == 1) {
							System.out.println("메뉴)              2.다음페이지>>   3.글목록갯수설정 4.목록정렬설정 0.뒤로가기");
						}else if(((page*pageSet)+1)>books.size()) {
							System.out.println("메뉴) 1.<<이전페이지                3.글목록갯수설정 4.목록정렬설정 0.뒤로가기");
						}else {
							System.out.println("메뉴) 1.<<이전페이지 2.다음페이지>>   3.글목록갯수설정 4.목록정렬설정 0.뒤로가기");
						}
						int subMenu = readInt("선택>> ");
						if (subMenu == 1) {
							if(page == 1) {
								System.out.println("첫 페이지는 입니다");
							}else {
								page --;
							}
						}else if(subMenu == 2) {
							if(((page*pageSet)+1)>books.size()) {
								System.out.println("다음 페이지는 없습니다");
							}else {
								page ++;
							}
						}else if(subMenu == 3) {
							pageSet = readInt("원하는 글목록갯수입력>> ");
							page = 1;
						}else if(subMenu == 4) {
							System.out.println("목록정렬) 1.책번호 오름차순 2.책번호 내림차순 3.책이름 오름차순 4.책이름 내림차순 5.글쓴이 오름차순 6.글쓴이 내림차순 ");
							int orMenu = readInt("선택>> ");
							if(0 < orMenu && orMenu < 7) {
								order = orMenu;
							}else {
								System.out.println("잘못된 목록정렬 선택입니다. 설정을 다시 해주세요");
							}
						}else if(subMenu == 0) {
							System.out.println("글목록을 나갑니다");
							break;
						}else {
							System.out.println("잘못된 선택입니다");
						}
					}
				} else if (menu == 5) {
					System.out.println("==상세조회==");
					int num = readInt("조회할 책번호>>");
					Book book = dao.getBook(num);
					if (book != null) {
						while (true) {
							System.out.println("======================================================");
							if(book.getReturnDate() == null) {
								System.out.println(book.toStringY());
							}else {
								System.out.println(book.toStringN());
							}
							
							System.out.println("======================================================");
							System.out.println("<<도서후기>>");
							List<Review> revs = dao.getRevList(num);
							for (Review rev : revs) {
								System.out.println(rev.getrevList());
							}
							System.out.println();
							System.out.println("메뉴)) 1.대여 2.반납 3.도서후기작성 4.도서후기수정 5.도서후기삭제 6.북마크 0.취소");
							int submenu = readInt("선택>> ");
							if (submenu == 1) {
								System.out.println("==대여==");
							} else if (submenu == 2) {
								System.out.println("==반납==");
							} else if (submenu == 3) {
								System.out.println("==도서후기작성==");
								System.out.println("도서후기 내용>>");
								String content = scn.nextLine();
								Review rev = new Review(0, num, content, id, null);
								dao.insertRev(rev);
							} else if (submenu == 4) {
								System.out.println("==도서후기수정==");
								int revId = readInt("수정할 도서후기번호>>");
								System.out.println("수정할 도서후기 내용>>");
								String content = scn.nextLine();
								Review rev = new Review(revId, num, content, id, null);
								dao.updateRev(rev);
							} else if (submenu == 5) {
								System.out.println("==도서후기삭제==");
								int revId = readInt("삭제할 도서후기번호>>");
								Review rev = new Review(revId, 0, null, null, null);
								dao.deleteRev(rev);
							} else if (submenu == 6) {
								System.out.println("==북마크==");
								Bookmark bmk = new Bookmark(0, book.getBookId(), id, book.getBookName(),
										book.getBookWriter(), book.getBookPublisher());
								dao.insertBmk(bmk);
							} else if (submenu == 0) {
								break;
							} else {
								System.out.println("잘못된 선택입니다");
							}
						}
					} else {
						System.out.println("해당 책번호는 없는 책입니다");
					}

				} else if (menu == 6) {
					System.out.println("==내도서후기보기==");
					while (true) {
						List<Review> revs = dao.getMyRev(id);
						for (Review rev : revs) {
							System.out.println(rev.getrevList());
						}
						System.out.println("메뉴)) 1.도서후기수정 2.도서후기삭제 0.취소");
						int submenu = readInt("선택>> ");
						if (submenu == 1) {
							System.out.println("==도서후기수정==");
							int revId = readInt("수정할 도서후기번호>>");
							System.out.println("수정할 도서후기 내용>>");
							String content = scn.nextLine();
							Review rev = new Review(revId, 0, content, id, null);
							dao.updateRev(rev);
						} else if (submenu == 2) {
							System.out.println("==도서후기삭제==");
							int revId = readInt("삭제할 도서후기번호>>");
							Review rev = new Review(revId, 0, null, null, null);
							dao.deleteRev(rev);
						} else if (submenu == 0) {
							break;
						} else {
							System.out.println("잘못된 선택입니다");
						}

					}
				} else if (menu == 7) {
					System.out.println("==북마크==");
					while (true) {
						List<Bookmark> bmks = dao.getMyBmk(id);
						for (Bookmark bmk : bmks) {
							System.out.println(bmk.toString());
						}
						System.out.println("메뉴)) 1.북마크삭제 2.파일로저장 0.취소");
						int submenu = readInt("선택>> ");
						if (submenu == 1) {
							System.out.println("==북마크삭제==");
							int bmkId = readInt("삭제할 북마크번호>>");
							Bookmark bmk = new Bookmark(bmkId, 0, id, null, null, null);
							dao.deleteBmk(bmk);
						}else if(submenu == 2) { 
							System.out.println("==파일로저장==");
							try {
								FileWriter fw = new FileWriter("C:/BookManag/bookmarkList.txt");					
								for(Bookmark bmk : bmks) {
									fw.write(bmk.getBookId()+ " " 
											+ bmk.getBookName() + " "
											+ bmk.getBookWriter() + " "
											+ bmk.getBookPublisher() + "\n");
								}
								fw.close();
								System.out.println("파일이 저장되었습니다");
								
							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("completed");
						}else if (submenu == 0) {
							break;
						} else {
							System.out.println("잘못된 선택입니다");
						}
					}
				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다");
					break;
				} else {
					System.out.println("잘못된 선택입니다");
				}
			}
		} else {

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
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요!");
			}
		}
		return result;
	}
}
