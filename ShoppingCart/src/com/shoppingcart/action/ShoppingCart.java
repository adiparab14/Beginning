package com.shoppingcart.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shoppingcart.bean.AdminBean;
import com.shoppingcart.bean.ProductBean;
import com.shoppingcart.dao.Dao;

public class ShoppingCart {

	public String verifyAdmin(HttpServletRequest request, HttpServletResponse response) throws NullPointerException, SQLException
	{
		AdminBean bean = new AdminBean();
		Dao d = new Dao();
		System.out.println("bab");
		bean.setUsername(request.getParameter("username"));
		bean.setPassword(request.getParameter("password"));
		String message = d.getAdminDetails(bean);
		return message;
		//System.out.println(message);
	}
	
	public void addProducts(HttpServletRequest request, HttpServletResponse response) throws NullPointerException, SQLException
	{
		ProductBean bean = new ProductBean();
		Dao d = new Dao();
		//Adding from shrikanth technologies
		 response.setContentType("text/html;charset=UTF-8");
	        
	            // Apache Commons-Fileupload library classes
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload sfu  = new ServletFileUpload(factory);

	            if (! ServletFileUpload.isMultipartContent(request)) {
	                System.out.println("sorry. No file uploaded");
	                return;
	            }

	            // parse request
	            
				try {
					List items = sfu.parseRequest(request);
					
						FileItem  id = (FileItem) items.get(3);
						bean.setId(Integer.parseInt(id.getString()));
					
						FileItem  name = (FileItem) items.get(4);
			            bean.setName(name.getString());
			            //String photoid =  name.getString();
			            
			            FileItem specification = (FileItem) items.get(5);
			            bean.setSpecification(specification.getString());
			            
			            FileItem cost = (FileItem) items.get(6);
			            bean.setCost(Double.parseDouble(cost.getString()));
			            
			           FileItem quantity = (FileItem) items.get(7);
			           bean.setQuantity(Integer.parseInt(quantity.getString()));
			            
			            System.out.println("Name"+bean.getName());
			            System.out.println("Speci"+bean.getSpecification());
			            System.out.println("Cos"+bean.getCost());
			            System.out.println("Qua"+bean.getQuantity());

			            // get uploaded file
			            bean.setIcon((FileItem) items.get(1));
			            //FileItem file = (FileItem) items.get(0);
			            d.addProduct(bean);  
			            // Connect to Oracle
			            
				
				
				System.out.println("hello");
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	public void listProducts(HttpServletRequest request, HttpServletResponse response) throws NullPointerException, SQLException
	{
		Dao d = new Dao();
		ProductBean ProductList = d.listProducts();
		request.setAttribute("ProductList",ProductList);
	}

	public void singleProductEdit(HttpServletRequest request, HttpServletResponse response) throws NullPointerException, SQLException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("product_id"));
		Dao d = new Dao();
		ProductBean singleProduct = d.singleProductEdit(id);
		request.setAttribute("singleProduct",singleProduct);
	}

	public void updateProduct(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Dao d = new Dao();
		ProductBean bean = new ProductBean();
		bean.setName(request.getParameter("name"));
		bean.setCost(Double.parseDouble(request.getParameter("cost")));
		bean.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setSpecification(request.getParameter("speci"));
		//System.out.println(bean.getName());
		d.updateProduct(bean);
	}
	
	
}
