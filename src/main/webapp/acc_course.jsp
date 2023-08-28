
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
    
    <center><h1>Course Info</h1></center>
    <table>
    <tr><td>Id                        :</td><td><b>${stud.getId()}</b></td></tr>
    <tr><td>Student Id              :</td><td><b>${stud.getSt_id()}</b></td></tr>
    <tr><td>Student Name         :</td><td><b>${stud.getSt_name()}</b></td></tr>
    <tr><td>Course Id               :</td><td><b>${stud.getCo_id()}</b></td></tr>
    <tr><td>Course Name          :</td><td><b>${stud.getCo_name()}</b></td></tr>
    <tr><td>Starting Date          :</td><td><b>${stud.getStart_date()}</b></td></tr>
    <tr><td>Ending  Date          :</td><td><b>${stud.getEnd_date()}</b></td></tr>
    <tr><td>Total Cost (INR)       :</td><td><b>${user.getCost()}</b></td></tr>
    <tr><td>Amount Payed (INR) :</td><td><b>${user.getPayed()}</b></td></tr>
    <tr><td>Amount Due (INR)   :</td><td><b>${user.getCost()-user.getPayed()}</b></td></tr>
    <tr><td>Status                   :</td><td><b>${user.getStatus()}</b></td></tr>
    <tr><td><form action ="CourseReceipt_1.jsp" method="post">
   <% session.setAttribute("title", "Insitute Receipt"); %>
  
    <input type='hidden' name='st_id' id='st_id' value='${stud.getSt_id()}' />
    <input type='hidden' name='st_name' id='st_name' value='${stud.getSt_name()}' />
    <input type='hidden' name='co_id' id='co_id' value='${stud.getCo_id()}' />
    <input type='hidden' name='co_name' id='co_name' value='${stud.getCo_name()}' />
    <input type='hidden' name='start' id='start' value='${stud.getStart_date()}' />
    <input type='hidden' name='end' id='end' value='${stud.getEnd_date()}' />
    <input type='hidden' name='total' id='total' value='${user.getCost()}' />
    <input type='hidden' name='payed' id='payed' value='${user.getPayed()}' />
    <input type='hidden' name='due' id='due' value='${user.getCost()-user.getPayed()}' />
        <input type='hidden' name='status' id='status' value='${user.getStatus()}' />   
    <input type="submit" value="Get Course's Receipt">
    </form> </td><td>
   <form action='Receipts' method="post">
<input  type='hidden' name='function' id='function' value='new' />
<input type='hidden' name='id' id='id' value='${stud.getId()}'/>
<input type='submit' value='Get Receipt'  /></form></td>
    <td>
    <c:if test="${due!='0'}">
     <form action="Fee_payments" method="post">
     <input type="hidden" id="function" name="function" value="new_">
     <input type="hidden" id ="id"  name="id" value="${stud.getId()}">
     <input type="hidden" id ="amount" name="amount" value="${due}">
     <input type="submit" value="Start Payment">
     </form>
 
    
    </c:if>   </td>
    </tr></table>
   <center> <h2> Course's Payments</h2></center>
    <table border="1"  class="table">
    <thead class="thead-dark">
<tr class="head">
<th > Id</th>
<th >Amount</th>
<th >Date </th>
<th > Method</th>
<th >Additional Details</th>
</thead>
  <c:forEach items="${listAssign}" var="post">
   <tr>
          <td>${post. getId()}</td>  
          <td>${post.getAmount()}</td>
           <td>${post. getDate_time()}</td>   
           <td>${post.getMethod_name()}</td> 
            <td>${post. getAccount_details()}</td>      
   </tr>
  </c:forEach>
</table>
 <form action='MoreFunction' method="post">
						<input type='hidden' name='function' id='function' value='student' />
						<input type='hidden' name='id' id='id' value='${stud.getSt_id()}' />
						<input class="btn btn-secondary btn-lg"  type='submit' value='Back'
							 />
					</form>
</body>
<c:import url="accfooter.jsp" />