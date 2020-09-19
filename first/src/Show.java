

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
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsixty","root","root");
			String qr="select * from product";
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(qr);
			out.println("<h1 align=center>Product LIst</h1>");
			out.println("<table align=center border=1px>");
			out.println("<th>NAME</th><th>PRICE</th><th>CAT</th><th>CMP</th>");
			if(rs.next())
			{
				do
				{
					String name=rs.getString("name");
					String price=rs.getString("price");
					String cat=rs.getString("cat");
					String cmp=rs.getString("cmp");
					out.println("<tr>");
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
					out.println("<a href=Delete?name="+name+">Delete</a>");
					out.println("</td>");
					out.println("<td>");
					out.println("<a href=UpdatePro?name="+name+"&price="+price+"&cat="+cat+"&cmp="+cmp+">UPDATE</a>");
					out.println("</td>");
					out.println("</tr>");
				}while(rs.next());
				out.println("</table>");
			}else
			{
				out.println("no records found");
			}
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}













