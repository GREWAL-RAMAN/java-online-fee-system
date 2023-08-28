
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

	<input type='hidden' name='mySt_id' id='mySt_id' value='${st_id}' />
	<input type='hidden' name='mySt_course_id' id='mySt_course_id'
		value='${st_co_id}' />



	<div class="container text-center my-4">

		<h4>Student Name</h4><h3>${name} </h3>
		<h4>Course Name</h4><h3>${course} </h3>
		<h4>Payment Due</h4><h3>${due} INR</h3>
		<input id="payment_field" class="form-control my-5"
			placeholder="Enter Amount" max="${due}" min="0" type="number">

		<button onclick="paymentStart()" class="btn btn-success btn-block">CHECKOUT</button>

	</div>
</body>
<c:import url="footer.jsp" />