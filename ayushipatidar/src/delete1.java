

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
 * Servlet implementation class delete1
 */
@WebServlet("/delete1")
public class delete1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product1","root","root");
			String qr="delete from addproduct1 where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, name);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("show1");
				rd.include(request, response);
				out.println("deleted");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("show1");
				rd.include(request, response);
				out.print("not deleted");
			}
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
