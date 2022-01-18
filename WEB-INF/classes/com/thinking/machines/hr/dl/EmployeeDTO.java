package com.thinking.machines.hr.dl;
import java.math.*;
import java.util.*;
public class EmployeeDTO implements java.io.Serializable,Comparable<EmployeeDTO>
{
private String id;
private String name;
private String title;
private int designationCode;
private String gender;
private Date dateOfBirth;
private boolean isIndian;
private BigDecimal basicSalary;
private String panNumber;
private String aadharCardNumber;
public EmployeeDTO()
{
this.id="";
this.name="";
this.title="";
this.designationCode=0;
this.gender="";
this.dateOfBirth=null;
this.isIndian=false;
this.basicSalary=null;
this.panNumber="";
this.aadharCardNumber="";
}

public void setId(String id)
{
this.id=id;
}
public String getId()
{
return this.id;
}
 
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}

public void setDesignation(String title)
{
this.title=title;
}
public String getDesignation()
{
return this.title;
}

public void setDesignationCode(int designationCode)
{
this.designationCode=designationCode;
}
public int getDesignationCode()
{
return this.designationCode;
}

public void setGender(String gender)
{
this.gender=gender;
}
public String getGender()
{
return this.gender;
}

public void setDateOfBirth(Date dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public Date getDateOfBirth()
{
return this.dateOfBirth;
}

public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public boolean getIsIndian()
{
return this.isIndian;
}

public void setBasicSalary(BigDecimal basicSalary)
{
this.basicSalary=basicSalary;
}
public BigDecimal getBasicSalary()
{
return this.basicSalary;
}

public void setPanNumber(String panNumber)
{
this.panNumber=panNumber;
}
public String getPanNumber()
{
return this.panNumber;
}

public void setAadharCardNumber(String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}

public boolean equals(Object object)
{
if(!(object instanceof EmployeeDTO)) return false;
EmployeeDTO other=(EmployeeDTO)object;
return this.id.equalsIgnoreCase(other.id);
}

public int compareTo(EmployeeDTO other)
{
return this.id.compareTo(other.id);
}

public int hashCode()
{
return id.hashCode();
}
}