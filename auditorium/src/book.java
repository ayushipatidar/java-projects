

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class book
 */
@WebServlet("/book")
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html");
		try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
		 String qr="select collegename,auditoriumname,ownername from addetails";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(qr);
	     out.print("<table align=center border=1px>");	 
		 out.println("<th>collegename</th><th>auditoriumname</th><th>ownername</th>");
		 if(rs.next())
		 {
			 do
			 {
		 String collegename=rs.getString("collegename");
		 String auditoriumname=rs.getString("auditoriumname");
		 String ownername=rs.getString("ownername");
		 out.print("<tr>");
		 out.println("<td>");
		 out.println(collegename);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(auditoriumname);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(ownername);
		 out.println("</td>");
	    out.println("<td>");
		 out.println("<a href=booking.html?collegename="+collegename+"&auditoriumname="+auditoriumname+"&ownername="+ownername+">Book</a>");
		 out.println("</td>");
		 out.print("</tr>");
	
			 }while(rs.next());
		 }
		 out.println("</table>");
		 con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
