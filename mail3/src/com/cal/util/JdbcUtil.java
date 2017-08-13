package com.cal.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class JdbcUtil {
	private static String driverClassName;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		try {
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("files");
			Properties props = new Properties();
			props.load(in);
			driverClassName = props.getProperty("driverClassName");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void Liahjie(ResultSet rs,PreparedStatement stmt,Connection conn){
		if(rs != null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(stmt != null){
			try{
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
