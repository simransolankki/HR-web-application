package com.thinking.machines.hr.tags;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
public class UsernameActivityTagHandler extends BodyTagSupport
{
public int doStartTag()
{
HttpServletRequest request;
request=(HttpServletRequest)pageContext.getRequest();
String username=request.getParameter("username");
JspWriter jw=pageContext.getOut();
try
{
jw.println("<input type='hidden' name='username' id='username' value='"+username+"'>");
}catch(IOException ioException)
{
//do nothing
}
return super.SKIP_BODY;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}