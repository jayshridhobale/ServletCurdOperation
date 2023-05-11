//package com.jd.grocery.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.jd.grocery.model.Item;
//
//public class ItemDao {
//	private  Connection con;
//	PreparedStatement pstmt;
//	ResultSet rs;
//	{
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1EMJ9","root","tiger");
//		} catch (SQLException | ClassNotFoundException e) {
//			System.out.println("Database Connection failed");
//			e.printStackTrace();
//		}
//	}
//	public Item add(Item item) {
//		try {
//			String query="insert into grocery(g_name,stock,price) values(?,?,?)";
//			
//	
//			pstmt=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
//			pstmt.setString(1,item.getItemName() );
//			pstmt.setInt(2, item.getStock());
//			pstmt.setDouble(3, item.getPrice());
//			Object res= pstmt.execute();
//			System.out.println(res);
//			
//			rs=pstmt.getGeneratedKeys();
//			if(rs.next()) {
//				item.setId(rs.getInt(1));
//				System.out.println(rs.getObject(1));
//			}else {
//				throw new SQLException("item Addition failed,no id generated");
//			}
//			
//			return item;
//		}catch (Exception e) {
//			System.out.println("Item Addition Failed" +e.getMessage());
//			return null;
//		}
//	}
//}
    