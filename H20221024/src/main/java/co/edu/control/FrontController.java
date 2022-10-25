package co.edu.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;

public class FrontController extends HttpServlet{
	
	Map<String, Command> control = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		control.put("/main.do", new MainControl());
		// 추가기능
		control.put("/memberAddForm.do", new MemberAddForm());
		control.put("/memberAdd.do", new MemberAddControl());
		// 수정기능
		control.put("/memberModifyForm.do", new MemberModifyForm());
		control.put("/memberModify.do", new MemberModifyControl());
		// 삭제기능
		control.put("/memberRemoveFrom.do", new MemberRemoveFrom());
		control.put("/memberRemove.do", new MemberRemoveControl());
		// 단건조회
		control.put("/memberSearchFrom.do", new MemberSearchFrom());
		control.put("/memberSearch.do", new MemberSearchControl());
		// 목록
		control.put("/memberList.do", new MemberListControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = control.get(path);
		command.exec(req, resp);
	}
}
