package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.MemberVO;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO();
	
	@Override
	public BoardVO insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int id) {
		// TODO Auto-generated method stub
		return dao.searchBoard(id);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}

	@Override
	public void addMember(MemberVO vo) {
		dao.memberInsert(vo);
	}

	@Override
	public MemberVO login(String id, String pass) {
		return dao.login(id,pass);
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO findMember(String id) {
		return dao.searchMember(id);
	}

	@Override
	public String sendMail(String from, String to, String subject, String content) {
		return dao.sendMail(from, to, subject, content);
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		return dao.updateMember(vo);
	}

}
