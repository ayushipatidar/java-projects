

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
 * Servlet implementation class userdetails
 */
@WebServlet("/userdetails")
public class userdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//response.setContentType("text/css");
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
			 String qr="select*from user";
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery(qr);
		     out.print("<table align=center border=1px>");	 
		     if(rs.next())
		     {
		    	 do{
		     
		String fname=rs.getString("fname");
		String lname=rs.getString	 ("lname");
		String contact=rs.getString("contact");
		String email=rs.getString("email");
		String pwd=rs.getString("pwd");
		String address=rs.getString("address");
		String city=rs.getString("city");
		String state=rs.getString("state");
		 out.print("<tr>");
		 out.println("<td>");
		 out.println(fname);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(lname);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(contact);
		 out.println("</td>");
		 out.print("<td>");
		out.println(email);
		out.println("</td>");
		 out.println("<td>");
		out.println(pwd);
    	 out.println("</td>");
	     out.println("<td>");
		out.println(address);
	    out.println("</td>");
	    out.println("<td>");
	    out.println(city);
	    out.println("</td>");
	    out.println("<td>");
	    out.println(state);
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