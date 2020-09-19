

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show1
 */
@WebServlet("/show1")
public class show1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	//response.setContentType("text/html");
	try{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product1","root","root");
	 String qr="select*from addproduct1";
	 Statement st=con.createStatement();
	 ResultSet rs=st.executeQuery(qr);
	 out.println("<a align=center>product list </a>");
     out.print("<table align=center border=1px>");	 
	 out.println("<th>name</th><th>price</th>cat</th><th>cmp</th>");
	 if(rs.next())
	 {
		 do
		 {
	 String name=rs.getString("name");
	 String price=rs.getString("price");
	 String cat=rs.getString("cat");
	 String cmp=rs.getString("cmp");
	 out.print("<tr>");
	 out.println("<td>");
	 out.println(name);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(price);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(cat);
	 out.println("</td>");
	 out.println("<td>");
	 out.println(cmp);
	 out.println("</td>");
	 out.println("<td>");
	 out.println("<a href=delete1?name="+name+">delete</a>");
	 out.println("</td>");
	 out.println("<td>");
	 out.println("<a href=update1?name="+name+"&price="+price+"&cat="+cat+"&cmp="+cmp+">update</a>");
	 out.println("</td>");
	 out.println("</table>");
		 }while(rs.next());
	 }
	 con.close();
	}catch(Exception e)
	{
		out.println(e);
	}
	}

}
