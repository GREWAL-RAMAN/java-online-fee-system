package grewal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email.equals("admin@feereport.com") && password.equals("admin123")) {
			
			HttpSession session = request.getSession();
		
			session.setAttribute("username", email);
			session.setAttribute("idd", "2");
			session.setAttribute("password", password);
			session.setAttribute("working", "yes");
		    session.setAttribute("title", "Admin Panel"); 

		
           response.sendRedirect("adminHome.jsp");
		} else {

			request.setAttribute("Error", "yes");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			 dispatcher.forward(request, response);
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
          response.sendRedirect("adminHome.jsp");
	}

	
}
