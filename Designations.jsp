<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'></tm:Module>
<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<h2>Designations</h2>
<table border='1'>
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:5px'><a href='/styletwo/DesignationAddForm.jsp'>Add new designation</a>
</th>
</tr>
<tr>
<th style='width:50px;text-align:center'>S.No.</th>
<th style='width:200px;text-align:center'>Designations</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
</thead>
<tbody>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' beanName='dBean'>
<tr>
<td style='width:50px;text-align:right'>${serialNumber}.</td>
<td style='width:200px;text-align:left'>${dBean.title}</td>
<td style='width:100px;text-align:center'><a href='/styletwo/editDesignation?code=${dBean.code}'>Edit</a></td>
<td style='width:100px;text-align:center'><a href='/styletwo/confirmDesignationDeletion?code=${dBean.code}'>Delete</a></td>
</tr>
</tm:EntityList>
</tbody>
</table>
<jsp:include page='/MasterPageBottomSection.jsp' />