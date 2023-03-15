<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert data</title>
<style>
a:link, a:visited {
	background-color: #f44336;
	color: white;
	padding:14px 25px;
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
<a href="../layout.html" target="_blank">Home</a>
<br/>
<br/>
	<c:choose>
		<c:when test="${status eq 'success'}">
			<h1 style="color:green; text-align:center">BOOK ISSUED SUCCEFULLY</h1>
		</c:when>
		<c:otherwise>

			<h1 style="color:red; text-align:center">ISSUING BOOK FAILED</h1>

		</c:otherwise>
	</c:choose>
</body>
</html>