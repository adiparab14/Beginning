<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post"
		action="<%=request.getContextPath() %>/Controller?work=productadd"
		enctype="multipart/form-data">
		<input type="hidden" name="work" value="productadd">
		<table>
			<tr>
				<td>Icon image:</td>
				<td><input type="file" name="icon"></td>
			</tr>
			<tr>
				<td>Product Page Image</td>
				<td><input type="file" name="display"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Specifications</td>
				<td><textarea rows="2" cols="20" name="speci"></textarea></td>
			</tr>
			<tr>
				<td>Cost</td>
				<td><input type="text" name="cost"></td>
			</tr><tr>
				<td>Quantity</td>
				<td><input type="text" name="id"></td>
			</tr>
		</table>
		<br />
		<br />
		<br /> <input type="submit" value="Submit">
	</form>
</body>
</html>