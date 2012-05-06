package com.shoppingcart.util;

import java.sql.Connection;

/**
 * to pass the connection, error message etc across different methods 
      * @author Lipi Soral and Aditya Parab
      * @version   1.0   
      * @Class ConnectionDtls
      * @Creation Date 20-08-2011 
*/
public class ConnectionDtls {
	
	Connection conn;
	String message;
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
