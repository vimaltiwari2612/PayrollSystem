package com.payroll.dao;
import java.util.*;
import java.sql.*;
import java.io.*;
import com.payroll.exceptions.*;
import com.payroll.connection.*;
import com.payroll.interfaces.*;
public class EmployeeDAO implements EmployeeDAOInterface 
{

public void add(EmployeeInterface employeeInterface) throws DAOException
{
try{
if(exists(employeeInterface.getID())==true) throw new DAOException("  ID is already Assigned!!");
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="insert into Employee values("+employeeInterface.getID()+",'"+employeeInterface.getPassword()+"','"+employeeInterface.getName()+"','"+employeeInterface.getAddress()+"',"+employeeInterface.getContact()+",'"+employeeInterface.getGender()+"','"+employeeInterface.getBloodGroup()+"','"+employeeInterface.getDateOfBirth()+"','"+employeeInterface.getCity()+"','"+employeeInterface.getState()+"','"+employeeInterface.getEmail()+"','"+employeeInterface.getMeritalStatus()+"',"+employeeInterface.getAge()+","+employeeInterface.getDearnessAllowance()+","+employeeInterface.getCityCompensatoryAllowance()+","+employeeInterface.getOverTimeAllowance()+","+employeeInterface.getMedicalAllowance()+","+employeeInterface.getHomeRentAllowance()+","+employeeInterface.getDailyAllowance()+","+employeeInterface.getVehicleAllowance()+","+employeeInterface.getOtherAllowance()+","+employeeInterface.getLifeInsurance()+","+employeeInterface.getGeneralProvidentFund()+","+employeeInterface.getIncomeTax()+","+employeeInterface.getOtherTax()+","+employeeInterface.getNetSalary()+",'"+employeeInterface.getDesignation()+"','"+employeeInterface.getLastLoginState()+"',"+employeeInterface.getAttendence()+","+employeeInterface.getLoginState()+")";
statement.executeUpdate(stmt);
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Can't Add Record !!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Can't Add record !!"+exception.getMessage());
}
}

public void update(EmployeeInterface employeeInterface) throws DAOException
{
try{
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="update Employee set password = '"+employeeInterface.getPassword()+"',set name = '"+employeeInterface.getName()+"', set address= '"+employeeInterface.getAddress()+"', set contact = "+employeeInterface.getContact()+", set gender='"+employeeInterface.getGender()+"', set bloodGroup ='"+employeeInterface.getBloodGroup()+"', set dob='"+employeeInterface.getDateOfBirth()+"',set city= '"+employeeInterface.getCity()+"', set state = '"+employeeInterface.getState()+"', set email = '"+employeeInterface.getEmail()+"',set meritalStatus = '"+employeeInterface.getMeritalStatus()+"', set age= "+employeeInterface.getAge()+",set dearness = "+employeeInterface.getDearnessAllowance()+", set cityCompensatory = "+employeeInterface.getCityCompensatoryAllowance()+", set overTime ="+employeeInterface.getOverTimeAllowance()+", set medical="+employeeInterface.getMedicalAllowance()+",set homeRent= "+employeeInterface.getHomeRentAllowance()+", set daily ="+employeeInterface.getDailyAllowance()+",set vehicle="+employeeInterface.getVehicleAllowance()+",set other ="+employeeInterface.getOtherAllowance()+",set lifeInsurance = "+employeeInterface.getLifeInsurance()+",set generalProvidentFund="+employeeInterface.getGeneralProvidentFund()+",set incomeTax ="+employeeInterface.getIncomeTax()+",set otherTax="+employeeInterface.getOtherTax()+",set salary="+employeeInterface.getNetSalary()+",set designation='"+employeeInterface.getDesignation()+"' where ID ="+employeeInterface.getID();
statement.executeUpdate(stmt);
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Can't update Record !! "+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Can't update record !!"+exception.getMessage());
}
}

public void refresh(long Id) throws DAOException
{
try{
if(exists(Id)==false) throw new DAOException("ID Does Not Exists!!");
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="update Employee set loginState="+00+" where ID = " +Id;
statement.executeUpdate(stmt);
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Can't Refresh !!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Can't Refresh !!"+exception.getMessage());
}
}

public void remove(long Id) throws DAOException
{
try{
if(exists(Id)==false) throw new DAOException("ID Does Not Exists!!");
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="delete from Employee where ID = " +Id;
statement.executeUpdate(stmt);
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Can't delete Record !!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Can't delete record !!"+exception.getMessage());
}
}

public HashMap<String,EmployeeInterface> get() throws DAOException
{
HashMap<String,EmployeeInterface> hashMaps;
try{
hashMaps=new HashMap<String,EmployeeInterface>();
ResultSet resultSet;
EmployeeInterface employee;
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="select * from Employee";
resultSet=statement.executeQuery(stmt);
while(resultSet.next()==true)
{
employee=new Employee();
employee.setID(resultSet.getLong("ID"));
employee.setPassword(resultSet.getString("password"));
employee.setName(resultSet.getString("name"));
employee.setAddress(resultSet.getString("address"));
employee.setContact(resultSet.getLong("contact"));
employee.setGender(resultSet.getString("gender"));
employee.setBloodGroup(resultSet.getString("bloodGroup"));
employee.setDateOfBirth(resultSet.getString("dob"));
employee.setCity(resultSet.getString("city"));
employee.setState(resultSet.getString("state"));
employee.setEmail(resultSet.getString("email"));
employee.setMeritalStatus(resultSet.getString("meritalStatus"));
employee.setAge(resultSet.getInt("age"));
employee.setDearnessAllowance(resultSet.getInt("dearness"));
employee.setCityCompensatoryAllowance(resultSet.getInt("cityCompensatory"));
employee.setOverTimeAllowance(resultSet.getInt("overTime"));
employee.setMedicalAllowance(resultSet.getInt("medical"));
employee.setHomeRentAllowance(resultSet.getInt("homeRent"));
employee.setDailyAllowance(resultSet.getInt("daily"));
employee.setVehicleAllowance(resultSet.getInt("vehicle"));
employee.setOtherAllowance(resultSet.getInt("other"));
employee.setLifeInsurance(resultSet.getInt("lifeInsurance"));
employee.setGeneralProvidentFund(resultSet.getInt("generalProvidentFund"));
employee.setIncomeTax(resultSet.getInt("incomeTax"));
employee.setOtherTax(resultSet.getInt("otherTax"));
employee.setNetSalary(resultSet.getDouble("salary"));
employee.setDesignation(resultSet.getString("designation"));
employee.setLastLoginState(resultSet.getString("lastLoginState"));
employee.setAttendence(resultSet.getInt("attendence"));
employee.setLoginState(resultSet.getInt("loginState"));
hashMaps.put(String.valueOf(employee.getID()),employee);
}
statement.close();
connection.close();
}
catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch Record !!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Unable to fetch Record !!"+exception.getMessage());
}
if(hashMaps.size()<=0) throw new DAOException("NO records..!!");

return hashMaps;
}

public EmployeeInterface get(long ID) throws DAOException
{
ResultSet resultSet;
EmployeeInterface employee=null;
try{
if(!exists(ID)==true) throw new DAOException("ID Does Not Exists!!");
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="select * from Employee";
resultSet=statement.executeQuery(stmt);
while(resultSet.next()==true)
{
if(resultSet.getLong("ID")==ID)
{
employee=new Employee();
employee.setID(resultSet.getLong("ID"));
employee.setPassword(resultSet.getString("password"));
employee.setName(resultSet.getString("name"));
employee.setAddress(resultSet.getString("address"));
employee.setContact(resultSet.getLong("contact"));
employee.setGender(resultSet.getString("gender"));
employee.setBloodGroup(resultSet.getString("bloodGroup"));
employee.setDateOfBirth(resultSet.getString("dob"));
employee.setCity(resultSet.getString("city"));
employee.setState(resultSet.getString("state"));
employee.setEmail(resultSet.getString("email"));
employee.setMeritalStatus(resultSet.getString("meritalStatus"));
employee.setAge(resultSet.getInt("age"));
employee.setDearnessAllowance(resultSet.getInt("dearness"));
employee.setCityCompensatoryAllowance(resultSet.getInt("cityCompensatory"));
employee.setOverTimeAllowance(resultSet.getInt("overTime"));
employee.setMedicalAllowance(resultSet.getInt("medical"));
employee.setHomeRentAllowance(resultSet.getInt("homeRent"));
employee.setDailyAllowance(resultSet.getInt("daily"));
employee.setVehicleAllowance(resultSet.getInt("vehicle"));
employee.setOtherAllowance(resultSet.getInt("other"));
employee.setLifeInsurance(resultSet.getInt("lifeInsurance"));
employee.setGeneralProvidentFund(resultSet.getInt("generalProvidentFund"));
employee.setIncomeTax(resultSet.getInt("incomeTax"));
employee.setOtherTax(resultSet.getInt("otherTax"));
employee.setNetSalary(resultSet.getDouble("salary"));
employee.setDesignation(resultSet.getString("designation"));
employee.setLastLoginState(resultSet.getString("lastLoginState"));
employee.setAttendence(resultSet.getInt("attendence"));
employee.setLoginState(resultSet.getInt("loginState"));
break;
}
}
statement.close();
connection.close();
}
catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch Record !!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Unable to fetch Record !!"+exception.getMessage());
}
return employee; 
}

public boolean exists(long ID) throws DAOException
{
try
{
if(new File(FILE_NAME).exists())
{
ResultSet resultSet;
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="select * from Employee";
resultSet=statement.executeQuery(stmt);
while(resultSet.next()==true)
{
if(resultSet.getLong("ID")==ID)
{
statement.close();
connection.close();
return true;
}
}
statement.close();
connection.close();
}
}
catch(SQLException sqlException)
{
throw new DAOException("Unable to fetch Records !!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Unable to fetch Records !!"+exception.getMessage());
}
return false;
}

public void sendMessage(long ID,String message) throws DAOException
{
try{
if(exists(ID)==false) throw new DAOException("  ID does Not Exists!!");
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="insert into Message values("+ID+",'"+message+"')";
statement.executeUpdate(stmt);
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException("Can't Send Message!!"+sqlException.getMessage());
}
catch(Exception exception)
{
throw new DAOException("Can't Send Message!!"+exception.getMessage());
}
}


}