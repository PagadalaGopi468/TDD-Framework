package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Jdbc {

@Test
public void JDBC() throws SQLException
    {
		
		/* Create Driver Class
		 * Register With the driver
		 * Connect with the driver
		 * Create one statement
		 * Write the Query in Execute Update and Execute Query
		 * close the database
		 */
			
		Driver d=new Driver();
		 
		DriverManager.registerDriver(d);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees", "root", "root");
		
		Statement state = con.createStatement();
		
		//state.executeUpdate("create table EmployeesInfo(name varchar(20),age int(20),salary int(25));");
		 //state.executeUpdate("insert into EmployeesInfo values('Gopi',22,20000);");
		 //state.executeUpdate("delete from EmployeesInfo where age=22;");
		 //state.executeUpdate("insert into EmployeesInfo values('Gopi',22,20000);");
		state.executeUpdate("update EmployeesInfo set age=23 where name='Gopi';");
		ResultSet re = state.executeQuery("select * from EmployeesInfo");
		while(re.next())
		{
			System.out.println(re.getString(1)+" "+re.getInt(2)+" "+re.getInt(3));
		}
		System.out.println("table created");
		con.close();
	}
}
