<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'></tm:Module>
<jsp:useBean id='eBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/EmployeeAddForm.js'></script>
<h2 style='margin-left:10px;'>Employee (Add Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form action='/styletwo/addEmployee' onsubmit='return validateForm(this)'>
<table style='margin-left:10px;'>
<tr>
<td>
Name
</td>
<td>
<input type='text' id='name' name='name' maxlength='50' size='51' value='${eBean.name}'>
<span id='nameErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td>
Designation
</td>
<td>
<select name='designationCode' id='designationCode'> //need to populate it dynamically
<option value='-1'>&lt;Select&gt;</option>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.EmployeeBean' populatorMethod='getAll' beanName='eBean'>
<option value='${eBean.designationCode}'>${eBean.designation}</option>
</tm:EntityList>
</select>
<span id='designationCodeErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td>
Gender
</td>
<td>
Male<input type='radio' id='Male' name='gender' value='M'>
&nbsp;&nbsp;&nbsp;
Female<input type='radio' id='Female' name='gender' value='F'>
<span id='genderErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td>
Is Indian ?
</td>
<td>
<input type='checkbox' name='isIndian' id='isIndian' value='${eBean.isIndian}'>
</td>
</tr>

<tr>
<td>
Basic Salary
</td>
<td>
<input type='text' id='basicSalary' name='basicSalary' value='${eBean.basicSalary}'>
<span id='basicSalaryErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td>
PAN Number
</td>
<td>
<input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='${eBean.panNumber}'>
<span id='panNumberErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td>
Aadhar Card Number
</td>
<td>
<input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${eBean.aadharCardNumber}'>
<span id='aadharCardNumberErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td></td>
<td>
<button type='submit'>Add</button>
<button type='Button' onclick='cancelAddition()'>Cancel</button>
</td>
</tr>

</table>
</form>
<form id='cancelAdditionForm' action='/styletwo/Employees.jsp'></form>
<jsp:include page='/MasterPageBottomSection.jsp' />