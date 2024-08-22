import DB_Connect.*;
import java.io.*;
import java.util.Scanner;
public class demo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("inter name sallery");
        String name=sc.nextLine();
        int sallery=sc.nextInt();
        String sql="insert into pradeep values('"+name+"',"+sallery+")";
       DB_Connect.ExcuteUpdate(sql);
       if(DB_Connect.res) 
       {
        System.out.println("record saved");
       }
       else{
        System.out.println("some error");
       }

    }
}
