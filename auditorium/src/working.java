

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
 * Servlet implementation class working
 */
@WebServlet("/working")
public class working extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public working() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String work=request.getParameter("ownername");
		String charge=request.getParameter("charge");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
		    String qr="insert into working values(?,?,?)";
		    PreparedStatement ps=con.prepareStatement(qr);
		    ps.setString(1,email );
		    ps.setString(2,work );
		    ps.setString(3, charge);
		    int i=ps.executeUpdate();
		    if(i>0)
		    {
		    	//RequestDispatcher rd=request.getRequestDispatcher("worked");
		    	out.println("confimed");
		    }
		    else
		    {
		    	response.sendRedirect("user.html");
		    	out.print("Record not added");
		    }
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
