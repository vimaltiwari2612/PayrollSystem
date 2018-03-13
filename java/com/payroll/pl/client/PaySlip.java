package com.payroll.pl.client;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.event.*;
import com.payroll.exceptions.*;
import com.payroll.interfaces.*;
import java.util.*;
import com.payroll.pl.client.*;
import com.payroll.pl.server.*;

public class PaySlip extends JFrame implements ActionListener,Printable
{
private MainMenuClient mainMenu;
private EmployeeInterface e;
private Long ID;
private JLabel
paySlipLabel,IDLabel1,nameLabel1,packageLabel1,phoneNumberLabel1,emailLabel1,addressLabel1,ageLabel1,designationLabel1,netSalaryLabel1,IDLabel2,nameLabel2,packageLabel2,phoneNumberLabel2,emailLabel2,addressLabel2,ageLabel2,designationLabel2,netSalaryLabel2,deductionLabel,allowanceLabel,licLabel1,gpfLabel1,itLabel1,otherTaxLabel1,dearnessLabel1,ccLabel1,hrLabel1,otherAllowanceLabel1,vehicleLabel1,dailyLabel1,medicalLabel1,overTimeLabel1,licLabel2,gpfLabel2,itLabel2,otherTaxLabel2,dearnessLabel2,ccLabel2,hrLabel2,otherAllowanceLabel2,vehicleLabel2,dailyLabel2,medicalLabel2,overTimeLabel2,dateLabel;
private Container container;
private JButton print,exit;
private Calendar c;
PaySlip(EmployeeInterface e,MainMenuClient m,Long ID)
{
container=getContentPane();

container.setBackground(Color.white);
this.e=e;
mainMenu=m;
this.ID=ID;
c=Calendar.getInstance();
mainMenu.setVisible(false);
dateLabel=new JLabel(String.valueOf(c.getTime()).trim());
print=new JButton("Print",new ImageIcon(this.getClass().getResource(GlobalResources.PRINT_BUTTON)));
exit=new JButton("Exit",new ImageIcon(this.getClass().getResource(GlobalResources.EXIT_BUTTON)));

this.setTitle("Pay Slip - "+ e.getName().toUpperCase());
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.PAY_SLIP_MODULE)).getImage());

setResizable(false);
	
paySlipLabel=new JLabel("Pay Slip");
paySlipLabel.setFont(new Font("Times New Roman",Font.BOLD,28));
paySlipLabel.setOpaque(true);
IDLabel1=new JLabel("Employee ID");
nameLabel1=new JLabel("Employee Name");
ageLabel1=new JLabel("Employee Age");
phoneNumberLabel1=new JLabel("Employee Contact NO.");
emailLabel1=new JLabel("Employee Email ");
addressLabel1=new JLabel("Employee Address");
designationLabel1=new JLabel("Employee Designation");
allowanceLabel=new JLabel("Allowances");
deductionLabel=new JLabel("Deductions");
dearnessLabel1=new JLabel("Dearness");
ccLabel1=new JLabel("City Compensatory");
overTimeLabel1=new JLabel("Over Time");
medicalLabel1=new JLabel("Medical");
hrLabel1=new JLabel("Home Rent");
vehicleLabel1=new JLabel("Vehicle");
dailyLabel1=new JLabel("Daily");
otherAllowanceLabel1=new JLabel("Other");
licLabel1=new JLabel("Life Insurance");
itLabel1=new JLabel("Income Tax");
otherTaxLabel1=new JLabel("Other Tax");
gpfLabel1=new JLabel("General Provident Fund");
netSalaryLabel1=new JLabel("Employee Monthly salary");
IDLabel2=new JLabel(String.valueOf(ID));
nameLabel2=new JLabel(e.getName());

ageLabel2=new JLabel(String.valueOf(e.getAge()));
phoneNumberLabel2=new JLabel(String.valueOf(e.getContact()));
emailLabel2=new JLabel(e.getEmail());
addressLabel2=new JLabel(e.getAddress());
designationLabel2=new JLabel(e.getDesignation());
dearnessLabel2=new JLabel(String.valueOf(e.getDearnessAllowance()));
ccLabel2=new JLabel(String.valueOf(e.getCityCompensatoryAllowance()));
overTimeLabel2=new JLabel(String.valueOf(e.getOverTimeAllowance()));
medicalLabel2=new JLabel(String.valueOf(e.getMedicalAllowance()));
hrLabel2=new JLabel(String.valueOf(e.getHomeRentAllowance()));
vehicleLabel2=new JLabel(String.valueOf(e.getVehicleAllowance()));
dailyLabel2=new JLabel(String.valueOf(e.getDailyAllowance()));
otherAllowanceLabel2=new JLabel(String.valueOf(e.getOtherAllowance()));
licLabel2=new JLabel(String.valueOf(e.getLifeInsurance()));
itLabel2=new JLabel(String.valueOf(e.getIncomeTax()));
otherTaxLabel2=new JLabel(String.valueOf(e.getOtherTax()));
gpfLabel2=new JLabel(String.valueOf(e.getGeneralProvidentFund()));
netSalaryLabel2=new JLabel(String.valueOf(e.getNetSalary())+" /- Rs.");
paySlipLabel.setBackground(Color.white);
netSalaryLabel2.setForeground(Color.red);
phoneNumberLabel2.setForeground(Color.red);
container.setLayout(null);
paySlipLabel.setBounds(10,10,200,30);
dateLabel.setBounds(300,10,290,30);
IDLabel1.setBounds(30,70,150,20);
nameLabel1.setBounds(30,100,150,20);
ageLabel1.setBounds(30,130,150,20);
phoneNumberLabel1.setBounds(30,160,150,20);
emailLabel1.setBounds(30,190,150,20);
addressLabel1.setBounds(30,220,150,20);
designationLabel1.setBounds(30,250,150,20);
allowanceLabel.setBounds(60,290,150,20);
deductionLabel.setBounds(330,290,150,20);
ccLabel1.setBounds(30,320,150,20);
overTimeLabel1.setBounds(30,350,150,20);
medicalLabel1.setBounds(30,380,150,20);
hrLabel1.setBounds(30,410,150,20);
vehicleLabel1.setBounds(30,440,150,20);
dailyLabel1.setBounds(30,470,150,20);
otherAllowanceLabel1.setBounds(30,500,150,20);
dearnessLabel1.setBounds(30,530,150,20);
licLabel1.setBounds(250,320,150,20);
itLabel1.setBounds(250,350,150,20);
otherTaxLabel1.setBounds(250,380,150,20);
gpfLabel1.setBounds(250,410,150,20);
ccLabel2.setBounds(200,320,50,20);
overTimeLabel2.setBounds(200,350,50,20);
medicalLabel2.setBounds(200,380,50,20);
hrLabel2.setBounds(200,410,50,20);
vehicleLabel2.setBounds(200,440,50,20);
dailyLabel2.setBounds(200,470,50,20);
otherAllowanceLabel2.setBounds(200,500,50,20);
dearnessLabel2.setBounds(200,530,50,20);
licLabel2.setBounds(420,320,50,20);
itLabel2.setBounds(420,350,50,20);
otherTaxLabel2.setBounds(420,380,50,20);
gpfLabel2.setBounds(420,410,50,20);
IDLabel2.setBounds(250,70,150,20);
nameLabel2.setBounds(250,100,150,20);
ageLabel2.setBounds(250,130,150,20);
phoneNumberLabel2.setBounds(250,160,150,20);
emailLabel2.setBounds(250,190,240,20);
addressLabel2.setBounds(250,220,300,20);
designationLabel2.setBounds(250,250,150,20);
netSalaryLabel1.setBounds(30,570,150,20);
netSalaryLabel2.setBounds(250,570,150,20);
print.setBounds(180,610,120,30);
exit.setBounds(320,610,100,30);
container.add(paySlipLabel);
container.add(dateLabel);
container.add(IDLabel1);
container.add(nameLabel1);
container.add(emailLabel1);
container.add(addressLabel1);
container.add(phoneNumberLabel1);
container.add(designationLabel1);
container.add(allowanceLabel);
container.add(otherAllowanceLabel1);
container.add(otherAllowanceLabel2);
container.add(deductionLabel);
container.add(itLabel1);
container.add(itLabel2);
container.add(gpfLabel2);
container.add(gpfLabel1);
container.add(licLabel2);
container.add(licLabel1);
container.add(otherTaxLabel1);
container.add(otherTaxLabel2);
container.add(ccLabel1);
container.add(ccLabel2);
container.add(hrLabel1);
container.add(hrLabel2);
container.add(vehicleLabel1);
container.add(vehicleLabel2);
container.add(dailyLabel1);
container.add(dailyLabel2);
container.add(medicalLabel1);
container.add(medicalLabel2);
container.add(overTimeLabel1);
container.add(overTimeLabel2);
container.add(dearnessLabel1);
container.add(dearnessLabel2);
container.add(ageLabel1);
container.add(IDLabel2);
container.add(nameLabel2);
container.add(emailLabel2);
container.add(allowanceLabel);
container.add(netSalaryLabel2);
container.add(addressLabel2);
container.add(phoneNumberLabel2);
container.add(designationLabel2);
container.add(ageLabel2);
container.add(netSalaryLabel2);
container.add(netSalaryLabel1);
container.add(print);
container.add(exit);
setSize(580,680);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);      	        
setVisible(true);
print.addActionListener(this);
exit.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
Object o=ae.getSource();
if(o==print)
{
doPrintJob();
}

if(o==exit)
{
this.dispose();
mainMenu.setVisible(true);
}
}

public void doPrintJob()
{
PrinterJob printJob = PrinterJob.getPrinterJob();
printJob.setPrintable(this);
if(printJob.printDialog()) 
{
try {
printJob.print();                  
}
catch(Exception PrintException) 
{
JOptionPane.showMessageDialog(this,"Can't Print - "+PrintException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);              
printJob.cancel();
}
}

}

public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
                      
            Graphics2D g2 = (Graphics2D)g;
            g2.translate(pf.getImageableX()+5, pf.getImageableY()+5);
            
    	    Font  f = new Font("Monospaced",Font.PLAIN,12);
    	    g2.setFont (f);
	    	paint (g2);
	    	
            return Printable.PAGE_EXISTS;
        }
  		 

               	


}