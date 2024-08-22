import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import DB_Connect.*;
public class Account_Detail implements ActionListener {

JFrame frm;
JLabel  id,name,fname,account,pin,l1,amount;
JLabel id1,name1,fname1,account1,pin1,amount1;
JButton sumbit;
int res;
JPanel top, botom,center;
Account_Detail()
{
frm=new JFrame();
top=new JPanel(new GridLayout(1,1));
center=new JPanel(new GridLayout(6,2));
botom=new JPanel();
id= new JLabel("   Custermer_Id:");
name=new JLabel("  Holder Name:");
fname= new JLabel(" Father name:");
account= new JLabel(" Account NO:");
pin= new JLabel("  PIN NO:");
amount=new JLabel(" Total Amount");
frm=new JFrame();
sumbit=new JButton("Sumbit");
sumbit.addActionListener(this);
id1= new JLabel("");
name1=new JLabel("");
fname1= new JLabel("");
account1= new JLabel("");
pin1= new JLabel("");
amount1=new JLabel("");
Font f=new Font("Cursive",Font.BOLD,34);
Font f1=new Font("Cursive",Font.BOLD,20);
l1=new JLabel("  ACCOUNT _DETAILS");
l1.setFont(f);
l1.setForeground(Color.white);
top.setBackground(Color.black);
try{
    String SQL="select MAX(c_id) from REGISTERS";
if(DB_Connect.ExcuteQuery(SQL))
{
 res=DB_Connect.rs.getInt(1);
 
System.out.println(res);
}
   }
   catch(Exception ee)
   {
System.out.println(ee);
   }

String str="select *from REGISTERS where c_id="+res+"";
if(DB_Connect.ExcuteQuery(str))
{
    try{
name1.setText(""+DB_Connect.rs.getString("name"));
fname1.setText(""+DB_Connect.rs.getString("Fname"));
}
catch(Exception e1)
{
System.out.println(e1);
}
}
Random r=new Random();
int num=r.nextInt(9999999);
int p=r.nextInt(9999);
account1.setText(""+num);
pin1.setText(""+p);
account1.setFont(f1);
pin1.setFont(f1);
amount1.setText(""+500);
id1.setText(""+res);

center.add(id);center.add(id1);
center.add(name);center.add(name1);
center.add(fname);center.add(fname1);
center.add(account);center.add(account1);
center.add(pin);center.add(pin1);
center.add(amount);center.add(amount);
top.add(l1);
botom.add(sumbit);
frm.setSize(400,400);
frm.setLayout(new BorderLayout());
frm.setVisible(true);
frm.setLocationRelativeTo(null);
frm.setResizable(false);
frm.add(BorderLayout.NORTH,top);
frm.add(BorderLayout.CENTER,center);
frm.add(BorderLayout.SOUTH,botom);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==sumbit)
{
String str="insert into ACCOUNT_DETAIL1 values("+res+",'"+name1.getText()+"','"+fname1.getText()+"','"+account1.getText()+"','"+pin1.getText()+"','"+amount1.getText()+"')";
if(DB_Connect.ExcuteUpdate(str))
{
new Login();
}
else
{
    System.out.println("Error");
}
}
}




public static void main(String[] args) {
    new Account_Detail();
}    
}
