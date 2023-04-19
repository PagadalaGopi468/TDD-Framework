package myproject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import GenericUtilities.AddTaskPage;
import GenericUtilities.ExcelUtility;

public class AddTaskTest {
@Test
public void add() throws Exception {
	
	ChromeOptions o=new ChromeOptions();
	o.addArguments("--remote-allow-origins=*");
    WebDriver driver=new ChromeDriver(o);
	
	driver.get("https://demo.actitime.com/login.do");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	AddTaskPage a=new AddTaskPage(driver);
	a.LoginToApp("admin", "manager");
	
	ExcelUtility e=new ExcelUtility();
	String CustomerName = e.ReadData("Sheet1", 2, 0);
	String Description = e.ReadData("Sheet1", 2, 1);

	a.CreateUser(CustomerName, Description);
	System.out.println(CustomerName+" "+Description);
}
}