package grewal.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONObject;

import com.razorpay.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Servlet implementation class OrderCreation
 */
public class OrderCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderCreation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("happenfnf");
	    BufferedReader reader = request.getReader();
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }
	    String json = sb.toString();

	    Gson gson = new Gson();
	    Map<String, Object> data = gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());

	    String amount = (String) data.get("amount");
	    int amt=Integer.parseInt(amount);
	    String info = (String) data.get("info");
	    
	    RazorpayClient client=null;
	    String orderS=null;
	    try { 
	        client=new RazorpayClient("rzp_test_tN00KemE4lMnax","zNzVUmlwNGROWe4FFj3clZef");
	        JSONObject options = new JSONObject();
	        options.put("amount",amt*100); // amount in the smallest currency unit
	        options.put("currency", "INR"); 
	        options.put("receipt", "order_rcptid_rg10_11");
	        options.put("payment_capture", true);
	        
	        Order order=client.Orders.create(options); 
	        orderS=  order.toString();
	        System.out.println(order);
	    } 
	    catch (RazorpayException e) { // Handle Exception
	        System.out.println(e.getMessage());
	    }       
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(orderS);
	}

}
