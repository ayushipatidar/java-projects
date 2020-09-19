

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addetails
 */
@WebServlet("/addetails")
public class addetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String collegename=request.getParameter("collegename");
		String ownername=request.getParameter("ownername");
		String details=request.getParameter("details");
	    String auditoriumname=request.getParameter("auditoriumname");
	    String area=request.getParameter("area");
	    String city=request.getParameter("city");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String facalities=request.getParameter("facalities");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
		    String qr="insert into addetails values(?,?,?,?,?,?,?,?,?)";
		    PreparedStatement ps=con.prepareStatement(qr);
		    ps.setString(1,collegename );
		    ps.setString(2,ownername );
		    ps.setString(3, details);
		    ps.setString(4, auditoriumname);
		    ps.setString(5, area);
		    ps.setString(6, city);
		    ps.setString(7, contact);
		    ps.setString(8,  address);
		    ps.setString(9, facalities);
		    int i=ps.executeUpdate();
		    if(i>0)
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("showdetails.jsp");
		    	rd.include(request, response);
		    	out.println("Added");
		    }
		    else
		    {
		    	response.sendRedirect("addetails.html");
		    	out.print("Record not added");
		    }
		}catch(Exception e)
		{
			out.println(e);
		}
	}
}
