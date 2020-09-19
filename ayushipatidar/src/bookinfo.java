

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
 * Servlet implementation class bookinfo
 */
@WebServlet("/bookinfo")
public class bookinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//String enrollment=request.getParameter("enrollment");
		String bookname=request.getParameter("bookname");
		String author=request.getParameter("author");
		//String issuedate=request.getParameter("issuedate");
		//String bookreturn=request.getParameter("bookreturn");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			String qr="insert into book values(?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			//ps.setString(1, enrollment);
			ps.setString(1, bookname);
			ps.setString(2, author);
			int i=ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("bookissue");
				rd.include(request, response);
				out.println("issue");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("bookissue");
				rd.include(request, response);
				out.println("already issue");
			}
		}catch(Exception e)
		{
		out.print(e);	
		}
		
	}

}
