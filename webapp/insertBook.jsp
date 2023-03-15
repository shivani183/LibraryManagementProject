<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert data</title>
<link rel="stylesheet" type="text/css" href="style.css"/>

<style>
a:link, a:visited {
	background-color:#f44336;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}
a:hover, a:active {
	background-color: red;
}

</style>
</head>
<body>
<a href="../layout.html" target="_blank">Home</a>
	<br/>
	<br/>
	<c:choose>
		<c:when test="${status eq 'success'}">
			<h1 style="color:green; text-align:center">BOOK SUCCEFULLY INSERTED IN LIBRARY </h1>
		</c:when>
		<c:otherwise>

			<h1 style="color:red; text-align:center">RECORD INSERTION FAILED</h1>

		</c:otherwise>
	</c:choose>
</body>
</html>