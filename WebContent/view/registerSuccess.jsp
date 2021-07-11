<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 가입 정보를 보여준다. -->
<body>
	<h1> ${customer.name} registered in successfully.</h1>
	<ul>
		<li> Id: ${customer.id } </li>
		<li> Password: ${customer.password } </li>
		<li> Gender: ${customer.gender } </li>
		<li> Name: ${customer.name } </li>
		<li> Email: ${customer.email } </li>
	</ul>
	<p>
		<a href="/hw1-helloMVC/index.jsp"> go to home page </a>
	</p>


</body>
</html>