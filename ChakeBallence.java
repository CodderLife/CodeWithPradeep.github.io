import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import DB_Connect.DB_Connect;
public class ChakeBallence implements ActionListener{
    JFrame frm,frm1;
    JButton inter,sumbit;
JLabel l1,l2;
JTextField tr,tr1;
JPanel center,bottom;
String a;
    
ChakeBallence()
    {
frm=new JFrame();
center=new JPanel(new GridLayout(2,2));

bottom=new JPanel();
l1=new JLabel(" INTER A/C::");
l2=new JLabel("  INTER Pin::");
inter=new JButton("Inter");
inter.addActionListener(this);
tr=new JTextField(20);
tr1=new JTextField(20);
sumbit=new JButton("SUBMIT");
sumbit.addActionListener(this);
bottom.add(inter);
frm.setVisible(true);
 frm.setSize(400,200);
 frm.setLayout(new BorderLayout());
frm.setLocationRelativeTo(null);
center.add(l1);center.add(tr);
center.add(l2);center.add(tr1);
frm.add(BorderLayout.CENTER,center);
frm.add(BorderLayout.SOUTH,bottom);

    }
  public void actionPerformed(ActionEvent e)
  {
if(e.getSource()==inter)
{
    try{
        a=tr.getText();
String sql="select *from account_detail1 where account_no='"+tr.getText()+"'";
if(DB_Connect.ExcuteQuery(sql))
{
if(tr1.getText().equals(DB_Connect.rs.getString("pin_no")))
{
    frm.dispose();
slip();
}
else{
    JOptionPane.showMessageDialog(frm,"PLEASE INTER CURRECT PIN","information",JOptionPane.INFORMATION_MESSAGE);

}
}
else
{
    JOptionPane.showMessageDialog(frm,"RECORD NOT FOUND","information",JOptionPane.INFORMATION_MESSAGE);
 
}
}

catch(Exception e1)
{
System.out.println(e1);
}
  }
if(e.getSource()==sumbit)
{
frm1.dispose();
new MainWindow();
}
}  
public void slip()
{
    
    JLabel  id,name,fname,account,l1,amount;
    JLabel id1,name1,fname1,account1,amount1;
   
    int res;
    JPanel top, botom,center;
   
    frm1=new JFrame();
    top=new JPanel(new GridLayout(1,1));
    center=new JPanel(new GridLayout(5,2));
    botom=new JPanel();
    id= new JLabel("   Custermer_Id:");
    name=new JLabel("  Holder Name:");
    fname= new JLabel(" Father name:");
    account= new JLabel(" Account NO:");
   
    amount=new JLabel(" Total Amount");
    
    sumbit=new JButton("OK");
    sumbit.addActionListener(this);
    id1= new JLabel("");
    name1=new JLabel("");
    fname1= new JLabel("");
    account1= new JLabel("");
    
    amount1=new JLabel("");
    Font f=new Font("Cursive",Font.BOLD,34);
    Font f1=new Font("Cursive",Font.BOLD,24);

    l1=new JLabel("       Slip of Deposite Amount");
    l1.setFont(f);
    l1.setForeground(Color.white);
    top.setBackground(Color.black);
    top.add(l1);
    botom.add(sumbit);
    String sql="select *from Account_detail1 where account_no='"+a+"'";
    if(DB_Connect.ExcuteQuery(sql))
    {
        try{
        id1.setText(""+DB_Connect.rs.getInt(1));
       name1.setText(""+DB_Connect.rs.getString("name"));
      fname1 .setText(""+DB_Connect.rs.getString("fname"));
       account1.setText("XXXX"+DB_Connect.rs.getString("account_no"));
     
       amount1.setText(""+DB_Connect.rs.getString("amount"));   
amount1.setFont(f1);
    }
    catch(Exception eeee)
    {
System.out.println(eeee);
    }
    }
    center.add(id);center.add(id1);center.add(name);center.add(name1);center.add(fname);center.add(fname1);
    center.add(account);center.add(account1);center.add(amount);center.add(amount1);
    frm1.setSize(400,400);
    frm1.setLayout(new BorderLayout());
    frm1.setVisible(true);
    frm1.setLocationRelativeTo(null);
    frm1.setResizable(false);
    frm1.add(BorderLayout.CENTER,center);
    frm1.add(BorderLayout.SOUTH,botom);
frm1.add(BorderLayout.NORTH,top);
}

    

    public static void main(String args[])
    {
new ChakeBallence();
    }
}