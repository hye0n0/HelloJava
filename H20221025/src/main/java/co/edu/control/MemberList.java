package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.dao.BoardDAO;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;
import co.edu.vo.MemberVO;

public class MemberList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 회원전체목록조회
		BoardService service = new BoardServiceImpl();
		List<MemberVO> list = service.memberList();
		req.setAttribute("list", list);
		
		HttpUtil.forward(req, resp, "member/memberList.tiles");
	}

}
