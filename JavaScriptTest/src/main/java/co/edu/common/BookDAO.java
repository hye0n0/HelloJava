package co.edu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.book.BookVO;

public class BookDAO extends DAO{
	public List<BookVO> bookList() {
		// 도서목록을 반환하도록 구성.
		List<BookVO> list = new  ArrayList<>();
		getConnect();
		String sql = "select * from tbl_book";
		
		try {
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_name"));
				vo.setAuthor(rs.getString("author"));
				vo.setPress(rs.getString("press"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public void bookAdd(BookVO vo) {
		getConnect();
		String sql = "insert into tbl_book (book_code, book_name, author, press, price) "
				+ "values( ?, ?, ?, ?, ?) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
			psmt.setString(3, vo.getAuthor());
			psmt.setString(4, vo.getPress());
			psmt.setInt(5, vo.getPrice());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public boolean bookDel(String BookCode) {
		getConnect();
		String sql = "delete from tbl_book where book_code = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, BookCode);
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
