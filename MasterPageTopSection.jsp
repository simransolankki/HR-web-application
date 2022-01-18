<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styleone/images/logo.png' style='margin:6px;float:left'>
<!-- header content starts here -->
<div class='brand-name'>
Thinking Machines
</div>
<img src='/styletwo/images/userIc.jpg' style='margin-right:6px;margin-top:3px;float:left'>
<div style='font-family:helvetica;float:left;margin-right:20px;margin-top:9px'>${username}</div>
<form action='/styletwo/logout'>
<button type='submit' style='border:none;background-color:black;color:white;width:100px;height:30px;border-radius:4px;margin-top:4px'>Logout</button>
</form>
<!-- header content ends here -->
</div>
<!-- header ends here -->
<!-- mid section starts here -->
<div class='content'>
<!-- left panel starts here -->
<div class='left-panel'>

<br>
<tm:If condition='${module==HOME}'>
<!-- In case of HOME PAGE -->
<a href='/styletwo/Designations.jsp' style='color:#999966;font-size:15pt;padding:5px'>Designations</a>
<br>
<a href='/styletwo/EmployeesAfterChanges.jsp' style='color:#999966;font-size:15pt;padding:5px'>Employees</a>
<br>
<br>
<b style='font-size:15pt;padding:5px'>Home</b>
</tm:If>

<tm:If condition='${module==DESIGNATION}'>
<!-- In case of DESIGNATION MODULE -->
<b style='font-size:15pt;padding:5px'>Designations</b>
<br>
<a href='/styletwo/EmployeesAfterChanges.jsp' style='color:#999966;font-size:15pt;padding:5px'>Employees</a>
<br>
<br>
<a href='/styletwo/index.jsp' style='color:#999966;font-size:15pt;padding:5px'>Home</a>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<!-- In case of EMPLOYEE MODULE -->
<b style='font-size:15pt;padding:5px'>Employees</b>
<br>
<a href='/styletwo/Designations.jsp' style='color:#999966;font-size:15pt;padding:5px'>Designations</a>
<br>
<br>
<a href='/styletwo/index.jsp' style='color:#999966;font-size:15pt;padding:5px'>Home</a>
</tm:If>

</div>
<!-- left panel ends here -->
<!-- right panel starts here -->
<div class='right-panel'>