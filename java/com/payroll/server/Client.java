package com.payroll.server;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import java.net.*;
import com.payroll.interfaces.*;
import com.payroll.exceptions.*;

public class Client 
{
ServerInterface server;
Registry registry;
public Client(String IP) throws Exception
{
try{
registry=LocateRegistry.getRegistry(IP,4000);
server=(ServerInterface)registry.lookup("Server");
}
catch(Exception e)
{
throw new DAOException("Server Problem : CLOSE "+ e.getMessage());
}
}

public boolean isRightAuthentication(String u,String p) throws RemoteException,DAOException
{
return server.isRightAuthentication(u,p);
}

public EmployeeInterface get(Long ID) throws RemoteException,DAOException
{
return server.get(ID);
}

public void updateInfo(Long ID,EmployeeInterface employee) throws RemoteException,DAOException
{
server.updateInfo(ID,employee);
}

public void sendMessage(Long ID,String message) throws RemoteException,DAOException
{
server.sendMessage(ID,message);
}

}