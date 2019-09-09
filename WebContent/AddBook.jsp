<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Book</title>
</head>
<body>
	<h1 align="center">ADD BOOK</h1>
	<hr />
	<div align="center">
		<form action="InsertBook" method="post">
			<table>
				<tr>
					<td>Title</td>
					<td><input type="text" name="bookTitle" />
				</tr>
				<tr>
					<td>Subject Name</td>
					<td><input type="text" name="bookSubject" />
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" />
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