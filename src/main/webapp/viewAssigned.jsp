
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
<div class="container-fluid">
<br><br><br><br><hr>
<center><h2>Assigned Courses</h2></center><hr>
<hr>
	<center><input type="text" name="" id="myInput"
				onkeyup="searchFun()" placeholder="Id"></center>
	<hr>	
<table border="1" class="table" id="myTable">
<thead class="thead-dark">
<tr>
<th >Id</th>
<th >Student Id </th>
<th >Student name </th>
<th >Course Id</th>
<th >Course name </th>
<th > Starting Date</th>
<th > Ending Date</th>
<th  colspan="2">Action</th></tr>
</thead>  <c:forEach items="${listAssign}" var="post">
   <tr>
          <td>${post. getId()}</td>  
          <td>${post. getSt_id()}</td>
           <td>${post. getSt_name()}</td>
          <td>${post.getCo_id()}</td>
           <td>${post. getCo_name()}</td>   
           <td>${post.getStart_date()}</td> 
            <td>${post. getEnd_date()}</td>      
          <td><form action='Receipts' method="post">
<input  type='hidden' name='function' id='function' value='new' />
<input type='hidden' name='id' id='id' value='${post.getId()}'/>
<input type='submit' value='Get Receipt'  /></form>
</td>
   </tr>
  </c:forEach>
</table>

<script type="text/javascript">
const searchFun = () => {
	  let filter = document.getElementById('myInput').value.toUpperCase();
	  let myTable = document.getElementById('myTable');
	  let tr = myTable.getElementsByTagName('tr');

	  for (var i = 1; i < tr.length; i++) { // Start the loop at index 1
	    let td = tr[i].getElementsByTagName('td')[0];
	    if (td) {
	      let textValue = td.textContent || td.innerText;
	      if (textValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }

	  // Additional check for when filter is empty
	  if (filter.length == 0) {
	    for (var i = 0; i < tr.length; i++) {
	      tr[i].style.display = "";
	    }
	  }
	}

</script>

</div>
</body>

<c:import url="accfooter.jsp" />