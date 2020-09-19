

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
 * Servlet implementation class addpro1
 */
@WebServlet("/addpro1")
public class addpro1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addpro1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String cat=request.getParameter("cat");
		String cmp=request.getParameter("cmp");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product1","root","root");
			String qr="insert into addproduct1 values(?,?,?,?)";
		     PreparedStatement ps=con.prepareStatement(qr);
		     ps.setString(1,name);
		     ps.setString(2, price);
		     ps.setString(3, cat);
		     ps.setString(4, cmp);
		     int i=ps.executeUpdate();
		     RequestDispatcher rd=request.getRequestDispatcher("addpro1.html");
		     if(i>0)
		     {
		    	 rd.include(request, response);
		    	 out.println("added");
		     }
		     else
		     {
		    	 rd.include(request,response);
		    	 out.print("not added");
		     }
		     con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}
