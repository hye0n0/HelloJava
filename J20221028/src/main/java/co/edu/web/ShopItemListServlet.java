package co.edu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.shopItem;

@WebServlet("/ShopItemListServlet")
public class ShopItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShopItemListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		shopItem item1 = new shopItem("item001", "과테말라 안티구아", 5000, 4000, 4.5, "과테말라 안티구아.jpg");
		shopItem item2 = new shopItem("item002", "니카라구아 핸드드립", 5500, 4500, 4.0, "니카라구아 핸드드립.jpg");
		shopItem item3 = new shopItem("item003", "브라질산토스", 6000, 5000, 3.0, "브라질산토스.jpg");
		shopItem item4 = new shopItem("item004", "에티오피아 예가체프", 5200, 4200, 3.5, "에티오피아 예가체프.jpg");
		shopItem item5 = new shopItem("item005", "케냐 오크라톡신", 7000, 5000, 4.0, "케냐 오크라톡신.jpg");
		shopItem item6 = new shopItem("item006", "코스타리카 따라주", 8000, 5500, 3.0, "코스타리카 따라주.jpg");
		List<shopItem> itemList = new ArrayList<shopItem>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		itemList.add(item6);
		
		response.setContentType("text/json;charset:utf-8");
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(itemList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
