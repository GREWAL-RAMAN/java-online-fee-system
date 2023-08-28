
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
          <h2 class="footer-copyright text-center py-3">Course Assignment Form</h2>

     
	<h3> Add </h3>
         	<c:if test="${ss=='y'}">
         	
		<form action="AssignCourse" method="post">
		<input type='hidden' name='function' id='function' value='new' />
		<input type='hidden' name='get' id='get' value='course' />
		<div class="form-group">
         		<label>Student Name</label> 
         		 <select class="form-control" name="st_id" >
      <c:forEach items="${liststudent}" var="option">
        <option value="${option.getId()}">${option.getId()} :- ${option.getName()}</option>
      </c:forEach>
    </select>        		
    </div>
<br>
<div class="form-row">
<div class="col">
	<button class="btn btn-primary" type="submit" >Get Courses</button>
	</div>
	</form>
	<div class="col">
	<a  href="Home.jsp"><button class="btn btn-dark">Back</button></a>
	</div>
	</div>
</c:if>
   	<c:if test="${ss=='n'}">
   	<form action="AssignCourse" method="post">
		<input type='hidden' name='function' id='function' value='insert' />
		<input type='hidden' name='st_id' id='st_id' value='${liststudent.getId()}' />
		
		<input type='hidden' name='st_name' id='st_name' value='${liststudent.getName()}' />
        <div class="form-group">
         		<label>Student Name</label> 
         		 <select class="from-control" name="ss"  disabled="disabled" >
        <option value="${liststudent.getId()}">${liststudent.getName()}</option>
    </select>        		
    </div>
	
	<div class="form-group">
		<label>Course Name</label> 
         		 <select class="form-control" name="co_id" >
      <c:forEach items="${listcourse}" var="option">
        <option value="${option.getId()}/${option.getName()}" >${option.getName()}</option>
      </c:forEach>
    </select>
    </div>
    <div class="form-group">
       <label for="date" >Enter Starting Date:</label>
        <input class="form-control" type="date" id="dateS" name="dateS">
        </div>
        <div class="form-group">
         <label for="date" >Enter Ending Date:</label>
        <input class="form-control" type="date" id="dateE" name="dateE">
        </div>
        <div class="form-row">
<div class="col">
    	<button class="btn btn-primary" type="submit" >Save</button>
	</div></form>
	<div class="col">
	<a href="Home.jsp"><button class="btn btn-dark">Back</button></a>
	</div>
	</div>
</c:if>
</div>

<br><br><br><br><br>

<script>
  // Get the input elements for start and end dates
  var startDateInput = document.getElementById("dateS");
  var endDateInput = document.getElementById("dateE");

  // Add an event listener to the end date input
  endDateInput.addEventListener("input", function() {
    // Get the values of the start and end dates
    var startDate = new Date(startDateInput.value);
    var endDate = new Date(endDateInput.value);

    // Compare the dates and show an error if end date is before start date
    if (endDate < startDate) {
      endDateInput.setCustomValidity("End date cannot be before start date");
    } else {
      endDateInput.setCustomValidity("");
    }
  });
</script>
         

</body>
<c:import url="accfooter.jsp" />