

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
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//response.setContentType("text/css");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
			String qr="insert into user values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, contact);
			ps.setString(4, email);
			ps.setString(5, pwd);
			ps.setString(6, address);
			ps.setString(7, city);
			ps.setString(8, state);
			int i=ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
				rd.include(request, response);
				out.println("registration successfully");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
				out.print("not registerd");
			}
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
