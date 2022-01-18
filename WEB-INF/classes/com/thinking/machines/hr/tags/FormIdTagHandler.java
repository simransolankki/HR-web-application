package com.thinking.machines.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
public class FormIdTagHandler extends TagSupport
{
public FormIdTagHandler()
{
reset();
}
public void reset()
{
//do nothing
}
public int doStartTag()
{
String formId=UUID.randomUUID().toString();
pageContext.setAttribute(formId,formId,PageContext.SESSION_SCOPE);
JspWriter jw=pageContext.getOut();
try
{
jw.print("<input type='hidden' id='formId' name='formId' value='"+formId+"'>");
}catch(IOException ioe)
{
//do nothing
}
return this.SKIP_BODY;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}