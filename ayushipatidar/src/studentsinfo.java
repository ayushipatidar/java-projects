

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
 * Servlet implementation class studentsinfo
 */
@WebServlet("/studentsinfo")
public class studentsinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentsinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String studentname=request.getParameter("studentname");
		String enrollment=request.getParameter("enrollment");
		//String bookname=request.getParameter("bookname");
		//String author=request.getParameter("author");
		//String issuedate=request.getParameter("issuedate");
		//String returndate=request.getParameter("returndate");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		String qr="insert into student values(?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1, studentname);
		ps.setString(2, enrollment);
		int i=ps.executeUpdate();
		if(i>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("studentshow");
			rd.include(request, response);
			out.println(" record added");
		}	
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("studentinfo.hmtl");
			rd.include(request, response);
			out.print("please enter correct enrollment number");
		}
		con.close();
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
