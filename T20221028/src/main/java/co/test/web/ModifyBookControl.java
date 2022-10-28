package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookCode = request.getParameter("bookCode");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		int price = Integer.parseInt(request.getParameter("price")); 
		
		BookService service = new BookService();
		BookVO book = new BookVO(bookCode,title,author,press,price);
		service.modifyBook(book);
		
		HttpUtil.forward(request, response, "WEB-INF/result/modifyOutput.jsp");
	}

}
