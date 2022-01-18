<jsp:useBean id='administratorBean' scope='request' class='com.thinking.machines.hr.beans.AdministratorBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR Application</title>
<script src='/styletwo/js/LoginForm.js'></script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/LoginPageStyle.css'>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styleone/images/logo.png' style='margin:6px;float:left'>
<!-- header content starts here -->
<div class='header-content'>
Thinking Machines
</div>
<!-- header content ends here -->
</div>
<!-- header ends here -->
<!-- mid section starts here -->
<div class='content-section'>
<!-- right panel starts here -->
<div class='login-div'>
<h2 style='font-family:helvetica;font-weight:normal;padding:20px;margin-bottom:1px'>Administrator</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form action='/styletwo/Login.jsp' onsubmit='return validateLoginForm(this)'>
<style='font-family:helvetica'>Username
<input style='height:30px;width:300px;border:0.5px solid #f0f0f5;border-radius:4px' type='text' id='username' name='username' value='${administratorBean.username}' maxlength='15'>
<span id='usernameErrorSection' class='error'></span>
<br><br>
<style='font-family:helvetica'>Password
<input style='height:30px;width:300px;border:0.5px solid #f0f0f5;border-radius:4px' type='password' id='password' name='password' value='${administratorBean.password}' maxlength='15'>
<span id='passwordErrorSection' class='error'></span>
<br><br>
<button type='submit' class='button'>Login</button>
</form>
</div>
</center>
<!-- right panel ends here -->
</div>
<!-- mid section ends here-->
<!-- footer starts here -->
<div class='footer'>
&copy Thinking Machines 2020
</div>
<!-- footer ends here -->
</div>
<!-- Main container ends here -->
</body>
</html>