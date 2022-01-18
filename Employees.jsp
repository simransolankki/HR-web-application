<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='EMPLOYEE'/>
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/Employees.js'></script>
<!--<jsp:include page='/EmployeesJS.jsp'>-->
<link rel='stylesheet' type='text/css' href='/styletwo/css/Employee.css'>
<script>
function createDynamicRowClickHandler(rowAddress,employeeId)
{
return function()
{
selectEmployee(rowAddress,employeeId);
};
}
function populateEmployeesGridTable()
{
var employeesGridTable=document.getElementById("employeesGridTable");
var employeesGridTableBody=employeesGridTable.getElementsByTagName("tbody")[0];
var employeesGridTableBodyRowTemplate=employeesGridTableBody.getElementsByTagName("tr")[0];
//remove the ROW from DOM (Document object model)
employeesGridTableBodyRowTemplate.remove();
var employeesGridTableColumnsTemplateCollection=employeesGridTableBodyRowTemplate.getElementsByTagName("td");
var cellTemplate;
var k;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
for(k=0;k<employees.length;k++)
{
dynamicRow=employeesGridTableBodyRowTemplate.cloneNode(true);
employeesGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName("td");
for(var i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute("placeHolderId");
if(placeHolderFor==null) continue;
if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=(k+1);
if(placeHolderFor=="employeeId") cellTemplate.innerHTML=employees[k].employeeId;
if(placeHolderFor=="name") cellTemplate.innerHTML=employees[k].name;
if(placeHolderFor=="designationCode") cellTemplate.innerHTML=employees[k].designationCode;
if(placeHolderFor=="designation") cellTemplate.innerHTML=employees[k].designation;
if(placeHolderFor=="dateOfBirth") cellTemplate.innerHTML=employees[k].dateOfBirth;
if(placeHolderFor=="gender") cellTemplate.innerHTML=employees[k].gender;
if(placeHolderFor=="isIndian") cellTemplate.innerHTML=employees[k].isIndian;
if(placeHolderFor=="basicSalary") cellTemplate.innerHTML=employees[k].basicSalary;
if(placeHolderFor=="panNumber") cellTemplate.innerHTML=employees[k].panNumber;
if(placeHolderFor=="aadharCardNumber") cellTemplate.innerHTML=employees[k].aadharCardNumber;
if(placeHolderFor=="editOption") cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employees[k].employeeId+"'>Edit</a>";
if(placeHolderFor=="deleteOption") cellTemplate.innerHTML="<a href='/styletwo/deleteEmployee?employeeId="+employees[k].employeeId+"'>Delete</a>";
}
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
}//employees population loop ends
}
window.addEventListener('load',populateEmployeesGridTable);
</script>
<h4>Employees</h4>
<div class='employeeGridSection'>
<table border='1' id='employeesGridTable'>
<thead>
<tr>
<th colspan='6' class='employeeGridHeader'>
<a href='/styleone/getEmployeeAddForm'>Add Employee</a>
</th>
</tr>
<tr>
<th class='employeeGridSNOSection'>S.No.</th>
<th class='employeeGridIdSection'>Id.</th>
<th class='employeeGridNameSection'>Name</th>
<th class='employeeGridDesignationSection'>Designation</th>
<th class='employeeGridEditSection'>Edit</th>
<th class='employeeGridDeleteSection'>Delete</th>
</tr>
</thead>
<tbody>
<tr style='cursor:pointer'>
<td style='text-align: right' placeHolderId='serialNumber'></td>
<td placeHolderId='employeeId'></td>
<td placeHolderId='name'></td>
<td placeHolderId='designation'></td>
<td placeHolderId='editOption' style='text-align: center'></td>
<td placeHolderId='deleteOption' style='text-align: center'></td>
</tr>
</tbody>
    </table>
  </div>

<div style='height:19vh;margin-left:5px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black;'>
   <label style='background:gray;color:white;padding-left: 5px;padding-right: 5px'>Details</label>
    <table border='0' width="100%">
      <tr>
        <td>Employee Id : <span id='detailPanel_employeeId' style='margin-right: 30px'></span></td>
          <td>Name : <span id='detailPanel_name' style='margin-right: 30px'></span></td>
        <td>Designation: <span id='detailPanel_designation' style='margin-right: 30px'></span></td>
      </tr>

        <tr>
        <td>Date Of Birth : <span id='detailPanel_dateOfBirth' style='margin-right: 30px'></span></td>
          <td>Gender : <span id='detailPanel_gender' style='margin-right: 30px'></span></td>
        <td>Is Indian : <span id='detailPanel_isIndian' style='margin-right: 30px'></span></td>
      </tr>
      
        <tr>
        <td>Basic salary : <span id='detailPanel_basicSalary' style='margin-right: 30px'></span></td>
          <td>PAN Number : <span id='detailPanel_panNumber' style='margin-right: 30px'></span></td>
        <td>Aadhar Card Number : <span id='detailPanel_aadharCardNumber' style='margin-right: 30px'></span></td>
      </tr>
    </table>


</div>
</div>
<!--right panel ends here -->
</div><!--content-section ends here -->
<!--footer starts here -->
<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>
&copy; Thinking Machines 2020
</div>
<!-- footer ends here -->
</div> <!--Main container ends here -->
</body>
</html>