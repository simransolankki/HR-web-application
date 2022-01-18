package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
public class DesignationsTagHandler extends BodyTagSupport
{
private List<DesignationBean> designationBeans;
int index;
public DesignationsTagHandler()
{
reset();
}
public void reset()
{
index=0;
if(designationBeans!=null)
{
designationBeans.clear();
designationBeans=null;
}
}
public int doStartTag()
{
List<DesignationDTO> designations=null;
try
{
designations=new DesignationDAO().getAll();
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());//remove after testing
return super.SKIP_BODY;
}
if(designations.size()==0) return super.SKIP_BODY;
designationBeans=new LinkedList<>();
DesignationBean designationBean;
for(DesignationDTO designation:designations)
{
designationBean=new DesignationBean();
designationBean.setCode(designation.getCode());
designationBean.setTitle(designation.getTitle());
designationBeans.add(designationBean);
}//DAO's getAll() will return the address of a LinkedList<DesignationDTO> and then we will extract the Designation code and title from each designationDTO to designationBean and then put each designation bean in designationBeans named LInkedList
index=0;//initialize the index with zero
designationBean=designationBeans.get(index);//will assign the address of a designationBean type object in designationBeans at a given index to designationBean
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE); //then we will put the designationBean type object's address in request scope
pageContext.setAttribute("serialNumber",new Integer(index+1));//will make an object of type Integer and pass it on the value index+1 and then we will be able to access the value under the name "serial number"
return super.EVAL_BODY_INCLUDE;
}//
public int doAfterBody()
{
index++;
if(designationBeans.size()==index) return super.SKIP_BODY;
DesignationBean designationBean;
designationBean=designationBeans.get(index);
pageContext.setAttribute("designationBean",designationBean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1));
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}