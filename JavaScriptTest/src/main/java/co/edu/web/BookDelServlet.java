package co.edu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.BookDAO;

@WebServlet("/BookDelServlet")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookDelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset:utf-8");
		String bookCode = request.getParameter("bookCode");
		BookDAO dao = new BookDAO();
		if(dao.bookDel(bookCode)) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
	}

}
