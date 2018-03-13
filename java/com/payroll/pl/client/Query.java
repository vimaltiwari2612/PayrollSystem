package com.payroll.pl.client;
import com.payroll.exceptions.*;
import com.payroll.dao.*;
import com.payroll.pl.client.*;
import com.payroll.connection.*;
import com.payroll.model.*;
import com.payroll.server.*;
import com.payroll.interfaces.*;
import com.payroll.pl.server.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Query extends JFrame implements ActionListener
{
private JButton send,exit;
private JTextArea queryArea;
private JScrollPane scrollPane;
private JLabel query;
private Container container;
private EmployeeModel employeeModel;
private MainMenuClient mainMenu;
private EmployeeInterface employee;
private Client client;
private Long ID;
public Query(MainMenuClient mainMenu,EmployeeInterface employee,Client client,Long ID)
{
this.employee=employee;
this.client=client;
this.ID=ID;
this.mainMenu=mainMenu;
this.mainMenu.setVisible(false);
this.setTitle("Queries & Support");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)).getImage());
container=getContentPane();
send=new JButton("Send");
exit=new JButton("Exit");
queryArea=new JTextArea(6,12);
scrollPane=new JScrollPane(queryArea);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
query=new JLabel("Having Queries...??\nType here...");
this.setLayout(null);
query.setBounds(10,10,300,50);
scrollPane.setBounds(10,60,300,300);
send.setBounds(20,380,80,30);
exit.setBounds(120,380,80,30);
container.add(send);
container.add(exit);
container.add(scrollPane);
container.add(query);
setSize(360,460);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
send.addActionListener(this);
exit.addActionListener(this);
setVisible(true);
this.addWindowListener(new WindowAdapter(){
 Query cap=Query.this;        
     public void windowClosing(WindowEvent e)
     {
      cap.unloadWindow();  
        }
     });

setResizable(false);	
}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==send)
{
if(this.queryArea.getText().trim().equals(""))
{
JOptionPane.showMessageDialog(this,"Query Can't be Empty","Error",JOptionPane.WARNING_MESSAGE);
}
else
{
try{
this.client.sendMessage(employee.getID(),this.queryArea.getText().trim());
JOptionPane.showMessageDialog(this,"Sent!","Notification",JOptionPane.PLAIN_MESSAGE);
this.queryArea.setText("");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
}
}
}

if(o==exit)
{
this.unloadWindow();
}


}


public void unloadWindow()
{
this.dispose();
this.mainMenu.setVisible(true); 
}

}

