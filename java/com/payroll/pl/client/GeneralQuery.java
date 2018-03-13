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
public class GeneralQuery extends JFrame implements ActionListener
{
private JButton send,exit;
private JTextArea queryArea;
private JScrollPane scrollPane;
private JLabel query,IDLabel,queryLabel;
private JTextField IDBox;
private Container container;
private Client client;
private LoginFrameClient loginFrameClient;
private Long ID;
public GeneralQuery(LoginFrameClient loginFrameClient,Client client)
{
this.loginFrameClient=loginFrameClient;
this.client=client;
this.loginFrameClient.setVisible(false);
this.setTitle("Queries & Support");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)).getImage());
container=getContentPane();
IDBox=new JTextField();
send=new JButton("Send");
exit=new JButton("Exit");
queryArea=new JTextArea(6,12);
scrollPane=new JScrollPane(queryArea);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
query=new JLabel("Having Queries...??");
queryLabel=new JLabel("Type here...");
IDLabel=new JLabel("Enter Your ID");
this.setLayout(null);
query.setBounds(10,10,300,50);
IDLabel.setBounds(10,60,300,30);
IDBox.setBounds(10,90,200,30);
queryLabel.setBounds(10,120,200,30);
scrollPane.setBounds(10,150,300,300);
send.setBounds(30,470,80,30);
exit.setBounds(130,470,80,30);
container.add(send);
container.add(exit);
container.add(scrollPane);
container.add(query);
container.add(queryLabel);
container.add(IDBox);
container.add(IDLabel);

setSize(340,540);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
send.addActionListener(this);
exit.addActionListener(this);
setVisible(true);
this.addWindowListener(new WindowAdapter(){
 GeneralQuery cap=GeneralQuery.this;        
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
if(this.IDBox.getText().trim().equals("")==false && this.checkInt(IDBox))
{
if(this.queryArea.getText().trim().equals(""))
{
JOptionPane.showMessageDialog(this,"Query Can't be Empty","Error",JOptionPane.WARNING_MESSAGE);
}
else
{
try{
this.client.sendMessage(Long.parseLong(this.IDBox.getText().trim()),this.queryArea.getText().trim());
JOptionPane.showMessageDialog(this,"Sent!","Notification",JOptionPane.PLAIN_MESSAGE);
this.queryArea.setText("");
this.IDBox.setText("");
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
}
}
}
else
{
JOptionPane.showMessageDialog(this,"Enter ID Properly !!","Error",JOptionPane.WARNING_MESSAGE);
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
this.loginFrameClient.setVisible(true); 
}


public boolean checkInt(JTextField jTextField) 
{
String text=jTextField.getText();
char[] textArray;
int count=0;
int i=0;
try{
textArray=text.toCharArray();
while(count<textArray.length)
{
i=Integer.parseInt(String.valueOf(textArray[count]));
count++;
}
return true;
}catch(Exception exception)
{
return false;
}
}


}

