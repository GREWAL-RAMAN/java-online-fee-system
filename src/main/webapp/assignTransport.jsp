<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ page  isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Transport Assignment Form</h2>

	<h2> Add </h2>
         	<c:if test="${ss=='y'}">
         	
		<form action="AssignTransport" method="post">
		<input type='hidden' name='function' id='function' value='new' />
		<input type='hidden' name='get' id='get' value='transport' />
         		<label>Student Name</label> 
         		 <select name="st_id" >
      <c:forEach items="${liststudent}" var="option">
        <option value="${option.getId()}">${option.getName()}</option>
      </c:forEach>
    </select>        		
<br>
	<button type="submit" >Get Transport</button>
	</form>
	<a href="Home.jsp"><button>Back</button></a>
</c:if>
   	<c:if test="${ss=='n'}">
   	<form action="AssignTransport" method="post">
		<input type='hidden' name='function' id='function' value='insert' />
		<input type='hidden' name='st_id' id='st_id' value='${liststudent.getId()}' />
		<input type='hidden' name='st_name' id='st_name' value='${liststudent.getName()}' />
         		<label>Student Name</label> 
         		 <select name="ss"  disabled="disabled" >
        <option value="${liststudent.getId()}">${liststudent.getName()}</option>
    </select>        		
	<br>
		<label>Distance in Kilo Meter</label> 
         		 <select name='tp_id' >
      <c:forEach items="${listtransport}" var="option">
        <option value="${option.getId()}/${option.getDistance()}" >${option.getDistance()}</option>
      </c:forEach>
    </select><br>
      <label for="date" >Enter Starting Date:</label>
        <input type="date" id="dateS" name="dateS"><br>
         <label for="date" >Enter Ending Date:</label>
        <input type="date" id="dateE" name="dateE"><br>
      
    	<button type="submit" >Save</button>
	</form>
	<a href="Home.jsp"><button>Back</button></a>
</c:if>

         


</body>
</html>