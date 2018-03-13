package com.payroll.pl.server;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import javax.swing.border.*;
import java.awt.event.*;
import com.payroll.pl.server.*;
import com.payroll.dao.*;
import com.payroll.server.*;
import com.payroll.model.*;
import com.payroll.exceptions.*;
import java.util.*;

public class MainMenu extends JFrame implements ActionListener{
private JMenuBar menuBar;
private AdminModel adminModel;
private Server server;
private JMenu menuTools,menuReports,menuEmployee,menuExit,menuSettings,menuServer,menuSupport;
private Container container;
private Calendar calendar;
private JMenuItem addEmployee,editEmployee,deleteEmployee,notepadTool,calculatorTool,quit,paySlipReport,statusReport,passwordSettings,usernameSettings,serverOn,serverOff,queryWindow,refreshEmployee,help;
private JLabel oldLoginLabel,currentLoginLabel;
private Date date;
public MainMenu()
{
calendar=Calendar.getInstance();
container=getContentPane();
container.setLayout(null);
container.setBackground(new Color(128,128,255));
date=new Date();
adminModel=new AdminModel();
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.MAIN_MENU_MODULE)).getImage());
currentLoginLabel=new JLabel("Current Session : "+String.valueOf(calendar.getTime()));
oldLoginLabel=new JLabel("");
try{
oldLoginLabel.setText(adminModel.getLastLoginState());
adminModel.setLastLoginState("Previous Session : "+String.valueOf(calendar.getTime()));
}catch(Exception e)
{
oldLoginLabel.setText(e.getMessage());
}

try{
server=new Server();
JOptionPane.showMessageDialog(this,"Server is Initialized...","Notification",JOptionPane.INFORMATION_MESSAGE);
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Server Problem : "+e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
}
setLayout(null);
oldLoginLabel.setOpaque(true);
currentLoginLabel.setOpaque(true);
oldLoginLabel.setBackground(Color.white);
currentLoginLabel.setBackground(Color.white);
oldLoginLabel.setBounds(0,416,300,20);
currentLoginLabel.setBounds(300,416,300,20);
container.add(oldLoginLabel);
container.add(currentLoginLabel);
setJMenuBar(createMenuBar());
setSize(600,490);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setVisible(true);
this.setTitle("Welcome To MainMenu");
addListeners();
this.addWindowListener(new WindowAdapter(){
   MainMenu m=MainMenu.this;      
     public void windowClosing(WindowEvent e)
     {
          System.exit(0);
           }
     });
setResizable(false);
	
serverOff.setEnabled(false);
     
}

public void addListeners()
{
addEmployee.addActionListener(this);
editEmployee.addActionListener(this);
deleteEmployee.addActionListener(this);
paySlipReport.addActionListener(this);
statusReport.addActionListener(this);
passwordSettings.addActionListener(this);
usernameSettings.addActionListener(this);
calculatorTool.addActionListener(this);
notepadTool.addActionListener(this);
quit.addActionListener(this);
serverOn.addActionListener(this);
serverOff.addActionListener(this);
queryWindow.addActionListener(this);
refreshEmployee.addActionListener(this);
help.addActionListener(this);
}

protected void runComponents(String sComponents)
	{
		Runtime rt = Runtime.getRuntime();
		try{
                      rt.exec(sComponents);
                    
                      }
		catch(IOException evt){
                JOptionPane.showMessageDialog(null,evt.getMessage(),"Error Found",JOptionPane.ERROR_MESSAGE);
      }
	}


public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==addEmployee)
{
new AddEmployee(this);
}
if(o==editEmployee)
{
new EditEmployee(this);
}

if(o==quit)
{
this.unloadWindow();
}

if(o==passwordSettings)
{
new ChangeAdminPassword(this);
}
if(o==usernameSettings)
{
new ChangeAdminUsername(this);
}

if(o==deleteEmployee)
{
new DeleteEmployee(this);
}


if(o==paySlipReport)
{
new PaySlip(this);
}

if(o==statusReport)
{
new EmployeeStatusReport(this);
}

if(o==notepadTool)
{
this.runComponents("notepad.exe");
}

if(o==calculatorTool)
{
this.runComponents("calc.exe");
}

if(o==serverOn)
{
try{
server.start();
serverOff.setEnabled(true);
serverOn.setEnabled(false);
JOptionPane.showMessageDialog(this,"Server is ON.","Notification",JOptionPane.INFORMATION_MESSAGE);		
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Server problem : "+e.getMessage(),"Notification",JOptionPane.INFORMATION_MESSAGE);		
}
}

if(o==serverOff)
{
try{
server.stop();
serverOff.setEnabled(false);
serverOn.setEnabled(true);
JOptionPane.showMessageDialog(this,"Server is OFF.","Notification",JOptionPane.INFORMATION_MESSAGE);		
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,"Server problem : "+e.getMessage(),"Notification",JOptionPane.INFORMATION_MESSAGE);		
}
}

if(o==queryWindow)
{

}
if(o==help)
{
String text="Having Queries...???\n\nContact - abc1234@gmail.com\nthank you!";
JOptionPane.showMessageDialog(this,text,"Query",JOptionPane.QUESTION_MESSAGE);
}

if(o==refreshEmployee)
{
new RefreshEmployee(this);
}
}



private JMenuBar createMenuBar()
{
menuBar=new JMenuBar();
menuSupport=new JMenu("Support   ");
menuSupport.setMnemonic('U');
menuTools=new JMenu("Tools   ");
menuTools.setMnemonic('T');
menuEmployee=new JMenu("Employee   ");
menuEmployee.setMnemonic('E');
menuReports=new JMenu("Reports    ");
menuReports.setMnemonic('R');
menuSettings=new JMenu("Settings   ");
menuSettings.setMnemonic('S');
menuServer=new JMenu("Server   ");
menuServer.setMnemonic('V');
menuExit=new JMenu("Quit   ");
menuExit.setMnemonic('Q');
queryWindow=new JMenuItem("Check Queries");
queryWindow.setMnemonic('Q');
refreshEmployee=new JMenuItem("Refresh Employee Account",new ImageIcon(this.getClass().getResource(GlobalResources.RESET_BUTTON)));
refreshEmployee.setMnemonic('R');
help=new JMenuItem("Help",new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
help.setMnemonic('H');
passwordSettings=new JMenuItem("Change Password",new ImageIcon(this.getClass().getResource(GlobalResources.CHANGE_PASSWORD_MODULE)));
passwordSettings.setMnemonic('P');
usernameSettings=new JMenuItem("Change Username",new ImageIcon(this.getClass().getResource(GlobalResources.CHANGE_USERNAME_MODULE)));
usernameSettings.setMnemonic('U');
addEmployee=new JMenuItem("Add Employee",new ImageIcon(this.getClass().getResource(GlobalResources.ADD_MODULE)));
addEmployee.setMnemonic('A');
editEmployee=new JMenuItem("Edit Employee",new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_MODULE)));
editEmployee.setMnemonic('E');
deleteEmployee=new JMenuItem("Delete Employee",new ImageIcon(this.getClass().getResource(GlobalResources.DELETE_MODULE)));
deleteEmployee.setMnemonic('D');
quit=new JMenuItem("Quit",new ImageIcon(this.getClass().getResource(GlobalResources.CLOSE_BUTTON)));
quit.setMnemonic('Q');
paySlipReport=new JMenuItem("Pay Slip",new ImageIcon(this.getClass().getResource(GlobalResources.PAY_SLIP_MODULE)));
paySlipReport.setMnemonic('P');
statusReport=new JMenuItem("Employee Status Details",new ImageIcon(this.getClass().getResource(GlobalResources.EMPLOYEE_STATUS_MODULE)));
statusReport.setMnemonic('S');
notepadTool=new JMenuItem("Notepad",new ImageIcon(this.getClass().getResource(GlobalResources.NOTEPAD_MODULE)));
notepadTool.setMnemonic('N');
calculatorTool=new JMenuItem("Calcuator",new ImageIcon(this.getClass().getResource(GlobalResources.CALCULATOR_MODULE)));
calculatorTool.setMnemonic('C');
serverOn=new JMenuItem("ON");
serverOff=new JMenuItem("OFF");
serverOn.setMnemonic('O');
serverOff.setMnemonic('F');
menuSupport.add(queryWindow);
menuSupport.add(refreshEmployee);
menuSupport.add(help);
menuEmployee.add(addEmployee);
menuEmployee.add(editEmployee);
menuEmployee.addSeparator();
menuEmployee.add(deleteEmployee);
menuTools.add(notepadTool);
menuTools.add(calculatorTool);
menuReports.add(paySlipReport);
menuReports.add(statusReport);
menuSettings.add(passwordSettings);
menuSettings.add(usernameSettings);
menuExit.add(quit);
menuServer.add(serverOn);
menuServer.add(serverOff);
menuBar.add(menuEmployee);
menuBar.add(menuTools);
menuBar.add(menuReports);
//menuBar.add(menuServer);
menuBar.add(menuSettings);
menuBar.add(menuSupport);
menuBar.add(menuExit);
menuBar.setBackground(Color.white);
menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
return menuBar;
}


protected void unloadWindow()
{
try
{
int reply = JOptionPane.showConfirmDialog(this,"Are you sure to exit?","Quit",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
if (reply == JOptionPane.YES_OPTION)
{
JOptionPane.showMessageDialog(this,"Server is Turning Off!!","Notification",JOptionPane.INFORMATION_MESSAGE);		
System.exit(0);
}
}catch(Exception e)
{
}

}

}
