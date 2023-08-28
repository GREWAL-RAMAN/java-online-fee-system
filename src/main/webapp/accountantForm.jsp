
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

<c:if test="${work=='add'}">

	<form action="AdminSS" method="post">
		<input type='hidden' name='working' id='working' value='yes' /> <input
			type='hidden' name='function' id='function' value='insert' />
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea name="address"
						style="width: 300px; height: 100px;"></textarea></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="text" name="contact" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Accountant" /></td>
			</tr>
		</table>
	</form>


</c:if>
<c:if test="${work == 'edit'}">
<div class='container'>
	<h1>Edit Accountant Form</h1>
	<form action='AdminSS' method='post'>
	<input type='hidden' name='working' id='working' value='yes' /> <input
			type='hidden' name='function' id='function' value='update' />
		<table>
			<tr>
				<td><input type='hidden' name='id' value='${stud.getId()}' /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type='text' name='name' value='${stud.getName()}' /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type='email' name='email'
					value='${stud.getEmail()}' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='text' name='password'
					value='${stud.getPassword()}' /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea name='address'
						style='width: 300px; height: 100px;'>${stud.getAddress()}</textarea></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><input type='text' name='contact'
					value='${stud.getContact()}' /></td>
			</tr>
			<tr>
				<td colspan='2' align='center'><input type='submit'
					value='Update Accountant' class='btn btn-default' /></td>
			</tr>
		</table>
	</form>
	</div>


</c:if>


<c:import url="footer.jsp" />