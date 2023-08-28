package grewal.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.student;
import grewal.bean.student_login;
import grewal.dao.student_dao;
import grewal.dao.student_login_Dao;

/**
 * Servlet implementation class Students
 */
public class Students extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Students() {
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
			    case "assigned":
			        getAssignedUser(request, response);
			        break;
			    default:
			        listUser(request, response);
			        break;
			}
	}

	private void getAssignedUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  List<student> listStudents =new student_dao().getStudentsNotInCourse();
	        request.setAttribute("liststudent",listStudents);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent.jsp");
	        dispatcher.forward(request, response);
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    List<student> listStudents =new student_dao().getAllStudent();
	        request.setAttribute("liststudent",listStudents);
	        request.setAttribute("title","Student List");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewStudent.jsp");
	        dispatcher.forward(request, response);
		
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String contact = request.getParameter("contact");
	        String address = request.getParameter("address");
            student_login myLogin=new student_login(id,name+email,name+contact); 
	        student my = new student(name, email, contact, address);
	        System.out.println(my);
	        new student_dao().updateStudent(my, id);
	        new student_login_Dao().updatestudent_login(myLogin, id);
	        System.out.println(my);
	        response.sendRedirect("Students");
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
	     student myStudent=new student_dao().getStudent(id);
	     request.setAttribute("title","Edit Student Form");
	     RequestDispatcher dispatcher = request.getRequestDispatcher("student_form.jsp");
	        request.setAttribute("stud", myStudent);
	        dispatcher.forward(request, response);
		
	}

	

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String contact = request.getParameter("contact");
	        String address = request.getParameter("address");
	        student myStudent =new student(name, email, contact, address);
	        System.out.println(myStudent);
	      	        new student_dao().addStudent(myStudent);
	      	      System.out.println(myStudent);
	      	  student myStudent2=new student_dao().getMaxIdRecord();    
	      	  student_login myLogin=new student_login(myStudent2.getId(), name+email,name+contact);    
              new student_login_Dao().addstudent_login(myLogin);
	        response.sendRedirect("Students");
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setAttribute("title","Add Student Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("student_form.jsp");
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
