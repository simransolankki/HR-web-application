<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
<tm:FormResubmitted>
<jsp:forward page='/notifyResubmission' />
</tm:FormResubmitted>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:setProperty name='designationBean' property='*'/>
<jsp:forward page='/addDesignation'/>