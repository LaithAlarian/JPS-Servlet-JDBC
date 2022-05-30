package com.sts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	
	public static final String INSERT_USER = "INSERT INTO USERS (NAME,EMAIL,COUNTRY) VALUES(?,?,?)";

	public static final String UPDATE_USER = "UPDATE USERS SET NAME=?,EMAIL=?,COUNTRY=? WHERE ID=?";

	public static final String DELETE_USER = "DELETE FROM USERS WHERE ID =?";

	public static final String LIST_ALL_USERS = "SELECT * FROM USERS";

	public static final String LIST_USER_BY_ID = "SELECT * FROM USERS WHERE ID =?";

	static ResourceBundle bundle=ResourceBundle.getBundle("com.sts.util.jdbc");
	
	private static String url=bundle.getString("url");
	private static String username=bundle.getString("username");
	private static String password=bundle.getString("password");

	
	public static Connection createConnection()throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, username, password); 
	}
	
	
}
