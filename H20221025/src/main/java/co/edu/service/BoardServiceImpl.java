package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.dao.BoardDAO;

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

}
