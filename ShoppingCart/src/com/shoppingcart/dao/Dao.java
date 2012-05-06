package com.shoppingcart.dao;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Request;
import org.apache.commons.fileupload.FileItem;

import com.shoppingcart.bean.AdminBean;
import com.shoppingcart.bean.ProductBean;
import com.shoppingcart.util.*;

public class Dao {

	public String getAdminDetails(AdminBean bean)  throws SQLException,NullPointerException
	{
		ConnectionDtls connDtls = DBConnection.getConnection();
		Connection conn = connDtls.getConn();
		PreparedStatement pstmt = null;	
		String message="";
		try {
			pstmt = conn.prepareStatement(ShoppingcartSql.Select_Admin);
			//System.out.println(bean.getUsername());
			pstmt.setString(1, bean.getUsername());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println("yeah");
				//System.out.println("adi"+((String) rs.getObject("password")));
				if(bean.getUsername().equals((String) rs.getObject("username")))
				{
					if(bean.getPassword().equals((String) rs.getObject("password")))
					{
						message="Welcome "+(String) rs.getObject("name");
						bean.setName((String) rs.getObject("name"));
					}
					
					else 
						message="Invalid Password";
				}
			}
				if(message.equals(""))
					message="Invalid Username";
			
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		catch(NullPointerException e)
		{
			
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally{
			DBConnection.close(pstmt, conn);
		}
		
		return message;
	}
	
	
	public String addProduct(ProductBean b)  throws SQLException,NullPointerException
	{
		ConnectionDtls connDtls = DBConnection.getConnection();
		Connection conn = connDtls.getConn();
		PreparedStatement pstmt = null;	
		String message="";
		try {
			
            //con.setAutoCommit(false);

            pstmt = conn.prepareStatement(ShoppingcartSql.Insert_Product);
            pstmt.setLong(1, b.getId());
            //pstmt.setString(2, phototitle);
            // size must be converted to int otherwise it results in error
            pstmt.setBinaryStream(2, b.getIcon().getInputStream(), (int) b.getIcon().getSize());
            pstmt.executeUpdate();
            //con.commit();
            //con.close();
           // out.println("Proto Added Successfully. <p> <a href='listphotos'>List Photos </a>");

		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		catch(NullPointerException e)
		{
			
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally{
			DBConnection.close(pstmt, conn);
		}
		
		return message;
	}
	
	public Blob displayProduct(ProductBean b)  throws SQLException,NullPointerException
	{
		
		
		ConnectionDtls connDtls = DBConnection.getConnection();
		Connection conn = connDtls.getConn();
		PreparedStatement pstmt = null;	
		Blob b1 = null;
		try {
			pstmt = conn.prepareStatement(ShoppingcartSql.Select_Product);
			pstmt.setInt(1, b.getQuantity());
			ResultSet rs = pstmt.executeQuery();
			//pstmt.setBinaryStream(1,b.getIcon().getInputStream());
			//pstmt.setBinaryStream(2,b.getDisplay().get	InputStream());
			
			while(rs.next()) {
				b1 = rs.getBlob("icom");
			    //System.out.println("A"+b1);
			}
			

		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		catch(NullPointerException e)
		{
			
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally{
			//DBConnection.close(pstmt, conn);
		}
		
		return b1;
	}

}
