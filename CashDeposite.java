import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import DB_Connect.DB_Connect;
public class CashDeposite implements ActionListener{
    JFrame frm,frm1;
    JButton inter,sumbit;
JLabel number,amount,captcha,head,temp,temp1,type1;
JTextField number1,amount1,captcha1;
JComboBox type;
JPanel top,center,bottom;
String a;
int b1;
    
    CashDeposite()
    {
        frm=new JFrame();
        top=new JPanel(new GridLayout(1,1));
        bottom=new JPanel(new GridLayout());
        center=new JPanel(new GridLayout(5,2));
        inter=new JButton("INTER");
        inter.addActionListener(this);
        number=new JLabel("  Inter A/C No:");
        amount=new JLabel("  Inter Amount:");
        captcha=new JLabel("  Inter Captcha");
        head=new JLabel("    Cash Deposite");
        temp=new JLabel("               ");
        temp1=new JLabel("               ");
        Random r=new Random();
        int num=r.nextInt(99999);
        temp1.setText(""+num);
        type1=new JLabel("  Type of Account:"); 
        String str[]={"Saving A/C","Fixed Deposite A/C","Bussiness A/C","Crrent A/C"};
        type=new JComboBox(str);
        number1=new JTextField(20);
        amount1=new JTextField(20);
       captcha1=new JTextField(20);
       center.add(number);center.add(number1);
       center.add(amount);center.add(amount1);
     
       center.add(type1);center.add(type);
       center.add(captcha);center.add(captcha1);
       center.add(temp);  center.add(temp1);
        Font f=new Font("Cursive",Font.BOLD,34);
        temp1.setFont(f);
       // temp1.setForeground(Color.white);
      //  temp1.setBackground(Color.black);
        head.setForeground(Color.white);
        head.setFont(f);
        top.setBackground(Color.black);
        top.add(head);
        bottom.add(inter);
        frm.setSize(400, 400);
        frm.setLayout(new BorderLayout());
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.add(BorderLayout.NORTH,top);
        frm.add(BorderLayout.CENTER,center);
       frm.add(BorderLayout.SOUTH,bottom);
    }
 public void actionPerformed(ActionEvent e)
 {
    if(e.getSource()==inter)
    {
        try{
        String str="select *from Account_Detail1 where account_no='"+number1.getText()+"'";
        a=number1.getText();
        if(DB_Connect.ExcuteQuery(str))
        {
            String num=(DB_Connect.rs.getString("amount"));
            System.out.println(num);
            int amount=Integer.parseInt(amount1.getText())+Integer.parseInt(num);
            b1=Integer.parseInt(amount1.getText());
            String amount1=String.valueOf(amount);
            String sql="update account_detail1 set amount="+amount1+" where account_no='"+number1.getText()+"'";
            if(DB_Connect.ExcuteUpdate(sql))
            {
                JOptionPane.showMessageDialog(frm,"AMMOUNT Deposite SUCCESFULL","information",JOptionPane.INFORMATION_MESSAGE);

                slip();
            }
        
        }
        else
        {
            JOptionPane.showMessageDialog(frm,"Record not found","information",JOptionPane.INFORMATION_MESSAGE);

        }
        }
        catch(Exception e2)
        {
            System.out.println(e2);
        }
    }
    if(e.getSource()==sumbit)
    {
frm1.dispose();
    }

 }
 public void slip()
{
    
    JLabel  id,name,fname,account,withdrol,l1,amount;
    JLabel id1,name1,fname1,account1,withdrol1,amount1;
   
    int res;
    JPanel top, botom,center;
   
    frm1=new JFrame();
    top=new JPanel(new GridLayout(1,1));
    center=new JPanel(new GridLayout(6,2));
    botom=new JPanel();
    id= new JLabel("   Custermer_Id:");
    name=new JLabel("  Holder Name:");
    fname= new JLabel(" Father name:");
    account= new JLabel(" Account NO:");
    withdrol= new JLabel("  Deposite Amount:");
    amount=new JLabel(" Total Amount");
    
    sumbit=new JButton("OK");
    sumbit.addActionListener(this);
    id1= new JLabel("");
    name1=new JLabel("");
    fname1= new JLabel("");
    account1= new JLabel("");
    withdrol1= new JLabel("");
    amount1=new JLabel("");
    Font f=new Font("Cursive",Font.BOLD,34);
    Font f1=new Font("Cursive",Font.BOLD,24);
    withdrol1.setFont(f1);amount1.setFont(f1);
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
      withdrol1 .setText(""+b1);
       amount1.setText(""+DB_Connect.rs.getString("amount"));   

    }
    catch(Exception eeee)
    {
System.out.println(eeee);
    }
    }
    center.add(id);center.add(id1);center.add(name);center.add(name1);center.add(fname);center.add(fname1);
    center.add(account);center.add(account1);center.add(withdrol);center.add(withdrol1);center.add(amount);center.add(amount1);
    frm1.setSize(400,400);
    frm1.setLayout(new BorderLayout());
    frm1.setVisible(true);
    frm1.setLocationRelativeTo(null);
    frm1.setResizable(false);
    frm1.add(BorderLayout.CENTER,center);
    frm1.add(BorderLayout.SOUTH,botom);
frm1.add(BorderLayout.NORTH,top);
}
    public static void main(String[] args) {
        new CashDeposite();
    }
}
