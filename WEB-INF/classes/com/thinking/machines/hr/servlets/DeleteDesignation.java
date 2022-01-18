package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
RequestDispatcher requestDispatcher;
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");

if(designationBean==null)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}
/*int code=Integer.parseInt("");
if(code<=0)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
do nothing
}
}
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designation=new DesignationDTO();
try
{
designation=designationDAO.getByCode(code);
designationDAO.delete(designation);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Designation (Delete Module)");
messageBean.setMessage("Designation deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("Designations.jsp");
messageBean.setModuleName("DESIGNATION");

request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notifications.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setErrorMessage(daoException.getMessage());
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
}*/

}catch(Exception exception)
{
System.out.println(exception.getMessage());
//RequestDispatcher requestDispatcher;
//requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
//try
//{
//requestDispatcher.forward(request,response);
//}catch(Exception e)
//{
//do nothing
//}
}


}

}