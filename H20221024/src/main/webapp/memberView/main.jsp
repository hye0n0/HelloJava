<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<% 
		String id = (String) session.getAttribute("id"); 
		String auth = (String) session.getAttribute("auth"); 
	%>
	<% if (id != null) {%>
		<p>아이디: <%=id %></p>
	<% } else {%>
		<p>손님</p>
	<% } %>
	
	<h2>Member 첫페이지</h2>
	<% if (auth != null && auth.equals("admin")) {%>
	<a href="./memberAddForm.do">회원정보생성페이지</a><br>
	<% } %>
	<a href="./memberSearch.do?id=<%=id %>&job=update">회원정보수정페이지</a><br>
	<a href="./memberRemoveFrom.do">회원정보삭제페이지</a><br>
	<a href="./memberSearchFrom.do">회원정보조회페이지</a><br>
	<a href="./memberList.do">회원정보목록페이지</a><br>
	<% if (id == null) {%>
	<a href="./LoginForm.do">로그인화면</a><br>
	<% } else { %>
	<a href="./LoginOut.do">로그아웃</a>
	<% } %>
</body>
</html>