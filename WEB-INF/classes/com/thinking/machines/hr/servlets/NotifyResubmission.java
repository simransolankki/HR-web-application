package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class NotifyResubmission extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Notification");
messageBean.setMessage("Form can not be resubmitted.");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("index.jsp");
messageBean.setModuleName("HOME");

request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notifications.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception.getMessage());
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}


}

}