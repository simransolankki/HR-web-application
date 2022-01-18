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
document.getElementById('detailPanel_name').innerHTML=emp.name;
document.getElementById('detailPanel_designation').innerHTML=emp.designation;
document.getElementById('detailPanel_dateOfBirth').innerHTML=emp.dateOfBirth;
document.getElementById('detailPanel_gender').innerHTML=emp.gender;
if(emp.isIndian)
{
document.getElementById('detailPanel_isIndian').innerHTML='Yes';
}
else
{
document.getElementById('detailPanel_isIndian').innerHTML='No';
}
document.getElementById('detailPanel_basicSalary').innerHTML=emp.basicSalary;
document.getElementById('detailPanel_panNumber').innerHTML=emp.panNumber;
document.getElementById('detailPanel_aadharNumber').innerHTML=emp.adhaarCardNumber;
}