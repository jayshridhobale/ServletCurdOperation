package groceryitems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaylink")

public class DisplayGroceryItem extends HttpServlet{
	Connection con=null;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Statement stmt=null;
		ResultSet rs=null;
		
		PrintWriter pw=resp.getWriter();
		
		String query="select * from grocery";
		
		pw.print("<h1 style='color:red'>Display Grocery Data </h1>");
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			pw.print("<table border='4' >" );
			pw.print("<tr>");
			pw.print("<th>Grocery Id</th>");
			pw.print("<th>Grocery Name</th>");
			pw.print("<th>Grocery Stock</th>");
			pw.print("<th>Grocery Price</th>");
			pw.print("</tr>");
			
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getInt(3)+"</td>");
				pw.print("<td>"+rs.getDouble(4)+"</td>");
				pw.print("</tr>");
				
			}	
			pw.print("</table>");
		} catch (SQLException e) {
		e.printStackTrace();
		}	
	}
}
