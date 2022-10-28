package co.test.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.web.AddBookControl;
import co.test.web.AddBookFormControl;
import co.test.web.ListBookControl;
import co.test.web.MainControl;
import co.test.web.ModifyBookControl;
import co.test.web.ModifyBookFormControl;
import co.test.web.RemoveBookControl;
import co.test.web.RemoveBookFormControl;
import co.test.web.SearchBookControl;
import co.test.web.SearchBookFormControl;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Controller> map;
	String enc;

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		enc = config.getInitParameter("encoding");

		map = new HashMap<String, Controller>();

		map.put("/main.do", new MainControl());

		map.put("/addBookForm.do", new AddBookFormControl());
		map.put("/addBook.do", new AddBookControl());

		map.put("/searchBookForm.do", new SearchBookFormControl());
		map.put("/searchBook.do", new SearchBookControl());

		map.put("/modifyBookForm.do", new ModifyBookFormControl());
		map.put("/modifyBook.do", new ModifyBookControl());

		map.put("/removeBookForm.do", new RemoveBookFormControl());
		map.put("/removeBook.do", new RemoveBookControl());

		map.put("/listBook.do", new ListBookControl());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(enc);

		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println(path);
		Controller controller = map.get(path);
		controller.execute(request, response);

	}

}
