<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
<tm:usernameSessionActivity>
<jsp:forward page='/Login.jsp' />
</tm:usernameSessionActivity>
<tm:Module name="HOME"></tm:Module>
<jsp:include page='/MasterPageTopSection.jsp' />
<h1>Welcome</h1>
<jsp:include page='/MasterPageBottomSection.jsp' />