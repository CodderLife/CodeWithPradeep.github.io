import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class VerifiedPin implements ActionListener{
    JFrame frm;
    JTextField pin;
JButton inter;
JLabel pin1,verify;
JPanel center;
VerifiedPin()
{
   pin=new JTextField(20);
  
   Font f=new Font("Cursive",Font.BOLD,25);
   Font f1=new Font("Cursive",Font.BOLD,35);
   pin1=new JLabel("   Inter pin:");

   verify=new JLabel("    Verifying");
   verify.setFont(f1);
   verify.setForeground(Color.white);

   pin1.setFont(f);
  
  
   center=new JPanel(new GridLayout(1,2));
  
   inter=new JButton("INTER");
   inter.addActionListener(this);
center.add(pin1);center.add(pin);
   inter.setBounds(50, 50, 80, 50);

    frm=new JFrame();
    frm.setLayout(new BorderLayout());
    frm.setSize(400,250);
    
    frm.setLocationRelativeTo(null);
    frm.setVisible(true);
    
    
    frm.add(BorderLayout.NORTH,center);
    frm.add(inter);
   // frm.add(BorderLayout.SOUTH,botom);
   // frm.add(BorderLayout.NORTH,top);
  
}
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==inter)
{
    frm.dispose();
    
    new ATM();

}    
}
    public static void main(String[] args) {
        new VerifiedPin();
    }
}
