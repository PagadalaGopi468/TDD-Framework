package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Connection {
@Test
	public void jdbc() throws SQLException
	{
		
    Driver d=new Driver();
    
    DriverManager.registerDriver(d);
    
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven", "root", "root");
    
   Statement state = con.createStatement();
  
   int result = state.executeUpdate("update connection set name='Anusha' where empID=456;");
   ResultSet re = state.executeQuery("select * from connection;");
   
   while(re.next())
   {
	   System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getInt(3));
   }
	   System.out.println("passed");
   con.close();

}
}