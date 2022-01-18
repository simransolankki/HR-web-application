function validateForm(frm)
{
var valid=true;
var firstInvalidComponent=null;
var name=frm.name.value.trim();
var nameErrorSection=document.getElementById('nameErrorSection');
nameErrorSection.innerHTML='';
if(name.length==0)
{
nameErrorSection.innerHTML='**Name required';
valid=false;
firstInvalidComponent=frm.name;
}
else
{
var v='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .';
var e;
for(e=0;e<name.length;e++)
{
if(v.indexOf(name.charAt(e))==-1)
{
nameErrorSection.innerHTML='**Invalid name';
valid=false;
firstInvalidComponent=frm.name;
break;
}
}
}

var designationCode=frm.designationCode.value;
var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');
designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
designationCodeErrorSection.innerHTML='**Select designation';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;
}

var gender=frm.gender;
var genderErrorSection=document.getElementById('genderErrorSection');
genderErrorSection.innerHTML='';
if(gender[0].checked==false && gender[1].checked==false)
{
genderErrorSection.innerHTML='**Select gender';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.gender[0];
}

var basicSalary=frm.basicSalary.value.trim();
var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');
basicSalaryErrorSection.innerHTML='';
if(basicSalary.length==0)
{
basicSalaryErrorSection.innerHTML='**Basic salary required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
}
else
{
var a='0123456789.';
var i;
for(i=0;i<basicSalary.length;i++)
{
if(a.indexOf(basicSalary.charAt(i))==-1)
{
basicSalaryErrorSection.innerHTML='**Invalid Basic salary';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
}
}
}

var panNumber=frm.panNumber.value.trim();
var panNumberErrorSection=document.getElementById('panNumberErrorSection');
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
panNumberErrorSection.innerHTML='**PAN Number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;
}

var aadharCardNumber=frm.aadharCardNumber.value.trim();
var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
aadharCardNumberErrorSection.innerHTML='**Aadhar Card Number required';
valid=false;
if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;
}

if(valid==false) firstInvalidComponent.focus();
return valid;
}


function cancelAddition()
{
document.getElementById('cancelAdditionForm').submit();
}
