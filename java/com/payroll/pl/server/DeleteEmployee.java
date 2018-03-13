package com.payroll.pl.server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.payroll.exceptions.*;
import com.payroll.model.*;
import com.payroll.interfaces.*;
import java.util.*;

import com.payroll.dao.*;

public class DeleteEmployee extends JFrame implements ActionListener
{
private EmployeeInterface employee;
private EmployeeModel employeeModel;
private HashMap<String,EmployeeInterface> hashMaps;
private JLabel IDLabel;
private JTextField ID;
private JButton find,delete,exit;
private Container container;
private MainMenu mainMenu;
public DeleteEmployee(MainMenu mainMenu)
{
this.mainMenu=mainMenu;
container=getContentPane();
this.setTitle("Delete Employee");
this.setIconImage(new ImageIcon(getClass().getResource(GlobalResources.DELETE_MODULE)).getImage());
container.setBackground(new Color(137,177,78));
IDLabel=new JLabel("Enter an ID ");
IDLabel.setOpaque(true);
IDLabel.setBackground(new Color(137,177,78));
ID=new JTextField();
find=new JButton("Find",new ImageIcon(this.getClass().getResource(GlobalResources.SEARCH_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
delete=new JButton("Delete",new ImageIcon(getClass().getResource(GlobalResources.DELETE_BUTTON)));
container.setLayout(null);
IDLabel.setBounds(10,20,100,30);
ID.setBounds(120,20,100,30);
find.setBounds(10,60,120,30);
exit.setBounds(140,60,100,30);
container.add(IDLabel);
container.add(ID);
container.add(find);
container.add(exit);
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
this.setVisible(true);
employeeModel=new EmployeeModel();
setSize(270,130);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
find.addActionListener(this);
exit.addActionListener(this);
setResizable(false);
	
this.addWindowListener(new WindowAdapter(){
 DeleteEmployee de=DeleteEmployee.this;        
     public void windowClosing(WindowEvent e)
     {
           de.dispose(); 
            de.mainMenu.setVisible(true);        
}
     });

this.mainMenu.setVisible(false);

}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==find)
{
try
{
if(ID.getText().trim().equals("")==false && employeeModel.checkChar(ID)==false)
{
if(employeeModel.exists(Long.parseLong(ID.getText().trim())))
{
employee=employeeModel.get(Long.parseLong(ID.getText().trim()));
new DeleteEmployeeDetails(employee);
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

class DeleteEmployeeDetails extends JWindow implements ActionListener
{
private JLabel IDLabel1,nameLabel1,packageLabel1,phoneNumberLabel1,emailLabel1,addressLabel1,ageLabel1,designationLabel1,netSalaryLabel1,IDLabel2,nameLabel2,packageLabel2,phoneNumberLabel2,emailLabel2,addressLabel2,ageLabel2,designationLabel2,netSalaryLabel2;
private JButton delete,exit;
private DeleteEmployee deleteEmployee;
private Container container;
DeleteEmployeeDetails(EmployeeInterface e)
{
container=getContentPane();
container.setBackground(new Color(186,199,188));
deleteEmployee=DeleteEmployee.this;
IDLabel1=new JLabel("Employee ID");
nameLabel1=new JLabel("Employee Name");
ageLabel1=new JLabel("Employee Age");
phoneNumberLabel1=new JLabel("Employee Contact NO.");
emailLabel1=new JLabel("Employee Email ");
addressLabel1=new JLabel("Employee Address");
designationLabel1=new JLabel("Employee Designation");
netSalaryLabel1=new JLabel("Employee Monthly salary");
packageLabel1=new JLabel("Employee Annual Package");
IDLabel2=new JLabel(deleteEmployee.ID.getText().trim());
nameLabel2=new JLabel(e.getName());
ageLabel2=new JLabel(String.valueOf(e.getAge()));
phoneNumberLabel2=new JLabel(String.valueOf(e.getContact()));
emailLabel2=new JLabel(e.getEmail());
addressLabel2=new JLabel(e.getAddress());
designationLabel2=new JLabel(e.getDesignation());
netSalaryLabel2=new JLabel(String.valueOf(e.getNetSalary())+" /- Rs.");
packageLabel2=new JLabel(String.valueOf(12*e.getNetSalary()) + "  lac");
delete=new JButton("Delete",new ImageIcon(getClass().getResource(GlobalResources.DELETE_BUTTON)));
exit=new JButton("Exit",new ImageIcon(getClass().getResource(GlobalResources.CLOSE_BUTTON)));
container.setBackground(Color.white);
container.setLayout(null);
IDLabel1.setBounds(20,20,150,20);
nameLabel1.setBounds(20,50,150,20);
ageLabel1.setBounds(20,80,150,20);
phoneNumberLabel1.setBounds(20,110,150,20);
emailLabel1.setBounds(20,140,150,20);
addressLabel1.setBounds(20,170,150,20);
designationLabel1.setBounds(20,200,150,20);
netSalaryLabel1.setBounds(20,230,150,20);
packageLabel1.setBounds(20,260,150,20);
IDLabel2.setBounds(190,20,150,20);
nameLabel2.setBounds(190,50,150,20);
ageLabel2.setBounds(190,80,150,20);
phoneNumberLabel2.setBounds(190,110,150,20);
emailLabel2.setBounds(190,140,240,20);
addressLabel2.setBounds(190,170,240,20);
designationLabel2.setBounds(190,200,150,20);
netSalaryLabel2.setBounds(190,230,150,20);
packageLabel2.setBounds(190,260,150,20);
delete.setBounds(50,300,100,30);
exit.setBounds(170,300,100,30);
container.add(IDLabel1);
container.add(nameLabel1);
container.add(emailLabel1);
container.add(netSalaryLabel1);
container.add(packageLabel1);
container.add(addressLabel1);
container.add(phoneNumberLabel1);
container.add(designationLabel1);
container.add(ageLabel1);
container.add(IDLabel2);
container.add(nameLabel2);
container.add(emailLabel2);
container.add(netSalaryLabel2);
container.add(packageLabel2);
container.add(addressLabel2);
container.add(phoneNumberLabel2);
container.add(designationLabel2);
container.add(ageLabel2);
container.add(delete);
container.add(exit);
setSize(450,350);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
delete.addActionListener(this);
exit.addActionListener(this);
this.addWindowListener(new WindowAdapter(){
DeleteEmployeeDetails ded=DeleteEmployeeDetails.this;
public void windowDeactivated(WindowEvent we)
{
ded.dispose();
}
});
}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==delete)
{
try{
deleteEmployee.employeeModel.remove(Long.parseLong(deleteEmployee.ID.getText().trim()));
this.dispose();
JOptionPane.showMessageDialog(this,"Successfully Deleted!!","Notification",JOptionPane.INFORMATION_MESSAGE);
deleteEmployee.ID.setText("");
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
}

if(o==exit)
{
this.dispose();
}
}

} 

}

