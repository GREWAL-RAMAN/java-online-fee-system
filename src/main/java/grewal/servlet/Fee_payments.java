package grewal.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.fee_cost;
import grewal.bean.fee_payment;
import grewal.bean.st_course;
import grewal.bean.student;
import grewal.dao.fee_cost_dao;
import grewal.dao.fee_payment_dao;
import grewal.dao.st_course_dao;
import grewal.dao.student_dao;

/**
 * Servlet implementation class Fee_payments
 */
public class Fee_payments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fee_payments() {
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
		case "new_":
			showindex(request, response);
			break;
		case "insert_":
			AddNewPayment_(request, response);
			break;
		default:
			list_payment(request, response);
			break;
		}
	}

	private void showindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=Integer.parseInt(request.getParameter("id"));
		     String amount=request.getParameter("amount");
		     st_course myCourse=new st_course_dao().getst_course(id);
		     
		     request.setAttribute("due", amount);
		     request.setAttribute("st_co_id", id);
		     request.setAttribute("name", myCourse.getSt_name());
		     request.setAttribute("course", myCourse.getCo_name());
		     request.setAttribute("st_id",myCourse.getSt_id());
		     
		     RequestDispatcher dispatcher = request.getRequestDispatcher("index_acc.jsp");
		        dispatcher.forward(request, response);
		
	}

	private void list_payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  List<fee_payment> listFee =new fee_payment_dao().getAllFee_payment();
	        request.setAttribute("listPayment",listFee);
	        request.setAttribute("title","Payment List");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewFeePayment.jsp");
	        dispatcher.forward(request, response);		
		
	}

	private void AddNewPayment_(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p_id= Integer.parseInt(request.getParameter("id"));
		Double Amount= Double.parseDouble(request.getParameter("amount"));
		String method= "MANUAL";
		 st_course myACourse=new st_course_dao().getst_course(p_id);
		String details= request.getParameter("details");
		Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
		
        fee_payment myFee_payment =new fee_payment(myACourse.getSt_id(), p_id, Amount, method, formattedDate, details);
		new fee_payment_dao().addFeeCoursePayment(myFee_payment);
		
		 
	       student myStudent=new student_dao().getStudent(myACourse.getSt_id());
	      myFee_payment.setId(new fee_payment_dao().getMaxIdRecord().getId());
	      new fee_cost_dao().updateFeeCostStatus();
	       
	       request.setAttribute("st_course", myACourse);
	       request.setAttribute("student", myStudent);
	       request.setAttribute("total", myFee_payment.getAmount());
	       request.setAttribute("payment",myFee_payment);
	       
		
	       RequestDispatcher dispatcher = request.getRequestDispatcher("ReceiptAfter.jsp");
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
