package grewal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.assign;
import grewal.dao.assign_dao;

/**
 * Servlet implementation class Assigned
 */
public class Assigned extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assigned() {
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
			        insertNewAssigned(request, response);
			        break;
			    case "delete":
			        deleteAssigned(request, response);
			        break;
			    case "edit":
			        showEditForm(request, response);
			        break;
			    case "update":
			        updateAssigned(request, response);
			        break;
			    default:
			        listAssigned(request, response);
			        break;
			}

	}

	private void listAssigned(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  List<assign> listAssign =new assign_dao().getAllassign();;
	        request.setAttribute("listAssign",listAssign);
			  request.setAttribute("title","View Assigned");

	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAssigned.jsp");
	        dispatcher.forward(request, response);		
	}

	private void updateAssigned(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		  int id = Integer.parseInt(request.getParameter("id"));
//	        String name = request.getParameter("");
//	        String duration = request.getParameter("");
//	        
//	        String status = request.getParameter("status");
//	        String cost_perMonth = request.getParameter("cost_perMonth");
//	       
//	        course my=new course(name, duration, totalCost, cost_perMonth, status);
//	        System.out.println(my);
//	new course_dao().updateAssign(my, id);
//	        System.out.println(my);
//	        response.sendRedirect("Courses");
//		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	     assign my=new assign_dao().getassign(id);
		  request.setAttribute("title","Edit Assign Form");

	        RequestDispatcher dispatcher = request.getRequestDispatcher("Assigned_form.jsp");
	        request.setAttribute("cou", my);
	        dispatcher.forward(request, response);
		
	}

	private void deleteAssigned(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  int id = Integer.parseInt(request.getParameter("id"));
	        new assign_dao().deleteassign(id);
	        response.sendRedirect("Assigned");

		
	}

	private void insertNewAssigned(HttpServletRequest request, HttpServletResponse response) throws IOException {
                 
		
		       
//	        System.out.println(my);
//	      	        new course_dao().addCourse(my);
//	      	      System.out.println(my);

	        response.sendRedirect("Assigned");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setAttribute("title","Assign Form");

		RequestDispatcher dispatcher = request.getRequestDispatcher("Assigned_form.jsp");
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
