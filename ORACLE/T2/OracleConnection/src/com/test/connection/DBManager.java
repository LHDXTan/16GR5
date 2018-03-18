package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	
	private static String user="scott";
	
	private static String password="tiger";
	
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
	
	static Connection con;
	
	public static Connection getConnection(){
		try{
			con=DriverManager.getConnection(url,user,password);
			System.out.println("连接成功:"+con);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args){
		DBManager.getConnection();
	}
	
}
