package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import co.edu.common.DAO;
import co.edu.vo.BoardVO;
import co.edu.vo.MemberVO;

public class BoardDAO extends DAO {
	// 입력,조회,수정,삭제...

	// 입력
	public BoardVO insertBoard(BoardVO vo) {
		// 입력처리중 에러가 발생하면.. null;
		conn = getConnect();
		String sql1 = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content, writer,image) " + "VALUES(?, ?, ?, ?,?)";
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());
			int r = psmt.executeUpdate();
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; // 실패할 경우 null을 반환
	}

	// 한건조회
	public BoardVO searchBoard(int boardNo) {
		conn = getConnect();
		String sql = "select * from tbl_board where board_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 전체목록
	public List<BoardVO> boardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		conn = getConnect();
		String sql = "select* from tbl_board " //
				+ "where 1 = 1 " //
				+ "and title like '%'||?||'%' " //
				+ "and content like '%'||?||'%' " //
				+ "and writer like '%'||?||'%' "; //
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
	}

	// 수정
	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 0이면 false;
		conn = getConnect();
		String sql = "update tbl_board " + "set content = ? " + "where board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getBoardNo());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	// 삭제
	public boolean deleteBoard(int boardNo) {
		// 처리건수가 0이면 false;
		conn = getConnect();
		String sql = "delete from tbl_board where board_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 페이지, 전체건수/ 10개씩, 검색결과 전체건수/10개씩
	public int totalCnt() {
		conn = getConnect();
		String sql = "select count(1) from tbl_board ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	public List<BoardVO> pageList(int page) {
		List<BoardVO> list = new ArrayList<>();
		conn = getConnect();
		String sql = "select b.* from "
				+ "    (select ROWNUM rn, a.* "
				+ "    from (select * from tbl_board "
				+ "        order by board_no desc) a "
				+ "    where ROWNUM <= ?) b "
				+ " where b.rn >= ? ";
		int from = (page - 1) * 10 + 1;  // 1, 11
		int to = (page * 10);  // 10, 20
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to);
			psmt.setInt(2, from);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public void memberInsert(MemberVO vo) {
		String sql = "insert into members (id,passwd,name,email,resposibility) " + " values(?, ?, ?, ?, 'user')";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			int r = psmt.executeUpdate();
			System.out.println();
			System.out.println("<<" + r + "건 입력되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public MemberVO login(String id, String passwd) {
		conn = getConnect();
		String sql = "select* from members where id = ? ";
		MemberVO vo = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("passwd").equals(passwd)) {
					vo.setId(rs.getString("id"));
					vo.setPasswd(rs.getString("passwd"));
					vo.setName(rs.getString("name"));
					vo.setEmail(rs.getString("email"));
					vo.setResposibility(rs.getString("resposibility"));
					return vo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 회원목록출력하기 for member/MemberList.jsp 에서 jstl 이용
	public List<MemberVO> memberList(){
		List<MemberVO> list = new ArrayList<>();
		conn = getConnect();
		String sql = "select * from members";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("resposibility"));
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
	
	public MemberVO searchMember(String id) {
		conn = getConnect();
		String sql = "select * from members where id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("resposibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public boolean updateMember(MemberVO vo) {
		// 처리건수가 0이면 false;
		conn = getConnect();
		String sql = "update members " + "set passwd = ? " + "where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getId());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	
	public String sendMail(String from, String to, String subject, String content) {
		String _email = "hyeon97101@gmail.com";
		String _password = "tgmsefzsrkverwee";

		System.out.println("Start JavaMail API Test ~!");

//		String subject = "Hello JavaMail API Test";
		String fromMail = from;// "cholee@yedam.ac";
		String fromName = "Charles";
		String toMail = to;// "leadon@naver.com"; // 콤마(,) 나열 가능

		// mail contents
		StringBuffer contents = new StringBuffer();
		contents.append("<h1>Hello</h1>\n");
		contents.append("<p>Nice to meet you ~! :)</p><br>");

		// mail properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // use Gmail
		props.put("mail.smtp.port", "587"); // set port

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // use TLS
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() { // set authenticator
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(_email, _password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(mailSession);

			message.setFrom(new InternetAddress(fromMail, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 한글의 경우
																											// encoding
																											// 필요
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8"); // 내용 설정 (HTML 형식)
			message.setSentDate(new java.util.Date());

			Transport t = mailSession.getTransport("smtp");
			t.connect(_email, _password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();

			System.out.println("Done Done ~!");
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
	}
}
