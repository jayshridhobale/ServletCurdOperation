package groceryitems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addlink")
public class AddGroceryItem extends HttpServlet{
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1EMJ9?user=root&password=tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//fetch the values from html
	 String item=req.getParameter("item");
	 String stock=req.getParameter("stock");
	 String price=req.getParameter("price");
	 
	 //parse value
	 int stock1=Integer.parseInt(stock);
	 double price1=Double.parseDouble(price);
	 
	 //declare resources
	PreparedStatement pstmt;
	
	//create query
	String query="insert into grocery(g_name,stock,price) values(?,?,?)";
	
	try {
		pstmt=con.prepareStatement(query);
		pstmt.setString(1,item);
		pstmt.setInt(2, stock1);
		pstmt.setDouble(3, price1);
		int addition=pstmt.executeUpdate();
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1 style='color:red'>"+addition+"Record Inserted Successfully</h1>");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	}

}
