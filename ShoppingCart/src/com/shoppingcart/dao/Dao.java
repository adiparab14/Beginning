package com.shoppingcart.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            pstmt.setString(3, b.getName());
            pstmt.setString(4,b.getSpecification());
            pstmt.setLong(5, (long) b.getCost());
            pstmt.setLong(6, b.getQuantity());
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
	
	public ProductBean listProducts()  throws SQLException,NullPointerException
	{
		ConnectionDtls connDtls = DBConnection.getConnection();
		Connection conn = connDtls.getConn();
		PreparedStatement pstmt = null;	
		ProductBean bean =new ProductBean();
		try {
			pstmt = conn.prepareStatement(ShoppingcartSql.Select_ListProducts);
			ArrayList<ProductBean> products = new ArrayList<ProductBean>();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductBean b = new ProductBean();
				b.setId(rs.getInt("id"));
				//b.setSpecification(rs.getString("specifications"));
				//b.setCost(rs.getDouble("cost"));
				//b.setQuantity(rs.getInt("quantity"));
				b.setName(rs.getString("name"));
				products.add(b);
			}
			bean.setProducts(products);
			
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
		
		return bean;
	}


	public ProductBean singleProductEdit(int id)throws SQLException,NullPointerException
	{
		// TODO Auto-generated method stub
		
		ConnectionDtls connDtls = DBConnection.getConnection();
		Connection conn = connDtls.getConn();
		PreparedStatement pstmt = null;	
		ProductBean bean =new ProductBean();
		try {
			pstmt = conn.prepareStatement(ShoppingcartSql.Select_SingleProduct);
			ArrayList<ProductBean> products = new ArrayList<ProductBean>();
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductBean b = new ProductBean();
				b.setId(rs.getInt("id"));
				b.setSpecification(rs.getString("specifications"));
				b.setCost(rs.getDouble("cost"));
				b.setQuantity(rs.getInt("quantity"));
				b.setName(rs.getString("name"));
				products.add(b);
			}
			bean.setProducts(products);
			
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
		
		return bean;
		
	}


	public void updateProduct(ProductBean bean) {
		// TODO Auto-generated method stub
		
		ConnectionDtls connDtls = DBConnection.getConnection();
		Connection conn = connDtls.getConn();
		PreparedStatement pstmt = null;	
		//ProductBean bean =new ProductBean();
		try {
			pstmt = conn.prepareStatement(ShoppingcartSql.Update_SingleProduct);
			pstmt.setString(1, bean.getName());
			pstmt.setDouble(2, bean.getCost());
			pstmt.setInt(3, bean.getQuantity());
			pstmt.setString(4, bean.getSpecification());
			pstmt.setInt(5, bean.getId());
			pstmt.executeUpdate();
			
			
			
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
		
		//return bean;
		
	}

}
