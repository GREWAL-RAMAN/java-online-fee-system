package grewal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.accountantBean;
import grewal.dao.accountantDao;

/**
 * Servlet implementation class AdminSS
 */
public class AdminSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSS() {
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
			    case "view":
			       viewAccountant(request, response);
			    	break;
			    default:
			      response.sendRedirect("adminHome.jsp");
			       break;
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action=" "; 
		  if(request.getParameter("function")!=null) {
		    action= request.getParameter("function");}
		 
	        switch (action) {
			    case "insert":
			        insertAccountant(request, response);
			        break;
			    case "delete":
			        deleteAccountant(request, response);
			        break;
			    case "edit":
			        showEditForm(request, response);
			        break;
			    case "update":
			        updateAccountant(request, response);
			        break;
			       default:
			     viewAccountant(request, response);				 
			    	break;
			}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	     accountantBean myStudent=new accountantDao().getaccountantBean(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("accountantForm.jsp");
	        request.setAttribute("stud", myStudent);
	        request.setAttribute("work","edit");
			 request.setAttribute("title","Edit Accountant");
	        dispatcher.forward(request, response);
		
	}

	private void updateAccountant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		accountantBean bean=new accountantBean(name, email, password, address, contact);
		
		new accountantDao().updateaccountantBean(bean, id);
		
		   response.sendRedirect("AdminSS?function=view");
		
		
	}

	private void viewAccountant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<accountantBean> listStudents =new accountantDao().getAllaccountantBean();
        request.setAttribute("listaccount",listStudents);
        request.setAttribute("title","View Accountants");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_accountant.jsp");
        dispatcher.forward(request, response);
		
	}

	private void deleteAccountant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		 new accountantDao().deleteaccountantBean(id);
		 
		   response.sendRedirect("AdminSS?function=view");
	}

	private void insertAccountant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		accountantBean bean=new accountantBean(name, email, password, address, contact);
		new accountantDao().addaccountantBean(bean);
	   response.sendRedirect("AdminSS?function=view");
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("accountantForm.jsp");
		  request.setAttribute("title","Add Accountant");

		 request.setAttribute("work","add");
	        dispatcher.forward(request, response);
		
	}

}
