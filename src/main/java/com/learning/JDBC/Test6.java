package com.learning.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test6 {
	public static void insertQueries() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		String sql = "insert into product values (104,'HP123',67000,'Laptop')";
		String sql2 = "insert into product values (105,'Motorola',27000,'Mobile')";
		String sql3 = "insert into product values (106,'Iphone14',77000,'Mobile')";
		Statement statement = con.createStatement();
		statement.addBatch(sql);
		statement.addBatch(sql2);
		statement.addBatch(sql3);
		int[] rows = statement.executeBatch();
		System.out.println(rows.length+ " rows affected ");
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		insertQueries();

	}

}
