<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='style_2.css' />
</head>
<body>
<<div class="navbar">
  <a href="#home">Home</a>
  <a href="#news">News</a>
  <div class="dropdown">
  <button class="dropbtn" onclick="myFunction()">Dropdown
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-content" id="myDropdown">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
  </div> 
</div>
<script type="text/javascript">
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}
</script>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="accountantHome.jsp">FeeReport</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a>Student </a>
						<ul>
							<li><a href="Students?function=view">View Student</a></li>
							<li><a href="Students?function=new">Add Student</a></li>
						</ul></li>
				
					<li><a>Course </a>
						<ul>
							<li><a href="Courses?function=view">View Course</a></li>
							<li><a href="Courses?function=new">Add Course</a></li>
						</ul></li>
					<li>
					<li><a href="DueFee">Due Fee</a></li>
					<li><a href="SearchStudentForm">Search Student</a></li>
					<li><a href="adminLogout">Logout</a></li>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

</body>
</html>