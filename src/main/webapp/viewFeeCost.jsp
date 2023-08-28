<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
     <%@ page  isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='Fee_costs' method="post">	
			<input type="submit" value='pending' name="but">
			<input type="submit" value='complete' name="but">
			<input type="submit" value='left' name="but">
			<input type="submit" value='all' name="but">
	</form>
	<br><hr>
<table border="1">
<tr>
<th >Student ID</th>
<th >Student Course Id</th>
<th >Course Name</th>
<th >Cost of Course</th>
<th >Amount Payed</th>
<th >Amount Left</th>
<th >Status</th>
<c:forEach items="${listPayment}" var="post">
   <tr>
          <td>${post. getSt_id()}</td>
          <td>${post.getCo_id()}</td>        
          <td>${post. getCo_name()}</td>
          <td>${post. getCost()}</td>
          <td>${post.getPayed()}</td>
          <td>${post. getCost()-post.getPayed()}</td>
          <td>${post.getStatus()}</td>
          
   </tr>
  </c:forEach>
</table>

</body>
<c:import url="footer.jsp" />