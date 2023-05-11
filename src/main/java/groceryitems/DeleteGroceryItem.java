package groceryitems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletelink")

public class DeleteGroceryItem extends HttpServlet{
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1EMJ9?user=root&password=tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String itemId=req.getParameter("itemid");
		
		int id=Integer.parseInt(itemId);
		
		PreparedStatement pstmt=null;
		
		String query="delete from grocery where g_id=?";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			int delete=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			pw.print("<h1 style='color:red'>"+delete+"Recored deleted Successfully</h1>");
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
