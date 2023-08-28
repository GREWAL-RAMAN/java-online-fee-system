package grewal.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import grewal.bean.fee_payment;
import grewal.bean.st_course;
import grewal.bean.student;
import grewal.dao.fee_cost_dao;
import grewal.dao.fee_payment_dao;
import grewal.dao.st_course_dao;
import grewal.dao.student_dao;

/**
 * Servlet implementation class PaymentSave
 */
public class PaymentSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSave() {
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
		   BufferedReader reader = request.getReader();
		    StringBuilder sb = new StringBuilder();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		    String json = sb.toString();

		    Gson gson = new Gson();
		    Map<String, Object> data = gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());


		    String amount = (String) data.get("Yamount");
		    double amt=Double.parseDouble(amount);
		    String st_iddString=(String)data.get("st_id");
		    int student_id = Integer.parseInt(st_iddString);
		    String st_coiddString=(String)data.get("st_co_id");
		    int student_course_id = Integer.parseInt(st_coiddString);
		    String Paymentid="pay_id: "+ data.get("payment_id");
		    String method= "online payment";
		    Date currentDate = new Date();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String formattedDate = dateFormat.format(currentDate);
		    
		    fee_payment myFee_payment =new fee_payment(student_id, student_course_id,amt, method, formattedDate, Paymentid);
		    new fee_payment_dao().addFeeCoursePayment(myFee_payment);
		    
		    new fee_cost_dao().updateFeeCostStatus();
		    
		    response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().append("{\"status\": \"success\"}");
		      	      
		   
		}

}
