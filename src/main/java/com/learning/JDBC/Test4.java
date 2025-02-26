package com.learning.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;


public class Test4 {
	public static void callProcedure() throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		CallableStatement stmt = con.prepareCall("{call getProducts()}");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.println("ProductId : " + rs.getInt(1));
            System.out.println("ProductName : " + rs.getString(2));
            System.out.println("ProductPrice : " + rs.getDouble(3));
            System.out.println("Category : " + rs.getString(4));
			System.out.println("______________________________________");
		}
	}
	public static void callProcedureById(int productId) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		CallableStatement stmt = con.prepareCall("{call getProductById(?)}");
		stmt.setInt(1, productId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			System.out.println("ProductId : " + rs.getInt(1));
            System.out.println("ProductName : " + rs.getString(2));
            System.out.println("ProductPrice : " + rs.getDouble(3));
            System.out.println("Category : " + rs.getString(4));	
		}
	}
	public static void insertData(Product p) throws ClassNotFoundException, SQLException {
	    Connection con = DBConnection.getConnection();
	    CallableStatement stmt = con.prepareCall("{call insertData(?,?,?,?)}");
	    stmt.setInt(1, p.getProductId());
	    stmt.setString(2, p.getProductName());
	    stmt.setDouble(3, p.getProductPrice());
	    stmt.setString(4, p.getCategory());
	    int rows = stmt.executeUpdate();
	    if (rows > 0) {
	        System.out.println("product added successfully");
	    } else {
	        System.out.println("Insertion failed");
	    }
	}



	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//callProcedure();
		//callProcedureById(102);
		Product p = new Product(103,"SamsungS25Ultra",98000,"Mobile");
		insertData(p);
		

	}

}
