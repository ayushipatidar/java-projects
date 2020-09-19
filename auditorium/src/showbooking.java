

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
 * Servlet implementation class showbooking
 */
@WebServlet("/showbooking")
public class showbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showbooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html");
		try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
		 String qr="select*from proceed";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(qr);
	     out.print("<table align=center border=1px>");	 
		 out.println("<th>Email</th><th>Working</th><th>Charge</th>");
		 if(rs.next())
		 {
			 do
			 {
		 String email=rs.getString("email");
		 String working=rs.getString("working");
		 String charge=rs.getString("charge");
		 out.print("<tr>");
		 out.println("<td>");
		 out.println(email);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(working);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(charge);
		 out.println("</td>");
		 out.print("</tr>");
		 out.println("</table>");
			 }while(rs.next());
		 }
		 con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
