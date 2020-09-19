

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
 * Servlet implementation class proceed
 */
@WebServlet("/proceed")
public class proceed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public proceed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String working=request.getParameter("working");
		String charge=request.getParameter("charge");
	  
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
		    String qr="insert into proceed values(?,?,?)";
		    PreparedStatement ps=con.prepareStatement(qr);
		    ps.setString(1,email );
		    ps.setString(2,working );
		    ps.setString(3,charge);
		   
		    int i=ps.executeUpdate();
		    if(i>0)
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("showbooking.jsp");
		    	rd.include(request, response);
		    	out.println("added");
		    }
		    else
		    {
		    	response.sendRedirect("proceed.html");
		    	out.print("Please add correct record");
		    }
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
