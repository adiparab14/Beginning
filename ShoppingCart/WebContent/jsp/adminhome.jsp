<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/design.css" type="text/css">
</head>
<body>
<div id=right>
<a href="<%=request.getContextPath() %>/Controller?work=adminLogout">Logout</a>
</div>
<%String message = (String)request.getAttribute("message");
if(message!=null)
	out.println("<center><font color=red>"+message+"</center></font>");
%>
<br /><br /><br /><br /><br /><br />
<div id="center">
<a href="<%=request.getContextPath()%>/jsp/addproduct.jsp">Add Product</a>&nbsp;<br />
<a href="">Edit Product Information</a>
</div>
</body>
</html>