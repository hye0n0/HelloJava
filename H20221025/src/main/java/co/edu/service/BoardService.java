package co.edu.service;

import java.util.List;

import co.edu.vo.BoardVO;
import co.edu.vo.MemberVO;

public interface BoardService {
	// 기능만 정의
	public BoardVO insertBoard(BoardVO vo);
	public List<BoardVO> getList(BoardVO vo);
	public BoardVO findBoard(int id);
	public boolean updateBoard(BoardVO vo);
	public boolean deleteBoard(int boardNo);
	
	// 페이지
	public List<BoardVO> pageList(int page);
	
	public void addMember(MemberVO vo);
	public MemberVO login(String id, String pass);
	
	// 회원목록
	public List<MemberVO> memberList();
	public MemberVO findMember(String id);
	public boolean updateMember(MemberVO vo);
	
	public String sendMail(String from, String to, String subject, String content);
}
