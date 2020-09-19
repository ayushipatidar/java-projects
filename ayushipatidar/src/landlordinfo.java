

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class landlordinfo
 */
@WebServlet("/landlordinfo")
public class landlordinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public landlordinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String propertype=request.getParameter("propertype");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/landlord","root","root");
			String qr="insert into property values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,contact);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,area);
			ps.setString(7,propertype);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				out.print("record not added");
			}
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
