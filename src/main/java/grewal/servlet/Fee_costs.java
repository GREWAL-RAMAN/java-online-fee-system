package grewal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grewal.bean.fee_cost;
import grewal.dao.fee_cost_dao;

/**
 * Servlet implementation class Fee_costs
 */
public class Fee_costs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Fee_costs() {
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

		default:
			list_payment(request, response);
			break;
		}
	}

	private void list_payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionString=	request.getParameter("but");
		new fee_cost_dao().updateFeeCostStatus();
		if(actionString.equals("all"))
		{
			List<fee_cost> listFee =new fee_cost_dao().getAllfee_cost();
			request.setAttribute("listPayment",listFee);
		}else {
			List<fee_cost> listFee =new fee_cost_dao().getFeeCostByStatus(request.getParameter("but"));
			request.setAttribute("listPayment",listFee);
		}
		  request.setAttribute("title","View Fee Cost");

	
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewFeeCost.jsp");
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
