package com.payroll.interfaces;
import com.payroll.model.*;
import com.payroll.dao.*;
import com.payroll.exceptions.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public interface ServerInterface extends Remote
{
public boolean isRightAuthentication(String username,String password) throws RemoteException,DAOException;
public void updateInfo(Long ID,EmployeeInterface employee) throws RemoteException,DAOException;
public EmployeeInterface get(Long ID) throws RemoteException,DAOException;
public void sendMessage(Long ID,String message) throws RemoteException,DAOException;
}