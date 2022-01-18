<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<link rel='stylesheet' type='text/css' href='/styletwo/css/employees.css'>
<script src='/styletwo/js/Employees1.js'></script>
<h2>Employees</h2>
<div class='employeeGrid'>
<table border='1'>
<thead>
<tr><th colspan='6' class='employeeGridHeader'>
<a href='/styleone/getEmployeeAddForm'>AddEmployee</a>
</th></tr>
<tr>
<th class='employeeGridSNOColumnTitle'>S.No.</th>
<th class='employeeGridIdColumnTitle'>Id.</th>
<th class='employeeGridNameColumnTitle'>Name</th>
<th class='employeeGridDesignationColumnTitle'>Designation</th>
<th class='employeeGridEditOptionColumnTitle>Edit</th>
<th class='employeeGridDeleteOptionColumnTitle>Delete</th>
</tr>
</thead>
<tbody>
<tr style='cursor:pointer'>
<td style='text-align:right'></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tbody>
</table>
</div>
<div style='height:19vh;margin-left:5px;margin-right:5px;margin-top:5px;margin-bottom:5px;padding:5px;border:1px solid black'>
<label style='background:gray;color:white;padding-left:5px;padding-right:5px'>Details</label>
<table border='0' width='100%'>
<tr>
<td>Employee Id : <span id='detailPanel_employeeId' style='margin-right:30px'></span></td>
<td>Name : <span id='detailPanel_name' style='margin-right:30px'></span></td>
<td>Designation : <span id='detailPanel_designation' style='margin-right:30px'></span></td>
</tr>
<tr>
<td>Date of Birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px'></span></td>
<td>Gender : <span id='detailPanel_gender' style='margin-right:30px'></span></td>
<td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:30px'></span></td>
</tr>
<tr>
<td>Basic Salary : <span id='detailPanel_basicSalary' style='margin-right:30px'></span></td>
<td>PAN Number : <span id='detailPanel_panNumber' style='margin-right:30px'></span></td>
<td>Aadhar Card Number : <span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>
</tr>
</table>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />