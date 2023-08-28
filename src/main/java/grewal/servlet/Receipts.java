package grewal.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.fee_payment;
import grewal.bean.st_course;
import grewal.bean.student;
import grewal.dao.fee_payment_dao;
import grewal.dao.st_course_dao;
import grewal.dao.student_dao;

/**
 * Servlet implementation class Receipts
 */
public class Receipts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receipts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String action=" "; 
		  if(request.getParameter("function")!=null) {
		    action= request.getParameter("function");}
		 
	        switch (action) {
			    case "new":
			        showNewForm(request, response);
			        break;
			    case "new_1":
			        showNewForm_(request, response);
			        break;
			    case "insert":
			        insertReceipt(request, response);
			        break;
			    case "delete":
			        deleteReceipt(request, response);
			        break;
			    case "assigned":
			        getAssignedReceipt(request, response);
			        break;
			    default:
			        response.sendRedirect("accountantHome.jsp");
			        break;
			}
	}

	

	private void getAssignedReceipt(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteReceipt(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       if(request.getParameterValues("Payment")==null)
	       {
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("accountantHome.jsp");
	            dispatcher.forward(request, response);
	       }
	       else {
			
		       int st_id=Integer.parseInt(request.getParameter("st_id"));
		       int co_id=Integer.parseInt(request.getParameter("co_id"));
		       int st_co_id=Integer.parseInt(request.getParameter("st_co_id"));
		       String[] payments = request.getParameterValues("Payment");
		       List<fee_payment> feePayments = new ArrayList<>();

		       for (String payment : payments) {
		           String[] fields = payment.split("/");
		           int id = Integer.parseInt(fields[0]);
		           int stId = Integer.parseInt(fields[1]);
		           int pId = Integer.parseInt(fields[2]);
		           double amount = Double.parseDouble(fields[3]);
		           String methodName = fields[4];
		           String dateTime = fields[5];
		           String accountDetails = fields[6];

		           fee_payment fp = new fee_payment();
		           fp.setId(id);
		           fp.setSt_id(stId);
		           fp.setP_id(pId);
		           fp.setAmount(amount);
		           fp.setMethod_name(methodName);
		           fp.setDate_time(dateTime);
		           fp.setAccount_details(accountDetails);

		           feePayments.add(fp);
		       }
		       double totalAmount = 0.0;

		       for (fee_payment fp : feePayments) {
		       totalAmount += fp.getAmount();
		       }
		       st_course myACourse=new st_course_dao().getst_course(st_co_id);
		       student myStudent=new student_dao().getStudent(st_id);
		      
		       
		       request.setAttribute("st_course", myACourse);
		       request.setAttribute("student", myStudent);
		       request.setAttribute("total", totalAmount);
		       request.setAttribute("fee_pa",feePayments);
			   request.setAttribute("title",myStudent.getName()+"'s Receipt");
			 
		       
		       

				RequestDispatcher dispatcher = request.getRequestDispatcher("Viewreceipt.jsp");
		        dispatcher.forward(request, response);

	       }
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		st_course myCourse=new st_course_dao().getst_course(id);
		
		List<fee_payment> myFee_payments=new fee_payment_dao().getFeePaymentsByPId(id);
		
		request.setAttribute("st_co", myCourse);
		request.setAttribute("fee_pa", myFee_payments);
	     request.setAttribute("title","Reciept Form");
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("ReceiptsForm.jsp");
        dispatcher.forward(request, response);
	
		
		
	}
	private void showNewForm_(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		st_course myCourse=new st_course_dao().getst_course(id);
		
		List<fee_payment> myFee_payments=new fee_payment_dao().getFeePaymentsByPId(id);
		
		request.setAttribute("st_co", myCourse);
		request.setAttribute("fee_pa", myFee_payments);
	     request.setAttribute("title","Reciept Form");
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("ReceiptsForm_1.jsp");
        dispatcher.forward(request, response);
	
		
		
	}

}
