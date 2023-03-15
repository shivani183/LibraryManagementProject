<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('mylib.jpeg');
  background-repeat: no-repeat;
  background-size: 1500px 825px;
}
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

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body >
<a href="./layout.html" target="_blank">Home</a>
<div>
	<c:choose>
		<c:when test="${student ne null || !empty student}">
		<h1 style="text-align:center;color:brown">Edit Student's Record</h1>
			<form method="get" action="./controller/updateRecord">
				<table align="center">
					<tr>
						<th>SID</th>
						<td><input type="text" readonly="readonly" name="sid"
							value="${student.sid}" /></td>
					</tr>
					<tr>
						<th>SNAME</th>
						<td><input type="text" name="sname" value="${student.sname}" /></td>
					</tr>
					<tr>
						<th>COURSE</th>
						<td><input type="text" name="scourse" value="${student.scourse}" /></td>
					</tr>
					<tr>
						<th>PHONE</th>
						<td><input type="text" name="sphone"
							value="${student.sphone}" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="Update" /></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h1 style="color: green; text-align: center;">NO RECORDS
				AVAILBALE</h1>
		</c:otherwise>
	</c:choose></div>
</body>
</html>