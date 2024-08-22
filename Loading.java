import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Loading{
JFrame frm2;
JProgressBar pb;
JLabel image;
Loading()
{
frm2=new JFrame("Splash Screen");
pb=new JProgressBar(0,100);
image=new JLabel(new ImageIcon("image\\a.png"));
image.setBounds(0,0,576,282);
pb.setBounds(5,270,560,20);
pb.setStringPainted(true);
pb.setValue(0);
pb.setBackground(Color.red);
frm2.setUndecorated(true);
frm2.setSize(576,20);
frm2.setLocationRelativeTo(null);
frm2.setLayout(null);
frm2.setVisible(true);
frm2.add(pb);
frm2.add(image);
progress();

}
public void progress()
{
try{
int i=0;
while(i<=100)
{
pb.setValue(i);
i=i+2;
Thread.sleep(200);
}
}catch(Exception e)
{
System.out.println(e);
}
frm2.dispose();

}
public static void main(String args[])
{
new Loading();


}
}