

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatepro
 */
@WebServlet("/updatepro")
public class updatepro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String cat=request.getParameter("cat");
		String cmp=request.getParameter("cmp");
		out.print("<form action=update1>");
		out.println(name);
		out.println("<input type=hidden name=name value="+name+">");
		out.println("<pre>");
		out.println("price<input type=number name=price value="+price+">");
		out.println("cat<input type=text name=cat value="+cat+">");
		out.println("cmp<input type=text name=cmp value="+cmp+">");
		out.println("</pre>");
		out.print("</form>");
	}

}
