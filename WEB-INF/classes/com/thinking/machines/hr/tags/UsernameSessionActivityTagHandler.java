package com.thinking.machines.hr.tags;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
public class UsernameSessionActivityTagHandler extends TagSupport
{
public void reset()
{
//do nothing
}
public int doStartTag()
{
HttpServletRequest request;
request=(HttpServletRequest)pageContext.getRequest();
HttpSession session=request.getSession(false);
if(session==null) return super.EVAL_BODY_INCLUDE;
else return super.SKIP_BODY;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}