package com.learning.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String category;

    public Product(int productId, String productName, double productPrice, String category) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class ProductUtil {
    public static String addProduct(Product product) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into product values (?,?,?,?)");
        ps.setInt(1, product.getProductId());
        ps.setString(2, product.getProductName());
        ps.setDouble(3, product.getProductPrice());
        ps.setString(4, product.getCategory());
        int rows = ps.executeUpdate();
        if (rows > 0) {
            return "Product added successfully!!";
        }
        return "Insertion failed";
    }

    public static String updateProduct(int productId, double productPrice) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("update product set productPrice=? where productId=?");
        ps.setDouble(1, productPrice);
        ps.setInt(2, productId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            return "Product Updated successfully!!";
        }
        return "Updation failed";
    }

    public static String deleteProduct(int productId) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from product where productId=?");
        ps.setInt(1, productId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            return "Product deleted successfully!!";
        }
        return "Deletion failed";
    }

    public static void getProduct() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from product");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("ProductId : " + rs.getInt(1));
            System.out.println("ProductName : " + rs.getString(2));
            System.out.println("ProductPrice : " + rs.getDouble(3));
            System.out.println("Category : " + rs.getString(4));
        }
    }

    public static void getProductById(int productId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from product where productId = ?");
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("ProductId : " + rs.getInt(1));
            System.out.println("ProductName : " + rs.getString(2));
            System.out.println("ProductPrice : " + rs.getDouble(3));
            System.out.println("Category : " + rs.getString(4));
        } else {
            System.out.println("No product found");
        }
    }
}

public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Product p1 = new Product(101, "Dell11345", 78000, "Laptop");
        System.out.println(ProductUtil.addProduct(p1));
    }
}
