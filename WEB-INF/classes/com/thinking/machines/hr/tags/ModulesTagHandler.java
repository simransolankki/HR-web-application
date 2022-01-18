package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class ModulesTagHandler extends BodyTagSupport
{
private String name;
public ModulesTagHandler()
{
reset();
}
public void reset()
{
this.name="";
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public int doStartTag()
{
if(this.name=="HOME")
{
pageContext.setAttribute("HOME",new String("HOME"),PageContext.REQUEST_SCOPE);
}
if(this.name=="DESIGNATION") 
{
pageContext.setAttribute("DESIGNATION",new String("DESIGNATION"),PageContext.REQUEST_SCOPE);
}
if(this.name=="EMPLOYEE")
{
pageContext.setAttribute("EMPLOYEE",new String("EMPLOYEE"),PageContext.REQUEST_SCOPE);
}
pageContext.setAttribute("module",new String(this.name),PageContext.REQUEST_SCOPE);
return super.EVAL_BODY_INCLUDE;
}
public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}