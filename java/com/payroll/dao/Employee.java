package com.payroll.dao;
import com.payroll.interfaces.*;
import java.io.*;


public class Employee implements EmployeeInterface,Serializable
{
private String name,address,gender,email,meritalStatus,dob,state,city,bloodGroup,password,designation,time;
private int age,dearness,cityCompensatory,overTime,medical,homeRent,daily,vehicle,other,lifeInsurance,generalProvidentFund,incomeTax,otherTax,count,bit;
private long ID,contact;
private double salary;
private Object object;


public void setLastLoginState(String time)
{
this.time=time;
}

public void setAttendence(int count)
{
this.count=count;
}

public void setLoginState(int bit)
{
this.bit=bit;
}

public void setName(String name)
{
this.name=name;
}
public void setAddress(String address)
{
this.address=address;
}
public void setContact(long contact)
{
this.contact=contact;
}
public void setGender(String gender)
{
this.gender=gender;
}
public void setAge(int age)
{
this.age=age;
}
public void setEmail(String email)
{
this.email=email;
}
public void setMeritalStatus(String meritalStatus)
{
this.meritalStatus=meritalStatus;
}
public void setDateOfBirth(String dob)
{
this.dob=dob;
}
public void setState(String state)
{
this.state=state;

}
public void setCity(String city)
{
this.city=city;
}
public void setBloodGroup(String bloodGroup)
{
this.bloodGroup=bloodGroup;
}
public void setID(long ID)
{
this.ID=ID;
}
public void setPassword(String password)
{
this.password=password;
}
public void setDesignation(String designation)
{
this.designation=designation;
}

public void setDearnessAllowance(int dearness)
{
this.dearness=dearness;
}

public void setCityCompensatoryAllowance(int cityCompensatory)
{
this.cityCompensatory=cityCompensatory;
}
public void setOtherAllowance(int other)
{
this.other=other;
}
public void setDailyAllowance(int daily)
{
this.daily=daily;
}
public void setMedicalAllowance(int medical)
{
this.medical=medical;
}

public void setHomeRentAllowance(int homeRent)
{
this.homeRent=homeRent;
}
public void setVehicleAllowance(int vehicle)
{
this.vehicle=vehicle;
}
public void setOverTimeAllowance(int overTime)
{
this.overTime=overTime;
}
public void setLifeInsurance(int lifeInsurance)
{
this.lifeInsurance=lifeInsurance;
}
public void setGeneralProvidentFund(int generalProvidentFund)
{
this.generalProvidentFund=generalProvidentFund;
}
public void setIncomeTax(int incomeTax)
{
this.incomeTax=incomeTax;
}
public void setOtherTax(int otherTax)
{
this.otherTax=otherTax;
}

public void setDeduction(int lifeInsurance,int generalProvidentFind, int incomeTax,int otherTax )
{
this.lifeInsurance=lifeInsurance;
this.generalProvidentFund=generalProvidentFund;
this.incomeTax=incomeTax;
this.otherTax=otherTax;

}

public String getLastLoginState()
{
return this.time;
}

public int getAttendence()
{
return this.count;
}

public int getLoginState()
{
return this.bit;
}


public int getLifeInsurance()
{
return this.lifeInsurance;
}

public int getDearnessAllowance()
{
return this.dearness;
}

public int getOtherAllowance()
{
return this.other;
}
public int getHomeRentAllowance()
{
return this.homeRent;
}
public int getDailyAllowance()
{
return this.daily;
}
public int getCityCompensatoryAllowance()
{
return this.cityCompensatory;
}
public int getVehicleAllowance()
{
return this.vehicle;
}
public int getOverTimeAllowance()
{
return this.overTime;
}

public int getMedicalAllowance()
{
return this.medical;
}



public int getGeneralProvidentFund()
{
return this.generalProvidentFund;
}


public int getIncomeTax()
{
return this.incomeTax;
}


public int getOtherTax()
{
return this.otherTax;
}




public void setNetSalary(double salary)
{
this.salary=salary;
}
public String getName()
{
return this.name;
}

public String getAddress()
{
return this.address;
}
public long getContact()
{
return this.contact;
}

public String getGender()
{
return this.gender;
}
public int getAge()
{
return this.age;
}
public String getMeritalStatus()
{
return this.meritalStatus;
}
public String getState()
{
return this.state;
}
public String getCity()
{
return this.city;
}
public String getPassword()
{
return this.password;
}
public long getID()
{
return this.ID;
}
public double getNetSalary()
{
return this.salary;
}
public int getAllowance()
{
return (this.dearness+this.cityCompensatory+this.medical+this.vehicle+this.daily+this.other+this.overTime+this.homeRent);
}
public int getDeduction()
{
return (this.lifeInsurance+this.generalProvidentFund+this.incomeTax+this.otherTax);
}
public String getBloodGroup()
{
return this.bloodGroup;
}
public String getEmail()
{
return this.email;
}
public String getDateOfBirth()
{
return this.dob;
}
public String getDesignation()
{
return this.designation;
}

public boolean equals(Object object)
{
if(!(object instanceof Employee)) return false;
Employee employee=(Employee)object;
return String.valueOf(this.ID).equalsIgnoreCase(String.valueOf(employee.ID));

}

public String toString()
{
return this.name;
}

public int compareTo(EmployeeInterface employeeInterface)
{
return String.valueOf(this.ID).compareTo(String.valueOf(employeeInterface.getID()));
}

}