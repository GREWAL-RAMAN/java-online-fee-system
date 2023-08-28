

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html></html>
<head>
<meta charset="ISO-8859-1">
<title>Fee Report</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<link rel="stylesheet" href="style.css">

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->


			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1"></div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>Admin Login Form</h2>
				<c:if test="${Error != null}">
					<h4 style="color: red">Invalid username or password entered</h4>
				</c:if>
				<form action="AdminLogin" method="post">
					<table>
						<tr>
							<td>Email:</td>
							<td><input type="email" name="email" required /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" required /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								class="btn btn-default" value="Login" /></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="col-md-6 ">
				<h2>Accountant Login Form</h2>
				<c:if test="${error != null}">
					<h4 style="color: red;">Invalid User Name or password entered</h4>
				</c:if>
				<form action="AccountantLogin" method="post">
					<table>
						<tr>
							<td>Email:</td>
							<td><input type="email" name="email" required /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" required /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								class="btn btn-default" value="Login" /></td>
						</tr>
					</table>
				</form>
				<script>
					function clearFields() {
						document.getElementById("email").value = "";
						document.getElementById("password").value = "";
					}
				</script>
			</div>
		</div>
			<div class="col-md-6">
				<h2>Student Login Form</h2>
				<c:if test="${errorr != null}">
					<h4 style="color: red;">Invalid User Name or password entered</h4>
				</c:if>
				<form action="StudentLogin" method="post">
					<table>
						<tr>
							<td>Email:</td>
							<td><input type="email" name="email" required /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" required /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								class="btn btn-default" value="Login" /></td>
						</tr>
					</table>
				</form>
				<script>
					function clearFields() {
						document.getElementById("email").value = "";
						document.getElementById("password").value = "";
					}
				</script>
			</div>
		</div>


	
	<c:import url="footer.jsp"></c:import>