//static page hai ise dynamically fetch karna hai data uske liye changes karne padenge
function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.basicSalary=0;
this.dateOfBirth="";
this.gender="";
this.isIndian=false;
this.panNumber="";
this.adhaarCardNumber="";
}
var selectedRow=null;
var employees=[];
function selectEmployee(row,employeeId)
{
if(row==selectedRow) return;
if(selectedRow!=null)
{
selectedRow.style.background="white"
selectedRow.style.color="black";
}
row.style.color="white";
row.style.background="#adad85";
selectedRow=row;
var i;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById('detailPanel_employeeId').innerHTML=emp.employeeId;
document.getElementById('detailPanel_employeeName').innerHTML=emp.name;
document.getElementById('detailPanel_employeeDesignation').innerHTML=emp.designation;
document.getElementById('detailPanel_employeeDOB').innerHTML=emp.dateOfBirth;
document.getElementById('detailPanel_employeeGender').innerHTML=emp.gender;
if(emp.isIndian)
{
document.getElementById('detailPanel_employeeIsIndian').innerHTML='Yes';
}
else
{
document.getElementById('detailPanel_employeeIsIndian').innerHTML='No';
}
document.getElementById('detailPanel_employeeSalary').innerHTML=emp.basicSalary;
document.getElementById('detailPanel_employeePanNumber').innerHTML=emp.panNumber;
document.getElementById('detailPanel_employeeAdhaarNumber').innerHTML=emp.adhaarCardNumber;
}

//bad mein add kiya hua part
function createDynamicRowClickHandler(rowAddress,employeeId)
{
return function()
{
selectEmployee(rowAddress,employeeId);
}
}
function populateEmployeesGridTable()
{
//alert(employees.length);
var employeesGridTable=document.getElementById("employeesGridTable");
//alert(employeesGridTable);
var employeesGridTableBody=employeesGridTable.getElementsByTagName("tbody")[0];
//alert(employeesGridTableBody);
//alert(employeesGridTableBody.innerHTML);
var employeesGridTableRowTemplate=employeesGridTableBody.getElementsByTagName("tr")[0];
//remove the ROW from DOM(Document Object Model)
alert('Great');
employeesGridTableRowTemplate.remove();
//alert(employeesGridTableRowTemplate.innerHTML);
var employeesGridTableColumnsTemplateCollection=employeesGridTableRowTemplate.getElementsByTagName("td");
var cellTemplate;
var k;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
var dynamicRowId=[];
for(k=0;k<employees.length;k++)
{
dynamicRow=employeesGridTableRowTemplate.cloneNode(true);
employeesGridTable.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName("td");
for(var i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute("placeHolderId");
if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=(k+1)+".";
if(placeHolderFor=="name") cellTemplate.innerHTML=employees[k].name;
if(placeHolderFor=="designationCode") cellTemplate.innerHTML=employees[k].designationCode;
if(placeHolderFor=="designation") cellTemplate.innerHTML=employees[k].designation;
if(placeHolderFor=="id") cellTemplate.innerHTML=employees[k].employeeId;
if(placeHolderFor=="adhaarCardNumber") cellTemplate.innerHTML=employees[k].adhaarCardNumber;
if(placeHolderFor=="basicSalary") cellTemplate.innerHTML=employees[k].basicSalary;
if(placeHolderFor=="dateOfBirth") cellTemplate.innerHTML=employees[k].dateOfBirth;
if(placeHolderFor=="panNumber") cellTemplate.innerHTML=employees[k].panNumber;
if(placeHolderFor=="editOption") cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employees[k].employeeId+"'>Edit</a>";
if(placeHolderFor=="deleteOption") cellTemplate.innerHTML="<a href='/styletwo/confirmEmployeeDeletion?employeeId="+employees[k].employeeId+"'>Delete</a>";
//alert(cellTemplate.getAttribute("placeHolderId"));
}
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
}//employees population loop ends
}
window.addEventListener('load',populateEmployeesGridTable);