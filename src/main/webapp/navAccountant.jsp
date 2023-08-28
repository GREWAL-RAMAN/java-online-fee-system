
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/2.3.6/css/buttons.dataTables.min.css">
<title>${title}</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
	
</script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
	 <script>
        window.onpopstate = function(event) {
            location.reload(true);
        }
    </script>
</head>
<body class="bg-light">

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" href="accountantHome.jsp">Fee Management
					System</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarScroll"
					aria-controls="navbarScroll" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarScroll">
					<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
						style="-bs-scroll-height: 100px;">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="accountantHome.jsp">Home</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarScrollingDropdown" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Student </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarScrollingDropdown">
								<li><a class="dropdown-item" href="Students?function=view">View
										Students</a></li>
								<li><a class="dropdown-item" href="Students?function=new">Add
										Student</a></li>
							</ul></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarScrollingDropdown" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Course </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarScrollingDropdown">
								<li><a class="dropdown-item" href="Courses?function=view">View
										Courses</a></li>
								<li><a class="dropdown-item" href="Courses?function=new">Add
										Course</a></li>
								<li><a class="dropdown-item"
									href="AssignCourse?function=new&&get=new">Assign Course</a></li>
								<li><a class="dropdown-item"
									href="AssignCourse?function=view">View Assigned Courses</a></li>
							</ul></li>

						<li class="nav-item"><a class="nav-link"
							href="Fee_payments?function=view">Fee Payments</a></li>

						<li class="nav-item"><a class="nav-link" href="adminLogout">Logout</a>
						</li>

					</ul>
				</div>
			</div>
		</nav>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>