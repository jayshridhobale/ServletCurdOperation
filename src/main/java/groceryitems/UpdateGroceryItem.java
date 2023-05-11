package groceryitems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatelink")

public class UpdateGroceryItem extends HttpServlet{
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
		
		 String id=req.getParameter("itemid");
		 String item=req.getParameter("item");
		 String stock=req.getParameter("stock");
		 String price=req.getParameter("price");
		 
		 //parse
		 int id1=Integer.parseInt(id);
		 int stock1=Integer.parseInt(stock);
		 double price1=Double.parseDouble(price);
		 
		 String query="update grocery set g_name=?,stock=?,price=? where g_id=?";
		 PreparedStatement pstmt=null;
		 try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,item);
			pstmt.setInt(2,stock1);
			pstmt.setDouble(3, price1);
			pstmt.setInt(4, id1);
			int update=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			pw.print("<h1 style='color:red'>"+update+"value updated</h1>");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
