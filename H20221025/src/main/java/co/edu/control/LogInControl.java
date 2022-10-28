package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;
import co.edu.vo.MemberVO;

public class LogInControl implements Control {
	// 아이디, 패스워드 => 검증 맞으면 session객체에 id값을 저장
	// 로그인성공했습니다. login.jsp에 출력 
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("passwd");

		BoardService service = new BoardServiceImpl();
		MemberVO result = service.login(id, pass);
		// 회원아이디와 비밀번호 => main.jsp이동 
		if(result != null) {
			req.setAttribute("logInfo", result);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("auth", result.getResposibility());
			
			HttpUtil.forward(req, resp, "member/login.tiles");
		} else {
			HttpUtil.forward(req, resp, "member/loginForm.tiles");
		}
		
	}
}
