<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert data</title>
<style>
a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}
a:hover, a:active {
	background-color: red;
}
body {
  background-image: url('mylib.jpeg');
  background-repeat: no-repeat;
  background-size: 1500px 825px;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${status eq 'success'}">
			<h1
				style="color: green; text-align: center; background-color: lightyellow;">LIBRARIAN
				RECORD REGISTERED SUCCEFULLY</h1>
			<CENTER>
				<a href="../index.jsp" target="_blank">HOME</a>
			</CENTER>
		</c:when>
		<c:otherwise>
			<h1
				style="color: red; text-align: center; background-color: black;">RECORD
				INSERTION FAILED</h1>
			<CENTER>
				<a href="index.jsp" target="_blank">HOME</a>
			</CENTER>
		</c:otherwise>
	</c:choose>
</body>
</html>