
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
    // Redirect to login page if user is not logged in
    if(session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
      
        return;
    }

    // Redirect to login page if user is not an admin
    if(!"2".equals(session.getAttribute("idd"))) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Set cache headers
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<c:import url="navAdmin.jsp" />

<div class='container'>
	<h1>View Accountant</h1>

	<table class='table table-bordered table-striped'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>address</th>
			<th>contact</th>
			<th>Edit</th>
			<th>Delete</th>
		<tr>
			<c:forEach items="${listaccount}" var="post">
				<tr>
					<td>${post. getId()}</td>
					<td>${post. getName()}</td>
					<td>${post.getEmail()}</td>
					<td>${post.getPassword()}</td>
					<td>${post.getAddress()}</td>
					<td>${post.getContact()}</td>
					<td><form action='AdminSS' method="post">
							<input type='hidden' name='function' id='function' value='edit' />
							<input type='hidden' name='id' id='id' value='${post.getId()}' />
							<input class="btn btn-secondary btn-lg" type='submit'
								value='Edit' />
						</form>
						</td>
						<td>
						<form action='AdminSS' method="post">
							<input type='hidden' name='function' id='function' value='delete' />
							<input type='hidden' name='id' id='id' value='${post.getId()}' />
							<input class="btn" type='submit' value='Delete'
								onclick="if(!confirm('Sure ! You want to delete it.')) return false" />
						</form></td>
				</tr>
			</c:forEach>
	</table>

</div>
<c:import url="footer.jsp" />