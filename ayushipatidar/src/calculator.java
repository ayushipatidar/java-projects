

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculator
 */
@WebServlet("/calculator")
public class calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String n1=request.getParameter("n1");
		String n2=request.getParameter("n2");
		int a=Integer.parseInt(n1);
		int b=Integer.parseInt(n2);
		String option=request.getParameter("option");
		if(option.equals("+"))
		{
			out.print("addition is"+a+b);
		}
		else if(option.equals("-"))
			{
			out.print("substraction is "+(a-b));
		}		

		else if(option.equals("*"))
		
			{
				out.print("multiplication is "+(a*b));
			}	
		else
		{
			out.print("division is "+(a%b));
		}	
		}
	
	
	
	}


