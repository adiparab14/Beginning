<%@page import="java.awt.image.SinglePixelPackedSampleModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.shoppingcart.bean.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductBean singleProductInfo = (ProductBean) request
				.getAttribute("singleProduct");
		ArrayList<ProductBean> singleProduct = singleProductInfo
				.getProducts();
		int size = singleProduct.size();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				out.println(singleProduct.get(i).getName());
	%>


	<form action="<%=request.getContextPath()%>/Controller" method="post">
	<input type="hidden" name="work" value="updateProduct">
		<table>
			<tr>
				<td>Name: <input type="text" name="name"
					value="<%=singleProduct.get(i).getName()%>">
				</td>
			</tr>
			
			<tr>
				<td>Id: <input type="text" name="id" READONLY
					value="<%=singleProduct.get(i).getId()%>">
				</td>
			</tr>
			
			<tr>
				<td>Specifications: <textarea rows="2" cols="20" name="speci" ><%=singleProduct.get(i).getSpecification()%></textarea>
				</td>
			</tr>
			
			<tr>
				<td>Cost: <input type="text" name="cost"
					value="<%=singleProduct.get(i).getCost()%>">
				</td>
			</tr>
			
			<tr>
				<td>Quantity: <input type="text" name="quantity"
					value="<%=singleProduct.get(i).getQuantity()
					%>">
				</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form>
	<%
		}
		}
	%>
</body>
</html>