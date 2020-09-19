

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
 * Servlet implementation class enrollment
 */
@WebServlet("/enrollment")
public class enrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			String qr="select*from student where entrollment=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				do{
		String enrollment=rs.getString("enrollment");
		out.print(enrollment);
				}while(rs.next());
				RequestDispatcher rd=request.getRequestDispatcher("bookissue");
				rd.include(request, response);
			}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("enrollment.html");
					rd.include(request, response);
					out.println("invalid enrollment");
				}
			
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
