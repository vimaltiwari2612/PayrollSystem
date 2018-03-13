# PayrollSystem

A Payroll system used to generate pay slips and reports of employee's allowances and deductions.

It is made up using JAVA RMI architecture.

Server features :
1. add, edit , delete employee details
![screeenshot](https://github.com/vimaltiwari2612/PayrollSystem/blob/master/1.png)

2. generate payslips, refresh database for client side login issues.
![screeenshot](https://github.com/vimaltiwari2612/PayrollSystem/blob/master/2.png)

client feature :using there Employee id and password
1.mark attendence
![screeenshot](https://github.com/vimaltiwari2612/PayrollSystem/blob/master/4.png)

2.generate payslips , edit personal details , change password.
![screeenshot](https://github.com/vimaltiwari2612/PayrollSystem/blob/master/3.png)

for more details, explore the app...


#howtoRunIt

1.open cmd

2. cd upto pyrollsystem.jar

3. start server type  java -cp PayrollSystem.jar; com.payroll.pl.server.StartFrame
 Username:admin
 password:1234

4. open another cmd 

5. cd upto pyrollsystem.jar

6. start client type java -cp PayrollSystem.jar; com.payroll.pl.client.LoginFrameClient yourSystemIPAddress
Username:employeeid generated when registerd

password:password generated when registerd




HAVE FUN!!



