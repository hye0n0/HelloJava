<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>도서 리스트.</title>
</head>

<body>
	<c:choose>
		<c:when test="${not empty bList }">
			<table border="1">
	        <caption>도서목록</caption>
		    <thead>
		            <tr>
		                <th>도서코드</th>
		                <th>도서명</th>
		                <th>도서저자</th>
		                <th>도서출판사</th>
		                <th>도서가격</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach var="vo" items="${bList }">
		        		<tr>
		        			<td>${vo.getBookCode() }</td>
		        			<td>${vo.getBookTitle() }</td>
		        			<td>${vo.getBookAuthor() }</td>
		        			<td>${vo.getBookPress() }</td>
		        			<td>${vo.getBookPrice() }</td>
		        		</tr>
		        	</c:forEach>
		        </tbody>
		    </table>
		</c:when>
		<c:otherwise>
		<p>조회되는 정보가 없습니다</p>
		</c:otherwise>
	</c:choose>
    
    
    <a href="main.do">첫페이지</a>
</body>

</html>