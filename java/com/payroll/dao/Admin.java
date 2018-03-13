package com.payroll.dao;
import com.payroll.interfaces.*;
import com.payroll.exceptions.*;
import com.payroll.connection.*;

import java.sql.*;

public class Admin implements AdminInterface
{

private String username,password,time;
public Admin()
{
}

public void setLastLogin(String time)
{
this.time=time;
}

public String getLastLogin()
{
return time;
}

public void setUsername(String username)
{
this.username=username;
}

public void setPassword(String password)
{
this.password=password;
}

public String getUsername()
{
return this.username;
}

public String getPassword()
{
return password;
}


public void updateUsername(String username) throws DAOException
{
try{
this.username=username;
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="update Admin set username='"+this.username+"' where number=1";
statement.executeUpdate(stmt);
statement.close();
connection.close();
}
catch(Exception exception)
{
throw new DAOException("Can't change Username!!"+exception.getMessage());
}
}


public void updatePassword(String password) throws DAOException
{
try{
this.password=password;
Connection connection=(new AdminConnection()).getAdminConnection();
Statement statement=connection.createStatement();
String stmt="update Admin set password='"+this.password+"' where number=1";
statement.executeUpdate(stmt);
statement.close();
connection.close();
}
catch(Exception exception)
{
throw new DAOException("Can't change Password!!"+exception.getMessage());
}
}



}