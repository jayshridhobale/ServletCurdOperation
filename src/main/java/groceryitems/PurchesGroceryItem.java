package groceryitems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/purcheslink")

public class PurchesGroceryItem extends HttpServlet{
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
		int id=Integer.parseInt(req.getParameter("itemid"));
		int quantity=Integer.parseInt(req.getParameter("qty"));
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		PrintWriter pw=resp.getWriter();
		

		String query="select stock,price from grocery where g_id=?";
		String query2="update grocery set stock=? where g_id=?";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int dbStock=rs.getInt(1);
				double dbPrice=rs.getDouble(2);
				if(quantity<=dbStock) {
					double total=quantity*dbPrice;
					pw.println("<h1 style='color:red'>Total Amount is: "+total+"</h1>");
				
			pstmt=con.prepareStatement(query2);
				pstmt.setInt(1,dbStock-quantity );
				pstmt.setInt(2, id);
			int count =	pstmt.executeUpdate();
			pw.print("<h1>Item updated\t"+count+"</h1>");
				}else {
					pw.print("<h1 style='color:red'>Item Out of stock</h1>");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
