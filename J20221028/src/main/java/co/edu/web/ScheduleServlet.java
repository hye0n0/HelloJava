package co.edu.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.service.MemberDAO;

@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScheduleServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset:utf-8");
		
		MemberDAO dao =  new MemberDAO();
		List<Map<String, String>> result = dao.getSchedule();
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().print(gson.toJson(result));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset:utf-8");
		
		String title = request.getParameter("title");
		String startStr = request.getParameter("start");
		String endStr = request.getParameter("end");
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("start_date", startStr);
		map.put("end_date", endStr);
		System.out.println(map);
		MemberDAO dao =  new MemberDAO();
		if(dao.insertSchedule(map)) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
		
	}

}
