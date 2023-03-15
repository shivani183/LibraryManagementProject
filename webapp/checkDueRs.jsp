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
.p3 {
  font-family: "Lucida Console", "Courier New", monospace;
  color:black;
  font-size:2vw;
  text-align:center;
  
}
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
}input[type=text], select {
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
	background-color: #66270b;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #9a5536;
}

div {
	border-radius: 5px;
	background-color: lightyellow;
	padding: 20px;
	height: 315px;
	width: 30%;
	margin-top: 50px;
	margin-right: 50px;
	margin-bottom: 300px;
	margin-left: 440px;
}
</style>
</head>
<body>

<a href="layout.html" target="_blank">Home</a>

	<table>
		<thead>
			<tr>
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Issue Date</th>
				<th>Due Date</th>
				<th>Fine Amount(5rs/day)</th>

			</tr>
		</thead>
		<tbody>
			<%
			ResultSet rs = null;
			rs = (ResultSet) session.getAttribute("checkDueRs");
			System.out.println(rs);
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getDate(5)%></td>
				<td><%=rs.getDate(6)%></td>
				<td>
					<%
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate currentDate = LocalDate.now();
					Date duedate = rs.getDate(6);

					LocalDate newDuedate = duedate.toLocalDate();

					String dueDateString = formatter.format(newDuedate);
					String issueDateString = formatter.format(currentDate);
					LocalDate date1 = LocalDate.parse(dueDateString, formatter);
					LocalDate date2 = LocalDate.parse(issueDateString, formatter);

					long noDays = ChronoUnit.DAYS.between(date1, date2);
					if (noDays <= 0) {
						noDays = 0;
					} else {
						noDays = noDays * 5;
					}
					%><%=noDays + "Rs"%></td>

			</tr>

			<%
			}
			%>

		</tbody>
	</table>
<br/>
<br/>
<br/>
<br/>

<div>
<h2 class="p3">Return A Book</h2>
		<form method="post" action="./issueBookController/returnBook">
			<label for="fname">Student Id</label> 
			<input type="text" id="fname" name="sid" placeholder="student Id.."> 
			<label for="fname">Book Id</label> 
			<input type="text" id="fname" name="bid" placeholder="Book Id.."> 
			<input type="submit" value="Return">
			
		</form>
		</div>
</body>
</html>




