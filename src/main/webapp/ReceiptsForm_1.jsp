
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

<form action="Receiptt" method="post">
<input type='hidden' name='function' id='function' value="insert" />
	<input type='hidden' name='st_id' id='st_id' value="${st_co.getSt_id()}" />
	
	<input type='hidden' name='co_id' id='co_id' value='${st_co.getCo_id()}' />
	<input type='hidden' name='st_co_id' id='st_co_id'
		value='${st_co.getId()}' /> Student Name: <label>${st_co.getSt_name()}</label><input type="text"
		disabled="disabled" value="${st_co.getSt_name()}" id="st_name"><br>
	Course Name:<input type="text" disabled="disabled"
		value="${st_co.getCo_name()}" id="co_name"><br>
	<table id="example" class="table" style="width: 100%">
		<thead class="thead-dark">
			<tr class="head">
				<th>Id</th>
				<th>Student ID</th>
				<th>Student Course Id</th>
				<th>Amount</th>
				<th>Payment Method</th>
				<th>Date Time</th>
				<th>Additional Info</th>
				<th>To Be Bill</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fee_pa}" var="post">
				<tr>
					<td>${post. getId()}</td>
					<td>${post. getSt_id()}</td>
					<td>${post.getP_id()}</td>
					<td>${post. getAmount()}</td>
					<td>${post. getMethod_name()}</td>
					<td>${post.getDate_time()}</td>
					<td>${post.getAccount_details()}</td>
					<td><input type="checkbox" name="Payment"
						value="${post.getId()}/${post.getSt_id()}/${post.getP_id()}/${post.getAmount()}/${post.getMethod_name()}/${post.getDate_time()}/${post.getAccount_details()}"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<input type="submit" value="Enter" name="Bill">
</form>


</body>
<c:import url="footer.jsp" />