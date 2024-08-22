import DB_Connect.*;

import java.awt.event.*;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Login implements ActionListener{
JFrame frm;
JButton Register,clear,Sign;
JTextField user,Captch;
JPasswordField password;
JLabel head,name,pass,Captcha,code,temp;
JPanel top,center,bottom;
Font f;

Login()
{
    frm=new JFrame("ATM LOGIN");
    top=new JPanel(new GridLayout(1,1));
    center=new JPanel(new GridLayout(4,4));
    bottom=new JPanel(new GridLayout(1,3));
    head=new JLabel("       WELCOME TO BANK");
 
    head.setForeground(Color.white);
    top.setBackground(Color.black);
    f=new Font("Cursive",Font.BOLD,30);
    head.setFont(f);
    name=new JLabel("   INTER A/C NO:");
    pass=new JLabel("   INTER PIN:");
    Captcha=new JLabel("   Captcha:");
    temp=new JLabel("               ");
    code=new JLabel();

    Random r=new Random();
    int res=r.nextInt(99999);
    code.setText(""+res);
    code.setFont(f);
    //code.setForeground(Color.cyan);
    user=new JTextField(20);
    Captch=new JTextField(20);
    password=new JPasswordField(20);
    Register=new JButton("Login");
    Register.addActionListener(this);
    Sign=new JButton("Create A/C");
    Sign.setBackground(Color.cyan);
    Register.setBackground(Color.pink);
    Sign.addActionListener(this);
    clear=new JButton("Clear");
    clear.setBackground(Color.magenta);
    clear.addActionListener(this);
    frm.setSize(400,300);
    frm.setVisible(true);
    frm.setResizable(false);
    frm.setLayout(new BorderLayout());
    frm.setLocationRelativeTo(null);
    top.add(head);center.add(name);center.add(user);
    center.add(pass);center.add(password);
    center.add(Captcha);center.add(Captch);center.add(temp);center.add(code);
    bottom.add(Register);bottom.add(Sign);bottom.add(clear);
    frm.add(BorderLayout.NORTH,top);
    frm.add(BorderLayout.CENTER,center);
    frm.add(BorderLayout.SOUTH,bottom);
   // frm.setBackground(Color.red);
   frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==Register)
{
    
    int number=0;
    int pin=0;
    try{
    String str1="select *from Account_Detail1 where Account_No="+user.getText()+"";
    
    DB_Connect.res=DB_Connect.ExcuteQuery(str1);
    if( DB_Connect.res==true)
    {
 number=DB_Connect.rs.getInt("Account_NO");
 pin=DB_Connect.rs.getInt("pin_no");
 if(code.getText().equals(Captch.getText()))
 {
    if(user.getText().equals(String.valueOf(number)))
    {
        if(password.getText().equals(String.valueOf(pin)))
        {
            new MainWindow();
        }
        else{
            System.out.println(pin);
            System.out.println("Worng pin");
        }
    }
    else{

        System.out.println("worng Account number");
    }
 }
 else{
    System.out.println("Wornge Chaptacha code");
 }
    }
    else{
        JOptionPane.showMessageDialog(frm,"RECORD NOT FOUND INTER VALID INFORMATION","information",JOptionPane.INFORMATION_MESSAGE);

    }
    
}
catch(Exception e1)
{
System.out.println(e1);
}
}
if(e.getSource()==clear)
{
user.setText("null");
password.setText("null");

}
if(e.getSource()==Sign)
{
 // new Loading();
try{
    Thread.sleep(3000);
    frm.dispose();
  new Register();
}
catch(Exception e1)
{
System.out.println(e1);
}
}
}
    public static void main(String[] args) {
new Login();        
    }
}
