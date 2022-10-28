<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원가입</h3>
	<form action="./signUp.do" method="post" >
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		Name: <input type="text" name="name"><br>
		Mail: <input type="email" name="mail"><br>
		<input type="submit" value="등록">		
	</form>
