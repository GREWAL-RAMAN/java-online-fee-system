
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
    // Redirect to login page if user is not logged in
    if(session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
      
        return;
    }

    // Redirect to login page if user is not an admin
    if(!"3".equals(session.getAttribute("idd"))) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Set cache headers
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<c:import url="navStudent.jsp" />

<div id="content" class="display nowrap" >
<h1>Receipt</h1>
	<table>
		<tr>
			<td>Student Id:</td>
			<td>${student.getId()}</td>
		</tr>
		<tr>
			<td>Student Name:</td>
			<td>${student.getName()}</td>
		</tr>
		<tr>
			<td>Course Id:</td>
			<td>${st_course.getId()}</td>
		</tr>
		<tr>
			<td>Course Name:</td>
			<td>${st_course.getCo_name()}</td>
		</tr>
		<tr>
			<td>Total Amount Paid:</td>
			<td>${total} INR</td>
		</tr>
	</table>
	<h2>Payment Details</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Payment ID</th>
				<th>Amount Paid</th>
				<th>Payment Method</th>
				<th>Date and Time</th>
				<th>Additional Info</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${payment.id}</td>
					<td>${payment.amount}</td>
					<td>${payment.method_name}</td>
					<td>${payment.date_time}</td>
					<td>${payment.account_details}</td>
				</tr>
		</tbody>
	</table>
</div>
<div class="container"> <img class="img-thumbnail" title="sign" src="resources/images/sign.jpeg"></div>

<button id="btn-print-this" class="btn btn-success btn-lg">Print this Page </button>


<script  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script  src="printThis.js"></script>
<script  src="custom.js"></script>
</body>
<c:import url="footer.jsp" />