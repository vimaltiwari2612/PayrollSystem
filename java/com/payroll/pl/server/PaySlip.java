package com.payroll.pl.server;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.event.*;

import com.payroll.exceptions.*;
import com.payroll.model.*;
import com.payroll.interfaces.*;
import java.util.*;

import com.payroll.dao.*;

public class PaySlip extends JFrame implements ActionListener,ItemListener
{
private MainMenu mainMenu;
private EmployeeInterface employee;
private EmployeeModel employeeModel;
private HashMap<String,EmployeeInterface> hashMaps;
private JLabel nameLabel,phoneNumberLabel,addressLabel,genderLabel,designationLabel,bloodGroupLabel,dobLabel,dateLabel,monthLabel,passwordLabel,reTypePasswordLabel,IDLabel,cityLabel,stateLabel,yearLabel,margineLabel,emailLabel,ageLabel,
officeWorkLabel,meritalStatusLabel,allowanceLabel,dearnessAllowanceLabel,overTimeAllowanceLabel,fixedMedicalAllowanceLabel,cityCompensatoryAllowanceLabel,otherAllowanceLabel,homeRentAllowanceLabel,vehicleAllowanceLabel,dailyAllowanceLabel,lifeInsuranceLabel,generalProvidentFundLabel,incomeTaxLabel,otherTaxLabel,deductionLabel,totalSalaryLabel,netSalaryLabel;
private JButton generateSlip,exit,edit,netSalaryButton,find;
private JCheckBox dearnessCheck,overTimeCheck,fixedMedicalCheck,cityCompensatoryCheck,homeRentCheck,otherCheck,dailyCheck,vehicleCheck;
private JTextField name,phoneNumber,address,year,ID,city,state,email,age,otherPosition,overTime,daily,vehicle,otherAllowance,homeRent,fixedMedical,dearness,cityCompensatory,netSalary,lifeInsurance,generalProvidentFund,incomeTax,otherTax,totalSalary;
private JComboBox IDBox,designation;
private Container container;
private Set<String> keys;
private String IDSet[];
private String designationSet[]={"Managing Director","General Manager","Asst.GM","Manager","Asst. Manager","Senior Coordinator","Junior Coordinator","Supervisor","Senior Assistant","Junior Assistant","Office Assistant","Sr.Executive","Executive","Jr.Executive","Trainee","other.."};
private int i=0;
public PaySlip(MainMenu mainMenu)
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

this.setTitle("Pay Slip");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.PAY_SLIP_MODULE)).getImage());
container=getContentPane();
netSalaryLabel=new JLabel("Net Salary");
generateSlip=new JButton("Create Slip",new ImageIcon(this.getClass().getResource(GlobalResources.GENERATE_SLIP_BUTTON)));
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

netSalaryLabel.setBounds(300,510,120,30);
netSalary.setBounds(410,510,100,30);
generateSlip.setBounds(280,550,130,30);
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
container.add(netSalaryLabel);
container.add(exit);
container.add(generateSlip);
container.add(netSalary);
container.add(find);
loadDefault();
addListeners();
setResizable(false);
	
setSize(580,640);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
addWindowListener(new WindowAdapter()
{
PaySlip m=PaySlip.this;
public void windowClosing(WindowEvent we)
{
m.dispose();
m.mainMenu.setVisible(true);
}
});

this.mainMenu.setVisible(false);
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
name.setText("");
phoneNumber.setText("");
email.setText("");
IDBox.setSelectedIndex(0);
generalProvidentFund.setText("0");
lifeInsurance.setEditable(false);
otherTax.setEditable(false);
incomeTax.setEditable(false);
generalProvidentFund.setEditable(false);
totalSalary.setText("0.0");
totalSalary.setEditable(false);
netSalary.setText("0.0");
netSalary.setEditable(false);
generateSlip.setEnabled(false);
edit.setEnabled(false);
}

public void addListeners()
{
generateSlip.addActionListener(this);
edit.addActionListener(this);
find.addActionListener(this);
exit.addActionListener(this);
designation.addItemListener(this);
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

if(o==exit)
{
this.dispose();
this.mainMenu.setVisible(true);
}

if(o==generateSlip)
{
loadDefault();
new PaySlipDetails(employee);
}


if(o==find)
{
generateSlip.setEnabled(true);
searchAll(Long.parseLong(String.valueOf(IDBox.getSelectedItem())));
}
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
amount=(Double.parseDouble(totalSalary.getText())+Integer.parseInt(daily.getText())+Integer.parseInt(cityCompensatory.getText())+Integer.parseInt(dearness.getText())+Integer.parseInt(overTime.getText())+Integer.parseInt(fixedMedical.getText())+Integer.parseInt(homeRent.getText())+Integer.parseInt(otherAllowance.getText())+Integer.parseInt(vehicle.getText()))-(Integer.parseInt(lifeInsurance.getText())+Integer.parseInt(generalProvidentFund.getText())+Integer.parseInt(otherTax.getText())+Integer.parseInt(incomeTax.getText()));
netSalary.setText(String.valueOf(amount));
}


public void searchAll(long ID)
{
int i=0,flag=0;
try{
employee=employeeModel.get(ID);
name.setText(employee.getName().trim().toUpperCase());
email.setText(employee.getEmail().trim());
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

//inner class
class PaySlipDetails extends JFrame implements ActionListener,Printable
{
private JLabel paySlipLabel,IDLabel1,nameLabel1,packageLabel1,phoneNumberLabel1,emailLabel1,addressLabel1,ageLabel1,designationLabel1,netSalaryLabel1,IDLabel2,nameLabel2,packageLabel2,phoneNumberLabel2,emailLabel2,addressLabel2,ageLabel2,designationLabel2,netSalaryLabel2,deductionLabel,allowanceLabel,licLabel1,gpfLabel1,itLabel1,otherTaxLabel1,dearnessLabel1,ccLabel1,hrLabel1,otherAllowanceLabel1,vehicleLabel1,dailyLabel1,medicalLabel1,overTimeLabel1,licLabel2,gpfLabel2,itLabel2,otherTaxLabel2,dearnessLabel2,ccLabel2,hrLabel2,otherAllowanceLabel2,vehicleLabel2,dailyLabel2,medicalLabel2,overTimeLabel2,dateLabel;
private Container container;
private JButton print,exit;
private Calendar c;
PaySlipDetails(EmployeeInterface e)
{
c=Calendar.getInstance();
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.GENERATE_SLIP_BUTTON)).getImage());
dateLabel=new JLabel(String.valueOf(c.getTime()).trim());
print=new JButton("Print",new ImageIcon(this.getClass().getResource(GlobalResources.PRINT_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
this.setTitle("Pay Slip - "+ e.getName().toUpperCase());
container=getContentPane();
container.setBackground(Color.white);
paySlipLabel=new JLabel("Pay Slip");
paySlipLabel.setFont(new Font("Times New Roman",Font.BOLD,28));
paySlipLabel.setOpaque(true);
IDLabel1=new JLabel("Employee ID");
nameLabel1=new JLabel("Employee Name");
ageLabel1=new JLabel("Employee Age");
phoneNumberLabel1=new JLabel("Employee Contact NO.");
emailLabel1=new JLabel("Employee Email ");
addressLabel1=new JLabel("Employee Address");
designationLabel1=new JLabel("Employee Designation");
allowanceLabel=new JLabel("Allowances");
deductionLabel=new JLabel("Deductions");
dearnessLabel1=new JLabel("Dearness");
ccLabel1=new JLabel("City Compensatory");
overTimeLabel1=new JLabel("Over Time");
medicalLabel1=new JLabel("Medical");
hrLabel1=new JLabel("Home Rent");
vehicleLabel1=new JLabel("Vehicle");
dailyLabel1=new JLabel("Daily");
otherAllowanceLabel1=new JLabel("Other");
licLabel1=new JLabel("Life Insurance");
itLabel1=new JLabel("Income Tax");
otherTaxLabel1=new JLabel("Other Tax");
gpfLabel1=new JLabel("General Provident Fund");
netSalaryLabel1=new JLabel("Employee Monthly salary");
IDLabel2=new JLabel(String.valueOf(IDBox.getSelectedItem()));
nameLabel2=new JLabel(e.getName());
ageLabel2=new JLabel(String.valueOf(e.getAge()));
phoneNumberLabel2=new JLabel(String.valueOf(e.getContact()));
emailLabel2=new JLabel(e.getEmail());
addressLabel2=new JLabel(e.getAddress());
designationLabel2=new JLabel(e.getDesignation());
dearnessLabel2=new JLabel(String.valueOf(e.getDearnessAllowance()));
ccLabel2=new JLabel(String.valueOf(e.getCityCompensatoryAllowance()));
overTimeLabel2=new JLabel(String.valueOf(e.getOverTimeAllowance()));
medicalLabel2=new JLabel(String.valueOf(e.getMedicalAllowance()));
hrLabel2=new JLabel(String.valueOf(e.getHomeRentAllowance()));
vehicleLabel2=new JLabel(String.valueOf(e.getVehicleAllowance()));
dailyLabel2=new JLabel(String.valueOf(e.getDailyAllowance()));
otherAllowanceLabel2=new JLabel(String.valueOf(e.getOtherAllowance()));
licLabel2=new JLabel(String.valueOf(e.getLifeInsurance()));
itLabel2=new JLabel(String.valueOf(e.getIncomeTax()));
otherTaxLabel2=new JLabel(String.valueOf(e.getOtherTax()));
gpfLabel2=new JLabel(String.valueOf(e.getGeneralProvidentFund()));
netSalaryLabel2=new JLabel(String.valueOf(e.getNetSalary())+" /- Rs.");
paySlipLabel.setBackground(Color.white);
netSalaryLabel2.setForeground(Color.red);
phoneNumberLabel2.setForeground(Color.red);
container.setLayout(null);
paySlipLabel.setBounds(10,10,200,30);
dateLabel.setBounds(300,10,290,30);
IDLabel1.setBounds(30,70,150,20);
nameLabel1.setBounds(30,100,150,20);
ageLabel1.setBounds(30,130,150,20);
phoneNumberLabel1.setBounds(30,160,150,20);
emailLabel1.setBounds(30,190,150,20);
addressLabel1.setBounds(30,220,150,20);
designationLabel1.setBounds(30,250,150,20);
allowanceLabel.setBounds(60,290,150,20);
deductionLabel.setBounds(330,290,150,20);
ccLabel1.setBounds(30,320,150,20);
overTimeLabel1.setBounds(30,350,150,20);
medicalLabel1.setBounds(30,380,150,20);
hrLabel1.setBounds(30,410,150,20);
vehicleLabel1.setBounds(30,440,150,20);
dailyLabel1.setBounds(30,470,150,20);
otherAllowanceLabel1.setBounds(30,500,150,20);
dearnessLabel1.setBounds(30,530,150,20);
licLabel1.setBounds(250,320,150,20);
itLabel1.setBounds(250,350,150,20);
otherTaxLabel1.setBounds(250,380,150,20);
gpfLabel1.setBounds(250,410,150,20);
ccLabel2.setBounds(200,320,50,20);
overTimeLabel2.setBounds(200,350,50,20);
medicalLabel2.setBounds(200,380,50,20);
hrLabel2.setBounds(200,410,50,20);
vehicleLabel2.setBounds(200,440,50,20);
dailyLabel2.setBounds(200,470,50,20);
otherAllowanceLabel2.setBounds(200,500,50,20);
dearnessLabel2.setBounds(200,530,50,20);
licLabel2.setBounds(420,320,50,20);
itLabel2.setBounds(420,350,50,20);
otherTaxLabel2.setBounds(420,380,50,20);
gpfLabel2.setBounds(420,410,50,20);
IDLabel2.setBounds(250,70,150,20);
nameLabel2.setBounds(250,100,150,20);
ageLabel2.setBounds(250,130,150,20);
phoneNumberLabel2.setBounds(250,160,150,20);
emailLabel2.setBounds(250,190,240,20);
addressLabel2.setBounds(250,220,300,20);
designationLabel2.setBounds(250,250,150,20);
netSalaryLabel1.setBounds(30,570,150,20);
netSalaryLabel2.setBounds(250,570,150,20);
print.setBounds(200,610,120,30);
exit.setBounds(320,610,100,30);
container.add(paySlipLabel);
container.add(dateLabel);
container.add(IDLabel1);
container.add(nameLabel1);
container.add(emailLabel1);
container.add(addressLabel1);
container.add(phoneNumberLabel1);
container.add(designationLabel1);
container.add(allowanceLabel);
container.add(otherAllowanceLabel1);
container.add(otherAllowanceLabel2);

container.add(deductionLabel);
container.add(itLabel1);
container.add(itLabel2);
container.add(gpfLabel2);
container.add(gpfLabel1);
container.add(licLabel2);
container.add(licLabel1);
container.add(otherTaxLabel1);
container.add(otherTaxLabel2);
container.add(ccLabel1);
container.add(ccLabel2);
container.add(hrLabel1);
container.add(hrLabel2);
container.add(vehicleLabel1);
container.add(vehicleLabel2);
container.add(dailyLabel1);
container.add(dailyLabel2);
container.add(medicalLabel1);
container.add(medicalLabel2);
container.add(overTimeLabel1);
container.add(overTimeLabel2);
container.add(dearnessLabel1);
container.add(dearnessLabel2);
container.add(ageLabel1);
container.add(IDLabel2);
container.add(nameLabel2);
container.add(emailLabel2);
container.add(allowanceLabel);
container.add(netSalaryLabel2);
container.add(addressLabel2);
container.add(phoneNumberLabel2);
container.add(designationLabel2);
container.add(ageLabel2);
container.add(netSalaryLabel2);
container.add(netSalaryLabel1);
container.add(print);
container.add(exit);
setSize(580,680);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);      	        
setVisible(true);
print.addActionListener(this);
exit.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==print)
{
doPrintJob();
}

if(o==exit)
{
this.dispose();
}
}

public void doPrintJob()
{
PrinterJob printJob = PrinterJob.getPrinterJob();
printJob.setPrintable(this);

if(printJob.printDialog()) {
try {
printJob.print();                  
}catch(Exception PrintException) 
{
JOptionPane.showMessageDialog(this,"Can't Print - "+PrintException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);              
printJob.cancel();
}
}
}

public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
                      
            Graphics2D g2 = (Graphics2D)g;
            g2.translate(pf.getImageableX()+5, pf.getImageableY()+5);
            
    	    Font  f = new Font("Monospaced",Font.PLAIN,12);
    	    g2.setFont (f);
	    	paint (g2);
	    	
            return Printable.PAGE_EXISTS;
        }
  		 

               	

}

}