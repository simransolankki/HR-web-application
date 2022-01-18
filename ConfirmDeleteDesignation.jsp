<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'></tm:Module>
<script src='/styletwo/js/DesignationDeleteForm.js'></script>
<jsp:useBean id="designationBean" scope="request" class="com.thinking.machines.hr.beans.DesignationBean" />
<jsp:useBean id="errorBean" scope="request" class="com.thinking.machines.hr.beans.ErrorBean" />
<jsp:include page='/MasterPageTopSection.jsp' />
<h2>Designation (Delete Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>
<form action='/styletwo/deleteDesignation'>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
<h3>Are you sure you want to delete the designation : ${designationBean.title}</h3>
<button type='submit'>Yes</button>
<button type='Button' onclick='cancelDeletion()'>No</button>
</form>

<form id='cancelDeleteForm' action='/styletwo/Designations.jsp'></form>
<jsp:include page='/MasterPageBottomSection.jsp' />