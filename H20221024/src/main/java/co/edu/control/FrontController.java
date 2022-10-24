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
		control.put("/memberAddForm.do", new memberAddForm());
		control.put("/memberAdd.do", new MemberAddControl());
		control.put("/memberModifyForm.do", new memberModifyForm());
		control.put("/memberModify.do", new memberModifyControl());
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
