package com.payroll.interfaces;
import java.util.*;
import com.payroll.exceptions.*;
public interface EmployeeDAOInterface 
{
public String FILE_NAME="employee.db";
public void add(EmployeeInterface employeeInterface) throws DAOException;
public void update(EmployeeInterface employeeInterface) throws DAOException;
public void remove(long Id) throws DAOException;
public void refresh(long Id) throws DAOException;
public HashMap<String,EmployeeInterface> get() throws DAOException;
public EmployeeInterface get(long ID) throws DAOException;
public boolean exists(long ID) throws DAOException;
public void sendMessage(long ID,String message) throws DAOException;

}