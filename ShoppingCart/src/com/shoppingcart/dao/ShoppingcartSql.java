package com.shoppingcart.dao;

public interface ShoppingcartSql {

	String Select_Admin="SELECT * FROM ADMIN WHERE USERNAME = ?";
	
	String Insert_Product="INSERT INTO PRODUCTS(ID,ICOM,NAME,SPECIFICATIONS,COST,QUANTITY) VALUES (?,?,?,?,?,?)";
	
	String Select_Product="SELECT ICOM,ID FROM PRODUCTS WHERE ID=?";
	
	String Select_ListProducts="Select NAME,ID FROM PRODUCTS";

	String Select_SingleProduct = "Select NAME,ID,COST,QUANTITY,SPECIFICATIONS FROM PRODUCTS WHERE ID=?";

	String Update_SingleProduct = "Update PRODUCTS SET NAME=?, COST=?, Quantity=?, SPECIFICATIONS=? "+
									"WHERE ID=?";
}
