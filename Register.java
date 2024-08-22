import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import DB_Connect.*;
import oracle.sql.DATE;

class Register implements ActionListener {
    JFrame frm;
    JPanel top,center,genderP,qualification,bottom;
    JLabel l1,name,Fname,gender,address,mobile,course,dob;
    JTextField Tname,TFname,Tmobile,Tdob;
    ButtonGroup G1;
    JRadioButton RBmale,RBfemale;
    JTextArea Taddress;
    JComboBox CBcourse;
    
    JButton save,clear,exit;
    Font f;
    int res=0;
    
         Register(){
        frm=new JFrame("Registration Form");
        frm.setSize(550,500);
        top=new JPanel();
        top.setBackground(Color.black);
        center=new JPanel(new GridLayout(7,2,0,10));
        // fnameP=new JPanel();
        bottom=new JPanel();
        bottom.setBackground(Color.cyan );

        save=new JButton("Save");
       //save.addActionListener(this);
        
	exit=new JButton("Exit");
      // exit.addActionListener(this);
	
      
        clear=new JButton("Clear");
       // clear.addActionListener(this);
exit=new JButton("Exit");
       //exit.addActionListener(this);
        l1=new JLabel("Bank Registration Form");
        f=new Font("Monotype Corsiva",Font.ITALIC, 34);
        l1.setFont(f);
        frm.setForeground(Color.green);
        l1.setForeground(Color.white);
        top.add(l1);
        
        name=new JLabel("    Enter Name:");
        Tname=new JTextField(20);

        Fname=new JLabel("    Father Name:");
        TFname=new JTextField(20);

        G1=new ButtonGroup();
        genderP=new JPanel();
        gender=new JLabel("    Select Gender:");
        RBmale=new JRadioButton("Male");
        RBfemale=new JRadioButton("Female");
        G1.add(RBmale);G1.add(RBfemale);
        genderP.add(RBmale);
        genderP.add(RBfemale);

        address=new JLabel("    Enter Address:");
        Taddress=new JTextArea();
        mobile=new JLabel("    Enter Mobile:");
        Tmobile=new JTextField(20);

        course=new JLabel("    A/C Type:");
        String s1[]={"\tSelect A/C Type","Sallary A/C","Fix Deposite","Saving","Current"};
        CBcourse=new JComboBox(s1);
        

        dob=new JLabel("    Enter DOB:");
        Date date=new Date(0);
        Tdob=new JTextField("");
        
      //d(ten);qualification.add(inter);qualification.add(graduate);

        center.add(name);center.add(Tname);center.add(Fname);center.add(TFname);center.add(gender);center.add(genderP);
        center.add(address);center.add(Taddress);center.add(mobile);center.add(Tmobile);center.add(course);
        center.add(CBcourse);center.add(dob);center.add(Tdob);

        bottom.add(save);
      save.addActionListener(this);
        bottom.add(clear);
        clear.addActionListener(this);
	bottom.add(exit);
  exit.addActionListener(this);
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        // frm.setResizable(false);
        frm.setLayout(new BorderLayout());
        frm.add(top ,BorderLayout.NORTH);
        frm.add(center ,BorderLayout.CENTER);
        frm.add(bottom ,BorderLayout.SOUTH);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    int p=0;
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==save)
{
  try{
    String SQL="select MAX(c_id) from REGISTERS";
if(DB_Connect.ExcuteQuery(SQL))
{
 res=DB_Connect.rs.getInt(1);
 res=res+1;
System.out.println(res);
}
   }
   catch(Exception ee)
   {
System.out.println(ee);
   }

  try{
  String gen;
  frm.dispose();
  if(RBfemale.isSelected()==true)
  {
   
  gen="female";
  }
  else
  {
    gen="male";
  }
  String sql="insert into Registers values("+res+",'"+Tname.getText()+"','"+TFname.getText()+"','"+gen+"','"+Taddress.getText()+"','"+Tmobile.getText()+"','"+CBcourse.getSelectedItem()+"','"+Tdob.getText()+"')";
  System.out.println(sql);
  if(DB_Connect.ExcuteUpdate(sql))
  {
    new Ragister1();
  }
  else
  {
    System.out.println("Some problum");
  }
}
catch(Exception e1)
{
System.out.println(e1);
}

}
if(e.getSource()==exit)
{
  frm.dispose();
}
    }
public static void main(String[] args) {
    new Register();
}
}
