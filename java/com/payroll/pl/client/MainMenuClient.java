package com.payroll.pl.client;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import javax.swing.border.*;
import java.awt.event.*;
import com.payroll.pl.client.*;
import com.payroll.pl.server.*;
import com.payroll.dao.*;
import com.payroll.server.*;
import com.payroll.model.*;
import com.payroll.exceptions.*;
import com.payroll.interfaces.*;
import java.util.*;
public class MainMenuClient extends JFrame implements ActionListener{
private JMenuBar menuBar;
private EmployeeInterface employee;
private JMenu menuReports,menuEmployee,menuExit,menuSettings,menuHelp;
private Container container;
private Calendar calendar;
private JMenuItem addEmployee,editEmployee,deleteEmployee,notepadTool,calculatorTool,quit,paySlipReport,statusReport,passwordSettings,usernameSettings,serverOn,serverOff,help;
private JLabel oldLoginLabel,currentLoginLabel,frontLabel;
private Date date;
private LoginFrameClient loginFrameClient;
private Client client;
private Long ID;
private String time1,time2,time3;

public MainMenuClient(EmployeeInterface employee,LoginFrameClient loginFrameClient,Client client,Long ID)
{
this.ID=ID;
this.employee=employee;
this.client=client;
this.loginFrameClient=loginFrameClient;
this.loginFrameClient.setVisible(false);
calendar=Calendar.getInstance();
container=getContentPane();
container.setLayout(null);
container.setBackground(new Color(131,191,64));
date=new Date();
int comma=employee.getLastLoginState().indexOf(",");
time1=employee.getLastLoginState().substring(0,comma);
time2=employee.getLastLoginState().substring(comma+1);
time3=String.valueOf(calendar.getTime());
currentLoginLabel=new JLabel("Current Session : "+time3);
oldLoginLabel=new JLabel("Previous Session :"+ time2);
this.employee.setLastLoginState(time1+","+time3);
frontLabel=new JLabel("Welcome  -  "+employee.getName().toUpperCase());
frontLabel.setFont(new Font("Times New Roman",Font.BOLD,24));
frontLabel.setOpaque(true);
frontLabel.setBackground(Color.white);
setLayout(null);
oldLoginLabel.setOpaque(true);
currentLoginLabel.setOpaque(true);
oldLoginLabel.setBackground(Color.white);
currentLoginLabel.setBackground(Color.white);
oldLoginLabel.setBounds(0,416,300,20);
frontLabel.setBounds(0,0,600,30);
currentLoginLabel.setBounds(300,416,300,20);
container.add(oldLoginLabel);
container.add(currentLoginLabel);
container.add(frontLabel);
setJMenuBar(createMenuBar());
setSize(600,490);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
setResizable(false);	
this.setTitle("Welcome To MainMenu");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.MAIN_MENU_MODULE)).getImage());
addListeners();
this.addWindowListener(new WindowAdapter(){
   MainMenuClient m=MainMenuClient.this;      
     public void windowClosing(WindowEvent e)
     {
      try{     
       m.employee.setLoginState(10);
       m.employee.setID(m.ID);
       m.client.updateInfo(m.ID,m.employee);
       m.dispose();
       m.loginFrameClient.setVisible(true);       
      }
     catch(Exception ex)
     {
JOptionPane.showMessageDialog(m,ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);

            }     
}
     });

serverOff.setEnabled(false);
try{
this.employee.setLastLoginState(String.valueOf(calendar.getTime()));
this.employee.setLoginState(11);
this.client.updateInfo(this.ID,this.employee);
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Can't Save Last Login Time "+e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
}     
}

public void addListeners()
{
editEmployee.addActionListener(this);
paySlipReport.addActionListener(this);
passwordSettings.addActionListener(this);
quit.addActionListener(this);
help.addActionListener(this);
}



public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==editEmployee)
{
new EditEmployee(this,this.employee,this.client,this.ID);
}

if(o==quit)
{
this.unloadWindow();
}

if(o==passwordSettings)
{
new ChangeEmployeePassword(this,this.employee,this.client,this.ID);
}

if(o==paySlipReport)
{
new PaySlip(this.employee,this,this.ID);
}

if(o==help)
{
new Query(this,this.employee,this.client,this.ID);
}

}


private JMenuBar createMenuBar()
{
menuBar=new JMenuBar();
menuHelp=new JMenu("Help ");
menuHelp.setMnemonic('H');
help=new JMenuItem("Queries",new ImageIcon(getClass().getResource(GlobalResources.HELP_ICON)));
menuHelp.add(help);
menuEmployee=new JMenu("Employee   ");
menuEmployee.setMnemonic('E');
menuReports=new JMenu("Reports    ");
menuReports.setMnemonic('R');
menuSettings=new JMenu("Settings   ");
menuSettings.setMnemonic('S');
menuExit=new JMenu("Quit   ");
menuExit.setMnemonic('Q');
passwordSettings=new JMenuItem("Change Password",new ImageIcon(getClass().getResource(GlobalResources.CHANGE_PASSWORD_MODULE)));
passwordSettings.setMnemonic('P');
editEmployee=new JMenuItem("Edit Personal Details",new ImageIcon(getClass().getResource(GlobalResources.EDIT_MODULE)));
editEmployee.setMnemonic('E');
quit=new JMenuItem("Quit",new ImageIcon(getClass().getResource(GlobalResources.CLOSE_BUTTON)));
quit.setMnemonic('Q');
paySlipReport=new JMenuItem("Pay Slip",new ImageIcon(getClass().getResource(GlobalResources.PAY_SLIP_MODULE)));
paySlipReport.setMnemonic('P');
menuEmployee.add(editEmployee);
menuReports.add(paySlipReport);
menuSettings.add(passwordSettings);
menuExit.add(quit);
menuBar.add(menuEmployee);
menuBar.add(menuReports);
menuBar.add(menuSettings);
menuBar.add(menuHelp);
menuBar.add(menuExit);
menuBar.setBackground(Color.white);
menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
return menuBar;
}

public void unloadWindow()
{
try
{
int reply = JOptionPane.showConfirmDialog(this,"Are you sure to exit?","Quit",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
if (reply == JOptionPane.YES_OPTION)
{
this.dispose();
this.employee.setLoginState(10);
this.employee.setID(this.ID);
this.client.updateInfo(this.ID,this.employee);
this.loginFrameClient.setVisible(true);
} 
}catch(Exception e)
{
}
}

}
