import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import DB_Connect.DB_Connect;
public class Reset implements ActionListener{
    JFrame frm,frm1;
    JButton inter,sumbit;
JLabel l1,l2,l3,l4;
JTextField tr,tr1,t3;
JPanel center,bottom,top;
String a;
    
Reset()
    {
frm=new JFrame();
center=new JPanel(new GridLayout(3,2));
top=new JPanel(new GridLayout(1,1));
bottom=new JPanel();
l1=new JLabel(" INTER OLD PIN::");
l2=new JLabel("  INTER NEW PIN");
l3=new JLabel("  INTER CONFIRM PIN");
Font f=new Font("cursive",Font.BOLD,34);
l4=new JLabel("           RESET PIN");
l4.setFont(f);
l4.setForeground(Color.white);
top.setBackground(Color.black);
top.add(l4);
inter=new JButton("Inter");
inter.addActionListener(this);
tr=new JTextField(20);
tr1=new JTextField(20);
t3=new JTextField(20);
sumbit=new JButton("SUBMIT");
sumbit.addActionListener(this);
bottom.add(inter);
frm.setVisible(true);
 frm.setSize(400,250);
 frm.setLayout(new BorderLayout());
frm.setLocationRelativeTo(null);

center.add(l1);center.add(tr);
center.add(l2);center.add(tr1);
center.add(l3);center.add(t3);
frm.add(BorderLayout.NORTH,top);
frm.add(BorderLayout.CENTER,center);
frm.add(BorderLayout.SOUTH,bottom);
    }
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==inter)
{
    try{
    String sql="select *from account_detail1 where pin_no='"+tr.getText()+"'";
    if(DB_Connect.ExcuteQuery(sql))
    {
if(tr1.getText().equals(t3.getText()))
{
    String sql1="update account_detail1 set pin_no='"+tr1.getText()+"' where pin_no='"+tr.getText()+"'";
    if(DB_Connect.ExcuteUpdate(sql1))
    {
        JOptionPane.showMessageDialog(frm,"PIN RESET SUSSECFULL","information",JOptionPane.INFORMATION_MESSAGE);
        frm.dispose();
        new MainWindow();
    }
}
else
{
    JOptionPane.showMessageDialog(frm,"PIN NOT MATCH","information",JOptionPane.INFORMATION_MESSAGE);

}
    }
    else
    {
        JOptionPane.showMessageDialog(frm,"PLEASE INTER CURRECT PIN","information",JOptionPane.INFORMATION_MESSAGE);

    }
    }
    catch(Exception e2)
    {
System.out.println(e2);
    }
}
    }
    public static void main(String[] args) {
        new Reset();
    }
}