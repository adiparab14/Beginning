package com.shoppingcart.bean;

import org.apache.commons.fileupload.FileItem;

public class ProductBean {

	String name = "";
	String Specification="";
	FileItem icon;
	FileItem display;
	int quantity;
	double cost;
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
