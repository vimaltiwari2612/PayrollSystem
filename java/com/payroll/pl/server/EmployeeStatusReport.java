package com.payroll.pl.server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.payroll.exceptions.*;
import com.payroll.model.*;
import com.payroll.interfaces.*;
import java.util.*;

import com.payroll.dao.*;

public class EmployeeStatusReport extends JFrame implements ActionListener
{
private MainMenu mainMenu;
private EmployeeInterface employee;
private EmployeeModel employeeModel;
private HashMap<String,EmployeeInterface> hashMaps;
private JLabel IDLabel;
private JTextField ID;
private JButton search,delete,exit;
private Container container;

public EmployeeStatusReport(MainMenu mainMenu)
{
this.mainMenu=mainMenu;
container=getContentPane();
this.setTitle("Status Report");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.EMPLOYEE_STATUS_MODULE)).getImage());

container.setBackground(new Color(137,177,78));
IDLabel=new JLabel("Enter an ID ");
IDLabel.setOpaque(true);
IDLabel.setBackground(new Color(137,177,78));
ID=new JTextField();
search=new JButton("Search",new ImageIcon(this.getClass().getResource(GlobalResources.SEARCH_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
delete=new JButton("Delete");
container.setLayout(null);
IDLabel.setBounds(10,20,100,30);
ID.setBounds(120,20,100,30);
search.setBounds(10,60,120,30);
exit.setBounds(140,60,100,30);
container.add(IDLabel);
container.add(ID);
container.add(search);
container.add(exit);
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
this.setVisible(true);
employeeModel=new EmployeeModel();
setSize(270,130);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
search.addActionListener(this);
exit.addActionListener(this);
this.addWindowListener(new WindowAdapter(){
 EmployeeStatusReport esr=EmployeeStatusReport.this;        
     public void windowClosing(WindowEvent e)
     {
      esr.dispose();
       esr.mainMenu.setVisible(true);  }
     });
setResizable(false);
	

this.mainMenu.setVisible(false);
}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==search)
{
try
{
if(ID.getText().trim().equals("")==false && employeeModel.checkChar(ID)==false)
{
if(employeeModel.exists(Long.parseLong(ID.getText().trim())))
{
employee=employeeModel.get(Long.parseLong(ID.getText().trim()));
new EmployeeStatusReportDetails(employee);
ID.setText("");
}
else
{
JOptionPane.showMessageDialog(this,"ID Does Not Exists!!","Error",JOptionPane.ERROR_MESSAGE);
}
}
else
{
ID.requestFocus();
JOptionPane.showMessageDialog(this,"Please Type the ID Correctly !!","Error",JOptionPane.ERROR_MESSAGE);
}
}
catch(DAOException e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
}

if(o==exit)
{
this.dispose();

this.mainMenu.setVisible(true);
}
}

//inner class

class EmployeeStatusReportDetails extends JWindow implements ActionListener
{
private JLabel IDLabel1,nameLabel1,packageLabel1,phoneNumberLabel1,emailLabel1,addressLabel1,ageLabel1,designationLabel1,netSalaryLabel1,IDLabel2,nameLabel2,packageLabel2,phoneNumberLabel2,emailLabel2,addressLabel2,ageLabel2,designationLabel2,netSalaryLabel2,totalDeductionLabel1,totalAllowancesLabel1,totalDeductionLabel2,totalAllowancesLabel2,passwordLabel1,passwordLabel2,attendenceLabel1,attendenceLabel2;
private JButton exit;
private EmployeeStatusReport deleteEmployee;
private Container container;
private String month="",date="";
EmployeeStatusReportDetails(EmployeeInterface e)
{
container=getContentPane();
deleteEmployee=EmployeeStatusReport.this;
passwordLabel1=new JLabel("password - ");
passwordLabel1.setFont(new Font("Times New Roman",Font.PLAIN,12));
IDLabel1=new JLabel("Employee ID");
nameLabel1=new JLabel("Employee Name");
ageLabel1=new JLabel("Employee Age");
phoneNumberLabel1=new JLabel("Employee Contact NO.");
emailLabel1=new JLabel("Employee Email ");
addressLabel1=new JLabel("Employee Address");
designationLabel1=new JLabel("Employee Designation");
netSalaryLabel1=new JLabel("Employee Monthly salary");
packageLabel1=new JLabel("Employee Annual Package");
totalAllowancesLabel1=new JLabel(" Total Allowances");
totalDeductionLabel1=new JLabel("Total Deduction");
StringTokenizer st=new StringTokenizer(String.valueOf(Calendar.getInstance().getTime())," ");

while(st.hasMoreTokens())
{
st.nextToken();
month=st.nextToken();
date=st.nextToken();
break;
}
attendenceLabel1=new JLabel("Attendence("+ month+" )");
passwordLabel2=new JLabel(e.getPassword());
passwordLabel2.setFont(new Font("Times New Roman",Font.PLAIN,10));
IDLabel2=new JLabel(deleteEmployee.ID.getText().trim());
nameLabel2=new JLabel(e.getName());
ageLabel2=new JLabel(String.valueOf(e.getAge()));
phoneNumberLabel2=new JLabel(String.valueOf(e.getContact()));
emailLabel2=new JLabel(e.getEmail());
addressLabel2=new JLabel(e.getAddress());
designationLabel2=new JLabel(e.getDesignation());
netSalaryLabel2=new JLabel(String.valueOf(e.getNetSalary())+" /- Rs.");
packageLabel2=new JLabel(String.valueOf(12*e.getNetSalary()) + "  /-Rs.");
totalAllowancesLabel2=new JLabel(String.valueOf(e.getAllowance()*12)+" /- Rs. " + "("+String.valueOf(e.getAllowance())+" per Month)");
totalDeductionLabel2=new JLabel(String.valueOf(e.getDeduction()*12)+" /- Rs. " + "("+String.valueOf(e.getDeduction())+" per Month)");
exit=new JButton("Close",new ImageIcon(getClass().getResource(GlobalResources.CLOSE_BUTTON)));
attendenceLabel2=new JLabel(String.valueOf(e.getAttendence())+"/"+date);
container.setLayout(null);
container.setBackground(new Color(142,152,103));
passwordLabel1.setBounds(220,5,100,20);
passwordLabel2.setBounds(300,5,100,20);
IDLabel1.setBounds(20,20,150,20);
nameLabel1.setBounds(20,50,150,20);
ageLabel1.setBounds(20,80,150,20);
phoneNumberLabel1.setBounds(20,110,150,20);
emailLabel1.setBounds(20,140,150,20);
addressLabel1.setBounds(20,170,150,20);
designationLabel1.setBounds(20,200,150,20);
totalAllowancesLabel1.setBounds(20,230,150,20);
totalDeductionLabel1.setBounds(20,260,150,20);
netSalaryLabel1.setBounds(20,290,150,20);
packageLabel1.setBounds(20,320,150,20);
attendenceLabel1.setBounds(20,350,150,20);
IDLabel2.setBounds(190,20,150,20);
nameLabel2.setBounds(190,50,150,20);
ageLabel2.setBounds(190,80,150,20);
phoneNumberLabel2.setBounds(190,110,150,20);
emailLabel2.setBounds(190,140,240,20);
addressLabel2.setBounds(190,170,300,20);
designationLabel2.setBounds(190,200,150,20);
totalAllowancesLabel2.setBounds(190,230,240,20);
totalDeductionLabel2.setBounds(190,260,240,20);
netSalaryLabel2.setBounds(190,290,150,20);
packageLabel2.setBounds(190,320,150,20);
attendenceLabel2.setBounds(190,350,150,20);
exit.setBounds(150,390,100,30);
container.add(IDLabel1);
container.add(nameLabel1);
container.add(emailLabel1);
container.add(netSalaryLabel1);
container.add(packageLabel1);
container.add(addressLabel1);
container.add(phoneNumberLabel1);
container.add(designationLabel1);
container.add(ageLabel1);
container.add(totalDeductionLabel1);
container.add(totalDeductionLabel2);
container.add(totalAllowancesLabel2);
container.add(totalAllowancesLabel1);
container.add(IDLabel2);
container.add(nameLabel2);
container.add(emailLabel2);
container.add(netSalaryLabel2);
container.add(packageLabel2);
container.add(addressLabel2);
container.add(phoneNumberLabel2);
container.add(designationLabel2);
container.add(ageLabel2);
container.add(exit);
container.add(passwordLabel1);
container.add(passwordLabel2);
container.add(attendenceLabel1);
container.add(attendenceLabel2);
setSize(450,440);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
delete.addActionListener(this);
exit.addActionListener(this);
this.addWindowListener(new WindowAdapter(){
EmployeeStatusReportDetails ded=EmployeeStatusReportDetails.this;
public void windowDeactivated(WindowEvent we)
{
ded.dispose();
}
});
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==exit)
{
this.dispose();
}

}

} 

}

