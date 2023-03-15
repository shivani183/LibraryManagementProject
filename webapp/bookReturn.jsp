<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Result Page</title>
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

</style>
</head>
<body bgcolor="white">
<a href="../layout.html" target="_blank">Home</a>
	<br />
	<br />
	<br />
	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style="color: darkgreen; text-align: center;">BOOK RETURNED SUCCESFULLY !</h1>
		</c:when>
		<c:when test="${status eq 'failure' }">
			<h1 style="color: red; text-align: center;">RETURNING BOOK
				FAILED</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color: green; text-align: center;">RECORD NOT AVAILABLE FOR DELETION</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>