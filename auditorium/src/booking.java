

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
 * Servlet implementation class booking
 */
@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
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
		String purpose=request.getParameter("purpose");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auditorium","root","root");
		    String qr="insert into booking values(?,?,?,?)";
		    PreparedStatement ps=con.prepareStatement(qr);
		    ps.setString(1,id );
		    ps.setString(2,date );
		    ps.setString(3, time);
		    ps.setString(4, purpose);
		    int i=ps.executeUpdate();
		    if(i>0)
		    {
		    	RequestDispatcher rd=request.getRequestDispatcher("booked");
		    	rd.include(request, response);
		    }
		    else
		    {
		    
		    	out.print("not confirmed");
		    }
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
