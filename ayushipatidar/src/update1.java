

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
 * Servlet implementation class update1
 */
@WebServlet("/update1")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name =request.getParameter("name");
		String price=request.getParameter("price");
		String cat=request.getParameter("cat");
		String cmp=request.getParameter("cmp");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product1","root","root");
			String qr=" update addproduct1 set price=?, cat=?,cmp=? where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(4, name);
			ps.setString(1, price);
			ps.setString(2, cat);
			ps.setString(3, cmp);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("show1");
				rd.include(request, response);
				out.print(name+"updated");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("show1");
				rd.include(request, response);
				out.println("not updated");
			}
			con.close();
		}catch(Exception e)
		{
			out.print(e);
		}
	}

}
