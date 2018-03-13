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
public class ChangeEmployeePassword extends JFrame implements ActionListener
{
private JPasswordField oldPassword,newPassword,reTypePassword;
private JButton save,exit;
private JLabel oldPasswordLabel,newPasswordLabel,reTypePasswordLabel;
private Container c;
private EmployeeModel employeeModel;
private MainMenuClient mainMenu;
private EmployeeInterface employee;
private Client client;
private Long ID;
public ChangeEmployeePassword(MainMenuClient mainMenu,EmployeeInterface employee,Client client,Long ID)
{
this.employee=employee;
this.client=client;
this.ID=ID;
this.mainMenu=mainMenu;
this.mainMenu.setVisible(false);
this.setTitle("Change Password");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.CHANGE_PASSWORD_MODULE)).getImage());
oldPassword=new JPasswordField();
newPassword=new JPasswordField();
reTypePassword=new JPasswordField();
oldPasswordLabel=new JLabel("Current Password");
newPasswordLabel=new JLabel("New Password");
reTypePasswordLabel=new JLabel("Re-Type Password");
oldPasswordLabel.setOpaque(true);
newPasswordLabel.setOpaque(true);
reTypePasswordLabel.setOpaque(true);
newPasswordLabel.setBackground(new Color(137,177,78));
oldPasswordLabel.setBackground(new Color(137,177,78));
reTypePasswordLabel.setBackground(new Color(137,177,78));
save=new JButton("Save",new ImageIcon(getClass().getResource(GlobalResources.SAVE_BUTTON)));
exit=new JButton("Exit",new ImageIcon(getClass().getResource(GlobalResources.EXIT_BUTTON)));
c=getContentPane();
c.setLayout(null);
c.setBackground(new Color(137,177,78));
oldPasswordLabel.setBounds(10,10,120,30);
newPasswordLabel.setBounds(10,50,120,30);
reTypePasswordLabel.setBounds(10,90,130,30);
oldPassword.setBounds(150,10,100,30);
newPassword.setBounds(150,50,100,30);
reTypePassword.setBounds(150,90,100,30);
save.setBounds(50,140,90,30);
exit.setBounds(150,140,90,30);
c.add(newPasswordLabel);
c.add(oldPasswordLabel);
c.add(reTypePassword);
c.add(reTypePasswordLabel);
c.add(newPassword);
c.add(oldPassword);
c.add(save);
c.add(exit);
setSize(300,250);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
save.addActionListener(this);
exit.addActionListener(this);
setVisible(true);
this.addWindowListener(new WindowAdapter(){
 ChangeEmployeePassword cap=ChangeEmployeePassword.this;        
     public void windowClosing(WindowEvent e)
     {
      cap.unloadWindow();  
        }
     });

setResizable(false);
	

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==save)
{
try{
if((employee.getPassword().trim()).equals(String.valueOf(oldPassword.getText())))
{
if(String.valueOf(newPassword.getText()).equals("")==false && confirm(String.valueOf(newPassword.getText()),String.valueOf(reTypePassword.getText())))
{
employee.setPassword(String.valueOf(newPassword.getText().trim()));
employee.setID(ID);
client.updateInfo(ID,employee);
JOptionPane.showMessageDialog(this,"Successfully Updated!!","Notification",JOptionPane.INFORMATION_MESSAGE);
}
else
{
JOptionPane.showMessageDialog(this,"new Password & ReType Password are Miss matched!!","Error",JOptionPane.ERROR_MESSAGE);
}
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Current Password !!","Error",JOptionPane.ERROR_MESSAGE);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
oldPassword.setText("");
newPassword.setText("");
reTypePassword.setText("");

}
if(ae.getSource()==exit)
{
this.dispose();
this.mainMenu.setVisible(true);
}
}

public boolean confirm(String newPassword,String reTypePassword)
{
char[] n=newPassword.toCharArray();
char[] r=reTypePassword.toCharArray();
if(n.length==r.length)
{
for(int i=0;i<n.length;i++)
{
if(n[i]!=r[i])
{
return false;
}
}
return true;
}
else
{
return false;
}

}

public void unloadWindow()
{
this.dispose();
this.mainMenu.setVisible(true);
 
}

}

