package grewal.servlet;

import java.io.IOException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.course;
import grewal.bean.fee_cost;
import grewal.bean.st_course;
import grewal.bean.student;

import grewal.dao.fee_cost_dao;
import grewal.dao.st_course_dao;
import grewal.dao.student_dao;

/**
 * Servlet implementation class AssignCourse
 */
public class AssignCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignCourse() {
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
			    default:
			        listAssigned(request, response);
			        break;
			}
	}
	private void listAssigned(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  List<st_course> listAssign =new st_course_dao().getAllst_course();
	        request.setAttribute("listAssign",listAssign);
	        request.setAttribute("title","Assigned Course List");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewAssigned.jsp");
	        dispatcher.forward(request, response);		
	}



	private void insertNewAssigned(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ret=request.getParameter("co_id");
		String[] ter=ret.split("/");
		
		
		Integer st_id= Integer.parseInt(request.getParameter("st_id"));
		String st_name=request.getParameter("st_name");
		Integer co_id= Integer.parseInt(ter[0]);
		String co_name=ter[1];  
		String dateS = request.getParameter("dateS");
		String dateE = request.getParameter("dateE");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateSS = String.valueOf(LocalDate.parse(dateS, formatter)); // parse as LocalDate
		String dateEE = String.valueOf(LocalDate.parse(dateE, formatter)); 
		st_course myCourse=new st_course(st_id,st_name,co_id,co_name,dateSS,dateEE);
	double totalCost=new st_course_dao().addStCourseAndCalculateCost(myCourse);

	  fee_cost myFee_cost=new fee_cost((int )st_id, new st_course_dao().getMaxIdRecord().getId(),co_name, totalCost, 0, "pending");
	   new fee_cost_dao().addfee_cost(myFee_cost);
	        response.sendRedirect("AssignCourse");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("get").equals("new")){
			 List<student> listStudents =new student_dao().getAllStudent();
			
		        request.setAttribute("liststudent",listStudents);
		        request.setAttribute("ss","y");
		        request.setAttribute("title","Assign Course Form");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("assignCourse.jsp");
		        dispatcher.forward(request, response);
			 
		 }
		 else
		{
			Integer id= Integer.parseInt(request.getParameter("st_id"));
			  student myStudent=new student_dao().getStudent(id);
			 List<course> listCourse =new st_course_dao().getUnassignedCourses(id);
			
			 request.setAttribute("liststudent",myStudent);
	        request.setAttribute("listcourse",listCourse);
	        request.setAttribute("ss","n");
			  request.setAttribute("title","Assign Course");

		 RequestDispatcher dispatcher = request.getRequestDispatcher("assignCourse.jsp");
	        dispatcher.forward(request, response);
		}}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
