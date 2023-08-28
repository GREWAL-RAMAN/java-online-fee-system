
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
<br><br><br><br><hr><div class="container">
	<center class="container"><input type="text" name="" id="myInput"
				onkeyup="searchFun()" placeholder="STUDENT ID"></center>
	<hr>		
	<table class="table" id="myTable">

		<thead class="thead-dark">
			<tr class="head">
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Contact</th>
				<th scope="col">Edit</th>
				<th scope="col">More</th>
			</tr>
		</thead>
		<c:forEach items="${liststudent}" var="post">
			<tr>
				<td>${post. getId()}</td>
				<td>${post. getName()}</td>
				<td>${post.getEmail()}</td>
				<td>${post.getAddress()}</td>
				<td>${post.getContact()}</td>
			
				<td><form action='Students' method="post">
						<input type='hidden' name='function' id='function' value='edit' />
						<input type='hidden' name='id' id='id' value='${post.getId()}' />
						<input class="btn btn-secondary btn-lg" type='submit' value='*' />
					</form></td><td>
					<form action='MoreFunction' method="post">
						<input type='hidden' name='function' id='function' value='student' />
						<input type='hidden' name='id' id='id' value='${post.getId()}' />
						<input class="btn btn-secondary btn-lg"  type='submit' value='*'
							 />
					</form></td>
			</tr>
		</c:forEach>
	</table>
</div>
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

</body>
<br><br><br><br>
<c:import url="accfooter.jsp" />
