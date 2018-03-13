package com.payroll.pl.server;
import com.payroll.exceptions.*;
import com.payroll.dao.*;
import com.payroll.pl.server.*;
import com.payroll.connection.*;
import com.payroll.model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LoginFrame extends JFrame implements ActionListener
{
private JTextField username;
private JPasswordField password;
private JButton login,exit;
private JLabel usernameLabel,passwordLabel,frontLabel;
Container container;
private AdminModel adminModel;

public LoginFrame()
{
adminModel=new AdminModel();
this.setTitle("LOGIN - Payroll System");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.LOGIN_FRAME_SERVER)).getImage());
usernameLabel=new JLabel("USERNAME");
frontLabel=new JLabel("         Welcome To Complete Payroll System");
frontLabel.setFont(new Font("Segoe Print",Font.BOLD,18));
passwordLabel=new JLabel("PASSWORD");
container=getContentPane();
login=new JButton("Login",new ImageIcon(this.getClass().getResource(GlobalResources.LOGIN_FRAME_LOGIN_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
username=new JTextField();
password=new JPasswordField();
container.setLayout(null);
frontLabel.setBounds(0,0,500,70);
usernameLabel.setBounds(30,100,100,30);
passwordLabel.setBounds(30,140,100,30);
username.setBounds(200,100,100,30);
password.setBounds(200,140,100,30);
login.setBounds(100,220,100,30);
exit.setBounds(250,220,100,30);
container.setBackground(new Color(255,128,0));
frontLabel.setOpaque(true);
frontLabel.setForeground(Color.black);
frontLabel.setBackground(new Color(255,128,0));
container.add(frontLabel);
container.add(usernameLabel);
container.add(passwordLabel);
container.add(username);
container.add(password);
container.add(login);
container.add(exit);
this.setSize(500,300);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);

this.setVisible(true);
login.addActionListener(this);
exit.addActionListener(this);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
	
}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==login)
{
try{
if(isNotEmpty())
{
if(adminModel.isRightAuthentication(username.getText(),password.getText()))
{
this.dispose();
new MainMenu(); 
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Username/Password !!","Error",JOptionPane.ERROR_MESSAGE);
}
}
}catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
}
if(o==exit)
{
System.exit(0);
}
}

public boolean isNotEmpty() throws DAOException
{
if(this.username.getText().equals(""))
{
throw new DAOException("Username Can't be empty !!");
}
if(this.password.getText().equals(""))
{
throw new DAOException("Password Can't be empty !!");
}
return true;
}


public static void main(String gg[])
{
new LoginFrame();
}

}

