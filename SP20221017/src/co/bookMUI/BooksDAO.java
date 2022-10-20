package co.bookMUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO extends DAO {
	// 로그인
	public int rogin(String id, String pw) {
		String sql = "select* from members where user_id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (pw.equals(rs.getString("passwd"))) {
					return rs.getInt("user_num");
				} else {
					return -2;
				}
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2;
	}

	// 회원가입
	public void createUser(Member member) {
		String sql1 = "select* from members where user_id = ? ";
		String sql2 = "insert into members (user_num,user_id,passwd,user_name) " + " values(user_n.nextval, ?, ?, ? )";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, member.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				System.out.println("<<이미 있는 아이디 입니다>>");
			} else {
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, member.getUserId());
				psmt.setString(2, member.getPasswd());
				psmt.setString(3, member.getUserName());

				psmt.executeUpdate();
				System.out.println();
				System.out.println("<<회원가입되었습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 책등록(입력)
	public void insert(Book book) {
		String sql = "insert into books (book_id,book_name,book_writer,book_publisher) "
				+ " values(books_id.nextval, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookName());
			psmt.setString(2, book.getBookWriter());
			psmt.setString(3, book.getBookPublisher());

			int r = psmt.executeUpdate();
			System.out.println();
			System.out.println("<<" + r + "건 입력되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 책등록(파일가져오기)
	public void insertFile() {
		String sql = "insert into books (book_id,book_name,book_writer,book_publisher) "
				+ " values(books_id.nextval, ?, ?, ?)";
		conn = getConnect();
		String[] books = null;
		Book book = null;
		int r = 0;
		try (FileReader fr = new FileReader("C:/BookM/bookList.txt"); BufferedReader br = new BufferedReader(fr);) {
			while (true) {
				String bok = br.readLine();
				if (bok == null)
					break;

				books = bok.split("\\/");
				book = new Book(0, books[0], books[1], books[2], null, null, null, null);
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, book.getBookName());
				psmt.setString(2, book.getBookWriter());
				psmt.setString(3, book.getBookPublisher());

				int a = psmt.executeUpdate();
				r += a;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println();
		System.out.println("<<" + r + "건 입력되었습니다>>");
	}

	// 책수정
	public void update(Book book) {
		String sql = " update books " + " set book_name = ?, book_writer = ?, book_publisher = ? "
				+ " where book_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookName());
			psmt.setString(2, book.getBookWriter());
			psmt.setString(3, book.getBookPublisher());
			psmt.setInt(4, book.getBookId());

			int r = psmt.executeUpdate();
			System.out.println();
			System.out.println("<<" + r + "건 변경되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 책삭제
	public void delete(Book book) {
		String sql1 = "select* from books where book_id = ? ";
		String sql2 = "delete from books where book_id = ? ";
		String sql3 = "delete from reviews where book_Id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, book.getBookId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, book.getBookId());
				int r = psmt.executeUpdate();
				System.out.println("<<" + r + "건 삭제되었습니다>>");
				psmt = conn.prepareStatement(sql3);
				psmt.setInt(1, book.getBookId());
				r = psmt.executeUpdate();
				System.out.println("<<" + r + "건 도서후기도 삭제되었습니다>>");
			} else {
				System.out.println();
				System.out.println("<<해당 글번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 전체목록
	public List<Book> search(int order, int search, String serWord) {
		conn = getConnect();
		String sql = "select* from books ";
		List<Book> list = new ArrayList<>(); // 반환하기위한 값
		try {
			switch (search) {
			case 1:
				sql += ("where book_name like '%" + serWord + "%' ");
				break;
			case 2:
				sql += ("where book_writer like '%" + serWord + "%' ");
				break;
			case 3:
				sql += ("where book_publisher like '%" + serWord + "%' ");
				break;
			default:
				break;
			}
			switch (order) {
			case 1:
				sql += "order by book_id ";
				break;
			case 2:
				sql += "order by book_id desc ";
				break;
			case 3:
				sql += "order by book_name ";
				break;
			case 4:
				sql += "order by book_name desc ";
				break;
			case 5:
				sql += "order by book_writer ";
				break;
			case 6:
				sql += "order by book_writer desc ";
				break;
			}

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("book_writer"),
						rs.getString("book_publisher"), rs.getString("renting"), rs.getString("return_date"),
						rs.getString("creation_date"), rs.getString("rent_userid")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 상세조회
	public Book getBook(int bookId) {
		String sql = "select* from books where book_id = ? ";
		conn = getConnect();
		Book book = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bookId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book = new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("book_writer"),
						rs.getString("book_publisher"), rs.getString("renting"), rs.getString("return_date"),
						rs.getString("creation_date"), rs.getString("rent_userid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}

	// 대여
	public void rentBook(Book book) {
		String sql1 = "select* from members where user_id = ? ";
		String sql2 = "select* from books where book_id = ? ";
		String sql3 = "update books " + "set renting = '불가능', return_date = sysdate + 7 ,rent_userid = ? "
				+ "where book_id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, book.getRentUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, book.getBookId());
				rs = psmt.executeQuery();
				if (rs.next()) {
					if (rs.getString("renting").equals("불가능")) {
						System.out.println();
						System.out.println("<<이미 대여중인 책입니다>>");
					} else {
						psmt = conn.prepareStatement(sql3);
						psmt.setString(1, book.getRentUserId());
						psmt.setInt(2, book.getBookId());
						int r = psmt.executeUpdate();
						System.out.println();
						System.out.println("<<" + r + "건 대여되었습니다>>");
					}
				}else {
					System.out.println();
					System.out.println("<<해당 책번호는 없는 책입니다>>");
				}
			}else{
				System.out.println();
				System.out.println("<<해당 아이디는 없는 아이디입니다>>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 반납
	public void returnBook(Book book) {
		String sql1 = "select* from members where user_id = ? ";
		String sql2 = "select* from books where book_id = ? and  renting = '불가능' ";
		String sql3 = "update books " + "set renting = '가능', return_date = null ,rent_userid = null "
				+ "where book_id = ? ";
		conn = getConnect();
		try {
			int userNum = 0;
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, book.getRentUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				userNum = rs.getInt("user_num");
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, book.getBookId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (userNum == 1) {
					psmt = conn.prepareStatement(sql3);
					psmt.setInt(1, book.getBookId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 반납되었습니다>>");
				} else if (rs.getString("rent_userid").equals(book.getRentUserId())) {
					psmt = conn.prepareStatement(sql3);
					psmt.setInt(1, book.getBookId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 반납되었습니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<대여하고있지않습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 북마크 등록
	public void insertBmk(Bookmark bmk) {
		String sql1 = "select* from bookmarks where book_id = ? and user_id = ? ";
		String sql2 = "insert into bookmarks (mark_id,book_id,user_id) " + " values(bookmark_id.nextval, ?, ? )";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, bmk.getBookId());
			psmt.setString(2, bmk.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				System.out.println("<<이미 북마크로 등록되어있습니다>>");
			} else {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, bmk.getBookId());
				psmt.setString(2, bmk.getUserId());

				int r = psmt.executeUpdate();
				System.out.println();
				System.out.println("<<" + r + "건 등록되었습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 북마크 삭제
	public void deleteBmk(Bookmark bmk) {
		String sql1 = "select* from bookmarks where mark_id = ? ";
		String sql2 = "delete from bookmarks where mark_id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, bmk.getMarkId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (bmk.getUserId().equals(rs.getString("user_id"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setInt(1, bmk.getMarkId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 삭제되었습니다>>");
				} else {
					System.out.println();
					System.out.println("<<잘못된 북마크 번호입니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 북마크번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 북마크 전체목록
	public List<Bookmark> getMyBmk(String userId) {
		String sql = "select * " + "from bookmarks k, books b  " + "where k.book_id = b.book_id  "
				+ "and user_id = ? order by mark_id";
		conn = getConnect();
		List<Bookmark> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Bookmark(rs.getInt("mark_id"), rs.getInt("book_id"), rs.getString("user_id"),
						rs.getString("book_name"), rs.getString("book_writer"), rs.getString("book_publisher")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 북마크 저장
	public void toBmkfile(List<Bookmark> bmks) {
		try {
			FileWriter fw = new FileWriter("C:/BookM/bookmarkList.txt");
			for (Bookmark bmk : bmks) {
				fw.write("책번호: " + bmk.getBookId() + " | 책이름: " + bmk.getBookName() + " | 글쓴이: " + bmk.getBookWriter()
						+ " | 출판사:" + bmk.getBookPublisher() + "\n");
			}
			fw.close();
			System.out.println();
			System.out.println("<<파일이 저장되었습니다>>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 도서후기 등록
	public void insertRev(Review review) {
		String sql = "insert into reviews (rev_id,book_Id,rev_content,rev_writer) "
				+ " values(review_id.nextval, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, review.getBookId());
			psmt.setString(2, review.getRevContent());
			psmt.setString(3, review.getRevWriter());

			int r = psmt.executeUpdate();
			System.out.println();
			System.out.println("<<" + r + "건 등록되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 도서후기 수정
	public void updateRev(Review review) {
		String sql1 = "select* from reviews where rev_id = ? ";
		String sql2 = " update reviews " + " set rev_content = ? , creation_date = sysdate " + " where rev_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, review.getRevId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (review.getRevWriter().equals("master")) {
					psmt = conn.prepareStatement(sql2);
					psmt.setString(1, review.getRevContent());
					psmt.setInt(2, review.getRevId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 변경되었습니다>>");
				} else if (review.getRevWriter().equals(rs.getString("rev_writer"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setString(1, review.getRevContent());
					psmt.setInt(2, review.getRevId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 변경되었습니다>>");
				} else {
					System.out.println();
					System.out.println("<<해당도서후기의 작성자가 아니여서 수정할 수 없습니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 도서후기번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 도서후기 삭제
	public void deleteRev(Review review) {
		String sql1 = "select* from reviews where rev_id = ? ";
		String sql2 = "delete from reviews where rev_id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, review.getRevId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (review.getRevWriter().equals("master")) {
					psmt = conn.prepareStatement(sql2);
					psmt.setInt(1, review.getRevId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 삭제되었습니다>>");
				} else if (review.getRevWriter().equals(rs.getString("rev_writer"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setInt(1, review.getRevId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 삭제되었습니다>>");
				} else {
					System.out.println();
					System.out.println("<<해당도서후기의 작성자가 아니여서 삭제할 수 없습니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 도서후기번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 해당책의 도서후기목록
	public List<Review> getRevList(int bookId) {
		String sql = "select* from reviews where book_Id = ? order by rev_id";
		conn = getConnect();
		List<Review> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bookId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt("rev_id"), rs.getInt("book_Id"), rs.getString("rev_content"),
						rs.getString("rev_writer"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 내도서후기 전체목록
	public List<Review> getMyRev(String userId) {
		String sql = "select* from reviews where rev_writer = ? order by rev_id";
		conn = getConnect();
		List<Review> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt("rev_id"), rs.getInt("book_Id"), rs.getString("rev_content"),
						rs.getString("rev_writer"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 대여중인 도서
	public List<Book> getMyRentBook(String userId) {
		String sql = "select* from books where rent_userid = ? order by book_id";
		conn = getConnect();
		List<Book> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("book_writer"),
						rs.getString("book_publisher"), rs.getString("renting"), rs.getString("rent_userid"),
						rs.getString("return_date"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 대여중인 도서 전체목록
	public List<Book> getRentBookList() {
		String sql = "select* from books where renting = '불가능' order by book_id";
		conn = getConnect();
		List<Book> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("book_writer"),
						rs.getString("book_publisher"), rs.getString("renting"), rs.getString("return_date"),
						rs.getString("creation_date"), rs.getString("rent_userid")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 회원 전체목록
	public List<Member> MemberList() {
		String sql = "select* from members where not user_num = 1";
		conn = getConnect();
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Member(rs.getInt("user_num"), rs.getString("user_id"), rs.getString("passwd"),
						rs.getString("user_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 회원 수정
	public void updateMem(Member mem) {
		String sql1 = "select* from members where user_num = ? ";
		String sql2 = " update members " + " set user_name = ? " + " where user_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, mem.getUserNum());
			rs = psmt.executeQuery();

			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, mem.getUserName());
				psmt.setInt(2, mem.getUserNum());
				int r = psmt.executeUpdate();
				System.out.println();
				System.out.println("<<" + r + "건 변경되었습니다>>");
			} else {
				System.out.println();
				System.out.println("<<해당 번호의 회원은 없습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 회원 삭제
	public void deleteMem(Member mem) {
		String sql1 = "select* from members where user_num = ? ";
		String sql2 = "delete from members where user_num = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, mem.getUserNum());
			rs = psmt.executeQuery();

			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, mem.getUserNum());
				int r = psmt.executeUpdate();
				System.out.println();
				System.out.println("<<" + r + "건 삭제되었습니다>>");
			} else {
				System.out.println();
				System.out.println("<<해당 번호의 회원은 없습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 질문 등록
	public void insertQue(Question que) {
		String sql = "insert into questions (que_id,que_title,que_content,que_writer) "
				+ " values(question_id.nextval, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, que.getQueTitle());
			psmt.setString(2, que.getQueContent());
			psmt.setString(3, que.getQueWriter());

			int r = psmt.executeUpdate();
			System.out.println();
			System.out.println("<<" + r + "건 등록되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 질문 수정
	public void updateQue(Question que) {
		String sql1 = "select* from questions where que_id = ? ";
		String sql2 = "select* from answers where que_id = ? ";
		String sql3 = " update questions " + " set que_title = ?, que_content = ? , creation_date = sysdate "
				+ " where que_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, que.getQueId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, que.getQueId());

				rs = psmt.executeQuery();
				if (rs.next()) {
					System.out.println();
					System.out.println("<<답변이 달린 질문은 수정할 수 없습니다>>");
				} else {
					psmt = conn.prepareStatement(sql3);
					psmt.setString(1, que.getQueTitle());
					psmt.setString(2, que.getQueContent());
					psmt.setInt(3, que.getQueId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 변경되었습니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 질문번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 질문 삭제
	public void deleteQue(Question que) {
		String sql1 = "select* from questions where que_id = ? ";
		String sql2 = "select* from answers where que_id = ? ";
		String sql3 = "delete from questions where que_id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, que.getQueId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, que.getQueId());

				rs = psmt.executeQuery();
				if (rs.next()) {
					System.out.println();
					System.out.println("<<답변이 달린 질문은 삭제할 수 없습니다>>");
				} else {
					psmt = conn.prepareStatement(sql3);
					psmt.setInt(1, que.getQueId());
					int r = psmt.executeUpdate();
					System.out.println();
					System.out.println("<<" + r + "건 삭제되었습니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 질문번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 질문 전체목록
	public List<Question> getQueList(int order, String id) {
		String sql = "select* from questions ";
		conn = getConnect();
		List<Question> list = new ArrayList<>();
		try {
			if (order == 1) {
				sql += " where que_writer = '" + id + "'";
			}
			sql += " order by que_id desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Question(rs.getInt("que_id"), rs.getString("que_title"), rs.getString("que_content"),
						rs.getString("que_writer"), rs.getString("creation_date"), rs.getString("ans_exi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 질문 상세보기
	public Question searchQue(Question que) {
		String sql = "select* from questions where que_id = ?";
		conn = getConnect();
		Question question = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, que.getQueId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (que.getQueWriter().equals("master")) {
					question = new Question(rs.getInt("que_id"), rs.getString("que_title"), rs.getString("que_content"),
							rs.getString("que_writer"), rs.getString("creation_date"), rs.getString("ans_exi"));
				} else if (que.getQueWriter().equals(rs.getString("que_writer"))) {
					question = new Question(rs.getInt("que_id"), rs.getString("que_title"), rs.getString("que_content"),
							rs.getString("que_writer"), rs.getString("creation_date"), rs.getString("ans_exi"));
				} else {
					System.out.println();
					System.out.println("<<해당 질문의 작성자가 아니여서 볼 수 없습니다>>");
				}
			} else {
				System.out.println();
				System.out.println("<<해당 질문번호는 없는 번호입니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return question;
	}

	// 답변 등록
	public void insertAns(Answer ans) {
		String sql1 = "select* from answers where que_id = ?";
		String sql2 = "insert into answers (ans_id,que_id,ans_content) " + " values(answer_id.nextval, ?, ? )";
		String sql3 = "update questions " + " set ans_exi = '있음' " + " where que_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, ans.getQueId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				System.out.println("<<이미 답변한 질문입니다>>");
			} else {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, ans.getQueId());
				psmt.setString(2, ans.getAnsContent());
				int r = psmt.executeUpdate();
				psmt = conn.prepareStatement(sql3);
				psmt.setInt(1, ans.getQueId());
				psmt.executeUpdate();
				System.out.println();
				System.out.println("<<" + r + "건 등록되었습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 답변 수정
	public void updateAns(Answer ans) {
		String sql1 = "select* from answers where que_id = ? ";
		String sql2 = " update answers " + " set ans_content = ? , creation_date = sysdate " + " where que_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, ans.getQueId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, ans.getAnsContent());
				psmt.setInt(2, ans.getQueId());
				int r = psmt.executeUpdate();
				System.out.println();
				System.out.println("<<" + r + "건 수정되었습니다>>");
			} else {
				System.out.println();
				System.out.println("<<해당 질문의 답변은 없습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 답변 삭제
	public void deleteAns(Answer ans) {
		String sql1 = "select* from answers where que_id = ? ";
		String sql2 = "delete from answers where que_id = ? ";
		String sql3 = "update questions " + " set ans_exi = '없음' " + " where que_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, ans.getQueId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, ans.getQueId());
				int r = psmt.executeUpdate();
				psmt = conn.prepareStatement(sql3);
				psmt.setInt(1, ans.getQueId());
				psmt.executeUpdate();
				System.out.println();
				System.out.println("<<" + r + "건 삭제되었습니다>>");
			} else {
				System.out.println();
				System.out.println("<<해당 질문의 답변은 없습니다>>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 답변 상세보기
	public Answer searchAns(int queId) {
		String sql = "select* from answers where que_id = ?";
		conn = getConnect();
		Answer answer = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, queId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				answer = new Answer(rs.getInt("ans_id"), rs.getInt("que_id"), rs.getString("ans_content"),
						rs.getString("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return answer;
	}
}
