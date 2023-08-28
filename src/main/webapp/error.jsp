<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<button id="payButton" onclick="CreateOrderID()" class="bttnStyle">PAY</button>
</center>

<button id="rzp-button1">Pay with Razorpay</button>
<script >
var xhttp=new XMLHttpRequest();
var RazorpayOrderId;
function CreationOrderID() {
    xhttp.open("GET","http://localhost:8081/FEES_MANAGE/OrderCreation",false);
    xhttp.send();
    RazorpayOrderId=xhttp.responseText;
    OpenCheckout();
	
}
</script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
var options = {
    "key": "rzp_test_tN00KemE4lMnax", // Enter the Key ID generated from the Dashboard
    "amount": ${amount}, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "100",
    "description": "Test Transaction",
    "image": "https://example.com/your_logo",
    "order_id": RazorpayOrderId, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "handler": function (response){
        alert(response.razorpay_payment_id);
        alert(response.razorpay_order_id);
        alert(response.razorpay_signature)
    },
    "prefill": {
        "name": "mtra",
        "email": "gaurav.kumar@example.com",
        "contact": "9000090000"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
};
var rzp1 = new Razorpay(options);
rzp1.on('payment.failed', function (response){
        alert(response.error.code);
        alert(response.error.description);
        alert(response.error.source);
        alert(response.error.step);
        alert(response.error.reason);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id);
});
document.getElementById('rzp-button1').onclick = function(e){
    rzp1.open();
    e.preventDefault();
}
</script>

</body>
</html>