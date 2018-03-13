package com.payroll.pl.server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.payroll.exceptions.*;
import com.payroll.model.*;
import com.payroll.interfaces.*;
import java.util.*;

import com.payroll.dao.*;

public class EditEmployee extends JFrame implements ActionListener,ItemListener
{
private MainMenu mainMenu;
private EmployeeInterface employee;
private EmployeeModel employeeModel;
private HashMap<String,EmployeeInterface> hashMaps;
private JLabel nameLabel,phoneNumberLabel,addressLabel,genderLabel,designationLabel,bloodGroupLabel,dobLabel,dateLabel,monthLabel,passwordLabel,reTypePasswordLabel,IDLabel,cityLabel,stateLabel,yearLabel,margineLabel,emailLabel,ageLabel,
officeWorkLabel,meritalStatusLabel,allowanceLabel,dearnessAllowanceLabel,overTimeAllowanceLabel,fixedMedicalAllowanceLabel,cityCompensatoryAllowanceLabel,otherAllowanceLabel,homeRentAllowanceLabel,vehicleAllowanceLabel,dailyAllowanceLabel,lifeInsuranceLabel,generalProvidentFundLabel,incomeTaxLabel,otherTaxLabel,deductionLabel,totalSalaryLabel;
private JButton save,exit,edit,netSalaryButton,find;
private JCheckBox dearnessCheck,overTimeCheck,fixedMedicalCheck,cityCompensatoryCheck,homeRentCheck,otherCheck,dailyCheck,vehicleCheck;
private JTextField name,phoneNumber,address,year,ID,city,state,email,age,otherPosition,overTime,daily,vehicle,otherAllowance,homeRent,fixedMedical,dearness,cityCompensatory,netSalary,lifeInsurance,generalProvidentFund,incomeTax,otherTax,totalSalary;
private JComboBox IDBox,designation;
private Container container;
private Set<String> keys;
private String IDSet[];
private String designationSet[]={"Managing Director","General Manager","Asst.GM","Manager","Asst. Manager","Senior Coordinator","Junior Coordinator","Supervisor","Senior Assistant","Junior Assistant","Office Assistant","Sr.Executive","Executive","Jr.Executive","Trainee","other.."};

private int i=0;
public EditEmployee(MainMenu mainMenu)
{
this.mainMenu=mainMenu;
employeeModel=new EmployeeModel();
try{
hashMaps=employeeModel.get();
IDSet=new String[hashMaps.size()];
keys=hashMaps.keySet();
for(String key : keys)
{
IDSet[i]=key;
i++;
}
this.initComponents();
}
catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Notification",JOptionPane.INFORMATION_MESSAGE);
this.dispose();
}
}

public void initComponents()
{
container=getContentPane();
this.setTitle("Edit Employee Settings");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_MODULE)).getImage());
this.mainMenu.setVisible(false);
netSalaryButton=new JButton("Net Salary",new ImageIcon(this.getClass().getResource(GlobalResources.NET_SALARY_BUTTON)));
save=new JButton("Save",new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
edit=new JButton("Edit",new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_BUTTON)));
find=new JButton("Find",new ImageIcon(this.getClass().getResource(GlobalResources.SEARCH_BUTTON)));
netSalary=new JTextField("0.0");
otherPosition=new JTextField();
designation=new JComboBox(designationSet);
container.setBackground(new Color(137,177,78));
IDLabel=new JLabel("Select an ID ");
IDLabel.setOpaque(true);
IDLabel.setBackground(new Color(137,177,78));
nameLabel=new JLabel("Name");
name=new JTextField();
phoneNumber=new JTextField();
email=new JTextField();
nameLabel.setOpaque(true);
nameLabel.setBackground(new Color(137,177,78));
phoneNumberLabel=new JLabel("Contact");
phoneNumberLabel.setOpaque(true);
phoneNumberLabel.setBackground(new Color(137,177,78));
emailLabel=new JLabel("Email");
emailLabel.setOpaque(true);
emailLabel.setBackground(new Color(137,177,78));
designationLabel=new JLabel("Designation");
totalSalaryLabel=new JLabel("Salary");
otherPosition=new JTextField();
totalSalary=new JTextField();
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
deductionLabel=new JLabel("Deductions");
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
allowanceLabel=new JLabel("Allowances");
dearnessAllowanceLabel=new JLabel("Dearness");
cityCompensatoryAllowanceLabel=new JLabel("City Compensatory");
overTimeAllowanceLabel=new JLabel("Over Time");
fixedMedicalAllowanceLabel=new JLabel("Medical");
homeRentAllowanceLabel=new JLabel("Home Rent");
vehicleAllowanceLabel=new JLabel("Vehicle");
dailyAllowanceLabel=new JLabel("Daily");
otherAllowanceLabel=new JLabel("Other");
IDBox=new JComboBox(IDSet);
container.setLayout(null);
edit.setBounds(440,10,100,30);
find.setBounds(330,10,100,30);
IDLabel.setBounds(100,10,100,30);
IDBox.setBounds(210,10,100,30);
nameLabel.setBounds(10,50,100,20);
phoneNumberLabel.setBounds(150,50,100,20);
emailLabel.setBounds(300,50,100,20);
name.setBounds(10,80,120,30);
phoneNumber.setBounds(150,80,100,30);
email.setBounds(300,80,220,30);
designationLabel.setBounds(10,140,100,20);
designation.setBounds(120,140,170,30);
otherPosition.setBounds(120,180,170,30);
totalSalaryLabel.setBounds(340,140,80,30);
totalSalary.setBounds(420,140,100,30);
allowanceLabel.setBounds(50,230,100,30);
deductionLabel.setBounds(380,230,100,20);
dearnessAllowanceLabel.setBounds(10,270,100,30);
lifeInsuranceLabel.setBounds(280,270,100,30);
dearnessCheck.setBounds(130,275,20,20);
dearness.setBounds(160,270,100,30);
lifeInsurance.setBounds(420,270,100,30);
cityCompensatoryAllowanceLabel.setBounds(10,310,120,30);
generalProvidentFundLabel.setBounds(280,310,130,30);
generalProvidentFund.setBounds(420,310,100,30);
cityCompensatoryCheck.setBounds(130,315,20,20);
cityCompensatory.setBounds(160,310,100,30);
overTimeAllowanceLabel.setBounds(10,350,100,30);
incomeTaxLabel.setBounds(280,350,100,30);
incomeTax.setBounds(420,350,100,30);
overTimeCheck.setBounds(130,355,20,20);
overTime.setBounds(160,350,100,30);
fixedMedicalAllowanceLabel.setBounds(10,390,100,30);
otherTaxLabel.setBounds(280,390,100,30);
otherTax.setBounds(420,390,100,30);

fixedMedicalCheck.setBounds(130,395,20,20);
fixedMedical.setBounds(160,390,100,30);
homeRentAllowanceLabel.setBounds(10,430,100,30);
homeRentCheck.setBounds(130,435,20,20);
homeRent.setBounds(160,430,100,30);
vehicleAllowanceLabel.setBounds(10,470,100,30);
vehicleCheck.setBounds(130,475,20,20);
vehicle.setBounds(160,470,100,30);

dailyAllowanceLabel.setBounds(10,510,100,30);
dailyCheck.setBounds(130,515,20,20);
daily.setBounds(160,510,100,30);

otherAllowanceLabel.setBounds(10,550,100,30);
otherCheck.setBounds(130,555,20,20);
otherAllowance.setBounds(160,550,100,30);

netSalaryButton.setBounds(270,510,130,30);
netSalary.setBounds(410,510,100,30);
save.setBounds(300,550,100,30);
exit.setBounds(410,550,100,30);
container.add(IDLabel);
container.add(nameLabel);
container.add(phoneNumberLabel);
container.add(emailLabel);
container.add(name);
container.add(phoneNumber);
container.add(email);
container.add(designation);
container.add(totalSalaryLabel);
container.add(designationLabel);
container.add(otherPosition);
container.add(totalSalary);
container.add(IDBox);
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
container.add(edit);
container.add(exit);
container.add(save);
container.add(netSalary);
container.add(find);

setResizable(false);
	
loadDefault();
addListeners();
setSize(580,640);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
addWindowListener(new WindowAdapter()
{
EditEmployee m=EditEmployee.this;
public void windowClosing(WindowEvent we)
{
m.dispose();
m.mainMenu.setVisible(true);
}
});
}

public void loadDefault()
{
designation.setEditable(false);
dearnessCheck.setVisible(false);
cityCompensatoryCheck.setVisible(false);
overTimeCheck.setVisible(false);
fixedMedicalCheck.setVisible(false);
homeRentCheck.setVisible(false);
vehicleCheck.setVisible(false);
dailyCheck.setVisible(false);
otherCheck.setVisible(false);
name.setEditable(false);
phoneNumber.setEditable(false);
email.setEditable(false);
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
lifeInsurance.setEditable(false);
otherTax.setEditable(false);
incomeTax.setEditable(false);
generalProvidentFund.setEditable(false);
totalSalary.setText("0.0");
totalSalary.setEditable(false);
netSalary.setText("0.0");
netSalary.setEditable(false);
save.setEnabled(false);
netSalaryButton.setEnabled(false);
edit.setEnabled(false);
}

public void addListeners()
{
save.addActionListener(this);
edit.addActionListener(this);
find.addActionListener(this);
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

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==edit)
{
editAll();
}

if(o==exit)
{
this.dispose();

this.mainMenu.setVisible(true);
}

if(o==save)
{
try{
if(necessaryCheck())
{
totalAmount();
saveAll(Long.parseLong(String.valueOf(IDBox.getSelectedItem())));
}
}catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Notification",JOptionPane.INFORMATION_MESSAGE);
}
}

if(o==netSalaryButton)
{
totalAmount();
}

if(o==find)
{
edit.setEnabled(true);
searchAll(Long.parseLong(String.valueOf(IDBox.getSelectedItem())));
}

}

public boolean necessaryCheck()
{
if(employeeModel.checkChar(lifeInsurance))
{
lifeInsurance.requestFocus();
JOptionPane.showMessageDialog(this,"Life Insurance Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}


if(employeeModel.isEmpty(phoneNumber))
{
phoneNumber.requestFocus();
JOptionPane.showMessageDialog(this,"Contact Field is Empty","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(employeeModel.isEmpty(email))
{
email.requestFocus();
JOptionPane.showMessageDialog(this,"Email Field is Empty","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(employeeModel.checkChar(phoneNumber))
{
phoneNumber.requestFocus();
JOptionPane.showMessageDialog(this,"Contact Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(phoneNumber.getText().trim().length()!=10)
{
phoneNumber.requestFocus();
JOptionPane.showMessageDialog(this,"Contact Field - should contain 10 integers","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(employeeModel.checkChar(generalProvidentFund))
{
generalProvidentFund.requestFocus();
JOptionPane.showMessageDialog(this,"General Provident Fund Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(incomeTax))
{
incomeTax.requestFocus();
JOptionPane.showMessageDialog(this,"Income Tax Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(otherTax))
{
otherTax.requestFocus();
JOptionPane.showMessageDialog(this,"Other Tax Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(dearness))
{
dearness.requestFocus();
JOptionPane.showMessageDialog(this,"Dearness Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(employeeModel.checkChar(cityCompensatory))
{
cityCompensatory.requestFocus();
JOptionPane.showMessageDialog(this,"City Compensatory Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(daily))
{
daily.requestFocus();
JOptionPane.showMessageDialog(this,"Daily Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(fixedMedical))
{
fixedMedical.requestFocus();
JOptionPane.showMessageDialog(this,"Medical Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(homeRent))
{
homeRent.requestFocus();
JOptionPane.showMessageDialog(this,"Home Rent Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}
if(employeeModel.checkChar(otherAllowance))
{
otherAllowance.requestFocus();
JOptionPane.showMessageDialog(this,"Other Allowance Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(employeeModel.checkChar(overTime))
{
overTime.requestFocus();
JOptionPane.showMessageDialog(this,"Over Time Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(employeeModel.checkChar(vehicle))
{
vehicle.requestFocus();
JOptionPane.showMessageDialog(this,"Vehicle Allowance Field - only integers are allowed","Error",JOptionPane.ERROR_MESSAGE);
return false;
}

if(Double.parseDouble(netSalary.getText().trim())<=0)
{
JOptionPane.showMessageDialog(this,"Net Salary Can't be Negative /Zero","Notification",JOptionPane.INFORMATION_MESSAGE);
return false;
}


return true;
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
dearness.setEditable(false);
}


if(otherCheck.isSelected())
{
otherAllowance.setEditable(true);
}
else
{
otherAllowance.setEditable(false);
}


if(dailyCheck.isSelected())
{
daily.setEditable(true);
}
else
{
daily.setEditable(false);
}


if(cityCompensatoryCheck.isSelected())
{
cityCompensatory.setEditable(true);
}
else
{

cityCompensatory.setEditable(false);
}


if(homeRentCheck.isSelected())
{
homeRent.setEditable(true);
}
else
{
homeRent.setEditable(false);
}


if(fixedMedicalCheck.isSelected())
{
fixedMedical.setEditable(true);
}
else
{
fixedMedical.setEditable(false);
}

if(vehicleCheck.isSelected())
{
vehicle.setEditable(true);
}
else
{
vehicle.setEditable(false);
}

if(overTimeCheck.isSelected())
{
overTime.setEditable(true);
}
else
{
overTime.setEditable(false);
}

}


public void totalAmount()
{
Double amount;
if(totalSalary.getText().equals(""))
{
totalSalary.setText("0");
}
if(dearness.getText().equals(""))
{
dearness.setText("0");
}
if(cityCompensatory.getText().equals(""))
{
cityCompensatory.setText("0");
}
if(homeRent.getText().equals(""))
{
homeRent.setText("0");
}
if(daily.getText().equals(""))
{
daily.setText("0");
}
if(vehicle.getText().equals(""))
{
vehicle.setText("0");
}
if(overTime.getText().equals(""))
{
overTime.setText("0");
}
if(fixedMedical.getText().equals(""))
{
fixedMedical.setText("0");
}
if(otherAllowance.getText().equals(""))
{
otherAllowance.setText("0");
}
if(incomeTax.getText().equals(""))
{
incomeTax.setText("0");
}
if(lifeInsurance.getText().equals(""))
{
lifeInsurance.setText("0");
}
if(otherTax.getText().equals(""))
{
otherTax.setText("0");
}
if(generalProvidentFund.getText().equals(""))
{
generalProvidentFund.setText("0");
}

amount=(Double.parseDouble(totalSalary.getText())+Integer.parseInt(daily.getText())+Integer.parseInt(cityCompensatory.getText())+Integer.parseInt(dearness.getText())+Integer.parseInt(overTime.getText())+Integer.parseInt(fixedMedical.getText())+Integer.parseInt(homeRent.getText())+Integer.parseInt(otherAllowance.getText())+Integer.parseInt(vehicle.getText()))-(Integer.parseInt(lifeInsurance.getText())+Integer.parseInt(generalProvidentFund.getText())+Integer.parseInt(otherTax.getText())+Integer.parseInt(incomeTax.getText()));
netSalary.setText(String.valueOf(amount));
}

public void saveAll(long ID) throws DAOException
{
employee=employeeModel.get(ID);
employee.setID(ID);
employee.setContact(Long.parseLong(phoneNumber.getText()));
employee.setEmail(email.getText());
employee.setDailyAllowance(Integer.parseInt(daily.getText()));
employee.setCityCompensatoryAllowance(Integer.parseInt(cityCompensatory.getText()));
employee.setDearnessAllowance(Integer.parseInt(dearness.getText()));
employee.setOverTimeAllowance(Integer.parseInt(overTime.getText()));
employee.setVehicleAllowance(Integer.parseInt(vehicle.getText()));
employee.setMedicalAllowance(Integer.parseInt(fixedMedical.getText()));
employee.setHomeRentAllowance(Integer.parseInt(homeRent.getText()));
employee.setOtherAllowance(Integer.parseInt(otherAllowance.getText()));
employee.setLifeInsurance(Integer.parseInt(lifeInsurance.getText()));
employee.setGeneralProvidentFund(Integer.parseInt(generalProvidentFund.getText()));
employee.setOtherTax(Integer.parseInt(otherTax.getText()));
employee.setIncomeTax(Integer.parseInt(incomeTax.getText()));
employee.setNetSalary(Double.parseDouble(netSalary.getText()));
if(designation.getSelectedItem().equals("other.."))
{
employee.setDesignation(otherPosition.getText());
}
else
{
employee.setDesignation(String.valueOf(designation.getItemAt(designation.getSelectedIndex())));
}
employeeModel.remove(ID);
employeeModel.add(employee);
JOptionPane.showMessageDialog(this,"Record Updated succesfully!!","Notification",JOptionPane.INFORMATION_MESSAGE);
loadDefault();
}

public void editAll()
{
save.setEnabled(true);
netSalaryButton.setEnabled(true);
designation.setEditable(true);
dearnessCheck.setVisible(true);
cityCompensatoryCheck.setVisible(true);
overTimeCheck.setVisible(true);
fixedMedicalCheck.setVisible(true);
homeRentCheck.setVisible(true);
vehicleCheck.setVisible(true);
dailyCheck.setVisible(true);
otherCheck.setVisible(true);
phoneNumber.setEditable(true);
email.setEditable(true);
lifeInsurance.setEditable(true);
otherTax.setEditable(true);
incomeTax.setEditable(true);
generalProvidentFund.setEditable(true);
totalSalary.setEditable(true);
}

public void searchAll(long ID)
{
int i=0,flag=0;
try{
employee=employeeModel.get(ID);
name.setText(employee.getName().trim().toUpperCase());
email.setText(employee.getEmail().trim().toUpperCase());
phoneNumber.setText(String.valueOf(employee.getContact()));
netSalary.setText(String.valueOf(employee.getNetSalary()));
dearness.setText(String.valueOf(employee.getDearnessAllowance()));
cityCompensatory.setText(String.valueOf(employee.getCityCompensatoryAllowance()));
homeRent.setText(String.valueOf(employee.getHomeRentAllowance()));
otherAllowance.setText(String.valueOf(employee.getOtherAllowance()));
daily.setText(String.valueOf(employee.getDailyAllowance()));
fixedMedical.setText(String.valueOf(employee.getMedicalAllowance()));
vehicle.setText(String.valueOf(employee.getVehicleAllowance()));
overTime.setText(String.valueOf(employee.getOverTimeAllowance()));
lifeInsurance.setText(String.valueOf(employee.getLifeInsurance()));
generalProvidentFund.setText(String.valueOf(employee.getGeneralProvidentFund()));
otherTax.setText(String.valueOf(employee.getOtherTax()));
incomeTax.setText(String.valueOf(employee.getIncomeTax()));
totalSalary.setText(String.valueOf(employee.getNetSalary()+employee.getDeduction()-employee.getAllowance()));
for(i=0;i<designationSet.length;i++)
{
if(designationSet[i].equals(employee.getDesignation()))
{
flag=1;
designation.setSelectedIndex(i);
}
}
if(flag!=1)
{
designation.setSelectedIndex(designationSet.length-1);
otherPosition.setVisible(true);
otherPosition.setText(employee.getDesignation());
}
}
catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Notification",JOptionPane.INFORMATION_MESSAGE);
}
}


}