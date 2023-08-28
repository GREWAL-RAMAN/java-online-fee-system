package grewal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.st_course;
import grewal.dao.st_course_dao;

/**
 * Servlet implementation class Recptt
 */
public class Recptt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recptt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     int id=Integer.parseInt(request.getParameter("id"));
	     int st_id=Integer.parseInt(request.getParameter("st_id"));
	     String amount=request.getParameter("amount");
	     st_course myCourse=new st_course_dao().getst_course(id);
	 
	     
	     request.setAttribute("due", amount);
	     request.setAttribute("st_co_id", id);
	     request.setAttribute("name", myCourse.getSt_name());
	     request.setAttribute("course", myCourse.getCo_name());
	     request.setAttribute("st_id",st_id);
	     
	     RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
	     
	}

}
