package com.shoppingcart.bean;

import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;

public class ProductBean {

	String name = "";
	String Specification="";
	FileItem icon;
	FileItem display;
	int quantity;
	double cost;
	int id ;
	private ArrayList<ProductBean> products;
	
	public ArrayList<ProductBean> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<ProductBean> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
	public FileItem getIcon() {
		return icon;
	}
	public void setIcon(FileItem icon) {
		this.icon = icon;
	}
	public FileItem getDisplay() {
		return display;
	}
	public void setDisplay(FileItem display) {
		this.display = display;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		this.quantity = i;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	
	
}
