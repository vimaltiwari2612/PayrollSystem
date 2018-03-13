package com.payroll.interfaces;
import com.payroll.interfaces.*;
import com.payroll.exceptions.*;

import java.sql.*;
public interface AdminConnectionInterface
{
public Connection getAdminConnection() throws DAOException;
}