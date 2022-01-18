<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<script>
var employee;
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.EmployeeBL' populatorMethod='getAll' beanName='eBean'>
employee=new Employee();
employee.employeeId="${eBean.id}";
employee.name="${eBean.name}";
employee.designationCode=${eBean.designationCode};
employee.designation="${eBean.designation}";
employee.basicSalary=${eBean.basicSalary};
employee.dateOfBirth="${eBean.dateOfBirth}";
employee.isIndian=${eBean.isIndian};
employee.gender="${eBean.gender}";
employee.panNumber="${eBean.panNumber}";
employee.adhaarCardNumber="${eBean.aadharCardNumber}";
employees[${serialNumber-1}]=employee;
</tm:EntityList>
</script>