package com.shoppingcart.dao;

public interface ShoppingcartSql {

	String Select_Admin="SELECT * FROM ADMIN WHERE USERNAME = ?";
	
	String Insert_Product="INSERT INTO PRODUCTS(ID,ICOM,NAME,SPECIFICATIONS,COST,QUANTITY) VALUES (?,?,?,?,?,?)";
	
	String Select_Product="SELECT ICOM,ID FROM PRODUCTS WHERE ID=?";
	
	String Select_ListProducts="Select NAME FROM PRODUCTS";
}
