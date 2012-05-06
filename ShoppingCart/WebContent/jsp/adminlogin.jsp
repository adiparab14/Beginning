<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

<%String message = (String)request.getAttribute("message");
if(message!=null)
out.print(message);
%>
	<form method="post" action="<%=request.getContextPath()%>/Controller">
		<input type="hidden" name="work" value="adminLogin" />
		<fieldset>
			<legend> Login </legend>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>

			<table>
				<tr>
					<input type="submit" name="submit" value="Submit" />
					<input type="reset" name="reset" value="Reset" />
				</tr>
			</table>

		</fieldset>
	</form>
</body>
</html>