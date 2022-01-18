<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'></tm:Module>
<jsp:include page='MasterPageTopSection.jsp' />
<link rel='styelsheet' type='text/css' href='/styletwo/css/employees.css'>
<script src='/styletwo/js/Employees.js'></script>
<h2>Employees</h2>
<div class='employeeGrid'>
<table border='1'>
<thead>
<th colspan='6' class='employeeGridHeader'>
<a href='/styleone/addEmployee'>Add employee</a>
</th>
<tr>
<th class='employeeGridSNO'>S.No.</th>
<th class='employeeGridEmployeeId'>Employee Id</th>
<th class='employeeGridNameDesignation'>Name</th>
<th class='employeeGridNameDesignation'>Designation</th>
<th class='employeeGridEditDelete'>Edit</th>
<th class='employeeGridEditDelete'>Delete</th>
</tr>
</thead>
<tbody>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.EmployeeBL' populatorMethod='getAll' beanName='eBean'>
<tr style='cursor:pointer' onclick='selectEmployee(this,"${eBean.id}")'>
<td style='width:50px;text-align:right'>${serialNumber}.</td>
<td style='width:100px;text-align:left'>${eBean.id}</td>
<td style='width:200px;text-align:left'>${eBean.name}</td>
<td style='width:200px;text-align:left'>${eBean.designation}</td>
<td style='width:100px;text-align:center'><a href='/styleone/editEmployee?employeeId=${eBean.id}'>Edit</a></td>
<td style='width:100px;text-align:center'><a href='/styleone/confirmEmployeeDeletion?employeeId=${eBean.id}'>Delete</a></td>
</tr>
</tm:EntityList>
</tbody>
</table>
</div>
<div style='width:auto;height:21vh;margin-left:10px;margin-right:5px;margin-top:10px;margin-bottom:5px;border:0.5px solid black;padding-top:5px;padding-left:5px'>
<label style='background:#adad85;color:white;padding-right:5px;padding-left:5px;'>Details</label>
<table border='0' width='100%'>
<tr>
<td>Employee Id : <span id='detailPanel_employeeId' style='margin-right:40px;'></span></td>
<td>Name : <span id='detailPanel_name' style='margin-right:40px;'></span></td>
<td>Designation : <span id='detailPanel_designation' style='margin-right:40px;'></span></td>
</tr>
<tr>
<td>Date of birth : <span id='detailPanel_dateOfBirth' style='margin-right:40px;'></span></td>
<td>Gender : <span id='detailPanel_gender' style='margin-right:40px;'></span></td>
<td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:40px;'></span></td>
</tr>
<tr>
<td>Basic Salary : <span id='detailPanel_basicSalary' style='margin-right:40px;'></span></td>
<td>Pan Number : <span id='detailPanel_panNumber' style='margin-right:40px;'></span></td>
<td>Adhaar Card Number : <span id='detailPanel_aadharNumber' style='margin-right:40px;'></span></td>
</tr>
</table>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />