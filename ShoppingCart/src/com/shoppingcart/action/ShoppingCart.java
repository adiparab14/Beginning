package com.shoppingcart.action;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shoppingcart.bean.AdminBean;
import com.shoppingcart.bean.ProductBean;
import com.shoppingcart.dao.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
		Dao d = new Dao();
		ProductBean b = new ProductBean();
		FileItemFactory factory = new DiskFileItemFactory();
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			List<FileItem>items = upload.parseRequest(request);
			  b.setIcon((FileItem) items.get(0));
			  b.setDisplay((FileItem) items.get(1));
			  for(FileItem item:items)
			  {
				  if(item.getFieldName().equals("id"))
				  b.setQuantity(Integer.parseInt(item.getString()));
			  }
			 // FileItem file = (FileItem) items.get(0);
			  	d.addProduct(b);
			  	Blob b1 = d.displayProduct(b);
	            response.setContentType("image/jpeg");
	            response.setContentLength( (int) b1.length());
	            InputStream is = b1.getBinaryStream();
	            OutputStream os = response.getOutputStream();
	            byte buf[] = new byte[(int) b1.length()];
	            is.read(buf);
	            os.write(buf);
	            os.close();
	          
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
