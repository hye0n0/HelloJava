<%@page import="org.apache.commons.collections.bag.SynchronizedSortedBag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String paging = (String) request.getParameter("page"); 
		session.getAttribute("id");
		System.out.println(paging);
		application.setAttribute("info", "hong");
		session.setAttribute("mysession", 1234);
		session.setAttribute("yoursession", 5678);
	%>
</body>
</html>