package grewal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grewal.bean.fee_cost;
import grewal.bean.fee_payment;
import grewal.bean.st_course;
import grewal.bean.student;
import grewal.bean.student_login;
import grewal.dao.fee_cost_dao;
import grewal.dao.fee_payment_dao;
import grewal.dao.st_course_dao;
import grewal.dao.student_dao;
import grewal.dao.student_login_Dao;

/**
 * Servlet implementation class MoreFunction
 */
public class MoreFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoreFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ShowSelfStudent(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action=" "; 
		  if(request.getParameter("function")!=null) {
		    action= request.getParameter("function");}
		 
	        switch (action) {
			    case "student":
			        ShowMoreStudent(request, response);
			        break;
			    case "course":
			        ShowMoreCourse(request, response);
			        break;
			    case "selfStudent":
			        ShowSelfStudent(request, response);
			        break;
			    case "selfcourse":
			        ShowSelfCourse(request, response);
			        break; 

			    default:
			        response.sendRedirect("accountantHome.jsp");
			        break;
			}
	}

	private void ShowSelfCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=Integer.parseInt(request.getParameter("id"));
		  st_course course=new st_course_dao().getst_course(id);
		  fee_cost fCost=new fee_cost_dao().getFeeCostByCourseId(id);
		  List<fee_payment> myFee_payments=new fee_payment_dao().getFeePaymentsByPId(id);
		  int due=(int) fCost.getCost()- (int)fCost.getPayed();
		  request.setAttribute("stud", course);
		   request.setAttribute("user", fCost);
		   request.setAttribute("due", due);
		   request.setAttribute("listAssign", myFee_payments);
		   request.setAttribute("title",course.getSt_name()+"'s Courses");

		   RequestDispatcher dispatcher = request.getRequestDispatcher("acc_selfCourse.jsp");
	       dispatcher.forward(request, response);
	}

	private void ShowSelfStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();     
		String username=(String) session.getAttribute("username");
		
			System.out.println(username);
		 student_login myLogin=new student_login_Dao().getStudentByUsername(username);
		 int id= myLogin.getId();
		 
		  student myStudent=new student_dao().getStudent(id);
		   List<st_course>myCourses=new st_course_dao().getCoursesByStudentId(id);
		   
		   request.setAttribute("stud", myStudent);
		   request.setAttribute("user", myLogin);
		   request.setAttribute("listAssign", myCourses);
		   request.setAttribute("title",myStudent.getName()+"'s Info");

	  
		   RequestDispatcher dispatcher = request.getRequestDispatcher("acc_selfStudent.jsp");
	       dispatcher.forward(request, response);
		
	}

	private void ShowMoreCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=Integer.parseInt(request.getParameter("id"));
		  st_course course=new st_course_dao().getst_course(id);
		  fee_cost fCost=new fee_cost_dao().getFeeCostByCourseId(id);
		  List<fee_payment> myFee_payments=new fee_payment_dao().getFeePaymentsByPId(id);
		  int due=(int) fCost.getCost()- (int)fCost.getPayed();
		  request.setAttribute("stud", course);
		   request.setAttribute("user", fCost);
		   request.setAttribute("due", due);
		   request.setAttribute("listAssign", myFee_payments);
		   request.setAttribute("title",course.getSt_name()+"'s Courses");

		   RequestDispatcher dispatcher = request.getRequestDispatcher("acc_course.jsp");
	       dispatcher.forward(request, response);
		
	}

	private void ShowMoreStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int id=Integer.parseInt(request.getParameter("id"));
	   student myStudent=new student_dao().getStudent(id);
	   List<st_course>myCourses=new st_course_dao().getCoursesByStudentId(id);
	   student_login myLogin=new student_login_Dao().getstudent_login(id);
	   
	   request.setAttribute("stud", myStudent);
	   request.setAttribute("user", myLogin);
	   request.setAttribute("listAssign", myCourses);
	   request.setAttribute("title",myStudent.getName()+"'s Info");

  
	   RequestDispatcher dispatcher = request.getRequestDispatcher("acc_student.jsp");
       dispatcher.forward(request, response);
	
	    
		
	}

}
