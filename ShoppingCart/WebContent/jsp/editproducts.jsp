<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.shoppingcart.bean.*" %>
     <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Products</title>
</head>
<body>
<table>
<tr>
<%ProductBean ProductList= (ProductBean)request.getAttribute("ProductList");
ArrayList<ProductBean> prodList = ProductList.getProducts();
					int size = prodList.size();
					if(size > 0){
						for (int i = 0; i < size; i++) 
						{
							out.println();
							%>
							<td><a href="<%=request.getContextPath() %>/Controller?work=singleProductView&product_id=<%=prodList.get(i).getId()%>"><%=prodList.get(i).getName()%></a></td>
							<% }}%>		
</tr>							
							</table>
</body>
</html>