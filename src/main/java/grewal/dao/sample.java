package grewal.dao;


import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

public class sample {
	private void doget() {
		/*
		 * RazorpayClient client=null; String orderId=null; try { client=new
		 * RazorpayClient("rzp_test_tN00KemE4lMnax","zNzVUmlwNGROWe4FFj3clZef");
		 * JSONObject options = new JSONObject(); options.put("amount",
		 * request.getParameter("amount")); // amount in the smallest currency unit
		 * options.put("currency", "INR"); options.put("receipt", "order_rcptid_11");
		 * options.put("payment_capture", true);
		 * 
		 * Order order=client.Orders.create(options); orderId=order.get("id");
		 * 
		 * } catch (RazorpayException e) { // Handle Exception
		 * System.out.println(e.getMessage()); } response.getWriter().append(orderId);
		 */
	}
void DoPost() {
	/*
	 * RazorpayClient client=null; try { client=new
	 * RazorpayClient("rzp_test_tN00KemE4lMnax","zNzVUmlwNGROWe4FFj3clZef");
	 * JSONObject options = new JSONObject(); options.put("razorpay_payment_id",
	 * request.getParameter("razorpay_payment_id"));
	 * options.put("razorpay_order_id", request.getParameter("razorpay_order_id"));
	 * options.put("razorpay_signature",
	 * request.getParameter("razorpay_signature")); boolean
	 * SigRes=Utils.verifyPaymentSignature(options,"secret"); if(SigRes) {
	 * response.getWriter().append("Payment successful and Signature Verified"); }
	 * else {
	 * response.getWriter().append("Payment failed and Signature not Verified"); }
	 * 
	 * 
	 * }catch (RazorpayException e) { e.printStackTrace();
	 */
	
}
}
