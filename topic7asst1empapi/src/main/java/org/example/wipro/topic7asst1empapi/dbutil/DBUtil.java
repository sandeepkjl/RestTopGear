package org.example.wipro.topic7asst1empapi.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getDBConnection()
	{
		String dbUrl= "jdbc:oracle:thin:@localhost:1521:xe";
		String dbname="sk6785";
		String dbpwd="sho987";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(dbUrl, dbname,dbpwd);
			
			return con;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
	}

}
