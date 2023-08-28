<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
     <%@ page  isELIgnored = "false" %>
  
 <c:import url="navbar.jsp" />

    <div class="container-fluid">
	<a href="Students"><button>View Students Info</button></a>
	<form action='Students'  class="form-control"> 
		<input type='hidden' name='function' id='function' value='new' /> <input
			type='submit' value='Add student' />
	</form>

	<br>
	<a href="AssignCourse"><button>View assigned courses</button></a>
	<form action='AssignCourse'>
		<input type='hidden' name='function' id='function' value='new' /> <input
			type='hidden' name='get' id='get' value='new' /> <input type='submit'
			value='Add Assign course' />
	</form>

	<br>
	<a href="Courses"><button>View Courses Info</button></a>
	<form action='Courses'>
		<input type='hidden' name='function' id='function' value='new' /> <input
			type='submit' value='Add course' />
	</form>
	<br>
	<a href="Assigned"><button>View Assigned Info</button></a>
	<form action='Assigned'>
		<input type='hidden' name='function' id='function' value='new' /> <input
			type='submit' value='Add new Assigned' />
	</form>

	<br>

	<a href="Fee_payments"><button>View Fee Payments Info</button></a>
	<form action='Fee_payments'>
		<input type='hidden' name='function' id='function' value='new' />
		<input type='hidden' name='get' id='get' value='new' /> <input
			type='submit' value='Add new Fee Payment' />
	</form>

	<br>
	<form action='Fee_costs'>
	<input type='hidden' name='but' id='but' value='all' />
	<input type='submit' value='View Fee Cost ' />
	</form>
	<form action='Fee_costs'>
		<input type='hidden' name='function' id='function' value='new' /> <input
			type='submit' value='Add new Fee cost ' />
	</form>

	<br>
	<a href="Receipts"><button>View Receipt Info</button></a>
	<form action='Receipts'>
		<input type='hidden' name='function' id='function' value='new' /> <input
			type='submit' value='Add new Receipt' />
	</form>
</div>


<c:import url="footer.jsp" />

