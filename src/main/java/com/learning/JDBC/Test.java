package com.learning.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBConnection{
	private static final String url = "jdbc:mysql://localhost:3306/jdbc";
	private static final String username = "root";
	private static final String password = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
	public static String getTable()throws ClassNotFoundException, SQLException {
		String sql = "create table student(id int(20),name varchar(20),dept varchar(20))";
		Statement statement = getConnection().createStatement();
		boolean result = statement.execute(sql);
		if(!result) {
			return "Table created successfully";
		}
		return "Something went wrong";
	}
	
}
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(DBConnection.getConnection());
		System.out.println(DBConnection.getTable());
		

	}

}
