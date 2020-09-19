

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
 * Servlet implementation class show
 */
@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     PrintWriter out=response.getWriter();
    try {
    	Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
    String qr="select*from addproduct";
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery(qr);
    		out.print("<h1 align=center>product list</h1>");
    		out.print("<table align=center border=1px>");
            out.print("<th>name</th><th>price</th><th>cat</th><th>cmp</th>");
            if(rs.next())
            {
            do{
    	String name=rs.getString("name");
    	String price=rs.getString("price");
    	String cat=rs.getString("cat");
    	String cmp=rs.getString("cmp");
    	out.print("<tr>");
    	out.print("<td>");
    	out.print(name);
    	out.print("</td>");
    	out.print("<td>");
    	out.print(price);
    	out.print("</td>");
    	out.print("<td>");
    	out.print(cat);
    	out.print("</td>");
    	out.print("<td>");
    	out.print(cmp);
    	out.print("</td>");
    	
    	out.print("</tr>");
            }
            while(rs.next());
            
    	out.print("</table>");
            }
            else
            {
            	out.print("no record found");
            }
            con.close();
     }catch(Exception e)
    {
    	 out.println(e);
    }
     
	}

}
