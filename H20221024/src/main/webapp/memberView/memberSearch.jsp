<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보 검색</h3>
	<form action="./memberSearch.do" method="post">
		<input type="hidden" name="job" value="search">
		ID: <input type="text" name="id"><br> <input
			type="submit" value="조회">
	</form>
</body>
</html>