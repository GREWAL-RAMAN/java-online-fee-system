
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

<br><br><br><br>


    <div id="content" class="container">  <center>  <h1 class="text-bg-primary">Receipt</h1></center>
	<table class="table border">
		<tr>
			<td>Student Id:</td>
			<td class="text-bg-primary p-3"><b><%=request.getParameter("st_id") %></b></td>
		</tr>
		<tr>
			<td>Student Name:</td>
			<td><b><%=request.getParameter("st_name") %></b></td>
		</tr>
		<tr>
			<td>Course Id:</td>
			<td><b><%=request.getParameter("co_id") %></b></td>
		</tr>
		<tr>
			<td>Course Name:</td>
			<td><b><%=request.getParameter("co_name") %></b></td>
		</tr>
		<tr>
			<td>Course Start Date:</td>
			<td><b><%=request.getParameter("start") %></b></td>
		</tr>
			<tr>
			<td>Course End Date</td>
			<td><b><%=request.getParameter("end") %></b></td>
		</tr>
		<tr>
			<td>Total Cost :</td>
			<td><b><%=request.getParameter("total") +"INR" %></b></td>
		</tr>		
			<tr>
			<td>Total Amount Paid:</td>
			<td><b><%=request.getParameter("payed") +"INR" %></b></td>
		</tr>
			<tr>
			<td>Due :</td>
			<td><b><%=request.getParameter("due")+"INR" %></b></td>
		</tr>				
			<tr>
			<td>Status:</td>
			<td><b><%=request.getParameter("status") %></b> </td>
		</tr>
   
</table>
</div>
<div class="container"> <img class="img-thumbnail" title="sign" src="resources/images/sign.jpeg"></div>

<br>
<button id="btn-print-this" class="btn btn-success btn-lg">Print this Page </button>
<a href="accountantHome.jsp"><button  class="btn btn-success btn-lg" >Home </button></a>


<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
       
        dom: 'Bfrtip',
        buttons: [
            'copy',
            'csv',
            'excel',
            'pdf',
            {
                extend: 'print',
                download: 'open',
                text: 'Print all (not just selected)',
                exportOptions: {
                    modifier: {
                        selected: null
                    }
                }
            }
        ],
        select: true
    } );
} );


 
</script>

<script type="text/javascript" src="resources/script.js"></script>
<script  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script  src="printThis.js"></script>
<script  src="custom.js"></script>



</body>
<c:import url="accfooter.jsp" />