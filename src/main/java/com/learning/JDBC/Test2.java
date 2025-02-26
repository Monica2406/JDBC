package com.learning.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

//class Student{
//	private int studentId;
//	private String student

class JDBCUtil{
	public static String insertData() throws ClassNotFoundException, SQLException {
//		int id = s1.getStudentId();
//		String name = s1.getStudentName();
//		String dept = s1.getDepartment();
		String sql = "insert into student values(101,'Harsh','CSE')";
		Statement statement = DBConnection.getConnection().createStatement();
		int rows = statement.executeUpdate(sql);
		if(rows>0) {
			return "Student added successfully";
		}
		return "Insertion failed";
	}
}
public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Student s1 = new Student(101,"Harsh","CSE");
		System.out.println(JDBCUtil.insertData());
		
		

	}

}
