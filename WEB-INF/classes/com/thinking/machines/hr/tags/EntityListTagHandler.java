package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
public class EntityListTagHandler extends BodyTagSupport
{
private List list;
private String populatorClass;
private String populatorMethod;
private String beanName;//because beans will be populated int the list
private int index=0;
public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}
public String getPopulatorClass()
{
return this.populatorClass;
}
public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}
public String getPopulatorMethod()
{
return this.populatorMethod;
}
public void setBeanName(String beanName)
{
this.beanName=beanName;
}
public String getBeanName()
{
return this.beanName;
}
public EntityListTagHandler()
{
reset();
}
public void reset()
{
this.list=null;
this.populatorClass=null;
this.populatorMethod=null;
this.beanName=null;
}
public int doStartTag()
{
try
{
index=0;
if(beanName==null || beanName.trim().length()==0) return super.SKIP_BODY;
Class c=Class.forName(populatorClass);
Object obj=c.newInstance();
Class parameters[]=new Class[0];
Method method=c.getMethod(populatorMethod,parameters);//since there are going to be no parameters to zero size ka parameters nam ka array bna diya
list=(List)method.invoke(obj);
if(list==null) return super.SKIP_BODY;
if(list.size()==0) return super.SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(beanName,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),PageContext.REQUEST_SCOPE);
index++;
return super.EVAL_BODY_INCLUDE;
}catch(Throwable t)
{
//some logging act should be done later on(in next styles)
return super.SKIP_BODY;
}

}

public int doAfterBody()
{
if(index==list.size()) return super.SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(beanName,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),PageContext.REQUEST_SCOPE);
index++;
return super.EVAL_BODY_AGAIN;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}