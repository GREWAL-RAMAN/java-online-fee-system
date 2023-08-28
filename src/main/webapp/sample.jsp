        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
        <c:import url="navbar.jsp" />
          <div class="col-lg-5 content">
            <h2>Professional Photographer from New York</h2>
            <p class="fst-italic py-3">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
              magna aliqua.
            </p>
            <div class="row">
              <div class="col-lg-6">
                <ul>
                  <li><i class="bi bi-chevron-right"></i> <strong>Birthday:</strong> <span>1 May 1995</span></li>
                  <li><i class="bi bi-chevron-right"></i> <strong>Website:</strong> <span>www.example.com</span></li>
                  <li><i class="bi bi-chevron-right"></i> <strong>Phone:</strong> <span>+123 456 7890</span></li>
                  <li><i class="bi bi-chevron-right"></i> <strong>City:</strong> <span>New York, USA</span></li>
                </ul>
              </div>
              <div class="col-lg-6">
                <ul>
                  <li><i class="bi bi-chevron-right"></i> <strong>Age:</strong> <span>30</span></li>
                  <li><i class="bi bi-chevron-right"></i> <strong>Degree:</strong> <span>Master</span></li>
                  <li><i class="bi bi-chevron-right"></i> <strong>PhEmailone:</strong> <span>email@example.com</span></li>
                  <li><i class="bi bi-chevron-right"></i> <strong>Freelance:</strong> <span>Available</span></li>
                </ul>
              </div>
            </div>
            <p class="py-3">	<a href="Students"><button>View Students Info</button></a>
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
	<center><h1>Course Info</h1></center>
    <table>
    <tr><td>Id                        :</td><td><b>${stud.getId()}</b></td></tr>
    <tr><td>Student Id              :</td><td><b>${stud.getSt_id()}</b></td></tr>
    <tr><td>Student Name         :</td><td><b>${stud.getSt_name()}</b></td></tr>
    <tr><td>Course Id               :</td><td><b>${stud.getCo_id()}</b></td></tr>
    <tr><td>Course Name          :</td><td><b>${stud.getCo_name()}</b></td></tr>
    <tr><td>Starting Date          :</td><td><b>${stud.getStart_date()}</b></td></tr>
    <tr><td>Ending  Date          :</td><td><b>${stud.getEnd_date()}</b></td></tr>
    <tr><td>Total Cost (INR)       :</td><td><b>${user.getCost()}</b></td></tr>
    <tr><td>Amount Payed (INR) :</td><td><b>${user.getPayed()}</b></td></tr>
    <tr><td>Amount Due (INR)   :</td><td><b>${user.getCost()-user.getPayed()}</b></td></tr>
    <tr><td>Status                   :</td><td><b>${user.getStatus()}</b></td></tr>
    </table>
   <center> <h2> Course's Payments</h2></center>
    <table border="1" class="table">
    <thead class="thead-dark">
<tr class="head">
<th > Id</th>
<th >Amount</th>
<th >Date </th>
<th > Method</th>
<th >Additional Details</th>
</thead>
  <c:forEach items="${listAssign}" var="post">
   <tr>
          <td>${post. getId()}</td>  
          <td>${post.getAmount()}</td>
           <td>${post. getDate_time()}</td>   
           <td>${post.getMethod()}</td> 
            <td>${post. getAccount_details()}</td>      
   </tr>
  </c:forEach>
</table></p>
            <p class="m-0">
              Recusandae est praesentium consequatur eos voluptatem. Vitae dolores aliquam itaque odio nihil. Neque ut neque ut quae voluptas. Maxime corporis aut ut ipsum consequatur. Repudiandae sunt sequi minus qui et. Doloribus molestiae officiis.
              Soluta eligendi fugiat omnis enim. Numquam alias sint possimus eveniet ad. Ratione in earum eum magni totam.
            </p>
          </div>
          <c:import url="footer.jsp" />
          