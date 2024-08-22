import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Register2 implements ActionListener {
    JFrame frm;
    JCheckBox Saving,Family,Current,SallaryAccount,BussinessAccount,FixedDeposite; 
    JPanel top,center,center1,temp,bottom,p1;
    JLabel type,service;
    JCheckBox ATM,NetBacking,Chackbook,Other;
    JButton sumbit,cancel;
    Register2()
    {
        frm=new JFrame();
        frm.setBackground(Color.BLUE);
        type=new JLabel("                  Type of Account");
       Font f=new Font("Cursive",Font.BOLD,30);
       type.setFont(f);
       type.setForeground(Color.white);
       
       sumbit=new JButton("Sumbit");
       sumbit.addActionListener(this);
       cancel=new JButton("Cancel");
       cancel.addActionListener(this);
        service=new JLabel("      Services");
        center=new JPanel(new GridLayout(3,2)); 
        center1=new JPanel(new GridLayout(2,2));
        temp=new JPanel(new GridLayout(2,1));
        top=new JPanel(new GridLayout(1,1));
       top.setBackground(Color.black);
        bottom=new JPanel();
        bottom.setBackground(Color.cyan);
        p1=new JPanel(new GridLayout(1,1));
        service.setBounds(150, 150, 5, 5);
  Saving=new JCheckBox("Saving A/C");
  BussinessAccount=new JCheckBox("Current A/C");
  Family=new JCheckBox("Sallary A/C");
Current=new JCheckBox("Bussiness A/C");
  FixedDeposite=new JCheckBox("FixedDeposite A/C");
  SallaryAccount=new JCheckBox("FixedDeposite A/C");
  ButtonGroup g1=new ButtonGroup();
  g1.add(Saving);g1.add(BussinessAccount);g1.add(Family);
  g1.add(Current);g1.add(FixedDeposite);g1.add(SallaryAccount);
  ATM=new JCheckBox("ATM");
  NetBacking=new JCheckBox("NetBacking");
  Chackbook=new JCheckBox(" Chackbook");
  Other=new JCheckBox("Other");  
//center.add(type);
  center.add(SallaryAccount);
  center.add(Saving);
  center.add(Current);
  center.add(BussinessAccount);
  center.add(Family);
  center.add(FixedDeposite);
  
  center1.add(ATM);
  center1.add(NetBacking);
  center1.add(Chackbook);
  center1.add(Other);
  frm.setSize(500,500);
  frm.setVisible(true);
  frm.setLocationRelativeTo(null);
frm.setLayout(new BorderLayout());
top.add(type);
bottom.add(sumbit);bottom.add(cancel);
temp.add(center);temp.add(center1);
frm.add(BorderLayout.CENTER,temp);

frm.add(BorderLayout.NORTH,top);
frm.add(BorderLayout.SOUTH,bottom);

    
    }
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==sumbit)
{
 
  try{
    
    Thread.sleep(2000);
    frm.dispose();
new Account_Detail();
  }catch(Exception e2)
  {
System.out.println(e2);
  }
}
if(e.getSource()==cancel)
{
//frm.dispose();
    }
  }    
    public static void main(String[] args) {
        new Register2();
    }
}
