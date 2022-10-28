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

public class passwdReConfirm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BoardService service = new BoardServiceImpl();
		MemberVO mem = service.findMember(id);
		String num = "";
		for(int i=0;i<6;i++) {
			num += (int) (Math.random()*10);
		}
		String mail = service.sendMail("test.email", mem.getEmail(), "비밀번호 재설정", "변경된 비밀번호: "+num);
		Boolean chpw = false;
		if(mail.equals("Success")) {
			mem.setPasswd(num);
			chpw = service.updateMember(mem);
			HttpSession session = req.getSession();
			session.setAttribute("chpw", chpw);
			HttpUtil.forward(req, resp, "member/loginForm.tiles");
		} else {
			HttpUtil.forward(req, resp, "member/passwdReConfirm.tiles");
		}
		
	}

}
