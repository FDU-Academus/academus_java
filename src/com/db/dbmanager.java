package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
public class dbmanager {
	private static String connectionstring;
	private static String username;
	private static String password;
	static{
		try{
			connectionstring = "jdbc:oracle:thin:@localhost:1521:orcl";
			username = "academus";
			password = "academus32";
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection c = null;
		try{
			c = DriverManager.getConnection(connectionstring, username,
					password);
			System.out.println("connect success!");
		}catch(Exception e){
			System.err.println("connect error");
			e.printStackTrace();
		}
		return c;
	}


}