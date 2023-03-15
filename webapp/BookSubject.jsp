<%@page import="java.sql.Date"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
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

</style>
</head>
<body>

<a href="layout.html" target="_blank">Home</a>

	<table>
		<thead>
			<tr>
				<th>Book's Id</th>
				<th>Book's Name</th>
				<th>Book's Author</th>
				<th>Book's Subject</th>
				<th>Quantity</th>

			</tr>
		</thead>
		<tbody>
			<%
			ResultSet rs = null;
			rs = (ResultSet) session.getAttribute("BookSubject");
			System.out.println(rs);
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getInt(5)%></td>
				

			</tr>

			<%
			}
			%>

		</tbody>
	</table>

</body>
</html>




