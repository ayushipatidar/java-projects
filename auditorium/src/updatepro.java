

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
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html");
		String collegename=request.getParameter("collegename");
		String ownername=request.getParameter("ownername");
		String details=request.getParameter("details");
		String auditoriumname=request.getParameter("auditoriumname");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String facalities=request.getParameter("facalities");
		out.print("<form action=update>");
		out.println(collegename);
		out.println("<input type=hidden name=collegename value="+collegename+">");
		out.println("<pre>");
		out.println("ownername<input type=text name=ownername value="+ownername+">");
		out.println("details<input type=text name=details value="+details+">");
		out.println("auditoriumname<input type=text name=auditoriumname value="+auditoriumname+">");
		out.println("city<input type=text name=city value="+city+">");
		out.println("area<input type=text name=area value="+area+">");
		out.println("contact<input type=number name=contact value="+contact+">");
		out.println("address<input type=text name=address value="+address+">");
		out.println("facalities<input type=text name=facalities value="+facalities+">");
		out.println("</pre>");
		out.print("</form>");
	}

}
