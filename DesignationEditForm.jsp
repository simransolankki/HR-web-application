<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'></tm:Module>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<script src='/styletwo/js/DesignationEditForm.js'></script>

<jsp:include page='/MasterPageTopSection.jsp' />
<h2>Designation (Edit Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>
<form action='/styletwo/EditDesignation.jsp' onsubmit='return validateForm(this)'>
Designation
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
<input type='hidden' id='code' name='code' value=${designationBean.code}>
<span id='titleErrorSection' class='error'></span><br>
<button type='submit'>Update</button>
<button type='Button' onclick='cancelEditing()'>Cancel</button>
</form>

<form id='cancelEditingForm' action='/styletwo/Designations.jsp'></form>
<jsp:include page='/MasterPageBottomSection.jsp' />