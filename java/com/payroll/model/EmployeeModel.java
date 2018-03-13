package com.payroll.model;
import java.util.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.payroll.connection.*;
import com.payroll.interfaces.*;
import com.payroll.dao.*;
import com.payroll.exceptions.*;
public class EmployeeModel extends JTextField
{
HashMap<String,EmployeeInterface> hashMaps;

public void add(EmployeeInterface employeeInterface) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDAO.add(employeeInterface);
hashMaps=employeeDAO.get();
}

public void sendMessage(Long ID,String message) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDAO.sendMessage(ID,message);
}
public void update(EmployeeInterface employeeInterface) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDAO.update(employeeInterface);
hashMaps=employeeDAO.get();
}

public void remove(long ID) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDAO.remove(ID);
try{
hashMaps=employeeDAO.get();
}catch(Exception exception)
{
hashMaps=new HashMap<String,EmployeeInterface>();
}
}

public void refresh(long ID) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDAO.refresh(ID);
}

public EmployeeInterface get(long ID) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
return employeeDAO.get(ID);
}

public HashMap<String,EmployeeInterface> get() throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
hashMaps=employeeDAO.get();
return hashMaps;
}


public boolean exists(long ID) throws DAOException
{
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
return employeeDAO.exists(ID);
}



public boolean checkInt(JTextField jTextField) 
{
String text=jTextField.getText();
char[] textArray;
int count=0;
int i=0;
try{
textArray=text.toCharArray();
while(count<textArray.length)
{
i=Integer.parseInt(String.valueOf(textArray[count]));
count++;
}
return true;
}catch(Exception exception)
{
return false;
}
}

public boolean checkChar(JTextField jTextField) 
{

String text=jTextField.getText();
char[] textArray;
int count=0;
String g="";
int i=0;
textArray=text.toCharArray();
while(count<textArray.length)
{
if((((int)textArray[count]>=32 && (int)textArray[count]<=47 )  || ((int)textArray[count]>=58 && (int)textArray[count]<=127 )))
{
return true ;
}
count++;
}
return false;
}

public boolean isEmpty(JTextField jTextField)
{
String text=jTextField.getText();
if(text.trim().equals(""))
return true;
else
return false;
}
}