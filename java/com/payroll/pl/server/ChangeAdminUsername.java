package com.payroll.pl.server;
import com.payroll.exceptions.*;
import com.payroll.dao.*;
import com.payroll.pl.server.*;
import com.payroll.connection.*;
import com.payroll.model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ChangeAdminUsername extends JFrame implements ActionListener
{
private JTextField oldUsername,newUsername;
private JButton save,exit;
private JLabel oldUsernameLabel,newUsernameLabel;
private Container c;
private AdminModel adminModel;
private MainMenu mainMenu;
public ChangeAdminUsername(MainMenu mainMenu)
{
this.mainMenu=mainMenu;
this.setTitle("Change Username");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.CHANGE_USERNAME_MODULE)).getImage());

adminModel=new AdminModel();
oldUsername=new JTextField();
newUsername=new JTextField();
oldUsernameLabel=new JLabel("Current Username");
newUsernameLabel=new JLabel("New Username");
oldUsernameLabel.setOpaque(true);
newUsernameLabel.setOpaque(true);
newUsernameLabel.setBackground(new Color(137,177,78));
oldUsernameLabel.setBackground(new Color(137,177,78));
save=new JButton("Save",new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));
c=getContentPane();
c.setLayout(null);
c.setBackground(new Color(137,177,78));
oldUsernameLabel.setBounds(10,10,120,30);
newUsernameLabel.setBounds(10,50,120,30);
oldUsername.setBounds(140,10,100,30);
newUsername.setBounds(140,50,100,30);
save.setBounds(40,90,100,30);
exit.setBounds(150,90,100,30);
c.add(newUsernameLabel);
c.add(oldUsernameLabel);
c.add(newUsername);
c.add(oldUsername);
c.add(save);
c.add(exit);
setSize(280,170);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
save.addActionListener(this);
exit.addActionListener(this);
setVisible(true);

this.mainMenu.setVisible(false);
this.addWindowListener(new WindowAdapter(){
 ChangeAdminUsername cap=ChangeAdminUsername.this;        
     public void windowClosing(WindowEvent e)
     {
      cap.dispose();
      cap.mainMenu.setVisible(true);  
        }
     });
setResizable(false);
	
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==save)
{
try{
if(adminModel.checkUsername(oldUsername.getText().trim()) && newUsername.getText().trim().equals("")==false)
{
adminModel.updateUsername(newUsername.getText().trim());
JOptionPane.showMessageDialog(this,"Successfully Updated!!","Notification",JOptionPane.INFORMATION_MESSAGE);
oldUsername.setText("");
newUsername.setText("");

}
else
{
JOptionPane.showMessageDialog(this,"Invalid Current Username !!","Error",JOptionPane.ERROR_MESSAGE);
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
}

