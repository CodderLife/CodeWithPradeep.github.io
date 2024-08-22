import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.String.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB_Connect.DB_Connect;

import java.awt.event.*;

public class ATM implements ActionListener{
    
    JFrame frm;
    JButton frist,second,third,fourth,five,six,inter,next;
    JTextField amount;
    JPasswordField pin,number;
JLabel amount1,number1,pin1;
    JPanel top ,center,bottom,temp;
    String a;
    int b1;
    JButton sumbit;
    JFrame frm1;
    ATM()
    {
        frm=new JFrame();
        pin=new JPasswordField(20);
        pin1=new JLabel("      INTER PIN");
        amount1=new JLabel("   INTER AMOUNT:");
        number1=new JLabel(" INTER ACCOUNT NO:");
        top=new JPanel(new GridLayout(1,1));
        temp=new JPanel(new GridLayout(3,2,0,0));
        number=new JPasswordField(20);
        //temp.setSize(400, 150);
        temp.setBackground(Color.cyan);
        amount=new JTextField(20);
        amount.setToolTipText("Inter Amount");
        amount.setBounds(250, 150, 140, 30);
Font f1=new Font("Curisive",Font.BOLD,25);
amount.setFont(f1);
number.setFont(f1);

pin.setFont(f1);

       temp.add(number1) ;temp.add(number);
        temp.add(amount1);temp.add(amount);
        temp.add(pin1);temp.add(pin);
       // center=new JPanel(new GridLayout(3,3));
        bottom=new JPanel(new GridLayout());
        frist=new JButton("500");
        frist.addActionListener(this);
            frist.setForeground(Color.white);
            frist.setBackground(Color.black);
       second =new JButton("1000");
       second.addActionListener(this);
       second.setForeground(Color.white);
            second.setBackground(Color.black);
       third =new JButton("2000");
       third.addActionListener(this);
     third.setForeground(Color.white);
          third.setBackground(Color.black);
        fourth=new JButton("3000");
        fourth.addActionListener(this);
        fourth.setForeground(Color.white);
            fourth.setBackground(Color.black);
        five=new JButton("4000");
        five.addActionListener(this);
      five.setForeground(Color.white);
      five.setBackground(Color.black);
       six =new JButton("5000");
       six.addActionListener(this);
      six.setForeground(Color.white);
           six.setBackground(Color.black);
       inter =new JButton("INTER");
      inter.setForeground(Color.white);
      inter.addActionListener(this);
           inter.setBackground(Color.black);
         next =new JButton("NEXT");
         next.setForeground(Color.white);
         next.addActionListener(this);
              next.setBackground(Color.black);
           JLabel l1=new JLabel("      WELCOME IN ATM");
           Font f=new Font("Corsive",Font.BOLD,34);
           l1.setForeground(Color.white);
           top.setBackground(Color.black);
           l1.setFont(f);
           frist.setBounds(0, 180, 140, 40);
           second.setBounds(0, 220, 140, 40);
           third.setBounds(0, 260, 140, 40);
           fourth.setBounds(250, 180, 140, 40);
           five.setBounds(250, 220, 140, 40);
           six.setBounds(250, 260, 140, 40);
          
           frm.add(frist); frm.add(second); frm.add(third);
           frm.add(fourth); frm.add(five); frm.add(six);
           temp.setBounds(0, 40, 400, 110);
           frm.add(temp);
           //    center.add(frist);center.add(second);
        //    center.add(third);center.add(fourth);
        //    center.add(five);center.add(six);
           bottom.add(inter);
           bottom.add(next);
           top.add(l1);
           frm.setSize(400,400);
           frm.setLayout(new BorderLayout());
           frm.setVisible(true);
           frm.setLocationRelativeTo(null);
          
           
           frm.add(BorderLayout.NORTH,top);
           frm.add(BorderLayout.SOUTH,bottom);
        //   frm.add(BorderLayout.CENTER,center);


    }
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==sumbit)
{
    frm1.dispose();
}
if(e.getSource()==next)
{
    String num,pincode,ball;
    int total,ball1;
    try{
    String str="select *from ACCOUNT_DETAIL1 where account_no="+number.getText()+"";
    if(DB_Connect.ExcuteQuery(str))
    {
        a=number.getText();
 num=DB_Connect.rs.getString("account_no");
 pincode=DB_Connect.rs.getString("pin_no");

 ball=DB_Connect.rs.getString("amount");
 
 total=Integer.parseInt(amount.getText());
 b1=total;
ball1=Integer.parseInt(ball);
        if(total<ball1)
        {
           // pin.setVisible(true);
           // pin1.setVisible(true);
            if(pincode.equals(pin.getText()))
            {
                ball1=ball1-total;
                String ball2=String.valueOf(ball1);
                JOptionPane.showMessageDialog(frm,"AMMOUNT WITHDROL SUCCESFULL"+total,"information",JOptionPane.INFORMATION_MESSAGE);
                String sql="update ACCOUNT_DETAIL1 set amount='"+ball2+"'where account_no="+number.getText()+"";
                if(DB_Connect.ExcuteUpdate(sql))
                {
                    frm.dispose();
                    slip();
                }

            }
            else
            {
                JOptionPane.showMessageDialog(frm,"WORNGE PIN","information",JOptionPane.INFORMATION_MESSAGE);

            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(frm,"NOT SUFFCIENT AMMOUNT","information",JOptionPane.INFORMATION_MESSAGE);

        }

    }
    else{
        JOptionPane.showMessageDialog(frm,"RECORD NOT FOUND","information",JOptionPane.INFORMATION_MESSAGE);

    }
    
}
catch(Exception ee)
{
System.out.println(ee);
}
}
if(e.getSource()==frist)
{
    amount.setText(frist.getText());
}
if(e.getSource()==second)
{
    amount.setText(second.getText());
}
if(e.getSource()==third)
{
    amount.setText(third.getText());
}
if(e.getSource()==fourth)
{
    amount.setText(fourth.getText());
}
if(e.getSource()==five)
{
    amount.setText(five.getText());
}
if(e.getSource()==six)
{
    amount.setText(six.getText());
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
    withdrol= new JLabel("  Withdrol Amount:");
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
        new ATM();
    }
}
