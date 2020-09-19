

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
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		//String price=request.getParameter("price");
		//String cat=request.getParameter("cat");
		//String cmp=request.getParameter("cmp");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
			String qr="delete from addproduct where name=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, name);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("adminhome.html");
			}
			else
			{
				out.println("record not updated");
			}
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
