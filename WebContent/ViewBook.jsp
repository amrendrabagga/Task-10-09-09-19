<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Book</title>
</head>
<body>
	<h1 align="center">VIEW BOOK</h1>
	<hr />
	<div align="center">
		<form action="ViewBook" method="post">
			<table>
				<tr>
					<td>Enter Subject</td>
					<td><input type="text" name="subjectName" /></td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit"
						value="SUBMIT" /></td>
				</tr>
			</table>
		</form>
	</div>
	<hr />
	<a href="index.jsp">Go to DashBoard</a>
</body>
</html>