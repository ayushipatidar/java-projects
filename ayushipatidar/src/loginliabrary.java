

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginliabrary
 */
@WebServlet("/loginliabrary")
public class loginliabrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginliabrary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		if(email.equals("abc@gmail.com")&&pwd.equals("12345"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("student.html");
			rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("loginliabrary.html");
			rd.include(request, response);
			out.println("invalid email and password");
		}
	}

}
