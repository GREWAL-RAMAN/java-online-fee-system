package grewal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grewal.dao.accountantDao;

/**
 * Servlet implementation class AccountantLogin
 */
public class AccountantLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountantLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.sendRedirect("accountantHome.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean status=new accountantDao().validateAccountant(email, password);
		if(status){
			 
			 HttpSession session = request.getSession();
				
				session.setAttribute("username", email);
				session.setAttribute("idd","1");
				session.setAttribute("password", password);
				session.setAttribute("working", "yes");
			    session.setAttribute("title", "Accountant Panel"); 
		      response.sendRedirect("accountantHome.jsp");
		}else{
			 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		        request.setAttribute("error","yes");
		        dispatcher.forward(request, response);
			
		}
		
	}

}
