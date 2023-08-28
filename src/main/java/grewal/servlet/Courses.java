package grewal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.course;
import grewal.dao.course_dao;


/**
 * Servlet implementation class Courses
 */
public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=" "; 
		if(request.getParameter("function")!=null) {
			action= request.getParameter("function");}

		switch (action) {
		case "new":
			showNewForm(request, response);
			break;
		case "insert":
			insertUser(request, response);
			break;
		case "edit":
			showEditForm(request, response);
			break;
		case "update":
			updateUser(request, response);
			break;
		default:
			listUser(request, response);
			break;
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<course> listCourse =new course_dao().getAllcourse();
		request.setAttribute("listCourse",listCourse);
		request.setAttribute("title","Course List");
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewCourse.jsp");
		dispatcher.forward(request, response);

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		String cost_perDay = request.getParameter("cost_perDay");  
		course my=new course(name, cost_perDay);

		new course_dao().updatecourse(my, id);
		response.sendRedirect("Courses");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		course my=new course_dao().getcourse( id);
		request.setAttribute("title","Edit Course Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Course_form.jsp");
		request.setAttribute("cou", my);
		dispatcher.forward(request, response);
	}



	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String cost_perDay = request.getParameter("cost_perDay");

		course my=new course(name, cost_perDay);
		new course_dao().addCourse(my);
		response.sendRedirect("Courses");

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setAttribute("title","Add Course Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Course_form.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
