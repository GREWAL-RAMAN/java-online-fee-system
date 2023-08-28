
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

<div class="container">
	<br><br><br>
          <h2 class="footer-copyright text-center py-3">Course Form</h2>

	<c:if test="${cou != null}">
		<form action="Courses" method="post">
		<input type='hidden' name='function' id='function' value='update' />
	</c:if>
	<c:if test="${cou == null}">
		<form action="Courses" method="post">
		<input type='hidden' name='function' id='function' value='insert' />
	</c:if>
	
	<h3>
		<c:if test="${cou != null}">
                                    Edit course
                                </c:if>
		<c:if test="${cou == null}">
                                    Add New course
                                </c:if>
	</h3>

	<c:if test="${cou != null}">
		<input type="hidden" name="id"  id ="id" value='${cou.getId()}'>
	</c:if><div class="form-group">
         		<label>Course Name</label> <input class="form-control" type="text"
			value="${cou.getName()}" 
			name="name" required="required">
			</div>
	<div class="form-group">
				<label>Course Cost per Day</label> <input class="form-control" type="text"
			value=" ${cou.getCost_perDay()}"
			name="cost_perDay" required="required">
</div>
	<button class="btn btn-primary" type="submit" >Save</button>
	</form></div>
</body>

<c:import url="accfooter.jsp" />