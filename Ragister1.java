import DB_Connect.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Ragister1 implements ActionListener{
JFrame frm;
JPanel top,center,bottom,temp1,temp2;
 JComboBox Religion,Category,Income,qualification,Occupation;
 
 JLabel Religion1,Category1,Income1,qualification1,Occupation1,pan1,adhar1;
 JTextField pan,adhar;
 JCheckBox citizen,exiting1,ch1,ch2;
JLabel sinior ,exiting ,l1;
JButton Next,btn2;


      Ragister1(){
        
        
        frm=new JFrame();
        frm.setBackground(Color.orange);
        top=new JPanel(new GridLayout(1,1,5,5));
        center=new JPanel(new GridLayout(9,2,5,5));
        bottom=new JPanel();
        temp1=new JPanel(new GridLayout(1,2));
        temp2=new JPanel(new GridLayout(1,2));
        Next=new JButton("Next");
        Next.addActionListener(this);
        btn2=new JButton("Clear");
        btn2.addActionListener(this);
        Font f=new Font("Monotype Corsiva",Font.ITALIC, 34);
        Font f1=new Font("Cursive",Font.BOLD, 20);
        l1=new JLabel("           Page no:2 Regitration");
        l1.setFont(f);
        l1.setForeground(Color.white);
        top.setBackground(Color.black);
        pan=new JTextField(20);
        adhar=new JTextField(20);  
        citizen=new JCheckBox("yes");  
        ch1=new JCheckBox("No");  
        
       
        exiting1=new JCheckBox("yes");    
        ch2=new JCheckBox("No");  
        ButtonGroup g1=new ButtonGroup();
        ButtonGroup g2=new ButtonGroup();
        g1.add(ch1); g1.add(citizen);
        g2.add(exiting1);g2.add(ch2); 
        temp1.add(citizen);  temp1.add(ch1); 
        temp2.add(exiting1);temp2.add(ch2);
        pan1=new JLabel("    Pan Card;");
        adhar1=new JLabel("  Adhar Card;");
           String fill[]={"Hindu","muslim","Cristen","other"};
	Religion=new JComboBox(fill);
    //Religion.addItem(fill);
    String fill1[]={"OBC","GEN","SC","ST",};
    Category=new JComboBox(fill1);
    //Category.addItem(fill1);
    String fill2[]={">50000",">10000",">20000",">300000"};
    Income=new JComboBox(fill2);
    //Income.addItem(fill2);
   
    String fill3[]={"10TH","12TH","Graduation","Post-Graduation"};
    qualification=new JComboBox(fill3);
  //  qualification.addItem(fill3);

    String fill4[]={"FARMAR","GOVT SERVICE","BUSSINESS","OTHER"};
    Occupation=new JComboBox(fill4);
   // Occupation.addItem(fill4);
    Religion1=new JLabel("  Religion:");
    Religion1.setFont(f1);
    Category1=new JLabel("  Category:");
    Category1.setFont(f1);
    qualification1=new JLabel("  qualification:");
    qualification1.setFont(f1);
    Occupation1=new JLabel("  Occupation:");
    Occupation1.setFont(f1);
    Income1=new JLabel("  Income:");
    Income1.setFont(f1);
    sinior=new JLabel("   Sinior Citizen:");
    sinior.setFont(f1);
    exiting=new JLabel("  Exiting A/C:");
    exiting.setFont(f1);
    pan1.setFont(f1);
    adhar1.setFont(f1);
    center.add(Religion1);center.add(Religion);
    center.add(Income1);center.add(Income);
    center.add( Category1);center.add( Category);
    center.add(qualification1);center.add(qualification);
    center.add( Occupation1);center.add( Occupation);
    center.add( pan1);center.add( pan);
    center.add( adhar1);center.add( adhar);
    center.add( sinior);center.add( temp1);
    center.add( exiting);center.add( temp2);
top.add(l1);
bottom.add(Next);bottom.add(btn2);
bottom.setBackground(Color.cyan);
       
        frm.setSize(500,500);
        frm.setResizable(false);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        // frm.setResizable(false);
        frm.setLayout(new BorderLayout());
        frm.add(top ,BorderLayout.NORTH);
        frm.add(center ,BorderLayout.CENTER);
        frm.add(bottom ,BorderLayout.SOUTH);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(BorderLayout.NORTH,top);
        frm.add(BorderLayout.CENTER,center);
        frm.add(BorderLayout.SOUTH,bottom);
    
    
    }
    int res=0;
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==Next)
{
    String chake;
frm.dispose();
if(citizen.isSelected()==true)
{
chake="Yes";
}
else
{
    chake="No";
}
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

String str="insert into ragister11 values("+res+",'"+Religion.getSelectedItem()+"','"+Income.getSelectedItem()+"','"+Category.getSelectedItem()+"','"+qualification.getSelectedItem()+"','"+Occupation.getSelectedItem()+"','"+pan.getText()+"','"+adhar.getText()+"','"+chake+"','"+chake+"')";
System.out.println(str);
DB_Connect.res=DB_Connect.ExcuteUpdate(str);
System.out.println(DB_Connect.res);
try{
if(DB_Connect.res==true)
{
    new Register2();
}
else
{
    System.out.println("SOME PROBLUM");
}
}
catch(Exception e1)
{
System.out.println(e1);
}
    }
}
public static void main(String[] args) {
   
    new Ragister1();
}
}
