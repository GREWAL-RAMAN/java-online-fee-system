
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
    <center><h1>Student Info</h1></center>
    <table>
    <tr><td>Student Id           :</td><td><b>${stud.getId()}</b></td></tr>
    <tr><td>Student Name      :</td><td><b>${stud.getName()}</b></td></tr>
    <tr><td>Student Email       :</td><td><b>${stud.getEmail()}</b></td></tr>
    <tr><td>Student Contact    :</td><td><b>${stud.getContact()}</b></td></tr>
    <tr><td>Student Address    :</td><td><b>${stud.getAddress()}</b></td></tr>
    <tr><td>Student Username  :</td><td><b>${user.getUsername()}</b></td></tr>
    <tr><td>Student Password   :</td><td><b>${user.getPassword()}</b></td></tr>
    </table>
   <center> <h2> Student's Courses</h2></center>
    <table border="1" class="table">
    <thead class="thead-dark">
<tr class="head">
<th > Id</th>
<th >Course Id</th>
<th >Course name </th>
<th > Starting Date</th>
<th > Ending Date</th>
<th  colspan="2">Action</th></tr>
</thead>
  <c:forEach items="${listAssign}" var="post">
   <tr>
          <td>${post. getId()}</td>  
          <td>${post.getCo_id()}</td>
           <td>${post. getCo_name()}</td>   
           <td>${post.getStart_date()}</td> 
            <td>${post. getEnd_date()}</td>      
          <td><form action='MoreFunction' method="post">
<input  type='hidden' name='function' id='function' value='selfcourse' />
<input type='hidden' name='id' id='id' value='${post.getId()}'/>
<input type='submit' value='More'  /></form>
</td>
   </tr>
  </c:forEach>
</table>
    
   
</body>
<c:import url="footer.jsp" />