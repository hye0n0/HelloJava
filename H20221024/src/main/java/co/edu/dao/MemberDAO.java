package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {
	
	// 생성, 수정, 삭제, 한건조회, 목록...
	public void memberInsert(MemberVO vo) {
		String sql = "insert into members (id,passwd,name,email) " + " values(?, ?, ?, ?)";
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

	public MemberVO memberSearch(String id) {
		String sql = "select* from members where id = ? ";
		conn = getConnect();
		MemberVO vo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(rs.getString("id"), rs.getString("passwd"),
						rs.getString("name"), rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	public void memberUpdate(MemberVO vo) {
		String sql = " update members " + " set passwd = ?, name = ?, email = ? " + " where id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			int r = psmt.executeUpdate();
			System.out.println();
			System.out.println("<<" + r + "건 변경되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void memberdelete(String id) {
		String sql = "delete from members where id = ? ";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println("<<" + r + "건 삭제되었습니다>>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public List<MemberVO> memberList() {
		conn = getConnect();
		String sql = "select* from members order by id";
		List<MemberVO> list = new ArrayList<>(); // 반환하기위한 값
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getString("id"), rs.getString("passwd"),
						rs.getString("name"), rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
