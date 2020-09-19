

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
 * Servlet implementation class bookissue
 */
@WebServlet("/bookissue")
public class bookissue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookissue() {
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
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		  String qr="select*from book";
		  PreparedStatement ps=con.prepareStatement(qr);
		  
	  }catch(Exception e)
	  {
		  out.println(e);
	  }
	}

}
