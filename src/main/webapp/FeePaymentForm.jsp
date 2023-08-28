
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
    // Redirect to login page if user is not logged in
    if(session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
      
        return;
    }

    // Redirect to login page if user is not an admin
    if(!"1".equals(session.getAttribute("idd"))) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Set cache headers
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<c:import url="navAccountant.jsp" />

	<c:if test="${check=='a'}">
		<form action="Fee_payments" method="post">
			<input type='hidden' name='function' id='function' value='new' /> 
				<input type='hidden' name='get' id='get' value='fee_pay' /> <label>Payment
				Method</label> <select name="method_id">
				<option value="a">Manual</option>
				<option value="b">Online</option>
			</select> <br> <select name="st_id">
				<c:forEach items="${liststudent}" var="option">
        <option value="${option.getId()}">${option.getName()}</option>
      </c:forEach>
			</select> <br>
			<button type="submit">Get Form</button>
		</form>
</c:if>
	<c:if test="${check=='b'}">
		<c:if test="${method=='b'}">
		<form action="Fee_payments" method="post">
		<input type='hidden' name='function' id='function' value='insert'/> 
		<input type='hidden' name='id_of' id='id_of' value='${liststudent.getId()}' />
		<input type='hidden' name='method' id='method' value='manual'/>
		 <label>${liststudent.getName()}</label>
			Course <select name="fee_cost_id">
				<c:forEach items="${listFeeCost}" var="optin" >
					<option value="${optin.getCo_id()}">${optin.getCo_name()}(payment left- INR ${optin.getCost()-optin.getPayed()})</option>
					<br>
				</c:forEach>
			</select><br>
		Amount	<input type="number" required="required" id="amount" name="amount" /><br>
	
		Details <input type="text" required="required" id="details" name="details" ><br>
		     <input type="submit" value="submit" />
		</form>
		</c:if>
		<c:if test="${method='b'}">

		</c:if>


	</c:if>
</body>
<c:import url="accfooter.jsp" />