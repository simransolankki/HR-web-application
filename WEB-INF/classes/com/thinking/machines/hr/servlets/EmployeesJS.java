package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.bl.*;
import java.util.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EmployeesJS extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/javascript");
/*
the following is a bad idea(and hence commented) because the path is hardcoded
it's possible in someone else's machine the tomcat9 is installed on some other
folder.
*/
//File file=new File("C:\\tomcat9\\webapps\\styletwo\\WEB-INF\\js\\Employees.js");
ServletContext servletContext=getServletContext();
File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}
randomAccessFile.close();
pw.println("var employee;\n");
List<EmployeeBean> employees=new EmployeeBL().getAll();
int i=0;
for(EmployeeBean employeeBean:employees)
{
pw.println("employee=new Employee();");
pw.println("employee.employeeId=\""+employeeBean.getId()+"\";");
pw.println("employee.name=\""+employeeBean.getName()+"\";");
pw.println("employee.designationCode="+employeeBean.getDesignationCode()+";");
pw.println("employee.designation=\""+employeeBean.getDesignation()+"\";");
pw.println("employee.basicSalary="+employeeBean.getBasicSalary()+";");
pw.println("employee.dateOfBirth=\""+employeeBean.getDateOfBirth()+"\";");
pw.println("employee.isIndian="+employeeBean.getIsIndian()+";");
pw.println("employee.gender=\""+employeeBean.getGender()+"\";");
pw.println("employee.panNumber=\""+employeeBean.getPanNumber()+"\";");
pw.println("employee.adhaarCardNumber=\""+employeeBean.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
}
}catch(Exception exception)
{
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