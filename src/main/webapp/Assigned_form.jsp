
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

Assign form.

	<c:if test="${cou != null}">
		<form action="Assigned" method="post">
		<input type='hidden' name='function' id='function' value='update' />
	</c:if>
	<c:if test="${cou == null}">
		<form action="Assigned" method="post">
		<input type='hidden' name='function' id='function' value='insert' />
	</c:if>
	
	<h2>
		<c:if test="${cou != null}">
                                    Edit course
                                </c:if>
		<c:if test="${cou == null}">
                                    Add New course
                                </c:if>
	</h2>

	<c:if test="${cou != null}">
		<input type="hidden" name="id"  id ="id" value='${cou.getId()}'>
	</c:if>
         		<label>Course Name</label> <input type="text"
			value="${cou.getName()}" 
			name="name" required="required">
<br>
				<label>Course Duration</label> <input type="text"
			value= "${cou.getDurationPermonth()}"   
			name="durationPermonth" required="required">
<br>
				<label>Course Cost per month</label> <input type="text"
			value=" ${cou.getCost_perMonth()}"
			name="cost_perMonth" required="required">

<br>
				<label>Course Status</label> <input type="text"
			value="${cou.getStatus()}"  
			name="status" required="required">
<br>	
	<button type="submit" >Save</button>
	</form>


</body>
<c:import url="accfooter.jsp" />