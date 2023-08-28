
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
          <h2 class="footer-copyright text-center py-3">Student Form</h2>
	<c:if test="${stud != null}">
		<form action="Students" method="post">
		<input type='hidden' name='function' id='function' value='update' />
	</c:if>
	<c:if test="${stud == null}">
		<form  action="Students" method="post">
		<input type='hidden' name='function' id='function' value='insert' />
	</c:if>
	
	<h3>
		<c:if test="${stud != null}">
                                    Edit student
                                </c:if>
		<c:if test="${stud == null}">
                                    Add New student
                                </c:if>
	</h3>

	<c:if test="${stud != null}">
		<input type="hidden" name="id"  id ="id" value='${stud.id}'>
	</c:if>
	<div class="form-group">
         		<label>STUDENT NAME</label> <input class="form-control" type="text"
			value="${stud.name}" 
			name="name" required="required">
</div>
<div class="form-row">
<div class="col">
				<label>STUDENT EMAIL</label> <input class="form-control" type="email"
			value="${stud.email}"  
			name="email" required="required">
			</div>

<div class="col">
				<label>STUDENT CONTACT</label> <input class="form-control" type="number"
			value="${stud.contact}"  
			name="contact" required="required"  >
</div>
</div>
<div class="form-group">
				<label>STUDENT ADDRESS</label> <input class="form-control" type="text"
			value="${stud.address}" 
			name="address" required="required">
</div>
	<button class="btn btn-primary" type="submit" >Save</button>
	</form>
</div>

<br><br><br><br><br>
</body>

<c:import url="accfooter.jsp" />