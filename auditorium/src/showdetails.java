

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
 * Servlet implementation class showdetails
 */
@WebServlet("/showdetails")
public class showdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showdetails() {
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
		 String qr="select*from addetails";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(qr);
	     out.print("<table align=center border=1px>");	 
	     
	    
		 
		 if(rs.next())
		 {
			 do
			 {
		 String collegename=rs.getString("collegename");
		 String ownername=rs.getString("ownername");
		 String details=rs.getString("details");
		 String auditoriumname=rs.getString("auditoriumname");
		 String area=rs.getString("area");
		 String city=rs.getString("city");
		 String contact=rs.getString("contact");
		 String address=rs.getString("address");
		 String facalities=rs.getString("facalities");
		 
		 out.print("<tr>");
		 out.println("<td>");
		 out.println(collegename);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(ownername);
		 out.println("</td>");
		 out.println("<td>");
		 out.println(details);
		 out.println("</td>");
		 out.print("<td>");
		out.println(auditoriumname);
		out.println("</td>");
		 out.println("<td>");
		out.println(area);
    	 out.println("</td>");
	     out.println("<td>");
		out.println(city);
	    out.println("</td>");
	    out.println("<td>");
		out.println(contact);
	    out.println("</td>");	 
	    out.println("<td>");
		out.println(address);
	    out.println("</td>");
	    out.println("<td>");
		out.println(facalities);
	    out.println("</td>");
	    out.println("<td>");
		 out.println("<a href=delete?collegename="+collegename+">delete</a>");
		 out.println("</td>");
		 out.println("<td>");
		 out.println("<a href=update.jsp?collegename="+collegename+"&ownername="+ownername+"&details="+details+"&auditoriumname="+auditoriumname+"&area="+area+"&city="+city+"&contact="+contact+"&address="+address+"&facalities="+facalities+">update</a>");
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


