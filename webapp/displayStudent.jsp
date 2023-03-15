<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix='c'%>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Record</title>
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
<body>
<a href="../layout.html" target="_blank">Home</a>

<br/>
<br/>
<br/>
	<c:choose>
		<c:when test="${student ne null || ! empty student }">
			<table border='1' align="center">
				<caption>STUDENT RECORD</caption>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>COURSE</th>
					<th>PHONE NUMBER</th>
				</tr>
				<tr>
					<td>${student.sid }</td>
					<td>${student.sname }</td>
					<td>${student.scourse }</td>
					<td>${student.sphone }</td>
				</tr>	
			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color:red; text-align: center;'>No Record to display</h1>
		</c:otherwise>
	</c:choose>		
</body>
</html>