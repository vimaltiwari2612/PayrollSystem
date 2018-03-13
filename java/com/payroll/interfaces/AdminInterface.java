package com.payroll.interfaces;
import com.payroll.exceptions.*;
public interface AdminInterface 
{
public void setUsername(String username);
public void setPassword(String password);
public String getUsername();
public String getPassword();
public void setLastLogin(String time);
public String getLastLogin();
public void updatePassword(String password) throws DAOException;
public void updateUsername(String username) throws DAOException;
}