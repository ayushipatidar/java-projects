

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class auditype
 */
@WebServlet("/auditype")
public class auditype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auditype() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String auditoriumname=request.getParameter("auditoriumname");
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
			String qr="select * from addetails where auditoriumname=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, auditoriumname);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("book.jsp");
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("auditype.html");
				rd.include(request, response);
				out.println("not found");
			}
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
