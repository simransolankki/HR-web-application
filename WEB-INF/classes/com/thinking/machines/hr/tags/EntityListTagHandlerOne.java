package com.thinking.machines.hr.tags;
import java.servlet.jsp.*;
import java.servlet.jsp.tagext.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
public class EntityListTagHandlerOne extends BodyTagSupport
{
private List list;
private String populatorClass;
private String populatorMethod;
private String beanName;
private int index;
public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}
public String getPopulatorClass()
{
return this.populatorClass();
}
public void setPopulatorMethod(String populatorMethod);
{
this.populatorMethod=populatorMethod;
}
public String getPopulatorMethod()
{
return this.populatorMethod();
}
public void setBeanName(String beanName)
{
this.beanName=beanName;
}
public String getBeanName()
{
return this.beanName;
}
public EntityListTagHandlerOne()
{
this.reset();
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
index=0;
try
{
if(beanName==null || beanName.trim().size()==0) return super.SKIP_BODY;
Class c=Class.forName(populatorClass);
Object obj=c.newInstance();
Class parameters[]=new Class[0];
Method method=c.getMethod(populatorMethod,parameters);
list=(List)method.invoke(obj);
if(list==null || list.size()==0) return super.SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(beanName,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",new Integer(index+1),PageContext.REQUEST_SCOPE);
index++;
return super.EVAL_BODY_INCLUDE;
}catch(Throwable t)
{
return super.SKIP_BODY;
}
}

public int doAfterBody()
{
if(list.size()==index) return super.SKIP_BODY;
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