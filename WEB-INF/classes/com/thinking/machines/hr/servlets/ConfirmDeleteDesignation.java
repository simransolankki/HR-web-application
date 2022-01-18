package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
DesignationBean designationBean=new DesignationBean();
String codeString=request.getParameter("code");
RequestDispatcher requestDispatcher;
if(codeString==null)
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
if(codeString.trim().length()==0)
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
int code=Integer.parseInt(codeString);
if(code<=0)
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
DesignationDTO designation;
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
try
{
designation=designationDAO.getByCode(code);
designationBean.setTitle(designation.getTitle());
designationBean.setCode(designation.getCode());
request.setAttribute("designationBean",designationBean);
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
}
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