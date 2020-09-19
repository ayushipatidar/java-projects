

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
 * Servlet implementation class booked
 */
@WebServlet("/booked")
public class booked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
			String qr="select * from booking where date=? and time=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, date);
			ps.setString(2, time);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
				rd.include(request, response);
				out.print("already booked");
			}else{
			
	String qr1="insert into booking values(?,?,?,?)";
	PreparedStatement ps1=con.prepareStatement(qr1);
	ps1.setString(1,id);
	ps1.setString(2,date);
	ps1.setString(3, time);
	ps1.setString(4, time);
	int i=ps1.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("ending.jsp");
	}
	else
	{
	out.println("booked");
			}
			}
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
