package com.thinking.machines.hr.tags;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
public class FormResubmittedTagHandler extends TagSupport
{
public FormResubmittedTagHandler()
{
reset();
}
public void reset()
{
//do nothing
}
public int doStartTag()
{
HttpServletRequest request;
request=(HttpServletRequest)pageContext.getRequest();
String formId=request.getParameter("formId");
if(formId==null) return super.EVAL_BODY_INCLUDE;
String formIdInSession=(String)pageContext.getAttribute(formId,PageContext.SESSION_SCOPE);
if(formIdInSession==null) return super.EVAL_BODY_INCLUDE;
pageContext.removeAttribute(formId,PageContext.SESSION_SCOPE);
if(formId.equals(formIdInSession)) return super.SKIP_BODY;
else return super.EVAL_BODY_INCLUDE;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}