<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}

</style>
</head>
<body >
<a href="../layout.html" target="_blank">Home</a>

<br/>
<br/>
<br/>
	<c:choose>
		<c:when test="${book ne null || ! empty book }">
			<table border='1' text-align="center">
			<caption>Book's Information!</caption>
				<tr>
					<td>Book's ID</td>
					<td>Book's NameE</td>
					<td>Book's Author</td>
					<td>Book's Subject</td>
					<td>Quantity</td>
				</tr>
				<tr>
					<td>${book.bid}</td>
					<td>${book.bname}</td>
					<td>${book.bauthor}</td>
					<td>${book.bsubject}</td>
					<td>${book.quantity}</td>
				</tr>
			</table>

		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">NO RECORDS AVAILABLE
				FOR DISPLAYING</h1>
		</c:otherwise>

	</c:choose>
</body>
</html>