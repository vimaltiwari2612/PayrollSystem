package com.payroll.pl.server;
import java.awt.*;
import javax.swing.*;
import com.payroll.pl.server.*;
public class StartFrame extends JWindow
{
Container container;
JLabel screenLabel;
String text;
StartFrame()
{
initComponents();
}

public void initComponents(){
container=getContentPane();
this.screenLabel=new JLabel(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM1)));
container.setLayout(new BorderLayout());
container.add(this.screenLabel,BorderLayout.CENTER);
setSize(484,283);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2 -this.getWidth()/2,d.height/2 - this.getHeight()/2);
setVisible(true);
}


public static void main(String gg[])
{
PicChanger pic=new PicChanger();
try
{
pic.join();
}
catch(InterruptedException ie)
{
}
new LoginFrame();
}
}


class PicChanger extends Thread
{
StartFrame startFrame1;
PicChanger()
{
startFrame1=new StartFrame();
start();
}

public void run()
{
try{
Thread.sleep(500);
startFrame1.screenLabel.setIcon(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM2)));
Thread.sleep(500);
startFrame1.screenLabel.setIcon(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM3)));
Thread.sleep(500);
startFrame1.screenLabel.setIcon(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM4)));
Thread.sleep(500);
startFrame1.screenLabel.setIcon(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM5)));
Thread.sleep(500);
startFrame1.screenLabel.setIcon(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM6)));
Thread.sleep(500);
startFrame1.screenLabel.setIcon(new ImageIcon(getClass().getResource(GlobalResources.PAYROLL_SYSTEM7)));
Thread.sleep(1000);
startFrame1.dispose();
}catch(Exception e)
{
}
}
}

