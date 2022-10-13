package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// C(reate)R(ead)U(pdate)D(elete)
public class BoardDAO extends DAO {
	// 아이디, 비밀번호 체크
	public int rogin(String id, String pw) {
		String sql = "select* from users where id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if(pw.equals(rs.getString("passwd"))) {
					return 0;
				}else {
					return -2;
				}
			}else {
					return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2;
	}

	// 등록
	public void insert(Board board) {
		String sql = "insert into board (board_num,board_title,board_content,board_writer) " + " values(?, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBoardNum());
			psmt.setString(2, board.getBoardTitle());
			psmt.setString(3, board.getBoardContent());
			psmt.setString(4, board.getBoardWriter());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 수정
	public void update(Board board) {
		String sql1 = "select* from board where board_num = ? ";
		String sql2 = " update board " + " set board_content = ?, creation_date = sysdate " + " where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, board.getBoardNum());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (board.getBoardWriter().equals(rs.getString("board_writer"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setString(1, board.getBoardContent());
					psmt.setInt(2, board.getBoardNum());
					int r = psmt.executeUpdate();
					System.out.println(r + "건 변경됨");
				} else {
					System.out.println("해당글의 작성자가 아니여서 삭제할 수 없습니다");
				}
			}else{
				System.out.println("해당 글번호는 없는 번호입니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void delete(Board board) {
		String sql1 = "select* from board where board_num = ? ";
		String sql2 = "delete from board where board_num = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, board.getBoardNum());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (board.getBoardWriter().equals(rs.getString("board_writer"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setInt(1, board.getBoardNum());
					int r = psmt.executeUpdate();
					System.out.println(r + "건 삭제됨");
				}else {
					System.out.println("해당글의 작성자가 아니여서 삭제할 수 없습니다");
				}
			}else {
				System.out.println("해당 글번호는 없는 번호입니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 목록
	public List<Board> search(int order) {
		conn = getConnect();
		String sql = "select* from board ";
		List<Board> list = new ArrayList<>(); // 반환하기위한 값
		try {
			switch (order) {
			case 1:
				sql += "order by board_num ";
				break;
			case 2:
				sql += "order by board_num desc ";
				break;
			case 3:
				sql += "order by creation_date ";
				break;
			case 4:
				sql += "order by creation_date desc ";
				break;
			case 5:
				sql += "order by cnt ";
				break;
			case 6:
				sql += "order by cnt desc ";
				break;
			}
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 상세 조회
	public Board getBoard(int boardNum) {
		String sql1 = "select* from board where board_num = ?";
		String sql2 = "update board set cnt = cnt + 1 where board_num = ?";
		conn = getConnect();
		Board board = null;
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				board = new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("board_writer"), rs.getInt("cnt"));
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
	
	// 댓글 등록
	public void insertReq(Reply rep) {
		String sql = "insert into reply (rep_seq,board_num,rep_content,rep_writer) "
				+ " values(reply_seq.nextval, ?, ?, ?)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rep.getBoardNum());
			psmt.setString(2, rep.getRepContent());
			psmt.setString(3, rep.getRepWriter());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 댓글 수정
	public void updateReq(Reply rep) {
		String sql1 = "select* from reply where rep_seq = ? ";
		String sql2 = " update reply " + " set rep_content = ?, creation_date = sysdate " + " where rep_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, rep.getRepSeq());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rep.getRepWriter().equals(rs.getString("rep_writer"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setString(1, rep.getRepContent());
					psmt.setInt(2, rep.getRepSeq());
					int r = psmt.executeUpdate();
					System.out.println(r + "건 변경됨");
				} else {
					System.out.println("해당댓글의 작성자가 아니여서 수정할 수 없습니다");
				}
			}else{
				System.out.println("해당 댓글번호는 없는 번호입니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//댓글 삭제
	public void deleteReq(Reply rep) {
		String sql1 = "select* from reply where rep_seq = ? ";
		String sql2 = "delete from reply where rep_seq = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, rep.getRepSeq());

			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rep.getRepWriter().equals(rs.getString("rep_writer"))) {
					psmt = conn.prepareStatement(sql2);
					psmt.setInt(1, rep.getRepSeq());
					int r = psmt.executeUpdate();
					System.out.println(r + "건 삭제됨");
				}else {
					System.out.println("해당댓글의 작성자가 아니여서 삭제할 수 없습니다");
				}
			}else {
				System.out.println("해당 댓글번호는 없는 번호입니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 댓글 전체목록
	public List<Reply> getMyRepList(String id) {
		String sql1 = "select* from reply where rep_writer = ? order by rep_seq";
		conn = getConnect();
		List<Reply> list = new ArrayList<>(); // 반환하기위한 값
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(rs.getInt("rep_seq"), rs.getInt("board_num"), rs.getString("rep_content"),
						rs.getString("rep_writer"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 원본글의 댓글목록
	public List<Reply> getReps(int boardNum) {
		String sql1 = "select* from reply where board_num = ? order by rep_seq";
		conn = getConnect();
		List<Reply> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(rs.getInt("rep_seq"), rs.getInt("board_num"), rs.getString("rep_content"),
						rs.getString("rep_writer"), rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
