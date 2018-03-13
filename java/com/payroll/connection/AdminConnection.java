package com.payroll.connection;
import java.sql.*;
import com.payroll.exceptions.*;
import com.payroll.interfaces.*;

public class AdminConnection implements AdminConnectionInterface
{
Connection connection;
public Connection getAdminConnection() throws DAOException
{
try{
Class.forName("org.sqlite.JDBC");
connection=DriverManager.getConnection("jdbc:sqlite:employee.db");
}
catch(SQLException sqlException)
{
throw new DAOException("Can't create Connection!!"+sqlException.getMessage());
}

catch(Exception exception)
{
throw new DAOException("Can't create Connection!!"+exception.getMessage());
}
return connection;

}
}