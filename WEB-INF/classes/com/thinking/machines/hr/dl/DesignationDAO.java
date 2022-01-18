package com.thinking.machines.hr.dl;
import java.sql.*;
import java.util.*;
public class DesignationDAO
{
public void add(DesignationDTO designation) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,designation.getTitle());
ResultSet resultSet=preparedStatement.executeQuery();//agar table mein title exist krta hai already to uske pehle tk ka resultSet ko mil jaega
if(resultSet.next()==true)//isliye agar ResultSet ke next ki value agar true hai matlab ye ki resultSet ka end nhi hua title kahi mil gya 
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Designation : "+designation.getTitle()+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into designation (title) values(?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,designation.getTitle());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
int code=resultSet.getInt(1);
resultSet.close();
preparedStatement.close();
connection.close();
designation.setCode(code);
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
public List<DesignationDTO> getAll() throws DAOException
{
List<DesignationDTO> designations;
designations=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from designation order by title");
DesignationDTO designation;
int code;
String title;
while(resultSet.next())
{
code=resultSet.getInt("code");
title=resultSet.getString("title").trim(); //trim is vvvvvv imp
designation=new DesignationDTO();
designation.setCode(code);
designation.setTitle(title);
designations.add(designation); //LinkedList ki add method
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return designations;
}
public DesignationDTO getByCode(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid designation code"+code);
}
DesignationDTO designation=new DesignationDTO();
designation.setCode(resultSet.getInt("code"));
designation.setTitle(resultSet.getString("title").trim());//trim is very important
resultSet.close();
preparedStatement.close();
connection.close();
return designation;
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
public void update(DesignationDTO designation) throws DAOException
{
try
{
int code=designation.getCode();
String title=designation.getTitle();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid designation code"+code);
}
//below is for checking ki title (jo user ne diya hai) vo to exist karta hai jo usne diya pr uske against jo usne code diya hai vo galat hai to user ko ehsaas dilaana pdega
preparedStatement=connection.prepareStatement("select * from designation where title=? and code!=?");
preparedStatement.setString(1,title);
preparedStatement.setInt(2,code);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
throw new DAOException("Title exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update designation set title=? where code=?");
preparedStatement.setString(1,title);
preparedStatement.setInt(2,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}

public void delete(DesignationDTO designation) throws DAOException
{
try
{
int code=designation.getCode();
String title=designation.getTitle();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid designation code :"+code);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from designation where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}

public void deleteByCode(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
preparedStatement.close();
resultSet.close();
connection.close();
throw new DAOException("Invalid designation code : "+code);
}
preparedStatement.close();
resultSet.close();
preparedStatement=connection.prepareStatement("select gender from employee where designation_code=?");
preparedStatement.setInt(1,code);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
preparedStatement.close();
resultSet.close();
connection.close();
throw new DAOException("Cannot delete designation as it has been alloted to an employee");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from designation where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
public boolean designationCodeExists(int designationCode) throws DAOException
{
boolean exists=true;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from designation where code=?");
preparedStatement.setInt(1,designationCode);
ResultSet resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
preparedStatement.close();
resultSet.close();
connection.close();
}catch(Exception exception)
{
System.out.println(exception.getMessage());
}
return exists;
}

}