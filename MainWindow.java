import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
//import java.awt.event.*;
import javax.swing.*;

public class MainWindow implements ActionListener{
    JFrame frm;
    JLabel head,image;
JPanel top;
JButton ATM,ATM1,ATM2,ATM3,ATM4,ATM5;
Font f;    
    MainWindow()
    {
frm=new JFrame();
f=new Font("Cursive",Font.BOLD,50);
head=new JLabel("                 WELCOME IN CHOTA BANK");
head.setForeground(Color.white);
head.setFont(f);
top=new JPanel(new GridLayout(1,1));
image=new JLabel(new ImageIcon("bankjpg.jpeg"));
image.setBounds(200, 200, 500, 500);
top.setBackground(Color.black);
top.add(head);
f=new Font("Cursive",Font.BOLD,25);
ATM=new JButton("ATM Trangections");
ATM.addActionListener(this);
ATM.setBackground(Color.black);
ATM.setForeground(Color.white);
ATM.setBounds(800, 400, 300, 50);
ATM1=new JButton("CASH WITHDROL ");
ATM1.setBackground(Color.black);
ATM1.setForeground(Color.white);
ATM1.setBounds(800, 500, 300, 50);
ATM2=new JButton("CASH DEPOSITE");
ATM2.addActionListener(this);
ATM2.setBackground(Color.black);
ATM2.setForeground(Color.white);
ATM2.setBounds(800, 600, 300, 50);
ATM.setFont(f);
ATM1.setFont(f);
ATM2.setFont(f);
ATM3=new JButton("Reset Pin");
ATM3.setBackground(Color.black);
ATM3.setForeground(Color.white);
ATM3.setBounds(0, 400, 300, 50);
ATM4=new JButton("EXIT");
ATM4.addActionListener(this);
ATM4.setBackground(Color.black);
ATM4.setForeground(Color.white);
ATM4.setBounds(0, 500, 300, 50);
ATM5=new JButton("CHAKE BALENCE ");
ATM5.addActionListener(this);
ATM5.setBackground(Color.black);
ATM5.setForeground(Color.white);
ATM5.setBounds(0, 600, 300, 50);
ATM3.setFont(f);
ATM4.setFont(f);
ATM5.setFont(f);
frm.setSize(1100,700);
frm.setVisible(true);
frm.setLocationRelativeTo(null);
frm.setLayout(new BorderLayout());
frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
frm.add(BorderLayout.NORTH,top);
frm.add(ATM1);
frm.add(ATM2);
frm.add(ATM);
frm.add(ATM3);
frm.add(ATM4);
frm.add(ATM5);
frm.add(image);
    }
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==ATM)
{
    new ATM();
}
if(e.getSource()==ATM2)
{
    new CashDeposite();
}
if(e.getSource()==ATM5)
{
    new ChakeBallence();
}
if(e.getSource()==ATM4)
{
    frm.dispose();
}
if(e.getSource()==ATM3)
{
    new Reset();
}
}
    
    public static void main(String[] args) {
        new MainWindow();
    }
}
