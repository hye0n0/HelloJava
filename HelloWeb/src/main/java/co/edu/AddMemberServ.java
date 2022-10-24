package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServ() {
		super();
	}

	// get 방식의 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// content 타입을 지정
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("/addMemberSer 페이지입니다");
		String empId = request.getParameter("employee_id");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hDate = request.getParameter("hire_date");
		String jId = request.getParameter("job_id");
//		System.out.println(empId);
		EmployeeVO emp = new EmployeeVO(0,fName, lName, email, hDate, jId);
		
		//입력
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(emp);
		
		System.out.println("입력완료");
		
		PrintWriter out =  response.getWriter(); // 출력스트림
		out.print("<h3>completed</h3>"
				+ "<h3>입력결과: </h3>"
				+ "<p>사원번호: " + emp.getEmployeeId() + "<br>"
				+ "이름: " + emp.getLastName() + "<br>"
				+ "이메일: " + emp.getEmail() + "<br>"
				+ "입사날짜: " + emp.getHireDate() + "<br>"
				+ "직무: " + emp.getJobId() + "</p>"
				+"<a href=\"http://localhost:8081/HelloWeb/\">시작 페이지 이동</a>");
		
		
		
	}
	
	// post 방식의 요청 시 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		doGet(request, response);
		PrintWriter out = response.getWriter(); // 사용자의 브라우저(출력스트림 생성)
		out.print("<h3>Post 방식의 요청</h3>");
	}

}
