package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// C(reate)R(ead)U(pdate)D(elete)
public class BoardDAO extends DAO{
	
	// 등록
	public void insert(Board board) {
		String sql = "insert into board (board_num,board_title,board_content,board_writer) "
				+ " values(?, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBoardNum());
			psmt.setString(2, board.getBoardTitle());
			psmt.setString(3, board.getBoardContent());
			psmt.setString(4, board.getBoardWriter());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정
	public void update(int boardNum, String BoardContent) {
		String sql =" update board "
				+ " set board_content = ?, creation_date = sysdate "
				+ " where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, BoardContent);
			psmt.setInt(2, boardNum);
			int r = psmt.executeUpdate();
			if(r > 0) {
				System.out.println(r + "건 변경됨");
			}else{
				System.out.println("해당 글번호는 없는 번호입니다");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 삭제
	public void delete(int boardNum) {
		String sql = "delete from board where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				System.out.println(r + "건 삭제됨");
			}else{
				System.out.println("해당 글번호는 없는 번호입니다");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	// 목록
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<>(); //반환하기위한 값
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select* from board order by board_num");
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"),
						rs.getString("board_content"), rs.getString("board_writer"),
						rs.getString("creation_date"), rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//상세 조회
	public Board getBoard(int boardNum) {
		String sql1 ="select* from board where board_num = ?";
		String sql2 = "update board set cnt = cnt + 1 where board_num = ?";
		conn = getConnect();
		Board board = null;
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			if(rs.next()) {
				board = new Board(rs.getInt("board_num"), rs.getString("board_title"),
						rs.getString("board_content"), rs.getString("board_writer"),
						rs.getString("board_writer"), rs.getInt("cnt"));
				psmt = conn.prepareStatement(sql2);
				psmt.setInt(1, boardNum);
				psmt.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return board;
	}
	
}
