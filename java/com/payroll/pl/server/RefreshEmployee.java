package com.payroll.pl.server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.payroll.exceptions.*;
import com.payroll.model.*;
import com.payroll.interfaces.*;
import java.util.*;

import com.payroll.dao.*;

public class RefreshEmployee extends JFrame implements ActionListener
{
private EmployeeInterface employee;
private EmployeeModel employeeModel;
private HashMap<String,EmployeeInterface> hashMaps;
private JLabel IDLabel;
private JTextField ID;
private JButton refresh,delete,exit;
private Container container;
private MainMenu mainMenu;
public RefreshEmployee(MainMenu mainMenu)
{
this.mainMenu=mainMenu;
container=getContentPane();
this.setTitle("Refresh Account");
this.setIconImage(new ImageIcon(getClass().getResource(GlobalResources.RESET_BUTTON)).getImage());
container.setBackground(new Color(137,177,78));
IDLabel=new JLabel("Enter an ID ");
IDLabel.setOpaque(true);
IDLabel.setBackground(new Color(137,177,78));
ID=new JTextField();
refresh=new JButton("Refresh",new ImageIcon(this.getClass().getResource(GlobalResources.RESET_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
delete=new JButton("Delete",new ImageIcon(getClass().getResource(GlobalResources.DELETE_BUTTON)));
container.setLayout(null);
IDLabel.setBounds(10,20,100,30);
ID.setBounds(120,20,100,30);
refresh.setBounds(10,60,120,30);
exit.setBounds(140,60,100,30);
container.add(IDLabel);
container.add(ID);
container.add(refresh);
container.add(exit);
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
this.setVisible(true);
employeeModel=new EmployeeModel();
setSize(270,130);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
refresh.addActionListener(this);
exit.addActionListener(this);
setResizable(false);
	
this.addWindowListener(new WindowAdapter(){
 RefreshEmployee de=RefreshEmployee.this;        
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
if(o==refresh)
{
try
{
if(ID.getText().trim().equals("")==false && employeeModel.checkChar(ID)==false)
{
if(employeeModel.exists(Long.parseLong(ID.getText().trim())))
{
employeeModel.refresh(Long.parseLong(ID.getText().trim()));
JOptionPane.showMessageDialog(this,"Refreshed!!","Notification",JOptionPane.INFORMATION_MESSAGE);
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
}
