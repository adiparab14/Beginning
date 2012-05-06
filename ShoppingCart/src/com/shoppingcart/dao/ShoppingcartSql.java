package com.shoppingcart.dao;

public interface ShoppingcartSql {

	String Select_Admin="SELECT * FROM ADMIN WHERE USERNAME = ?";
	
	String Insert_Product="INSERT INTO PRODUCTS(ICOM,DISPLAY,ID) VALUES (?,?,?)";
	
	String Select_Product="SELECT ICOM,DISPLAY,ID FROM PRODUCTS WHERE ID=1002";
}
