package com.payroll.pl.client;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import com.payroll.exceptions.*;
import com.payroll.model.*;
import com.payroll.server.*;
import com.payroll.interfaces.*;
import com.payroll.pl.client.*;
import com.payroll.pl.server.*;
import java.rmi.*;
import com.payroll.dao.*;

public class EditEmployee extends JFrame implements ActionListener,ItemListener
{
private EmployeeInterface employee;
private EmployeeModel employeeModel;

private JLabel nameLabel,phoneNumberLabel,addressLabel,genderLabel,designationLabel,bloodGroupLabel,dobLabel,dateLabel,monthLabel,passwordLabel,reTypePasswordLabel,IDLabel,cityLabel,stateLabel,yearLabel,margineLabel,emailLabel,ageLabel,
officeWorkLabel,meritalStatusLabel,allowanceLabel,dearnessAllowanceLabel,overTimeAllowanceLabel,fixedMedicalAllowanceLabel,cityCompensatoryAllowanceLabel,otherAllowanceLabel,homeRentAllowanceLabel,vehicleAllowanceLabel,dailyAllowanceLabel,lifeInsuranceLabel,generalProvidentFundLabel,incomeTaxLabel,otherTaxLabel,deductionLabel,totalSalaryLabel;
private JButton add,exit,reset,netSalaryButton;
private JCheckBox dearnessCheck,overTimeCheck,fixedMedicalCheck,cityCompensatoryCheck,homeRentCheck,otherCheck,dailyCheck,vehicleCheck;
private JTextField name,phoneNumber,address,year,ID,city,state,email,age,otherPosition,overTime,daily,vehicle,otherAllowance,homeRent,fixedMedical,dearness,cityCompensatory,netSalary,lifeInsurance,generalProvidentFund,incomeTax,otherTax,totalSalary;
private JPasswordField password,reTypePassword;
private JComboBox designation,bloodGroup,date,month,gender,meritalStatus;
private Container container;
private MainMenuClient mainMenuClient;
private Client client;
private Long Id;
public EditEmployee(MainMenuClient mainMenuClient,EmployeeInterface employee,Client client,Long Id)
{
this.mainMenuClient=mainMenuClient;
this.client=client;
this.Id=Id;
this.employee=employee;
initComponents();
}

public void initComponents(){
this.setTitle("Edit Details");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_MODULE)).getImage());
this.totalSalary=new JTextField(10);
this.totalSalaryLabel=new JLabel("Salary");
this.totalSalaryLabel.setOpaque(true);
this.totalSalaryLabel.setBackground(new Color(137,177,78));
deductionLabel=new JLabel("Deductions");
netSalaryButton=new JButton("Net Salary");
netSalary=new JTextField();
netSalary.setEditable(false);
dearness=new JTextField();
cityCompensatory=new JTextField();
overTime=new JTextField();
fixedMedical=new JTextField();
homeRent=new JTextField();
vehicle=new JTextField();
daily=new JTextField();
otherAllowance=new JTextField();
incomeTax=new JTextField();
otherTax=new JTextField();
generalProvidentFund=new JTextField();
lifeInsurance=new JTextField();
incomeTaxLabel=new JLabel("Income Tax");
otherTaxLabel=new JLabel("Other Tax");
generalProvidentFundLabel=new JLabel("General ProvidentFund");
lifeInsuranceLabel=new JLabel("Life Insurance");
dearnessCheck=new JCheckBox();
cityCompensatoryCheck=new JCheckBox();
overTimeCheck=new JCheckBox();
fixedMedicalCheck=new JCheckBox();
homeRentCheck=new JCheckBox();
vehicleCheck=new JCheckBox();
dailyCheck=new JCheckBox();
otherCheck=new JCheckBox();
dearnessCheck.setOpaque(true);
dearnessCheck.setBackground(new Color(137,177,78));
cityCompensatoryCheck.setOpaque(true);
overTimeCheck.setOpaque(true);
fixedMedicalCheck.setOpaque(true);
homeRentCheck.setOpaque(true);
vehicleCheck.setOpaque(true);
dailyCheck.setOpaque(true);
otherCheck.setOpaque(true);
cityCompensatoryCheck.setBackground(new Color(137,177,78));
overTimeCheck.setBackground(new Color(137,177,78));
fixedMedicalCheck.setBackground(new Color(137,177,78));
vehicleCheck.setBackground(new Color(137,177,78));
dailyCheck.setBackground(new Color(137,177,78));
otherCheck.setBackground(new Color(137,177,78));
homeRentCheck.setBackground(new Color(137,177,78));
dearnessAllowanceLabel=new JLabel("Dearness");
cityCompensatoryAllowanceLabel=new JLabel("City Compensatory");
overTimeAllowanceLabel=new JLabel("Over Time");
fixedMedicalAllowanceLabel=new JLabel("Medical");
homeRentAllowanceLabel=new JLabel("Home Rent");
vehicleAllowanceLabel=new JLabel("Vehicle");
dailyAllowanceLabel=new JLabel("Daily");
otherAllowanceLabel=new JLabel("Other");
margineLabel=new JLabel("");
String genderSet[]={"Male","Female"};
String meritalStatusSet[]={"Married","Unmarried"};
gender=new JComboBox(genderSet);
meritalStatus=new JComboBox(meritalStatusSet);
officeWorkLabel=new JLabel("Work Details");
margineLabel.setOpaque(true);
margineLabel.setBackground(Color.black);
emailLabel=new JLabel("Email");
ageLabel=new JLabel("Age");
email=new JTextField();
age=new JTextField(2);
container=getContentPane();
container.setBackground(new Color(137,177,78));
String designationSet[]={"Managing Director","General Manager","Asst.GM","Manager","Asst. Manager","Senior Coordinator","Junior Coordinator","Supervisor","Senior Assistant","Junior Assistant","Office Assistant","Sr.Executive","Executive","Jr.Executive","Trainee","other.."};
String dateSet[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
String bloodGroupSet[]={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
String monthSet[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
bloodGroup=new JComboBox(bloodGroupSet);
bloodGroup.setSelectedIndex(0);
date=new JComboBox(dateSet);
date.setSelectedIndex(0);
meritalStatus.setSelectedIndex(1);
gender.setSelectedIndex(0);
otherPosition=new JTextField(20);
month=new JComboBox(monthSet);
month.setSelectedIndex(0);
add=new JButton("Save",new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
reset=new JButton("Reset",new ImageIcon(this.getClass().getResource(GlobalResources.RESET_BUTTON)));
name=new JTextField(25);
phoneNumberLabel=new JLabel("Contact No.");
phoneNumber=new JTextField(10);
address=new JTextField(100);
nameLabel=new JLabel("Full Name");
addressLabel=new JLabel("Full Address");
year=new JTextField(4);
ID=new JTextField(20);
state=new JTextField(20);
city=new JTextField(20);
stateLabel=new JLabel("State");
passwordLabel=new JLabel("Password");
reTypePasswordLabel=new JLabel("Re-Type Password");
password=new JPasswordField(15);
reTypePassword=new JPasswordField(15);
genderLabel=new JLabel("Gender");
IDLabel=new JLabel("Employee ID");
designationLabel=new JLabel("Designation");
bloodGroupLabel=new JLabel("Blood Group");
dobLabel=new JLabel("Date Of Birth");
dateLabel=new JLabel("Date");
monthLabel=new JLabel("Month");
yearLabel=new JLabel("Year");
cityLabel=new JLabel("City");
designation=new JComboBox(designationSet);
designation.setSelectedIndex(0);
meritalStatusLabel=new JLabel("Marital Status");
allowanceLabel= new JLabel("Allowances");

container.setLayout(null);
nameLabel.setBounds(10,10,100,30);
name.setBounds(130,10,130,30);
addressLabel.setBounds(10,50,100,30);
address.setBounds(130,50,180,30);
phoneNumberLabel.setBounds(10,90,100,30);
phoneNumber.setBounds(130,90,100,30);
genderLabel.setBounds(10,130,100,30);
gender.setBounds(130,130,70,30);
bloodGroupLabel.setBounds(10,170,100,30);
bloodGroup.setBounds(130,170,100,30);
dobLabel.setBounds(10,210,100,30);
dateLabel.setBounds(130,210,50,30);
monthLabel.setBounds(190,210,50,30);
yearLabel.setBounds(250,210,100,30);
date.setBounds(130,240,50,30);
month.setBounds(190,240,50,30);
year.setBounds(250,240,70,30);
cityLabel.setBounds(10,280,100,30);
city.setBounds(130,280,100,30);
stateLabel.setBounds(10,320,100,30);
state.setBounds(130,320,100,30);
margineLabel.setBounds(350,0,2,620);
emailLabel.setBounds(10,380,100,30);
email.setBounds(130,380,150,30);
ageLabel.setBounds(10,420,100,30);
age.setBounds(130,420,100,30);
meritalStatusLabel.setBounds(10,460,100,30);
meritalStatus.setBounds(130,460,100,30);
add.setBounds(15,540,100,30);
reset.setBounds(130,540,100,30);
exit.setBounds(245,540,100,30);

container.add(nameLabel);
container.add(name);
container.add(addressLabel);
container.add(address);
container.add(phoneNumberLabel);
container.add(phoneNumber);
container.add(genderLabel);
container.add(gender);
container.add(bloodGroupLabel);
container.add(bloodGroup);
container.add(dobLabel);
container.add(dateLabel);
container.add(monthLabel);
container.add(yearLabel);
container.add(date);
container.add(month);
container.add(year);
container.add(cityLabel);
container.add(city);
container.add(stateLabel);
container.add(state);
container.add(margineLabel);
container.add(emailLabel);
container.add(email);
container.add(ageLabel);
container.add(meritalStatusLabel);
container.add(meritalStatus);
container.add(age);
container.add(add);
container.add(reset);
container.add(exit);
officeWorkLabel.setBounds(510,5,200,20);
IDLabel.setBounds(360,30,100,30);
ID.setBounds(490,30,100,30);
passwordLabel.setBounds(360,70,100,30);
password.setBounds(490,70,100,30);
reTypePasswordLabel.setBounds(360,110,130,30);
reTypePassword.setBounds(490,110,100,30);
totalSalaryLabel.setBounds(650,120,100,30);
designationLabel.setBounds(360,150,100,30);
designation.setBounds(490,150,130,30);
otherPosition.setBounds(490,190,130,30);
totalSalary.setBounds(630,150,100,30);
allowanceLabel.setBounds(510,222,200,20);
deductionLabel.setBounds(800,222,100,20);
dearnessAllowanceLabel.setBounds(360,240,100,30);
lifeInsuranceLabel.setBounds(700,240,100,30);
dearnessCheck.setBounds(490,245,20,20);
dearness.setBounds(560,240,100,30);
lifeInsurance.setBounds(830,240,100,30);
cityCompensatoryAllowanceLabel.setBounds(360,280,120,30);
generalProvidentFundLabel.setBounds(700,280,130,30);
generalProvidentFund.setBounds(830,280,100,30);
cityCompensatoryCheck.setBounds(490,285,20,20);
cityCompensatory.setBounds(560,280,100,30);
overTimeAllowanceLabel.setBounds(360,320,100,30);
incomeTaxLabel.setBounds(700,320,100,30);
incomeTax.setBounds(830,320,100,30);

overTimeCheck.setBounds(490,325,20,20);
overTime.setBounds(560,320,100,30);
fixedMedicalAllowanceLabel.setBounds(360,360,100,30);
otherTaxLabel.setBounds(700,360,100,30);
otherTax.setBounds(830,360,100,30);

fixedMedicalCheck.setBounds(490,365,20,20);
fixedMedical.setBounds(560,360,100,30);
homeRentAllowanceLabel.setBounds(360,400,100,30);
homeRentCheck.setBounds(490,405,20,20);
homeRent.setBounds(560,400,100,30);
vehicleAllowanceLabel.setBounds(360,440,100,30);
vehicleCheck.setBounds(490,445,20,20);
vehicle.setBounds(560,440,100,30);

dailyAllowanceLabel.setBounds(360,480,100,30);
dailyCheck.setBounds(490,485,20,20);
daily.setBounds(560,480,100,30);

otherAllowanceLabel.setBounds(360,520,100,30);
otherCheck.setBounds(490,525,20,20);
otherAllowance.setBounds(560,520,100,30);
netSalaryButton.setBounds(400,560,100,30);
netSalary.setBounds(510,560,100,30);
container.add(officeWorkLabel);
container.add(IDLabel);
container.add(ID);
container.add(passwordLabel);
container.add(password);
container.add(reTypePasswordLabel);
container.add(reTypePassword);
container.add(designationLabel);
container.add(designation);
container.add(otherPosition);
container.add(totalSalary);
container.add(totalSalaryLabel);
container.add(allowanceLabel);
container.add(deductionLabel);
container.add(lifeInsuranceLabel);
container.add(otherTaxLabel);
container.add(incomeTaxLabel);
container.add(lifeInsurance);
container.add(otherTax);
container.add(incomeTax);
container.add(generalProvidentFundLabel);
container.add(generalProvidentFund);

container.add(dearnessAllowanceLabel);
container.add(cityCompensatoryAllowanceLabel);
container.add(overTimeAllowanceLabel);
container.add(fixedMedicalAllowanceLabel);
container.add(homeRentAllowanceLabel);
container.add(dailyAllowanceLabel);
container.add(vehicleAllowanceLabel);
container.add(otherAllowanceLabel);
container.add(dearnessCheck);
container.add(cityCompensatoryCheck);
container.add(overTimeCheck);
container.add(homeRentCheck);
container.add(dailyCheck);
container.add(vehicleCheck);
container.add(otherCheck);
container.add(fixedMedicalCheck);

container.add(otherAllowance);
container.add(homeRent);
container.add(dearness);
container.add(fixedMedical);
container.add(daily);
container.add(vehicle);
container.add(cityCompensatory);
container.add(overTime);
container.add(netSalaryButton);
container.add(netSalary);
this.mainMenuClient.setVisible(false);
this.addListeners();
this.resetAll();
setResizable(false);
setSize(353,640);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
employeeModel=new EmployeeModel();
this.mainMenuClient.setVisible(false);
addWindowListener(new WindowAdapter()
{
EditEmployee m=EditEmployee.this;
public void windowClosing(WindowEvent we)
{
m.dispose();
m.mainMenuClient.setVisible(true);
}
});

loadDefaults(this.employee,dateSet,monthSet,bloodGroupSet,genderSet,meritalStatusSet);
}



public void loadDefaults(EmployeeInterface employee,String[] dateSet,String[] monthSet,String[] bloodGroupSet,String[] genderSet,String[] meritalStatusSet)
{
String d="",m="",y="",b="";
b=employee.getBloodGroup();
name.setText(employee.getName());
age.setText(String.valueOf(employee.getAge()));
state.setText(employee.getState());
city.setText(employee.getCity());
phoneNumber.setText(String.valueOf(employee.getContact()));
address.setText(employee.getAddress());
String dob=employee.getDateOfBirth();
StringTokenizer st=new StringTokenizer(dob,"/");
while(st.hasMoreTokens())
{
d=st.nextToken();
m=st.nextToken();
y=st.nextToken();
}
for(int i=0;;i++)
{
if(dateSet[i].equals(d))
{
date.setSelectedIndex(i);
break;
}
}
for(int i=0;;i++)
{
if(bloodGroupSet[i].equals(b))
{
bloodGroup.setSelectedIndex(i);
break;
}
}
for(int i=0;;i++)
{
if(monthSet[i].equals(m))
{
month.setSelectedIndex(i);
break;
}
}
for(int i=0;;i++)
{
if(meritalStatusSet[i].equals(employee.getMeritalStatus()))
{

meritalStatus.setSelectedIndex(i);
break;
}
}
for(int i=0;;i++)
{
if(genderSet[i].equals(employee.getGender()))
{
gender.setSelectedIndex(i);
break;
}
}
year.setText(y);
email.setText(employee.getEmail());


}


public void addListeners()
{
add.addActionListener(this);
reset.addActionListener(this);
exit.addActionListener(this);
designation.addItemListener(this);
netSalaryButton.addActionListener(this);
dearnessCheck.addItemListener(this);
cityCompensatoryCheck.addItemListener(this);
overTimeCheck.addItemListener(this);
vehicleCheck.addItemListener(this);
dailyCheck.addItemListener(this);
otherCheck.addItemListener(this);
homeRentCheck.addItemListener(this);
fixedMedicalCheck.addItemListener(this);

}

public void itemStateChanged(ItemEvent ie)
{
if(designation.getSelectedItem().equals("other..")==true)
{
otherPosition.setVisible(true);
}
else
{
otherPosition.setVisible(false);
}

if(dearnessCheck.isSelected())
{
dearness.setEditable(true);
}
else
{

dearness.setText("0");

dearness.setEditable(false);
}


if(otherCheck.isSelected())
{
otherAllowance.setEditable(true);
}
else
{

otherAllowance.setText("0");
otherAllowance.setEditable(false);
}


if(dailyCheck.isSelected())
{
daily.setEditable(true);
}
else
{

daily.setText("0");

daily.setEditable(false);
}


if(cityCompensatoryCheck.isSelected())
{
cityCompensatory.setEditable(true);
}
else
{

cityCompensatory.setText("0");

cityCompensatory.setEditable(false);
}


if(homeRentCheck.isSelected())
{
homeRent.setEditable(true);
}
else
{

homeRent.setText("0");
homeRent.setEditable(false);
}


if(fixedMedicalCheck.isSelected())
{
fixedMedical.setEditable(true);
}
else
{

fixedMedical.setText("0");

fixedMedical.setEditable(false);
}

if(vehicleCheck.isSelected())
{
vehicle.setEditable(true);
}
else
{

vehicle.setText("0");

vehicle.setEditable(false);
}

if(overTimeCheck.isSelected())
{
overTime.setEditable(true);
}
else
{

overTime.setText("0");

overTime.setEditable(false);
}


}
public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==add)
{
if(necesarryChecks())
{
try
{
totalAmount();
this.addAll();
}catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Notification",JOptionPane.INFORMATION_MESSAGE);
}
}
}

if(o==reset)
{
this.resetAll();
JOptionPane.showMessageDialog(this,"All Entries are Cleared & Reseted!!","Notification",JOptionPane.INFORMATION_MESSAGE);
}

if(o==exit)
{
this.dispose();
this.mainMenuClient.setVisible(true);
}

if(o==netSalaryButton)
{
this.totalAmount();
}
}

public boolean necesarryChecks()
{
if(employeeModel.isEmpty(name))
{
name.requestFocus();
JOptionPane.showMessageDialog(this,"Name Field is Empty","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.checkChar(name)==false)
{
name.requestFocus();
JOptionPane.showMessageDialog(this,"Name Field -only Characters Are allowed","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.isEmpty(address))
{
address.requestFocus();
JOptionPane.showMessageDialog(this,"Address Field Is empty","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.isEmpty(phoneNumber))
{
phoneNumber.requestFocus();
JOptionPane.showMessageDialog(this,"Contact Field is Empty","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.checkInt(phoneNumber)==false)
{
phoneNumber.requestFocus();
JOptionPane.showMessageDialog(this,"Contact Field - only Numbers are allowed","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}

if(phoneNumber.getText().trim().length()!=10 )
{
phoneNumber.requestFocus();

JOptionPane.showMessageDialog(this,"Phone Number is not correctly typed - 10 digits","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}


if(employeeModel.isEmpty(city))
{
city.requestFocus();
JOptionPane.showMessageDialog(this,"City Field is Empty","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.checkChar(city)==false)
{
city.requestFocus();
JOptionPane.showMessageDialog(this,"City Field-only Characters are allowed","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.isEmpty(state))
{
state.requestFocus();
JOptionPane.showMessageDialog(this,"State Field is Empty","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.checkChar(state)==false)
{
state.requestFocus();
JOptionPane.showMessageDialog(this,"City Field -only Characters are allowed","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.isEmpty(age))
{
age.requestFocus();
JOptionPane.showMessageDialog(this,"Age Field is Empty","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}
if(employeeModel.checkInt(age)==false)
{
age.requestFocus();
JOptionPane.showMessageDialog(this,"Age Field -only Numbers are allowed","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}

if(age.getText().trim().length()!=2)
{
age.requestFocus();
JOptionPane.showMessageDialog(this,"Age is not correctly typed - 2digits","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}

if(employeeModel.checkInt(year)==false)
{
year.requestFocus();
JOptionPane.showMessageDialog(this,"Year Field -only Numbers are allowed","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}

if(year.getText().trim().length()!=4)
{
year.requestFocus();
JOptionPane.showMessageDialog(this,"Year is not correctly typed - 4 digits","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}


return true;
}


public void totalAmount()
{
Double amount;
amount=(Double.parseDouble(totalSalary.getText())+Integer.parseInt(daily.getText())+Integer.parseInt(cityCompensatory.getText())+Integer.parseInt(dearness.getText())+Integer.parseInt(overTime.getText())+Integer.parseInt(fixedMedical.getText())+Integer.parseInt(homeRent.getText())+Integer.parseInt(otherAllowance.getText())+Integer.parseInt(vehicle.getText()))-(Integer.parseInt(lifeInsurance.getText())+Integer.parseInt(generalProvidentFund.getText())+Integer.parseInt(otherTax.getText())+Integer.parseInt(incomeTax.getText()));
netSalary.setText(String.valueOf(amount));
}

public void addAll() throws DAOException,RemoteException
{
employee.setName(name.getText());
employee.setAddress(address.getText());
employee.setContact(Long.parseLong(phoneNumber.getText()));
employee.setState(state.getText());
employee.setMeritalStatus(String.valueOf(meritalStatus.getItemAt(meritalStatus.getSelectedIndex())));
employee.setGender(String.valueOf(gender.getItemAt(gender.getSelectedIndex())));
employee.setBloodGroup(String.valueOf(bloodGroup.getItemAt(bloodGroup.getSelectedIndex())));
employee.setDateOfBirth(String.valueOf(date.getItemAt(date.getSelectedIndex()))+"/"+month.getSelectedItem()+"/"+year.getText());
employee.setCity(city.getText());
employee.setEmail(email.getText());
employee.setAge(Integer.parseInt(age.getText()));
employee.setID(Id);
client.updateInfo(Id,employee);
JOptionPane.showMessageDialog(this,"Record Updated succesfully!!","Notification",JOptionPane.INFORMATION_MESSAGE);
}

public void resetAll()
{
name.setText("");
address.setText("");
phoneNumber.setText("");
ID.setText("");
city.setText("");
state.setText("");
password.setText("");
reTypePassword.setText("");
year.setText("");
date.setSelectedIndex(0);
month.setSelectedIndex(0);
meritalStatus.setSelectedIndex(1);
gender.setSelectedIndex(0);
age.setText("");
email.setText("");
designation.setSelectedIndex(0);
dearnessCheck.setSelected(false);
cityCompensatoryCheck.setSelected(false);
overTimeCheck.setSelected(false);
fixedMedicalCheck.setSelected(false);
homeRentCheck.setSelected(false);
vehicleCheck.setSelected(false);
dailyCheck.setSelected(false);
otherCheck.setSelected(false);
otherPosition.setVisible(false);
dearness.setEditable(false);
cityCompensatory.setEditable(false);
overTime.setEditable(false);
fixedMedical.setEditable(false);
homeRent.setEditable(false);
vehicle.setEditable(false);
daily.setEditable(false);
daily.setText("0");
dearness.setText("0");
cityCompensatory.setText("0");
overTime.setText("0");
fixedMedical.setText("0");
homeRent.setText("0");
vehicle.setText("0");
otherAllowance.setText("0");
otherAllowance.setEditable(false);
lifeInsurance.setText("0");
otherTax.setText("0");
incomeTax.setText("0");
generalProvidentFund.setText("0");
netSalary.setText("0.0");
totalSalary.setText("0.0");
bloodGroup.setSelectedIndex(0);

}

}