package co.test.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class ListBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookService();
		List<BookVO> list = new ArrayList<>();
		list = service.bookList();
		request.setAttribute("bList", list);
		
		HttpUtil.forward(request, response, "WEB-INF/result/listOutput.jsp");
	}

}
