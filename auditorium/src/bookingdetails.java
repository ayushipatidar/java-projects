

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
 * Servlet implementation class bookingdetails
 */
@WebServlet("/bookingdetails")
public class bookingdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookingdetails() {
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
		 String qr="select*from booking";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(qr);
	     out.print("<table align=center border=1px>");	 
	     
	    
		 
		 if(rs.next())
		 {
			 do
			 {
		 String id=rs.getString("id");
		 String date=rs.getString("date");
		 String time=rs.getString("time");
		 
		 out.print("<tr>");
		 out.println("<td>");
		 out.println(id);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(date);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(time);
		 out.println("</td>");
		 out.println("<td>");
		 out.println("<a href=proceed.html?id="+id+"&=date"+date+"&time="+time+">Proceed</a>");
		 out.println("</td>");
		 out.println("</tr>");
		
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
