

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Expires" content="0">
<script type="text/javascript" src="resources/script.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<style>
.bttnStyle {
	background-color: lightblue;
	border-radius: 8.5 mm;
	border: 1px solid transparent;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript" src="resources/script.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	

<link rel='stylesheet' href='style.css' />
</head>
<body>


	<nav class="navbar navbar-expand-lg fixed-top navbar-inverse $black">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<a class="navbar-brand" href="studentHome.jsp">Fee Management</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse "
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="studentHome.jsp">Home</a></li>
					<li><a href="MoreFunction?function=selfStudent">My Info </a>
					<li><a href="adminLogout">Logout</a></li>

				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>