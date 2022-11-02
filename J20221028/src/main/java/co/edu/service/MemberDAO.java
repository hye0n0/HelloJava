package co.edu.service;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.common.DAO;
import co.edu.member.MemberVO;

public class MemberDAO extends DAO{
	
	// 부서명, 부서인원
	public Map<String, Integer> getEmpByDept(){
		getConnect();
		Map<String, Integer> map = new HashMap<>();
		String sql = "select d.department_name, count(1) "
				+ "from hr.employees e "
				+ "join hr.departments d "
				+ "on e.department_id = d.department_id "
				+ "group by d.department_name";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return map;
	}
	
	// 스케줄
	public List<Map<String, String>> getSchedule(){
		getConnect();
		List<Map<String, String>> list = new  ArrayList<>();
		String sql = "select * from full_calender ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("title", rs.getString("title"));
				map.put("start_date", rs.getString("start_date"));
				map.put("end_date", rs.getString("end_date"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println(list);
		return list;
	}
	
	// 한건등록
		public boolean insertSchedule(Map<String, String> map) {
			getConnect();
			String sql = "insert into full_calender (title,start_date,end_date) "
					+ "values (?, ?, ?) ";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, map.get("title"));
				psmt.setString(2, map.get("start_date"));
				psmt.setString(3, map.get("end_date"));
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
	
	// 한건 삭제
	public boolean deleteMember(String id) {
		getConnect();
		String sql = "delete from members where id = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
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
	
	// 한건등록
	public void insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd,name,email,resposibility) "
				+ " values(?,?,?,?,'user') ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.executeUpdate();
			
			vo.setResposibility("user");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 전체조회
	public List<MemberVO> memberList(){
		List<MemberVO> list = new  ArrayList<>();
		getConnect();
		String sql = "select * from members";
		
		try {
			psmt =conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
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
	

}
