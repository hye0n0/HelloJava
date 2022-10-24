package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class MemberAddControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter 값에 따라서...
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO(id, passwd, name, mail);
		
		// DB 입력처리
		MemberService service = new MemberServiceImpl();
		service.addMember(vo);
		
		// 처리된 결과를 페이지
		HttpUtil.forward(req, resp, "memberResult/memberInsertOutput.jsp");
	}

}
