package com.thinking.machines.hr.beans;
import java.math.*;
import java.util.*;
public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
private String id;
private String name;
private String designation;
private int designationCode;
private String gender;
private String dateOfBirth;
private boolean isIndian;
private String basicSalary;
private String panNumber;
private String aadharCardNumber;
public EmployeeBean()
{
this.id="";
this.name="";
this.designation="";
this.designationCode=0;
this.gender="";
this.dateOfBirth=null;
this.isIndian=false;
this.basicSalary=null;
this.panNumber="";
this.aadharCardNumber="";
}

public boolean isMale()
{
return gender.equals("M");
}
public boolean isFemale()
{
return gender.equals("F");
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

public void setDesignation(String designation)
{
this.designation=designation;
}
public String getDesignation()
{
return this.designation;
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

public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
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

public void setBasicSalary(String basicSalary)
{
this.basicSalary=basicSalary;
}
public String getBasicSalary()
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
if(!(object instanceof EmployeeBean)) return false;
EmployeeBean other=(EmployeeBean)object;
return this.id.equalsIgnoreCase(other.id);
}

public int compareTo(EmployeeBean other)
{
return this.id.compareTo(other.id);
}

public int hashCode()
{
return id.hashCode();
}
}