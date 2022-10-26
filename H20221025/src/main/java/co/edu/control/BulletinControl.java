package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.BoardVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class BulletinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		int pg = Integer.parseInt(page);
		
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.pageList(pg); // service.getList(new BoardVO(0, "", "", "", "", 0, ""));
		
		for(BoardVO vo : list) {
			System.out.println(vo.getBoardNo());
		}
		req.setAttribute("bList", list);
		
		HttpUtil.forward(req, resp, "bulletin/bulletin.tiles");
		
	}

}
