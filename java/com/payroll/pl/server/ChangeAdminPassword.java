package com.payroll.pl.server;
import com.payroll.exceptions.*;
import com.payroll.dao.*;
import com.payroll.pl.server.*;
import com.payroll.connection.*;
import com.payroll.model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ChangeAdminPassword extends JFrame implements ActionListener
{
private JPasswordField oldPassword,newPassword,reTypePassword;
private JButton save,exit;
private JLabel oldPasswordLabel,newPasswordLabel,reTypePasswordLabel;
private Container c;
private AdminModel adminModel;
private MainMenu mainMenu;
public ChangeAdminPassword(MainMenu mainMenu)
{
this.mainMenu=mainMenu;
this.mainMenu.setVisible(false);
this.setTitle("Change Password");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.CHANGE_PASSWORD_MODULE)).getImage());

adminModel=new AdminModel();
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
save=new JButton("Save",new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
c=getContentPane();
c.setLayout(null);
setResizable(false);
	
c.setBackground(new Color(137,177,78));
oldPasswordLabel.setBounds(10,10,120,30);
newPasswordLabel.setBounds(10,50,120,30);
reTypePasswordLabel.setBounds(10,90,130,30);
oldPassword.setBounds(150,10,100,30);
newPassword.setBounds(150,50,100,30);
reTypePassword.setBounds(150,90,100,30);
save.setBounds(40,140,100,30);
exit.setBounds(150,140,100,30);
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
 ChangeAdminPassword cap=ChangeAdminPassword.this;        
     public void windowClosing(WindowEvent e)
     {
      cap.unloadWindow();  
        }
     });

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==save)
{
try{
if(adminModel.checkPassword(String.valueOf(oldPassword.getText()).trim()))
{
if(String.valueOf(newPassword.getText()).trim().equals("")==false && confirm(String.valueOf(newPassword.getText()),String.valueOf(reTypePassword.getText())))
{
adminModel.updatePassword(String.valueOf(newPassword.getText()).trim());
JOptionPane.showMessageDialog(this,"Successfully Updated!!","Notification",JOptionPane.INFORMATION_MESSAGE);
oldPassword.setText("");
newPassword.setText("");
reTypePassword.setText("");
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

