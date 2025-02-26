package com.learning.JDBC;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Test5 {
	public static void getMetaData() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		DatabaseMetaData metaData = con.getMetaData();
		System.out.println(metaData.getDriverName());
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(metaData.getDatabaseProductVersion());
	}
	public static void getInfo() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.getResultSet();
		ResultSetMetaData metadata = resultSet.getMetaData();
		System.out.println(metadata.getColumnCount());
		System.out.println(metadata.getColumnClassName(1));
		System.out.println(metadata.getTableName(1));
		System.out.println(metadata.getColumnName(2));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//getMetaData();
		getInfo();

	}

}
