<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
	<c:if test="${not empty error}">
		<h3>${error }</h3>
	</c:if>
    <h3>도서삭제조회</h3>
    <form action="./searchBook.do" method="get">
        <input type="text" name="bookCode"><br>
        <input type="hidden" name="job" value="remove">
        <input type="submit" value="조회">
    </form>

    <!-- 도서삭제를 위한 화면 작성코드를 입력하세요. -->
	 <c:choose>
    	<c:when test="${not empty vo}">
	    	<h3>도서삭제확인</h3>
			<form action="./removeBook.do" method="post">
				책코드: <input type="text" name="bookCode" value="${vo.getBookCode() }" readonly><br>
		        제목: <input type="text" name="title" value="${vo.getBookTitle() }" readonly><br>
		        저자: <input type="text" name="author" value="${vo.getBookAuthor() }" readonly><br>
		        출판사: <input type="text" name="press" value="${vo.getBookPress() }" readonly><br>
		        가격: <input type="text" name="price" value="${vo.getBookPrice() }" readonly><br>
		        <input type="submit" value="삭제">
		    </form>
    	</c:when>
    	<c:otherwise>
    		<p>조회된 정보가 없습니다!</p>
    	</c:otherwise>
    </c:choose>
    <a href="main.do">첫페이지</a>

</body>

</html>