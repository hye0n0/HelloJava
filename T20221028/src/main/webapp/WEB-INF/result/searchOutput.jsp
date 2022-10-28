<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>조회결과페이지</h3>
	<c:choose>
		<c:when test="${not empty vo}">
			<p>도서코드: ${vo.getBookCode() }</p>
			<p>도서명: ${vo.getBookTitle() }</p>
			<p>도서저자: ${vo.getBookAuthor() }</p>
			<p>도서출판사: ${vo.getBookPress() }</p>
			<p>도서가격: ${vo.getBookPrice() }</p>
		</c:when>
		<c:otherwise>
			<p>조회된 정보가 없습니다!</p>
		</c:otherwise>
	</c:choose>
    <a href="main.do">첫페이지</a>

</body>
</html>