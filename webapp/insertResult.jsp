<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix = 'c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
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
<a href="../layout.html" target="_blank">Home</a>
	<br/>
	<br/>
	<c:choose>
		<c:when test="${status eq 'success' }">
			<h1 style='color:green;text-align: center'>
				STUDENT'S RECORD INSERTED SUCCESFULLY
			</h1>
		</c:when>
		<c:otherwise>
			<h1 style='color:red;text-align: center'>
				RECORD INSERTION FAILED
			</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>