package com.payroll.pl.client;
import com.payroll.exceptions.*;
import com.payroll.server.*;
import com.payroll.interfaces.*;
import com.payroll.pl.server.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class LoginFrameClient extends JFrame implements ActionListener
{
private JTextField username;
private JPasswordField password;
private JButton login,exit,help;
private ButtonGroup group;
private JRadioButton userAttendence,userLogin;
private JLabel usernameLabel,passwordLabel,frontLabel;
private Container container;
private Client client;
private EmployeeInterface employee;
private String IP;
public LoginFrameClient(String IP)
{
help=new JButton("Help");
this.IP=IP;
this.setTitle("EMPLOYEE LOGIN - Payroll System");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.LOGIN_FRAME_SERVER)).getImage());
usernameLabel=new JLabel("USERNAME");
frontLabel=new JLabel("         Welcome To Complete Payroll System");
frontLabel.setFont(new Font("Segoe Print",Font.BOLD,18));
passwordLabel=new JLabel("PASSWORD");
container=getContentPane();
login=new JButton("Submit",new ImageIcon(this.getClass().getResource(GlobalResources.LOGIN_FRAME_LOGIN_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
group=new ButtonGroup();

userLogin=new JRadioButton("Login",true);
userLogin.setOpaque(true);
userLogin.setBackground(new Color(0,255,255));
userAttendence=new JRadioButton("Attendence",false);
userAttendence.setOpaque(true);
userAttendence.setBackground(new Color(0,255,255));
group.add(userAttendence);
group.add(userLogin);
username=new JTextField();
password=new JPasswordField();
container.setLayout(null);
frontLabel.setBounds(0,0,500,70);
usernameLabel.setBounds(70,100,100,30);
passwordLabel.setBounds(70,140,100,30);
username.setBounds(200,100,100,30);
password.setBounds(200,140,100,30);
userLogin.setBounds(60,190,100,30);
userAttendence.setBounds(190,190,100,30);
login.setBounds(100,230,130,30);
exit.setBounds(250,230,100,30);
help.setBounds(400,260,80,20);
container.setBackground(new Color(0,255,255));
frontLabel.setOpaque(true);
frontLabel.setForeground(Color.black);
frontLabel.setBackground(new Color(0,255,255));
container.add(frontLabel);
container.add(usernameLabel);
container.add(passwordLabel);
container.add(userAttendence);
container.add(userLogin);
container.add(username);
container.add(password);
container.add(login);
container.add(exit);
container.add(help);
this.setSize(500,320);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);
login.addActionListener(this);
exit.addActionListener(this);
help.addActionListener(this);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);	
}

public void actionPerformed(ActionEvent ae)
{
String state="",attendenceTime="",lastLoginTime="",date1="",month1="",year1="",date2="",month2="",year2="";
int comma=0;
StringTokenizer st;
Object o=ae.getSource();
if(o==help)
{
try{
client=new Client(IP);
new GeneralQuery(this,this.client);
}catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
}
}
if(o==login)
{
try{
client=new Client(IP);
if(isNotEmpty() && client.isRightAuthentication(username.getText(),password.getText()) && this.checkInt(username))
{
this.employee=client.get(Long.parseLong(username.getText().trim()));
state=this.employee.getLastLoginState();
if(userAttendence.isSelected())
{
comma=state.indexOf(",");
attendenceTime=state.substring(0,comma);
if(attendenceTime.equals("Attendence Time")==false)
{
st=new StringTokenizer(attendenceTime," ");
while(st.hasMoreTokens())
{
st.nextToken();
month1=st.nextToken();
date1=st.nextToken();
st.nextToken();
st.nextToken();
year1=st.nextToken();
}
st=new StringTokenizer(String.valueOf(Calendar.getInstance().getTime())," ");
while(st.hasMoreTokens())
{
st.nextToken();
month2=st.nextToken();
date2=st.nextToken();
st.nextToken();
st.nextToken();
year2=st.nextToken();
}
if(month1.equals(month2)==false || date1.equals(date2)==false || year1.equals(year2)==false)
{
int count=this.employee.getAttendence();
count=count+1;
this.employee.setAttendence(count);
attendenceTime=String.valueOf(Calendar.getInstance().getTime());
String text=attendenceTime+","+this.employee.getLastLoginState().substring(comma+1);
this.employee.setLastLoginState(text);
this.client.updateInfo(this.employee.getID(),this.employee);
JOptionPane.showMessageDialog(this,"Attendence Granted - "+ this.employee.getName().toUpperCase(),"Notification",JOptionPane.INFORMATION_MESSAGE);
}
else
{
JOptionPane.showMessageDialog(this,"Today's Attendence Already Granted - "+ this.employee.getName().toUpperCase(),"Error",JOptionPane.WARNING_MESSAGE);
}
}
if(attendenceTime.equals("Attendence Time"))
{
int count=this.employee.getAttendence();
count=count+1;
this.employee.setAttendence(count);
attendenceTime=String.valueOf(Calendar.getInstance().getTime());
String text=attendenceTime+","+this.employee.getLastLoginState().substring(comma+1);
this.employee.setLastLoginState(text);
this.client.updateInfo(this.employee.getID(),this.employee);
JOptionPane.showMessageDialog(this,"Attendence Granted - "+ this.employee.getName().toUpperCase(),"Notification",JOptionPane.INFORMATION_MESSAGE);
}
}
if(userLogin.isSelected())
{
if(this.employee.getLoginState()==10 || this.employee.getLoginState()==00)
{
this.employee.setLoginState(11);
this.client.updateInfo(this.employee.getID(),this.employee);
new MainMenuClient(this.employee,this,client,Long.parseLong(username.getText().trim()));
JOptionPane.showMessageDialog(this,"Logged In successfully!!","Notification",JOptionPane.INFORMATION_MESSAGE);
}
else
{
JOptionPane.showMessageDialog(this,"Already Logged In User  : "+this.employee.getName().toUpperCase(),"Error",JOptionPane.WARNING_MESSAGE);
}
}
}
else
{
JOptionPane.showMessageDialog(this,"Invalid USERNAME/PASSWORD","Error",JOptionPane.WARNING_MESSAGE);
}
}catch(Exception e)
{
try{
if(e.getMessage().trim().equals("null")==false)
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
}catch(Exception ee)
{
}
}
username.setText("");
password.setText("");
}

if(o==exit)
{
System.exit(0);
}
}

public boolean isNotEmpty() throws DAOException
{
if(this.username.getText().trim().equals(""))
{
throw new DAOException("Username Can't be empty !!");
}
if(this.password.getText().trim().equals(""))
{
throw new DAOException("Password Can't be empty !!");
}
return true;
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



public static void main(String args[])
{
new LoginFrameClient(args[0]);
}

}

