package com.thinking.machines.hr.bl;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.text.*;
public class EmployeeBL
{
public List<EmployeeBean> getAll()
{
List<EmployeeBean> employeeBeans=new LinkedList<>();
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> dlEmployees=employeeDAO.getAll();
EmployeeBean employeeBean;
SimpleDateFormat simpleDateFormat;
simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO dlEmployee:dlEmployees)
{
employeeBean=new EmployeeBean();
employeeBean.setId(dlEmployee.getId());
employeeBean.setName(dlEmployee.getName());
employeeBean.setDesignation(dlEmployee.getDesignation());
employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
employeeBean.setDateOfBirth(simpleDateFormat.format(dlEmployee.getDateOfBirth()));
employeeBean.setGender(dlEmployee.getGender());
employeeBean.setIsIndian(dlEmployee.getIsIndian());
employeeBean.setBasicSalary(dlEmployee.getBasicSalary().toPlainString());
employeeBean.setPanNumber(dlEmployee.getPanNumber());
employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
employeeBeans.add(employeeBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());//to be changed later on
}
return employeeBeans;
}
}