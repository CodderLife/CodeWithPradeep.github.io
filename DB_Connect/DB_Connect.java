package DB_Connect;
import java.sql.*;

public class DB_Connect {
public static Connection con;
public static Statement stmt;
public static ResultSet rs;
public static Boolean res;
public static int ID;
public static void connect()
{
    try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
stmt=con.createStatement();
    }
    catch(Exception e)
    {
System.out.println(e);
    }
}
public static Boolean ExcuteUpdate(String SQL){
try{
    connect();
int r=stmt.executeUpdate(SQL);
if(r>0)
{
    DB_Connect.res=true;
}
else
{
    DB_Connect.res=false;
}
}
catch(Exception e)
{
System.out.println(e);
}
return res;

}
public static Boolean ExcuteQuery(String SQL){
    try{
        connect();
     rs=stmt.executeQuery(SQL);
    if(rs.next())
    {
        DB_Connect.res=true;
    }
    else
    {
        DB_Connect.res=false;
    }
    }
    catch(Exception e)
    {
    System.out.println(e);
    }
    return res;
    
    }
public static int custmer_id1()
{
   ID=1000;
   return ID;
}
public static int custmer_id()
{
   
   return ID++;
}

    

}