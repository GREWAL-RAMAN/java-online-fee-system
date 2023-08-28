
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%><%
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
<br><br><br><br><br><br>

<table id="example" class="display nowrap" style="width:100%">
<thead>
<tr>
<th >Id</th>
<th >Student ID</th>
<th >Student Course Id</th>
<th >Amount</th>
<th >Payment Method</th>
<th >Date Time</th>
<th >Additional Info</th>

</tr></thead>
<tbody>
<c:forEach items="${listPayment}" var="post">
   <tr>
          <td>${post. getId()}</td>  
          <td>${post. getSt_id()}</td>
          <td>${post.getP_id()}</td>        
          <td>${post. getAmount()}</td>
          <td>${post. getMethod_name()}</td>
          <td>${post.getDate_time()}</td>
          <td>${post.getAccount_details()}</td>
           </tr>
  </c:forEach>
  </tbody>
</table>
</form>
<script type="text/javascript">
const searchFun = () => {
	  let filter = document.getElementById('myInput').value.toUpperCase();
	  let myTable = document.getElementById('example');
	  let tr = myTable.getElementsByTagName('tr');

	  for (var i = 1; i < tr.length; i++) { // Start the loop at index 1
	    let td = tr[i].getElementsByTagName('td')[1];
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
	  if (filter.length === 0) {
	    for (var i = 0; i < tr.length; i++) {
	      tr[i].style.display = "";
	    }
	  }
	}
</script>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
} );
</script>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.print.min.js"></script>



</body>
<c:import url="accfooter.jsp" />
