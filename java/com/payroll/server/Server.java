package com.payroll.server;
import com.payroll.dao.*;
import com.payroll.pl.*;
import com.payroll.model.*;
import com.payroll.interfaces.*;
import com.payroll.exceptions.*;
import com.payroll.server.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class Server extends UnicastRemoteObject implements ServerInterface,Serializable
{
EmployeeModel employeeModel;
EmployeeInterface employee;
Registry registry;
public Server() throws RemoteException
{
employeeModel=new EmployeeModel();
this.registry = LocateRegistry.createRegistry(4000);
this.registry.rebind("Server",this);
}


public void start() throws RemoteException,NotBoundException,AccessException
{
this.registry.rebind("Server",this);
}


public void stop() throws RemoteException,NotBoundException,AccessException
{
this.registry.unbind("Server");
UnicastRemoteObject.unexportObject(this,true);
}

public boolean isRightAuthentication(String username,String password) throws RemoteException,DAOException
{
employee=employeeModel.get(Long.parseLong(username));
if(employee.getPassword().trim().equals(password))
{
return true;
}
return false;
}

public void updateInfo(Long ID,EmployeeInterface employee) throws RemoteException,DAOException
{
employeeModel.remove(ID);
employeeModel.add(employee);
}

public void sendMessage(Long ID,String message) throws RemoteException,DAOException
{
employeeModel.sendMessage(ID,message);
}

public EmployeeInterface get(Long ID) throws RemoteException,DAOException
{
return employeeModel.get(ID);
}


}

